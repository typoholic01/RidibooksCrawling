function ascendingPartition(arr, left, right) {
	var temp;
	var i = left;
	var j = right;
	var pivot = arr[(i+j)/2];
	
	//i부터 j까지 정렬한다
	while (i <= j) {
		
		//arr[i]가 pivot보다 작으면 skip한다
		while (arr[i] < pivot) {
			i++;
		}
		
		//arr[j]가 pivot보다 크면 skip한다
		while (pivot < arr[j]) {
			j--;
		}
		
		//pivot보다 큰 arr[i]가 존재하고 pivot보다 작은 arr[j]가 존재하며 그 둘이 pivot을 사이에 두고 정대칭일때
		if (i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			//가만히 냅두면 다시 같은 값을 참조하므로 증가시킨다
			i++;
			j--;
		}
	}
	//다음 정렬에 사용할 index를 넘긴다
	return i;
}

function descendingPartition(arr, left, right) {
	var temp;
	var i = left;
	var j = right;
	var fivot = arr[(i+j)/2];
	
	//i부터 j까지 정렬한다
	while (i <= j) {
		
		//arr[i]가 pivot보다 크면 skip한다
		while (arr[i] > pivot) {
			i++;
		}
		
		//arr[j]가 pivot보다 작으면 skip한다
		while (pivot > arr[j]) {
			j--;
		}
		
		//pivot보다 작은 arr[i]가 존재하고 pivot보다 큰 arr[j]가 존재하며 그 둘이 pivot을 사이에 두고 정대칭일때
		if (i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			//가만히 냅두면 다시 같은 값을 참조하므로 증가시킨다
			i++;
			j--;
		}
	}
	//다음 정렬에 사용할 index를 넘긴다
	return i;
}

function ascendingSort(arr, left, right) {
	
	//1차로 정렬해준다
	var index = ascendingPartition(arr, left, right);

	// 왼쪽을 끝까지 정렬했는지 여부를 확인한다
	if (left < index - 1)
		//재귀로 반복한다
		ascendingSort(arr, left, index - 1);
	// 오른쪽을 끝까지 정렬했는지 확인한다
	if (index < right)
		ascendingSort(arr, index, right);
	
	// 전부 정렬이 되었으면 탈출한다
}