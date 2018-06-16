<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${productDetail.productName}立即购买-小米商城</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
    <script src="../static/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var versionList = $("#version").find(".banben");
            var colorList = $("#color").find(".banben");
            var nowVersion = versionList.eq(0);
            console.log("nowVersion = " + nowVersion.find("a").find("span").eq(0).text());
            var nowColor = colorList.eq(0);
            console.log("nowColor = " + nowColor.text());
            var nowPrice = versionList.eq(0).find("a").find("span").eq(1).text();
            console.log("nowPrice = " + nowPrice);
            var sumText = $("#sum_text");
            console.log("sumText = " + sumText.text());
            var price = $("#price");
            console.log("price = " + price.text());
            var sumPrice = $("#sum_price");
            console.log("sumPrice = " + sumPrice.text());
            var productName = $("#product_name");
            console.log("productName = " + productName.text());

            sumText.text(productName.text() + nowVersion.find("a").find("span").eq(0).text() + nowColor.text());
            price.text(nowPrice + ".00元");
            sumPrice.text("总计：" + nowPrice + ".00元")

            nowVersion.css("border", "1px solid #ff6700");
            nowVersion.find("a").css("color", "#ff6700");
            nowColor.css("border", "1px solid #ff6700");
            nowColor.find("a").css("color", "#ff6700");

            for (var i = 0; i < versionList.length; ++i) {
                versionList.eq(i).click(function () {
                    nowVersion.css("border", "1px solid #bbb");
                    nowVersion.find("a").find("span").css("color", "#000");
                    $(this).css("border", "1px solid #ff6700");
                    $(this).find("a").find("span").css("color", "#ff6700");
                    nowVersion = $(this);
                    nowPrice = $(this).find("a").find("span").eq(1).text();
                    sumText.text(productName.text() + nowVersion.find("a").find("span").eq(0).text() + nowColor.text());
                    price.text(nowPrice + ".00元");
                    sumPrice.text("总计：" + nowPrice + ".00元")
                })
            }

            for (var j = 0; j < colorList.length; ++j) {
                colorList.eq(j).click(function () {
                    nowColor.css("border", "1px solid #bbb");
                    nowColor.find("a").css("color", "#000");
                    $(this).css("border", "1px solid #ff6700");
                    $(this).find("a").css("color", "#ff6700");
                    nowColor = $(this);
                    sumText.text(productName.text() + nowVersion.find("a").find("span").eq(0).text() + nowColor.text());
                    price.text(nowPrice + ".00元");
                    sumPrice.text("总计：" + nowPrice + ".00元")
                })
            }

            function buyOrAdd() {
                $.post("/shoppingCart/do",
                    {
                        productName: productName.text(),
                        version: nowVersion.find("a").find("span").eq(0).text(),
                        color: nowColor.text()
                    })
            }

            $("#buy").click(function () {
                buyOrAdd();
                window.location = "/shoppingCart";
            });

            $("#add").click(function () {
                buyOrAdd();
            })

        })

    </script>
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
            <div class="gouwuche fr"><a href="/shoppingCart">购物车</a></div>
            <div class="fr">
                <ul>
                    <li><a href="/login" target="_self">登录</a></li>
                    <li>|</li>
                    <li><a href="/register" target="_self">注册</a></li>
                    <li>|</li>
                    <li><a href="">消息通知</a></li>
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


<!-- detail -->
<div style="height: 900px;">
    <div class="detail">
        <div class="content w">
            <div class="product_header fl" id="product_name">${productDetail.productName}</div>
            <nav class="fr">
                <li><a href="">概述</a></li>
                <li>|</li>
                <li><a href="">变焦双摄</a></li>
                <li>|</li>
                <li><a href="">设计</a></li>
                <li>|</li>
                <li><a href="">参数</a></li>
                <li>|</li>
                <li><a href="">F码通道</a></li>
                <li>|</li>
                <li><a href="">用户评价</a></li>
                <div class="clear"></div>
            </nav>
            <div class="clear"></div>
        </div>
    </div>

    <div class="jieshao mt20 w">
        <div class="left fl" style="height: 620px"><img
                src="../static/image/thumb/${productDetail.productName.replace(' ', '_').replace("\"", "")}.jpg"
                style="width: 100%;height: 90%;margin: 30px auto"></div>
        <div class="right fr" style="height: 750px">
            <div class="h3 ml20 mt20">${productDetail.productName}</div>
            <div class="jianjie mr40 ml20 mt10">变焦双摄，4 轴防抖 / 骁龙845 旗舰处理器，6GB 大内存，最大可选128GB 闪存 / 5.15" 护眼屏 / 四曲面玻璃/陶瓷机身
            </div>
            <div class="jiage ml20 mt10">${productDetail.versionList.values().iterator().next()}.00元</div>
            <div class="ft20 ml20 mt20">选择版本</div>
            <div class="xzbb ml20 mt10" id="version">
                <c:forEach items="${productDetail.versionList}" var="pdvl">
                    <div class="banben" style="display: inline-block; margin: 5px 5px">
                        <a>
                            <span>${pdvl.key}</span>
                            <span>${pdvl.value}</span>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="clear" style="height: 65px"></div>
            <div class="ft20 ml20 mt20">选择颜色</div>
            <div class="xzbb ml20 mt10" id="color">
                <c:forEach items="${productDetail.colorList}" var="pdcl">
                    <div class="banben" style="display: inline-block; margin: 5px 5px">
                        <a>
                            <span class="yuandian" style="background: ${pdcl.key}"></span>
                            <span class="yanse">${pdcl.value}</span>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="clear" style="height: 75px"></div>
            <div class="xqxq mt20 ml20" style="margin: 10px 10px">
                <div class="top1 mt10">
                    <div class="left1 fl" id="sum_text">

                    </div>
                    <div class="right1 fr" id="price"></div>
                    <div class="clear"></div>
                </div>
                <div class="bot mt20 ft20 ftbc" id="sum_price">
                </div>
            </div>
            <div class="xiadan ml20 mt20" style="margin: 15px 58px">
                <input class="button" type="button" name="button" id="buy" value="立即选购"/>
                <input class="button" type="button" name="button" id="add" value="加入购物车"/>

            </div>
        </div>
        <div class="clear"></div>
    </div>

    <div class="clear" style="height: 50px"></div>
</div>
<!-- footer -->
<footer class="mt20 center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

</footer>

</body>
</html>