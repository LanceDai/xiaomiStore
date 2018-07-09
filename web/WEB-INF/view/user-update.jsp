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

<div class="layui-card">
    <div class="layui-card-header">用户资料编辑</div>
    <div class="layui-card-body" style="margin-top: 25px">
        <%--<form class="layui-form" action="">--%>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <input id="name" type="text" name="title" required  lay-verify="required" placeholder="用户昵称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input id="phone" type="text" name="title" required  lay-verify="required" placeholder="手机号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input id="password" type="text" name="title" required  lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
            </div>
        </div>
            <div class="layui-form-item">
                <label class="layui-form-label">个性签名</label>
                <div class="layui-input-block">
                    <input id="sign" type="text" name="title" required  lay-verify="required" placeholder="个性签名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">爱好</label>
                <div class="layui-input-block">
                    <input id="hobby" type="text" name="title" required  lay-verify="required" placeholder="爱好" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">收货地址</label>
                <div class="layui-input-block">
                    <input id="address" type="text" name="title" required  lay-verify="required" placeholder="收货地址" autocomplete="off" class="layui-input">
                </div>
            </div>
        <%--</form>--%>
    </div>
</div>
</body>
</html>
