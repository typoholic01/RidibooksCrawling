<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- AJAX -->
<script type="text/javascript">
$(document).ready(function() {
	getPostList('news');
	getPostList('free');
	getBookList();
	$('.carousel').carousel();
});
function getBookList() {
	
	$.ajax({
		type: 'GET',
		url: './book/json/',
		data: {
			"queryType" : 'clap',
			"direction" : 'desc'
		},		
		async: true, 
		success: function(data) {
			$.each(data, function(index, item) {
 				$('#myCarousel div.carousel-inner').append(setBookHtml(data[index]));
 				
 				if (index == 0) {
 					$('#myCarousel div.carousel-inner div.item').attr('class','item active');
				} else if (index == 5) {
  					return false;
				}
			});
		}
	});
}
function setBookHtml(book,index) {	
	var html = '<div class="item">'
			+'    <img class="col-sm-12" src="'+book.cover+'" alt="'+book.title+'" style="height: 340px;">'
			+'    <div class="carousel-caption">'
			+'      <h3>'+book.title+'</h3>'
			+'      <p>'+book.author+'</p>'
			+'    </div>'
			+'  </div>';
	
	return html;
}
</script>
<!-- Ajax -->
<script type="text/javascript">
function getPostList(boardUrl) {
	var target = '#'+boardUrl+' > tbody';
	
	//페이지 초기화
	var page = '${page}';
	if (page == '') {
		page = '1';
	}
	
	$.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath }/json/'+boardUrl,
		data: {
			"page" : page
		},		
		async: true, 
		success: function(data) {
			console.log(data);
			
 			$.each(data, function(index, item) {
 				console.log(data[index]);
  				//글 만들기
 				$(target).append(setPostHtml(data[index]));
  				if (index == 5) {
  					return false;
				}
			}); 
		}	
	});
	
}
function setPostHtml(post) {
	var html = '<tr>'
					+'<td>'
						+'<a href="${pageContext.request.contextPath }/free/'+post.seq+'">'+post.title+'</a>'
					+'</td>'
					+'<td>'+post.userId+'</td>'
				+'</tr>';
	
	return html;
}
</script>
<div class="container">
<div class="row">
	<div class="col-sm-3">
  	<h4 class="category-title" style="border-left: 3px solid steelblue;padding-left: 0.3em;">베스트셀러</h4>
  	<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
      <!-- bookList	 -->
      </div>

      <!-- Left and right controls -->
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
  <div class="col-sm-9">
  	<div class="row">
		<div class="table-responsive">
		<h4 class="category-title" style="border-left: 3px solid steelblue;padding-left: 0.3em;">뉴스 게시판</h4>   	          
		  <table id="news" class="table table-hover table-bordered">
		  	<colgroup>
		  		<col class="col-sm-9" />
		  		<col class="col-sm-3" />
		  	</colgroup>
		    <tbody>
		 	<!-- 				게시물 불러오기				 -->   
		    </tbody>
		  </table>
	  	</div>
  	</div>
  	<div class="row">
		<div class="table-responsive">
		<h4 class="category-title" style="border-left: 3px solid steelblue;padding-left: 0.3em;">자유 게시판</h4>   	          
		  <table id="free" class="table table-hover table-bordered">
		  	<colgroup>
		  		<col class="col-sm-9" />
		  		<col class="col-sm-3" />
		  	</colgroup>
		    <tbody>
		 	<!-- 				게시물 불러오기				 -->   
		    </tbody>
		  </table>
	  	</div>
  	</div>
  </div>  
</div>
<hr>
</div>