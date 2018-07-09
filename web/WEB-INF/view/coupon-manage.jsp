<%--
Created by IntelliJ IDEA.
User: ACM-PC
Date: 2018/5/20
Time: 19:21
To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>users</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/layui/layui.js"></script>
    <script src="../static/js/coupon.js"></script>
    <style>
        body {
            background-color: #eee;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<div class="layui-fluid">

    <div class="layui-row layui-col-space15">

        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">优惠券管理</div>
                <div class="layui-card-body">
                    <button class="layui-btn" id="add">
                        <i class="layui-icon">&#xe61f;</i> 新增优惠券
                    </button>
                    <div id="couponTable" lay-filter="couponTable"></div>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/html" id="toolBar">
    <%--<a class="layui-btn layui-btn-sm" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-sm" lay-event="edit"> <i class="layui-icon">&#xe642;</i>编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del"> <i class="layui-icon">&#xe640;</i>删除</a>
</script>


</body>
</html>

