<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>
</style>

<html>
<head>
    <title>AccountPro Exception</title>
</head>

<body>


<form:form >
 	
 	 	<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
 		</tr>
 	
 	 	<table class="tblParent">
			<tr>
				<td class="Heading">AccountPro Exception</td>
			</tr> 	
	 		<tr>
	 			<td>
				    <table class="tblChild">
				    	
					    <tr>
					        <%-- <td><form:label  >AccountPro Exception</form:label></td> --%>
					        <td>AccountPro Exception</td>
					        <td> <c:out value="${exceptionReason}"> </c:out> </td>
					    </tr>
					</table>
				</td>
			</tr>
		</table>
</form:form>
</body>
</html>					