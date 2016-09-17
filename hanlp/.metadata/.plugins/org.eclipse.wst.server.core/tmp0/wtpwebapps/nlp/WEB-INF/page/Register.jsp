<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body>
	<form action="register.action" method="post">
		<table>
			<tr>
				<th>E-mail:</th>
				<td><input type="text" id="email" name="email"/></td>
			</tr>
			<tr>
				<th>username:</th>
				<td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
				<th>fullname:</th>
				<td><input type="text" id="fullname" name="fullname"/></td>
			</tr>
			<tr>
				<th>password:</th>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="login"/></td>
			</tr>
		</table>
	</form>
</body>
</html>