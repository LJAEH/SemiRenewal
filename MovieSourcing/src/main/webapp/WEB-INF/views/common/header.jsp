<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/common/header.css">
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <header>
        <div>
            <a href="${contextPath}"><img src="${contextPath}/resources/images/img_etc/moviesourcing.png" name="home-logo"></a>
        </div>

        <div>
            <ul class="home-nav">
                <li><a href="${contextPath}" id="homebutton"><i class="fa-solid fa-house"></i></a></li>
                <li><a href="${contextPath}/msList" id="janrbutton"><i class="fa-solid fa-magnifying-glass"></i></a></li>
                <li><a href="${contextPath}/boardList"><i class="fa-solid fa-comments"></i></a></li>
                <li><a href="${contextPath}/simulation/simulEnter"><i class="fa-solid fa-trophy"></i></a></li>
            </ul>


        </div>

    
    </header>
</body>
</html>