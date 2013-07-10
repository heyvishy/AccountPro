<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE HTML>
<html>

<head>
    <title>Welcome to AccountPro</title>

	<!-- Disables back button -->
   	<script type = "text/javascript" >
	    function preventBack(){window.history.forward();}
	    setTimeout("preventBack()", 0);
	    window.onunload=function(){null};
	</script>
    
	<link href="css/Login.css" rel="stylesheet" type="text/css"/>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
</head>

<body onload='document.f.userid.focus();'>


	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form:form name='f' method="post" action="<c:url value='j_spring_security_check' />" commandName="login">
	
		<table class="tblParent">
			<tr>
				<td class="Heading" >AccountPro</td>
			</tr>
			<tr>
				<td>
					<form:errors path="*" cssClass="errorblock" element="div" />
				</td>
			</tr> 	
			<tr>
				<td>
				    <table class="tblLogin">
					    <tr>
					        <td><form:label path="userid" >User Id</form:label></td>
					        <td><form:input name="j_username" path="userid" placeholder="UserID" /></td> 
					        <td><form:errors path="userid" cssClass="error"/></td>
					    </tr>
					    <tr>
					        <td><form:label path="password">Password</form:label></td>
					        <td><form:input name='j_password' path="password" placeholder="password" /></td>
					        <td><form:errors path="password" cssClass="error"/></td>
					    </tr>
					    <tr>
					        <td>
					            <input type="submit" value="Login"/>
					        </td>
					         <td class="und">
					            	Forgot your password ?
					        </td>
					        
					    </tr>
					</table>  		
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
