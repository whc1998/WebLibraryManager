<%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/8
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<div>
    <table background="283H.jpg" align="center"  height="700">
        <tr height="170">
            <td width="570px"></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <table>
                    <form method="POST" action="http://localhost:8080/test/hello.html?login=%B5%C7%C2%BC"
                          name="frmLogin">
                        <tr>
                            <td>用户名：</td>
                            <td><input type="text" name="username" value="Your name" size="20" maxlength="20"
                                       onfocus="if (this.value=='Your name')  this.value='';"/></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>密 码：</td>
                            <td><input type="password" name="password" value="Your password" size="20" maxlength="20"
                                       onfocus="if (this.value=='Your password')  this.value='';"/></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="zlogin" value="1">自动登录</td>
                        </tr>
                    </form>
                </table>
            </td>
        <tr>
            <td></td>
            <td>
                <table>
                    <tr>
                        <td><input type="submit" name="login" value="登录" onClick="return validateLogin()"/></td>
                        <td><input type="reset" name="rs" value="重置"></td>
                        <%--<td><input type="button" name="button" value="注册"--%>
                                   <%--onclick="location.href='http://localhost:8080/test/zc.html?login=%B5%C7%C2%BC'"></td>--%>
                    </tr>
                    </tr>
                </table>
            </td>
    </table>
</div>
</form>
<script language="javascript">
    function validateLogin() {
        var sUserName = document.frmLogin.username.value;
        var sPassword = document.frmLogin.password.value;
        var sinputCode = document.frmLogin.inputcode.value;
        if ((sUserName == "") || (sUserName == "Your name")) {
            alert("请输入用户名!");
            return false;
        }

        if ((sPassword == "") || (sPassword == "Your password")) {
            alert("请输入密码!");
            return false;
        }
        if ((sinputCode == "") || (sinputCode == "Your code")) {
            alert("请输入验证码!");
            return false;
        }
    }
</script>
</body>
</html>
