<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/link.jsp"%>
<%@ include file="/WEB-INF/views/include/loader.jsp"%>  
</head>
<body>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
 
    <div class="hero-wrap js-fullheight" style="background-image: url('${root}/resources/images/bg_4.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">  
          
                    <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">계정삭제</h1>
           
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
		<div class="col-lg-9" align="center">

			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
			<form class="login100-form validate-form">
			<span class="login100-form-title p-b-49">
				계정삭제
			</span>
			<br><br>
			<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired" align="left">
				<span class="label-input100">아이디</span>
					<input class="input100" type="text" name="username" value="Test" readonly="readonly">
				<span class="focus-input100" data-symbol="&#xf206;"></span>
			</div>

			<br>
			<div class="wrap-input100 validate-input" data-validate="Password is required" align="left">
				<span class="label-input100">비밀번호</span>
				<input class="input100" type="password" name="pass" placeholder="비밀번호입력">
				<span class="focus-input100" data-symbol="&#xf190;"></span>
			</div>

			
			
			
			<br><br>
			<div class="d-flex justify-content-center mb-3">
		    	<div class="p-2">
		    		<input type="submit" value="삭제" class="btn btn-primary py-3 px-4">
		    		<input type="submit" value="취소" class="btn btn-primary py-3 px-4">
		    	</div>			    
			</div>				
				
			</form>
		</div>

<!-- page END -->          	
		</div> 
<!-- 오른쪽 목록  END-->
	</div> <!-- 큰 row END -->
	</div> <!-- 큰 container END -->
	</section>
<!-- 내용끝 -->




<%@ include file="/WEB-INF/views/include/footer.jsp"%>
  
<%@ include file="/WEB-INF/views/include/arrowup.jsp"%>
</body>
</html>



