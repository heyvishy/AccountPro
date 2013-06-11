<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script type="text/javascript">
	
	
	 function findSelection(id) {
		 var selPayButtonId = "paybutton"+id;
		 var radios = document.getElementsByName('customerRadio');
		 //disable all pay buttons by default
		 for (var i = 0, length = radios.length; i < length; i++) {
			 var paybuttonId = "paybutton"+i;
			 document.getElementById(paybuttonId).disabled="disabled";
		 }
		 //enable only pay button, for which radio button is selected
		 document.getElementById(selPayButtonId).disabled="";
	 }
	 
	 function radioSelect(id){
		 //alert(id);
		 var paybuttonId = "paybutton"+id;
		 //alert("buttonId = "+buttonId);
		 //document.getElementById(buttonId).disabled="";
		 
		 findSelection(id);
	 }
	 
	 function onPayClick(name,policyid,paydue){
		 //alert("pay");
		 alert("name :"+name+" policyid :"+policyid+" paydue :"+paydue);
		 window.open('paymentpopup.htm','payment','resizable=no,height=400,width=600');
		 
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
				<td class="Heading">Policy Balances</td>
			</tr> 	
	 		<tr>
	 			<td>
				    <table class="tblChild">
					
			     		<tr>
					   			<!-- <td class="colDelete">Select</td> -->
					   			<td class="colName">Customer Name</td>
					   			<td class="col3">PolicyID</td>
					   			<td class="col4">Policy Payment Due</td>
 								<td class="colDelete">Payment</td>
				   		</tr>		
				    	<c:forEach items="${balanceDues}" var="balanceDue" varStatus="row">
				    	  <%-- <c:out value="${row.index}"></c:out> --%>
				    	  <%-- <c:set var="name" value="payButton${row.index}"/> --%>
				    	  <%-- <c:out value="${name}"/> --%>
			    		  <tr>
 								<%-- <td class="colDelete"><input id="radio${row.index}" type="radio" name="customerRadio" onclick="radioSelect('${row.index}')" ></td> --%>
 								<td class="colName"><c:out value="${balanceDue.customerName}"/></td>
 								<td class="col3"><c:out value="${balanceDue.policyId}"/></td>
				    		  	<td class="col4"><c:out value="${balanceDue.paymentDue}"/></td>
				    		  	<td class="colDelete"><input id= "paybutton${row.index}" type="submit" value="Pay" 
				    		  	onClick="onPayClick('${balanceDue.customerName}','${balanceDue.policyId}','${balanceDue.paymentDue}')"></td>
						 </tr>							    		  	
			    		</c:forEach>
						 				 '
					</table>  
	 			</td>
	 		</tr>
     
     </table>
</form:form>
</body>
</html>