<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
List<Birthday> birthdays = (List<Birthday>)request.getAttribute("birthdays");

int count = (Integer)request.getAttribute("count");
%>

<c:if test="<%= birthdays != null %>">
<liferay-ui:search-container
	emptyResultsMessage="no-birtdays-found"
	iteratorURL="<%= portletURL %>"
>
	<liferay-ui:search-container-results
		results="<%= birthdays %>"
		total="<%= count %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.sample.birthday.model.Birthday"
		escapedModel="<%= true %>"
		keyProperty="birthdayId"
		modelVar="birthday"
	>
		<liferay-ui:search-container-column-text
			name="name"
			orderable="<%= true %>"
			orderableProperty="name"
			value="<%= String.valueOf(birthday.getName()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="birthday"
			orderable="<%= true %>"
			orderableProperty="date"
			value="<%= mediumDateFormatDate.format(birthday.getDate()) %>"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
</c:if>

<portlet:renderURL var="editBirthdayURL">
	<portlet:param name="mvcPath" value="/edit.jsp" />
</portlet:renderURL>

<p><a href="<%= editBirthdayURL %>">Edit birthdays</a></p>