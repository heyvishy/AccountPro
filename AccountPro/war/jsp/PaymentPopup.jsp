<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">

	function selectCustomer(name,id){
 		window.opener.document.getElementById("customerID").value = id;
		window.close();
	}
	
</script>

<html>
<head>

	<!-- Disables back button -->
		<script type = "text/javascript" >
	    function preventBack(){window.history.forward();}
	    setTimeout("preventBack()", 0);
	    window.onunload=function(){null};
	</script>

    <title>Choose Customer</title>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
	<link href="css/ListCustomer.css" rel="stylesheet" type="text/css"/>
</head>

<body>


<form:form method="post" action="paymentpopup.htm" commandName="payment" >
 	
 	 	<table class="">
	 		<tr>
	 			<td>
				    <table class="">
<%-- 					    <tr>
					        <td><form:label >Customer Name</form:label></td>
					        <td><form:input  /></td>
					    </tr>
 --%>
					    <tr>
					        <td><form:label path="policyId">Policy ID</form:label></td>
					        <td><form:input path="policyId" /></td>
					    </tr>
					    <tr>
<%-- 					        <td><form:label path="">Balance Due</form:label></td>
					        <td><form:input path="" /></td>
 --%>					        
 							<td><label for="balanceDue">Balance Due</label></td>
 							<td><input type="text" value="100.00" disabled="disabled"></td>
					    </tr>

					    <tr>
					        <td><form:label path="paymentAmount">Payment Amount</form:label></td>
					        <td><form:input path="paymentAmount" /></td>
					    </tr>
					    
					    <tr>
							<td><input type="submit" value="Pay"/></td>
					        <td><input type="reset" value="Reset" /></td>
					    </tr>
						 				 
					</table>  
	 			</td>
	 		</tr>
     
      		
     </table>
</form:form>
</body>
</html>