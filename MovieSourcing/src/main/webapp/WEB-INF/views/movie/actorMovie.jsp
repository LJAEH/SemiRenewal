<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="actorInfo" value="${map.actorInfo}"/>
<c:set var="movieListInfo" value="${map.movieListInfo}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/actorMovie.css">
    
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
                        <a href="javascript:window.history.back();" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>


                <main id="contents">
                
                    <div class="actorInfo">
                        <div><img src="${contextPath}${actorInfo.actorImg}" id="actorImg"></div>
                        <div><span id="actorName">${actorInfo.actorName}</span></div>
                    </div>
           
                    <div class="Container">
                        <div id="information"> 
                            <span class="Count">${fn:length(movieListInfo)}개의 검색결과</span> 
                            <a href="#"></a>
                        </div>
                        <div id="selectedMovie">
                           
                           <c:forEach var="movieListInfo" items="${movieListInfo}">
                           		<div id="listBox">
                                <a href="${contextPath}/movieInfo?movieNo=${movieListInfo.movieNo}" id="movieListLink">
                                    <div>
                                        <img src="${contextPath}${movieListInfo.moviePoster}" alt="#" id="listPoster">
                                    </div>
                                    <div>
                                        <span id="movieTitle">${movieListInfo.movieTitle}</span>
                                    </div>
                                    <div>
                                        <div>
                                            <i class="fa-solid fa-circle" ></i>
                                            <span class="movieScore">${movieListInfo.movieScore}</span>    
                                        </div>
                                        <div>
                                            <span><i class="fa-solid fa-ellipsis-vertical" id="menu"></i></span>
                                        </div>
                                        
                                    </div>
                                </a>
                            	</div>
                           </c:forEach>


                        </div>
                    </div>
                   
                </main>

            </div>
        </div>
    </div>    
    <script src="${contextPath}/resources/js/movie/movieList.js"></script>

</body>
</html>