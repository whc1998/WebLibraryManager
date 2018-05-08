<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <script>
        var answer="<%=request.getAttribute("answer")%>";
        if (answer!=="null"){
            alert(answer);
        }
    </script>

</head>
<body>

<div align="center" id="base" style="width: auto">

    <p>用户登录</p>
    <form action="LoginServlet" method="post">
        用户id：<input type="text" name="userId" id="userId" value="">
        <p/>
        密  码：<input type="password" name="passWord" id="passWord" value="">
        <p/>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>

</div>

</body>
</html>