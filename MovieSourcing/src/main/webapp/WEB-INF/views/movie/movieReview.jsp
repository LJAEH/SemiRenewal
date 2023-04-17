<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/movieReview.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>영화리뷰페이지</title>
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
                        <span id="topName">${movieReviewList[0].movieTitle} 리뷰</span>
                    </div>
           
                    <div class="reviewContainer">
                        <div class="review1">
                            <span class="reviewCount">${fn:length(movieReviewList)}개의 리뷰</span> 
                        </div>
                        
                        <c:forEach var="movieReviewList" items="${movieReviewList}">
	                        <div class="reviewbox">
	                            <div class="reviewInfo">
	                                <div class="moviewrap">
	                                <div id="user">
	                                    <div class="poster">
											<img src="${contextPath}${movieReviewList.memPic}" id="poster">
	                                    </div>
	                                </div>    
	                                    <div class="reviewName">
	                                    <div class="review">
	                                            <span id="reviewName">${movieReviewList.memNic}</span>
	                                        </div>
	                                        <div class="reviewScoreBox">
	                                            <span>작성자평가</span>
	                                            <div class="scoreLight"></div>
	                                            <div id="userScore">
	                                                <span class="userScore">${movieReviewList.reviewScore / 2}</span>
	                                            </div>
	                                        </div>
	                                        <div class="userControl"></div>
	                                    </div>
	                                </div>
	                                <div>
	                                    <span>${movieReviewList.reviewDate}</span>
	                                </div>
	                            </div>
	                            <div class="reviewContent">
	                                <span id="reviewContent">
	                                   ${movieReviewList.reviewContent}
	                                </span>
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
    
    <script src="${contextPath}/resources/js/movie/movieReview.js"></script>
</body>
</html>