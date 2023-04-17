<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="member" value="${map.member}" />
<c:set var="hateList" value="${map.hateList}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/hateList.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>
    
    <title>본영화</title>
</head>
<body>
 
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header class="backpageHeader">
                    <div class="backpageDiv">
                        <a href="javascript:window.history.back();" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <div class="top">
                        <span id="topName">관심없어요</span>
                    </div>
           
                    <div class="Container">
                        <div class="infomation"> 
                            <span class="Count">${fn:length(hateList)}개의 영화를 설정</span> 
                            <a href="#"></a>
                        </div>
                        <c:forEach var="hateList" items="${hateList}">
	                        <div class="watched" style=" cursor: pointer;" 
	                        onclick="location.href='${contextPath}/movie/movieInfo?movieNo=${hateList.movieNo}'">
	                            <div class="watchedInfo">
	                               
	                                <div class="watchedInfoWrap">
	                                    <div><span id="movieName">${hateList.movieTitle}</span></div>
	                                 
	                                </div>
	                            </div>
	                            <div id="watchedMenu">
	                                <a class="fa-regular fa-circle-xmark" id="watchedDelete" 
	                                href="${contextPath}/movielist/deleteHateList?movieNo=${hateList.movieNo}&memberNo=${loginMember.memberNo}"></a>
	                            </div>
	                        </div>
                        </c:forEach>
                        
                    </div>
                </main>
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
    </div>
     -->
    
    <script src="${contextPath}/resources/js/movie/hateList.js"></script>

</body>
</html>