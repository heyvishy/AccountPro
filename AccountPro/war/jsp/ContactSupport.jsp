<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/jsp/include.jsp" %>
<html>
	<head>
	
		<!-- Disables back button -->
	   	<script type = "text/javascript" >
		    function preventBack(){window.history.forward();}
		    setTimeout("preventBack()", 0);
		    window.onunload=function(){null};
		</script>

		<title>Contact Customer Support</title>
		<link href="css/global.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
		<form:form method="post" action="" commandName="">
	 		<tr>
	 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
	 		</tr>
		
		<table class="tblParent">
			
			<tr>
				<td>
					<table class="tblChild">
							<tr>
								<td>
									Got Issues ? Please contact support.
								</td>
							</tr>
							<tr>
								<td>email : shukla81@gmail.com</td>
							</tr>
							<tr>
								<td>phone :  (302) 468-7024</td>
							</tr>
					</table>
				</td>
			</tr>		
		
		</table>
	 
		
	 	</form:form> 
	</body>
		
</html>