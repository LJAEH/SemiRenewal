const input_img_btn = document.getElementById('input_img_btn');

const input = document.getElementById('input_img');

input_img_btn.addEventListener('click', function () {
    input.click();
});


const input_div = document.getElementById('input_div');

// input 요소에 change 이벤트 핸들러 등록
input.addEventListener('change', () => {
// 선택한 파일 가져오기
const file = input.files[0];

// FileReader 객체 생성
const reader = new FileReader();

// 파일 로드 이벤트 핸들러 등록
reader.addEventListener('load', () => {
    // 이미지 요소 생성
    const image = new Image();
    image.src = reader.result;

    // 이미지 파일 추가
    input_div.appendChild(image);
});

// 파일을 Data URL로 읽기
reader.readAsDataURL(file);
});


/* 안내문구 */


/* -------------------------------------- */
/* div에 작성된 내용 보내기 */

const form = document.getElementById("communityUpdateForm");

form.addEventListener("submit", () => {
	const input_div_content = input_div.innerHTML;
	const input_bar_hidden = document.createElement("input");
	
	input_bar_hidden.setAttribute("type", "hidden");
	input_bar_hidden.setAttribute("name", "comContent");
	input_bar_hidden.setAttribute("value", input_div_content);
	form.appendChild(input_bar_hidden);
	
});


// 게시글 작성 유효성 검사
function writeValidate(){
    const input_title = document.getElementById("input_title");
    const input_div = document.getElementById("input_div");

    if(input_title.value.trim().length == 0){
        alert("제목을 입력해주세요!!!");
        input_title.value = "";
        input_title.focus();
        return false;
    }

    if(input_div.innerText.trim().length == 0){
        alert("내용을 입력해주세요!!!");
        input_div.value = "";
        input_div.focus();
        return false;
    }

    return true;
}


















