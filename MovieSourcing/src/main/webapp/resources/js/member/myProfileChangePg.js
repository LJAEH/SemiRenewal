
const newPw1 = document.getElementById("newPw1");
const regEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[a-zA-Z0-9\d$@$!%*#?&]{8,15}$/;
const newPw2 = document.getElementById("newPw2");
const pwCheck = document.getElementById("pwCheck");


const newPwObj = false;

newPw2.addEventListener("keyup",function(){
    if(regEx.test(newPw1.value)){
        if(newPw2.value == newPw1.value){
            pwCheck.innerText = "사용가능";
            pwCheck.style.color = "springgreen";
            pwCheck.style.fontWeight = "bold";

            newPwObj = true;

            console.log(newPwObj);
        } else {
            pwCheck.innerText = "비밀번호가 일치하지 않습니다.";
            pwCheck.style.color = "tomato";
            pwCheck.style.fontWeight = "bold";
            
            newPwObj = false;

            console.log(newPwObj);
        }
    } else {
        pwCheck.innerText = "비밀번호 형식이 맞지 않습니다";
        pwCheck.style.color = "tomato";
        pwCheck.style.fontWeight = "bold";
        
        newPwObj = false;
        
        console.log(newPwObj);
    }  

    
})


$("#nicknameArea").on("input",function(){
    
    $(".nicknameCounter").text($(this).val().length);
})


$("#introduceArea").on("input",function(){
    
    $(".introCounter").text($(this).val().length);
})



// document.getElementById("saveBtn").addEventListener("click",function(){

//     if()

// })



const newPwOverlay = document.getElementById("newPwOverlay");
const changePw = document.getElementById("changeA");
const changeBtn = document.getElementById("changeBtn");

changePw.addEventListener("click", function(){
    newPwOverlay.style.display = "flex"; 
})

changeBtn.addEventListener("click", function(){
    if(newPwObj) {

        newPwOverlay.style.display = "none";
    } else {
        
        alert("형식에 맞지 않습니다")
    }
})

newPwOverlay.addEventListener("click", e =>{
    const evTarget = e.target;
    if(evTarget.classList.contains("newPwOverlay")){
        newPwOverlay.style.display = "none";
    }
})




// 회원 프로필 이미지 변경(미리보기)
const inputImage = document.getElementById("input-image");

if(inputImage != null){ // inputImage 요소가 화면에 존재 할 때
 
    // input type="file" 요소는 파일이 선택 될 때 change 이벤트가 발생한다.
    inputImage.addEventListener("change", function(){
       
        // this : 이벤트가 발생한 요소 (input type="file")

        // files : input type="file"만 사용 가능한 속성으로
        //         선택된 파일 목록(배열)을 반환
        //console.log(this.files)
        //console.log(this.files[0]) // 파일목록에서 첫 번째 파일 객체를 선택

        if(this.files[0] != undefined){ // 파일이 선택되었을 때

            const reader = new FileReader();
            // 자바스크립트의 FileReader
            // - 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0]);
            // FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함.
            // - 읽어오는게 완료되면 result 속성 data:에 
            //   읽어온 파일의 위치를 나타내는 URL이 포함된다.  
            //  -> 해당 URL을 이용해서 브라우저에 이미지를 볼 수 있다.


            // FileReader.onload = function(){}
            // - FileReader가 파일을 다 읽어온 경우 함수를 수행
            reader.onload = function(e){ // 고전 이벤트 모델
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소(객체) -> FileReader
                // e.target.result : FileReader가 읽어온 파일의 URL

                // 프로필 이미지의 src 속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profileimg");

                profileImage.setAttribute("src", e.target.result);
                // -> setAttribute() 호출 시 중복되는 속성이 존재하면 덮어쓰기

                document.getElementById("delete").value = 0;
                // 새로운 이미지가 선택 되었기 때문에 1 -> 0(안눌러짐 상태)으로 변경
            }

        }
    });
}