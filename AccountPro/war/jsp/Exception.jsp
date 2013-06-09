<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

	<!-- Disables back button -->
   	<script type = "text/javascript" >
	    function preventBack(){window.history.forward();}
	    setTimeout("preventBack()", 0);
	    window.onunload=function(){null};
	</script>
	
    <title>AccountPro Exception</title>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<form:form >
	 	 	<tr>
	 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
	 		</tr>
	 	
	 	 	<table class="tblParent">
				<tr>
					<td class="errorHeading" >AccountPro Exception :</td>
				</tr> 	
		 		<tr>
		 			<td>
					    <table class="tblChild">
						    <tr>
						        <!-- <td>AccountPro Exception</td> -->
						        <td class="errorMessage"> <c:out value="${exceptionReason}"> </c:out> </td>
						    </tr>
						</table>
					</td>
				</tr>
			</table>
	</form:form>
</body>
</html>					