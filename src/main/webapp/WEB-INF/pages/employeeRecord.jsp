<%--
  Created by IntelliJ IDEA.
  User: Nilesh
  Date: 3/27/2016
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><spring:message code="employee.records.title" /></title>
</head>
<body>
<h1><center><spring:message code="employee.list" /></center></h1>
<table border="2" align="center" width="100%">
    <thead>
    <tr>
        <th><spring:message code="employee.record.id" /></th>
        <th><spring:message code="employee.record.name" /></th>
        <th><spring:message code="employee.record.address" /></th>
        <th><spring:message code="employee.record.contact" /></th>
        <th><spring:message code="employee.record.role" /></th>
        <th><spring:message code="employee.record.department" /></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee}" var="emp">
        <tr align="center">
            <td><c:out value="${emp.getId()}" /></td>
            <td><c:out value="${emp.getName()}" /></td>
            <td><c:out value="${emp.getAddress()}" /></td>
            <td><c:out value="${emp.getContactNum()}" /></td>
            <td><c:out value="${emp.getRole()}" /></td>
            <td><c:out value="${emp.getDepartment()}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<spring:url value="/index.jsp" />"><spring:message code="user.create" /></a>
</body>
</html>
