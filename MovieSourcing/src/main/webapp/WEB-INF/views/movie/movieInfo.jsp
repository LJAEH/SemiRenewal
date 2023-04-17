<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="movieInfo" value="${map.movieInfo}" />
<c:set var="moviePeople" value="${map.moviePeople}" />
<c:set var="movieReview" value="${map.movieReview}" />
<c:set var="movieRecommend" value="${map.movieRecommend}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/movieInfo.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>

    <title>개별영화페이지</title>
</head>
<script>const contextPath = "${contextPath}"</script>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

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
                <c:choose>
                	<c:when test="${!empty loginMember}">
	                	<script> const loginCheck = 1; </script>
	                	<input style="display:none" value="${loginMember.memberNo}" id="memNo">
	                	<input style="display:none" value="${movieInfo.movieNo}" id="movieNo">
	                </c:when>
	                
	                <c:otherwise>
						<script> const loginCheck = 0; </script>                
	                </c:otherwise>
                
                </c:choose>
                
 
                    <div class="mainContainer">
                        <div class="poster">
                            <img id=posterImg src="${contextPath}${movieInfo.moviePoster}"></img>
                        </div>
                        <div class="movieInfoBox">
                            <div class="checkBox">
                                <div></div>
                                <form action="#" onsubmit="return submit_1('${loginMember.memberNo}', 
                                '${movieInfo.movieNo}')">
	                                <span id="watchedText">못 본 영화에요</span>
	                                <div class="toggle">
	                                    <input type="checkbox" name="toggle1" id="toggle1" value="1">
	                                    <label for="toggle1">스위치</label>
	                                    <input type="submit" id="submit1">
	                                </div>
                                </form>
                            </div>
                            <div class="titleBox">
                                <div>
                                    <span id="movieTitle">${movieInfo.movieTitle}</span>
                                </div>
                            </div>
                            <div id="engBar"><span id="engTitle">${movieInfo.movieEngTitle}</span><span> |</span>
                                <span id="openDate">${movieInfo.movieOpenDate}</span>
                            </div>
                            <div>
                                <table>
                                    <tr>
                                        <td><span>감독</span></td>
                                        <td><span id="director">${moviePeople.pdName}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>배우</span></td>
                                        <td>
                                            <span id="actor">${moviePeople.act1}</span>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                    	<td>
                                    	</td>
                                    	<td>
                                    		<span id="actor">${moviePeople.act2}</span>
                                    	</td>
                                    </tr>
                                    
                                    <tr>
                                    	<td>
                                    	</td>
                                    	<td>
                                    		<span id="actor">${moviePeople.act3}</span>
                                    	</td>
                                    </tr>
                                    <tr>
                                    	<td>
                                    	</td>
                                    	<td>
                                    		<span id="actor">${moviePeople.act4}</span>
                                    	</td>
                                    </tr>
                                    <tr>
                                        <td><span>등급</span></td>
                                        <td><span id="grade">${movieInfo.movieGrade}</span></td>
                                    </tr>
                                </table>
                            </div>
                            <div class="genreBox">
                                <div><span class="genreSpan">#${movieInfo.movieGenre[0]}</span></div>
                                <div><span class="genreSpan">#${movieInfo.movieGenre[1]}</span></div>
                                <div><span class="genreSpan">#${movieInfo.movieGenre[2]}</span></div>
                            </div>
                            <div class="scoreBox">
                                <div id="scoreBar">
                                    <div id="score" style="background-color: springgreen; color:black; width:10%"><span id="scoreComment">${movieInfo.movieScore}</span></div>
                                </div>
                                
                                <form action="#" onsubmit="return submit_2('${loginMember.memberNo}','${movieInfo.movieNo}')">
	                                <div id="wannasee">
	                                    <div class="fa-solid fa-heart"  id="wannaheart"></div>
	                                    <input type="submit" id="submit2" style="display:none">
	                                </div>
                                </form>
                                
                                

                            </div>
                            <div class="writeBox">
                                <button id="lifeMovie" type="button" style="background-color: rgb(41, 128, 185);">'인생영화'설정</button>
                                <button id="reviewWrite" type="button">리뷰쓰기</button>
                            </div>
                            
                        </div>
                    </div>
                    <div class="previewContainer">
                        <span class="bold2">줄거리</span>
                        <div class="previewbox">
<pre class="preview">
${movieInfo.moviePreview}
</pre>
                        </div>
                    </div>
                    <div class="actorContainer">
                        <span class="bold2">배우/제작진</span>
                        <div class="everyone">
                            <!-- 개별 배우 박스 -->
                            
                            <a class="actorbox" href="pdMovie?pdNo=${moviePeople.pdNo}">
                                <div><img src="${contextPath}${moviePeople.pdPicture}" id="directorBox"></div>
                                <span id="director">${moviePeople.pdName}</span>
                                <span>감독</span>
                            </a>
                            <a class="actorbox" href="actorMovie?actorNo=${moviePeople.act1No}">
                                <div><img src="${contextPath}${moviePeople.act1Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act1}</span>
                                <span>배우</span>
                            </a>
                            <a class="actorbox" href="actorMovie?actorNo=${moviePeople.act2No}">
                                <div><img src="${contextPath}${moviePeople.act2Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act2}</span>
                                <span>배우</span>
                            </a>
                            <a class="actorbox" href="actorMovie?actorNo=${moviePeople.act3No}"> 
                                <div><img src="${contextPath}${moviePeople.act3Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act3}</span>
                                <span>배우</span>
                            </a>
                            <a class="actorbox" href="actorMovie?actorNo=${moviePeople.act4No}">
                                <div><img src="${contextPath}${moviePeople.act4Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act4}</span>
                                <span>배우</span>
                            </a>
                        </div>
                    </div>
                    <div class="reviewContainer">
                        <div class="review1"> 
                            <span class="bold2">회원들의 리뷰</span> 
                            <a href="${contextPath}/movieReviewList?movieNo=${movieInfo.movieNo}">더보기</a>
                        </div>
                        
                        <c:choose>
                        	<c:when test="${empty movieReview}">
                        		<h3 id="firstReview">첫 리뷰의 주인공이 되어보세요</h3>
                        		<script> movieReview = false; </script>
                        	</c:when>
                        	
                        	<c:otherwise>
	                        	<script>const movieReview = true;</script>
	                        	<c:forEach var="review" items="${movieReview}">
			                        <div class="reviewbox">
			                            <div class="reviewInfo">
			                                <div>
			                                    <div id="user">
				                                    <img src="${contextPath}${review.memPic}">
			                                        <span id="userName">${review.memNic}</span>
			                                    </div>
			                                    <div class="scoreLight" style="background-color:springgreen"></div>
			                               
			                                    <div class="userScoreBox">
			                                        <span class="userScore">${review.reviewScore / 2}</span>	
			                                    </div>
			                                </div>
			                                <div class="reviewDotImgWrapper"> 
			                                <span  style="margin-right : 20px">${review.reviewDate}</span>
			                                    <label>
			                                   	 	<input id="reviewDotImg" type="checkbox"  value="${review.memNo}"
			                                    	class="hidden_checkbox">
			                                    	<i class="fa-solid fa-ellipsis-vertical" id="reviewDotImgI"></i>
			                                    </label>
				                    			<div id="popup_menu" >
					                                <ul class="popup_main_menu">
					                                    <!-- session 이용하여 회원 정보 일치시 수정 삭제 버튼 보이고 아니면 안보이게 -->
					                                    <li><a href="#" onclick="movieInfoReviewUpdate();">수정</a></li>
					                                    <li><a href="#" onclick="reviewDelete('${review.movieNo}', '${review.memNo}')">삭제</a></li>
					                                    <li><a href="">신고</a></li>
					                                </ul>
					                            </div>
			                                </div>
			                                
			                                
			                            </div>
			                            <div class="reviewContent">
			                                <span id="reviewContent">
			                                	${review.reviewContent}
			                                </span>
			                            </div>
			                        </div>
			                        
	                       		</c:forEach>
                       		</c:otherwise>
                       	</c:choose>
                       	
                    </div>
                    
                    <div class="recommendContainer">
                        <span class="bold2">이런영화는 어때요??</span> 
                        <div class="everyone">
                            <a href="movieInfo?movieNo=${movieRecommend[0].movieNo}" class="recommendMovieBox">
                                <img src="${contextPath}${movieRecommend[0].moviePoster}" id="recommendMovie">
                            </a>
                            <a href="movieInfo?movieNo=${movieRecommend[1].movieNo}" class="recommendMovieBox">
                                <img src="${contextPath}${movieRecommend[1].moviePoster}" id="recommendMovie">
                            </a>
                            <a href="movieInfo?movieNo=${movieRecommend[2].movieNo}" class="recommendMovieBox"> 
                                <img src="${contextPath}${movieRecommend[2].moviePoster}" id="recommendMovie">  
                            </a>
                            <a href="movieInfo?movieNo=${movieRecommend[3].movieNo}" class="recommendMovieBox">    
                                <img src="${contextPath}${movieRecommend[3].moviePoster}" id="recommendMovie">  
                            </a>
                        </div>
                </main>
                
            </div>
        </div>
    </div>

    <div id="reviewOverlay" class="reviewOverlay">
        <div id="reviewWriteBox">
            <div id="modalTitle">
                <span>리뷰를 작성해주세요</span>
            </div>
            <div id="modalScore">
                <div>
                    <span>별점 평가</span>
                </div>
                <div id="starBox">
                    <span class="star">
                        ★★★★★
                        <span>★★★★★</span>
                        <input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10"
                        id="starScore">
                    </span>
                </div>
            </div>
            <div id="modalDiv1">
                <div id="modalDiv2">
                    <div >
                        <span>간단히 작성해 보세요</span>
                    </div>
                    <div>
                        <span id="reviewCounter">0</span>
                        <span>/100</span>
                    </div>
                </div>
                <div>
                    <textarea name="review" id="reviewArea" spellcheck="false" ></textarea>
                </div>
                <div>
                    <button type="button" id="reviewSubmit"><span>저 장</span></button>
                </div>
            </div>
        </div>
    </div>
    
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

    <script src="${contextPath}/resources/js/movie/movieInfo.js"></script>

</body>
</html>