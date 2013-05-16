<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <style type="text/css">
<%@ include file="../css/global.css" %>
</style>
 --%>

<html>
	<head>
		<link href="css/global.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
		<form:form method="post" action="mainMenu.htm" commandName="mainMenu">
		 
	 		<tr>
	 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
	 		</tr>
			
			<table class="tblParent"> 
			
			  		<tr>
						<td class="Heading"></td>
					</tr> 	
			</table>
		</form:form>
	</body>

</html>