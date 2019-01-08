<%--
  Created by IntelliJ IDEA.
  User: henry_fordham
  Date: 2018/5/17
  Time: 下午12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>众筹网</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/registter.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ImgCutCss/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ImgCutCss/cropper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ImgCutCss/main.css">
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
    <script src="${pageContext.request.contextPath}/js/ImgCutJs/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ImgCutJs/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ImgCutJs/cropper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ImgCutJs/main.js"></script>



    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mvali.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
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
    <script>
        function add() {
            var money=document.getElementById("Item_DemandMoney").value;
            var regPos = /^\d+(\.\d+)?$/; //非负浮点数
            var regPosNum = / ^\d+$/; // 非负整数
            if(regPos.test(money) || regPosNum.test(money)){
                return true;
            }else{
                alert("You must input a number in correct format(At most two bits after the decimal)!");
                return false;
            }
        }
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
                <div id="crop-avatar">

                    <!-- Current avatar -->
                    <div class="avatar-view" title="Change the avatar">
                        <img src="${pageContext.request.contextPath}/images/B0.jpg" alt="Avatar">
                    </div>
                    <!-- Cropping modal -->
                    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <form class="avatar-form" action="/uploadHeadImage" enctype="multipart/form-data" method="post" accept="image/*">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title" id="avatar-modal-label">更改封面</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="avatar-body">

                                            <!-- avatar_file(源文件),avatar_data(裁剪参数JSON[x,y,w,h]),avatar-src(源文件路径) -->
                                            <div class="avatar-upload">
                                                <input type="hidden" class="avatar-src" name="avatar_src">
                                                <input type="hidden" class="avatar-data" name="avatar_data">
                                                <label for="avatarInput" class="btn btn-primary">选择一张图片</label>
                                                <input type="file" class="avatar-input" id="avatarInput" name="avatar_file" style="display: none;" accept="image/*">
                                            </div>

                                            <!-- Crop and preview -->
                                            <div class="row">
                                                <div class="col-md-9">
                                                    <div class="avatar-wrapper"></div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="avatar-preview preview-lg"></div>
                                                    <div class="avatar-preview preview-md"></div>
                                                    <div class="avatar-preview preview-sm"></div>
                                                </div>
                                            </div>

                                            <div class="row avatar-btns">
                                                <div class="col-md-9">
                                                    <div class="btn-group">
                                                        <button type="button" class="btn btn-primary" data-method="rotate" data-option="90" title="Rotate 90 degrees">Rotate</button>
                                                        <button type="button" class="btn btn-primary" data-method="rotate" data-option="15">15deg</button>
                                                        <button type="button" class="btn btn-primary" data-method="rotate" data-option="30">30deg</button>
                                                        <button type="button" class="btn btn-primary" data-method="rotate" data-option="45">45deg</button>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <button type="submit" class="btn btn-primary btn-block avatar-save">提交</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- <div class="modal-footer">
                                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    </div> -->
                                </form>
                            </div>
                        </div>
                    </div><!-- /.modal -->
                    <!-- Loading state -->
                    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
                </div>
                <div id="register">
                    <form class="form2" method="post" action="/addi">
                        <h3>Hello, ${user.user_Name}</h3>
                        <div class="vali">
                            <input type="text" id="Item_Title" name="Item_Title" placeholder="Item_Title">
                        </div>

                        <div class="vali">
                            <input type="text" id="Item_Discription" name="Item_Discription" placeholder="Item_Discription">
                        </div>

                        <div class="vali">
                            <select id="Item_Type" name="Item_Type">
                                <option value="1">Arts</option>
                                <option value="2">Food & Craft</option>
                                <option value="3">Comics & Illustration</option>
                                <option value="4">Films</option>
                                <option value="5">Design & Tech</option>
                            </select>
                        </div>

                        <div class="vali">
                            <input type="text" id="Item_DemandMoney" name="Item_DemandMoney" placeholder="Item_DemandMoney">
                        </div>

                        <div class="vali">
                        </div>
                        <div class="submit">
                            <input onclick="return add()" type="submit" class="btn" value="SUBMIT">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
