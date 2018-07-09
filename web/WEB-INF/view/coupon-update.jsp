<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2018/6/23
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/layui/layui.js"></script>
</head>
<body>
<%--<div class="info-container">--%>
    <%--<h4 class="title">优惠券编辑</h4>--%>
    <%--<div class="input-container">--%>
        <%--<span>--%>
            <%--<p>优惠券名称</p>--%>
        <%--</span>--%>
        <%--<input id="name" type="text">--%>
    <%--</div>--%>
    <%--<div class="input-container">--%>
				<%--<span>--%>
                    <%--<p>描述</p>--%>
				<%--</span>--%>
        <%--<input id="description" type="text">--%>
    <%--</div>--%>
    <%--<div class="input-container">--%>
				<%--<span>--%>
                    <%--<p>抵用金额</p>--%>
				<%--</span>--%>
        <%--<input id="price" type="text">--%>
    <%--</div>--%>
    <%--<div class="input-container">--%>
				<%--<span>--%>
                    <%--<p>状态</p>--%>
				<%--</span>--%>
        <%--<input id="status" type="text">--%>
    <%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<div class="layui-card">
    <div class="layui-card-header">优惠券编辑</div>
    <div class="layui-card-body" style="margin-top: 50px">
        <%--<form class="layui-form" action="">--%>
            <div class="layui-form-item">
                <label class="layui-form-label">优惠券名称</label>
                <div class="layui-input-block">
                    <input id="name" type="text" name="title" required  lay-verify="required" placeholder="请输名称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">描述</label>
                <div class="layui-input-block">
                    <input id="description" type="text" name="title" required  lay-verify="required" placeholder="描述" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">抵用金额</label>
                <div class="layui-input-block">
                    <input id="price" type="text" name="title" required  lay-verify="required" placeholder="抵用金额" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-block">
                    <input id="status" type="text" name="title" required  lay-verify="required" placeholder="状态" autocomplete="off" class="layui-input">
                </div>
            </div>
        <%--</form>--%>
    </div>
</div>

</html>
