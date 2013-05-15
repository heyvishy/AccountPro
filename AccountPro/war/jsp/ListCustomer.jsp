<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<style type="text/css">
<%@ include file="../css/ListCustomer.css" %>

/* .tblParenting   {width:100%;height:100%;background-Color:#D4D0C9;border-style: groove}
.tblChilding   {background-Color:#D4D0C9;width:50%;position:relative;margin-left:25%;margin-bottom:25%; border: thick; border-style: groove; }
 */ 
 
</style>

<head>
    <title>List of all Customers</title>
</head>
<body>

<form:form  commandName="customerList">
 
  	<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
    </tr>
<!--  	<tr>
		<td class="Head >List Customers</td>
	</tr> 	
 -->	<tr>
		<td><form:errors path="*" cssClass="errorblock" element="div" /></td>
	</tr> 	
 
    <table class="tblParent">
     		<tr>	
     			<td class="Heading"> List Customers</td>
     		</tr>
     		<tr>
     			<td>
     				<table class="tblChild">
     		<tr>
    			<td class="col1">FirstName</td>
    			<td class="col2">LastName</td>
    			<td class="col3">Phone</td>
    			<td class="col4">DueDate</td>
    			<td class="col5">AmountDue</td>
    			<td class="col6">Active</td>
    		</tr>		
	    	<c:forEach items="${customerList}" var="customer">
    		  <tr>
 	    		  	<td class="col1"><c:out value="${customer.firstName}"/></td>  
	    		  	<td class="col2"><c:out value="${customer.lastName}"/></td>
	    		  	<td class="col3"><c:out value="${customer.phone}"/></td>
	    		  	<td class="col4"><c:out value="${customer.paymentDueDate}"/></td>
	    		  	<td class="col5"><c:out value="${customer.amountDue}"/></td>
	    		  	<td class="col6"><c:out value="${customer.active}"/></td>
			 </tr>							    		  	
    		</c:forEach>
     				
     				</table>
     			</td>
     		</tr>
	 </table>	 
		    
</form:form>
</body>
</html>