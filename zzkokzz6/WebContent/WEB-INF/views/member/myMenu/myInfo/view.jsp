<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/link.jsp"%>
<%@ include file="/WEB-INF/views/include/loader.jsp"%>    
<link rel="stylesheet" type="text/css" href="${root}/resources/css/table.css">  
</head>
<body>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>

    <div class="hero-wrap js-fullheight" style="background-image: url('${root}/resources/images/bg_4.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">  
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">내정보 관리</h1>
          </div>
        </div>
      </div>
    </div>
 <!-- 내용시작 -->
	<section class="ftco-section ftco-degree-bg">
	<div class="container">
	<div class="row">
<!-- 왼쪽 검색창 -->	
<%@ include file="/WEB-INF/views/member/myMenu/sidebar.jsp"%>
<!-- 왼쪽 검색창 END -->

<!-- 오른쪽 목록 -->
		<div class="col-lg-9">
			<div class="container" align="center">
		    <hr>    
		    <div class="row"> 	
		    	<div class="table100" style="width: 600px; margin-left: 50px;">
			     <table>
				    <tbody>
				      <tr>
				        <td style="font-weight: bold">ID3232</td>
				        <td>${userInfo.userid}</td>	      
				      </tr>	
				      
				      <tr>
				        <td style="font-weight: bold">이름</td>
				        <td>${userInfo.username}</td>	      
				      </tr>	      	
				      
				      <tr>
				        <td style="font-weight: bold">Email</td>
				        <td>${userInfo.useremail}</td>		        
				      </tr>
				      <tr>
				        <td style="font-weight: bold">가입일</td>
				        <td><fmt:formatDate pattern="yyyy년 MM월 dd일 HH시 mm분" value="${userInfo.joindate}"/></td> 
				        
				      </tr>
				    </tbody>
			  		</table>	  	
		    	</div>
			</div>
			<hr>	  	
			</div>
			<div class="d-flex justify-content-center mb-3">
			    <div class="p-2"><input type="button" value="수정하기" class="btn btn-primary py-3 px-4" onclick="location.href='${root}/member?act=mvmodify'"></div>			    
			    <div class="p-2"><input type="button" value="계정삭제" class="btn btn-primary py-3 px-4" onclick="location.href='${root}/member?act=mvdelete'"></div>			    
			</div>

<!-- 오른쪽 목록  END-->
	</div>
	</div> <!-- 큰 row END -->
	</div> <!-- 큰 container END -->
	</section>
<!-- 내용끝 -->



<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<%@ include file="/WEB-INF/views/include/arrowup.jsp"%>
</body>
</html>