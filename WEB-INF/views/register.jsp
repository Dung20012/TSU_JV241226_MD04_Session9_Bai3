
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký</h2>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>

<form:form action="/auth/register" method="post" modelAttribute="user">
  <label for="username">Tên đăng nhập:</label>
  <form:input path="username" required="true"/><br><br>

  <label for="password">Mật khẩu:</label>
  <form:password path="password" required="true"/><br><br>

  <label for="confirmPassword">Nhập lại mật khẩu:</label>
  <input type="password" name="confirmPassword" required><br><br>

  <button type="submit">Đăng ký</button>
</form:form>

<p>Đã có tài khoản? <a href="/auth/login">Đăng nhập</a></p>
</body>
</html>

