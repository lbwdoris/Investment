
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>众筹网</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/registter.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/canvas.css">
    <style>
        html, body {
            height: 100%;
            width: 100%;
            margin: 0;
            /*overflow: hidden;*/
        }
        #site-landing {
            position:relative;
            height:800px ;
            width: 1366px;
            background-image: linear-gradient(to top, #30cfd0 0%, #330867 100%);
        }
    </style>

    <%--<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mvali.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function validateBalance() {
            var money=document.getElementById('money').value;
            var reg=/^[0-9]+(.[0-9]{1,3})?$/;
            if (!reg.test(money)){
                alert("You must enter correct number format!")
                return false;
            }
            if (parseFloat(${user.user_Balance})<parseFloat(money)){
                alert("Warning!!! You don't have sufficient amount now!!")
                return false;
            }

        }
        function additem(mypage){
            window.location.href='addItem.htm';
        }
        $.myvali({
            myform:".form2",								//表单id
            mybtn:".btn",									//提交表单按钮id
            myVali:".vali",									//input父盒子的class，可自定义类名

            Required:".Required",							//验证必填选项，值为Required,input自己加class
            RequiredTps:["不能为空!!!"],					//只验证不为空提示

            Requireds:".Requireds",							//验证必填不同提示，值为Requireds,input自己加class
            reqtps:".reqtps",								//验证不为空不同提示,input父盒子的class,可自定义类名
            Reqlength:[[2,4]],								//只验证不为空,设置最小长度和最大长度
            ReqlengthTps:["+不为空1"],						//验证不为空长度提示
            RequiredsTps:["这是自定义提示1"],				//默认提示

            myNuber:".nub",									//数字验证
            myNuberlength:[5,10],							//数字长度
            myNameNuber:"QQ",								//数字提示

            chinese:".chinese",								//中文验证id
            chinesetps:{
                minLength:2,								//最小长度
                maxLength:4,								//最大长度
                tps:"姓名",									//提示
            },

            myName:".uersname",								//用户名id或class

            myPassword:".pasw",								//密码id或class
            // myPasswordMinLength:6,						//密码最小长度，不写默认长度6
            // myPasswordMaxLength:16,						//密码最大长度，不写默认长度16
            myConfirmPassword:".pasws",						//确认密码id或class

            myPhone:".phone",								//手机号id或class

            isPhoneCode:true,								//开启手机短信验证，true开启，默认false不开启(此项功能与myPhone配合验证)
            phoneCodeBtn:".codebtn",						//发送手机验证码id或class（按钮）
            count:30,										//发送短信验证码倒计时，默认60s（按钮）
            codeBtnCol1:["rgb(150, 150, 150)"],				//短信验证码倒计时（按钮，通过验证前）颜色
            codeBtnCol2:["#333"],							//短信验证码倒计时（按钮，通过验证后）颜色


            myPhone1:"#v",									//修改手机号(原手机号用这个验证)id或class


            phoneCodeInput:".phcode",						//短信验证码id或class（输入框）

            myMailbox:".eal",								//邮箱id或class

            myCard:".cid",									//身份证验证id或class

        });
    </script>
</head>
<body>
<div id="site-landing">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="js/polygonizr.min.js"></script>
    <script type="text/javascript">
        $('#site-landing').polygonizr();
    </script>
    <canvas width="1366" height="800" style="position:absolute"></canvas>
    <div class="body">
        <div class="vli">
            <div class="wrapper move">
                <div id="register">
                    <form class="form2" method="post" action="/support">
                        <h3>Hello, ${user.user_Name}</h3>

                        <div class="vali">
                            Item Name:<input type="text" name="username" value="${user.user_Name}" placeholder="${user.user_ID}">
                        </div>

                        <div class="vali">
                            Investor ID:<input type="text" name="userid" value="${user.user_ID}" placeholder="${user.user_ID}">
                        </div>


                        <div class="vali">
                            Item ID:<input type="text" id="itemid" name="itemid" value="${item_copy.item_ID}" placeholder="${item_copy.item_ID}">
                        </div>

                        <div class="vali">
                            Item for investigation:<input type="text" disabled="disabled" id="itemTitle" name="itemTitle" value="${item_copy.item_Title}" placeholder="${item_copy.item_Title}">
                        </div>

                        <div class="vali">
                            Total Need:<input type="text" disabled="disabled" id="itemtotalmoney" name="itemtotalmoney" value="${item_copy.item_DemandMoney}" placeholder="TOTAL NEED">
                        </div>
                        <div class="vali">
                            Still Need:<input type="text" disabled="disabled" id="itemstillneed" name="itemstillneed" value="${item_copy.item_StillDemandMoney}" placeholder="TOTAL NEED">
                        </div>

                        <div class="vali">
                            Support Amount:<input type="text" name="money" id="money" placeholder="TOTAL NEED">
                        </div>

                        <div class="submit">
                            <input onclick="return validateBalance()" type="submit" class="btn" value="SUBMIT">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
