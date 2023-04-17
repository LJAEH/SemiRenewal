<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/signUp3.css">
   <script src="https://code.jquery.com/jquery-3.6.0.js" 
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
    crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>네비</title>

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
                <form action="signUp3" method="POST" >
                <main id="contents">
                    <section class="signup">
                        <span class="top">회원 가입</span>

                    </section>
                    <section class="infomationbox">
                        <div class="infomation">
                            <div class="emailwrap">
                                <div class="emailSpan">
                                    <span id="Font">이메일</span> 
                                    <span id="emailMessage"></span>
                                </div>
                                
                                <div class="email">
                                    <input type="text" id="memberEmail"name="memberEmail" placeholder="이메일 주소를 입력해주세요">
                                    <div class="cNumberBox">
                                        <button id="cNumberBtn" type="button" ><span>인증번호받기</span></button>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="certificationwrap">
                                <div>
                                    <span id="Font">인증번호</span>
                                    <span id="cMessage"></span>
                                </div>
                               
                                <div class="certification">
                                    <input type="text" id="cNumber" name="memberEmail"  placeholder="인증번호 숫자 6자리">
                                    <div class="certificationbox">
                                        <button id="cBtn" type="button"><span >번호인증</span></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                   

                    <section class="savebox">
                        <button><span>완료</span></button>
                    </section>
                </main>
                 </form>
            </div>
        </div>

    </div>
    <script src="${contextPath}/resources/js/member/signUp3.js"></script>
</body>
</html>