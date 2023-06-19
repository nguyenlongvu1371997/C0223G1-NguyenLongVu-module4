<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form:form method="post" modelAttribute="email" action="/list">
    Language<form:select path="language">
    <form:option value="English">English</form:option>
    <form:option value="Vietnamese">Vietnamese</form:option>
    <form:option value="Japanese">Japanese</form:option>
    <form:option value="Chinese">Chinese</form:option>
</form:select><br>

    Page size<form:select path="size">
    <form:option value="5">5</form:option>
    <form:option value="10">10</form:option>
    <form:option value="15">15</form:option>
    <form:option value="25">25</form:option>
    <form:option value="50">50</form:option>
    <form:option value="100">100</form:option>
</form:select><br>

    Span filer <form:checkbox path="filter" value="false"/><br>

    Signature <form:textarea path="signature"/><br>
    <button type="submit">Update</button>
    <button type="button">Cancel</button>

</form:form>
</body>
</html>