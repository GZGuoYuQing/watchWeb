<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>手表详情</title>
    <link rel="shortcut icon" href="/images/webLogo.ico" type="image/x-icon" />
    <link href="<%=path %>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
    <script src="<%=path %>/js/jquery-1.11.0.min.js"></script>
    <!--Custom-Theme-files-->
    <!--theme-style-->
    <link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="author" content="Jango, 467524272@qq.com" />
    <meta name="Description" Content="姜戈名品,专注原单,姜戈团队,手表行业顶级复刻,为顾客定制高端复刻手表,定制正品原单鞋子,原单皮具.">
    <meta name="Kyewords" Lang="EN" Content="Jango,Watch,Genuine,Luxury, sports shoes, Famous,Leather goods,Purse">
    <script type="<%=path %>/application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--start-menu-->
    <script src="<%=path %>/js/simpleCart.min.js"> </script>
    <link href="<%=path %>/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="<%=path %>/js/memenu.js"></script>
    <script>$(document).ready(function(){$(".memenu").memenu();});</script>
    <!--dropdown-->
    <script src="<%=path %>/js/jquery.easydropdown.js"></script>
    <script type="text/javascript">
        $(function() {

            var menu_ul = $('.menu_drop > li > ul'),
                    menu_a  = $('.menu_drop > li > a');

            menu_ul.hide();

            menu_a.click(function(e) {
                e.preventDefault();
                if(!$(this).hasClass('active')) {
                    menu_a.removeClass('active');
                    menu_ul.filter(':visible').slideUp('normal');
                    $(this).addClass('active').next().stop(true,true).slideDown('normal');
                } else {
                    $(this).removeClass('active');
                    $(this).next().stop(true,true).slideUp('normal');
                }
            });

        });
        /*导航栏*/
        function mbar(sobj) {
            var docurl =sobj.options[sobj.selectedIndex].value;
            if (docurl != "") {
                open(docurl,'_blank');
                sobj.selectedIndex=0;
                sobj.blur();
            }
        }
    </script>
</head>
<body>
<!--top-header-->
<div class="top-header">
    <div class="container">
        <div class="top-header-main">
            <div class="col-md-6 top-header-left">
                <div class="drop">
                    <div class="box">
                        <select class="dropdown drop" onchange="self.location.href=options[selectedIndex].value">
                            <option value="" class="label">快速进入 :&nbsp;</option>
                            <option value="http://weidian.com/?userid=1093447508">姜戈微店</option>
                            <option value="<%=path%>/index">姜戈官网</option>
                        </select>
                    </div>
                    <div class="box1">
                        <select class="dropdown" onchange=mbar(this) name="select">
                            <option value="" class="label">友情链接 :&nbsp;</option>
                            <option value="<%=path%>/forum/forum">专业技术贴</option>
                            <option value="http://tieba.baidu.com/f?ie=utf-8&kw=姜戈名品">贴吧论坛</option>
                            <option value="http://www.xbiao.com/">腕表之家</option>
                        </select>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="col-md-6 top-header-left">
                <div class="cart box_1">
                    <img src="<%=path %>/images/cart-1.png" style="height:37px;" alt="" />
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--top-header-->
<!--start-logo-->
<div class="logo">
    <p>
        <a
                style="font-weight: bolder; font-family: MingLiU; font-size: 19px;cursor: default;">&nbsp;Jango&nbsp;&nbsp;&nbsp;MingPin</a>
    </p>
    <p>
        <a
                style="font-weight: bolder; font-family: KaiTi; font-size: 38px; color: black;cursor: default;">姜戈名品</a>
    </p>
</div>
<!--start-logo-->
<!--bottom-header 导航条-->
<div class="header-bottom">
    <div class="container">
        <div class="header">
            <div class="col-md-9 header-left">
                <div class="top-nav">
                    <ul class="memenu skyblue">
                        <li class="active"><a href="<%=path%>/index">首页</a></li>
                        <li class="grid"><a href="#">男表</a>
                            <div class="mepanel">
                                <div class="row">
                                    <div class="col1 me-one">
                                        <h4>顶级 复刻</h4>
                                        <ul>
                                            <li><a href="<%=path%>/watch/products/万国/男款">万国(IWC)</a></li>
                                            <li><a href="<%=path%>/watch/products/劳力士/男款">劳力士(Rolex)</a></li>
                                            <li><a href="<%=path%>/watch/products/欧米茄/男款">欧米茄(OMEGA)</a></li>
                                            <li><a href="<%=path%>/watch/products/卡地亚/男款">卡地亚(Cartier)</a></li>
                                            <li><a href="<%=path%>/watch/products/真力时/男款">真力时(Zenith)</a></li>
                                            <li><a href="<%=path%>/watch/products/宇舶/男款">宇舶(Hublot)</a></li>
                                            <li><a href="<%=path%>/watch/products/爱彼/男款">爱彼(Audemars Piguet)</a></li>
                                            <li><a href="<%=path%>/watch/products/积家/男款">积家(Jaeger LeCoultre)</a></li>
                                            <li><a href="<%=path%>/watch/products/宝珀/男款">宝珀(BLANCPAIN)</a></li>
                                            <li><a href="<%=path%>/watch/products/万宝龙/男款">万宝龙(Montblanc)</a></li>
                                            <li><a href="<%=path%>/watch/products/百达翡丽/男款">百达翡丽(Patek Philippe)</a></li>
                                            <li><a href="<%=path%>/watch/products/江诗丹顿/男款">江诗丹顿(Vacheron Constantin)</a></li>
                                            <li><a href="<%=path%>/watch/productsType/男款">更多+</a></li>
                                        </ul>
                                    </div>
                                    <div class="col1 me-one">
                                        <h4>小众 轻奢</h4>
                                        <ul>
                                            <li><a href="<%=path%>/watch/products/浪琴/男款">浪琴(Longines)</a></li>
                                            <li><a href="<%=path%>/watch/products/天梭/男款">天梭(Tissot)</a></li>
                                            <li><a href="<%=path%>/watch/products/美度/男款">美度(Mido)</a></li>
                                            <li><a href="<%=path%>/watch/products/精工/男款">精工(SEIKO)</a></li>
                                            <li><a href="<%=path%>/watch/products/梅花/男款">梅花(Titoni)</a></li>
                                            <li><a href="<%=path%>/watch/products/摩凡陀/男款">摩凡陀(Movado)</a></li>
                                            <li><a href="<%=path%>/watch/products/泰格豪雅/男款">泰格豪雅(TAG Heuer)</a></li>
                                            <li><a href="<%=path%>/watch/productsType/男款">更多+</a></li>
                                        </ul>
                                    </div>
                                    <div class="col1 me-one">
                                        <h4>精致 石英</h4>
                                        <ul>
                                            <li><a href="<%=path%>/watch/products/古驰/男款">古驰(GUCCI)</a></li>
                                            <li><a href="<%=path%>/watch/products/范思哲/男款">范思哲(Versace)</a></li>
                                            <li><a href="<%=path%>/watch/products/阿玛尼/男款">阿玛尼(Armani)</a></li>
                                            <li><a href="<%=path%>/watch/products/卡西欧/男款">卡西欧(Casio)</a></li>
                                            <li><a href="<%=path%>/watch/products/CK/男款">CK(Calvin Klein)</a></li>
                                            <li><a href="<%=path%>/watch/products/施华洛世奇/男款">施华洛世奇(Swarovski)</a></li>
                                            <li><a href="<%=path%>/watch/products/丹尼尔惠灵顿/男款">丹尼尔惠灵顿(Daniel Wellington)</a></li>
                                            <li><a href="<%=path%>/watch/productsType/男款">更多+</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div></li>
                        <li class="grid"><a href="#">女表</a>
                            <div class="mepanel">
                                <div class="row">
                                    <div class="col1 me-one">
                                        <h4>定制 复刻</h4>
                                        <ul>
                                            <li><a href="<%=path%>/watch/products/万国/女款">万国(IWC)</a></li>
                                            <li><a href="<%=path%>/watch/products/宝玑/女款">宝玑(Breguet)</a></li>
                                            <li><a href="<%=path%>/watch/products/劳力士/女款">劳力士(Rolex)</a></li>
                                            <li><a href="<%=path%>/watch/products/欧米茄/女款">欧米茄(OMEGA)</a></li>
                                            <li><a href="<%=path%>/watch/products/卡地亚/女款">卡地亚(Cartier)</a></li>
                                            <li><a href="<%=path%>/watch/products/美度/女款">美度(Mido)</a></li>
                                            <li><a href="<%=path%>/watch/products/香奈儿/女款">香奈儿(Chanel)</a></li>
                                            <li><a href="<%=path%>/watch/products/浪琴/女款">浪琴(Longines)</a></li>
                                            <li><a href="<%=path%>/watch/products/百达翡丽/女款">百达翡丽(Patek Philippe)</a></li>
                                            <li><a href="<%=path%>/watch/products/积家/女款">积家(Jaeger LeCoultre)</a></li>
                                            <li><a href="<%=path%>/watch/products/诺莫斯/女款">诺莫斯(Nomos)</a></li>
                                            <li><a href="<%=path%>/watch/products/江诗丹顿/女款">江诗丹顿(Vacheron Constantin)</a></li>
                                            <li><a href="<%=path%>/watch/products/理查德米勒/女款">理查德米勒(Richard Mille)</a></li>
                                            <li><a href="<%=path%>/watch/productsType/女款">更多+</a></li>
                                        </ul>
                                    </div>
                                    <div class="col1 me-one">
                                        <h4><a href="<%=path%>/watch/productsBSO/all/1"style="color:#73B6E1;">正品 原单</a></h4>
                                        <ul>
                                            <li><a href="<%=path%>/watch/productsBSO/天梭/1">天梭(Tissot)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/古驰/1">古驰(GUCCI)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/范思哲/1">范思哲(Versace)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/阿玛尼/1">阿玛尼(Armani)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/卡西欧/1">卡西欧(Casio)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/摩凡陀/1">摩凡陀(Movado)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/CK/1">CK(Calvin Klein)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/亨利伦敦/1">亨利伦敦(Henry London)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/施华洛世奇/1">施华洛世奇(Swarovski)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/丹尼尔惠灵顿/1">丹尼尔惠灵顿(Daniel Wellington)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/all/1">更多+</a></li>
                                        </ul>
                                    </div>
                                    <div class="col1 me-one">
                                        <h4><a href="<%=path%>/leather/product/all" style="color:#73B6E1;">原单 皮具</a></h4>
                                        <ul>
                                            <li><a href="<%=path%>/leather/product/古驰">古驰(Gucci)</a></li>
                                            <li><a href="<%=path%>/leather/product/迪奥">迪奥(Dior)</a></li>
                                            <li><a href="<%=path%>/leather/product/蔻驰">蔻驰(Coach)</a></li>
                                            <li><a href="<%=path%>/leather/product/登喜路">登喜路(dunhill)</a></li>
                                            <li><a href="<%=path%>/leather/product/范思哲">范思哲(Versace)</a></li>
                                            <li><a href="<%=path%>/leather/product/香奈儿">香奈儿(Chanel)</a></li>
                                            <li><a href="<%=path%>/leather/product/普拉达">普拉达(Prada)</a></li>
                                            <li><a href="<%=path%>/leather/product/爱马仕">爱马仕(Hermès)</a></li>
                                            <li><a href="<%=path%>/leather/product/路易威登">路易威登(L_V)</a></li>
                                            <li><a href="<%=path%>/leather/product/all">更多+</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div></li>
                        <li class="grid"><a href="#">正品原单</a>
                            <div class="mepanel">
                                <div class="row">
                                    <div class="col1 me-one">
                                        <h4><a href="<%=path%>/watch/productsBSO/all/1" style="color: #73B6E1;">原单 手表</a></h4>
                                        <ul>
                                            <li><a href="<%=path%>/watch/productsBSO/天梭/1">天梭(Tissot)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/古驰/1">古驰(Gucci)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/摩凡陀/1">摩凡陀(Movado)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/CK/1">CK(Calvin Klein)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/范思哲/1">范思哲(Versace)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/卡西欧/1">卡西欧(Casio)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/盖尔斯/1">盖尔斯(Guess)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/薇薇安/1">薇薇安(Vivienne)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/施华洛世奇/1">施华洛世奇(Swarovski)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/亨利伦敦/1">亨利伦敦(Henry London)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/丹尼尔惠灵顿/1">丹尼尔惠灵顿(DW)</a></li>
                                            <li><a href="<%=path%>/watch/productsBSO/all/1">更多+</a></li>
                                        </ul>
                                    </div>
                                    <div class="col1 me-one">
                                        <h4><a href="<%=path%>/shose/product/all" style="color: #73B6E1;">原单 运动鞋</a></h4>
                                        <ul>
                                            <li><a href="<%=path%>/shose/product/万斯">万斯(Vans)</a></li>
                                            <li><a href="<%=path%>/shose/product/耐克">耐克(Nike)</a></li>
                                            <li><a href="<%=path%>/shose/product/彪马">彪马(Puma)</a></li>
                                            <li><a href="<%=path%>/shose/product/匡威">匡威(Convers)</a></li>
                                            <li><a href="<%=path%>/shose/product/锐步">锐步(Reebok)</a></li>
                                            <li><a href="<%=path%>/shose/product/亚瑟士">亚瑟士(Asics)</a></li>
                                            <li><a href="<%=path%>/shose/product/乔丹">乔丹(JordanBrand)</a></li>
                                            <li><a href="<%=path%>/shose/product/新百伦">新百伦(New Balance)</a></li>
                                            <li><a href="<%=path%>/shose/product/斯凯奇">斯凯奇(Skechres)</a></li>
                                            <li><a href="<%=path%>/shose/product/阿迪达斯">阿迪达斯(Adidas)</a></li>
                                            <li><a href="<%=path%>/shose/product/all">更多+</a></li>
                                        </ul>
                                    </div>
                                    <div class="col1 me-one">
                                        <h4><a href="<%=path%>/leather/product/all" style="color: #73B6E1;">原单 皮具</a></h4>
                                        <ul>
                                            <li><a href="<%=path%>/leather/product/古驰">古驰(Gucci)</a></li>
                                            <li><a href="<%=path%>/leather/product/迪奥">迪奥(Dior)</a></li>
                                            <li><a href="<%=path%>/leather/product/蔻驰">蔻驰(Coach)</a></li>
                                            <li><a href="<%=path%>/leather/product/登喜路">登喜路(dunhill)</a></li>
                                            <li><a href="<%=path%>/leather/product/范思哲">范思哲(Versace)</a></li>
                                            <li><a href="<%=path%>/leather/product/香奈儿">香奈儿(Chanel)</a></li>
                                            <li><a href="<%=path%>/leather/product/普拉达">普拉达(Prada)</a></li>
                                            <li><a href="<%=path%>/leather/product/爱马仕">爱马仕(Hermès)</a></li>
                                            <li><a href="<%=path%>/leather/product/路易威登">路易威登(L_V)</a></li>
                                            <li><a href="<%=path%>/leather/product/all">更多+</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div></li>
                        <li class="grid"><a href="http://tieba.baidu.com/f?ie=utf-8&kw=姜戈名品">论坛入口</a></li>
                        <li class="grid"><a href="<%=path%>/forum/forum">贴子专区</a></li>
                        <li class="grid"><a>微信二维码</a>
                            <div class="mepanel">
                                <div class="row">
                                    <div class="col1 me-one">
                                        <a style="text-decoration: none">扫我加好友&nbsp;&nbsp;&nbsp;&nbsp;了解详情</a>
                                        <img alt="微信号:gyq18370949034" src="<%=path %>/images/6666.jpg" style="margin-left: 224px">
                                    </div>
                                </div>
                            </div></li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-3 header-right">
                <div class="search-bar">
                    <form action="<%=path%>/watch/queryByTitleDes" method="get" target="_blank">
                        <input type="text" name = "value" value="请输入手表品牌/型号/款式" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = '请输入手表品牌/型号/款式';}">
                        <input type="submit" value="">
                    </form>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--bottom-the end header  导航条结束-->
<!--start-breadcrumbs-->
<div class="breadcrumbs">
    <div class="container">
        <div class="breadcrumbs-main">
            <ol class="breadcrumb" style="margin-bottom: 0px;">
                <li><a href="<%=path%>/index">首页</a></li>
                <li class="active"><a href="<%=path%>/watch/products/${requestScope.watch.brand.des}/${requestScope.watch.type}">${requestScope.watch.brand.des}${requestScope.watch.type}</a></li>
                <li class="active">手表详情</li>
            </ol>
        </div>
    </div>
</div>
<!--end-breadcrumbs-->
<!--start-single-->
<div class="single contact">
    <div class="container">
        <div class="single-main">
            <div class="col-md-9 single-main-left">
                <div class="sngl-top">
                    <div class="col-md-5 single-top-left">
                        <div class="flexslider">
                            <ul class="slides">
                                <li data-thumb="<%=path %>/${requestScope.watch.image}">
                                    <div class="thumb-image"> <img src="<%=path %>/${requestScope.watch.image}" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                </li>
                                <li data-thumb="<%=path %>/${requestScope.watch.image1}">
                                    <div class="thumb-image"> <img src="<%=path %>/${requestScope.watch.image1}" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                </li>
                                <li data-thumb="<%=path %>/${requestScope.watch.image2}">
                                    <div class="thumb-image"> <img src="<%=path %>/${requestScope.watch.image2}" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                </li>
                                <li data-thumb="<%=path %>/${requestScope.watch.image3}">
                                    <div class="thumb-image"> <img src="<%=path %>/${requestScope.watch.image3}" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                </li>
                                <li data-thumb="<%=path %>/${requestScope.watch.image4}">
                                    <div class="thumb-image"> <img src="<%=path %>/${requestScope.watch.image4}" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                </li>
                                <li data-thumb="<%=path %>/${requestScope.watch.image5}">
                                    <div class="thumb-image"> <img src="<%=path %>/${requestScope.watch.image5}" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                </li>
                            </ul>
                        </div>
                        <!-- FlexSlider -->
                        <script src="<%=path %>/js/imagezoom.js"></script>
                        <script defer src="<%=path %>/js/jquery.flexslider.js"></script>
                        <link rel="stylesheet" href="<%=path %>/css/flexslider.css" type="text/css" media="screen" />

                        <script>
                            // Can also be used with $(document).ready()
                            $(window).load(function() {
                                $('.flexslider').flexslider({
                                    animation: "slide",
                                    controlNav: "thumbnails"
                                });
                            });
                        </script>
                    </div>
                    <div class="col-md-7 single-top-right">
                        <div class="single-para simpleCart_shelfItem">
                            <h2>${requestScope.watch.title}</h2>
                            <div class="star-on">
                                <ul class="star-footer">
                                    <li><a href=""><i> </i></a></li>
                                    <li><a href=""><i> </i></a></li>
                                    <li><a href=""><i> </i></a></li>
                                    <li><a href=""><i> </i></a></li>
                                    <li><a href=""><i> </i></a></li>
                                </ul>
                                <div class="review">
                                    <a href="#">推荐热度</a>

                                </div>
                                <div class="clearfix"> </div>
                            </div>

                            <h5 class="item_price">￥${requestScope.watch.price}</h5>
                            <p>手表功能&nbsp;&nbsp;:&nbsp;<a class="function" style="text-decoration: none;margin-left: 7%;">${requestScope.watch.function}</a></p>
                            <div class="available">
                                <ul>
                                    <li>表盘类型<select>
                                        <option>罗马字面</option>
                                        <option>数字字面</option>
                                        <option>钻石字面</option>
                                        <option>镂空字面</option>
                                    </select></li>
                                    <li class="size-in">表盘尺寸<select>
                                        <option>36mm以下</option>
                                        <option>36-39mm</option>
                                        <option>39-42mm</option>
                                        <option>42-45mm</option>
                                        <option>45mm以上</option>
                                    </select></li>
                                    <div class="clearfix"> </div>
                                </ul>
                            </div>
                            <ul class="tag-men">
                                <li><span>款式&nbsp;&nbsp;&nbsp;:</span>
                                    <span class="women1">${requestScope.watch.type}</span></li>
                                <li><span>类型&nbsp;&nbsp;&nbsp;:</span>
                                    <span class="women1">${requestScope.watch.style.des}</span></li>
                                <li><span>镜面&nbsp;&nbsp;&nbsp;:</span>
                                    <span class="women1">${requestScope.watch.lens}</span></li>
                            </ul>
                            <a href="#" class="add-cart item_add">立即购买</a>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="tabs">
                    <ul class="menu_drop">
                        <li class="item1"><a href=""><img src="<%=path %>/images/arrow.png" alt="">手表参数</a>
                            <ul class="parameter1" style="background: #fff;">
                                <li class="subitem0"><span class="parameter"style="height: 20px;"></span></li>
                                <li class="subitem1"><span class="parameter">品牌：${requestScope.watch.brand.des}</span></li>
                                <li class="subitem4"><span class="parameter">产地：${requestScope.watch.origin.des}</span></li>
                                <li class="subitem4"><span class="parameter">风格：${requestScope.watch.style.des}</span></li>
                                <li class="subitem3"><span class="parameter">款式：${requestScope.watch.type}</span></li>
                                <li class="subitem4"><span class="parameter">尺寸：${requestScope.watch.size}</span></li>
                                <li class="subitem4"><span class="parameter">功能：${requestScope.watch.function}</span></li>
                                <p><i class="parameter" style="height: 100%;font-style: normal;">描述：<b style="font-size: 14px;font-weight: normal;">${requestScope.watch.des}</b></i></p>
                                <li class="subitem4"><span class="parameter">材质：${requestScope.watch.material.des}</span></li>
                                <li class="subitem2"><span class="parameter">机芯：${requestScope.watch.core.des}</span></li>
                            </ul>
                        </li>
                        <li class="item2"><a href="#"><img src="<%=path %>/images/arrow.png" alt="">手表细节图片</a>
                            <ul>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image1}" style="width: 100%"></li>
                                <li class="subitem2"><img alt="" src="/${requestScope.watch.image2}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image3}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image4}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image5}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image6}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image7}" style="width: 100%"></li>
                                <li class="subitem0"><img alt="" src="/${requestScope.watch.image8}" style="width: 100%"></li>
                            </ul>
                        </li>
                        <li class="item3"><a href="#"><img src="<%=path %>/images/arrow.png" alt="">实拍视频</a>
                            <ul>
                                <li>
                                    <video src="/${requestScope.watch.video}" id = "video" controls="controls" style="width: 100%;">抱歉,您的浏览器无法播放视频.</video>
                                </li>
                            </ul>
                        </li>
                        <li class="item4"><a href="#"><img src="<%=path %>/images/arrow.png" alt="">了解更多详情加我微信</a>
                            <ul>
                                <li class="subitem2"><img alt="" src="<%=path %>/images/6666.jpg" style="width: 40%;"></li>
                            </ul>
                        </li>

                        <li class="item5"><a href="#"><img src="<%=path %>/images/arrow.png" alt="">退换货说明</a>
                            <ul>
                                <li class="subitem0" style="height: 20px"><span> </span></li>
                                <li class="subitem1"> <span style="margin-top: 0%"><h3>实物拍摄：</h3>
                                    <p style="font-size: 16px;text-indent: 10em;">姜戈工作室承诺，所售商品均是100%实物拍摄。</p>
                                    </span></li>
                                <li class="subitem0" style="height: 0px"><span> </span></li>
                                <li class="subitem1"> <span style="margin-top: 0%"><h3>关于尺寸：</h3>
                                    <p style="font-size: 16px;text-indent: 10em;">姜戈工作室保证，描述尺寸100%和实物匹配,细节详情可加姜戈工作室微信。</p>
                                    </span></li>
                                <li class="subitem0" style="height: 0px"><span> </span></li>
                                <li class="subitem1"> <span style="margin-top: 0%"><h3>关于发货：</h3>
                                    <p style="font-size: 16px;text-indent: 10em;">姜戈工作室合作快递为顺丰快递，力求每块表都安全 便捷 迅速的到达每位顾客手上.</p>
                                    </span></li>
                                <li class="subitem0" style="height: 0px"><span> </span></li>
                                <li class="subitem1"> <span style="margin-top: 0%"><h3>关于退货：</h3>
                                    <p style="font-size: 16px;text-indent: 10em;">姜戈工作室秉持7天无理由退换货，退货前请一定先联系姜戈工作室人员，我们一定第一时间为您处理.保证您购物放心无忧.</p>
                                    </span></li>
                                <li class="subitem0" style="height: 0px"><span> </span></li>
                                <li class="subitem1"> <span style="margin-top: 0%"><h3>关于售后：</h3>
                                    <p style="font-size: 16px;text-indent: 10em;">姜戈工作室复刻品质的手表无人为损坏保修一年,瑞士定制级保修二年,原单正品机芯保修二年,如果您在任何使用过程中手表产生了偷停，动力不足的情况，请不要自己盲目拆卸，请联系姜戈售后.在保修时间范围内我们会及时为您维修或者更换机芯，返修的周期为10天左右</p>
                                    </span></li>
                            </ul>
                        </li>

                    </ul>
                </div>
                <div class="latestproducts">
                    <div class="product-one">
                        <c:forEach items="${requestScope.watchs}" var="w">
                            <div class="col-md-4 product-left p-left">
                                <div class="product-main simpleCart_shelfItem">
                                    <a href="/watch/details/${w.id}" class="mask"><img class="img-responsive zoom-img" src="<%=path %>/${w.image}" alt="" /></a>
                                    <div class="product-bottom">
                                        <h3>${w.title}</h3>
                                        <p>${w.style.des}</p>
                                        <h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">$ ${w.price}</span></h4>
                                    </div>
                                    <div class="srch">
                                        <span>${w.table}</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 single-right">
                <div class="w_sidebar">
                    <form action="/watch/queryByPrices" method="get">
                        <section  class="sky-form">
                            <h4>手表分类</h4>
                            <div class="row1 scroll-pane">
                                <div class="col col-4">
                                    <label class="checkbox"><input type="radio" name="type"  value="男款"checked=""><i></i>男表系列</label>
                                    <label class="checkbox"><input type="radio" name="type"  value="女款"><i></i>女表系列</label>
                                    <label class="checkbox"><input type="radio" name="type"  value="男款"><i></i>机械系列</label>
                                    <label class="checkbox"><input type="radio" name="type"  value="女款"><i></i>石英系列</label>
                                </div>
                            </div>
                        </section>
                        <section  class="sky-form">
                            <h4>品牌选择</h4>
                            <div class="row1 row2 scroll-pane">
                                <div class="col col-4">
                                    <label class="checkbox"><input type="radio" name="des" value=""checked=""><i></i>所有品牌</label>
                                    <label class="checkbox"><input type="radio" name="des" value="百达翡丽"><i></i>百达翡丽(PP)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="劳力士"><i></i>劳力士(Rolex)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="欧米茄"><i></i>欧米茄(OMEGA)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="卡地亚"><i></i>卡地亚(Cartier)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="真力时"><i></i>真力时(Zenith)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="万国" ><i></i>万国(IWC)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="爱彼"><i></i>爱彼(AP)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="帝舵"><i></i>帝舵(Tudor)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="积家"><i></i>积家(JL)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="浪琴"><i></i>浪琴(LONGINES)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="天梭"><i></i>天梭(TISSOT)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="美度"><i></i>美度(MIDO)</label>
                                    <label class="checkbox"><input type="radio" name="des" value="诺莫斯"><i></i>诺莫斯(Nomos)</label>
                                </div>
                            </div>
                        </section>
                        <section class="sky-form">
                            <h4>价格区间</h4>
                            <div class="row1 row2 scroll-pane" style="overflow: hidden">
                                <div class="col col-4">
                                    <label class="radio"><input type="radio" name="prices"value="6"checked=""><i></i>所有</label>
                                    <label class="radio"><input type="radio" name="prices"value="1"><i></i>2000以下</label>
                                    <label class="radio"><input type="radio" name="prices"value="2"><i></i>2000至3500</label>
                                    <label class="radio"><input type="radio" name="prices"value="3"><i></i>3500至4500</label>
                                    <label class="radio"><input type="radio" name="prices"value="4"><i></i>4500至5500</label>
                                    <label class="radio"><input type="radio" name="prices"value="5"><i></i>5500以上</label>
                                </div>
                            </div>
                        </section>
                        <section class="sky-form">
                            <h4><input type="submit" value="搜索"/></h4>
                            <!-- 	<ul class="w_nav2">
                                    <li><a class="color1" href="#"></a></li>
                                    <li><a class="color2" href="#"></a></li>
                                </ul> -->
                        </section>
                    </form>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--end-single-->
<!--information-starts-->
<div class="information">
    <div class="container">
        <div class="infor-top">
            <div class="col-md-3 infor-left">
                <h3>
                    <b
                            style="font-weight: bolder; font-family: KaiTi; font-size: 23px; color: black;">关于我们</b>
                </h3>
                <ul>
                    <li><a href="#"><span class="fb"></span>
                        <h6>Facebook</h6></a></li>
                    <li><a href="#"><span class="twit"></span>
                        <h6>Twitter</h6></a></li>
                    <li><a href="#"><span class="google"></span>
                        <h6>Google+</h6></a></li>
                </ul>
            </div>
            <div class="col-md-3 infor-left">
                <h3>
                    <b
                            style="font-weight: bolder; font-family: KaiTi; font-size: 23px; color: black;">动态信息</b>
                </h3>
                <ul>
                    <li><a href="<%=path%>/forum/forum"><p>最新 复刻贴</p></a></li>
                    <li><a href="<%=path%>/watch/queryByTitleDes?value=定制"><p>最新 独家定制</p></a></li>
                    <li><a href="<%=path%>/watch/queryByTitleDes?value=机械"><p>畅销 机械表表</p></a></li>
                    <li><a href="<%=path%>/watch/productsBSO/all/2"><p>打折处理表</p></a></li>
                    <li><a href="http://weidian.com/?userid=1093447508"><p>保修 退换</p></a></li>
                </ul>
            </div>
            <div class="col-md-3 infor-left">
                <h3>
                    <b
                            style="font-weight: bolder; font-family: KaiTi; font-size: 23px; color: black;">合作厂家</b>
                </h3>
                <ul>
                    <li><a style="cursor: default;"><p>Noob Factory</p></a></li>
                    <li><a style="cursor: default;"><p>V6 Factory</p></a></li>
                    <li><a style="cursor: default;"><p>KW Factory</p></a></li>
                    <li><a style="cursor: default;"><p>MK Factory</p></a></li>
                    <li><a style="cursor: default;"><p>ZF Factory</p></a></li>
                </ul>
            </div>
            <div class="col-md-3 infor-left">
                <h3>
                    <b style="font-weight: bolder; font-family: KaiTi; font-size: 23px; color: black;">工作室信息</b>
                </h3>
                <h4>
                    工作室地址： <span>广东省佛山市南海区银河路89号(主地址)</span>
                    <span>江西省赣州市沙河金属物流城19栋(复地址)</span>
                    <span>湖南省长沙天心区上海城12栋(复地址)</span>
                </h4>
                <h5>18370949034(郭姜戈)</h5>
                <p>
                    <a>微信: gyq18370949034</a>
                </p>
                <p>
                    <a>QQ: 3234396045</a>
                </p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--information-end-->
<!--footer-starts-->
<div class="footer">
    <div class="container">
        <div class="footer-top">
            <div class="col-md-6 footer-left">
                <form action="<%=path%>/watch/queryByTitleDes" method="get" target="_blank">
                    <input type="text" name="value" value="搜索品牌关键字"
                           onfocus="this.value = '';"
                           onblur="if (this.value == '') {this.value = '搜索品牌关键字';}">
                    <input type="submit" value="搜索">
                </form>
            </div>
            <div class="col-md-6 footer-right">
                <p>姜戈名品团队成立于<strong>2013年5月</strong>，为追求顶级复刻不断和厂家合作，<strong>自主更新</strong>，几年来为许多复刻玩家提供<strong>定制级复刻表</strong></p>
                <p><strong>诚信经营</strong>，在业界享有优良口碑和声誉。&nbsp;&nbsp;&nbsp;&nbsp;我们的服务态度&nbsp;&nbsp;和质量保障&nbsp;&nbsp;以及售后维修上都是<strong>高于同行，优于同行</strong></p>
                <p>姜戈名品 &nbsp;行业顶尖&nbsp;&nbsp;&nbsp;&nbsp;专注<strong>高端奢侈复刻</strong></p>
                <p>&copy; 2013.姜戈名品顶尖复刻表团队&nbsp;&nbsp;版权所有.</p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--footer-end-->
</body>
</html>