<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/memberDelete.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>회원탈퇴</title>
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
                    <section class="delete">
                        <span class="top">회원 탈퇴</span>

                    </section>
                    <section class="infomationbox">
                        <div class="info">
                            <div class="infobox">
                                <span class="bold">회원 탈퇴 안내</span>
                                <span class="infocontents"> 
                                    
                                <br><br>
                                회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.
                                <br><br>
                                사용하고 계신 아이디는 탈퇴할 경우 재사용 및 복구가 불가능합니다.
                                탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가하오니 신중하게 선택하시기 바랍니다.
                                <br><br>
                                탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.
                                회원정보 및 메일, 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.
                                삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.
                                <br><br>
                                탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다.
                                리뷰, 커뮤니티 등에 올린 게시글 및 댓글은 탈퇴 시 자동 삭제되지 않고 그대로 남아 있습니다.
                                삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 삭제하시기 바랍니다.
                                탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.
                                <br><br>
                                탈퇴 후에는 해당 아이디로 다시 가입할 수 없으며 아이디와 데이터는 복구할 수 없습니다.
                                게시판형 서비스에 남아 있는 게시글은 탈퇴 후 삭제할 수 없습니다.
                                </span>
                                <br><br><br>
           <!-- 폼 임의추가  -->
                       <form action="${contextPath}/member/secession" method="POST" name="myPage-form" onsubmit="return secessionValidate()" >
                                <input type="checkbox" id="deleteid"> <span class="deco">안내 사항을 모두 확인하였으며, 이에 동의합니다.</span>
                                <br><br>
                            </div>
                        </div>
                    </section>
                   
                    <section class="passwordbox">
                        <div>
                        <!-- 인풋 아이디 네임  임의추가  -->
                            <input type="password" name="memberPw" id="memberPw" class="currentPw" placeholder="비밀번호 확인">
                        </div>
                    </section>
                    <hr class="line" color="gray">
                    <section class="savebox">
                        <button><span>회원탈퇴</span></button>
                          </form>
                    </section>
                </main>
            </div>
        </div>

    </div>
    <script src="${contextPath}/resources/js/member/myPage.js"></script>
</body>
</html>