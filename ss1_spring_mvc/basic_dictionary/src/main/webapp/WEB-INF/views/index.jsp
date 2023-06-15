<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/dictionary" method="post">
    Nhập: <input name="word" value="">
    <button type="submit">Dịch</button>
</form>
<p>Nghĩa: ${word}</p>
</body>
</html>