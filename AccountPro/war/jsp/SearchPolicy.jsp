<%@ include file="/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
 function openPolicy(id)
 {
	 //alert("openPolicy :"+id);
	 window.open('openPolicy.htm?id='+id,'_self',false);
 }
 
 function deletePolicy(id)
 {
	 //alert("DeletePolicy :"+id);
	 if (confirm('Are you sure you want to delete Policy ?')) 
	 { 
		  var form = document.getElementById("searchPolicyForm");
		  var policyId = document.getElementById("policyID");
		  policyId.value  = id;
		  form.action = 'deletePolicy.htm';
	 }
 }
</script>


<html>
<head>
    <title>Search Policy</title>
	<link href="css/error.css" rel="stylesheet" type="text/css"/>
	<link href="css/global.css" rel="stylesheet" type="text/css"/>
	<link href="css/SearchPolicy.css" rel="stylesheet" type="text/css"/>
</head>

<body>


<form:form method="post" action="searchPolicy.htm" commandName="SearchPolicyCriteria" id="searchPolicyForm">
 	
 	 	<tr>
 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
 		</tr>
 	
 	 	<table class="tblParent">
			<tr>
				<td class="Heading" >Search Policy</td>
			</tr> 	
	 		<tr>
	 			<td>
				    <table class="tblChild">
					    <tr>
					        <td><form:label path="policyType">Policy Type</form:label></td>
					        <td><form:input path="policyType" readonly="true" value="Recurring Deposit"/></td>
					    </tr>
 						<tr>
					        <td><form:label path="lastName">Last Name</form:label></td>
					        <td><form:input path="lastName" /></td>
					    </tr>
 						<tr>
					        <td><form:label path="firstName">First Name</form:label></td>
					        <td><form:input path="firstName" /></td>
					    </tr>

<%--					    <tr>
					        <td><form:label path="city">City</form:label></td>
					        <td><form:input path="city" /></td>
					        <td><form:errors path="city" cssClass="error" /></td>
					    </tr>
 --%>					    <tr>
							<td><input type="submit" value="Search"/></td>
					        <td><input type="reset" value="Reset" /></td>
					    </tr>
						<tr><td><form:hidden path="policyID" id="policyID"/></td></tr>
						
						<tr>
							<td>
								<table class="">
										<tr>
											<td><b>List Of Policies</b></td>
										</tr>
								</table>				
							</td>
						</tr>
			     		<tr>
					   			<!-- <td class="col1">Policy_Id</td> -->
					   			<td class="colOpen">Select</td>
					   			<td class="col2">CustomerName</td>
					   			<!-- <td class="col3">PolicyType</td> -->
					   			<td class="col4">Account Number</td>
					   			<td class="col5">PolicyAmount</td>
					   			<td class="col6">StartDate</td>
					   			<td class="col7">EndDate</td>
					   			<td class="colDelete">Delete</td>
				   		</tr>		
				    	<c:forEach items="${policies}" var="policy">
			    		  <tr>
			 	    		  	<%-- <td class="col1"><c:out value="${policy.policyID}"/></td> --%>  
				    		  	<td class="colOpen"><input type="button" value="open" onclick="openPolicy(${policy.policyID})"/></td>
				    		  	<td class="col2"><c:out value="${policy.customerName}"/></td>
				    		  	<%-- <td class="col3"><c:out value="${policy.policyType}"/></td> --%>
				    		  	<td class="col4"><c:out value="${policy.policyNumber}"/></td>
				    		  	<td class="col5"><c:out value="${policy.policyAmount}"/></td>
				    		  	<td class="col6"><c:out value="${policy.startDate}"/></td>
				    		  	<td class="col7"><c:out value="${policy.endDate}"/></td>
				    		  	<td class="colDelete"><input type="submit" value="Delete" onClick="deletePolicy(${policy.policyID})"></td>
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