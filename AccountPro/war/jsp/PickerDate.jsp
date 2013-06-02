<!DOCTYPE html>

<html>
<head>


 <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/jquery-ui.min.js"></script>

 <script>
  $(document).ready(function() {
    $("#datepicker1").datepicker();
    $("#datepicker2").datepicker();
  });
  </script>
  
  <script type="text/javascript">
    function setDates(){
    	//alert("value of date being set ");
    	//alert(" is :"+document.getElementById("datepicker").value);
    	var sDateValue = document.getElementById("datepicker1").value;
    	var eDateValue = document.getElementById("datepicker2").value;
      	window.opener.document.getElementById("sDate").value = sDateValue;
      	window.opener.document.getElementById("eDate").value = eDateValue;
    	window.close();
    }
  </script>

</head>  

<body>
<form>
    <table>
	    <tr>
	    	<!-- <td><form:label path="startDate">Start Date (Format DD-MM-YYYY e.g 01-01-2012)</form:label></td> --> 
	    	<td><label for="startDateLabel">Start Date</label></td>
	    	<!-- <td><input type="label" value="Start Date"/></td> --> 
	    	<td><input id="datepicker1" /></td>
	    </tr>
	    <tr>
	    	<!-- <td><input type="label" value="End Date"/></td> -->
	    	<td><label for="endDateLabel">End Date</label></td> 
	    	<td><input id="datepicker2" /></td>
	    </tr>
	
	    <tr>
	    	<td><input id="setDate" type="button" value="submit" onclick="setDates()"/></td>
	    </tr>
    </table>
    
</form>
</body>
</html>