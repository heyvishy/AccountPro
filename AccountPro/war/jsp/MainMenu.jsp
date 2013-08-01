<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

	<head>

		<!-- Disables back button -->
	   	<script type = "text/javascript" >
		    function preventBack(){window.history.forward();}
		    setTimeout("preventBack()", 0);
		    window.onunload=function(){null};
		</script>
	
		<link href="css/global.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
	 		<tr>
	 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
	 		</tr>
			
			<table class="tblParent"> 
			
			  		<tr>
						<td class="Heading"></td>
					</tr> 	
			</table>
	</body>

</html>