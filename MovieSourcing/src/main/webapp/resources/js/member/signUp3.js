
// 이메일 유효성 검사
let EmailObj = false;
let  cNumberObj = false;

const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.querySelector("#emailMessage");
const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

memberEmail.addEventListener("input", function(){
    if(memberEmail.value.length == 0 ){
        emailMessage.innerText("");
        return;
    }
    if(regExp.test(memberEmail.value)){
        emailMessage.innerText = "유효한 이메일 주소입니다";
        EmailObj = true;
    } else {
        emailMessage.innerText = "유효하지않은 이메일 주소입니다.";
        EmailObj = false;
    }
});


const cNumberBtn = document.getElementById("cNumberBtn");
const cMessage = document.getElementById("cMessage");

cNumberBtn.addEventListener("click",function(){
EmailObj = true;
    if(EmailObj){

        $.ajax({
            url : "sendEmail",
            data : {"memberEmail" : memberEmail.value},
            type : "GET",
            success : function(emailResult){
                console.log(emailResult);
                 console.log(memberEmail.value);
                cNumberObj = true;
            },
            error : function(){
                console.log("뭐임?")
            }     
        });

        cMessage.innerText = "3:00";
        min = 2;
        sec = 59;

        checkInterval = setInterval(function(){
            if(sec<10) sec = "0" + sec;
            cMessage.innerText = min + ":" + sec;
            if(Number(sec) === 0 ){
                min--;
                sec = 59;
            } else {
                sec--; 
            }

            if(min === -1){
                cMessage.innerText = "인증번호 만료";

                clearInterval(checkInterval);
            }
                
        }, 1000);

        alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.")
    }
});


const cNumber = document.getElementById("cNumber");
const cBtn = document.getElementById("cBtn");

cBtn.addEventListener("click",function(){
    if(cNumberObj){
        if(cNumber.value.length == 6){
            $.ajax({
                url : "cNumber",
                data : {"cNumber" : cNumber.value,"memberEmail" : memberEmail.value},
                type : "GET",
                success : function(cNumberResult){
                    console.log(cNumberResult);

                    // cNumberResult = 1 인증번호 + 시간만족
                    // cNumberResult = 2 인증번호만족 시간 x
                    // cNumberResult = 3 인증번호x 시간만족 X

                    if( cNumberResult == 1 ){
                        clearInterval(checkInterval);

                        cMessage.innerText = "인증되었습니다.";
                    } else if (cNumberResult == 2) {
                        alert("인증번호가 만료되었습니다.");
                    } else {
                        alert("인증번호가 일치하지 않습니다");
                    }
                },
                error : function(){
                    alert("진짜뭐임?");
                }
            })
        } else { // 인증번호 제대로 입력
            alert("인증번호는 6자리입니다");
            cNumber.focus();
        }
    } else {  // 인증번호 안받음
        alert("먼저 인증번호를 받아주세요.");
    }
})