/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pluginsecuritymanager.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;

import java.lang.Class;
import java.lang.ClassLoader;
import java.lang.Exception;
import java.lang.Object;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.PortletPreferences;

/**
 * @author Shinn Lok
 * @author Brian Wing Shun Chan
 */
public class PluginSecurityManagerUtil {

	public static JSONArray getPACLPoliciesJSONArray() throws Exception {
		Map<String, JSONObject> sortedPACLPolicies =
			new TreeMap<String, JSONObject>();

		Map<ClassLoader, Object> paclPolicies = _getPACLPolicies();

		for (Map.Entry<ClassLoader, Object> entry : paclPolicies.entrySet()) {
			Object value = entry.getValue();

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				JSONFactoryUtil.serialize(value));

			String servletContextName = jsonObject.getString(
				"servletContextName");

			sortedPACLPolicies.put(servletContextName, jsonObject);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Map.Entry<String, JSONObject> entry :
				sortedPACLPolicies.entrySet()) {

			JSONObject jsonObject = entry.getValue();

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	public static PortletPreferences getPreferences() throws SystemException {
		return PortletPreferencesLocalServiceUtil.getPreferences(
			CompanyConstants.SYSTEM, CompanyConstants.SYSTEM,
			PortletKeys.PREFS_OWNER_TYPE_COMPANY, PortletKeys.PREFS_PLID_SHARED,
			PortletKeys.PLUGIN_SECURITY_MANAGER);
	}

	public static boolean isAllowed() throws SystemException {
		PortletPreferences preferences = getPreferences();

		return GetterUtil.getBoolean(
			preferences.getValue(
				PortletPropsKeys.PLUGIN_SECURITY_MANAGER_ALLOWED,
				String.valueOf(Boolean.TRUE)));
	}

	public static boolean isPACLActive() throws Exception {
		if (_paclPolicyIsActiveMethod == null) {
			Class<?> clazz = _getPACLPolicyManagerClass();

			_paclPolicyIsActiveMethod = clazz.getMethod("isActive");
		}

		return (Boolean)_paclPolicyIsActiveMethod.invoke(null);
	}

	public static void togglePACL() throws Exception {
		boolean enabled = isAllowed();
		boolean paclActive = isPACLActive();

		if (!enabled && paclActive) {
			_deactivatePACL();
		}
		else if (enabled && !paclActive) {
			_activatePACL();
		}
	}

	private static void _activatePACL() throws Exception {
		Map<ClassLoader, Object> paclPolicies = _cachedPaclPolicies;

		for (Map.Entry<ClassLoader, Object> paclPolicy :
				paclPolicies.entrySet()) {

			if (_paclPolicyManagerRegisterMethod == null) {
				Class<?> clazz = _getPACLPolicyManagerClass();

				_paclPolicyManagerRegisterMethod = clazz.getMethod(
					"register", ClassLoader.class, _getPACLPolicyClass());
			}

			_paclPolicyManagerRegisterMethod.invoke(
				null, paclPolicy.getKey(), paclPolicy.getValue());
		}

		_cachedPaclPolicies.clear();
	}

	private static void _deactivatePACL() throws Exception {
		Map<ClassLoader, Object> paclPolicies = _getPACLPolicies();

		for (ClassLoader classLoader : paclPolicies.keySet()) {
			if (_paclPolicyManagerUnregisterMethod == null) {
				Class<?> clazz = _getPACLPolicyManagerClass();

				_paclPolicyManagerUnregisterMethod = clazz.getMethod(
					"unregister", ClassLoader.class);
			}

			_paclPolicyManagerUnregisterMethod.invoke(null, classLoader);

			_cachedPaclPolicies.clear();

			_cachedPaclPolicies.putAll(paclPolicies);
		}
	}

	private static Map<ClassLoader, Object> _getPACLPolicies()
		throws Exception {

		if (_referencedPaclPolicies == null) {
			Class<?> clazz = _getPACLPolicyManagerClass();

			Field field = clazz.getDeclaredField("_paclPolicies");

			field.setAccessible(true);

			_referencedPaclPolicies = (Map<ClassLoader, Object>)field.get(
				clazz);
		}

		return new HashMap<ClassLoader, Object>(_referencedPaclPolicies);
	}

	private static Class<?> _getPACLPolicyClass() throws Exception {
		ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();

		return classLoader.loadClass(
			"com.liferay.portal.security.pacl.PACLPolicy");
	}

	private static Class<?> _getPACLPolicyManagerClass() throws Exception {
		ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();

		return classLoader.loadClass(
			"com.liferay.portal.security.pacl.PACLPolicyManager");
	}

	private static Map<ClassLoader, Object> _cachedPaclPolicies =
		new HashMap<ClassLoader, Object>();

	private static Method _paclPolicyIsActiveMethod;
	private static Method _paclPolicyManagerRegisterMethod;
	private static Method _paclPolicyManagerUnregisterMethod;
	private static Map<ClassLoader, Object> _referencedPaclPolicies;

}