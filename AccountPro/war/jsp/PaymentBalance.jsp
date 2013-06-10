<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script type="text/javascript">
	
	 function radioSelect(){
		 alert("hi");
	 }
</script>

<html>

<head>
    <title>Policy Payment Balance </title>
    
	<!-- Disables back button -->
		<script type = "text/javascript" >
	    function preventBack(){window.history.forward();}
	    setTimeout("preventBack()", 0);
	    window.onunload=function(){null};
	</script>
    
	
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
	<link href="css/ListCustomer.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<form:form method="post" action="policyPayment.htm" commandName="balanceDue" >
 	
 	 	<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
 		</tr>
 	
 	 	<table class="tblParent">
			<tr>
				<td class="Heading" >Policy Balances</td>
			</tr> 	
	 		<tr>
	 			<td>
				    <table class="tblChild">
					
			     		<tr>
					   			<td class="colDelete">Select</td>
					   			<td class="colName">Customer Name</td>
					   			<td class="col3">PolicyID</td>
					   			<td class="col4">Policy Payment Due</td>
 								<td class="colDelete">Payment</td>
				   		</tr>		
				    	<c:forEach items="${balanceDues}" var="balanceDue">
			    		  <tr>
 								<td class="colDelete"><input type="radio" name="customergroup" onclick="radioSelect()" ></td>
 								<td class="colName"><c:out value="${balanceDue.customerName}"/></td>
 								<td class="col3"><c:out value="${balanceDue.policyId}"/></td>
				    		  	<td class="col4"><c:out value="${balanceDue.paymentDue}"/></td>
				    		  	<td class="colDelete"><input type="submit" value="Pay" onClick=""></td>
						 </tr>							    		  	
			    		</c:forEach>
						 				 
					</table>  
	 			</td>
	 		</tr>
     
     </table>
</form:form>
</body>
</html>