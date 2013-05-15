<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>
<%@ include file="../css/ListCustomer.css" %>


</style>

<script type="text/javascript">

 function openCustomer(id)
 {
	 window.open('openCustomer.htm?id='+id,'_self',false);
 }
 
 function deleteCustomer(id)
 {
	 if (confirm('Are you sure you want to delete customer ?')) 
	 { 
		  var form = document.getElementById("searchCustomerForm");
		  var custId = document.getElementById("custID");
		  custId.value  = id;
		  form.action = 'deleteCustomer.htm';
	 }
 }

</script>

<html>
<head>
    <title>Search Customer</title>
</head>

<body>


<form:form method="post" action="searchCustomer.htm" commandName="searchCustomerCriteria" id="searchCustomerForm">
 	
 	 	<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
 		</tr>
 	
 	 	<table class="tblParent">
			<tr>
				<td class="Heading" >Search Customer</td>
			</tr> 	
<%-- 	 		<tr>
	 			<td><form:errors path="*" cssClass="errorblock" element="div" /></td>
	 		</tr>
 --%>	 		<tr>
	 			<td>
				    <table class="tblChild">
					    <tr>
					        <td><form:label path="firstName">First Name</form:label></td>
					        <td><form:input path="firstName" /></td>
					        <%-- <td><form:errors path="firstName" cssClass="error" /></td> --%> 
					    </tr>
					    <tr>
					        <td><form:label path="lastName">Last Name</form:label></td>
					        <td><form:input path="lastName" /></td>
					        <%-- <td><form:errors path="lastName" cssClass="error" /></td> --%>
					    </tr>
					    <tr>
					        <td><form:label path="city">City</form:label></td>
					        <td><form:input path="city" /></td>
					        <%-- <td><form:errors path="city" cssClass="error" /></td> --%>
					    </tr>
					    <tr>
							<td><input type="submit" value="Search"/></td>
					        <td><input type="reset" value="Reset" /></td>
					    </tr>
					
						<tr><td><form:hidden path="customerID" id="custID"/></td></tr>
					
						<tr>
							<td>
								<table class="">
										<tr>
											<td colspan="2"><b>List Of Customers</b></td>
										</tr>
								</table>				
							</td>
						</tr>
			     		<tr>
					   			<!-- <td class="col1">FirstName</td> -->
					   			<!-- <td class="col2">LastName</td> -->
					   			<td class="colOpen">Select</td>
					   			<td class="colName">Name</td>
					   			<td class="col3">Phone</td>
					   			<td class="col4">DueDate</td>
					   			<td class="col5">AmountDue</td>
					   			<td class="col6">Active</td>
					   			<td class="colDelete">Delete</td>
				   		</tr>		
				    	<c:forEach items="${customerList}" var="customer">
			    		  <tr>
<%-- 			 	    		  	<td class="col1"><c:out value="${customer.firstName}"/></td>  
				    		  	<td class="col2"><c:out value="${customer.lastName}"/></td>
 --%>				    		 
 								<td class="colOpen"><input type="button" value="open" onclick="openCustomer(${customer.customerID})"/></td>
 								<td class="colName"><c:out value="${customer.firstName} ${customer.lastName}"/></td>
 								<td class="col3"><c:out value="${customer.phone}"/></td>
				    		  	<td class="col4"><c:out value="${customer.paymentDueDate}"/></td>
				    		  	<td class="col5"><c:out value="${customer.amountDue}"/></td>
				    		  	<td class="col6"><c:out value="${customer.active}"/></td>
				    		  	<td class="colDelete"><input type="submit" value="Delete" onClick="deleteCustomer(${customer.customerID})"></td>
				    		  	<!-- <td class="colDelete"><img src="../../images/Del.jpg" ALT="Delete Customer" /> </td> -->
				    		  	
				    		  	
						 </tr>							    		  	
			    		</c:forEach>
						 				 
					</table>  
	 			</td>
	 		</tr>
     
      		
<!--       		<tr>
      			<td>	
      				<table class="tblChild">
     				</table>
      			</td>
      		</tr>
 -->     
     </table>
</form:form>
</body>
</html>