<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>condiments</title>
</head>
<body>
Choose condiments for your sandwich<br>
<form method="post" action="/index">
    <input type="checkbox" name="sandwich" value="bread">Bread
    <input type="checkbox" name="sandwich" value="tomato">Tomato
    <input type="checkbox" name="sandwich" value="vegetable">Vegetable
    <input type="checkbox" name="sandwich" value="meat">Meat
    <input type="checkbox" name="sandwich" value="mustard">Mustard
    <input type="checkbox" name="sandwich" value="pepper">Pepper
    <input type="checkbox" name="sandwich" value="ketchup">Ketchup
    <button type="submit">Display condiments list </button>
</form>

</body>
</html>