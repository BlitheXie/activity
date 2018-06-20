<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="cn.activity.domain.Share" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.activity.domain.UserSign" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Blithe_Xie
  Date: 2018/6/12
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    String username = "";
    String id = "";
    if(session.getAttribute("userName") != null){
        id = session.getAttribute("id").toString();
        username = session.getAttribute("userName").toString();
    }

    List<UserSign> activitySignList = (List<UserSign>) request.getAttribute("activity");
    if (activitySignList == null)
        activitySignList = new ArrayList<>();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/i/app.png">
    <!--Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="images/i/app.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">
    <link rel="icon" type="image/png" href="images/i/favicon.png">
    <link rel="stylesheet" href="assets/css/amazeui.css">
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="js/public.js"></script>
    <script src="js/admin.js"></script>
    <script src="js/hammer.min.js"></script>
    <script src="js/iscroll-zoom-min.js"></script>
    <script src="js/lrz.all.bundle.js"></script>
    <script src="js/PhotoClip.js"></script>
</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="#">课余活动信息后台</a>
        </h1>
        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <div id="user_message">
                <div class="am-topbar-right">
                    <span id="user_name"><%=username%></span>
                </div>
                <div class="am-topbar-right">
                    <img class="am-circle" src="user/<%=id%>.jpg" height="50">
                </div>
            </div>
        </div>
    </div>
</header>
<!-- admin_main -->
<div id="admin_main">
    <div id="nav">
        <ul class="am-nav ">
            <li class="am-active" id="nav_user_message"><a href="javascript:(0)">个人信息</a></li>
            <li id="nav_activity" ><a href="javascript:(0)">我的活动</a></li>
            <li id="nav_comment" ><a href="javascript:(0)">我的评论</a></li>
            <li id="nav_share"><a href="javascript:(0)">我的分享</a></li>
            <li id="nav_help"><a href="javascript:(0)">我的求助</a></li>
            <li id="nav_answer"><a href="javascript:(0)">我的回答</a></li>
            <li id="nav_logo_out"><a href="javascript:(0)">退出</a></li>
        </ul>
    </div>
    <div class="admin_content">
        <div class="admin_content_item admin_content_user_message">
            <h1>个人信息</h1>
            <hr>
            <form>
                <div id="view" class="admin_head" style='background-image: url("user/<%=id%>.jpg")'>
                    <!-- <a href="javascript:void(0)" data-am-modal="{target: '#doc-modal-1'}"><img class="am-radius" alt="140*140" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/1000/h/1000/q/80" width="140" height="140" /></a> -->

                </div>
                <a href="javascript:void(0)" data-am-modal="{target: '#doc-modal-1'}">[修改头像]</a>
                <div class="admin_content_main">
                    <div class="am-g">
                        <div class="am-u-sm-5">学号:</div>
                        <div class="am-u-sm-5"><%=session.getAttribute("studentNumber")%></div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">用户名:</div>
                        <div class="am-u-sm-5"><span id="user_message_name"><%=session.getAttribute("userName")%></span> <a id="doc-prompt-toggle" href="javascript: void(0)">修改</a></div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">性别:</div>
                        <div class="am-u-sm-5">
                            <%
                                Object userGender = session.getAttribute("userGender");
                                boolean hasGender = false;
                                if(userGender != null)
                                    hasGender = true;
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            %>
                            <input id="gender_man" <%if(hasGender && userGender.toString().equals("男")){%> checked="checked" <%}%>type="radio" name="gender" value="男">
                            <label>男</label>
                            <input id="gender_woman" <%if(hasGender && userGender.toString().equals("女")){%> checked="checked" <%}%> type="radio" name="gender" value="女">
                            <label>女</label>

                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">创建时间:</div>
                        <div class="am-u-sm-5"><%=formatter.format(session.getAttribute("createTime"))%></div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5">&nbsp;</div>
                        <div class="am-u-sm-5"></div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-5"><button id="save_user_message" type="button" class="am-btn am-btn-danger">保存</button></div>
                        <div class="am-u-sm-5"></div>
                    </div>
                </div>
            </form>
            <!-- 裁切图片 -->
            <div class="am-popup" tabindex="-1" id="doc-modal-1">
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">请选择图片
                        <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                    </div>
                    <div class="am-modal-bd">
                        <div id="clipArea"></div>
                        <input type="file" id="file" />
                        <button class="am-btn am-btn-danger"  id="clipBtn">ok</button>
                    </div>
                </div>
            </div>

            <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
                <div class="am-modal-dialog">
                    <div class="am-modal-bd">
                        输入要改的用户名
                        <input type="text" class="am-modal-prompt-input">
                    </div>
                    <div class="am-modal-footer">
                        <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                        <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                    </div>
                </div>
            </div>
        </div>


        <!-- activity -->
        <div class="admin_content_item admin_content_activity">
            <h1>我的活动</h1>
            <hr>
            <div class="activity_content">
                <table class="am-table am-table-bordered am-table-striped am-table-compact">
                    <thead>
                    <tr>
                        <th>活动名称</th>
                        <th>报名时间</th>
                        <th>取消报名</th>
                    </tr>
                    </thead>
                    <tbody>

                   <%-- <tr class="am-active">
                        <td>Amaze UI(Active)</td>
                        <td>Amaze UI(Active)</td>
                        <td>http://amazeui.org</td>
                        <td><button actid="1" type="button"
                                    class="cancel_act am-btn am-btn-warning"
                                    id="doc-confirm-toggle" href="">取消</button></td>
                    </tr>--%>
                   <%
                       Format fm = new SimpleDateFormat("yyyy-MM-dd");
                        for (int i=0;i<activitySignList.size();i++){
                            UserSign us = activitySignList.get(i);
                   %>
                   <tr>
                        <td><a href="activityitem?id=<%=us.getActivityId()%>"><%=us.getActivityName()%></a></td>
                        <td><%=fm.format(us.getCreateTime())%></td>
                        <td><button actid="<%=us.getActivityId()%>" type="button"
                                    class="cancel_act am-btn am-btn-warning"
                                    id="doc-confirm-toggle" href="">取消</button></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                    <div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
                        <div class="am-modal-dialog">
                            <div class="am-modal-hd">
                                Amaze UI
                            </div>
                            <div class="am-modal-bd">
                                你，确定要删除这条记录吗？
                            </div>
                            <div class="am-modal-footer">
                                <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                                <span class="am-modal-btn" data-am-modal-confirm>确定</span>
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $(function() {
                            $(".cancel_act").
                            on('click', function() {
                                var actid = $(this).attr("actid");
                                $('#my-confirm').modal({
                                    relatedTarget: this,
                                    onConfirm: function(options) {
                                        var $link = $(this.relatedTarget).prev('a');
                                        var msg = $link.length ? '你要删除的链接 ID 为 ' + $link.data('id') :
                                            '确定了，但不知道要整哪样';
                                        alert(actid);
                                        window.location.replace("http://"+window.location.host+"/admin.html");
                                        $.post(
                                            "/deleteUserSign.html",{activityid:actid,userid:<%=id%>},function (data) {
                                                alert(data)
                                            }
                                        );
                                    }, onCancel: function() {
                                        alert('算求，不弄了');
                                    }
                                });
                            });
                        });
                    </script>
                </table>
            </div>
        </div>

        <!-- comment -->
        <div class="admin_content_item admin_content_comment">
            <h1>我的评论</h1>
            <hr>
            <div class="comment_content">

            </div>
        </div>





    </div>

</div>
</body>
</html>
