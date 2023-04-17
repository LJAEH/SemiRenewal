<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/myProfileChangePg.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>

    <title>프로필수정</title>
    
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
                <form action="myPagechangeEnter" method="POST"  enctype="multipart/form-data" >
                <main id="contents">
                    <section class="profilebox">
                        <span class="title">프로필수정</span>
                        <div> 
                         <c:if test="${empty loginMember.memberImg}">
                         
                          <img src="${contextPath}/resources/images/user.png" class="profileImg"  name = "profileimg"  id="profileimg">
                           
                             </c:if>
                          <c:if test="${!empty loginMember.memberImg}">
                     <img  src="${contextPath}/${loginMember.memberImg}" class="profileImg"  name = "profileimg"  id="profileimg">
                             </c:if>    
                        </div>
                     
                        <a href="#"><label for="input-image">사진변경</a></label>
                          <input type="file" name="profileImage" id="input-image" accept="image/*">
                          
                        <span class="email1">가입시 입력한 email 주소</span>
                        <span class="email2">${loginMember.memberEmail}</span>
                    </section>

                    <section class="nicknamebox">
                        <div class="nicknamebar">
                            <span class="leftpadding">닉네임</span>
                            <span id="nicknamebite"><span class="nicknameCounter">0</span>/20</span>
                        </div>
                        <div class="nicknameinsert">
                            <textarea id="nicknameArea" name = "nicknameArea" placeholder="바꿔도됩니다">${loginMember.memberNick}</textarea>
                        </div>
                    </section>

                    <section class="introducebox">
                        <div class="introducebar">
                            <span class="leftpadding">소개글</span>
                            <span id="introducebite"><span class="introCounter">0</span>/100</span>
                        </div>
                        <div class="introduceinsert">
                            <textarea name="introduceArea" name="introduceArea" id="introduceArea" placeholder="아무글이나 적어도 좋습니다.">${loginMember.memberIntro}</textarea>
                        </div>
                    </section>
                    
                    <div id="aDiv">
                        <a href="#" id="changeA" class="aStyle">
                            비밀번호 변경 <i class="fa-solid fa-chevron-right"></i>
                        </a>
                        <a href="${contextPath}/member/secession" id="byeA" class="aStyle">
                            회원탈퇴 <i class="fa-solid fa-chevron-right"></i> 
                        </a>    
                    </div>


                    <hr class="line" color="gray">

                    <section class="savebox">
                        <button id="saveBtn" ><span>저장</span></button>
                    </section>
                </main>
                </form>
            </div>
        </div>

    </div>

    <div id="newPwOverlay" class="newPwOverlay">
        <!-- 비밀번호 수정 -->
        <!-- 현재비밀번호 + 비밀번호 수정확인 -->

        <div class="passwordbox">
            <div id="modalTitle">
                <span>
                    비밀번호 수정
                </span>
                 <form action="pw" method="POST">
            </div>
           
            <div>
                <input type="password" class="currentPw" id="currentPw" name="currentPw" placeholder="현재 비밀번호">
            </div>
            <div>
                <input type="password" class="newPw1" id="newPw1" name="newPw1" placeholder="변경할 비밀번호">
            </div>
            <div class="passwordboxdiv3">
                <input type="password" class="newPw2" id="newPw2" placeholder="변경할 비밀번호 확인">
                <span id="pwCheck"></span>
            </div> 
            <button id="changeBtn" > 
                <span>수 정</span>
             
            </button>
             
        </div>
          </form>
    </div>

    <script src="${contextPath}/resources/js/member/myProfileChangePg.js"></script>
    
</body>
</html>