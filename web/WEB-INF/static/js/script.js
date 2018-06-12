$(document).ready(function () {
        var timer = null;
        var index = 0;
        var pics = $(".banner").find("div");
        var dots = $(".dots").children("span");
        var len = pics.length;
        var indexPre = len - 1;
        var indexNext = 1;
        var prev = $(".prev");
        var next = $(".next");
        var menuContent = $(".menu-content");
        var menu = menuContent.children("div");
        var subMenu = $(".sub-menu");
        var subItems = subMenu.children(".inner-box");
        var menuItems = menu;
        var main = $("#main");

        // 清除定时器,停止自动播放
        function stopAutoPlay() {
            if (timer) {
                clearInterval(timer);
            }
        }

// 图片自动轮播
        function startAutoPlay() {
            timer = setInterval(function () {
                var tmp = index;
                index = (index + 1) % len;
                indexPre = tmp;
                indexNext = (index + 1) % len;
                changeImg();
            }, 3000)
        }

        function slideImg() {
            main.mouseover(function () {
                stopAutoPlay();
            });
            main.mouseout(function () {
                stopAutoPlay();
                startAutoPlay();
            });
            //自动在main上触发鼠标离开的事件
            main.trigger("mouseout");
            // 点击导航切换
            for (var i = 0; i < len; i++) {
                dots.eq(i).attr("id", i);
                dots.eq(i).click(function () {

                    dots.eq(index).attr("class", "");
                    pics.eq(index).fadeOut(1000);
                    index = parseInt($(this).attr("id").replace(/[^0-9]/ig,""));//截取数字
                    dots.eq(index).attr("class", "active");
                    pics.eq(index).fadeIn(1000);
                    indexPre = (index - 1 + len) % len;
                    indexNext = (index + 1) % len;
                });
            }

            // 下一张
            next.click(function () {
                var tmp = index;
                index = indexNext;
                indexPre = tmp;
                indexNext = (index + 1) % len;
                changeImg();
            });

            // 上一张
            prev.click(function () {
                var tmp = index;
                index = indexPre;
                indexNext = tmp;
                indexPre = (index - 1 + len) % len;
                changeImg();
            });

            //导航菜单
            //遍历主菜单，且绑定点击事件
            for (var m = 0; m < menuItems.length; m++) {
                menuItems.eq(m).attr("data-index", m);
                menuItems.eq(m).mouseover(function () {
                    subMenu.attr("class", "sub-menu");
                    var idx = $(this).attr("data-index");
                    for (var j = 0; j < subItems.length; j++) {
                        subItems.eq(j).css("display", 'none');
                        menuItems.eq(j).css("background", 'none');
                    }
                    subItems.eq(idx).css("display", 'block');
                    menuItems.eq(idx).css("background", '#ff6700');
                });
            }
            menuContent.mouseout(function () {
                for (var i = 0; i < menuItems.length; i++) {
                    menuItems.eq(i).css("background", 'none');
                }
                subMenu.attr("class", "sub-menu hide");
            });
            subMenu.mouseover(function () {
                $(this).attr("class", "sub-menu");
            });
            subMenu.mouseout(function () {
                $(this).attr("class", "sub-menu hide");
            });
        }

        function changeImg() {
            // console.log("in change image")
            // console.log("indexPre = " + indexPre);
            // console.log("index = " + index);
            // console.log("indexNext = " + indexNext);
            dots.eq(indexPre).attr("class", "");
            dots.eq(index).attr("class", "active");
            dots.eq(indexNext).attr("class", "");
            pics.eq(indexPre).fadeOut(1000);
            pics.eq(index).fadeIn(1000);
            pics.eq(indexNext).fadeOut(0);
        }

        slideImg();
    }
)
