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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BirthdayLocalService}.
 *
 * @author Ryan Park
 * @see BirthdayLocalService
 * @generated
 */
@ProviderType
public class BirthdayLocalServiceWrapper implements BirthdayLocalService,
	ServiceWrapper<BirthdayLocalService> {
	public BirthdayLocalServiceWrapper(
		BirthdayLocalService birthdayLocalService) {
		_birthdayLocalService = birthdayLocalService;
	}

	/**
	* Adds the birthday to the database. Also notifies the appropriate model listeners.
	*
	* @param birthday the birthday
	* @return the birthday that was added
	*/
	@Override
	public com.liferay.sample.birthday.model.Birthday addBirthday(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return _birthdayLocalService.addBirthday(birthday);
	}

	@Override
	public com.liferay.sample.birthday.model.Birthday addBirthday(
		java.lang.String name, java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _birthdayLocalService.addBirthday(name, date);
	}

	/**
	* Creates a new birthday with the primary key. Does not add the birthday to the database.
	*
	* @param birthdayId the primary key for the new birthday
	* @return the new birthday
	*/
	@Override
	public com.liferay.sample.birthday.model.Birthday createBirthday(
		long birthdayId) {
		return _birthdayLocalService.createBirthday(birthdayId);
	}

	/**
	* Deletes the birthday from the database. Also notifies the appropriate model listeners.
	*
	* @param birthday the birthday
	* @return the birthday that was removed
	*/
	@Override
	public com.liferay.sample.birthday.model.Birthday deleteBirthday(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return _birthdayLocalService.deleteBirthday(birthday);
	}

	/**
	* Deletes the birthday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday that was removed
	* @throws PortalException if a birthday with the primary key could not be found
	*/
	@Override
	public com.liferay.sample.birthday.model.Birthday deleteBirthday(
		long birthdayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _birthdayLocalService.deleteBirthday(birthdayId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _birthdayLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _birthdayLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _birthdayLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _birthdayLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _birthdayLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _birthdayLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _birthdayLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.sample.birthday.model.Birthday fetchBirthday(
		long birthdayId) {
		return _birthdayLocalService.fetchBirthday(birthdayId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _birthdayLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _birthdayLocalService.getBeanIdentifier();
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
	@Override
	public java.util.List<com.liferay.sample.birthday.model.Birthday> getBirthdaies(
		int start, int end) {
		return _birthdayLocalService.getBirthdaies(start, end);
	}

	/**
	* Returns the number of birthdaies.
	*
	* @return the number of birthdaies
	*/
	@Override
	public int getBirthdaiesCount() {
		return _birthdayLocalService.getBirthdaiesCount();
	}

	/**
	* Returns the birthday with the primary key.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday
	* @throws PortalException if a birthday with the primary key could not be found
	*/
	@Override
	public com.liferay.sample.birthday.model.Birthday getBirthday(
		long birthdayId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _birthdayLocalService.getBirthday(birthdayId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _birthdayLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_birthdayLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the birthday in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param birthday the birthday
	* @return the birthday that was updated
	*/
	@Override
	public com.liferay.sample.birthday.model.Birthday updateBirthday(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return _birthdayLocalService.updateBirthday(birthday);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public BirthdayLocalService getWrappedBirthdayLocalService() {
		return _birthdayLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedBirthdayLocalService(
		BirthdayLocalService birthdayLocalService) {
		_birthdayLocalService = birthdayLocalService;
	}

	@Override
	public BirthdayLocalService getWrappedService() {
		return _birthdayLocalService;
	}

	@Override
	public void setWrappedService(BirthdayLocalService birthdayLocalService) {
		_birthdayLocalService = birthdayLocalService;
	}

	private BirthdayLocalService _birthdayLocalService;
}