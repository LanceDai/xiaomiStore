<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小米商城后台管理系统</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/layui/layui.js"></script>
    <style>
        #frame {
            overflow: visible;
            border: 0;
            width: 100%;
            height: 100%;
        }

        #content {
            position: absolute;
            left: 200px;
            right: 0;
            top: 60px;
            bottom: 0;
            z-index: 998;
            width: auto;
            overflow: hidden;
            overflow-y: auto;
            box-sizing: border-box
        }
    </style>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">小米商城后台管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right" lay-filter="topnav">
            <li class="layui-nav-item">
                <a>
                    <img src="../static/image/head_portrait/admin.jpg" class="layui-nav-img">
                    root
                </a>
            </li>
            <li class="layui-nav-item" id="quit"><a href="/admin/logout">登出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="sidenav">
                <li class="layui-nav-item">
                    <a href="javascript:">管理</a>
                    <dl class="layui-nav-child ">
                        <dd><a href="/api/usersView" target="frame">用户管理</a></dd>
                        <dd><a href="/api/productView" target="frame">商品管理</a></dd>
                        <dd><a href="/api/loopDisplay" target="frame">轮播管理</a></dd>
                        <dd><a href="/api/couponView" target="frame">优惠券管理</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="/echart/showAll" target="frame">数据分析</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/echart/productAttentionStatusView" target="frame">商品关注情况</a></dd>
                        <dd><a href="/echart/userNumberIncreaseStatusView" target="frame">用户注册趋势</a></dd>
                        <dd><a href="/echart/mallProfitFluctuatingView" target="frame">商城利润波动趋势</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div id="content">
        <iframe id="frame" name="frame" src="/echart/showAll"></iframe>
    </div>

</div>
<div id="divPreview">
    <img id="updatePreview" style="width: 100%"/>
</div>
<script>
    layui.use(['jquery', 'layer', 'element'], function () {
        var $ = layui.$, layer = layui.layer, element = layui.element;
        $("#updatePreview").hide();
    })

</script>
</body>
</html>
