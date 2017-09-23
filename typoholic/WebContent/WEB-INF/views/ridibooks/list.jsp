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
<script src="${pageContext.request.contextPath }/js/SortTable.js" type="text/javascript"></script>

<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- AJAX -->
<script type="text/javascript">
function sortTable(column) {
	var direction = $("#direction").val();
	console.log(direction);
	
	$.ajax({
		type: 'GET',
		url: './json/',
		data: {
			"queryType" : column,
			"direction" : direction
		},		
		async: true, 
		success: function(data) {
			$.each(data, function(index, item) {
 				$('tbody > tr:nth-child('+index+') > td:nth-child(1) > img').attr('src',data[index].cover);
 				$('tbody > tr:nth-child('+index+') > td:nth-child(2)').text(data[index].category);
 				$('tbody > tr:nth-child('+index+') > td:nth-child(3)').text(data[index].star);
 				$('tbody > tr:nth-child('+index+') > td:nth-child(4)').text(data[index].starredPerson);
 				$('tbody > tr:nth-child('+index+') > td:nth-child(5) > a').attr('href','https://ridibooks.com'+data[index].link);
 				$('tbody > tr:nth-child('+index+') > td:nth-child(5) > a').text(data[index].title);
 				$('tbody > tr:nth-child('+index+') > td:nth-child(6)').text(data[index].author);
			});
			
			//방향전
			if (direction == "desc") {
				$("#direction").val("asc");				
			} else {
				$("#direction").val("desc");							
			}
		}
	});
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="direction" type="hidden" value="desc">
<div class="container-fluid">
	<div class="table-responsive">          
		<table id="sortTable" class="table">
		<thead>
			<tr>
				<th>cover</th>
				<th onclick="sortTable('category')">분류</th>
				<th onclick="sortTable('star')">star</th>
				<th onclick="sortTable('starredPerson')">starred</th>
				<th onclick="sortTable('title')">title</th>
				<th onclick="sortTable('author')">author</th>
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