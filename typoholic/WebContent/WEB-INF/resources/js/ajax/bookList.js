function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";		  
    oScript.src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js";	
    document.getElementsByTagName("head")[0].appendChild(oScript);
}

function getBookList(category, column, direction) {
	var answer;
	$.ajax({
		type: 'GET',
		url: './book/json/',
		data: {
			"category" : category,
			"directionType" : column,
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
				$('tbody > tr:nth-child('+(index+1)+') > td:nth-child(5) > a').text(data[index].author);
			});			
		}
	});
}