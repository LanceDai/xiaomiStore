<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员登录</title>
    <link rel="stylesheet" href="../static/css/login.css">
    <script src="../static/js/jquery.min.js"></script>
    <script type="text/javascript">
        function changeVerifyCode() {
            var time=new Date().getTime();
            document.getElementById("kaptchaImage").src="/captcha-image?d="+time;//为了不让验证码缓存，为了安全起见，需要次次都刷新
        }
    </script>
</head>
<body>
<!-- login -->
<div class="top center">
    <div class="logo center">
        <a href="/" target="_self"><img src="../static/image/mistore_logo.png" alt=""></a>
    </div>
</div>
<form  method="post" action="/check" class="form center">
    <div class="login">
        <div class="login_center">
            <div class="login_top">
                <div class="left fl">会员登录</div>
                <div class="right fr">您还不是我们的会员？<a href="/register" target="_self">立即注册</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="login_main center">
                <div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username" id = "username"placeholder="请输入你的用户名"/></div>
                <div class="username">
                    密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;
                    <input class="shurukuang" type="password" name="password" id="password" placeholder="请输入你的密码"/>
                </div>
                <div class="username">
                    <div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="code"id="code" placeholder="请输入验证码"/></div>
                    <div class="right fl"><img src="/captcha-image" id="kaptchaImage" title="看不清，点击换一张" onclick="changeVerifyCode()"></div>
                    <div class="clear">

                    </div>
                </div>
            </div>
            <div class="login_submit">
                <input class="submit" type="submit" name="submit" id="submit-login" value="立即登录" >
            </div>

        </div>
    </div>
</form>
<footer>
    <div class="copyright">简体 | 繁体 | English | 常见问题</div>
    <div class="copyright">小米公司版权所有-京ICP备10046444-<img src="../static/image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>
</footer>
<script>
    $(document).on("click", "#submit-login", function (event){
        event.preventDefault();
        var username = $("#username").val();
        var password = $("#password").val();
        var code = $("#code").val();
        $.ajax({
            type: 'POST',
            url: "/user/check",
            data: {
                'username': username,
                'password': password,
                'code': code,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === "CodeError"){
                    alert("验证码错误");
                }else if (data.msg === "true"){
                    window.location.href = "/index";
                }else {
                    alert("账号密码错误");
                }
            },
            error:function () {
                console.log(data.msg);
                alert("异常");
            }
        });
    });
</script>
</body>
</html>