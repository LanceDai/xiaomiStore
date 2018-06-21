<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
    <script src="../static/js/jquery.min.js"></script>
    <style>
        .empty{
            background-size: 100% auto;
            background: url("../static/image/emptyShoppingCart.png") no-repeat;
            height: 1000px;
            border-top: 1px solid #ccc;
        }
    </style>
</head>
<body>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="/" target="_self">
        <div class="logo fl"></div>
    </a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <c:choose>
                <c:when test="${sessionScope.loginUser != null}">
                    <li><a href="/selfInfo/" target="_self" style="height: 40px;">
                        <img src="../static/image/head_portrait/${sessionScope.loginUser.img}"
                             onerror="this.src='../static/image/head_portrait/default.jpg'"
                             style="width: 40px;height: 40px;border-radius: 20px; margin: 30px 10px;">
                    </a></li>
                    <li>|</li>
                    <li><a href="/user/logout" target="_self">登出</a></li>
                    <li>|</li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login" target="_self">登录</a></li>
                    <li>|</li>
                    <li><a href="/register/" target="_self">注册</a></li>
                    <li>|</li>
                </c:otherwise>
            </c:choose>

        </ul>

    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="gwcxqbj">
    <div class="gwcxd center">
        <div class="top2 center" style="height: 50px">
            <div class="sub_top fl">
                <label>
                    <input type="checkbox" value="quanxuan" class="quanxuan" id="selectAll"/>
                </label>全选
            </div>
            <div class="sub_top fl">商品名称</div>
            <div class="sub_top fl">单价</div>
            <div class="sub_top fl">数量</div>
            <div class="sub_top fl">小计</div>
            <div class="sub_top fr">操作</div>
            <div class="clear"></div>
        </div>
        <c:choose>
        <c:when test="${shoppingCartList.size() == 0}">
        <div class="shoppingCartList empty">
            </c:when>
            <c:otherwise>
            <div class="shoppingCartList">
                </c:otherwise>
                </c:choose>
                <c:forEach items="${shoppingCartList}" var="scl" varStatus="status">
                    <div id="${status.index}" style="display: none;float: top;">
                        <div class="productName">
                                ${scl.productName}
                        </div>
                        <div class="detailVersion">
                                ${scl.detailVersion}
                        </div>
                        <div class="colorName">
                                ${scl.colorName}
                        </div>
                        <div class="price">
                                ${scl.price}
                        </div>
                    </div>
                    <div class="content2 center item">
                        <div class="sub_content fl ">
                            <label>
                                <input type="checkbox" data-index="${status.index}" value="quanxuan" class="quanxuan"
                                       id="choose"/>
                            </label>
                        </div>
                        <div class="sub_content fl">
                            <img id="img"
                                 src="../static/image/thumb/${scl.productName.replace(' ', '_').replace("\"", "")}.jpg">
                        </div>
                        <div class="sub_content fl ft20 ">
                                ${scl.productName.concat(scl.detailVersion).concat(scl.colorName)}
                        </div>
                        <div class="sub_content fl" style="width: 150px;">
                            <fmt:formatNumber type="number" value="${scl.price}" pattern="0.00" maxFractionDigits="2"/>元
                        </div>
                        <div class="sub_content fl" style="margin: 0 20px">
                            <label>
                                <input data-index="${status.index}" class="shuliang num" type="number"
                                       value="${scl.number}"
                                       step="1" min="1">
                            </label>
                        </div>
                        <div class="sub_content fl" id="sum_${status.index}" style="width: 100px;margin: 0 0 0 80px">
                            <fmt:formatNumber type="number" value="${scl.price * scl.number}" pattern="0.00"
                                              maxFractionDigits="2"/>元
                        </div>
                        <div class="sub_content fl delete" data-index="${status.index}"
                             style="width: 100px;margin: 0 0 0 100px"><a href="">×</a></div>
                        <div class="clear"></div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="jiesuandan mt20 center">
            <div class="tishi fl ml20">
                <ul>
                    <li><a href="resultSet.jsp">继续购物</a></li>
                    <li>|</li>
                    <li>共<span>${shoppingCartList.size()}</span>件商品，已选择<span id="selectNumber">0</span>件</li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="jiesuan fr">
                <div class="jiesuanjiage fl">合计（不含运费）：<span id="sum">00.00元</span></div>
                <div class="jsanniu fr">
                    <input class="jsan" type="submit" name="jiesuan" value="去结算" id="settlement"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>

    </div>


    <!-- footer -->
    <footer class="center">

        <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
        <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
        <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
    </footer>
    <script>
        $(document).ready(function () {

            $(".num").change(function () {
                console.log($(this).val());
                var num = $(this).attr("data-index");
                var number = $(this).val();
                console.log(num);
                var info = $("#" + num);
                $.post("/shoppingCart/do", {
                    productName: info.find(".productName").text().trim(),
                    version: info.find(".detailVersion").text().trim(),
                    color: info.find(".colorName").text().trim(),
                    number: number
                });
                $("#sum_" + num).text(number * info.find(".price").text() + ".00元");
                updateSumAndNumber();
            });

            $(".delete").click(function () {
                var num = $(this).attr("data-index")
                // console.log(num);
                var info = $("#" + num);
                $.post("/shoppingCart/delete", {
                    productName: info.find(".productName").text().trim(),
                    version: info.find(".detailVersion").text().trim(),
                    color: info.find(".colorName").text().trim()
                });
                alert("删除成功")
            });

            function updateSumAndNumber() {
                var sum = 0;
                var checkedList = $('input[type="checkbox"][id="choose"]:checked');
                $("#selectNumber").text(checkedList.length);
                for (var i = 0; i < checkedList.length; ++i) {
                    var index = checkedList.eq(i).attr("data-index");
                    (function (e) {
                        var price = $("#sum_" + e).text().trim();
                        price = price.substr(0, price.lastIndexOf('.'));
                        console.log("price = " + price);
                        sum = Number(sum) + Number(price);
                    })(index)
                }
                //console.log("sum = " + sum);
                var sumPrice = $("#sum").text(sum + ".00元");
            }

            var radioList = $('input[type="checkbox"][id="choose"]');
            for (var i = 0; i < radioList.length; ++i) {
                (function (e) {
                    radioList.eq(e).click(function () {
                        updateSumAndNumber();
                    });
                })(i)
            }

            $("#selectAll").click(function () {
                if ($(this).prop("checked") === true) {
                    $('input[type="checkbox"][id="choose"]').each(function () {
                        $(this).prop("checked", true);
                        updateSumAndNumber();
                    });
                } else {
                    $('input[type="checkbox"][id="choose"]').each(function () {
                        $(this).prop("checked", false);
                        updateSumAndNumber();
                    });
                }
            });

            $("#settlement").click(function () {
                var checkedList = $('input[type="checkbox"][id="choose"]:checked');
                for (var i = 0; i < checkedList.length; ++i) {
                    var index = checkedList.eq(i).attr("data-index");
                    (function (e) {
                        console.log("delete-index = " + e);
                        var deleteNeed = $(".delete[data-index=" + e + "]");
                        console.log(deleteNeed.text());
                        // console.log(num);
                        var info = $("#" + index);
                        $.post("/shoppingCart/delete", {
                            productName: info.find(".productName").text().trim(),
                            version: info.find(".detailVersion").text().trim(),
                            color: info.find(".colorName").text().trim()
                        });
                    })(index)
                }
                alert("结算成功");
                var sumPrice = $("#sum").text().trim();
                $.get("/shoppingCart/settlement/" + Number(sumPrice.substr(0, sumPrice.lastIndexOf('.'))));
                window.location.reload();
            })
        })
    </script>
</body>
</html>
