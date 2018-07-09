$(document).ready(function () {
    var myChart = echarts.init(document.getElementById('userNumberIncreaseStatusView'), "light");
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '用户注册趋势'
        },
        color: "#ccc",
        tooltip: {},
        legend: {
            data: ['注册人数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '注册人数',
            type: 'line',
            data: []
            // barWidth: '70px'
        }]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var nums = [];    //销量数组（实际用来盛放Y坐标值）

    $.ajax({
        type: "get",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/echart/userNumberIncreaseStatus",    //请求发送到TestServlet处
        data: {},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    names.push(result[i].createTime);
                    nums.push(result[i].num);
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: names
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '注册人数',
                        data: nums
                    }]
                });

            }

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })
})