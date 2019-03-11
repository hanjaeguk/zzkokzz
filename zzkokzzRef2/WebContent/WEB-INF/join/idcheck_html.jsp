<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${idcount == 0}">
<font color="blue"><b>${searchid}</b>는 사용 가능합니다.</font>
</c:if>
<c:if test="${idcount != 0}">
<font color="red"><b>${searchid}</b>는 사용중입니다. 다른 아이디를 검색하세요.</font>
</c:if>