<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/semi-main.css">
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
    <title>semi-main</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
</head>
<body>
    <main>
        <header id="head">

                <div class="main-image">
                    <ul class="main-slides">
                        <li><img src="resources/images/bg_1.jpg" ></li>
                        <li><img src="resources/images/bg_1.jpg" ></li>
                        <li><img src="resources/images/bg_1.jpg" ></li>
                    </ul>
                </div>
            

                <div>
                    <a href="${contextPath}"><img src="resources/images/LogoMakr-9dgAJM.png" name="home-logo"></a>
                </div>

                <div>
                    <ul class="home-nav">
                        <li><a href="${contextPath}" id="homebutton">홈</a></li>
                        <li><a href="${contextPath}/msList" id="janrbutton">장르 검색</a></li>
                        <li><a href="${contextPath}/boardList">커뮤니티</a></li>
                        <li><a href="${contextPath}/simulation/simulEnter">추천 시뮬레이션</a></li>
                    </ul>
                    <ul class="home-nav2">
                        <li><a href="${contextPath}" id="homebutton"><i class="fa-solid fa-house"></i></a></li>
                        <li><a href="${contextPath}/msList" id="janrbutton"><i class="fa-solid fa-magnifying-glass"></i></a></li>
                        <li><a href="${contextPath}/boardList"><i class="fa-solid fa-comments"></i></a></li>
                        <li><a href="${contextPath}/simulation/simulEnter"><i class="fa-solid fa-trophy"></i></a></li>
                    </ul>
                </div>

                <div class="head-right">

                    <div class="search-box">
                
                    <input type="text" class="search-txt" placeholder="영화제목,감독,배우" >
                    <a href="#" class="search-btn"><i class="fa-solid fa-magnifying-glass" ></i></a>
                    </div>
					
					<c:choose>
						<c:when test="${ loginMember.memberId== null }">
		                    <div><a href="member/login"><i class="fa-solid fa-heart"></i></a></div>
		                    <div><a href="member/login"><i class="fa-solid fa-user"></i></a></div>
						</c:when>
						
						<c:otherwise>
							<div><a href="member/MyPageEnter" ><i class="fa-solid fa-heart"></i></a></div>
							<div> <a href="member/MyPageEnter?memberNo=${loginMember.memberNo}" ><i class="fa-solid fa-user"></i></a></div>
						</c:otherwise>
					</c:choose>
                </div>

          
        </header>

        <section class="main">

            <!-- 영화 정보 -->
            <div class="movie">
                <div class="chart active">
                    <span><i class="fa-solid fa-trophy"></i>&nbsp넷플릭스 랭킹&nbsp
                        <a class="rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    </span>
                    <ul class="charts">
                  	<c:forEach var="v" items="${result.netflixList}" varStatus="vs">
                        <i class="fa-solid fa-${vs.count}"></i><li><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}" alt="${v.movieTitle}"></a></li>
                    </c:forEach>
                    </ul>
                </div>

                <div class="chart">
                    <span><i class="fa-solid fa-trophy"></i>&nbsp왓챠 랭킹
                        <a class="rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    </span>
                    <ul class="charts">
                    <c:forEach var="v" items="${result.watchaList}" varStatus="vs">
                        <i class="fa-solid fa-${vs.count}"></i><li>><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}"  alt="${v.movieTitle}"></a></li>
                    </c:forEach>
                    </ul>
                </div>

                <div class="chart">
                    <span><i class="fa-solid fa-trophy"></i>&nbsp디즈니+ 랭킹
                        <a class="rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    </span>
                    <ul class="charts">
                    <c:forEach var="v" items="${result.disneyPlusList}" varStatus="vs">
                        <i class="fa-solid fa-${vs.count}"></i><li><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}"  alt="${v.movieTitle}"></a></li>
                    </c:forEach>
                    </ul>
                </div>


                <div class="m-recommend">
                <span>
                    <p><i class="fa-solid fa-film"></i>회원맞춤<br>&nbsp 영화추천</p> 
                </span>

                <div class="slide_wrapper">
                    <ul class="slides">
                    <c:forEach var="v" items="${result.recommandList}" varStatus="vs">
                        <li><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}"  alt="${v.movieTitle}"></a></li>
                    </c:forEach>
                    </ul>
                </div>
                 </div>
                <p class="controls">
                    <span class="prev">prev</span>
                    <span class="next">next</span>
                </p>


                <div class="m-contents">
                <span >
                    <p><i class="fa-regular fa-bookmark"></i>&nbsp새로운 <br>&nbsp컨텐츠</p>
                </span>

                
                <div class="slide_wrapper2">
                    
                    <ul class="slides2">
                    <c:forEach var="v" items="${result.newList}" varStatus="vs">
                        <li><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}"  alt="${v.movieTitle}"></a></li>
                    </c:forEach>
                    </ul>
                </div>
                </div>
                <p class="controls2">
                    <span class="prev2">prev</span>
                    <span class="next2">next</span>
                </p>
                <div class="community">
                    <span><p><i class="fa-regular fa-comments"></i>&nbsp커뮤니티</p></span>
                    <a><i class="fa-solid fa-chevron-right"></i></a>
				<c:forEach var="v" items="${result.communityList}" varStatus="vs">
                    <div class="community1">
                        <div>${v.movieTitle}</div>
                        <div>
                            <div class="user">
                                <img src="${contextPath}${v.memImg}" id="userimg1" class="userimg">
                                <span class="userInfo">
                                    <span class="userNick" id="userNick1">${v.memNick}</span>
                                    <span class="date" id="date1">${v.comDate}</span>
                                </span>
                            </div>
                            <p class="communityDetail">${v.comContent}</p>
                        </div>
                        
                    </div>
                </c:forEach>
                </div>

                <div class="review">

                    <span><i class="fa-regular fa-circle-user"></i>회원들의 리뷰</span><i class="fa-solid fa-rotate"></i>
                    <a><i class="fa-solid fa-rotate-right"></i></a>

                    <div class="review-content">
                    <c:forEach var="v" items="${result.reviewList}" varStatus="vs">
                        <div style="overflow: hidden;">
                            <div class="r-user">
                                <img src="${contextPath}${v.memImg}" class="userimg2">
                                <span>${v.memNick}</span>
                            </div>
                            <span class="reviewTitle">${v.movieTitle}</span>
                            <div>${v.reviewScore}</div>
                            <span class="reviewContent">${v.reviewContent}</span>

                        </div>
                    </c:forEach>
                    </div>

                </div>

               <div class="favorite">
                    <span class="f-title"><i class="fa-regular fa-star"></i>인생영화관</span>
                    <div>
                    <a class="f-rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    <h4 style="color: white ; ">누누님의 인생영화</h4>
                    <div class="f-mlist1">
                   	<c:forEach var="v" items="${result.lifeList1}" varStatus="vs">
                        <div><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}" alt="${v.movieTitle}" width="130px"></a></div>
                    </c:forEach>
                    </div>
                    <h4 style="color: white;">나나님의 인생영화</h4>
                    <div class="f-mlist2">
                    <c:forEach var="v" items="${result.lifeList2}" varStatus="vs">
                        <div><a href="${contextPath}/movieInfo?movieNo=${v.movieNo}"><img src="${contextPath}${v.moviePoster}" alt="${v.movieTitle}" width="130px"></a></div>
                    </c:forEach>
                    </div>
                    </div>
                </div>
            </div>

            <!-- 시뮬,인기검색어 -->
            <div class="side">
                <div class="side-1">
            
                    <div class="game">
                        <a href="${contextPath}/simulation/simulEnter"><img src="resources/images/추천영화테스트.png" width="200px"></a>
                    </div>
                    <div><a class="btn" name="top"><i class="fa-solid fa-up-long"></i>top</a></div>
                </div>

                <div>
                    
                </div>

            </div>

            
        </section>

        
    </main>
    <footer>
        <p><a href="#">이용약관</a></p>
        <p><a href="#">개인정보처리방침</a></p>
        <p><a href="#">고객센터</a></p>
        <p><a href="#">(주)KH</a></p>
    </footer>

    <script src="resources/js/semi-main.js"></script>

  
</body>
</html>