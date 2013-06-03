<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<html>
<head>
	<title>Add Customer</title>
	
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
	<link href="css/AddCustomer.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/AddCust.js"></script>	
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
					        <td><form:input path="lastName"  /></td>
					        <td><form:errors path="lastName" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="address">Address</form:label></td>
					        <td><form:input path="address" /></td>
					        <td><form:errors path="address" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="city">City</form:label></td>
					        <td><form:input path="city" type="text"/></td>
					        <td><form:errors path="city" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="zipCode">Pin Code</form:label></td>
					        <td><form:input path="zipCode" type="number" /></td>
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
						
					 <c:if test="${!empty policies}" >
						<tr>
							<td>
								<table class="">
										<tr>
											<td><b>Customer Policies</b></td>
										</tr>
								</table>				
							</td>
						</tr>
			     		<tr>
					   			<!-- <td class="colOpen">Select</td> -->
					   			<!-- <td class="col2">CustomerName</td> -->
					   			<td class="col3">PolicyType</td>
					   			<td class="col4">PolicyNumber</td>
					   			<td class="col5">PolicyAmount</td>
					   			<td class="col6">StartDate</td>
					   			<td class="col7">EndDate</td>
					   			<!-- <td class="colDelete">Delete</td> -->
				   		</tr>		
					</c:if>
					
				    	<c:forEach items="${policies}" var="policy">
			    		  <tr>
				    		  	<%-- <td class="colOpen"><input type="button" value="open" onclick="openPolicy(${policy.policyID})"/></td> --%>
				    		  	<%-- <td class="col2"><c:out value="${policy.customerId}"/></td> --%>
				    		  	<td class="col3"><c:out value="${policy.policyType}"/></td>
				    		  	<td class="col4"><c:out value="${policy.policyNumber}"/></td>
				    		  	<td class="col5"><c:out value="${policy.policyAmount}"/></td>
				    		  	<td class="col6"><c:out value="${policy.startDate}"/></td>
				    		  	<td class="col7"><c:out value="${policy.endDate}"/></td>
				    		  	<%-- <td class="colDelete"><input type="submit" value="Delete" onClick="deletePolicy(${policy.policyID})"></td> --%>
						 </tr>							    		  	
			    		</c:forEach>
						 				 
					</table>  
	 			</td>
	 		</tr>
     </table>
</form:form>
</body>
</html>