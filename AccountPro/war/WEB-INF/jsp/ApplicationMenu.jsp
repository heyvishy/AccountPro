<%-- <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>

<style type="text/css">
<%@ include file="../css/global.css" %>
</style>

<html>
<body>

<%-- <form:form method="post" action="mainMenu.htm" commandName="mainMenu">
 --%>

<table >
		 <tr>
			 <td>
				 <div id="navigation">
				        <ul>
				            <li>
				            <a href="#">Customer</a>
				                <ul>
				                      <li><a href="addCustomer.htm">Add Customer</a></li>
				                      <li><a href="listCustomers.htm">Search Customer</a></li>
				                </ul>
				            </li>
				            
				            <li>
				            <a href="#">Policy</a>
				                <ul>
				                      <li><a href="addPolicy.htm">Add Policy</a></li>
				                      <li><a href="#">Look up Policy</a></li>
				                </ul>            
				            </li>
				            
				        </ul>    
				
				</div>
			 </td>
		 </tr>
 
	</table>	     
<%-- </form:form> --%>
</body>
</html>