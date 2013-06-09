<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/jsp/include.jsp" %>

	<script type="text/javascript">

		function printReport()
		{
			window.print();
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
	
		<title>Policy Report</title>
		<link href="css/global.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
		<form:form method="post" action="report.htm" commandName="">
	 		<tr>
	 			<td><%@ include file="../jsp/Navigation.jsp" %></td>
	 		</tr>
		
		<table class="tblParent">
			
			<tr>
				<td>
					<table class="tblChild">
							<tr>
								<td>
									This is policy report
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" name="printbutton" value="Print" onclick="printReport()"/>
								</td>
							</tr>
					</table>
				</td>
			</tr>		
		
		</table>
	 
		
	 	</form:form> 
	</body>
		
</html>