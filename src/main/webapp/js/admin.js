$(function(){
    var url = "http://"+window.location.host+"/updateusermessage.html";
    $(".admin_content_item").css('display','none');
    $(".admin_content_user_message").show();
    var pc = new PhotoClip('#clipArea', {
        size: 260,
        outputSize: 640,
        //adaptive: ['60%', '80%'],
        outputType:'jpg',
        file: '#file',
        view: '#view',
        ok: '#clipBtn'
    });
    var modal = $("#doc-modal-1");
    var clipImg = "";
    var username = $("#user_message_name").html();
    /*图片裁切完后*/
    $("#clipBtn").click(function(){
        modal.modal('close');
        clipImg = pc.clip();
        console.log(clipImg);
    });

    $("#nav_user_message").click(function(){
        $(".am-nav li").removeClass("am-active");
        $(".admin_content_item").css('display','none');
        $(this).addClass("am-active");
        $(".admin_content_user_message").show();
    });

    /*activity*/
    $("#nav_activity").click(function(){
        $(".am-nav li").removeClass("am-active");
        $(".admin_content_item").css('display','none');
        $(this).addClass("am-active");
        $(".admin_content_activity").show();
    });
    $("#nav_comment").click(function(){
        $(".am-nav li").removeClass("am-active");
        $(".admin_content_item").css('display','none');
        $(this).addClass("am-active");
        $(".admin_content_comment").show();
    });
    /*提交保存信息*/
    $("#save_user_message").click(function () {
        if(clipImg != "")
            var value = clipImg.split(",");
        else{
            var value = [0,0];
        }

        var gender = $('input[name="gender"]:checked ').val();
        $.post(url,{header:value[1],username:username,gender:gender},function (data) {

        },false);
        window.location.replace("http://"+window.location.host+"/admin.html");
    });

    $(function() {
        $('#doc-prompt-toggle').on('click', function() {
            $('#my-prompt').modal({
                relatedTarget: this,
                onConfirm: function(e) {
                    username = e.data;
                    $("#user_message_name").html(username);
                    /*alert('你输入的是：' + e.data || '')*/
                },
                onCancel: function(e) {
                    /*alert('不想说!');*/
                }
            });
        });
    });
});