<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<style type="text/css">
<%@ include file="../css/error.css" %>
<%@ include file="../css/global.css" %>


.col1	 	{width:10%;;background-Color:#D4D0C9;border:1px solid ;}
.col2	 	{width:15%;;background-Color:#D4D0C9;border:1px solid ;}
.col3	 	{width:20%;;background-Color:#D4D0C9;border:1px solid ;}
.col4	 	{width:25%;;background-Color:#D4D0C9;border:1px solid ;}
.col5	 	{width:10%;height:10%;background-Color:#D4D0C9;border:1px solid ;}
.col6	 	{width:10%;height:10%;background-Color:#D4D0C9;border:1px solid ;}
.col7	 	{width:10%;height:5%;background-Color:#D4D0C9;border:1px solid ;}

</style>


<html>
<head>
    <title>Search Policy</title>
</head>

<body>


<form:form method="post" action="searchPolicy.htm" commandName="policy">
 	
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
<%-- 					    <tr>
					        <td><form:label path="lastName">Last Name</form:label></td>
					        <td><form:input path="lastName" /></td>
					        <td><form:errors path="lastName" cssClass="error" /></td>
					    </tr>
					    <tr>
					        <td><form:label path="city">City</form:label></td>
					        <td><form:input path="city" /></td>
					        <td><form:errors path="city" cssClass="error" /></td>
					    </tr>
 --%>					    <tr>
							<td><input type="submit" value="Search"/></td>
					        <td><input type="reset" value="Reset" /></td>
					    </tr>
					
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
					   			<td class="col1">Policy_Id</td>
					   			<td class="col2">CustomerID</td>
					   			<td class="col3">PolicyType</td>
					   			<td class="col4">PolicyNumber</td>
					   			<td class="col5">PolicyAmount</td>
					   			<td class="col6">StartDate</td>
					   			<td class="col7">EndDate</td>
				   		</tr>		
				    	<c:forEach items="${policies}" var="policy">
			    		  <tr>
			 	    		  	<td class="col1"><c:out value="${policy.policyID}"/></td>  
				    		  	<td class="col2"><c:out value="${policy.customerId}"/></td>
				    		  	<td class="col3"><c:out value="${policy.policyType}"/></td>
				    		  	<td class="col4"><c:out value="${policy.policyNumber}"/></td>
				    		  	<td class="col5"><c:out value="${policy.policyAmount}"/></td>
				    		  	<td class="col6"><c:out value="${policy.startDate}"/></td>
				    		  	<td class="col7"><c:out value="${policy.endDate}"/></td>
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