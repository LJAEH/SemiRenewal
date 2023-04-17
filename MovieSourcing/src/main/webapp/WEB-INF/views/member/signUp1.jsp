<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/signUp1.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>

	 <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>

    <title>회원가입(1)</title>
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
                    <section class="signup">
                        <span class="top">회원 가입</span>

                    </section>
                    <section class="infomationbox">
                        <div class="info">
                         <form action="${contextPath}/member/signUp2" onsubmit="return nextMove()">
                            <div class="infobox">
                                <span class="info1">약관동의</span>
                                <div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="info2">가입을 위해 다음 정책에 대한 동의가 필요합니다.</span>
                                </div>
                                
                                <div>
                                    <input type="checkbox" id="checkAll"> <span class="info3">모두 동의합니다.</span>
                                </div>
                                <hr>
                                <div>
                                    <input type="checkbox" id="check1"> <span class="info3">[필수] 이용약관에 동의합니다.</span>
                                </div>
                         
                                <div>
                                    <input type="checkbox" id="check2"> <span class="info3">[필수] 개인정보 수집 및 이용에 동의합니다.</span>
                                </div>
                         
                                <div>
                                    <input type="checkbox" id="check3"> <span class="info3">[필수] 본인은 만 14세 이상입니다.</span>
                                </div>
                          
                                <div>
                                    <input type="checkbox" id="check4"> <span class="info3">[선택] 시사회 및 이벤트 등 알림 수신에 동의합니다.</span>
                                </div>
                            </div>
                        </div>
                    </section>
                   
                    <section class="nextbox">
                        <button id="nextBtn">다음</button>
                    </section>
                     </form>
                </main>
            </div>
        </div>

    </div>
      <script src="${contextPath}/resources/js/member/signUp1.js"></script>
</body>
</html>