layui.use(['jquery', 'laypage', 'table', 'layer', 'element', 'laydate'], function () {
    var $ = layui.$;
    var laypage = layui.laypage;
    var table = layui.table;
    var layer = layui.layer;
    var element = layui.element;
    var laydate = layui.laydate;

    // parent.register.userTable =
    table.render({
        elem: '#couponTable'
        , url: '/api/couponData'
        , page: false
        , cols: [[
            {field: 'couponId', title: '优惠券编号', align:"center" }
            , {field: 'name', title: '优惠券名称', align: "center"}
            , {field: 'description', title: '描述', align: "center"}
            , {field: 'price', title: '抵用金额', align: "center"}
            , {field: 'status', title: '状态', align: "center"}
            , {fixed: 'right', title: '操作', align: 'center', toolbar: '#toolBar'}
        ]]
        // , id: "userTable"
    });

    //监听工具条 tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    table.on('tool(couponTable)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        // console.info(data.userId + " " + data.authorityId);
        if (layEvent === 'detail') { //查看
            parent.layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                shadeClose: true,
                content: '<div><img src="../image/666.jpg" style="width: 100%"/></div>'
            });
        } else if (layEvent === 'del') { //删除
            layer.open({
                content: '<div style="text-align: center">确定要删除该优惠券吗？</div>'
                , btn: ['取消', '删除'] //按钮
                , btnAlign: 'c'
                , yes: function () {
                    layer.msg("取消删除");
                }
                , btn2: function () {
                    $.post("/api/couponDelete", {couponId: data.couponId}, function (data) {
                        // var dataObj = eval("(" + data + ")");
                        var dataObj = JSON.parse(JSON.stringify(data));

                        if (dataObj.result === 'success') {
                            layer.msg("删除成功");
                            obj.del();
                        } else {
                            layer.msg("删除失败");
                        }
                    })
                }
            });
        } else if (layEvent === 'edit') { //编辑;
            parent.layer.open({
                type: 2,
                content: ['/api/couponUpdate?start=' + data.startDate + '&end=' + data.endDate + '&remark=' + data.remark, 'no'],
                title: false,
                shade: 0,
                btn: ['确认', '取消'],
                area: ['400', '470'],
                btnAlign: 'c',
                id: 'first',
                resize: false,
                yes:
                    function (index, layero) {
                        var editFrame = parent.document.getElementById(layero.find('iframe')[0]['name']);
                        var editDoc = editFrame.contentDocument;
                        var name = $("#name", editDoc).val();
                        var description= $("#description", editDoc).val();
                        var price = $("#price", editDoc).val();
                        var status = $("#status", editDoc).val();
                        // var remark = $("#remark", editDoc).val();
                        $.post('/api/updateCoupon', {name: name, description: description, price: price, status:status, couponId: data.couponId}, function (data) {
                            var dataObj = JSON.parse(JSON.stringify(data));
                            if (dataObj.msg === 'success') {
                                obj.update({
                                    // endDate: endDate,
                                    // remark: remark
                                });
                                parent.layer.msg('修改成功');
                                parent.layer.close(index); //如果设定了yes回调，需进行手工关闭
                            } else {
                                parent.layer.msg("修改失败");
                            }
                        });
                    }
            })
        }
    });

    $("#add").click(function () {
        parent.layer.open({
            type: 2,
            content: ['/api/couponUpdate', 'no'],
            title: '添加优惠券',
            shade: 0,
            btn: ['确认', '取消'],
            area: ['400', '470'],
            btnAlign: 'c',
            id: "first",//同一 ID 窗口打开一个
            resize: false,
            yes:
                function (index, layero) {
                    var editFrame = parent.document.getElementById(layero.find('iframe')[0]['name']);
                    var editDoc = editFrame.contentDocument;
                    var name = $("#name", editDoc).val();
                    var description= $("#description", editDoc).val();
                    var price = $("#price", editDoc).val();
                    var status = $("#status", editDoc).val();
                    // var remark = $("#remark", editDoc).val();
                    $.post('/api/insertCoupon', {name: name, description: description, price: price, status:status}, function (data) {
                        var dataObj = JSON.parse(JSON.stringify(data));
                        if (dataObj.msg === 'success') {
                            // obj.update({
                            //     // endDate: endDate,
                            //     // remark: remark
                            // });
                            parent.layer.msg('添加成功');
                            parent.layer.close(index); //如果设定了yes回调，需进行手工关闭
                        } else {
                            parent.layer.msg("添加失败");
                        }
                    });
                }
        });
    });

    $("#search").click(function () {
        var data = $("#searchVal").val();
        console.info(data);
        parent.register.userTable.reload({
            where: { //设定异步数据接口的额外参数，任意设
                data: data
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })

});