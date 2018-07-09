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
    <script src="../static/js/users.js"></script>
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
                <div class="layui-card-header">轮播管理</div>
                <div class="layui-card-body">
                    <div id="jpgTable" lay-filter="jpgTable">
                        <table class="layui-table">
                            <colgroup>
                                <col width="45%"/>
                                <col width="45%"/>
                                <col>
                            </colgroup>
                            <thead>
                            <tr>
                                <th>图片</th>
                                <th>编号</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tr>
                                <th><img src="../static/image/backgroundImage/bg0.jpg"></th>
                                <th style="text-align: center">0</th>
                                <th>
                                    <button type="button" class="layui-btn" id="test0" data-value="0">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                </th>
                            </tr>
                            <tr>
                                <th><img src="../static/image/backgroundImage/bg1.jpg"></th>
                                <th style="text-align: center">1</th>
                                <th>
                                    <button type="button" class="layui-btn" id="test1" data-value="1">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                </th>
                            </tr>
                            <tr>
                                <th><img src="../static/image/backgroundImage/bg2.jpg"></th>
                                <th style="text-align: center">2</th>
                                <th>
                                    <button type="button" class="layui-btn" id="test2" data-value="2">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                </th>
                            </tr>
                            <tr>
                                <th><img src="../static/image/backgroundImage/bg3.jpg"></th>
                                <th style="text-align: center">3</th>
                                <th>
                                    <button type="button" class="layui-btn" id="test3" data-value="3">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                </th>
                            </tr>
                            <tr>
                                <th><img src="../static/image/backgroundImage/bg4.jpg"></th>
                                <th style="text-align: center">4</th>
                                <th>
                                    <button type="button" class="layui-btn" id="test4" data-value="4">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                </th>
                            </tr>
                            <tr>
                                <th><img src="../static/image/backgroundImage/bg5.jpg"></th>
                                <th style="text-align: center">5</th>
                                <th>
                                    <button type="button" class="layui-btn" id="test5" data-value="5">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                </th>
                            </tr>
                        </table>
                    </div>


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
<script src="../static/layui/layui.js"></script>
<script src="../static/js/jquery.min.js"></script>
<script>
    layui.use(['upload', 'layer'], function () {
        var upload = layui.upload;
        var layer = layui.layer;
        //执行实例
        for (var i = 0; i < 6; i++) {
            (function (e) {
                var uploadInst = upload.render({
                    elem: '#test' + e //绑定元素
                    , url: '/api/upload' //上传接口
                    , data: {
                        number: e
                    }
                    , done: function (res) {
                        var data = JSON.parse(JSON.stringify(res));
                        if (data.msg === "success")
                            layer.msg("上传成功");
                        //上传完毕回调
                    }
                    , error: function () {
                        //请求异常回调
                    }
                });
            })(i)

        }

    });

</script>

</body>
</html>

