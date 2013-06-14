<!DOCTYPE html>
<html>
	<head>
	
		<!-- Disables back button -->
	   	<script type = "text/javascript" >
		    function preventBack(){window.history.forward();}
		    setTimeout("preventBack()", 0);
		    window.onunload=function(){null};
		</script>
		
		<link href="css/navigation.css" rel="stylesheet" type="text/css"/>
		<link href="css/global.css" rel="stylesheet" type="text/css"/>
	</head>

	<body>
		<table class="tblNav">
				<tr>
					<td>
							<ul>
								<li>
									<a href="searchCustomer.htm">Customer</a>
					 	                <ul>
						                      <li><a href="addCustomer.htm">Add</a></li>
						                      <!-- <li><a href="listCustomers.htm">Search </a></li> -->
						                      <!-- <li><a href="searchCustomer.htm">Search </a></li> -->
						                      <li><a href="searchCustomer.htm">Manage</a></li>
						                      
						                </ul>
					 			</li>
								<li>
									<a href="searchPolicy.htm">Policy</a>
					 	                <ul>
						                      <li><a href="addPolicy.htm">Add</a></li>
						                      <!-- <li><a href="searchPolicy.htm">Search </a></li> -->
						                      <li><a href="searchPolicy.htm">Manage</a></li>
						                </ul>
								</li>
								<li>
									<a href="balance.htm">Payment</a>
								</li>

								<li>
									<a href="report.htm">Report</a>
								</li>
								<li>
									<a href="support.htm">Contact</a>
								</li>
									

<!--							<li>
									<a href="#">About</a>
								</li>
 -->
 							</ul>
					</td>
					<td align="right"><a href="login.htm">Sign out</a></td>
				</tr>
		</table>
	</body>
</html>

