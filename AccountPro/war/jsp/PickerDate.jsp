<!DOCTYPE html>

<html>
<head>

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- 
 <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/jquery-ui.min.js"></script>
 --> 
 
 <script>
  $(document).ready(function() {
    $("#datepicker1").datepicker({minDate:0});
    //$("#datepicker2").datepicker();
  });
  </script>
  
  <script type="text/javascript">
    

  function setDates(){
    	var sDateValue = document.getElementById("datepicker1").value;
    	//var eDateValue = document.getElementById("datepicker2").value;
      	window.opener.document.getElementById("sDate").value = sDateValue;
        //window.opener.document.getElementById("eDate").value = eDateValue;
        //alert("sDateValue :"+sDateValue);
      
		var dateArray = sDateValue.split("/");
		
		//in JS, month starts from 0
		var month = dateArray[0]-1;
		var day = dateArray[1];
		var fullYear = dateArray[2];
		//alert("month "+month+ " day "+day+" fullYear "+fullYear);
		var startDate = new Date();
		startDate.setMonth(month);
		startDate.setDate(day);
		startDate.setFullYear(fullYear);
		
		//alert("constructed startDate :"+startDate);
		
		//add 5 yrs - 1 day, to get end date
      	startDate.setMonth(startDate.getMonth()+60 );
      	startDate.setDate(startDate.getDate() - 1);
	    
        //alert((startDate.getMonth() + 1) + '/' + startDate.getDate() + '/' +  startDate.getFullYear());
      	window.opener.document.getElementById("eDate").value = (startDate.getMonth() + 1) + '/' + startDate.getDate() + '/' +  startDate.getFullYear();
      	
      	
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
<!--  	    <tr>
	    	<td><input type="label" value="End Date"/></td>
	    	<td><label for="endDateLabel">End Date</label></td> 
	    	<td><input id="datepicker2" /></td>
	    </tr>
 -->	
	    <tr>
	    	<td><input id="setDate" type="button" value="submit" onclick="setDates()"/></td>
	    </tr>
    </table>
    
</form>
</body>
</html>