
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>众筹网</title>
    <meta charset="utf-8">
    <meta name="keywords" content="众筹,融资,众筹平台,创业融资" />
    <meta name="description" content="众筹网是中国专业的一站式综合众筹融资服务平台，专业为有梦想、有创意、有项目的朋友提供募资、投资、孵化、运营一站式综合众筹服务，协助您实现自己的创业梦想。好平台，好起点，尽在钱钱融资网！" />
    <meta name="renderer" content="webkit" />
    <link rel="shortcut icon"  type="image/png" href="${pageContext.request.contextPath}/images/logo1.png.png" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/1.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/3.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/2.css" >



    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo5.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style2.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/smohan.pop&share.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />

    <script src="http://www.jq22.com/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/share/smohan.pop&share.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/share/qrcode.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>
    <link href="${pageContext.request.contextPath}/css/juanda-pagehelper.css" rel="stylesheet">
    <%--<script src=//cdn.bootcss.com/jquery/1.11.3/jquery.js></script>--%>
    <script src="${pageContext.request.contextPath}/js/juanda-pagehelper.js"></script>
    <link rel="stylesheet" href="https://terryz.github.io/lib/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/b.page.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/demo.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/b.page.bootstrap3.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/classie.js"></script>
    <script src="${pageContext.request.contextPath}/js/uiProgressButton.js"></script>
    <script>

        var serverHost=document.location.protocol+"//"+document.domain+":"+location.port;

        $(document).ready(function() {
            var uid=${user.user_ID};
            list2(1,4);
        });

        [].slice.call( document.querySelectorAll( '.progress-button' ) ).forEach( function( bttn, pos ) {
            new UIProgressButton( bttn, {
                callback : function( instance ) {
                    var progress = 0,
                        interval = setInterval( function() {
                            progress = Math.min( progress + Math.random() * 0.1, 1 );
                            instance.setProgress( progress );

                            if( progress === 1 ) {
                                instance.stop( pos === 1 || pos === 3 ? -1 : 1 );
                                clearInterval( interval );
                            }
                        }, 150 );
                }
            } );
        } );


        function test(obj){
            var number=obj;
            var isMine=${isMine};
            if (isMine==true){
                alert("You cannot invest your own item!");
                return;
            }
            var balance=${user.user_Balance};
            if (balance<=0){
                alert("You must deposit first!");
                return;
            }
            else
                window.location.href='ItemSupport.htm?ID='+number;

        }



    </script>
    <title>Title</title>
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

        function gotoMyPage_Supporter(){
            window.location.href='MyPage_Supporter.htm';
        }

        function gotoMyPage_Investor(){
            window.location.href='MyPage_Investor.htm';
        }

        function Deposit(mypage){
            window.location.href='deposit.htm';
        }
        function Home(mypage){
            window.location.href='success.htm';
        }

        function judge(form, event){
            event.preventDefault();
        var isMine=${isMine};
            if (isMine==true){
                alert("You cannot comment your own item!");
                return;
            }
        var comment=$("#item_comment").val();
            if(comment == ""){
//                $.pt({
//                    target: $("#item_comment"),
//                    position: 'r',
//                    align: 't',
//                    width: 'auto',
//                    height: 'auto',
//                    content:"Comment can not be Enpty"
//                });
                return;
            }
        else
            form.submit();

        }

        function list2(pageNum,pageSize) {
            $("#alltype").show();
            $("#type1").hide();
            $.ajax({
                type: "POST",
                url: serverHost+"/showComment",
                data: {
                    pageNum:pageNum,
                    pageSize:pageSize,
                    ID:${item_copy.item_ID}
                },
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                dataType: 'json',
                success: function(data){
                    if(data.endRow!=0){
                        $(".p-list-con2").empty();
                        $.each(data.list,function (i,item) {
                            $(".p-list-con2").append(
                                "<tr>"+
                                "<td style='width: 40px'>"+new Date(item.comment_Date).toLocaleDateString()+"</td>"+
                                "<td style='width: 612px'>"+item.comment+"</td>"+
                                "</tr>");
                        });

                        JUANDATOOLS.paginator(data,function (page) {
                            list2(page,4);
                        },false,200,"pagination2");
                    }else{
                        $(".p-list-con2").empty();
                        $(".p-list-con2").append("<p class='err-tip'style='font-size: large; font-style: italic'>Sorry, did not find any comments.</p>");
                    }
                },
                error: function(jqXHR){
                    alert("Can not connect to the server .Error：" + jqXHR.status);
                }
            });
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
                <a onclick="gotoMyPage()" class="siteH_feedbackA btn_ALink" target="_blank">Log out</a>
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
                <img src="${pageContext.request.contextPath}/images/logo.png.png"/>
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
                <a href="#" class="siteMSearchA siteIlB_item fr" id="searchBtn"></a>
                <span class="sitePHTip" style="top: 4px;left: 5px;">Search</span>
                <div class="input-hinter"></div>
            </div>
        </div>
    </div>

    <!--main static-->
    <div class="jlxqOuterBox" id="jlxqOuterBox"
     data-current = "||"
     data-owner="0"
     data-userid="6608997"
     data-dealid="741659"
     data-dealcode="6e68dd01b17cf61962266472"
     data-hrefUpdate="1"
     data-show-point="0">
        <div class="mainIn02Box">
            <div class="jlxqBox">
                <!-- 详情header begin -->
                <div class="jlxqTitle">
                    <a href="javascript:void(0);" onClick="siXin('+item.user_id+', '');sitePop.showSixin('6608997');">
                        <img class='jltitphoto' src="../images/97virtual_avatar_small.jpg"/>
                    </a>
                    <div class="jlxqtittext">
                        <div class="jlxqh3_wai" style="margin-bottom: 40px">
                            <h3 class="jlxqTitle_h3" id='move'>${item_copy.item_Title}</h3>

                        </div>
                        <div class="faqipeeson">
                            <span class='txt1'>发起人</span>
                            <span class='txt2' style='text-decoration:none !important;'><font>
                                ${owner.user_Name}</font></span>
                            <span class='per-v' title=""></span>
                            <span class='lianxi' onClick="sitePop.showSixin(6608997);">联系</span>
                        </div>
                    </div>
                    <!-- 分享 e-->
                </div>
                <div class="xqDetailBox">
                    <span class="xqStatusSpan zcz ordering"></span>
                    <div class="xqDetailLeft siteImgBox">
                        <img src="${pageContext.request.contextPath}/images/B${item_copy.item_ID}.jpg" class="lazy" />
                        <a class="is_right heart-shaped  deal_detail_like" data-id="741659" title="关注(2)">2</a>
                    </div>
                    <div class="xqDetailRight">
                        <div class="xqDetailDataBox">
                            <div class="xqDetailData">
                                <p><span class="ftP">${item_copy.item_SupporterNumber}</span><span class="scP pl5">支持</span></p>
                                <!-- <p class="scP">支持数</p> -->
                            </div>
                            <div class="xqDetailData">
                                <p><span class="ftP">$ ${item_copy.item_DemandMoney-item_copy.item_StillDemandMoney}</span><span class="scP pl5">已众筹</span></p>
                                <!-- <p class="scP">已筹款</p> -->
                            </div>
                        </div>
                        <div class="xqRatioOuterBox">
                            <p class="ftP"> ${rate}%</p>
                            <div class="xqRatio">
                                <div class="xqRatioInner " style="width: ${rate}%;"></div>
                            </div>
                            <div class="xqRatioText clearfix">
                                    <span class="leftSpan">
                                         <span>剩余</span>
                                         <b>24天</b>
                                    </span>
                                <span class="rightSpan">目标<b>$ ${item_copy.item_DemandMoney}</b></span>
                            </div>
                        </div>
                        <div class="xqDetailBtnBox">
                            <a href="#" target="_self" class="xqDetail_supA js-linkTaget 1 btn_ALink " onclick="test(${item_copy.item_ID})">Support Now!</a>
                            <div class="xqDetail_supA 1 btn_ALink share-wechat">
                                <a href="javascript:void(0)" class="share">分享</a>
                            </div>
                            <%--<div class="xqDetailShareBox clearfix">--%>
                                <%--<div class="jlxqTitleText siteIlB_box">--%>
                                        <%--<span class="gy siteIlB_item">--%>
                                            <%--<a href="" target="_blank" class="hoUdCLink">公益</a>--%>
                                        <%--</span>--%>
                                    <%--<span class="addr siteIlB_item">--%>
                                            <%--<a href="" class="site_ALink siteIlB_item" target="_blank">四川</a>--%>
                                        <%--</span>--%>

                                    <%--<span class="label siteIlB_item">--%>
                                            <%--<a href="" target="_blank" class="hoUdCLink">支教</a>--%>
                                            <%--<a href="" target="_blank" class="hoUdCLink">于归</a>--%>
                                            <%--<a href="" target="_blank" class="hoUdCLink">资阳</a>--%>
                                        <%--</span>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        </div>
                    </div>
                </div>
                <!-- 详情header end -->
            </div>


            </div>
            <section class="ac-container">
                <div>
                    <input id="ac-1" name="accordion-1" type="checkbox" />
                    <label for="ac-1">项目细节信息</label>
                    <article class="ac-small">
                        <table align="center" class="table table-striped table-bordered table-hover table-condensed">
                        <tbody>
                        <tr>
                        <td style="font-size: medium; text-align: center; font-family: 'Adobe Caslon Pro'; width: 200px; height:10px">项目编号</td>
                        <td>${item_copy.item_ID}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center; font-family: 'Adobe Caslon Pro';color:#ffffff;background-color:#337ab7;opacity: 0.6">项目发起日期</td>
                        <td>${item_copy.item_EstablishDate}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center; font-family: 'Adobe Caslon Pro'">项目描述</td>
                        <td>${item_copy.item_Discription}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center; font-family: 'Adobe Caslon Pro';color:#ffffff;background-color:#337ab7;opacity: 0.6">目标金额</td>
                        <td>${item_copy.item_DemandMoney}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center; font-family: 'Adobe Caslon Pro'">支持数</td>
                        <td>${item_copy.item_SupporterNumber}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center; font-family: 'Adobe Caslon Pro';color:#ffffff;background-color:#337ab7;opacity: 0.6">项目类型</td>
                        <td>${type}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center;font-family: 'Adobe Caslon Pro'">还需金额</td>
                        <td>${item_copy.item_StillDemandMoney}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; text-align: center;font-family: 'Adobe Caslon Pro';color:#ffffff;background-color:#337ab7;opacity: 0.6">项目名称</td>
                        <td>${item_copy.item_Title}</td>
                        </tr>
                        <tr>
                        <td style="font-size: medium; height:auto;text-align: center; font-family: 'Adobe Caslon Pro'">项目细节</td>
                        <td>${item_copy.item_Detail}</td>
                        </tr>
                        </tbody>
                        </table>


                        <div class="progress-button elastic">
                        <button onclick="test(${item_copy.item_ID})" style="margin-left: 450px")><span>Support</span></button>
                        <svg class="progress-circle" width="70" height="70"><path d="m35,2.5c17.955803,0 32.5,14.544199 32.5,32.5c0,17.955803 -14.544197,32.5 -32.5,32.5c-17.955803,0 -32.5,-14.544197 -32.5,-32.5c0,-17.955801 14.544197,-32.5 32.5,-32.5z"/></svg>
                        <svg class="checkmark" width="70" height="70"><path d="m31.5,46.5l15.3,-23.2"/><path d="m31.5,46.5l-8.5,-7.1"/></svg>
                        <svg class="cross" width="70" height="70"><path d="m35,35l-9.3,-9.3"/><path d="m35,35l9.3,9.3"/><path d="m35,35l-9.3,9.3"/><path d="m35,35l9.3,-9.3"/></svg>
                        </div><!-- /progress-button -->
                    </article>
                </div>
                <div>
                    <input id="ac-2" name="accordion-1" type="checkbox" />
                    <label for="ac-2">Comment</label>
                    <article class="ac-medium">
                            <table align="center" class="table table-striped table-bordered table-hover table-condensed">
                                <thead>
                                <th style="text-align: center;font-size: 14px; width:72px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                               background: #2e86cb;
                               background: -moz-linear-gradient(top, #337ab7 0%, #2e86cb 100%);
                               background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#337ab7), color-stop(100%,#2e86cb));
                               background: -webkit-linear-gradient(top, #337ab7 0%,#2e86cb 100%);
                               background: -o-linear-gradient(top, #337ab7 0%,#2e86cb 100%);
                               background: -ms-linear-gradient(top, #337ab7 0%,#2e86cb 100%);
                               background: linear-gradient(to bottom, #337ab7 0%,#2e86cb 100%);
                               opacity: 0.8">Date</th>
                           <th style="text-align: center; width:612px;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';
                           background: #2e86cb;
                           background: -moz-linear-gradient(top, #337ab7 0%, #2e86cb 100%);
                           background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));
                           background: -webkit-linear-gradient(top, #337ab7 0%,#2e86cb 100%);
                           background: -o-linear-gradient(top, #337ab7 0%,#2e86cb 100%);
                           background: -ms-linear-gradient(top, #337ab7 0%,#2e86cb 100%);
                           background: linear-gradient(to bottom, #337ab7 0%,#2e86cb 100%);
                           opacity: 0.8">Comment</th>
                     </thead>
                                <tbody class="p-list-con2"></tbody>
                            </table>
                            <div align="center" class="pagination2 pull-right" id="pagination2"></div>
                        <form onsubmit="javascript:judge(this, event)" method="post" action="/addComment">
                            <input id="itemID" name="itemID" value="${item_copy.item_ID}">
                            <p style="margin-left: 450px;margin-top: 40px">Write Your Comment</p>
                            <textarea style="width: 1000px;height:150px;border: 1px solid;opacity: 0.2" id="item_comment" name="item_comment"></textarea>
                            <br/>
                            <div class="progress-button elastic">
                                <button type="submit" style="margin-left: 450px"><span>comment</span></button>
                                <svg class="progress-circle" width="70" height="70"><path d="m35,2.5c17.955803,0 32.5,14.544199 32.5,32.5c0,17.955803 -14.544197,32.5 -32.5,32.5c-17.955803,0 -32.5,-14.544197 -32.5,-32.5c0,-17.955801 14.544197,-32.5 32.5,-32.5z"/></svg>
                                <svg class="checkmark" width="70" height="70"><path d="m31.5,46.5l15.3,-23.2"/><path d="m31.5,46.5l-8.5,-7.1"/></svg>
                                <svg class="cross" width="70" height="70"><path d="m35,35l-9.3,-9.3"/><path d="m35,35l9.3,9.3"/><path d="m35,35l-9.3,9.3"/><path d="m35,35l9.3,-9.3"/></svg>
                            </div>
                        </form>
                    </article>
                    <%--<article class="ac-medium">--%>
                        <%--<div class="container" style="margin-top: 30px;">--%>
                            <%--<table align="center" class="table table-striped table-bordered table-hover table-condensed">--%>
                                <%--<thead>--%>
                                <%--<th width="30px">NO.</th>--%>
                                <%--<th width="400px">Comment</th>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<c:forEach items="${commentSet}" var="comment">--%>
                                    <%--<tr>--%>
                                        <%--<td><c:out value="${comment.comment_ID}"></c:out></td>--%>
                                        <%--<td><c:out value="${comment.comment}"></c:out></td>--%>
                                    <%--</tr>--%>
                                <%--</c:forEach>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>


                                <%--<table align="center" class="table table-striped table-bordered table-hover table-condensed">--%>
                                    <%--<thead>--%>
                                        <%--<th width="40px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';--%>
                               <%--background: #2e86cb;--%>
                               <%--background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);--%>
                               <%--background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));--%>
                               <%--background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                               <%--background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                               <%--background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                               <%--background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);--%>
                               <%--opacity: 0.8">Date</th>--%>
                                        <%--<th width="300px" style="text-align: center;font-size: 14px;color: #f6f7f8; font-family: 'Adobe Caslon Pro';--%>
                           <%--background: #2e86cb;--%>
                           <%--background: -moz-linear-gradient(top, #55b5ff 0%, #2e86cb 100%);--%>
                           <%--background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#55b5ff), color-stop(100%,#2e86cb));--%>
                           <%--background: -webkit-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--background: -o-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--background: -ms-linear-gradient(top, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--background: linear-gradient(to bottom, #55b5ff 0%,#2e86cb 100%);--%>
                           <%--opacity: 0.8">Comment</th>--%>
                                    <%--</thead>--%>
                                    <%--<tbody class="p-list-con2"></tbody>--%>
                                <%--</table>--%>
                                <%--<div align="center" class="pagination2 pull-right" id="pagination2"></div>--%>
                            <%--</div>--%>

                            <%--<form onsubmit="javascript:judge(this, event)" method="post" action="/addComment">--%>
                            <%--<input id="itemID" name="itemID" value="${item_copy.item_ID}">--%>
                            <%--<p>Write Your Comment</p>--%>
                            <%--<textarea style="width: 600px;height:150px;" id="item_comment" name="item_comment"></textarea>--%>
                            <%--<br/>--%>
                                <%--<div class="progress-button elastic">--%>
                                    <%--<button type="submit"><span>comment</span></button>--%>
                                    <%--<svg class="progress-circle" width="70" height="70"><path d="m35,2.5c17.955803,0 32.5,14.544199 32.5,32.5c0,17.955803 -14.544197,32.5 -32.5,32.5c-17.955803,0 -32.5,-14.544197 -32.5,-32.5c0,-17.955801 14.544197,-32.5 32.5,-32.5z"/></svg>--%>
                                    <%--<svg class="checkmark" width="70" height="70"><path d="m31.5,46.5l15.3,-23.2"/><path d="m31.5,46.5l-8.5,-7.1"/></svg>--%>
                                    <%--<svg class="cross" width="70" height="70"><path d="m35,35l-9.3,-9.3"/><path d="m35,35l9.3,9.3"/><path d="m35,35l-9.3,9.3"/><path d="m35,35l9.3,-9.3"/></svg>--%>
                                <%--</div>--%>

                            <%--</form>--%>

                        <%--</div>--%>

                    <%--</article>--%>

                </div>
                <%--<div>--%>
                    <%--<input id="ac-4" name="accordion-1" type="checkbox" />--%>
                    <%--<label for="ac-4">好处</label>--%>
                    <%--<article class="ac-large">--%>

                    <%--</article>--%>
                <%--</div>--%>
            </section>

        </div>
    </div>




</body>
</html>
