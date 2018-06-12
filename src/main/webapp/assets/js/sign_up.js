
function checkPassword(){
	if($("#password2").val() == $("#password1").val()){
		$("#password2 + small").text("密码一致").css("color","green");
		return true;
	}else{
		$("#password2 + small").text("密码不一致").css("color","red");
		return false;
	}
}
var url = "http://"+window.location.host+"/checknumber.html";
$("#number").blur(function () {
    var bool = false;
	$.get(url,{number:$(this).val()},function (data) {
        if(data == 1){
            $("#number_text").text("该学号已存在").css('color','red');
        }else{
            if($("#number").val().trim() == "")
                $("#number_text").text("请输入学号").css('color','red');
            else{
                $("#number_text").text("学号可用").css('color','green');
                bool = true;
            }
        }
    if(bool){
            $("#submit").removeClass("am-disabled");
    }else{
        $("#submit").addClass("am-disabled");
    }
    });
});
$("#password2").blur(checkPassword);

$("#submit").click(function(){
	$.get(url,data,function(){
		
	})
    var number = $("number").val();
	var name = $("#user-name").val();
	var password = $("#password2").val();
	if(checkPassword()){

    }

});