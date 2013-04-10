<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>

</style>

<script type="text/javascript">
	
	function chooseCustomer(){
		window.open('pickerCustomer.htm','choosecustomer','resizable=no,height=400,width=600');
/*  		if (window.focus) {newwindow.focus()}
		return false;
 */ 	}
	
</script>

<html>	
<head>
    <title>Add Policy</title>
</head>

<body>

<form:form method="post" action="addPolicy.htm" commandName="policy">
 	
 	
  		<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
 		</tr>
 	
<table class="tblParent">
	<tr>
		<td class="Heading" >Add Policy</td>
	</tr> 	
	<tr>
		<td><form:errors path="*" cssClass="errorblock" element="div" /></td>
	</tr> 	
 	<tr>
 		<td>
			  <table class="tblChild">
			    <tr>
			    	
			    		<%-- <form:input path="" id="custIDValue" value="someVal"/> --%>
<%-- 			    		<form:select id="userSelect" name="userId" path="user.id">
						    <option value="">Select to Edit</option>
						    <c:forEach var="theUser" items="${user.userList}">
						        <form:option value="${theUser.id}"><c:out value="${theUser.lastname} ${theUser.firstname}"/></form:option>
						    </c:forEach>
						</form:select>
 --%>			    	
			    </tr>	
			    <tr>
			        <td>
			        	<form:label path="customerId">Select Customer</form:label>
			        </td>
			        <td>
						 <c:choose>
						 	<c:when test="${policy.customerId gt 0}"> 
					        	<form:select id="customerID" path="customerId" disabled="">
										   <form:option value="${policy.customerId}" label="${customerName}"/>
								</form:select>
						 	</c:when>
						 	<c:otherwise>
					        	<form:select id="customerID" path="customerId">
								    <option value="0">Select</option>
									    <c:forEach var="customer" items="${customerList}">
									        <form:option value="${customer.customerID}" label="${customer.firstName} ${customer.lastName}"> </form:option>
									    </c:forEach>
 										 <%-- <form:options items="${customerList}" itemValue="" /> --%>
								</form:select>
								<td><input type="button" value="choose" onclick="chooseCustomer()"/></td>
						 	</c:otherwise>
						 </c:choose>
			        	
					</td>
			        <td><form:errors path="customerId" cssClass="error" /></td> 
			    </tr>
			    <tr>
			        <td><form:label path="policyType">Policy Type</form:label></td>
			        <td><form:input path="policyType" readonly="true" value="Recurring Deposit"  /></td>
			    </tr>
			    <tr>
			        <td><form:label path="policyNumber">Policy Number</form:label></td>
			        <td><form:input path="policyNumber"/></td>
			        <td><form:errors path="policyNumber" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="policyAmount">Policy Amount</form:label></td>
			        <td><form:input path="policyAmount" /></td>
			        <td><form:errors path="policyAmount" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="startDate">Start Date (Format DD-MM-YYYY e.g 01-01-2012)</form:label></td>
			        <td><form:input path="startDate" /></td>
			        <td><form:errors path="startDate" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="endDate">End Date  (Format DD-MM-YYYY e.g 01-01-2012)</form:label></td>
			        <td><form:input path="endDate" /></td>
			        <td><form:errors path="endDate" cssClass="error" /></td>
			    </tr>

			    <tr>
					 <c:choose>
					 	<c:when test="${policy.customerId gt 0}">
					 	<%-- <c:when test="${resultValue > 0}"> --%>	  		
					        <td>
					            <input type="submit" value="Save"/>
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