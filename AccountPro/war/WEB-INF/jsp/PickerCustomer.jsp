<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>
<%@ include file="../css/ListCustomer.css" %>


</style>

<script type="text/javascript">

	function selectCustomer(id){
		alert("select customer id :"+id);
		window.opener.location.href = window.opener.location.href;

		if (window.opener.progressWindow)
		{
		    window.opener.progressWindow.close()
		}
		window.close();
	}
	
/*  function openCustomer(id)
 {
	 window.open('openCustomer.htm?id='+id,'_self',false);
 }
 */ 
/*  function deleteCustomer(id)
 {
	 if (confirm('Are you sure you want to delete customer ?')) 
	 { 
		  var form = document.getElementById("searchCustomerForm");
		  var custId = document.getElementById("custID");
		  custId.value  = id;
		  form.action = 'deleteCustomer.htm';
	 }
 }
 */
</script>

<html>
<head>
    <title>Choose Customer</title>
</head>

<body>


<form:form method="post" action="pickerCustomer.htm" commandName="searchCustomerCriteria" id="searchCustomerForm">
 	
 	 	<table class="">
	 		<tr>
	 			<td>
				    <table class="">
					    <tr>
					        <td><form:label path="firstName">First Name</form:label></td>
					        <td><form:input path="firstName" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="lastName">Last Name</form:label></td>
					        <td><form:input path="lastName" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="city">City</form:label></td>
					        <td><form:input path="city" /></td>
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
					   			<!-- <td class="colOpen">Select</td> -->
					   			<td class="colName">Name</td>
					   			<td class="col3">Phone</td>
					   			<td class="col4">DueDate</td>
					   			<td class="col5">AmountDue</td>
					   			<td class="col6">Active</td>
					   			<td class="colDelete">Select</td>
				   		</tr>		
				    	<c:forEach items="${customerList}" var="customer">
			    		  <tr>
 								<%-- <td class="colOpen"><input type="button" value="open" onclick="openCustomer(${customer.customerID})"/></td> --%>
 								<td class="colName"><c:out value="${customer.firstName} ${customer.lastName}"/></td>
 								<td class="col3"><c:out value="${customer.phone}"/></td>
				    		  	<td class="col4"><c:out value="${customer.paymentDueDate}"/></td>
				    		  	<td class="col5"><c:out value="${customer.amountDue}"/></td>
				    		  	<td class="col6"><c:out value="${customer.active}"/></td>
				    		  	<td class="colDelete"><input type="submit" value="select" onClick="selectCustomer(${customer.customerID})"></td>
				    		  	
				    		  	
						 </tr>							    		  	
			    		</c:forEach>
						 				 
					</table>  
	 			</td>
	 		</tr>
     
      		
     </table>
</form:form>
</body>
</html>