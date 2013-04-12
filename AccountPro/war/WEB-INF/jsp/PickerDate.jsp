<!DOCTYPE html>
<html>
<head>
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  
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
	    	<td><input type="label" value="Start Date"/> </td> <td><input id="datepicker1" /></td>
	    </tr>
	    <tr>
	    	<td><input type="label" value="End Date"/> </td> <td><input id="datepicker2" /></td>
	    </tr>
	
	    <tr>
	    	<td><input id="setDate" type="button" value="submit" onclick="setDates()"/></td>
	    </tr>
    </table>
    
</form>
</body>
</html>