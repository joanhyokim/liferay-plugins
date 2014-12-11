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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ryan Park
 * @generated
 */
@ProviderType
public class BirthdaySoap implements Serializable {
	public static BirthdaySoap toSoapModel(Birthday model) {
		BirthdaySoap soapModel = new BirthdaySoap();

		soapModel.setBirthdayId(model.getBirthdayId());
		soapModel.setName(model.getName());
		soapModel.setDate(model.getDate());

		return soapModel;
	}

	public static BirthdaySoap[] toSoapModels(Birthday[] models) {
		BirthdaySoap[] soapModels = new BirthdaySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BirthdaySoap[][] toSoapModels(Birthday[][] models) {
		BirthdaySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BirthdaySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BirthdaySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BirthdaySoap[] toSoapModels(List<Birthday> models) {
		List<BirthdaySoap> soapModels = new ArrayList<BirthdaySoap>(models.size());

		for (Birthday model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BirthdaySoap[soapModels.size()]);
	}

	public BirthdaySoap() {
	}

	public long getPrimaryKey() {
		return _birthdayId;
	}

	public void setPrimaryKey(long pk) {
		setBirthdayId(pk);
	}

	public long getBirthdayId() {
		return _birthdayId;
	}

	public void setBirthdayId(long birthdayId) {
		_birthdayId = birthdayId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	private long _birthdayId;
	private String _name;
	private Date _date;
}