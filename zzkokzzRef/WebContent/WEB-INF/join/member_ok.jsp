<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
${memberInfo.name}님 회원가입을 축하합니다.<br>
가입하신 아이디는 ${memberInfo.id}이고 이메일은 ${memberInfo.email1}@${memberInfo.email2}입니다.<br>
로그인 후 서비스를 이용 할수있습니다.<br>
<a href="${root}/user/login.test">로그인</a>
</center>
</body>
</html>