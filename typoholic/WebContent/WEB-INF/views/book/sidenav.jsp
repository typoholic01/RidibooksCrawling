<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="book-sidenav" class="col-sm-2 sidenav">
  <h4>분류</h4>
  <ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="#section1" onclick="sortTable('','clap', false)">전체</a></li>
    <li><a href="#section2" onclick="sortTable('general','clap', false)">일반</a></li>
    <li><a href="#section3" onclick="sortTable('fantasy','clap', false)">판타지</a></li>
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