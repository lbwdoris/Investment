<%--
  Created by IntelliJ IDEA.
  User: henry_fordham
  Date: 2018/5/4
  Time: 下午5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QianQian Investment</title>
</head>
<body>
    <form action="forregister" method="post">
        <label for="sid">ID</label>
        <input type="text" id="sid" name="id">
        <br><br>

        <label for="spwd">Password</label>
        <input type="password" id="spwd" name="password">
        <br><br>

        <label for="sage">Age</label>
        <input type="text" id="sage" name="age">
        <br><br>

        <label for="sname">Name</label>
        <input type="text" id="sname" name="name">
        <br><br>

        <select id="sgender" name="gender">
            <option value="M">Male</option>
            <option value="F">Female</option>
        </select>
        <br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
