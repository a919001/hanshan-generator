<!DOCTYPE html>
<html lang="zn-CH">
<head>
    <meta charset="UTF-8">
    <title>山寒</title>
</head>
<body>
    <h1>欢迎来到山寒与茶官网</h1>
    <ul>
        <#--循环渲染导航条-->
        <#list menuItems as item>
            <li><a href="${item.url}">${item.label}</a></li>
        </#list>
    </ul>
    <#--底部版权信息-->
    <footer>
        ${currentYear} 山寒官网
    </footer>
</body>
</html>