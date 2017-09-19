function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";		  
    oScript.src = "http://code.jquery.com/jquery-1.6.2.min.js";	
    document.getElementsByTagName("head")[0].appendChild(oScript);
}


function sortTable(n) {
	var rows, values;
	
	//배열 rows를 준비한다
    rows = $("#sortTable > tbody > tr");
    
    //정렬한다
//    ascendingSort(rows, n, 0, rows.length - 1);
    
    //스와핑 테스트
	var values = rows.children("td:nth-child("+(n+1)+")");
    var pivot = values[0];
    console.log(pivot);
	
}

function ascendingPartition(rows, n, left, right) {
	var temp;
	var i = left;
	var j = right;
	var values = rows.children("td:nth-child("+(n+1)+")");
	var pivot = values[(i+j)/2].text();
	
	
	//i부터 j까지 정렬한다
	while (i <= j) {
		
		//arr[i]가 pivot보다 작으면 skip한다
		while (values[i].text() < pivot) {
			i++;
		}
		
		//arr[j]가 pivot보다 크면 skip한다
		while (pivot < values[j].text()) {
			j--;
		}
		
		//pivot보다 큰 arr[i]가 존재하고 pivot보다 작은 arr[j]가 존재하며 그 둘이 pivot을 사이에 두고 정대칭일때
		if (i <= j) {
			//순서이동
		    rows[i].before(rows[j]);
		    rows[j+1].before(rows[i]);
		    //자료이동
		    temp = rows[i];
		    rows[i] = rows[j];
		    rows[j] = temp;
			//가만히 냅두면 다시 같은 값을 참조하므로 증가시킨다
			i++;
			j--;
		}
	}
	//다음 정렬에 사용할 index를 넘긴다
	return i;
}

function ascendingSort(rows, n, left, right) {
	
	//1차로 정렬해준다
	var index = ascendingPartition(rows, n, left, right);

	// 왼쪽을 끝까지 정렬했는지 여부를 확인한다
	if (left < index - 1)
		//재귀로 반복한다
		ascendingSort(rows, n, left, index - 1);
	// 오른쪽을 끝까지 정렬했는지 확인한다
	if (index < right)
		ascendingSort(rows, n, index, right);
	
	// 전부 정렬이 되었으면 탈출한다
}