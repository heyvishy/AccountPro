<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/jsp/include.jsp" %>
<html>
<style type="text/css">
<%@ include file="../css/global.css" %>
</style>


	<head>
		<title>Contact Customer Support</title>
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