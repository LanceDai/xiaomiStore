<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../static/css/admin.css">
    <link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body>
<script src="../static/js/jquery.min.js"></script>
<script rel="script" src="../static/layui/layui.js"></script>
<div class="panel-lite">
    <div class="layui-tab">
        <ul class="layui-tab-title  tap">
            <li>登录</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="thumbur">
                    <div class="icon-lock"></div>
                </div>
                <h4>用户登录</h4>
                <form action="#" method="post">
                    <div class="form-group">
                        <input required="required" class="form-control" name="username"/>
                        <label class="form-label">用户名</label>
                    </div>
                    <div class="form-group">
                        <input type="password" required="required" class="form-control" name="password"/>
                        <label class="form-label">密　码</label>
                    </div>
                    <a href="#">忘记密码?</a>
                    <button class="floating-btn" id="submit"><i class="icon-arrow"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use(['jquery', 'layer'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        $("#submit").click(function (e) {
            e.preventDefault();
            var userName = $('input[name="username"]').val();
            var password = $('input[name="password"]').val()
            console.log("userName = " + userName);
            console.log("password = " + password);
            $.post('/admin/check', {
                username: userName,
                password: password
            }, function (val) {
                // var dataObj = eval("(" + val + ")");
                console.log("val = " + val);
                if (val.msg === 'true') {
                    layer.msg("登陆成功");
                    window.location.href = '/admin';
                } else {
                    layer.msg("密码错误");
                }
            });
        })
    });
</script>
</body>
</html>