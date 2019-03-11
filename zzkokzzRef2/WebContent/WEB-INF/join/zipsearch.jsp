<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/style.css" type="text/css">
<script type="text/javascript">
function dongcheck(){
	if(document.getElementById("dong").value == "") {
		alert("검색 동 입력!");
		return;
	} else {
		document.zipform.action = "${root}/user/zipsearch.test";
		document.zipform.submit();
	}
}

function selectzip(z1, z2, address){
	opener.document.getElementById("zip1").value = z1;
	opener.document.getElementById("zip2").value = z2;
	opener.document.getElementById("address").value = address;
	
	self.close();
}
</script>
</head>
<body>
<center>
<form name="zipform" method="post" action="">
<h3>우편번호검색</h3>
<table width="350">
<tr>
	<td class="td3">검색할동을 입력하세요<br>(예: 역삼동, 신촌)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="dong" id="dong" onkeypress="javascript:if(event.keyCode == 13){ dongcheck(); }">
	<input type="button" value="검색" id="btnsearch" onclick="javascript:dongcheck();">
	</td>
</tr>
<c:if test="${searchdong == null}">
<tr>
	<td class="td4">
	동이름을 정확히 입력하세요.
	</td>
</tr>
</c:if>
<c:if test="${searchdong != null}">
	<c:if test="${ziplist.size() != 0}">
		<c:forEach var="zipcode" items="${ziplist}">
<tr>
	<td class="td4">
	<a href="javascript:selectzip('${zipcode.zip1}', '${zipcode.zip2}', '${zipcode.sido} ${zipcode.gugun} ${zipcode.dong} ${zipcode.bunji}');">
	${zipcode.zip1}-${zipcode.zip2}
	${zipcode.sido} ${zipcode.gugun} ${zipcode.dong} ${zipcode.bunji}
	</a>
	</td>
</tr>
		</c:forEach>	
	</c:if>
	<c:if test="${ziplist.size() == 0}">
<tr>
	<td class="td4">
	<b>${searchdong}</b>에 대한 검색 결과가 없습니다.
	</td>
</tr>
	</c:if>
</c:if>
</table>
</form>
</center>
</body>
</html>










