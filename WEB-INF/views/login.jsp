
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form action="/auth/login" method="post">
    <label for="username">Tên đăng nhập:</label>
    <input type="text" name="username" required><br><br>

    <label for="password">Mật khẩu:</label>
    <input type="password" name="password" required><br><br>

    <button type="submit">Đăng nhập</button>
</form>

<p>Chưa có tài khoản? <a href="/auth/register">Đăng ký</a></p>
</body>
</html>

