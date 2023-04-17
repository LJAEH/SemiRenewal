<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="movieListInfo" value="${map.movieListInfo}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/movieList.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>
    
    <title>배우영화</title>
</head>
<body>
 
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header class="backpageHeader">
                    <div classs="backpageDiv">
                        <a href="#" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>


                <main id="contents">
                
                    <div class="actorInfo">
                        <div><img src="/이미지/주연1.jpg" alt="" id="actorImg"></div>
                        <div><span id="actorName">송강호</span></div>
                    </div>
           
                    <div class="Container">
                        <div id="information"> 
                            <span class="Count">105개의 검색결과</span> 
                            <a href="#">더보기</a>
                        </div>
                        <div id="selectedMovie">
                           
                   			<div id="listBox">
                                <a href="#" id="movieListLink">
                                    <div>
                                        <img src="/이미지/같은 장르.jpg" alt="#" id="listPoster">
                                    </div>
                                    <div>
                                        <span id="movieTitle">존 윅</span>
                                    </div>
                                    <div>
                                        <div>
                                            <i class="fa-solid fa-circle" class="scoreCircle"></i>
                                            <span class="movieScore">8.3</span>    
                                        </div>
                                        <div>
                                            <span><i class="fa-solid fa-ellipsis-vertical" id="menu"></i></span>
                                        </div>
                                        
                                    </div>
                                    
                                </a>
                            </div>
                           

                        </div>
                    </div>
                   
                </main>

                <!-- 하단 네비 -->
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
    
    
    <script src="${contextPath}/resources/js/movie/movieList.js"></script>
    
</body>
</html>