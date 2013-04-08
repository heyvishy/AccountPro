<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>
</style>

<script type="text/javascript">

 function updateCustomer(){
     var form = document.getElementById("CustomerForm");
     form.action = 'updateCustomer.htm';
 }
 
 function addPolicy(id)
 {
	 alert("addPolicy for customerID "+id);
	 window.open('addPolicyForCustomer.htm?id='+id,'_self',false);
 }

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
					        <td><form:input path="lastName"/></td>
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
							<td><form:hidden path="customerID" /></td>
						</tr>
						
					    <tr>
						 <c:choose>
						 	<c:when test="${!empty customer.customerID }"> 
						        <td>
						            <input type="submit" value="Save" onClick="updateCustomer()">
						        </td>
						        <td>
						            <input type="button" value="AddPolicy" onClick="addPolicy(${customer.customerID})">
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