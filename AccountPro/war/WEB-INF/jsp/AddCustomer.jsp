<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>


</style>

<script type="text/javascript">

/* function changeAction () {
    alert("inside change action");
    var form = document.getElementById("CustomerForm");
    form.action = 'addPolicy.htm';
}
 */ 
 
  function addPolicy()
 {
	 window.open('addPolicy.htm','_self',false);
 }
 
/*  	function addPolicy()
    {
       // alert("inside addPolicy action");
  //     window.location = 'addPolicy.htm';
       
        var form = document.getElementById("CustomerForm");
        form.commandName='policy';
        form.action = 'addPolicy.htm';
        //form.submit;
     }
 */ 
</script>

<html>
<head>
    <title>Add Customer</title>
</head>

<body>


<form:form method="post" action="addCustomer.htm" commandName="customer" id="CustomerForm">
 	
 	 	<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
 		</tr>
 	
 	 	<table class="tblParent">
			<tr>
				<td class="Heading" >Add Customer</td>
			</tr> 	
	 		<tr>
	 			<td><form:errors path="*" cssClass="errorblock" element="div" /></td>
	 		</tr>
	 		<tr>
	 			<td>
				    <table class="tblChild">
					    <tr>
					        <td><form:label path="firstName">First Name</form:label></td>
					        <td><form:input path="firstName" /></td>
					        <td><form:errors path="firstName" cssClass="error" /></td> 
					    </tr>
					    <tr>
					        <td><form:label path="lastName">Last Name</form:label></td>
					        <td><form:input path="lastName" /></td>
					        <td><form:errors path="lastName" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="address">Address</form:label></td>
					        <td><form:input path="address" /></td>
					        <td><form:errors path="address" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="city">City</form:label></td>
					        <td><form:input path="city" /></td>
					        <td><form:errors path="city" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="zipCode">Pin Code</form:label></td>
					        <td><form:input path="zipCode" /></td>
					        <td><form:errors path="zipCode" cssClass="error" /></td>
					    </tr>
					
					    <tr>
						 <c:choose>
						 	<c:when test="${resultValue > 0}">
						        <td>
						            <input type="submit" value="Save"/>
						        </td>
						        <td>
						            <!-- <td><a href="addPolicy.htm" value="AddPolicy"></a> -->
						            <input type="button" value="AddPolicy" onClick="addPolicy()">
						            <!-- <input type="submit" value="AddPolicy" onclick="addPolicy();"/> -->
						        </td>
						        
						 	</c:when>
						 	<c:otherwise>
						        <td>
						            <input type="submit" value="Add"/>
						        </td>
						        <td>
						            <input type="reset" value="Reset" />
						        </td>
						 	</c:otherwise>
						 </c:choose>
					    </tr>
						 				 
					</table>  
	 			</td>
	 		</tr>
     </table>
</form:form>
</body>
</html>