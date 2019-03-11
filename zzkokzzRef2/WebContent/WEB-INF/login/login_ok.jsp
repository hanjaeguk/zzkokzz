<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:if test="${userInfo != null}">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<b>${userInfo.name}(${userInfo.id})</b>님 환영합니다.
[${userInfo.email1}@${userInfo.email2}]<br>
<a href="${root}/user/st.test">세션테스트</a><br>
<a href="${root}/user/logout.test">로그아웃</a>
</center>
</body>
</html>
</c:if>
<c:if test="${userInfo == null}">
<script>
alert("로그인 전용 페이지입니다.\n로그인페이지로 이동합니다.");
document.location.href = "${root}/user/login.test";
</script>
</c:if>