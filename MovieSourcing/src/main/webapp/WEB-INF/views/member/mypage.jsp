<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!-- 관심없어요 리뷰 커뮤니티 찜 본영화 순 -->
<c:set var="memberNo" value="${map.memberNo}"/>
<c:set var="memberCount" value="${map.memberCount}"/>
<c:set var="lifeMovieList" value="${map.lifeMovieList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/basic.css">

    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>

    <title>마이페이지</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
   
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
                    <section class="outer-wrap">
                        <div class="inner-wrap">
                            <div class="info-container">
                                <div class="user-wrap">
                                    <div id="userInfo">
                                        <div class="avatar-wrap">
	                                       <c:if test="${empty loginMember.memberImg}">
	                                            <span>
	                                                <img src="${contextPath}/resources/images/user.png" class="profileImg">
	                                            </span>
	                                       </c:if>
	                                        
	                                       <c:if test="${!empty loginMember.memberImg}">
	                                            <span>
	                                                 <img src="${contextPath}/${loginMember.memberImg}" class="profileImg">
	                                            </span>
	                                       </c:if>
                                        </div>
                                        
                                        <div class="info-wrap">
                                            <div class="user-name">
                                                <span>${loginMember.memberNick}</span>

                                                <!-- 개인창을 벗어나면 display none 으로 제어 -->
                                            </div>
                                            <div class="user-email">
                                            	<span>${loginMember.memberEmail}</span>
                                        	</div>
                                        </div>
                                    </div>
                                    
                                    <c:if test="${memberNo eq loginMember.memberNo}">
	                                    <div id="userMenu">
	                                        <a class="fa-regular fa-pen-to-square" href="myPagechangeEnter"></a>
	                                        <a class="fa-solid fa-right-to-bracket" href="logout"></a>
	                                    </div>
                                    </c:if>
                                </div>
                               
                                <div id="introduceBox">
	                       			<c:if test="${empty loginMember.memberIntro}">             
	                                    <span id="introduceSpan">
	                                        default
	                                    </span>
	                        		</c:if>
	
	                        		<c:if test="${!empty loginMember.memberIntro}">             
	                                    <span id="introduceSpan">
	         		                        ${loginMember.memberIntro}
	                                    </span>
	                        		</c:if>
                                </div>

                            </div>
                        </div>

                    </section>


                    <!-- 카운트 -->
                    <section class="contents-wrap">
                        <div class="profile-count-container">
                            <a href="${contextPath}/movielist/wishList?memberNo=${memberNo}" >
                                <span id="wannaseeCount" class="countSpan">${map.memberCount[3].count}</span>
                                <span>찜 영화</span>
                            </a>
                            
                            <a href="${contextPath}/movielist/watchedList?memberNo=${memberNo}">
                                <span id="watchedCount" class="countSpan">${map.memberCount[4].count}</span>
                                <span>본 영화</span>
                            </a>

                            <a href="${contextPath}/movielist/hateList?memberNo=${memberNo}" >
                                <span id="hateMovie" class="countSpan">${map.memberCount[0].count}</span>
                                <span>관심없어요<span class="fa-solid fa-circle-info" id="infoMark" title="관심없는 장르를 제외해줍니다."></span></span>
                            </a>
                        </div>



                        <div class="profile-container2">
                            <div class="profile-container-box"  style=" cursor: pointer;" 
                            onclick="location.href='${contextPath}/movielist/reviewList?memberNo=${memberNo}'">
                                <a href="#">작성한 리뷰</a>
                                <a href="#">
                                <span id="reviewCount">${map.memberCount[1].count}</span> <i class="fa-solid fa-chevron-right" id="arrow"></i>
                                </a>
                            </div>

                            <hr id="boxLine" class="boxline" color="gray">

                            <div class="profile-container-box" style=" cursor: pointer;" 
                            onclick="location.href='${contextPath}/movielist/communityList?memberNo=${memberNo}'">
                                <a href="#">커뮤니티 작성글</a>
                                <a href="#"><span id="communityCount">${map.memberCount[2].count}</span> <i class="fa-solid fa-chevron-right" id="arrow"></i></a>
                            </div>

                           <!--  <hr id="boxLine2" class="boxline" color="gray">

                            개인창을 벗어나면 display none 으로 제어
                            <div class="profile-container-box" id="unlikeBox">
                                <div>
                                    <a href="#">관심없어요</a>
                                    <a class="fa-solid fa-circle-info" id="infoMark" title="관심없는 장르를 제외해줍니다."></a>
                                </div>

                                <a href="#" id="genreBox">
                                    <div class="genreDiv"><span class="genre">액션</span></div>
                                    <div class="genreDiv"><span class="genre">외국영화</span></div>
                                    <div class="genreDiv"><span class="genre">독립영화</span></div>
                                </a>
                            </div>   -->

                        </div>

                        

                        <div class="lifemovie-container">
                            <div class="lifemovie-top">
                                <span>인생영화</span>

                                <!-- 개인창을 벗어나면 display none 으로 제어 -->
                                <a href="#">관리</a>
                            </div>

                            <div class="lifemovie-bottom">

							<c:if test="${ empty lifeMovieList }">

							    <!-- 타인이 봤을때 없을 경우 -->

							    <c:if test="${memberNo ne loginMember.memberNo }">

	                                <div class="lifemovie-empty-foreign">

	                                    <span>등록된 인생 영화가 없습니다.</span>

	                                </div>

                                </c:if>

                                <c:if test="${memberNo eq loginMember.memberNo }">

		                                <!-- 개인이 봤을때 등록된 인생영화가 없을 경우  -->
	                                <div class="lifemovie-empty"><span>인생영화를 등록해주세요</span></div>
	                                <a class="lifemovie-button">'인생영화' 등록</a>
                                </c:if>
							</c:if>

							<c:if test="${ not empty lifeMovieList }">
								<div id="lifeMovieBox">
									<c:forEach var="lifeMovie" items="${lifeMovieList}">
										<div id="posterBox">
											<img src="${contextPath}${lifeMovie.moviePoster}" id="poster"
											onclick="location.href='${contextPath}/movieInfo?movieNo=${lifeMovie.movieNo}'">
										</div>
									</c:forEach>
								</div>
							</c:if>
                            </div>
                        </div>
                    </section>
                </main>

            </div>
        </div>

    </div>

   <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

   

    <script src="${contextPath}/resources/js/member/myPage.js"></script>

    

    

</body>

</html>