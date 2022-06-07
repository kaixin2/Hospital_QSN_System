<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css" />
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<div id="bigBox">
    <h1>LOGIN</h1>
    <div class="inputBox">
        <form action="mr_x/login" method="post">

            <div class="inputText">
                <i class="fa fa-user-circle" style="color: whitesmoke;"></i>
                <input type="text" placeholder="手机号或邮箱" name="username"/>
            </div>

            <div class="inputText">
                <i class="fa fa-key" style="color: whitesmoke;"></i>
                <input type="password" placeholder="密码" name="password"/>
            </div>

            <div class="inputText" >
                <select id="options" name="type">
                    <option value="D">病人</option>
                    <option value="H">医生</option>
                    <option value="A">管理员</option>
                </select>
            </div>

            <input type="submit" class="inputButton" value="登录" />
            <input type="submit" class="inputButton" value="注册" />
        </form>
    </div>
</div>
</body>
</html>
