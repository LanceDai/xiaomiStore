<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米商城</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
    <link rel="stylesheet" type="text/css" href="../static/css/loopDisplay.css">
    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/script.js"></script>

</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="/shoppingCart/">购物车</a></div>
            <div class="fr">
                <ul>
                    <li><a href="login" target="_self">登录</a></li>
                    <li>|</li>
                    <li><a href="register.jsp" target="_blank">注册</a></li>
                    <li>|</li>
                    <li><a href="">消息通知</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.jsp" target="_blank">
        <div class="logo fl"></div>
    </a>
    <a href="">
        <div class="ad_top fl"></div>
    </a>
    <div class="nav fl">
        <ul>
            <li><a href="./liebiao" target="_blank">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->
<!-- start banner_y -->
<div class="main" id="main">
    <div class="menu-box">
    </div>
    <!--内容-->
    <div class="sub-menu hide" id="sub-menu">
        <c:forEach items="${typeList.originTypeList}" var="tl">
            <div class="inner-box nav">
                <ul>
                    <li>
                        <div class="pop" style="height: 100%;">
                            <div class="left fl" style="display: inline-block">
                                <c:forEach items="${tl.productList}" end="5" var="pll">
                                    <div style=" width: 265px; height:77px">
                                        <a class="link" href="/detail/${pll.productName}">
                                            <img class="thumb" width="40px" height="40px"
                                                 src="../static/image/thumb/${pll.productName.replace(' ', '_').replace("\"", "")}.jpg">
                                            <span class="ttext">${pll.productName}</span>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="cnt fl" style="display: inline-block">
                                <c:forEach items="${tl.productList}" begin="6" end="11" var="plc">
                                    <div style=" width: 265px; height:77px">
                                        <a class="link" href="/detail/${plc.productName}">
                                            <img class="thumb" width="40px" height="40px"
                                                 src="../static/image/thumb/${plc.productName.replace(' ', '_').replace("\"", "")}.jpg">
                                            <span class="ttext">${plc.productName}</span>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="right fl" style="display: inline-block">
                                <c:forEach items="${tl.productList}" begin="12" end="17" var="ple">
                                    <div style=" width: 265px; height:77px">
                                        <a class="link" href="/detail/${ple.productName}">
                                            <img class="thumb" width="40px" height="40px"
                                                 src="../static/image/thumb/${ple.productName.replace(' ', '_').replace("\"", "")}.jpg">
                                            <span class="ttext">${ple.productName}</span>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </c:forEach>
    </div>
    <!-- 菜单 -->
    <div class="menu-content" id="menu-content">
        <c:forEach items="${typeList.originTypeList}" var="tl">
            <div class="menu-item">
                <a href="/search/${tl.type.name}">
                    <span>${tl.type.name}</span>
                    <i class="icon">&#xe665;</i>
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="banner" id="banner">
        <c:forEach begin="0" end="5" var="i">
            <a href="">
                <c:choose>
                    <c:when test="${ i == 0}">
                        <div class="banner-slide slide-active">
                            <img src="${'../static/image/backgroundImage/bg'.concat(i).concat('.jpg')}" height="100%"
                                 width="100%">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="banner-slide ">
                            <img src="${'../static/image/backgroundImage/bg'.concat(i).concat('.jpg')} " height="100%"
                                 width="100%">
                        </div>
                    </c:otherwise>
                </c:choose>
            </a>
        </c:forEach>
    </div>
    <a href="javascript:void(0)" class="button prev" id="prev"></a>
    <a href="javascript:void(0)" class="button next" id="next"></a>
    <div class="dots" id="dots">
        <c:forEach begin="0" end="5" var="i">
            <c:choose>
                <c:when test="${ i == 0}">
                    <span class="active"></span>
                </c:when>
                <c:otherwise>
                    <span></span>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>
<div class="sub_banner center">
    <div class="sidebar fl">
        <div class="fl"><a href=""><img src="../static/image/hjh_01.gif"></a></div>
        <div class="fl"><a href=""><img src="../static/image/hjh_02.gif"></a></div>
        <div class="fl"><a href=""><img src="../static/image/hjh_03.gif"></a></div>
        <div class="fl"><a href=""><img src="../static/image/hjh_04.gif"></a></div>
        <div class="fl"><a href=""><img src="../static/image/hjh_05.gif"></a></div>
        <div class="fl"><a href=""><img src="../static/image/hjh_06.gif"></a></div>
        <div class="clear"></div>
    </div>
    <div class="datu fl"><a href=""><img src="../static/image/hongmi4x.png" alt=""></a></div>
    <div class="datu fl"><a href=""><img src="../static/image/xiaomi5.jpg" alt=""></a></div>
    <div class="datu fr"><a href=""><img src="../static/image/pinghengche.jpg" alt=""></a></div>
    <div class="clear"></div>


</div>
<!-- end banner -->

<!-- start danpin -->
<div class="danpin center">

    <div class="biaoti center">小米明星单品</div>
    <div class="main center">
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="../static/image/pinpai1.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米MIX</a></div>
            <div class="youhui">5月9日-21日享花呗12期分期免息</div>
            <div class="jiage">3499元起</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="../static/image/pinpai2.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米5s</a></div>
            <div class="youhui">5月9日-10日，下单立减200元</div>
            <div class="jiage">1999元</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="../static/image/pinpai3.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米手机5 64GB</a></div>
            <div class="youhui">5月9日-10日，下单立减100元</div>
            <div class="jiage">1799元</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="../static/image/pinpai4.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米电视3s 55英寸</a></div>
            <div class="youhui">5月9日，下单立减200元</div>
            <div class="jiage">3999元</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="../static/image/pinpai5.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米笔记本</a></div>
            <div class="youhui">更轻更薄，像杂志一样随身携带</div>
            <div class="jiage">3599元起</div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="peijian w">
    <div class="biaoti center">配件</div>
    <div class="main center">
        <div class="content">
            <div class="remen fl"><a href=""><img src="../static/image/peijian1.jpg"></a>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span>新品</span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian2.jpg"></a></div>
                <div class="miaoshu"><a href="">小米6 硅胶保护套</a></div>
                <div class="jiage">49元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian3.jpg"></a></div>
                <div class="miaoshu"><a href="">小米手机4c 小米4c 智能</a></div>
                <div class="jiage">29元</div>
                <div class="pingjia">372人评价</div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:red">享6折</span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian4.jpg"></a></div>
                <div class="miaoshu"><a href="">红米NOTE 4X 红米note4X</a></div>
                <div class="jiage">19元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian5.jpg"></a></div>
                <div class="miaoshu"><a href="">小米支架式自拍杆</a></div>
                <div class="jiage">89元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="content">
            <div class="remen fl"><a href=""><img src="../static/image/peijian6.png"></a>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian7.jpg"></a></div>
                <div class="miaoshu"><a href="">小米指环支架</a></div>
                <div class="jiage">19元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian8.jpg"></a></div>
                <div class="miaoshu"><a href="">米家随身风扇</a></div>
                <div class="jiage">19.9元</div>
                <div class="pingjia">372人评价</div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="../static/image/peijian9.jpg"></a></div>
                <div class="miaoshu"><a href="">红米4X 高透软胶保护套</a></div>
                <div class="jiage">59元</div>
                <div class="pingjia">775人评价</div>
            </div>
            <div class="remenlast fr">
                <div class="hongmi"><a href=""><img src="../static/image/hongmin4.png" alt=""></a></div>
                <div class="liulangengduo"><a href=""><img src="../static/image/liulangengduo.png" alt=""></a></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
</html>