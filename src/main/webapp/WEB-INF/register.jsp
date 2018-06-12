<%--
  Created by IntelliJ IDEA.
  User: Blithe_Xie
  Date: 2018/6/11
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册一个你的账号</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>

</head>

<body data-type="login" class="theme-white">
<script src="assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
    </div>
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-title">注册用户</div>
            <span class="tpl-login-content-info">
                  创建一个新的用户
              </span>


            <form method="post" action="#" id="#form" class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input name="number" type="number" pattern="^\d{12}$" title="学号为12位" class="tpl-form-input" id="number" placeholder="学号">
                    <small class="check" id="number_text" style="color : red;"></small>
                </div>

                <div class="am-form-group">
                    <input id="name" name="name" type="text" class="tpl-form-input" placeholder="姓名">
                </div>

                <div class="am-form-group">
                    <input  name="password" id="password1" id="doc-vld-pwd-1" pattern="^\d{6,12}" required="required" type="password" class="tpl-form-input" title="密码至少6位" placeholder="请输入密码">
                </div>

                <div class="am-form-group">
                    <input id="password2" data-equal-to="#doc-vld-pwd-1" type="password" class="tpl-form-input" id="user-name" placeholder="再次输入密码">
                    <small class="check" style="color : red;"></small>
                </div>

                <div class="am-form-group">
                    <button id="submit" type="submit" class="am-disabled am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="assets/js/sign_up.js"></script>

</body>

</html>