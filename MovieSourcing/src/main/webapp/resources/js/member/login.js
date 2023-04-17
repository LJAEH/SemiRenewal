// id pw 입력확인
function loginValidate(){

    const inputId = document.getElementById("id");

    const inputPw = document.getElementById("password");

    if(inputId.value.trim().length == 0 ){
        alert("이메일을 입력해주세요");
        inputId.value = "";
        inputId.focus();
        return false;
    }

    if(inputPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요");
        inputPw.value = ""
        inputPw.focus();
        return false;
    }

    return true;
}

document.getElementById("keepId").addEventListener("change",function(){

    console.log(this.checked);

    if(this.checked) {
        
    }
})
