<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/layui/layui.js"></script>
    <!-- ECharts单文件引入 -->
    <script src="../static/js/echarts.js"></script>
    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/userNumberIncreaseStatusView.js"></script>
    <script src="../static/js/productAttentionStatusView.js"></script>
    <script src="../static/js/mallProfitFluctuatingView.js"></script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>数据分析</legend>
</fieldset>

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">用户注册趋势</div>
                <div class="layui-card-body">
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="userNumberIncreaseStatusView" style="height: 75%; width: 100%;">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">商城利润波动趋势</div>
                <div class="layui-card-body">
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="mallProfitFluctuatingView" style="height: 75%; width: 100%;">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">商品关注情况</div>
                <div class="layui-card-body">
                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="productAttentionStatusView" style="height: 75%; width: 100%;">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>
