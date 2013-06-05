<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/jsp/include.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
		  $("#datepicker").datepicker();
		});
	</script>
	
	    
	<script type="text/javascript">
		
		function disableFormFields() {
			//document.getElementById('customerID').readOnly =true;
			document.getElementById('cardNumber').disabled ='disabled';
			document.getElementById('policyNumber').disabled ='disabled';
			document.getElementById('policyAmount').disabled ='disabled';
			document.getElementById('sDate').disabled ='disabled';
			document.getElementById('eDate').disabled ='disabled';
		}
		
		function enableFormFields() {
			document.getElementById('customerID').disabled ='';
			document.getElementById('cardNumber').disabled ='';
			document.getElementById('policyNumber').disabled ='';
			document.getElementById('policyAmount').disabled ='';
			document.getElementById('sDate').disabled ='';
			document.getElementById('eDate').disabled ='';
		}
	
		function startPolicy(){
			//disableFormFields();
		    var form = document.getElementById("policyForm");
		    document.getElementById("policyStatusID").value=1;
		    form.action = 'updatePolicy.htm';
		    alert("Policy Started");
		    //disableFormFields();
		}
		
		function stopPolicy(){
			enableFormFields();
		    var form = document.getElementById("policyForm");
		    document.getElementById("policyStatusID").value=0;
		    form.action = 'updatePolicy.htm';
			alert("Policy Stopped");
		}
		
		function pickCustomer()
		{
			window.open('pickerCustomer.htm','customerpicker','resizable=no,height=400,width=600');
		}
		
		function chooseDate()
		{
			window.open('pickerDate.htm','datepicker','resizable=no,height=400,width=600');
		}
	
		function updatePolicy(){
		     var form = document.getElementById("policyForm");
		     form.action = 'updatePolicy.htm';
		}
		
		
		function validateDate(){
			var sDate = document.getElementById('sDate').value;
			//alert("sDate is : "+sDate);
			
			if(sDate==""){
				alert("Please choose a start date");
				return false;
			}
			var dateArray = sDate.split("/");
			
			//in JS, month starts from 0
			var month = dateArray[0]-1;
			var day = dateArray[1];
			var fullYear = dateArray[2];
			//alert("month "+month+ " day "+day+" fullYear "+fullYear);
			var startDate = new Date();
			startDate.setMonth(month);
			startDate.setDate(day);
			startDate.setFullYear(fullYear);
			//alert("startDate is now "+startDate);
			
			var today = new Date();
			if(today.getTime() > startDate.getTime()){
				alert("Please choose a future start date  !");
				return false;
			}
			
		}
		
		function validatePolicyAmount(){
			var amount = document.getElementById('policyAmount').value;
			if(amount < 50){
				alert("Please choose an amount greater than or equal to 50  !");
				return false;
			}
		}
		
		function validate_form(){
			//validate customerName 
			var customerId = document.getElementById('customerID').value;
			if(customerId == '0'){
				alert("Please choose a customer first !");
				return false;
			}
			
			validatePolicyAmount();
			
			return validateDate();
			
			
		}
		
	</script>
	
<!DOCTYPE html>
<html>	
<head>
    <title>Add Policy</title>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<form:form method="post" action="addPolicy.htm" commandName="policy" id="policyForm" onsubmit="return validate_form()">
 	
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
								</form:select>
								<td><input id="chooseCustomer" type="button" value="choose" onClick="pickCustomer()"/></td>
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
			        <td><form:label path="cardNumber">Card Number</form:label></td>
			        <td><form:input path="cardNumber" id="cardNumber" type="number"/></td>
			        <td><form:errors path="cardNumber" cssClass="error" /></td>
				</tr>
			    <tr>
			        <%-- <td><form:label path="policyNumber">Policy Number</form:label></td> --%>
			        <td><form:label path="policyNumber">Account Number</form:label></td>
			        <td><form:input path="policyNumber" id="policyNumber" type="number"/></td>
			        <td><form:errors path="policyNumber" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="policyAmount">Policy Amount</form:label></td>
			        <td><form:input path="policyAmount" id="policyAmount" type="number"/></td>
			        <td><form:errors path="policyAmount" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="startDate">Start Date </form:label></td>
			        <%-- <td><form:input type="date" id="sDate" path="startDate"/></td> --%>
 			        <td><form:input type="text" readonly="true" id="sDate" path="startDate"/></td>
			        <td><input type="button" value="Pick Dates" onclick="chooseDate()"/></td>
					<td><form:errors path="startDate" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="endDate">End Date </form:label></td>
			        <%-- <td><form:input type="date" id="eDate" path="endDate"/></td> --%>
			        <td><form:input type="text" id="eDate" readonly="true" path="endDate" /></td>
			        <td><form:errors path="endDate" cssClass="error" /></td>
			    </tr>
				
				<tr>
					<td><form:hidden path="policyID" value="${policy.policyID}"/></td>
				</tr>

 				<tr>
					<td><form:hidden path="policyStatusID" id="policyStatusID" /></td>
				</tr>
 				
			    <tr>
					 
					 <c:choose>
					 	<c:when test="${policy.policyID gt 0 }">
					        <td>
					            <input type="submit" value="Save" onClick="updatePolicy()"/>
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

					<!-- Once policy is saved, show the option to start/stop policy -->
					<c:choose>
						<c:when test="${policy.policyID gt 0 && policy.policyStatusID eq 0}">
					 		<td>
					 			<input type="submit" value="Start Policy" onclick="startPolicy()" />
					 		</td>
						</c:when>
						
						<c:when test="${policy.policyID gt 0 && policy.policyStatusID gt 0}">
					 		<td>
					 			<input type="submit" value="Stop Policy" onclick="stopPolicy()"/>
					 		</td>
						</c:when>
						<c:otherwise>
								<!-- Nothing -->
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