<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="member" value="${map.member}"/>
<c:set var="reviewList" value="${map.reviewList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/reviewList.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>개인리뷰페이지</title>
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
                        <span id="topName">"${member.memberNick}"님이 작성한 리뷰</span>
                    </div>
           
                    <div class="reviewContainer">
                        <div class="review1"> 
                            <span class="reviewCount">${fn:length(reviewList)}개의 리뷰</span> 
                            <a href="#"></a>
                        </div>
                        
                        <c:forEach var="reviewList" items="${reviewList}">
                        <div class="reviewbox">
                            <div class="reviewInfo">
                                <div class="moviewrap">
                                    <div class="poster">
                                        <img src="${contextPath}${reviewList.moviePoster}" id="poster">
                                    </div>
                                    <div class="review">
                                        <div class="reviewName">
                                            <span id="reviewName">${reviewList.movieTitle}</span>
                                        </div>
                                        <div class="reviewScoreBox">
                                            <span>작성자평가</span>
                                            <div class="scoreLight"></div>
                                            <div id="userScore">
                                                <span id="userScore">${reviewList.reviewScore}</span>
                                            </div>
                                        </div>
                                        <div class="userControl"></div>
                                    </div>
                                </div>
                                <div>
                                    <span id="date">${reviewList.reviewDate}</span>
                                </div>
                            </div>
                            <div class="reviewContent">
                                <span id="reviewContent">
									${reviewList.reviewContent}
                                </span>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </main>
            </div>
        </div>

    </div>
    
    <script src="${contextPath}/resources/js/movie/reviewList.js"></script>
</body>
</html>