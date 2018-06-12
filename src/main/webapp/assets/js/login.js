$("#btn_login").click(function(){
    var number = $("#user-name").val();
    var password = $("#user-password").val();
    var modal = $('#my-alert');
    var url = "http://"+window.location.host+"/checkPassword.html";
    $.post(url,{studentNumber:number,password:password},function (data) {
    	console.log(data);
            if(data == 1){
                $("#login_advice").html("登陆成功！");
            modal.modal();
            window.location.replace("http://"+window.location.host+"/main.html");
		}else{
            $("#login_advice").html("登陆失败！密码错误");
            modal.modal();
		}
    });
    //此处实现ajax逻辑

});