function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("sortTable");
  switching = true;
  //Set the sorting direction to ascending:
  dir = "asc";
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("tr");
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("td")[n];
      y = rows[i + 1].getElementsByTagName("td")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      var xtor = x.innerHTML.toLowerCase();
      var ytor = y.innerHTML.toLowerCase();
      var xlen = xtor.length;
      var ylen = ytor.length;

      //modify digit
      if (xlen > ylen) {
        for (var j = 0; j < xlen-ylen; j++) {
          ytor = "0" + ytor;
        }
      } else if (xlen < ylen) {
        for (var k = 0; k < ylen-xlen; k++) {
          xtor = "0" + xtor;
        }
      }

      if (dir == "asc") {
        if (xtor > ytor) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (xtor < ytor) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;
    } else if (switchcount == 0 && dir == "asc") {
      /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
       dir = "desc";
       switching = true;
    }
  }
}

function descSortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, switchcount = 0;
  table = document.getElementById("sortTable");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("tr");
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("td")[n];
      y = rows[i + 1].getElementsByTagName("td")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      var xtor = x.innerHTML.toLowerCase();
      var ytor = y.innerHTML.toLowerCase();
      var xlen = xtor.length;
      var ylen = ytor.length;

      //modify digit
      if (xlen > ylen) {
        for (var j = 0; j < xlen-ylen; j++) {
          ytor = "0" + ytor;
        }
      } else if (xlen < ylen) {
        for (var k = 0; k < ylen-xlen; k++) {
          xtor = "0" + xtor;
        }
      }

      if (xtor < ytor) {
        //if so, mark as a switch and break the loop:
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;
    }
  }
}

function stringSortTable(str) {
  var table, rows, switching, i, x, y, shouldSwitch, switchcount = 0;
  table = document.getElementById("sortTable");
  rows = table.getElementsByTagName("tr");

  for (var i = 1; i < (rows.length - 1); i++) {
    var move = 1;
    if (rows[i].innerHTML.indexOf(str) != -1) {
      rows[i].parentNode.insertBefore(rows[i], rows[move]);
      move++;
    }
  }
}
