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

package com.liferay.sample.birthday.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Birthday. This utility wraps
 * {@link com.liferay.sample.birthday.service.impl.BirthdayLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ryan Park
 * @see BirthdayLocalService
 * @see com.liferay.sample.birthday.service.base.BirthdayLocalServiceBaseImpl
 * @see com.liferay.sample.birthday.service.impl.BirthdayLocalServiceImpl
 * @generated
 */
@ProviderType
public class BirthdayLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.sample.birthday.service.impl.BirthdayLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the birthday to the database. Also notifies the appropriate model listeners.
	*
	* @param birthday the birthday
	* @return the birthday that was added
	*/
	public static com.liferay.sample.birthday.model.Birthday addBirthday(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return getService().addBirthday(birthday);
	}

	public static com.liferay.sample.birthday.model.Birthday addBirthday(
		java.lang.String name, java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addBirthday(name, date);
	}

	/**
	* Creates a new birthday with the primary key. Does not add the birthday to the database.
	*
	* @param birthdayId the primary key for the new birthday
	* @return the new birthday
	*/
	public static com.liferay.sample.birthday.model.Birthday createBirthday(
		long birthdayId) {
		return getService().createBirthday(birthdayId);
	}

	/**
	* Deletes the birthday from the database. Also notifies the appropriate model listeners.
	*
	* @param birthday the birthday
	* @return the birthday that was removed
	*/
	public static com.liferay.sample.birthday.model.Birthday deleteBirthday(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return getService().deleteBirthday(birthday);
	}

	/**
	* Deletes the birthday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday that was removed
	* @throws PortalException if a birthday with the primary key could not be found
	*/
	public static com.liferay.sample.birthday.model.Birthday deleteBirthday(
		long birthdayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBirthday(birthdayId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.birthday.model.impl.BirthdayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.birthday.model.impl.BirthdayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.sample.birthday.model.Birthday fetchBirthday(
		long birthdayId) {
		return getService().fetchBirthday(birthdayId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Returns a range of all the birthdaies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.birthday.model.impl.BirthdayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of birthdaies
	* @param end the upper bound of the range of birthdaies (not inclusive)
	* @return the range of birthdaies
	*/
	public static java.util.List<com.liferay.sample.birthday.model.Birthday> getBirthdaies(
		int start, int end) {
		return getService().getBirthdaies(start, end);
	}

	/**
	* Returns the number of birthdaies.
	*
	* @return the number of birthdaies
	*/
	public static int getBirthdaiesCount() {
		return getService().getBirthdaiesCount();
	}

	/**
	* Returns the birthday with the primary key.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday
	* @throws PortalException if a birthday with the primary key could not be found
	*/
	public static com.liferay.sample.birthday.model.Birthday getBirthday(
		long birthdayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBirthday(birthdayId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the birthday in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param birthday the birthday
	* @return the birthday that was updated
	*/
	public static com.liferay.sample.birthday.model.Birthday updateBirthday(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return getService().updateBirthday(birthday);
	}

	public static BirthdayLocalService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(BirthdayLocalService service) {
	}

	private static ServiceTracker<BirthdayLocalService, BirthdayLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BirthdayLocalServiceUtil.class);

		_serviceTracker = new ServiceTracker<BirthdayLocalService, BirthdayLocalService>(bundle.getBundleContext(),
				BirthdayLocalService.class, null);

		_serviceTracker.open();
	}
}