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

package com.liferay.sample.birthday.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Birthday}.
 * </p>
 *
 * @author Ryan Park
 * @see Birthday
 * @generated
 */
@ProviderType
public class BirthdayWrapper implements Birthday, ModelWrapper<Birthday> {
	public BirthdayWrapper(Birthday birthday) {
		_birthday = birthday;
	}

	@Override
	public Class<?> getModelClass() {
		return Birthday.class;
	}

	@Override
	public String getModelClassName() {
		return Birthday.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("birthdayId", getBirthdayId());
		attributes.put("name", getName());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long birthdayId = (Long)attributes.get("birthdayId");

		if (birthdayId != null) {
			setBirthdayId(birthdayId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new BirthdayWrapper((Birthday)_birthday.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.birthday.model.Birthday birthday) {
		return _birthday.compareTo(birthday);
	}

	/**
	* Returns the birthday ID of this birthday.
	*
	* @return the birthday ID of this birthday
	*/
	@Override
	public long getBirthdayId() {
		return _birthday.getBirthdayId();
	}

	/**
	* Returns the date of this birthday.
	*
	* @return the date of this birthday
	*/
	@Override
	public java.util.Date getDate() {
		return _birthday.getDate();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _birthday.getExpandoBridge();
	}

	/**
	* Returns the name of this birthday.
	*
	* @return the name of this birthday
	*/
	@Override
	public java.lang.String getName() {
		return _birthday.getName();
	}

	/**
	* Returns the primary key of this birthday.
	*
	* @return the primary key of this birthday
	*/
	@Override
	public long getPrimaryKey() {
		return _birthday.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _birthday.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _birthday.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _birthday.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _birthday.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _birthday.isNew();
	}

	@Override
	public void persist() {
		_birthday.persist();
	}

	/**
	* Sets the birthday ID of this birthday.
	*
	* @param birthdayId the birthday ID of this birthday
	*/
	@Override
	public void setBirthdayId(long birthdayId) {
		_birthday.setBirthdayId(birthdayId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_birthday.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this birthday.
	*
	* @param date the date of this birthday
	*/
	@Override
	public void setDate(java.util.Date date) {
		_birthday.setDate(date);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_birthday.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_birthday.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_birthday.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the name of this birthday.
	*
	* @param name the name of this birthday
	*/
	@Override
	public void setName(java.lang.String name) {
		_birthday.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_birthday.setNew(n);
	}

	/**
	* Sets the primary key of this birthday.
	*
	* @param primaryKey the primary key of this birthday
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_birthday.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_birthday.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.birthday.model.Birthday> toCacheModel() {
		return _birthday.toCacheModel();
	}

	@Override
	public com.liferay.sample.birthday.model.Birthday toEscapedModel() {
		return new BirthdayWrapper(_birthday.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _birthday.toString();
	}

	@Override
	public com.liferay.sample.birthday.model.Birthday toUnescapedModel() {
		return new BirthdayWrapper(_birthday.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _birthday.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BirthdayWrapper)) {
			return false;
		}

		BirthdayWrapper birthdayWrapper = (BirthdayWrapper)obj;

		if (Validator.equals(_birthday, birthdayWrapper._birthday)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public Birthday getWrappedBirthday() {
		return _birthday;
	}

	@Override
	public Birthday getWrappedModel() {
		return _birthday;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _birthday.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _birthday.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_birthday.resetOriginalValues();
	}

	private final Birthday _birthday;
}