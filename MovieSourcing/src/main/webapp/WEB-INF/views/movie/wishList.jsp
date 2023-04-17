<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="member" value="${map.member}"/>
<c:set var="wishList" value="${map.wishList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/wishList.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>찜영화</title>
</head>
<body>
 
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header class="backpageHeader">
                    <div classs="backpageDiv">
                        <a href="javascript:window.history.back();" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <div class="top">
                        <span id="topName">"${member.memberNick}"님의 찜한 영화</span>
                    </div>
           
                    <div class="Container">
                        <div class="infomation"> 
                            <span class="Count">${fn:length(wishList)}개의 찜목록</span> 
                            <a href="#"></a>
                        </div>
                        
                        <c:forEach var="wishList" items="${wishList}">
                        <div class="watched" style=" cursor: pointer;" 
	                        onclick="location.href='${contextPath}/movieInfo?movieNo=${wishList.movieNo}'">
                            <div class="watchedInfo" >
                                <img src="${contextPath}${wishList.moviePoster}" class="watchedImg" alt="">
                                <div class="watchedInfoWrap">
                                    <div><span id="movieName">${wishList.movieTitle}</span></div>
                                    <div><span id="date">${wishList.movieOpen}</span></div>
                                    <div class="score"> 
                                        <span id="score">관객평점 <span id="movieScore">${wishList.movieScore}</span>/10.0</span>
                                    </div>
                                </div>
                            </div>
                            <div id="watchedMenu">
                                <a class="fa-regular fa-circle-xmark" id="watchedDelete"
                                href="${contextPath}/movielist/deleteWishList?movieNo=${wishList.movieNo}&memberNo=${loginMember.memberNo}"></a>

                                <a class="fa-solid fa-ellipsis-vertical" id="watchedDot"></a>
                            </div>
                        </div>
                        </c:forEach>
                        
                    </div>
                   
                </main>
                <header class="navHeader">
                    <nav class="nav">
                        <a href="#" class="home">
                            <i class="fa-solid fa-house"></i>
                            <span>홈</span>
                        </a>
                        <a href="#" class="community">
                            <i class="fa-solid fa-comments"></i>
                            <span>커뮤니티</span>
                        </a>
                        <a href="#" class="search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                            <span>탐색</span>
                        </a>
                        <a href="#" class="mypage">
                            <i class="fa-solid fa-user"></i>
                            <span>마이페이지</span>
                        </a>
                    </nav>
                </header>
                
            </div>
        </div>

    </div>
<!-- 
    모달창
    <div id="modalOverlay" class="modal">
        <div id="modalMenu">
            <div>

            </div>
            <div>   
                <button></button>
                <button></button>
                <button></button>
            </div>


        </div>
    </div> -->
    
    
    <script src="${contextPath}/resources/js/movie/wishList.js"></script>

</body>
</html>