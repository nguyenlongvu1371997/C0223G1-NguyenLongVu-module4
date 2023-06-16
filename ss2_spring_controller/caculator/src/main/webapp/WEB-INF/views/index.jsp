<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/calculator">
    <input type="number" name="number1" value="0">
    <input type="number" name="number2" value="0"><br>
    <button name="math" value="plus" type="submit">Cộng</button>
    <button name="math" value="minus" type="submit">Trừ</button>
    <button name="math" value="multiply" type="submit">Nhân</button>
    <button name="math" value="divide" type="submit">Chia</button><br>
    Kết quả là: ${result}
</form>
</body>
</html>