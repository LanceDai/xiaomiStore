<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米商城-个人中心</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
    <link rel="stylesheet" type="text/css" href="../static/css/coupon.css">
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="dingdanzhongxin.jsp">我的订单</a></div>
            <div class="fr">
                <ul>
                    <li><a href="#top">消息通知</a></li>
                    <li><a href="">我的订单</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->
<!-- start banner_x -->
<div class="banner_x center">
    <a href="index.jsp" target="_blank">
        <div class="logo fl"></div>
    </a>
    <a href="">
        <div class="ad_top fl"></div>
    </a>
    <div class="nav fl">
        <ul>
            <li><a href="">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->
<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><span class="subddzx-a"><a href="">我的订单</a></span></li>
                    <li><span class="subddzx-a"><a href="">意外保</a></span></li>
                    <li><span class="subddzx-a"><a href="">评价晒单</a></span></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><span class="subddzx-a"><a href="/selfInfo/">我的个人中心</a></span></li>
                    <li><span class="subddzx-a"><a href="/selfInfo/attention">我的关注</a></span></li>
                    <li><span class="subddzx-a"><a href="/selfInfo/coupon">优惠券</a></span>
                    </li>
                    <li><span class="subddzx-a"><a style="color:#ff6700;font-weight: bold;"
                                                   href="javascript:;">修改密码</a></span></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">
                <span>修改密码</span>
            </div>
            <div>
                <div class="username">
                    原密码:&nbsp;
                    <input class="shurukuang" type="password" name="password" id="password" placeholder="请输入你的原密码"/>
                </div>
                <div class="username">
                    新密码:&nbsp;
                    <input class="shurukuang" type="password" name="password" id="new-password" placeholder="请输入你的新密码"/>
                </div>
                <input id="update-password" type="submit" style="float:right; margin-right: 30px; background: #1E9FFF"
                       value="保存">
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- self_info -->

<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>


<script src="../static/js/jquery.min.js"></script>
<script>
    $("#update-password").on("click", function (event) {
        event.preventDefault();
        var password = $("#password").val();
        if (password === null || password === ""){
            alert("请输入旧密码");
            return;
        }
        var newPassword = $("#new-password").val();
        if (newPassword=== null || newPassword === ""){
            alert("请输入新密码");
            return;
        }
        $.ajax({
            type: 'POST',
            url: "/selfInfo/resetPassword/update",
            data: {
                'password': password,
                'newPassword': newPassword,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === "error") {
                    alert("原密码错误");
                } else if (data.msg === "success") {
                    alert("修改成功");
                    window.location.href = "/selfInfo/";
                }
            },
            error: function () {
                alert("修改异常");//写后台
            }
        });
    })
</script>
</body>
</html>