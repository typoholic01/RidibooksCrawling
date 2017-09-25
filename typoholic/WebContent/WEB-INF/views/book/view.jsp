<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(1) > img').attr('src',data[index].cover);
 				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(2)').text(data[index].category);
 				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(3)').text(data[index].clap);
 				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(4) > a').attr('href','https://ridibooks.com'+data[index].link);
 				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(4) > a').text(data[index].title);
 				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(5)').text(data[index].author);
			});
			
			//방향전환
			if (direction == "desc") {
				$("#direction").val("asc");				
			} else {
				$("#direction").val("desc");							
			}
		}
	});
}
</script>
<div class="col-sm-10">
<div class="table-responsive">          
		<table id="sortTable" class="table">
		<thead>
			<tr>
				<th>cover</th>
				<th onclick="sortTable('category')">분류</th>
				<th onclick="sortTable('clap')">clap</th>
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
				<td>${ridibook.clap }</td>
				<td><a href="https://ridibooks.com${ridibook.link }">${ridibook.title }</a></td>
				<td>${ridibook.author }</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</div>