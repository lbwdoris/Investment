<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sign-up-login.css">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inputEffect.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tooltips.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/spop.min.css" />

    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/b.page.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/demo.js" ></script>
    <script type="text/javascript">
        $(function(){
            SyntaxHighlighter.all();
        });
    </script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/js/snow.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.pure.tooltips.js"></script>
    <script src="${pageContext.request.contextPath}/js/spop.min.js"></script>
    <script>
        (function() {
            if (!String.prototype.trim) {
                (function() {
                    // Make sure we trim BOM and NBSP
                    var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                    String.prototype.trim = function() {
                        return this.replace(rtrim, '');
                    };
                })();
            }

            [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
                // in case the input is already filled..
                if( inputEl.value.trim() !== '' ) {
                    classie.add( inputEl.parentNode, 'input--filled' );
                }

                // events:
                inputEl.addEventListener( 'focus', onInputFocus );
                inputEl.addEventListener( 'blur', onInputBlur );
            } );

            function onInputFocus( ev ) {
                classie.add( ev.target.parentNode, 'input--filled' );
            }

            function onInputBlur( ev ) {
                if( ev.target.value.trim() === '' ) {
                    classie.remove( ev.target.parentNode, 'input--filled' );
                }
            }
        })();

        $(function() {
            $('#login #login-password').focus(function() {
                $('.login-owl').addClass('password');
            }).blur(function() {
                $('.login-owl').removeClass('password');
            });
            $('#login #register-password').focus(function() {
                $('.register-owl').addClass('password');
            }).blur(function() {
                $('.register-owl').removeClass('password');
            });
            $('#login #register-repassword').focus(function() {
                $('.register-owl').addClass('password');
            }).blur(function() {
                $('.register-owl').removeClass('password');
            });
            $('#login #forget-password').focus(function() {
                $('.forget-owl').addClass('password');
            }).blur(function() {
                $('.forget-owl').removeClass('password');
            });
        });

        function goto_register(){
            $("#register-username").val("");
            $("#register-password").val("");
            $("#register-repassword").val("");
            $("#register-code").val("");
            $("#tab-2").prop("checked",true);
        }

        function goto_login(){
            $("#login-username").val("");
            $("#login-password").val("");
            $("#tab-1").prop("checked",true);
        }

        function goto_forget(){
            $("#forget-username").val("");
            $("#forget-password").val("");
            $("#forget-code").val("");
            $("#tab-3").prop("checked",true);
        }

        function login(){//登录
            var username = $("#login-username").val(),
                password = $("#login-password").val(),
                validatecode = null,
                flag = false;
            //判断用户名密码是否为空
            if(username == ""){
                $.pt({
                    target: $("#login-username"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"ID cannot be empty"
                });
                return false;
            }

            var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if(reg.test(username) === false)
            {
                $.pt({
                    target: $("#login-username"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Invalid ID Number"
                });
                return false;
            }


            if(password == ""){
                $.pt({
                    target: $("#login-password"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Password cannot be empty"
                });
                return false;
            }
            //用户名只能是15位以下的字母或数字
            // var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
            // if(!regExp.test(username)){
            //     $.pt({
            //         target: $("#login-username"),
            //         position: 'r',
            //         align: 't',
            //         width: 'auto',
            //         height: 'auto',
            //         content:"用户名必须为15位以下的字母或数字"
            //     });
            //     flag = true;
            // }

            if(flag){
                return false;
            }
            else{//登录
                //调用后台登录验证的方法
                alert('Login Successful!');
                return true;
            }
        }

        //注册
        function register(){
            var username = $("#register-username").val(),
                password = $("#register-password").val(),
                repassword = $("#register-repassword").val(),
                name = $("#register-name").val(),
                tel = $("#register-tel").val(),
                code = $("#register-code").val(),
                flag = false,
                validatecode = null;
            //判断用户名密码是否为空
            if(username == ""){
                $.pt({
                    target: $("#register-username"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"ID Number can not be Enpty"
                });
                return false;
            }
            if(password == ""){
                $.pt({
                    target: $("#register-password"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Password can not be Enpty"
                });
                return false;
            }else{
                if(password != repassword){
                    $.pt({
                        target: $("#register-repassword"),
                        position: 'r',
                        align: 't',
                        width: 'auto',
                        height: 'auto',
                        content:"The Passwords Are Not Same"
                    });
                    return false;
                }
            }
            if(name == ""){
                $.pt({
                    target: $("#register-name"),
                    position: "r",
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Name can not be Enpty"
                })
            }
            if(tel == ""){
                $.pt({
                    target: $("#register-tel"),
                    position: "r",
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Telephone Number can not be Enpty"
                })
            }
            //用户名只能是15位以下的字母或数字
            var regExp = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if(!regExp.test(username)){
                $.pt({
                    target: $("#register-username"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Invalid National identity Number"
                });
                return false;
            }
            //手机号码
            var regExp2=new RegExp("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$");
            if(!regExp2.test(tel)){
                $.pt({
                    target: $("#register-tel"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Invalid Phone Number "
                });
                return false;
            }


                spop({
                    template: '<h4 class="spop-title">Register Success</h4>Wait for 3 minutes',
                    position: 'top-center',
                    style: 'success',
                    autoclose: 3000,
                    onOpen : function(){
                        var second = 2;
                        var showPop = setInterval(function(){
                            if(second == 0){
                                clearInterval(showPop);
                            }
                            $('.spop-body').html('<h4 class="spop-title">注册成功</h4>Wait '+second+' minutes back to login.');
                            second--;
                        },1000);
                    },
                    onClose : function(){
                        goto_login();
                        return true;

                    }
                });
                return true;
        }

        //重置密码
        //重置密码
        function forget(){
            var username = $("#forget_username").val(),
                password = $("#forget_password").val(),
                phone = $("#forget_phone").val(),
                flag = false,
                validatecode = null;
            //判断用户名密码是否为空
            if(username == ""){
                $.pt({
                    target: $("#forget_username"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"ID Number can not be Enpty"
                });
                flag = true;
            }
            //用户名只能是15位以下的字母或数字
            var regExp = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if(!regExp.test(username)){
                $.pt({
                    target: $("#forget_username"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Invalid ID Number "
                });
                flag = true;
            }


            if(password == ""){
                $.pt({
                    target: $("#forget_password"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Password Can Not Be Empty"
                });
                flag = true;
            }

            var regExp2=new RegExp("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$");
            if(!regExp2.test(phone)){
                $.pt({
                    target: $("#forget_phone"),
                    position: 'r',
                    align: 't',
                    width: 'auto',
                    height: 'auto',
                    content:"Invalid Phone Number "
                });
                flag = true;
            }
            //检查用户名是否存在
            //调后台方法

            //检查注册码是否正确




            if(flag){
                return false;
            }else{//重置密码
                spop({
                    template: '<h4 class="spop-title">修改密码成功</h4>Wait for 3 minutes',
                    position: 'top-center',
                    style: 'success',
                    autoclose: 3000,
                    onOpen : function(){
                        var second = 2;
                        var showPop = setInterval(function(){
                            if(second == 0){
                                clearInterval(showPop);
                            }
                            $('.spop-body').html('<h4 class="spop-title">修改密码成功</h4>Wait '+second+' minutes back to login.');
                            second--;
                        },1000);
                    },
                    onClose : function(){
                        goto_login();
                        return true;
                    }
                });
                return true;
            }
        }







    </script>
    <style type="text/css">
        html{width: 100%; height: 100%;}

        body{

            /*background-color: #00BDDC;*/

            background: url(images/snow.jpg) no-repeat center center #2D0F0F;

            /*background-size: 100% 100%;*/

        }

        .snow-container { position: fixed; top: 0; left: 0; width: 100%; height: 100%; pointer-events: none; z-index: 100001; }

    </style>
</head>
<body>
<!-- 雪花背景 -->
<div class="snow-container"></div>
<!-- 登录控件 -->
<div id="login">
    <input id="tab-1" type="radio" name="tab" class="sign-in hidden" checked />
    <input id="tab-2" type="radio" name="tab" class="sign-up hidden" />
    <input id="tab-3" type="radio" name="tab" class="sign-out hidden" />
    <div class="wrapper">
        <!-- 登录页面 -->
        <div class="login sign-in-htm">
            <form class="container offset1 loginform" action="login" method="post">


                <div class="pad input-container">
                    <section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="login-username" name="id"
                                       autocomplete="off" placeholder="Please Enter Your ID:" tabindex="1" maxlength="20" />
								<label class="input__label input__label--hideo" for="login-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="login-password" placeholder="Please Enter Your Password:" tabindex="2" maxlength="15" name="pwd"/>
								<label class="input__label input__label--hideo" for="login-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                    </section>
                </div>
                <div class="form-actions">
                    <a tabindex="4" class="btn pull-left btn-link text-muted" onclick="goto_forget()">忘记密码</a>
                    <a tabindex="5" class="btn btn-link text-muted" onclick="goto_register()">注册</a>
                    <input class="btn btn-primary" type="submit" tabindex="3" onclick="return login()" value="Login"
                           style="color:white;"/>
                </div>
            </form>
        </div>

        <!-- 忘记密码页面 -->
        <div class="login sign-out-htm">
            <form action="/forgetpass" method="post" class="container offset1 loginform">

                <div class="pad input-container">
                    <section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="forget_username"  name="forget_username" autocomplete="off" placeholder="Please Enter Your ID Number"/>
								<label class="input__label input__label--hideo" for="forget_username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="forget_phone" name="forget_phone" autocomplete="off" placeholder="Please Enter Your Phone Number"/>
								<label class="input__label input__label--hideo" for="forget_phone">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="forget_password" name="forget_password" placeholder="Please Enter Your New Password" />
								<label class="input__label input__label--hideo" for="forget_password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                    </section>
                </div>
                <div class="form-actions">
                    <a class="btn pull-left btn-link text-muted" onclick="goto_login()">马上登录</a>
                    <input class="btn btn-primary" type="submit" onclick="return forget()" value="Reset Password"
                           style="color:white;"/>
                    <%--onclick="return forget()"--%>
                </div>
            </form>
        </div>
        <!-- 注册页面 -->
        <div class="login sign-up-htm">
            <form action="/forregister" method="post" class="container offset1 loginform">

                <div class="pad input-container">
                    <section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" name="User_ID" id="register-username"
                                       autocomplete="off" placeholder="Please Enter Your ID Number" maxlength="20"/>
								<label class="input__label input__label--hideo" for="register-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" name="User_Password" id="register-password" placeholder="Please Enter Your Password" maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="register-repassword" placeholder="Please Ensure Your Password" maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-repassword">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>

                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="register-name" name="User_Name" placeholder="Please Enter Your Name" maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-name">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>

                        <%--<span class="input input--hideo">--%>
								<%--<input class="input__field input__field--hideo" type="text" id="register-code" autocomplete="off" placeholder="请输入注册码"/>--%>
								<%--<label class="input__label input__label--hideo" for="register-code">--%>
									<%--<i class="fa fa-fw fa-wifi icon icon--hideo"></i>--%>
									<%--<span class="input__label-content input__label-content--hideo"></span>--%>
								<%--</label>--%>
							<%--</span>--%>
                        <span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="register-tel" name="User_Phone" placeholder="Please Enter Your Tel" maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-tel">
									<i class="fa fa-fw fa-phone icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
                        </span>

                        <span class="input selectize">
                                <select id="User_Country" name="User_Country">
                                    <option class="input__field input__field--hideo" value="China">中国</option>
                                    <option class="input__field input__field--hideo" value="USA">美国</option>
                                    <option class="input__field input__field--hideo" value="Korea">韩国</option>
                                </select>
								<%--<input class="input__field input__field--hideo" type="text" id="register-cur" name="User_Phone" placeholder="Please Enter Your Tel" maxlength="15"/>--%>
                        </span>



                        <br><br>
                        <%--<span class="radio-inline bottom-right">--%>
								<%--<input type="radio" id="register-type" name="vs1" value="Financier"/>Sponsor--%>
                        <%--</span>--%>

                        <%--<span class="radio-inline bottom-right">--%>
                            <%--<input type="radio" id="register-type2" name="vs1" value="Investor"/>Investor--%>
                        <%--</span>--%>
                    </section>
                </div>
                <div class="form-actions">
                    <a class="btn pull-left btn-link text-muted" onclick="goto_login()">登录</a>
                    <input class="btn btn-primary" type="submit" onclick="return register()" value="Register"
                           style="color:white;"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
    <%--<body>--%>
        <%--<form action="login" method="post">--%>
            <%--<label for="sid">Student ID:</label>--%>
            <%--<input id="sid" type="text" name="id">--%>
            <%--<br><br>--%>
            <%--<label for="spwd">Student Password:</label>--%>
            <%--<input id="spwd" type="password" name="pwd">--%>
            <%--<br><br>--%>
            <%--<input type="submit" value="Login">--%>
            <%--<a href="forregister">Register</a>--%>
        <%--</form>--%>
    <%--</body>--%>
</html>
