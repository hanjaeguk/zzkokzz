<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>방방콕콕 - 여행 일정 상세</title>
<%@ include file="/WEB-INF/views/include/link.jsp"%>
<%@ include file="/WEB-INF/views/include/loader.jsp"%> 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ca50421e20fdf6befdf1ab193f76de7e&libraries=services"></script>
<link rel="stylesheet" href="${root}/resources/css/schedule.css">
<script type="text/javascript">
$(document).ready(function() {	
	$(".seul2").hide();
	$(".seul3").hide();

	$(".seul1").click(function(){
		$(".seul2").slideDown();
	});
	$(".seul2").click(function(){
		$(".seul3").slideDown();
	});
});
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>

    <!-- 내용 -->
    <div class="hero-wrap js-fullheight" style="background-image: url('${root}/resources/images/bg_4.jpg');">
      <div class="overlay"></div>
      <div class="container slcontainer">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">
            <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.jsp">Home</a></span> <span class="mr-2"><a href="blog.jsp">Schedule</a></span> <span>TripRead</span></p>
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">여행 일정 보기</h1>
          </div>
        </div>
      </div>
    </div>

<!-- 내용시작 -->
	<section class="ftco-section ftco-degree-bg">
	<div class="container">
	<div class="row">

<!-- 헤드 -->	
		<div class="col-md-12 ftco-animate destination">
			<div class="text p-3 row">			
				<div class="col-md-4 ftco-animate destination">
		    		<a href="#" class="img d-flex justify-content-center align-items-center" style="background-image: url('${root}/resources/images/destination-1.jpg');"></a>
				</div>
				<div class="col-md-8">
					<h3 class="mb-3">제목 입니다a.</h3>
					<p>여행 내용을 간략히 소개하는 부분 입니다.<br>지도는 왼쪽에서 스크롤해도 따라다니게 하면 좋을것 같다.<br>n일차 부분을 div, a, span, p 등으로 class 지정해주고 n일차(n) ^ 아이콘<br>밑에 부분 글씨 더 연하게</p>
					<hr>
					<p class="days">
						<span>
							<i class="icon-person"></i> 작성자id &nbsp;|&nbsp; <i class="icon-bookmark-o"></i> 북마크 : 18 &nbsp;|&nbsp; <i class="icon-thumbs-o-up"></i> 추천 : 18<br>
							<i class="icon-today"></i> 여행기간 : 18.08.18 - 18.09.18 (30일)<br>
							<i class="icon-pencil"></i> 게시일 : 18.08.18 수요일 &nbsp;|&nbsp; <i class="icon-pencil"></i> 최종 수정일 : 18.08.18 수요일<br>
						</span>
					</p><br>
					<p class="tagcloud">
						<a href="#" class="tag-cloud-link">전라남도</a>
		                <a href="#" class="tag-cloud-link">여수</a>
		                <a href="#" class="tag-cloud-link">순천</a>
		                <a href="#" class="tag-cloud-link">광양</a>
		                <a href="#" class="tag-cloud-link">봄</a>
		                <a href="#" class="tag-cloud-link">나혼자</a>
					</p>
				</div>
			</div>	
		</div>
<!-- 헤드 -->	
	
<!-- 왼쪽 -->
		<div class="col-md-4 sidebar ftco-animate">
        	<div class="sidebar-box ftco-animate">
				<div class="float_sidebar">
					<div class="">
						<div class="map_wrap">
	    					 <div id="daumMap" style="width:100%;height:400px;position:relative;overflow:hidden;"></div>
						</div>
					</div>
				</div>
            </div>
        
            <div class="sidebar-box ftco-animate">
              <h3><i class="icon-tag"></i> 태그cc</h3>
              <div class="tagcloud">
                <a href="#" class="tag-cloud-link">전라남도</a>
                <a href="#" class="tag-cloud-link">여수</a>
                <a href="#" class="tag-cloud-link">순천</a>
                <a href="#" class="tag-cloud-link">광양</a>
                <a href="#" class="tag-cloud-link">나혼자</a>
              </div>
            </div>

		</div>
<!-- 왼쪽 End -->
      
<!-- 오른쪽 -->    
		<div class="col-md-8 ftco-animate destination">
			
			<div class="sl-day day-updown"><label class="seul1">1일차 <a href="#"><i class="icon-keyboard_arrow_down"></i></a></label><hr></div>
			<div class="sl-loc loc-updown"><label class="seul2"><i class="flaticon-hotel"></i> 숙박숙박1 <a href="#"><i class="icon-keyboard_arrow_down"></i></a></label></div>
			<div class="sl-loc loc-updown"><label class="seul2"><i class="flaticon-hotel"></i> 숙박숙박1 <a href="#"><i class="icon-keyboard_arrow_down"></i></a></label></div>
				<div class="sl-loc-cont seul3">
		            <p> 2번째 내용내용 Temporibus ad error suscipit exercitationem hic molestiae totam obcaecati rerum, eius aut, in. Exercitationem atque quidem tempora maiores ex architecto voluptatum aut officia doloremque. Error dolore voluptas, omnis molestias odio dignissimos culpa ex earum nisi consequatur quos odit quasi repellat qui officiis reiciendis incidunt hic non? Debitis commodi aut, adipisci.</p>
		            <p><img src="${root}/resources/images/image_8.jpg" alt="" class="img-fluid"></p>
		            <p> 내용이구영 Quisquam esse aliquam fuga distinctio, quidem delectus veritatis reiciendis. Nihil explicabo quod, est eos ipsum. Unde aut non tenetur tempore, nisi culpa voluptate maiores officiis quis vel ab consectetur suscipit veritatis nulla quos quia aspernatur perferendis, libero sint. Error, velit, porro. Deserunt minus, quibusdam iste enim veniam, modi rem maiores.</p>
	            </div>
			<div class="sl-loc"><h5><i class="flaticon-fork"></i> 식당맛집식도락</h5></div>
				<div class="sl-loc-cont p-3">
	            	<p> 내용내용 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis, eius mollitia suscipit, quisquam doloremque distinctio perferendis et doloribus unde architecto optio laboriosam porro adipisci sapiente officiis nemo accusamus ad praesentium? Esse minima nisi et. Dolore perferendis, enim praesentium omnis, iste doloremque quia officia optio deserunt molestiae voluptates soluta architecto tempora.</p>
	            	<p><img src="${root}/resources/images/image_7.jpg" alt="" class="img-fluid"></p>
	           		<p> 내용 이어서 내용내용 Molestiae cupiditate inventore animi, maxime sapiente optio, illo est nemo veritatis repellat sunt doloribus nesciunt! Minima laborum magni reiciendis qui voluptate quisquam voluptatem soluta illo eum ullam incidunt rem assumenda eveniet eaque sequi deleniti tenetur dolore amet fugit perspiciatis ipsa, odit. Nesciunt dolor minima esse vero ut ea, repudiandae suscipit!</p>
	            </div>
            <div class="sl-loc"><h5><i class="flaticon-shopping-bag"></i> 쇼핑최고</h5></div>
            	<div class="sl-loc-cont p-3">
	            	<p> 내용내용 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis, eius mollitia suscipit, quisquam doloremque distinctio perferendis et doloribus unde architecto optio laboriosam porro adipisci sapiente officiis nemo accusamus ad praesentium? Esse minima nisi et. Dolore perferendis, enim praesentium omnis, iste doloremque quia officia optio deserunt molestiae voluptates soluta architecto tempora.</p>
	            	<p><img src="${root}/resources/images/image_7.jpg" alt="" class="img-fluid"></p>
	           		<p> 내용 이어서 내용내용 Molestiae cupiditate inventore animi, maxime sapiente optio, illo est nemo veritatis repellat sunt doloribus nesciunt! Minima laborum magni reiciendis qui voluptate quisquam voluptatem soluta illo eum ullam incidunt rem assumenda eveniet eaque sequi deleniti tenetur dolore amet fugit perspiciatis ipsa, odit. Nesciunt dolor minima esse vero ut ea, repudiandae suscipit!</p>
	            </div>
            <div class="sl-loc"><h5><i class="flaticon-meeting-point"></i> 장소멋진장소</h5></div>
	            <div class="sl-loc-cont p-3">
		            <p> 2번째 내용내용 Temporibus ad error suscipit exercitationem hic molestiae totam obcaecati rerum, eius aut, in. Exercitationem atque quidem tempora maiores ex architecto voluptatum aut officia doloremque. Error dolore voluptas, omnis molestias odio dignissimos culpa ex earum nisi consequatur quos odit quasi repellat qui officiis reiciendis incidunt hic non? Debitis commodi aut, adipisci.</p>
		            <p><img src="${root}/resources/images/image_8.jpg" alt="" class="img-fluid"></p>
		            <p> 내용이구영 Quisquam esse aliquam fuga distinctio, quidem delectus veritatis reiciendis. Nihil explicabo quod, est eos ipsum. Unde aut non tenetur tempore, nisi culpa voluptate maiores officiis quis vel ab consectetur suscipit veritatis nulla quos quia aspernatur perferendis, libero sint. Error, velit, porro. Deserunt minus, quibusdam iste enim veniam, modi rem maiores.</p>
	            </div>
	            
			<div class="sl-day sl-updown"><label class="seul1">2일차 <a href="#"><i class="icon-keyboard_arrow_down"></i></a></label><hr></div>
			<div class="sl-day sl-updown"><label class="seul1">3일차 <a href="#"><i class="icon-keyboard_arrow_down"></i></a></label><hr></div>      
            

<!-- 댓글 목록 ***li,ul 짝 안맞는거 찾기~ -->
            <div class="pt-5">
            <h5 class="mb-4"><i class="icon-comment"></i> 댓글 6</h5>
            <ul class="comment-list">
            	<li class="comment">
                  <div class="comment-body">
                  	<div class="row">
                  		<h3><i class="icon-person"></i> 작성자 11</h3>
                  		<div class="meta">2018.08.18 2:21</div>
                  		<a href="#" class="reply">답글</a>
                  	</div>
                  		<p>작성내용1 댓글이다 댓글</p>
                  </div>
                </li>

                <li class="comment">
                  <div class="comment-body">
                  	<div class="row">
                  		<h3><i class="icon-person"></i> 작성자 22222</h3>
                  		<div class="meta">2018.08.18 2:21</div>
                  		<a href="#" class="reply">답글</a>
                  	</div>
                  		<p>222222</p>
                  </div>


                  <ul class="slchild">
                    <li class="comment">
                      <div class="comment-body">
	                  	<div class="row">
	                  		<h3><i class="icon-person"></i> 작성자 22222</h3>
	                  		<div class="meta">2018.08.18 2:21</div>
	                  		<a href="#" class="reply">답글</a>
	                  	</div>
	                  		<p>222222</p>
	                  </div>
                    </li>
                  </ul>
                </li>

                <li class="comment">
                  <div class="comment-body">
                  	<div class="row">
                  		<h3><i class="icon-person"></i> 작성자 22222</h3>
                  		<div class="meta">2018.08.18 2:21</div>
                  		<a href="#" class="reply">답글</a>
                  	</div>
                  		<p>222222</p>
                  </div>
                </li>
              </ul>
              <!-- END comment-list -->
              
  <!-- 댓글달기 -->           
              <div class="comment-form-wrap pt-5">
                <form action="#" class="p-4 bg-light">
                	<div class="form-group">
                    	<p>댓글달기</p>
                    	<textarea name="" id="message" cols="30" rows="5" class="form-control" placeholder="내용과 무관한 댓글, 악플은 삭제될 수 있습니다."></textarea>
                 	 </div>
                  	<div class="form-group">
                   		 <input type="submit" value="등록" class="btn py-3 px-4 btn-primary">
                 	 </div>
                </form>
              </div>
            </div>

		</div>
<!-- 오른쪽 END -->
	</div>
	</div>
	</section>
<!-- 내용끝 -->


<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<%@ include file="/WEB-INF/views/include/arrowup.jsp"%>
<script src="${root}/resources/js/sl-map-view.js"></script>

</body>
</html>