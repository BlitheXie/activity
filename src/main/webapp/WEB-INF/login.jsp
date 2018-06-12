<%--
  Created by IntelliJ IDEA.
  User: Blithe_Xie
  Date: 2018/6/10
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>登陆</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/i/app-icon72x72@2x.png">
    <link rel="stylesheet" href="/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="/assets/css/app.css">
    <script src="/assets/js/jquery.min.js"></script>

</head>
<body data-type="login" class="theme-white">

<div class="am-g tpl-g">
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-logo">

            </div>
            <form id="form" method="post" action="/index.html" class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input name="number" type="text" class="tpl-form-input" id="user-name" minlength="12" placeholder="请输入学号">
                </div>
                <div class="am-form-group">
                    <input name="password" type="password" class="tpl-form-input" id="user-password" minlength="6" placeholder="请输入密码">
                </div>
                <div class="am-form-group tpl-login-remember-me">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">
                        记住密码
                    </label>

                </div>
                <div class="am-form-group">

                    <button id="btn_login" type="button"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn"
                            <%--data-am-modal="{target: '#my-alert'}--%>">提交
                    </button>
                </div>
                <!-- 弹出信息 -->
                <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
                    <div class="am-modal-dialog">
                        <div class="am-modal-hd">课余活动交流</div>
                        <div class="am-modal-bd">
                            <span id="login_advice">登陆成功！</span>
                        </div>
                        <div class="am-modal-footer">
                            <span class="am-modal-btn">确定</span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


</div>
<script src="/assets/js/amazeui.min.js"></script>
<script src="/assets/js/app.js"></script>
<script src="/assets/js/login.js"></script>
</body>

</html>