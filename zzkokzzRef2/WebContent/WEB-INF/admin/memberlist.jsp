<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/skin_purple.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function memberlist(pg) {
	$.ajax({
		type: "POST",
		url: "${root}/admin/memberlist.test",
		data: {pg: pg, key: $("#key").val(), word: $("#word").val()},
		dataType: "json",
		success: function(data) {
			makeList(data);
		},
		error: function(e) {
			alert("에러발생 : " + e);
		}
	});
}

function makeList(data) {
	var mlist = document.getElementById("mlist");
	
	removeData();
	
	var len = data.members.length;
	for(var i=0;i<len;i++) {
		var member = data.members[i];
		
		var name = createCell(member.name, i % 2);
		var id = createCell(member.id, i % 2);
		var email = createCell(member.email, i % 2);
		var tel = createCell(member.tel, i % 2);
		var address = createCell(member.address, i % 2);
		var joindate = createCell(member.joindate, i % 2);
		
		var row = createRow(name, id, email, tel, address, joindate);
		mlist.appendChild(row);
	}
	
	var nv = document.getElementById("nv");
	nv.innerHTML = data.navigator;
}

function removeData() {
	var tbody = document.getElementById("mlist");
	var len = tbody.childNodes.length;
	for(var i=len-1;i>=0;i--)
		tbody.removeChild(tbody.childNodes[i]);
}

function createCell(data, i) {
	var cell = document.createElement("td");//<td></td>
	cell.setAttribute("class", "td" + (i+1));
	cell.appendChild(document.createTextNode(data));//<td>안효인</td>
	return cell;
}

function createRow(name, id, email, tel, address, joindate) {
	var row = document.createElement("tr");
	row.appendChild(name);
	row.appendChild(document.createElement("td"));
	row.appendChild(id);
	row.appendChild(document.createElement("td"));
	row.appendChild(email);
	row.appendChild(document.createElement("td"));
	row.appendChild(tel);
	row.appendChild(document.createElement("td"));
	row.appendChild(address);
	row.appendChild(document.createElement("td"));
	row.appendChild(joindate);
	
	return row;
}
</script> 
</head>
<body onload="javascript:memberlist('1');">
<center>
<h3>회원 목록</h3>
<table width="950">
<tr>
	<td colspan="11" align="right">
	<select name="key" id="key">
		<option value="name">이름
		<option value="id">아이디
		<option value="tel3">전화번호끝4자리
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="검색" onclick="javascript:memberlist('1');">
	</td>
</tr>
<tr class="bg_board_title">
	<td width="80">이름</td>
	<td nowrap class="board_bar" style="padding: 0px">|</td>
	<td width="100">아이디</td>
	<td nowrap class="board_bar" style="padding: 0px">|</td>
	<td width="150">이메일</td>
	<td nowrap class="board_bar" style="padding: 0px">|</td>
	<td width="120">전화번호</td>
	<td nowrap class="board_bar" style="padding: 0px">|</td>
	<td>주소</td>
	<td nowrap class="board_bar" style="padding: 0px">|</td>
	<td width="100">가입일</td>
</tr>
<tbody id="mlist"></tbody>
</table>
<div id="nv"></div>
</center>
</body>
</html>















