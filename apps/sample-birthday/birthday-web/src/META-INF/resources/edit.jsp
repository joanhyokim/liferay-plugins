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
Calendar calendar = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(), themeDisplay.getLocale());
%>

<portlet:actionURL name="addBirthday" var="addBirthdayURL">
	<portlet:param name="mvcPath" value="/edit.jsp" />
</portlet:actionURL>

<aui:form action="<%= addBirthdayURL %>" method="post">
	<aui:input label="name" name="name" type="text" />

	<liferay-ui:input-date
		dayNullable="<%= false %>"
		dayParam="birthdayDay"
		dayValue="<%= calendar.get(Calendar.DATE) %>"
		firstDayOfWeek="<%= Calendar.SUNDAY - 1 %>"
		imageInputId="startDateImageId"
		monthNullable="<%= false %>"
		monthParam="birthdayMonth"
		monthValue="<%= calendar.get(Calendar.MONTH) %>"
		yearNullable="<%= false %>"
		yearParam="birthdayYear"
		yearRangeEnd="<%= calendar.get(Calendar.YEAR) %>"
		yearRangeStart="<%= 1920 %>"
		yearValue="<%= calendar.get(Calendar.YEAR) %>"
	/>
	<aui:button type="submit" />
</aui:form>

<portlet:renderURL var="viewBirthdayURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<p><a href="<%= viewBirthdayURL %>">Back</a></p>