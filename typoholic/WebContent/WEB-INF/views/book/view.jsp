<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- CSS -->
<style>
#pagination > ul > li > a > i {
	font-size: x-large;
}
</style>
<!-- AJAX -->
<script type="text/javascript" src='${pageContext.request.contextPath }/resources/js/ajax/bookList.js' ></script>


<script type="text/javascript">
function sortTable(category, column, scending) {	
	//init
	var direction; 
	
	//direction
	if (scending == true) {
		direction = $("#direction").val();		
	} else {
		direction = 'desc';
		$("#direction").val("desc");
	}
	
	//Ajax 처리
	getBookList(category, column, direction);
	
	//후처리
	if (category != '') {
		$('#sortTable > thead > tr > th:nth-child(2)').attr('onclick','sortTable(\''+category+'\', \'category\', true)');
		$('#sortTable > thead > tr > th:nth-child(3)').attr('onclick','sortTable(\''+category+'\', \'clap\', true)');
		$('#sortTable > thead > tr > th:nth-child(4)').attr('onclick','sortTable(\''+category+'\', \'title\', true)');
		$('#sortTable > thead > tr > th:nth-child(5)').attr('onclick','sortTable(\''+category+'\', \'author\', true)');
	}
	
	//방향전환
	if (direction == "desc") {
		$("#direction").val("asc");				
	} else {
		$("#direction").val("desc");							
	}

	//셀렉터
	sideNav(category);
}

//셀렉터
function sideNav(category) {
	if (category == '') {
		$('#book-sidenav > ul > li').attr('class','');
		$('#book-sidenav > ul > li:nth-child(1)').attr('class','active');
	} else if (category == 'general') {
		$('#book-sidenav > ul > li').attr('class','');
		$('#book-sidenav > ul > li:nth-child(2)').attr('class','active');		
	} else if (category == 'fantasy') {
		$('#book-sidenav > ul > li').attr('class','');
		$('#book-sidenav > ul > li:nth-child(3)').attr('class','active');		
	}
}
</script>
<!-- 추가 파라미터 -->
<input type="hidden" id="direction" value="asc" />
<input type="hidden" id="category" value="" />
<div class="col-sm-10">
<div class="table-responsive">
	<table id="sortTable" class="table">
		<colgroup>
			<col class="col-sm-2">
			<col class="col-sm-1">
			<col class="col-sm-1">
			<col class="col-sm-6">
			<col class="col-sm-2">
		</colgroup>
		<thead>
			<tr>
				<th>cover</th>
				<th onclick="sortTable('${category}', 'category', true)">분류</th>
				<th onclick="sortTable('${category}', 'clap', true)">인기</th>
				<th onclick="sortTable('${category}', 'title', true)">제목</th>
				<th onclick="sortTable('${category}', 'author', true)">저자</th>
			</tr>
		</thead>
		<tbody>
			<!-- getList -->
			<c:forEach items="${list }" var="ridibook">
			<tr>
				<td><img src="http://${ridibook.cover }" alt="" /></td>
				<td>${ridibook.category }</td>
				<td>${ridibook.clap }</td>
				<td><a href="https://ridibooks.com${ridibook.link }">${ridibook.title }</a></td>
				<td><a href="./book?category=${param.category }&queryType=author&query=${ridibook.author}">${ridibook.author }</a></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</div>

<!-- 페이징 -->
<div id="pagination" style="text-align: center;">
    <ul class="pagination pagination-lg">
    	<!-- 10페이지 이전 -->
    	<c:choose>
	  	<c:when test="${pagination.currPage <= pagination.pageLimit }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="?page=${pagination.currPage - pagination.pageLimit }&category=${param.category}"><i class="fa fa-angle-double-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose> 
	  <!-- 1페이지 이전 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == 1 }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-left"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="?page=${pagination.currPage - 1 }&category=${param.category}"><i class="fa fa-angle-left"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 페이징 설정만큼 돌리기 -->
	  <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }" step="1">
	  	<c:choose>
	  		<c:when test="${i == pagination.currPage }">
	 			<li class="active">
	 				<a href="?page=${i }&category=${param.category}">${i }</a>
	 			</li>	  		
	  		</c:when>
	  		<c:otherwise>
	  			<li><a href="?page=${i }&category=${param.category}">${i }</a></li>	  		
	  		</c:otherwise>
	  	</c:choose>
	  </c:forEach>
	  <!-- 1페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage == pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="?page=${pagination.currPage + 1 }&category=${param.category}"><i class="fa fa-angle-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	  <!-- 10페이지 이후 -->
	  <c:choose>
	  	<c:when test="${pagination.currPage + pagination.pageLimit > pagination.finalEndPage }">
	  		<li class="disabled"><a href="#"><i class="fa fa-angle-double-right"></i></a></li>	  	
	  	</c:when>
	  	<c:otherwise>
	  		<li><a href="?page=${pagination.currPage + pagination.pageLimit }&category=${param.category}"><i class="fa fa-angle-double-right"></i></a></li>	 	  	
	  	</c:otherwise>
	  </c:choose>
	</ul>
</div>