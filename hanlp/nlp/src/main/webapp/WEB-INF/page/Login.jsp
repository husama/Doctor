
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
</script>
<title>login</title>
</head>
<body>
	<form action="login.action" method="post" >
		<table>
			<tr>
				<th>E-mail:</th>
				<td><input type="text" id="email" name="email"/></td>
			</tr>
			<tr>
				<th>password:</th>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
		<!--  		<td><input type="button" id="register" value="register"  onclick="regist()"/></td>  --> 
				<td><input type="submit" id="submit" value="login"/></td>
			</tr>
		</table>
	</form>

</body>
</html>