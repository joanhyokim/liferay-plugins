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

package com.liferay.sample.birthday.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.sample.birthday.exception.NoSuchBirthdayException;
import com.liferay.sample.birthday.model.Birthday;
import com.liferay.sample.birthday.model.impl.BirthdayImpl;
import com.liferay.sample.birthday.model.impl.BirthdayModelImpl;
import com.liferay.sample.birthday.service.persistence.BirthdayPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the birthday service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ryan Park
 * @see BirthdayPersistence
 * @see BirthdayUtil
 * @generated
 */
@ProviderType
public class BirthdayPersistenceImpl extends BasePersistenceImpl<Birthday>
	implements BirthdayPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BirthdayUtil} to access the birthday persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BirthdayImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
			BirthdayModelImpl.FINDER_CACHE_ENABLED, BirthdayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
			BirthdayModelImpl.FINDER_CACHE_ENABLED, BirthdayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
			BirthdayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BirthdayPersistenceImpl() {
		setModelClass(Birthday.class);
	}

	/**
	 * Caches the birthday in the entity cache if it is enabled.
	 *
	 * @param birthday the birthday
	 */
	@Override
	public void cacheResult(Birthday birthday) {
		EntityCacheUtil.putResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
			BirthdayImpl.class, birthday.getPrimaryKey(), birthday);

		birthday.resetOriginalValues();
	}

	/**
	 * Caches the birthdaies in the entity cache if it is enabled.
	 *
	 * @param birthdaies the birthdaies
	 */
	@Override
	public void cacheResult(List<Birthday> birthdaies) {
		for (Birthday birthday : birthdaies) {
			if (EntityCacheUtil.getResult(
						BirthdayModelImpl.ENTITY_CACHE_ENABLED,
						BirthdayImpl.class, birthday.getPrimaryKey()) == null) {
				cacheResult(birthday);
			}
			else {
				birthday.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all birthdaies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BirthdayImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BirthdayImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the birthday.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Birthday birthday) {
		EntityCacheUtil.removeResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
			BirthdayImpl.class, birthday.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Birthday> birthdaies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Birthday birthday : birthdaies) {
			EntityCacheUtil.removeResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
				BirthdayImpl.class, birthday.getPrimaryKey());
		}
	}

	/**
	 * Creates a new birthday with the primary key. Does not add the birthday to the database.
	 *
	 * @param birthdayId the primary key for the new birthday
	 * @return the new birthday
	 */
	@Override
	public Birthday create(long birthdayId) {
		Birthday birthday = new BirthdayImpl();

		birthday.setNew(true);
		birthday.setPrimaryKey(birthdayId);

		return birthday;
	}

	/**
	 * Removes the birthday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param birthdayId the primary key of the birthday
	 * @return the birthday that was removed
	 * @throws com.liferay.sample.birthday.NoSuchBirthdayException if a birthday with the primary key could not be found
	 */
	@Override
	public Birthday remove(long birthdayId) throws NoSuchBirthdayException {
		return remove((Serializable)birthdayId);
	}

	/**
	 * Removes the birthday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the birthday
	 * @return the birthday that was removed
	 * @throws com.liferay.sample.birthday.NoSuchBirthdayException if a birthday with the primary key could not be found
	 */
	@Override
	public Birthday remove(Serializable primaryKey)
		throws NoSuchBirthdayException {
		Session session = null;

		try {
			session = openSession();

			Birthday birthday = (Birthday)session.get(BirthdayImpl.class,
					primaryKey);

			if (birthday == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBirthdayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(birthday);
		}
		catch (NoSuchBirthdayException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Birthday removeImpl(Birthday birthday) {
		birthday = toUnwrappedModel(birthday);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(birthday)) {
				birthday = (Birthday)session.get(BirthdayImpl.class,
						birthday.getPrimaryKeyObj());
			}

			if (birthday != null) {
				session.delete(birthday);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (birthday != null) {
			clearCache(birthday);
		}

		return birthday;
	}

	@Override
	public Birthday updateImpl(
		com.liferay.sample.birthday.model.Birthday birthday) {
		birthday = toUnwrappedModel(birthday);

		boolean isNew = birthday.isNew();

		Session session = null;

		try {
			session = openSession();

			if (birthday.isNew()) {
				session.save(birthday);

				birthday.setNew(false);
			}
			else {
				session.merge(birthday);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
			BirthdayImpl.class, birthday.getPrimaryKey(), birthday, false);

		birthday.resetOriginalValues();

		return birthday;
	}

	protected Birthday toUnwrappedModel(Birthday birthday) {
		if (birthday instanceof BirthdayImpl) {
			return birthday;
		}

		BirthdayImpl birthdayImpl = new BirthdayImpl();

		birthdayImpl.setNew(birthday.isNew());
		birthdayImpl.setPrimaryKey(birthday.getPrimaryKey());

		birthdayImpl.setBirthdayId(birthday.getBirthdayId());
		birthdayImpl.setName(birthday.getName());
		birthdayImpl.setDate(birthday.getDate());

		return birthdayImpl;
	}

	/**
	 * Returns the birthday with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the birthday
	 * @return the birthday
	 * @throws com.liferay.sample.birthday.NoSuchBirthdayException if a birthday with the primary key could not be found
	 */
	@Override
	public Birthday findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBirthdayException {
		Birthday birthday = fetchByPrimaryKey(primaryKey);

		if (birthday == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBirthdayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return birthday;
	}

	/**
	 * Returns the birthday with the primary key or throws a {@link com.liferay.sample.birthday.NoSuchBirthdayException} if it could not be found.
	 *
	 * @param birthdayId the primary key of the birthday
	 * @return the birthday
	 * @throws com.liferay.sample.birthday.NoSuchBirthdayException if a birthday with the primary key could not be found
	 */
	@Override
	public Birthday findByPrimaryKey(long birthdayId)
		throws NoSuchBirthdayException {
		return findByPrimaryKey((Serializable)birthdayId);
	}

	/**
	 * Returns the birthday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the birthday
	 * @return the birthday, or <code>null</code> if a birthday with the primary key could not be found
	 */
	@Override
	public Birthday fetchByPrimaryKey(Serializable primaryKey) {
		Birthday birthday = (Birthday)EntityCacheUtil.getResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
				BirthdayImpl.class, primaryKey);

		if (birthday == _nullBirthday) {
			return null;
		}

		if (birthday == null) {
			Session session = null;

			try {
				session = openSession();

				birthday = (Birthday)session.get(BirthdayImpl.class, primaryKey);

				if (birthday != null) {
					cacheResult(birthday);
				}
				else {
					EntityCacheUtil.putResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
						BirthdayImpl.class, primaryKey, _nullBirthday);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
					BirthdayImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return birthday;
	}

	/**
	 * Returns the birthday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param birthdayId the primary key of the birthday
	 * @return the birthday, or <code>null</code> if a birthday with the primary key could not be found
	 */
	@Override
	public Birthday fetchByPrimaryKey(long birthdayId) {
		return fetchByPrimaryKey((Serializable)birthdayId);
	}

	@Override
	public Map<Serializable, Birthday> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Birthday> map = new HashMap<Serializable, Birthday>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Birthday birthday = fetchByPrimaryKey(primaryKey);

			if (birthday != null) {
				map.put(primaryKey, birthday);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Birthday birthday = (Birthday)EntityCacheUtil.getResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
					BirthdayImpl.class, primaryKey);

			if (birthday == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, birthday);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BIRTHDAY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Birthday birthday : (List<Birthday>)q.list()) {
				map.put(birthday.getPrimaryKeyObj(), birthday);

				cacheResult(birthday);

				uncachedPrimaryKeys.remove(birthday.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(BirthdayModelImpl.ENTITY_CACHE_ENABLED,
					BirthdayImpl.class, primaryKey, _nullBirthday);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the birthdaies.
	 *
	 * @return the birthdaies
	 */
	@Override
	public List<Birthday> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Birthday> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Birthday> findAll(int start, int end,
		OrderByComparator<Birthday> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Birthday> list = (List<Birthday>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIRTHDAY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIRTHDAY;

				if (pagination) {
					sql = sql.concat(BirthdayModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Birthday>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Birthday>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the birthdaies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Birthday birthday : findAll()) {
			remove(birthday);
		}
	}

	/**
	 * Returns the number of birthdaies.
	 *
	 * @return the number of birthdaies
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BIRTHDAY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the birthday persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BirthdayImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIRTHDAY = "SELECT birthday FROM Birthday birthday";
	private static final String _SQL_SELECT_BIRTHDAY_WHERE_PKS_IN = "SELECT birthday FROM Birthday birthday WHERE birthdayId IN (";
	private static final String _SQL_COUNT_BIRTHDAY = "SELECT COUNT(birthday) FROM Birthday birthday";
	private static final String _ORDER_BY_ENTITY_ALIAS = "birthday.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Birthday exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = com.liferay.portal.util.PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
	private static final Log _log = LogFactoryUtil.getLog(BirthdayPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static final Birthday _nullBirthday = new BirthdayImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Birthday> toCacheModel() {
				return _nullBirthdayCacheModel;
			}
		};

	private static final CacheModel<Birthday> _nullBirthdayCacheModel = new CacheModel<Birthday>() {
			@Override
			public Birthday toEntityModel() {
				return _nullBirthday;
			}
		};
}