<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name ="google-signin-client_id" 
    content="935814438564-8ocf3d4e2vsp790u21l0vctt9qahq9bj.apps.googleusercontent.com">
    <link rel="stylesheet" href="../resources/css/member/login.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" 
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
    crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>로그인</title>

</head>
<body>
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header>
                    <div>
                        <a href="javascript:window.history.back();"  class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <section class="logintop">
                        <span class="top">로그인</span>

                    </section>
                    <section class="loginbox">
                        <div class="login">
                            <div class="loginwrap">
                                <form action="login" method="POST" name="login-form" onsubmit="return loginValidate()">
                                 <fieldset id="id-pw-area">
                                        <span>아이디</span>
                                        <div class="id">
                                            <input type="text" id="id"   name="id" placeholder="아이디를 입력해주세요" value="${cookie.keepLogin.value}">
                                        </div>
                                        <span>비밀번호</span>
                                        <div class="password">
                                            <input type="password" id="password"  name="password" placeholder="비밀번호를 입력해주세요">
                                        </div>
                                        <div class="keepLogin">
                                            <input type="checkbox" name="keepLogin">
                                            <label for="keepLogin"><span>로그인 상태 유지</span></label>
                                        </div>
                                        <button id="nomalLogin">
                                            <span>로그인</span>
                                        </button>
                                    </fieldset>
                                </form>
                               
                            </div>

                            <div class="btnwrap">
                                
                                <div id="kakaoLoginBtn">
                                    <div>
                                        <i class="fa-solid fa-comment" id="kakaoImg"></i>
                                    </div>
                                    <div><span>카카오 로그인</span></div>
                                    <div></div>
                                </div>
                                <div id="googleLogin">
                                    <div >
                                        <div class="googleBox">
                                            <i class="fa-brands fa-google-plus-g" id="googleImg"></i>
                                        </div>
                                    </div>
                                    <div><span>구글 로그인</span></div>
                                    <div></div>
                                </div>
                                <div class="enderMenu">
                                    <div>
                                        <a href="${contextPath}/member/signUp1"><span>회원가입</span></a>
                                    </div>
                                    <div>
                                        <a href="searchId"><span>아이디</span></a>
                                        <span> |</span>
                                        <a href="#"><span>비밀번호찾기</span></a>
                                    </div>
                                </div>

                            </div>
                            
                        </div>
                    </section>
                    <section class="under">

                    </section>
                   
                </main>
            </div>
        </div>

    </div>

    <script src="../resources/js/member/login.js"></script>
    
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    
    <script>

   	Kakao.init('f72ad10408e611f4a24827bd881110dc');
   	console.log(Kakao.isInitialized());
   	
   	let email = null;
   	
   	//카카오로그인
   	document.getElementById("kakaoLoginBtn")
   	.addEventListener("click",function kakaoLogin() {
   		
   	    Kakao.Auth.login({
   	    	
   	    success: function (response) {
   	        Kakao.API.request({
   	        url: '/v2/user/me',
   	        success: function (response) {
   	            console.log(response.kakao_account.email);
   	        	 
   	            email = response.kakao_account.email;
   	            
   	            console.log(email);
   	            

   	        },
   	        fail: function (error) {
   	            console.log(error)
   	        },
   	        })
   	    },
   	    fail: function (error) {
   	        console.log(error)
   	    },
   	    })
   	    
   	})
   	

   	$.ajax({
         url : "kakaoLogin",
         data : { "email" : email },
         type : "GET",
         success : function(loginMember) {
             if(loginMember != null) {
                 alert("로그인 성공");
               
             } else {
                 alert("등록된 회원 정보가 없습니다.");
                    
             }},
         error : function(){
             console.log("안됨");
         } 
     })  

   
   	

   	
   	document.getElementById("logout")
   	.addEventListener("click", function kakaoLogout() {
   	    if (Kakao.Auth.getAccessToken()) {
   	    Kakao.API.request({
   	        url: '/v1/user/unlink',
   	        success: function (response) {
   	            console.log(response)
   	        },
   	        fail: function (error) {
   	        console.log(error)
   	        },
   	    })
   	    Kakao.Auth.setAccessToken(undefined)
   	    alert("로그아웃댐")
   	    }
   	}  )

   	document.getElementById("kakaoLoginBtn")
   	.addEventListener("click",function kakaoLogin() {
   	    if (Kakao.Auth.getAccessToken()){
   	        alert("이미 로그인된 아이디입니다.")
   	    }
   	})
   	
   	
   	
   	
	      
    </script>
   	
    
    
</body>
</html>