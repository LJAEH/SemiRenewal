<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/signUp2.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" 
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
    crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>회원가입(2)</title>

</head>
<body>
 <form action="" method="POST" encType="multipart/form-data">
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header class="backpageHeader">
                    <div classs="backpageDiv">
                        <a href="javascript:window.history.back();"  class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <section class="signup">
                        <span class="top">회원 가입</span>

                    </section>
                    <section class="infomationbox">
                        <div class="infomation">
                            <div class="idwrap">
                                <span>아이디</span>
                                <div class="idinput">
                                    <input type="text" id="id" name = "id" placeholder="아이디를 입력해주세요" spellcheck="false">
                                    <div class="dupcheckbox">
                                        <button type = "button" class="dupcheck" id="iddupcheck"><span>중복확인</span></button>
                                    </div>
                                </div>
                            </div>
                            <div class="pwwrap1">
                                <div id="pwword"><span>비밀번호</span> <span id="pwCheck"></span>
                                </div>
                                <div class="pwinput1">
                                    <input type="password" id="pw1" name = "pw1" placeholder="영문/숫자/특수문자 포함 8자리 이상 입력">
                                </div>

                            </div>
                            <div class="pwwrap1">
                                <span>비밀번호확인</span>
                                <div class="pwinput2">
                                    <input type="password" id="pw2" placeholder="영문/숫자/특수문자 포함 8자리 이상 입력">
                                </div>
                            </div>
                            <div class="nicknamewrap">
                                <span>닉네임</span>
                                <div class="nicknameinput">
                                    <input type="text" id="membeNickname" name = "membeNickname" placeholder="한글 영어 숫자로 12자이내로 정해주세요" spellcheck="false">
                                    <div class="dupcheckbox">
                                        <button type = "button" class="dupcheck" id="namedupcheck"><span>중복확인</span></button>
                                    </div>
                                </div>
                            </div>
                            <div class="genderbox">
                                <span>성별</span>
                                <div>
                                    <label for="M"><span>남성</span></label> <input type="radio" name="gender" id="man" value="M" onclick="fnRadioName();">
                                    <label for="F"><span>여성</span></label> <input type="radio" name="gender" id="woman"  value="F" onclick="fnRadioName();">
                                </div>
                                <div>
                                    <input type="file" name = "memberImg">
                                </div>

                            </div>
                            <div class="birthwrap">
                                <span>출생연도</span>
                                <div class="birthbox" autocomplete="off" required>
                                    <div>                        
                                        <select name="yy" id="year" class="yearbox"></select>
                                        <select name="mm" id="month" class="monthbox"></select>
                                    </div>        
                                </div>
                            </div>
                        </div>
                    </section>
                   
                    <section class="savebox">
                        <button><span>다음</span></button>
                    </section>
                </main>
            </div>
        </div>

    </div>
    <script src="${contextPath}/resources/js/member/signUp2.js"></script>
</form>
</body>
</html>