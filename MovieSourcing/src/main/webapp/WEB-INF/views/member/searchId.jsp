<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${contextPath}/resources/css/member/searchId.css">

    <script src="https://code.jquery.com/jquery-3.6.0.js" 

    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 

    crossorigin="anonymous"></script>



    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>

    

    <title>아이디찾기</title>



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

                    <section class="idSearch">

                        <span class="top">아이디 찾기</span>



                    </section>

                    <section class="infomationbox">

                        <div class="infomation">

                            <div class="emailwrap">

                                <span>가입시 입력한 이메일 주소</span>

                                <div class="email">

                                    <input type="text" id="email" name="email" placeholder="이메일 주소를 입력해주세요">

                                </div>

                            </div>

                            

                        </div>

                    </section>

                   

                    <!-- 이메일로 아이디 발송 + 홈화면으로 이동 -->

                    <section class="savebox">

                        <button  id= "cNumberBtn"><span>찾기</span></button>

                    </section>

                </main>

            </div>

        </div>



    </div>

         <script src="${contextPath}/resources/js/member/signUp4.js"></script>

</body>

</html>