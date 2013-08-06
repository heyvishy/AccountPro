<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE HTML>
<html>

<head>
    <title>Welcome to AccountPro</title>

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
  
 <form name='f' action="<c:url value='j_spring_security_check' />" 	method='POST'>
	
	<table class="tblParent">
		<tr>
			<td class="Heading" >AccountPro</td>
		</tr>
		
		
		<tr><td>
		<c:if test="${not empty error}">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
		</td></tr>
	 	
		<tr>
			<td>
		 		<table class="tblLogin">
					<tr>
						<td>User:</td>
						<td><input type='text' name='j_username' value=''>
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='j_password' />
						</td>
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
</form>
 
</body>
</html>
