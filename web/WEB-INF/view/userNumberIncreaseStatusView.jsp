<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/layui/layui.js"></script>
    <!-- ECharts单文件引入 -->
    <script src="../static/js/echarts.js"></script>
    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/userNumberIncreaseStatusView.js"></script>
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
                <div class="layui-card-header">用户注册趋势</div>
                <div class="layui-card-body">
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="userNumberIncreaseStatusView" style="height: 75%; width: 100%;">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>

