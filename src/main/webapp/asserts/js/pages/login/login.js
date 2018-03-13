function login(){
	debugger;
	$.ajax({
		url:"./rest/cesium/login",
		dataType:"json",
		data:{username:$("#username").val(),password:$("#password").val()}
	})
}