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

package com.liferay.sample.birthday.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.birthday.model.Birthday;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Birthday in entity cache.
 *
 * @author Ryan Park
 * @see Birthday
 * @generated
 */
@ProviderType
public class BirthdayCacheModel implements CacheModel<Birthday>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{birthdayId=");
		sb.append(birthdayId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", date=");
		sb.append(date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Birthday toEntityModel() {
		BirthdayImpl birthdayImpl = new BirthdayImpl();

		birthdayImpl.setBirthdayId(birthdayId);

		if (name == null) {
			birthdayImpl.setName(StringPool.BLANK);
		}
		else {
			birthdayImpl.setName(name);
		}

		if (date == Long.MIN_VALUE) {
			birthdayImpl.setDate(null);
		}
		else {
			birthdayImpl.setDate(new Date(date));
		}

		birthdayImpl.resetOriginalValues();

		return birthdayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		birthdayId = objectInput.readLong();
		name = objectInput.readUTF();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(birthdayId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(date);
	}

	public long birthdayId;
	public String name;
	public long date;
}