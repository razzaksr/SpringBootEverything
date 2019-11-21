<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Let to update</title>
</head>
<body>
<form action="updated" method="post">
<input type="number" name="bid" value="${bike.bid }"/>
<input type="text" name="model" value="${bike.model }"/>
<input type="number" name="price" value="${bike.price }"/>
<input type="number" name="milage" value="${bike.milage }"/>
<input type="submit" value="Update">
</form>
</body>
</html>