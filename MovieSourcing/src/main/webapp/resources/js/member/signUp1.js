console.log("signUp1js 들어옴");

const check1 = document.getElementById("check1");
const check2 = document.getElementById("check2");
const check3 = document.getElementById("check3");
const check4 = document.getElementById("check4");

const signCheckList = {
    "check1a" : false,
    "check2a" : false,
    "check3a" : false,
    "check4a" : false,
}


$(document).ready(function(){
    $("#checkAll").click(function(){
        if($("#checkAll").is(":checked"))$("input[name=signCheck]").prop("checked",true);
        else $("input[name=signCheck]").prop("checked",false);
    });

    $("input[name=signCheck]").click(function(){
        var total = $("input[name=signCheck]").length;
        var checked =$("input[name=signCheck]:checked").length;

        if(total != checked) $("#checkAll").prop("checked",false);
        else $("#checkAll").prop("checked", true);
    })
})

if(check1.checked){
    signCheckList.check1a = true; 
} else {
    signCheckList.check1a = false;
}


if(check2.checked){
    signCheckList.check2a = true; 
} else {
    signCheckList.check2a = false;
}

if(check3.checked){
    signCheckList.check3a = true; 
} else {
    signCheckList.check3a = false;
}

if(check4.checked){
    signCheckList.check4a = true; 
} else {
    signCheckList.check4a = false;
}


function nextMove(){
	 if($("#checkAll").is(":checked")){
        alert("페이지이동");
        return true;
    } else {
        alert("이용약관을 동의해주세요.");
        
        return false;
    }
}
/*
const nextBtn = document.getElementById("nextBtn");

nextBtn.addEventListener("click", function(){
    if($("#checkAll").is(":checked")){
        alert("페이지이동");
    } else {
        alert("이용약관을 동의해주세요.");
    }
}) 
*/