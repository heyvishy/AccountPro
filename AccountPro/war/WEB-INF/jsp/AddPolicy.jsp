<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

  <script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });
  </script>


<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>
</style>
<script type="text/javascript">
	
	function chooseDate()
	{
		//alert("date"); 
		window.open('pickerDate.htm','datepicker','resizable=no,height=400,width=600');
	}

	function chooseCustomer(){
		window.open('pickerCustomer.htm','choosecustomer','resizable=no,height=400,width=600');
 	}
	
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
								<td><input id="chooseCustomer" type="button" value="choose" onclick="chooseCustomer()"/></td>
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
			        <td><form:input type="text" readonly="true" id="sDate" path="startDate"/></td>
			        <td><form:errors path="startDate" cssClass="error" /></td>
			        
			        <td><input type="button" value="Pick Dates" onclick="chooseDate()"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="endDate">End Date  (Format DD-MM-YYYY e.g 01-01-2012)</form:label></td>
			        <td><form:input type="text" id="eDate" readonly="true" path="endDate" /></td>
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