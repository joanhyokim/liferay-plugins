/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.sample.birthday.web.portlet;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.sample.birthday.model.Birthday;
import com.liferay.sample.birthday.service.BirthdayLocalService;

import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Ryan Park
 * @author Joan Kim
*/
public class BirthdayPortlet extends MVCPortlet {

	public void addBirthday(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String name = ParamUtil.getString(actionRequest, "name");

		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayMonth = ParamUtil.getInteger(
			actionRequest, "birthdayMonth");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");

		Calendar calendar = CalendarFactoryUtil.getCalendar(
			themeDisplay.getTimeZone(), themeDisplay.getLocale());

		calendar.set(Calendar.YEAR, birthdayYear);
		calendar.set(Calendar.MONTH, birthdayMonth);
		calendar.set(Calendar.DATE, birthdayDay);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		_birthdayLocalService.addBirthday(name, calendar.getTime());
	}

	@Override
	public void init() throws PortletException {
		super.init();

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_birthdayLocalService = ServiceTrackerUtil.getService(
			BirthdayLocalService.class, bundle.getBundleContext());
	}

	protected void populateContext(
			PortletRequest portletRequest, PortletResponse portletResponse,
			Template template)
		throws Exception {

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put("birthdayClass", Birthday.class);

		List<Birthday> birthdays = _birthdayLocalService.getBirthdaies(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		template.put("birthdays", birthdays);

		int birthdaysCount = _birthdayLocalService.getBirthdaiesCount();

		template.put("birthdaysCount", birthdaysCount);

		PortletSession portletSession = portletRequest.getPortletSession();
	}

	private BirthdayLocalService _birthdayLocalService;

}