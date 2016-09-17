<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zhoukewei.nlp.eneity.Case" %>
<%@ page import="com.zhoukewei.nlp.eneity.Answer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
 	<c:forEach items="${cases}" var="t">
		<tr>
			<td>${t.case_id}</td>
			<td>${t.question_desc}</td>
			<td>${t.question_type}</td>
			<c:forEach items="${t.answers}" var="x">
				<td>${x.answer_time}</td>
				<td>${x.answer_analysis}</td>
			</c:forEach>
		</tr>
	</c:forEach>  
	</table> 
</body>
</html>