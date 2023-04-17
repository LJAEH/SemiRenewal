<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="detail" value="${boardDetail}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 글쓰기</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/board/boardWirte.css">
    <script src="https://kit.fontawesome.com/a7b48fa03b.js" crossorigin="anonymous"></script>

</head>
<body>
    <section class="main">

        <div class="head_area">

            <button id="back_btn">
                <i class="fa-solid fa-angle-left" onclick="history.back();"></i>
            </button>

            <h3>글쓰기</h3>
            
            <button id="save_btn" form="communityUpdateForm" type="submit">저장</button>

        </div>
   
        <form action="write" id="communityUpdateForm" method="POST" onsubmit="return writeValidate()">
            <div id="content">
                
                <input type="text" placeholder="제목을 입력해주세요" id="input_title" name="comTitle" value="${detail.comTitle}" autocomplete="off">

                <div contenteditable="true" id="input_div" name="comContent" spellcheck="false"
                placeholder="내용을 입력해주세요">
                    ${detail.comContent}
                </div>
                
                <input type="file" id="input_img">
                <div>
                    <button id="input_img_btn" contenteditable="false" type="button">
                        <i class="fa-regular fa-image"></i>
                    </button>
                </div>

            </div>
            <input name="comNo" style="display:none;" value="${detail.comNo}">
            <input name="mode" style="display:none;" value="${mode}">
            <input name="memNo" style="display:none;" value="${loginMember.memberNo}">
        </form>
    </section>  

    <script src="${contextPath}/resources/js/board/boardWirte.js"></script>

</body>
</html>

