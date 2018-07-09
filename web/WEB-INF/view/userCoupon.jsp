<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <a href="/" target="_blank">
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
                    <li><span class="subddzx-a"><a href="/selfInfo/">我的个人中心</a></span></li>
                    <li><span class="subddzx-a"><a href="/selfInfo/attention">我的关注</a></span></li>
                    <li><span class="subddzx-a"><a style="color:#ff6700;font-weight: bold;" href="javascript:;">优惠券</a></span>
                    </li>
                    <li><span class="subddzx-a"><a href="/selfInfo/resetPassword">修改密码</a></span></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">
                <span>我的优惠券</span>
            </div>
            <div>
                <ul class="filter-first tab-switch">
                    <li id="li-valid" class="tab-active" style="height: 20px;">有效</li>
                    <span>|</span>
                    <li id="li-invalid" style="height: 20px;">已失效</li>
                </ul>
            </div>
            <div id="valid" class="tab-content has-result" style="">
                <ul class="coupon-list clearfix">
                    <c:forEach items="${list}" var="coupon">
                        <c:choose>
                            <c:when test='${"1".equals(coupon.status)}'>
                                <li class="coupon-card coupon-card-cash coupon-card-expired">
                                    <div class="coupon-item">
                                        <div class="coupon-header"></div>
                                        <div class="coupon-content">
                                            <div class="item-value"><span class="value"
                                                                          style="font-size: 60px; font-weight: 200;">${coupon.price}</span>元
                                            </div>
                                            <div class="item-desc">${coupon.name}</div>
                                        </div>
                                        <div class="item-description"><p>${coupon.description}</p></div>
                                        <div class="coupon-footer">
                                            <div class="coupon-date">有效</div>
                                        </div>
                                    </div>
                                </li>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
            <div id="invalid" class="tab-content has-result" style="display: none">
                <ul class="coupon-list clearfix">
                    <c:forEach items="${list}" var="coupon">
                        <c:choose>
                            <c:when test='${"2".equals(coupon.status)}'>
                                <li class="coupon-card coupon-card-cash coupon-card-expired"
                                    style="background-color:#b0b0b0 ">
                                    <div class="coupon-item">
                                        <div class="coupon-header"></div>
                                        <div class="coupon-content">
                                            <div class="item-value"><span class="value"
                                                                          style="font-size: 60px; font-weight: 200;">${coupon.price}</span>元
                                            </div>
                                            <div class="item-desc">${coupon.name}</div>
                                        </div>
                                        <div class="item-description" style="border: 1px solid #b0b0b0;">
                                            <p>${coupon.description}</p></div>
                                        <div class="coupon-footer">
                                            <div class="coupon-date">已失效</div>
                                        </div>
                                    </div>
                                </li>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </ul>
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
    $("#li-valid").on("click", function () {
        $("#li-valid").addClass("tab-active");
        $("#li-invalid").removeClass("tab-active");
        $("#valid").show();
        $("#invalid").hide();
    });

    $("#li-invalid").on("click", function () {
        $("#li-invalid").addClass("tab-active");
        $("#li-valid").removeClass("tab-active");
        $("#invalid").show();
        $("#valid").hide();
    })
</script>
</body>
</html>