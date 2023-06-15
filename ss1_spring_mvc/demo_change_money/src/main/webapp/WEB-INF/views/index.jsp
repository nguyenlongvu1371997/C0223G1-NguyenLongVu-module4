<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/convert">
    Nhập số tiền<input name="money" value="0" type="number"><br>
    From <select name="from">
    <option value="1">VNĐ</option>
    <option value="2">USD</option>
    <option value="3">Yên</option>
</select>
    to <select name="to">
    <option value="1">VNĐ</option>
    <option value="2">USD</option>
    <option value="3">Yên</option>
</select>
    <button type="submit">Đổi</button>
</form>

<p>Số tiền đổi được là ${money}</p>
</body>
</html>