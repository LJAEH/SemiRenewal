
// 유효성 검사 여부를 기록할 객체 생성
const checkObj = { 
    "memberId"     : false,
    "memberPw"        : false,
    "memberNickname"  : false,

};



//아이디 닉네임 중복체크 
const id = document.getElementById("id");

document.getElementById("iddupcheck")
.addEventListener("click",function(){
    const regEx = /^[a-zA-Z0-9]{5,12}$/;
    if(regEx.test(id.value)){
        $.ajax ({
            // 경로 지정 체크 
            url : "idDupCheck",
            data : {"memberId" : id.value},
            type : "GET",
            // result => servlet에서 출력된 result값
            success : function(idResult){
                if(idResult == 1){ // 중복일 경우
                    alert("이미 사용 중인 아이디입니다.");
                    checkObj.memberId = false;
                } else {
                    checkObj.memberId = true;
                }
            },
            error : function(){
                cosole.log("뭐임?");
            }
        })
        alert("사용가능한 아이디입니다.");
    } else {
        alert("형식에 맞지않습니다.");
        checkObj.memberId = false;
    }
})

// 닉네임 중복체크
const membeNickname = document.getElementById("membeNickname");

document.getElementById("namedupcheck")
.addEventListener("click",function(){
    const nickRegEx = /^[가-힣a-zA-Z0-9]{2,15}$/;
    if(nickRegEx.test(membeNickname.value)){
        $.ajax({
            url : "nicknameDupcheck",
            data : {"membeNickname" : membeNickname.value},
            type : "GET",
            success : function(nickResult){
                if(nickResult == 1 ){ // 중복
                    alert("닉네임 중복입니다.");
                    checkObj.memberNick = false;
                } else {
                    checkObj.memberNick = true;
                }
            },
            error : function(){
                cosole.log("왜이럼?");
            }

        })
        alert("사용가능한 닉네임입니다.");
    } else {
        checkObj.memberNick = false;
        alert("형식에 맞지않습니다.");
    }
})




// 비밀번호 체크

const pw1 = document.getElementById("pw1");
const regEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[a-zA-Z0-9\d$@$!%*#?&]{8,15}$/;
const pw2 = document.getElementById("pw2");
const pwCheck = document.getElementById("pwCheck");


pw2.addEventListener("keyup",function(){
    if(regEx.test(pw1.value)){
        if(pw2.value == pw1.value){
            pwCheck.innerText = "사용가능한 비밀번호 입니다.";
            pwCheck.style.color = "springgreen";
            pwCheck.style.fontWeight = "bold";
            checkObj.memberPw = true;
        } else {
            pwCheck.innerText = "비밀번호가 일치하지 않습니다.";
            pwCheck.style.color = "tomato";
            pwCheck.style.fontWeight = "bold";
            checkObj.memberPw = false;
        }
    } else {
        pwCheck.innerText = "비밀번호 형식이 맞지 않습니다";
        pwCheck.style.color = "tomato";
        pwCheck.style.fontWeight = "bold";
        checkObj.memberPw = false;
    }  
})


// 출생연도
$(document).ready(function(){            
    var now = new Date();
    // var year = now.getFullYear();
    // var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 

    for(var i = 2023 ; i >= 1920 ; i--) {
        $('#year').append('<option value="' + i + '">' + i + '년</option>');    
    }
    
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="' + mm + '">' + mm + '월</option>');    
    }
})

// 전체 유효성 검사
function signUpValidate() {

    let str;

    for (let key in checkObj) {

        if(!checkObj[key]){
            switch(key){
            case "memberId" : str="아이디가"; break;
            case "memberPw" : str="비밀번호가"; break;
            case "memberNickname" : str="닉네임이"; break;
            }
            str += " 유효하지 않습니다.";

            alert(str);

            document.getElementById(key).focus();

            return false;
        }
    }
    return true;
}

$(document).ready(function() {
    $("form").submit(function() {
        if(!$("input[name='gender']:checked").val()) {
            alert("성별을 선택해주세요.");
            return false;
        }
    });
});
