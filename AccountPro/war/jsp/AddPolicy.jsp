<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/jsp/include.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
		  $("#datepicker").datepicker();
		});
	</script>
	    
	<script type="text/javascript">

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

	</script>

<html>	
<head>
    <title>Add Policy</title>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<form:form method="post" action="addPolicy.htm" commandName="policy" id="policyForm">
 	
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
			        <td><form:input path="cardNumber"/></td>
			        <td><form:errors path="cardNumber" cssClass="error" /></td>
				</tr>
			    <tr>
			        <%-- <td><form:label path="policyNumber">Policy Number</form:label></td> --%>
			        <td><form:label path="policyNumber">Account Number</form:label></td>
			        <td><form:input path="policyNumber"/></td>
			        <td><form:errors path="policyNumber" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="policyAmount">Policy Amount</form:label></td>
			        <td><form:input path="policyAmount" /></td>
			        <td><form:errors path="policyAmount" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="startDate">Start Date </form:label></td>
			        <td><form:input type="text" readonly="true" id="sDate" path="startDate"/></td>
			        <td><input type="button" value="Pick Dates" onclick="chooseDate()"/></td>
					<td><form:errors path="startDate" cssClass="error" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="endDate">End Date </form:label></td>
			        <td><form:input type="text" id="eDate" readonly="true" path="endDate" /></td>
			        <td><form:errors path="endDate" cssClass="error" /></td>
			    </tr>
				
				<tr>
					<td><form:hidden path="policyID" value="${policy.policyID}"/></td>
				</tr>
				
			    <tr>
					 <c:choose>
					 	<c:when test="${policy.policyID gt 0}">
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
			    </tr>
			
			</table>  
 		</td>
 	</tr>
</table> 	
     
</form:form>
</body>
</html>