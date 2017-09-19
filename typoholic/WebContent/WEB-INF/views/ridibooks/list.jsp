<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Java Script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/Sorting.js" type="text/javascript"></script>

<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="table-responsive">          
		<table id="sortTable" class="table">
		<thead>
			<tr>
				<th>cover</th>
				<th onclick="sortTable(1)">분류</th>
				<th onclick="sortTable(2)">star</th>
				<th onclick="sortTable(3)">starred</th>
				<th onclick="sortTable(4)">title</th>
				<th onclick="sortTable(5)">author</th>
			</tr>
		</thead>
		<tbody>
			<!-- getList -->
			<c:forEach items="${list }" var="ridibook">
			<tr>
				<td><img src="http://${ridibook.cover }" alt="" /></td>
				<td>${ridibook.category }</td>
				<td>${ridibook.star }</td>
				<td>${ridibook.starredPerson }</td>
				<td><a href="https://ridibooks.com${ridibook.link }">${ridibook.title }</a></td>
				<td>${ridibook.author }</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</div>
</body>
</html>