<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>众筹网</title>
        <meta charset="utf-8">
        <meta name="keywords" content="crowdfunding,financing" />
        <meta name="description" content="Sign up for Projects We Love to receive a weekly mix of noteworthy projects, handpicked by our team." />
        <meta name="renderer" content="webkit" />
        <link rel="shortcut icon"  type="image/png" href="${pageContext.request.contextPath}/images/logo1.png.png" />
        <script type="text/javascript"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tuniu.css" />
        <script src="../js/jquery-2.1.4.min.js"></script>
        <script src="../js/index.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/2.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/1.css" />



        <link href="${pageContext.request.contextPath}/css/juanda-pagehelper.css" rel="stylesheet">
        <script src=//cdn.bootcss.com/jquery/1.11.3/jquery.js></script>
        <script src="${pageContext.request.contextPath}/js/juanda-pagehelper.js"></script>
        <link rel="stylesheet" href="https://terryz.github.io/lib/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome-4.5.0/css/font-awesome.min.css" />
        <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />

        <script src="${pageContext.request.contextPath}/js/http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/b.page.js" ></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/demo.js" ></script>
        <script src="${pageContext.request.contextPath}/js/mo.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/b.page.bootstrap3.css" type="text/css">
        <script type="text/javascript">
            $("#userSelect").click(function(e){
//屏蔽父元素的事件响应
                e.stopPropagation();
                // alert("This is Click me button");
            });
        </script>
        <script>
            var serverHost=document.location.protocol+"//"+document.domain+":"+location.port;
            // $(document).ready(function() {
            //     list(1,5);
            // });

            $(document).ready(function() {
                var uid=${user.user_ID};
                    $("#show").append("<a href='#' data-href='#' class='siteM_fqBtn btn_ALink js-checkLogin' onclick='additem()'>Financing</a>");
                list2(1,6);
            });

            function test2(obj){
                var number=obj;
                window.location.href='showItem.htm?ID='+number;
            }

            function gotoMyPage(){
                window.location.href='index.htm';

            }

            function gotoMyPage_Supporter(){
                window.location.href='MyPage_Supporter.htm';
            }

            function gotoMyPage_Investor(){
                window.location.href='MyPage_Investor.htm';
            }

            function additem(mypage){
                window.location.href='addItem.htm';
            }

            function Deposit(mypage){
                window.location.href='deposit.htm';
            }

            function Home(mypage){
                window.location.href='success.htm';
            }

            function list2(pageNum,pageSize) {
                $("#alltype").show();
                $("#type1").hide();
                $.ajax({
                    type: "POST",
                    url: serverHost+"/lists",
                    data: {
                        pageNum:pageNum,
                        pageSize:pageSize
                    },
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: 'json',
                    success: function(data){
                        if(data.endRow!=0){
                            $(".p-list-con2").empty();

                            $.each(data.list,function (i,item) {
                                // console.log(i);
                                if ((i+1)%3==1)
                                    $(".p-list-con2").append("<tr>");
                                var it=(item.Item_DemandMoney-item.Item_StillDemandMoney)/item.Item_DemandMoney;
                                var its=item.item_ID;
                                it=it.toFixed(2)*100;


                                $(".p-list-con2").append(
                                    "<td>"+
                                        "<div class='indCardItem'>"+
                                            "<a href='3.html' class='siteCardItemImgA ind' target='_blank'>"+
                                                "<img src='../images/B"+its+".jpg' onclick='test2("+item.item_ID+")' alt='你所向往的诗与远方，已经在他的绚烂画里了' />"+
                                                "<span class='siteCardStatus'></span>"+
                                            "</a>"+
                                            "<div class='indCardICBox siteCardICBox'>"+
                                                "<div class='indCardICText'>"+
                                                    "<a class='siteCardICH3' target='_blank' onclick='test2("+item.item_ID+")'>"+item.item_ID+"  "+item.Item_Title+"</a>"+
                                                    "<ol class='grid'id='userSelect' name='userSelect' onclick='addNum2("+item.item_ID+","+item.item_LikerNumeber+")'>"+
                                                        "<li class='grid__item'>" +
                                                            "<button class='icobutton icobutton--thumbs-up'><span class='fa fa-thumbs-up'></span></button>"+
                                                        "</li>" +
                                                    "</ol>"+

                                                    // "<input id='userSelect' type='button' name='userSelect' value='LIKE'  onclick='addNum2("+item.item_ID+","+item.Item_SupporterNumber+")'>"+
                                                    "<p class='siteCardIC_p ind'>"+item.Item_Discription+"</p>"+
                                                "</div>"+
                                                "<div class='siteCardFBox'>"+
                                                    "<div class='siteCardFLabelBox siteIlB_box'>"+
                                                        "<a href='#' class='site_ALink siteIlB_item' target='_blank'>SHanghai</a>"+
                                                        "<a href='#' class='site_ALink siteIlB_item' target='_blank'>Lu JiaZui</a>"+
                                                    "</div>"+
                                                    "<div class='siteCardRatio'>"+
                                                        "<div class='siteCardRatioInner' style='width: "+it+"%'>"+
                                                        "</div>"+
                                                    "</div>"+
                                                    "<div class='siteCardFData'>"+
                                                        "<div class='ftDiv'>"+
                                                            "<p class='ftP'>$"+item.Item_DemandMoney+"</p>"+
                                                            "<p class='scP'>pledged of goal</p>"+
                                                        "</div>"+
                                                        "<div class='scDiv'>"+
                                                            "<p class='ftP_support"+item.item_ID+"'>"+item.item_LikerNumeber+"</p>"+
                                                            "<p class='scP'>Like</p>"+
                                                        "</div>"+
                                                        "<div class='thDiv'>"+
                                                            "<p class='ftP'>"+it+"%</p>"+
                                                            "<p class='scP'>Processing</p>"+
                                                        "</div>"+
                                                    "</div>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                   "</td>");
                                if ((i+1)%3==0)
                                    $(".p-list-con2").append("</tr>");

                            });

                            JUANDATOOLS.paginator(data,function (page) {
                                list2(page,6);
                            },false,200,"pagination2");
                            $(".p-list-con2").append("<script src='../js/mo.min.js'/>"+
                                "<script src='../js/demo.js'/>");
                        }else{
                            $(".p-list-con2").empty();
                            $(".p-list-con2").append("<p class='err-tip'>Sorry, did not find you need.</p>");
                        }
                    },
                    error: function(jqXHR){
                        alert("Can not connect to the server .Error：" + jqXHR.status);
                    }
                });
            }



            function search(pageNum,pageSize){
                var content=document.getElementById("search").value;
                $("#alltype").hide();
                $("#type1").show();
                $.ajax({
                    type: "POST",
                    url: serverHost+"/search",
                    data: {
                        pageNum:pageNum,
                        pageSize:pageSize,
                        content:content,
                    },
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: 'json',
                    success: function(data){
                        if(data.endRow!=0){
                            $(".p-list-con3").empty();
                            $.each(data.list,function (i,item) {
                                // console.log(i);
                                if ((i+1)%3==1)
                                    $(".p-list-con3").append("<tr>");
                                var it=(item.Item_DemandMoney-item.Item_StillDemandMoney)/item.Item_DemandMoney;
                                var its=item.item_ID%6;
                                it=it.toFixed(2);


                                $(".p-list-con3").append(
                                    "<td>"+
                                    "<div class='indCardItem'>"+
                                    "<a href='3.html' class='siteCardItemImgA ind' target='_blank'>"+
                                    "<img src='../images/B"+item.item_ID+".jpg' onclick='test2("+item.item_ID+")' alt='你所向往的诗与远方，已经在他的绚烂画里了' />"+
                                    "<span class='siteCardStatus'></span>"+
                                    "</a>"+
                                    "<div class='indCardICBox siteCardICBox'>"+
                                    "<div class='indCardICText'>"+
                                    "<a href='#' class='siteCardICH3' target='_blank' onclick='test2("+item.item_ID+")'>"+item.item_ID+"  "+item.Item_Title+"</a>"+
                                    "<ol class='grid'id='userSelect' name='userSelect' onclick='addNum2("+item.item_ID+","+item.item_LikerNumeber+")'>"+
                                    "<li class='grid__item'>" +
                                    "<button class='icobutton icobutton--thumbs-up'><span class='fa fa-thumbs-up'></span></button>"+
                                    "</li>" +
                                    "</ol>"+
                                    // "<input id='userSelect' type='button' name='userSelect' value='LIKE'  onclick='addNum2("+item.item_ID+","+item.Item_SupporterNumber+")'>"+
                                    "<p class='siteCardIC_p ind'>"+item.Item_Discription+"</p>"+
                                    "</div>"+
                                    "<div class='siteCardFBox'>"+
                                    "<div class='siteCardFLabelBox siteIlB_box'>"+
                                    "<a href='#' class='site_ALink siteIlB_item' target='_blank'>Shanghai</a>"+
                                    "<a href='#' class='site_ALink siteIlB_item' target='_blank'>Xu Hui</a>"+
                                    "</div>"+
                                    "<div class='siteCardRatio'>"+
                                    "<div class='siteCardRatioInner' style='width: "+it+"%'>"+
                                    "</div>"+
                                    "</div>"+
                                    "<div class='siteCardFData'>"+
                                    "<div class='ftDiv'>"+
                                    "<p class='ftP'>$"+item.Item_DemandMoney+"</p>"+
                                    "<p class='scP'>pledged of goal</p>"+
                                    "</div>"+
                                    "<div class='scDiv'>"+
                                    "<p class='ftP_support"+item.item_ID+"'>"+item.item_LikerNumeber+"</p>"+
                                    "<p class='scP'>Like</p>"+
                                    "</div>"+
                                    "<div class='thDiv'>"+
                                    "<p class='ftP'>"+it+"%</p>"+
                                    "<p class='scP'>Processing</p>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>"+
                                    "</td>");
                                if ((i+1)%3==0)
                                    $(".p-list-con3").append("</tr>");
                            });

                            JUANDATOOLS.paginator(data,function (page) {
                                list_catalog1(page,6,num);
                            },false,200,"pagination3");
                            $(".p-list-con3").append("<script src='../js/mo.min.js'/>"+
                                "<script src='../js/demo.js'/>");
                        }else{
                            $(".p-list-con3").empty();
                            $(".p-list-con3").append("<p class='err-tip'>Sorry, did not find you need.</p>");
                        }
                    },
                    error: function(jqXHR){
                        alert("Can not connect to the server .Error：" + jqXHR.status);
                    }
                });
            }
            function list_catalog1(pageNum,pageSize,num) {
                $("#alltype").hide();
                $("#type1").show();
                $.ajax({
                    type: "POST",
                    url: serverHost+"/lists_catalog"+num,
                    data: {
                        pageNum:pageNum,
                        pageSize:pageSize
                    },
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: 'json',
                    success: function(data){
                        if(data.endRow!=0){
                            $(".p-list-con3").empty();
                            $.each(data.list,function (i,item) {
                                // console.log(i);
                                if ((i+1)%3==1)
                                    $(".p-list-con3").append("<tr>");
                                var it=(item.Item_DemandMoney-item.Item_StillDemandMoney)/item.Item_DemandMoney;
                                var its=item.item_ID%6;
                                it=it.toFixed(2);


                                $(".p-list-con3").append(
                                    "<td>"+
                                    "<div class='indCardItem'>"+
                                    "<a href='3.html' class='siteCardItemImgA ind' target='_blank'>"+
                                    "<img src='../images/B"+item.item_ID+".jpg' onclick='test2("+item.item_ID+")' alt='你所向往的诗与远方，已经在他的绚烂画里了' />"+
                                    "<span class='siteCardStatus'></span>"+
                                    "</a>"+
                                    "<div class='indCardICBox siteCardICBox'>"+
                                    "<div class='indCardICText'>"+
                                    "<a href='#' class='siteCardICH3' target='_blank' onclick='test2("+item.item_ID+")'>"+item.item_ID+"  "+item.Item_Title+"</a>"+
                                    "<ol class='grid'id='userSelect' name='userSelect' onclick='addNum2("+item.item_ID+","+item.item_LikerNumeber+")'>"+
                                    "<li class='grid__item'>" +
                                    "<button class='icobutton icobutton--thumbs-up'><span class='fa fa-thumbs-up'></span></button>"+
                                    "</li>" +
                                    "</ol>"+
                                    // "<input id='userSelect' type='button' name='userSelect' value='LIKE'  onclick='addNum2("+item.item_ID+","+item.Item_SupporterNumber+")'>"+
                                    "<p class='siteCardIC_p ind'>"+item.Item_Discription+"</p>"+
                                    "</div>"+
                                    "<div class='siteCardFBox'>"+
                                    "<div class='siteCardFLabelBox siteIlB_box'>"+
                                    "<a href='#' class='site_ALink siteIlB_item' target='_blank'>Shanghai</a>"+
                                    "<a href='#' class='site_ALink siteIlB_item' target='_blank'>Pu dong</a>"+
                                    "</div>"+
                                    "<div class='siteCardRatio'>"+
                                    "<div class='siteCardRatioInner' style='width: "+it+"%'>"+
                                    "</div>"+
                                    "</div>"+
                                    "<div class='siteCardFData'>"+
                                    "<div class='ftDiv'>"+
                                    "<p class='ftP'>$"+item.Item_DemandMoney+"</p>"+
                                    "<p class='scP'>pledged of goal</p>"+
                                    "</div>"+
                                    "<div class='scDiv'>"+
                                    "<p class='ftP_support"+item.item_ID+"'>"+item.item_LikerNumeber+"</p>"+
                                    "<p class='scP'>Like</p>"+
                                    "</div>"+
                                    "<div class='thDiv'>"+
                                    "<p class='ftP'>"+it+"%</p>"+
                                    "<p class='scP'>Processing</p>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>"+
                                    "</div>"+
                                    "</td>");
                                if ((i+1)%3==0)
                                    $(".p-list-con3").append("</tr>");
                            });

                            JUANDATOOLS.paginator(data,function (page) {
                                list_catalog1(page,6,num);
                            },false,200,"pagination3");
                            $(".p-list-con3").append("<script src='../js/mo.min.js'/>"+
                                "<script src='../js/demo.js'/>");
                        }else{
                            $(".p-list-con3").empty();
                            $(".p-list-con3").append("<p class='err-tip'>Sorry, did not find you need.</p>");
                        }
                    },
                    error: function(jqXHR){
                        alert("Can not connect to the server .Error：" + jqXHR.status);
                    }
                });
            }

            function addNum(obj){
                var number = $(obj).parent().next().next().next().next();
                var item_id = $(obj).parent().next();
                var id = parseInt(item_id.html());
                var num = number.html();
                var newnum = parseInt(num)+1;
                number.empty();
                number.html(newnum);
                $.ajax({
                    type: "post",
                    url: serverHost+"/addNum",
                    data:{
                        id :id,
                        num:newnum,
                    },
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: 'json',
                    success: function(data){
                        console.log(data);
                    }
                });
            }

            function addNum2(id,newnum){
                // alert(sessionStorage.getItem(id));
                if (sessionStorage.getItem(id)!=2)
                    sessionStorage.setItem(id,2);
                else
                    return;

                var id=parseInt(id);
                var newnum=parseInt(newnum)+1;
                $.ajax({
                    type: "post",
                    url: serverHost+"/addNum",
                    data:{
                        id :id,
                        num:newnum,
                    },
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    dataType: 'json',
                    success: function(data){
                        console.log(data);
                    }
                });

                var su="ftp_support"+id;
                $("."+su).empty();
                $("."+su).append(newnum);

            }
        </script>
    </head>

    <body>

        <!--网站header begin-->
        <div class="siteHTopBox">
            <div class="mainInnerBox">
                <!--官方咨询电话-->
                <div class="siteHTelBox">Tel：<span>888-820-8820</span></div>
                <!--top的右边-->
                <div align="right" style="align-self: right">
                    <a onclick="gotoMyPage()" class="siteH_feedbackA btn_ALink" target="_blank">退出</a>
                    <%--<a href="#" class="siteH_feedbackA btn_ALink" target="_blank">微筹</a>--%>
                    <%--<a href="#" class="siteH_feedbackA btn_ALink" target="_blank">Feedback</a>--%>
                    <%--<a href="#" class="siteHCodeB btn_ALink" target="_blank">Support</a>--%>
                </div>
            </div>
        </div>
        <!--网站header end-->


        <div class="siteMTopBox">
            <div class="mainInnerBox clearfix relative">
                <a href="#" class="siteMIndexA">
                    <img src="../images/logo.png"/>
                </a>
                <div class="siteHNavBox clearfix">
                    <div class="siteHNavItem">
                        <a href="#" class="siteHNavItemA" onclick="Home()">首页</a>
                    </div>
                    <div class="siteHNavItem">
                        <a href="#" class="siteHNavItemA" onclick="Deposit()">存款</a>
                    </div>
                    <div class="siteHNavItem">
                        <a onclick="gotoMyPage_Investor()" class="siteHNavItemA">投资</a>
                    </div>
                    <div class="siteHNavItem">
                        <a rel="nofollow"  onclick="gotoMyPage_Supporter()" class="siteHNavItemA" target="_blank">投入资金</a>
                    </div>
                </div>

                <div id="show" name="show">
                    <%--<a href="#" data-href="#" class="siteM_fqBtn btn_ALink js-checkLogin" id="show2" name="show2">发起融资</a>--%>
                </div>

                <div class="siteHLoginBox clearfix">
                    <a href="#" class="siteH_login"> Welcome, ${Type} ${user.user_Name}</a>
                    <%--<a href="#" class="siteH_login">登录</a>--%>
                    <%--<span class="line"></span>--%>
                    <%--<a href="#" class="siteH_register">注册</a>--%>
                </div>

                <div class="siteMSearch siteIlB_box sitePHBox" id="search-box">
                    <div class="search-input">
                        <input type="text" onkeydown="search(1,6)" id="search" class="siteMSearchInput siteIlB_item sitePHInput" id="searchInput" autocomplete="off" placeholder="Search" />
                    </div>

                </div>
            </div>
        </div>


        <div class="center">
            <div class="center_top">
                <!-- <==========================================================> -->
                <!-- 轮播图开始区域 -->
                <!-- <div id="bannar"> -->
                <div class="content_middle">
                    <div class="common_da">
                        <a class="common btnLeft"href="javascript:;"></a>
                        <a class="common btnRight"href="javascript:;"></a>
                    </div>
                    <ul>
                        <li style="background:url(../images/banner1.png) no-repeat center center;opacity: 100;filter: alpha(opacidiv1);"></li>
                        <li style="background:url(../images/banner2.jpg) no-repeat center center;"></li>
                        <li style="background:url(../images/banner3.jpg) no-repeat center center;"></li>
                    </ul>
                    <div class="table">
                        <a class="small_active" href="javascript:;"></a>
                        <a href="javascript:;"></a>
                        <a href="javascript:;"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="indexZCWrap">
            <div class="mainInnerBox">
                <h3 class="indexZCH3">推荐项目</h3>
                <ul class="indexZCLabel_ul siteIlB_box">
                    <li class="siteIlB_item">
                        <a class="site_ALink" target="_blank" onclick="list2(1,6)">最近</a>
                    </li>
                    <li class="geban siteIlB_item">/</li>
                    <li class="siteIlB_item">
                        <a class="site_ALink" target="_blank" onclick="list_catalog1(1,6,1)">艺术</a>
                    </li>
                    <li class="geban siteIlB_item">/</li>
                    <li class="siteIlB_item">
                        <a class="site_ALink" target="_blank" onclick="list_catalog1(1,6,2)">农业</a>
                    </li>
                    <li class="geban siteIlB_item">/</li>
                    <li class="siteIlB_item">
                        <a class="site_ALink" target="_blank" onclick="list_catalog1(1,6,3)">区块链</a>
                    </li>
                    <li class="geban siteIlB_item">/</li>
                    <li class="siteIlB_item">
                        <a class="site_ALink" target="_blank" onclick="list_catalog1(1,6,4)">电影</a>
                    </li>
                    <li class="geban siteIlB_item">/</li>
                    <li class="siteIlB_item">
                        <a class="site_ALink" target="_blank" onclick="list_catalog1(1,6,5)">艺术设计</a>
                    </li>
                    <li class="moreA siteIlB_item">
                        <a target="_blank" onclick="list2(1,6)">更多></a>
                    </li>
                </ul>

                <!-- 卡片列表 begin -->
                <div class="indCardListWrap clearfix" id="alltype">
                    <table align="center">
                        <tbody class="p-list-con2">
                        </tbody>
                    </table>
                    <div align="center" class="pagination2 pull-right" id="pagination2"></div>
                </div>

                <div class="indCardListWrap clearfix" id="type1">
                    <table align="center">
                        <tbody class="p-list-con3">

                        </tbody>

                    </table>
                    <div align="center" class="pagination2 pull-right" id="pagination3"></div>
                </div>





                <!-- 卡片列表 end -->
                <a href="/success" class="indCardListMoreA btn_ALink" target="_blank" >浏览更多</a>

            </div>
        </div>


    </body>
</html>
