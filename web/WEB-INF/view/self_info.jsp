<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米商城-个人中心</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
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
    <a href="/" target="_self">
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
                <input type="text" class="shuru" placeholder="小米8&nbsp;小米MIX2S现货">
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
                    <li><span class="subddzx-a"><a href="javascript:"
                                                   style="color:#ff6700;font-weight: bold;">我的个人中心</a></span></li>
                    <li><span class="subddzx-a"><a href="/selfInfo/attention">我的关注</a></span></li>
                    <li><span class="subddzx-a"><a href="/selfInfo/coupon">优惠券</a></span></li>
                    <li><span class="subddzx-a"><a href="/selfInfo/resetPassword">修改密码</a></span></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">
                <span>我的资料</span>
                <span id="edit" style="float: right; margin-right: 50px;cursor: pointer">编辑</span>
            </div>
            <div class="subgrzl ml40"><span>昵称</span><span>${user.userName}</span></div>
            <div class="subgrzl ml40"><span>手机号</span><span>${user.telephoneNumber}</span></div>
            <div class="subgrzl ml40"><span>密码</span><span>************</span></div>
            <div class="subgrzl ml40"><span>个性签名</span><span>${user.sign}</span></div>
            <div class="subgrzl ml40"><span>我的爱好</span><span>${user.hobby}</span></div>
            <div class="subgrzl ml40"><span>收货地址</span><span>${user.address}</span></div>

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

<div class="mask-wrapper" style="display: none">
    <div class="mask-container">
    </div>

    <div class="info-container">
        <h4 class="title">个人资料编辑</h4>
        <span class="close"><a href=""><img src="../static/image/exit.png"
                                            style="width: 20px; height: 20px; margin-top:5px"></a></span>
        <div class="input-container">
				<span>
                    <p>昵称</p>
				</span>
            <input id="name" type="text">
        </div>
        <div class="input-container">
				<span>
                    <p>手机号</p>
				</span>
            <input id="phone" type="text">
        </div>
        <%--<div class="input-container">--%>
				<%--<span>--%>
                    <%--<p>密码</p>--%>
				<%--</span>--%>
            <%--<input id="password" type="text">--%>
        <%--</div>--%>
        <div class="input-container">
				<span>
                    <p>个性签名</p>
				</span>
            <input id="sign" type="text">
        </div>
        <div class="input-container">
				<span>
                    <p>爱好</p>
				</span>
            <input id="hobby" type="text">
        </div>
        <div class="input-container">
				<span>
                    <p>收货地址</p>
				</span>
            <input id="address" type="text">
        </div>
        <input id="update-submit" type="submit" style="float:right; margin-right: 30px; background: #1E9FFF" value="保存">
    </div>

</div>


<script src="../static/js/jquery.min.js"></script>
<script>
    $("#edit").on("click", function () {
        // e.preventDefault();
        $(".mask-wrapper").css("display", "block");
    });

    $(".close").on("click", function (e) {
        e.preventDefault();
        $(".mask-wrapper").css("display", "none");
    });

    $("#update-submit").on("click", function () {
        var name = $("#name").val();
        var phone = $("#phone").val();
        var password = $("#password").val();
        var sign = $("#sign").val();
        var hobby = $("#hobby").val();
        var address = $("#address").val();

        $.ajax({
            type: 'POST',
            url: "/selfInfo/update",
            data: {
                'username': name,
                'phone': phone,
                'password': password,
                'sign': sign,
                'hobby': hobby,
                'address': address
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === "success") {
                    alert("修改成功");
                    $(".mask-wrapper").css("display", "none");
                }
            },
            error: function () {
                // console.log(data.msg);
                alert("失败");
            }
        });
    })
</script>
</body>
</html>