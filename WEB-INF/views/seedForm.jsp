<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${seed.id == null ? 'Thêm mới' : 'Cập nhật'} Hạt giống</h2>
<form:form method="post" modelAttribute="seed" action="/seeds/save">
  <form:hidden path="id"/>
  <p>Tên: <form:input path="seedName"/></p>
  <p>Số lượng: <form:input path="quantity"/></p>
  <p>Danh mục:
    <form:select path="category.id">
      <form:options items="${categories}" itemValue="id" itemLabel="cateName"/>
    </form:select>
  </p>
  <button type="submit">Lưu</button>
</form:form>
<a href="/seeds">Quay lại</a>
</body>
</html>
