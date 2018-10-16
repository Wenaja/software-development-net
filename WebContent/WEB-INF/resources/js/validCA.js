function checkUserName(){
	var username = document.getElementById("login_form:txt_username").value;
	alert("Function Ok!");
	if(username == ""){
		alert("Benutzername darf nicht leer sein");
		return false;
	}
	
	return true;
}
