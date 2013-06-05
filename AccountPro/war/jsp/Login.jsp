<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
    <title>Welcome to AccountPro</title>
	<link href="css/Login.css" rel="stylesheet" type="text/css"/>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<form:form method="post" action="doLogin.htm" commandName="login">
	
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
					        <td><form:input path="userid" placeholder="UserID"  /></td> 
					        <td><form:errors path="userid" cssClass="error"/></td>
					    </tr>
					    <tr>
					        <td><form:label path="password">Password</form:label></td>
					        <td><form:input path="password"  placeholder="password"/></td>
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