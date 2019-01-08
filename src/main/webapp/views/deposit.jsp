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

    <script>
        function add() {
            var money=document.getElementById("Deposit_Money").value;
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
    <script>
        var country="${user.user_Country}";
        var psd;
        if (country=="Korea")
            psd="금액을 입력하십시오";
        else
            if (country=="China")
                psd="请输入金额（人民币）";
        else
            psd="Please Enter the Amount in Dollar"
    </script>
    <canvas width="1366" height="800" style="position:absolute"></canvas>

    <div class="body">

        <div class="vli" style="margin: 50px auto">

            <div class="wrapper move">
                <div id="register">
                    <form class="form2" method="post" action="/addmoney">
                        <h3>, ${user.user_Name}</h3>

                        <div class="vali">
                            <input type="text" id="Deposit_Money" name="Deposit_Money" placeholder="请输入您的金额">
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
