<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:set var="member" value="${map.member}"/>
<c:set var="communityList" value="${map.communityList}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/communityList.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>communityList</title>
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
                        <span id="topName">"${member.memberNick}"님이 커뮤니티에 작성한 글목록</span>
                    </div>
           
                    <div class="reviewContainer">
                        <div class="review1"> 
                            <span class="reviewCount">${fn:length(communityList)}개의 작성글</span> 
                            <a href="#"></a>
                        </div>
                        
                        <c:forEach var="communityList" items="${communityList}">
                        <div class="reviewbox">
                            <div class="reviewInfo">
                                <div class="moviewrap">
                                    
                                    <div class="review">
                                        <div class="reviewName">
                                            <span id="reviewName">${communityList.comTitle}</span>
                                        </div>
                                        <div class="userControl"></div>
                                    </div>
                                </div>
                                <div>
                                    
                                </div>
                                <div class="span2">
                                    <span class="span2">조회수</span> 
                                    <span class="span2">${communityList.readCount} &nbsp&nbsp</span>
                                    <span id="date" class="span2">${communityList.comDate}</span>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </main>
            </div>
        </div>

    </div>
    
    <script src="${contextPath}/resources/js/movie/communityList.js"></script>
</body>
</html>