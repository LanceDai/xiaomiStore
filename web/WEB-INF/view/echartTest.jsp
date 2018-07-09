<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="height: 500px; width: 50%;"></div>
<!-- ECharts单文件引入 -->
<script src="../static/js/echarts.js"></script>
<script src="../static/js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var myChart = echarts.init(document.getElementById('main'), "light");
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '商品关注情况'
            },
            color : "#ccc",
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [],
                barWidth: '70px'
            }]
        });

        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

        var names=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums=[];    //销量数组（实际用来盛放Y坐标值）

        $.ajax({
            type : "get",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "/echart/productAttentionStatus",    //请求发送到TestServlet处
            data : {},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                console.log(result.toString());
                if (result) {
                    for (var i = 0; i < result.length; i++) {
                        names.push(result[i].productName);
                        nums.push(result[i].productNumber);
                    }
                    myChart.hideLoading();    //隐藏加载动画
                    myChart.setOption({        //加载数据图表
                        xAxis: {
                            data: names
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销量',
                            data: nums
                        }]
                    });

                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
    })
</script>
</body>
