<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
//셀렉터
$(document).ready(function() {
	if ('${param.category}' == '') {
		$('#book-sidenav > ul > li').attr('class','');
		$('#book-sidenav > ul > li:nth-child(1)').attr('class','active');
	} else if ('${param.category}' == 'general') {
		$('#book-sidenav > ul > li').attr('class','');
		$('#book-sidenav > ul > li:nth-child(2)').attr('class','active');		
	} else if ('${param.category}' == 'fantasy') {
		$('#book-sidenav > ul > li').attr('class','');
		$('#book-sidenav > ul > li:nth-child(3)').attr('class','active');		
	}
})
</script>
<div id="book-sidenav" class="col-sm-2 sidenav">
  <h4>분류</h4>
  <ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="./book">전체</a></li>
    <li><a href="./book?category=general">일반</a></li>
    <li><a href="./book?category=fantasy">판타지</a></li>
  </ul><br>
  <div class="input-group" style="display:none;">
    <input type="text" class="form-control" placeholder="Search Blog..">
    <span class="input-group-btn">
      <button class="btn btn-default" type="button">
        <span class="glyphicon glyphicon-search"></span>
      </button>
    </span>
  </div>
</div>