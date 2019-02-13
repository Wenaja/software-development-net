function encodeUserPwd(elem){
	var val = document.getElementById('login_form:user_password').value;
	
	document.getElementById('login_form:user_password').value = sha256(val);
}