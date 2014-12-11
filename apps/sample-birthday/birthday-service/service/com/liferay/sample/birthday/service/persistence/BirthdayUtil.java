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

package com.liferay.sample.birthday.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.sample.birthday.model.Birthday;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the birthday service. This utility wraps {@link BirthdayPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see BirthdayPersistence
 * @see BirthdayPersistenceImpl
 * @generated
 */
@ProviderType
public class BirthdayUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Birthday birthday) {
		getPersistence().clearCache(birthday);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Birthday> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Birthday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Birthday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Birthday> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Birthday update(Birthday birthday) {
		return getPersistence().update(birthday);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Birthday update(Birthday birthday,
		ServiceContext serviceContext) {
		return getPersistence().update(birthday, serviceContext);
	}

	/**
	* Caches the birthday in the entity cache if it is enabled.
	*
	* @param birthday the birthday
	*/
	public static void cacheResult(
		com.liferay.sample.birthday.model.Birthday birthday) {
		getPersistence().cacheResult(birthday);
	}

	/**
	* Caches the birthdaies in the entity cache if it is enabled.
	*
	* @param birthdaies the birthdaies
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sample.birthday.model.Birthday> birthdaies) {
		getPersistence().cacheResult(birthdaies);
	}

	/**
	* Creates a new birthday with the primary key. Does not add the birthday to the database.
	*
	* @param birthdayId the primary key for the new birthday
	* @return the new birthday
	*/
	public static com.liferay.sample.birthday.model.Birthday create(
		long birthdayId) {
		return getPersistence().create(birthdayId);
	}

	/**
	* Removes the birthday with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday that was removed
	* @throws com.liferay.sample.birthday.NoSuchBirthdayException if a birthday with the primary key could not be found
	*/
	public static com.liferay.sample.birthday.model.Birthday remove(
		long birthdayId)
		throws com.liferay.sample.birthday.exception.NoSuchBirthdayException {
		return getPersistence().remove(birthdayId);
	}

	public static com.liferay.sample.birthday.model.Birthday updateImpl(
		com.liferay.sample.birthday.model.Birthday birthday) {
		return getPersistence().updateImpl(birthday);
	}

	/**
	* Returns the birthday with the primary key or throws a {@link com.liferay.sample.birthday.NoSuchBirthdayException} if it could not be found.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday
	* @throws com.liferay.sample.birthday.NoSuchBirthdayException if a birthday with the primary key could not be found
	*/
	public static com.liferay.sample.birthday.model.Birthday findByPrimaryKey(
		long birthdayId)
		throws com.liferay.sample.birthday.exception.NoSuchBirthdayException {
		return getPersistence().findByPrimaryKey(birthdayId);
	}

	/**
	* Returns the birthday with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param birthdayId the primary key of the birthday
	* @return the birthday, or <code>null</code> if a birthday with the primary key could not be found
	*/
	public static com.liferay.sample.birthday.model.Birthday fetchByPrimaryKey(
		long birthdayId) {
		return getPersistence().fetchByPrimaryKey(birthdayId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.sample.birthday.model.Birthday> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the birthdaies.
	*
	* @return the birthdaies
	*/
	public static java.util.List<com.liferay.sample.birthday.model.Birthday> findAll() {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.sample.birthday.model.Birthday> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the birthdaies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.birthday.model.impl.BirthdayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of birthdaies
	* @param end the upper bound of the range of birthdaies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of birthdaies
	*/
	public static java.util.List<com.liferay.sample.birthday.model.Birthday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.sample.birthday.model.Birthday> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the birthdaies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of birthdaies.
	*
	* @return the number of birthdaies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BirthdayPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(BirthdayPersistence persistence) {
	}

	private static ServiceTracker<BirthdayPersistence, BirthdayPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BirthdayUtil.class);

		_serviceTracker = new ServiceTracker<BirthdayPersistence, BirthdayPersistence>(bundle.getBundleContext(),
				BirthdayPersistence.class, null);

		_serviceTracker.open();
	}
}