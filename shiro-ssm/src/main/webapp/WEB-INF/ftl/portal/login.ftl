<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>jx - portal - 首页</title>
</head>
<body>
<div>
    <h1>Portal login</h1>
</div>
<div>
    <form action="${request.contextPath}/auth/portal/loginForm" method="post">
        <div>
            <label>username:</label><input name="username" value="portal" />
        </div>
        <div>
            <label>password:</label><input name="password" value="123" />
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</div>
</body>
</html>
