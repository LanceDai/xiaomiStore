<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="../static/css/login.css">
	<script src="../static/js/jquery.min.js"></script>
	<script type="text/javascript">
        function changeVerifyCode() {
            var time=new Date().getTime();
            document.getElementById("kaptchaImage").src="/captcha-image?d="+time;//为了不让验证码缓存，为了安全起见，需要次次都刷新
        }
	</script>
</head>
<body>
<form>
	<div class="regist">
		<div class="regist_center">
			<div class="regist_top">
				<div class="left fl">会员注册</div>
				<div class="right fr"><a href="/" target="_self">小米商城</a></div>
				<div class="clear"></div>
				<div class="xian center"></div>
			</div>
			<div class="regist_main center">
				<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input id="register-username" class="shurukuang" type="text" name="username"  placeholder="请输入你的用户名"/><span>请不要输入汉字</span></div>
				<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input id="register-password" class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/><span>请输入6位以上字符</span></div>

				<div class="username">确认密码:&nbsp;&nbsp;<input id="register-password-check" class="shurukuang" type="password" name="repassword" placeholder="请确认你的密码"/><span>两次密码要输入一致哦</span></div>
				<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input id="register-telephoneNumber" class="shurukuang" type="text" name="tel" placeholder="请填写正确的手机号"/><span>填写下手机号吧，方便我们联系您！</span></div>
				<div class="username">
					<div class="left fl" >验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input id="code" class="yanzhengma" type="text" name="username" placeholder="请输入验证码" style="width: 220px;"/></div>
					<div class="right fl"><img src="/captcha-image" id="kaptchaImage" title="看不清，点击换一张" onclick="changeVerifyCode()"></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="regist_submit">
				<input id="submit-register" class="submit" type="submit" name="submit" value="立即注册" >
			</div>
		</div>
	</div>
</form>

<script>
    $(document).on("click", "#submit-register", function (event) {
        event.preventDefault();
        var username = $("#register-username").val();
        var password = $("#register-password").val();
        var checkPassword = $("#register-password-check").val();
        var telephoneNumber = $("#register-telephoneNumber").val();
        var code = $("#code").val();
        $.ajax({
            type: 'POST',
            url: "/register/create",
            data:{
                'username': username,
                'password': password,
                'checkPassword': checkPassword,
                'telephoneNumber': telephoneNumber,
                'code': code,
            },
            success: function (result) {
                var data = JSON.parse(JSON.stringify(result));
                if (data.msg === "CodeError"){
                    alert("验证码错误");
                }else if (data.msg === "usernameError"){
                    alert("此用户名已存在");
                }else if (data.msg === "PasswordError"){
                    alert("两次密码不一致");
                }else if (data.msg === "true"){
                    alert("注册成功");
                    window.location.href = "/";
                }
            },
            error:function () {
                alert("注册异常");//写后台
            }
        });
    });
</script>
</body>
</html>