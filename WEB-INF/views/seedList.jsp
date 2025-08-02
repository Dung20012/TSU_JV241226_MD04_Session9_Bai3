<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/seeds/create">Thêm mới</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Số lượng</th>
        <th>Danh mục</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="seed" items="${seeds}">
        <tr>
            <td>${seed.id}</td>
            <td>${seed.seedName}</td>
            <td>${seed.quantity}</td>
            <td>${seed.category.cateName}</td>
            <td>
                <a href="/seeds/edit?id=${seed.id}">Sửa</a> |
                <a href="/seeds/delete?id=${seed.id}" onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- Phân trang -->
<c:if test="${totalPages > 1}">
    <div>
        <c:forEach begin="1" end="${totalPages}" var="i">
            <a href="/seeds?page=${i}">${i}</a>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
