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
    <%--<h4 class="title">商品信息编辑</h4>--%>
    <%--<div class="input-container">--%>
        <%--<span>--%>
            <%--<p>商品名称</p>--%>
        <%--</span>--%>
        <%--<input id="name" type="text">--%>
    <%--</div>--%>
    <%--<div class="input-container">--%>
				<%--<span>--%>
                    <%--<p>商品描述</p>--%>
				<%--</span>--%>
        <%--<input id="description" type="text">--%>
    <%--</div>--%>
    <%--<div class="input-container">--%>
				<%--<span>--%>
                    <%--<p>商品类别</p>--%>
				<%--</span>--%>
        <%--<input id="type" type="text">--%>
    <%--</div>--%>
<%--</div>--%>
<div class="layui-card">
    <div class="layui-card-header">商品信息编辑</div>
    <div class="layui-card-body" style="margin-top: 50px">
        <%--<form class="layui-form" action="">--%>
        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input id="name" type="text" name="title" required  lay-verify="required" placeholder="请输名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品描述</label>
            <div class="layui-input-block">
                <input id="description" type="text" name="title" required  lay-verify="required" placeholder="商品描述" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品类别</label>
            <div class="layui-input-block">
                <input id="type" type="text" name="title" required  lay-verify="required" placeholder="类别" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--</form>--%>
    </div>
</div>
</body>
</html>
