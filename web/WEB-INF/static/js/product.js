layui.use(['jquery', 'laypage', 'table', 'layer', 'element', 'laydate'], function () {
    var $ = layui.$;
    var laypage = layui.laypage;
    var table = layui.table;
    var layer = layui.layer;
    var element = layui.element;
    var laydate = layui.laydate;

    // parent.register.userTable =
    table.render({
        elem: '#productTable'
        , url: '/api/productData'
        , page: false
        , cols: [[
            {field: 'productId', title: '商品编号', align:"center" }
            , {field: 'productName', title: '商品名称', align: "center"}
            , {field: 'productDescription', title: '商品描述', align: "center"}
            , {field: 'typeId', title: '商品类别', align: "center"}
            , {fixed: 'right', title: '操作', align: 'center', toolbar: '#toolBar'}
        ]]
        // , id: "userTable"
    });

    //监听工具条 tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    table.on('tool(productTable)', function (obj) {
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
                content: '<div style="text-align: center">确定要删除该商品吗？</div>'
                , btn: ['取消', '删除'] //按钮
                , btnAlign: 'c'
                , yes: function () {
                    layer.msg("取消删除");
                }
                , btn2: function () {
                    $.post("/api/productDelete", {productId: data.productId}, function (data) {
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
                content: ['/api/productUpdate?start=' + data.startDate + '&end=' + data.endDate + '&remark=' + data.remark, 'no'],
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
                        var type = $("#type", editDoc).val();
                        // var remark = $("#remark", editDoc).val();
                        $.post('/api/updateProduct', {name: name, description: description, typeId: type, productId: data.productId}, function (data) {
                            var dataObj = JSON.parse(JSON.stringify(data));
                            if (dataObj.msg === 'success') {
                                obj.update({
                                    endDate: endDate,
                                    remark: remark
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
        //用于关闭自身
        parent.layer.open({
            type: 2,
            content: ['/api/productUpdate', 'no'],
            title: '添加商品',
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
                    var type = $("#type", editDoc).val();
                    // var remark = $("#remark", editDoc).val();
                    $.post('/api/insertProduct', {name: name, description: description, typeId: type}, function (data) {
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

});