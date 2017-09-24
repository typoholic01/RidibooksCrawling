<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Resources -->
<%@ include file="head.jsp" %>

<!-- list-style -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/list-style.css" />

<!-- body -->
<div class="row">
<div class="col-sm-11">
<div class="table-responsive">          
  <table class="table table-hover table-bordered">
  	<colgroup>
  		<col class="col-sm-1" />
  		<col class="col-sm-8" />
  		<col class="col-sm-1" />
  		<col class="col-sm-1" />
  		<col class="col-sm-1" />
  	</colgroup>
    <thead>
      <tr class="active">
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>날짜</th>
        <th>조회</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td><a href="">안녕하세요 첫글입니다</a><i class="fa fa-comment"></i>10</td>
        <td>운영자</td>
        <td>2017-10-11</td>
        <td>0</td>
      </tr>
    </tbody>
  </table>
  </div>
</div>
</div>