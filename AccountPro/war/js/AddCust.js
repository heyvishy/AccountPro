function updateCustomer(){
     var form = document.getElementById("CustomerForm");
     form.action = 'updateCustomer.htm';
 }
 
 function addPolicy(id)
 {
	// alert("addPolicy for customerID "+id);
	 window.open('addPolicyForCustomer.htm?id='+id,'_self',false);
 }