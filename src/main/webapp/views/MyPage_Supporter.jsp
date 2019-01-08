<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <meta charset="utf-8">
    <title>众筹网</title>
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

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/smohan.pop&share.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />


    <link href="${pageContext.request.contextPath}/css/juanda-pagehelper.css" rel="stylesheet">
    <script src=//cdn.bootcss.com/jquery/1.11.3/jquery.js></script>
    <script src="${pageContext.request.contextPath}/js/juanda-pagehelper.js"></script>
    <link rel="stylesheet" href="https://terryz.github.io/lib/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome-4.5.0/css/font-awesome.min.css" />
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />

    <script src="${pageContext.request.contextPath}/js/http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/b.page.js" ></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/demo.js" ></script>
    <script src="${pageContext.request.contextPath}/js/mo.min.js"></script>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/b.page.bootstrap3.css" type="text/css">--%>

    <script src="${pageContext.request.contextPath}/js/classie.js"></script>
    <script src="${pageContext.request.contextPath}/js/uiProgressButton.js"></script>
    <script>
        var serverHost=document.location.protocol+"//"+document.domain+":"+location.port;
        var map="${map}"
        map=map.substr(1,map.length-2);
        var strset=map.split(",");
        var m = new Array(100);

        // alert(strset.length);
        for (var i=0;i<strset.length;i++){
            var newstr=strset[i].split("=");
            // alert(newstr[1].toString());
            // m.set(newstr[0],newstr[1]);
            // alert(m.get(newstr[0]));
            m[parseInt(newstr[0])]=newstr[1];
        }
        function additem(mypage){
            window.location.href='addItem.htm';
        }

        $(document).ready(function() {
            var uid=${user.user_ID};
            $("#show").append("<a class='siteM_fqBtn btn_ALink js-checkLogin' onclick='additem()'>Financing</a>");
            list2(1,4);
        });

        [].slice.call( document.querySelectorAll( '.progress-button' ) ).forEach( function( bttn, pos ) {
            new UIProgressButton( bttn, {
                callback : function( instance ) {
                    var progress = 0,
                        interval = setInterval( function() {
                            progress = Math.min( progress + Math.random() * 0.1, 1 );
                            instance.setProgress( progress );

                            if( progress===1 ) {
                                instance.stop( pos === 1 || pos === 3 ? -1 : 1 );
                                clearInterval( interval );
                            }
                        }, 150 );
                }
            } );
        } );


        function Home(mypage){
            window.location.href='success.htm';
        }

        function gotoMyPage_Supporter(){
            window.location.href='MyPage_Supporter.htm';
        }

        function gotoMyPage_Investor(){
            window.location.href='MyPage_Investor.htm';
        }

        function test(obj){
            var number=obj;
            window.location.href='ItemSupport.htm?ID='+number;
        }

        function test2(obj){
            var number=obj;
            window.location.href='showItem.htm?ID='+number;
        }
        function Deposit(mypage){
            window.location.href='deposit.htm';
        }

        function list2(pageNum,pageSize) {
            $("#alltype").show();
            $("#type1").hide();
            $.ajax({
                type: "POST",
                url: serverHost+"/showMySupport",
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
                            var it=(item.Item_DemandMoney-item.Item_StillDemandMoney)/item.Item_DemandMoney;
                            var its=item.item_ID;
                            it=it.toFixed(2)*100;

                            var typ;

                            // m.set("14","14");




                            // alert(m.toString());
                            <%--var money=${map.get(12)};--%>
                            if (item.item_Type==1)
                                typ="Arts";
                            if (item.item_Type==2)
                                typ="Food & Craft";
                            var id=item.item_ID.toString();
                            // sessionStorage.setItem(id,id);
                            $(".p-list-con2").append(
                                "<tr>"+
                                "<td onclick='test2("+item.item_ID+")'>"+item.Item_Title+"</td>"+
                                "<td onclick='test2("+item.item_ID+")'>"+
                                "<img src='../images/B"+item.item_ID+".jpg' alt='' />"+
                                "</td>"+
                                "<td>"+typ+"</td>"+
                                "<td>"+item.item_Discription+"</td>"+
                                "<td>"+ m[item.item_ID]+"</td>"+
                                "</tr>");
                        });

                        JUANDATOOLS.paginator(data,function (page) {
                            list2(page,4);
                        },false,200,"pagination2");
                    }else{
                        $(".p-list-con2").empty();
                        $(".p-list-con2").append("<p class='err-tip'style='text-align: center;font-size: 24px;font-family: 'Adobe Caslon Pro''>Sorry, did not find you need.</p>");
                    }
                },
                error: function(jqXHR){
                    alert("Can not connect to the server .Error：" + jqXHR.status);
                }
            });
        }
    </script>
    <script>
        $(function(){
            $('.link .button').hover(function(){
                var title=$(this).attr('data-title');
                $('.tip em').text(title);
                var pos=$(this).offset().left;
                var dis=($('.tip').outerWidth()-$(this).outerWidth())/2;
                var l=pos-dis;
                $('.tip').css({'left':l+'px'}).animate({'top':180,'opacity':1},300);
            },function(){
                $('.tip').animate({'top':160,'opacity':0},300);
            })
        })
    </script>

    <script type="text/javascript">
        $("#userSelect").click(function(e){
//屏蔽父元素的事件响应
            e.stopPropagation();
            // alert("This is Click me button");
        });
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
                    <img src="${pageContext.request.contextPath}/images/logo.png"/>
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
                        <a rel="nofollow"  onclick="gotoMyPage_Supporter()" class="siteHNavItemA" target="_blank">投入金额</a>
                    </div>
                </div>
                <div id="show" name="show">
                    <%--<a href="#" data-href="#" class="siteM_fqBtn btn_ALink js-checkLogin" id="show2" name="show2">发起融资</a>--%>
                </div>

                <div class="siteHLoginBox clearfix">
                    <a href="#" class="siteH_login"> Welcome, ${user.user_Name}</a>
                    <%--<a href="#" class="siteH_login">登录</a>--%>
                    <%--<span class="line"></span>--%>
                    <%--<a href="#" class="siteH_register">注册</a>--%>
                </div>


                <div class="siteMSearch siteIlB_box sitePHBox" id="search-box">
                    <div class="search-input">
                        <%--<input type="text" class="siteMSearchInput siteIlB_item sitePHInput" id="searchInput" autocomplete="off" placeholder="人在书店" />--%>
                    </div>

                </div>
            </div>
        </div>

        <!--main static-->
        <div>

                <div class="container" style="margin-top: 30px;">

                    <p style="font-size: 20px; font-family: 'Adobe Caslon Pro'">平均众筹金额:$ ${user.user_Balance}</p>

                    <table align="center" class="table table-striped table-bordered table-hover table-condensed">
                        <thead>
                        <th width="200px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                           background: #2e86cb;
                           background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);
                           background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));
                           background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);
                           opacity: 0.8">项目类型</th>
                        <th width="200px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                           background: #2e86cb;
                           background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);
                           background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));
                           background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);
                           opacity: 0.8">项目图片</th>
                        <th width="200px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                           background: #2e86cb;
                           background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);
                           background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));
                           background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);
                        opacity: 0.8">项目类型</th>
                        <th width="200px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                           background: #2e86cb;
                           background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);
                           background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));
                           background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);
                           opacity: 0.8">项目描述</th>
                        <th width="200px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                           background: #2e86cb;
                           background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);
                           background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));
                           background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);
                           background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);
                           opacity: 0.8">我的</th>
                        <%--<th width="200px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';--%>
                           <%--background: #2e86cb;--%>
                           <%--background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);--%>
                           <%--background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));--%>
                           <%--background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--opacity: 0.8">Invest Amount</th>--%>
                        </thead>
                        <tbody class="p-list-con2"></tbody>
                    </table>
                    <div align="center" class="pagination2 pull-right" id="pagination2"></div>

                    <%--<div class="progress-button elastic">--%>
                        <%--<button onclick="test(${item_copy.item_ID})"><span>Support</span></button>--%>
                        <%--<svg class="progress-circle" width="70" height="70"><path d="m35,2.5c17.955803,0 32.5,14.544199 32.5,32.5c0,17.955803 -14.544197,32.5 -32.5,32.5c-17.955803,0 -32.5,-14.544197 -32.5,-32.5c0,-17.955801 14.544197,-32.5 32.5,-32.5z"/></svg>--%>
                        <%--<svg class="checkmark" width="70" height="70"><path d="m31.5,46.5l15.3,-23.2"/><path d="m31.5,46.5l-8.5,-7.1"/></svg>--%>
                        <%--<svg class="cross" width="70" height="70"><path d="m35,35l-9.3,-9.3"/><path d="m35,35l9.3,9.3"/><path d="m35,35l-9.3,9.3"/><path d="m35,35l9.3,-9.3"/></svg>--%>
                    <%--</div><!-- /progress-button -->--%>
                </div>
        </div>



        <div class="siteFooterBox">
            <div class="mainInnerBox">
                <div class="siteMFooter"></div>
            </div>
        </div>
    </body>
</html>
