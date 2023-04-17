console.log("boardDetail js loaded")

const dotImg = document.getElementById("communityDotImg");
const popup_menu = document.getElementById("popup_menu");

dotImg.addEventListener("click", () => {

    if(popup_menu.style.display === 'flex'){
        popup_menu.style.display='none';
    } else{
        popup_menu.style.display='flex';
    }
});


/* ------------------------- */
/* 댓글 */
/*
const replyInput = document.getElementById("replyInput");

function resize(obj){
    obj.style.height = "1px";
    obj.style.height = (1+obj.scrollHeight)+"px";
    
    if(obj.style.height > "70px"){
       obj.style.height = "70px";
       obj.style.overflow = "visible";
    }
}*/

// 댓글 등록 AJAX

function replysubmit(){
	
	if(loginCheck !=  1){
		window.alert("로그인을 해주세요");
		location.href = "/MovieSourcing/member/login";
	} else{
	    $.ajax({
	        url : "reply",
	        data : {"comNo" : comNo,
	        		"content" : $("#replyInput").val(),
	        		"loginMemNo" : loginMemNo,
	        		"loginMemNic" : loginMemNic,
	        		"mode" : "mode"
	        		},
	        type : "GET",
	        dataType : "JSON",
	        success : function(result){
				 document.location.reload();
			}
	    })
	    
	    window.location.reload();
	}
    
};

var replyDotImgIs = document.querySelectorAll("#replyDotImgI");
const replyDotImg = document.querySelectorAll("#replyDotImg");
const replyPopup_menus = document.querySelectorAll("#replyPopup_menu");

for (var i = 0; i < replyDotImgIs.length; i++) {
  replyDotImgIs[i].addEventListener('click', function() {
    var index = Array.prototype.indexOf.call(replyDotImgIs, this);
	
	replyDotImg[index].click();
	
	replyDotImg[index].addEventListener("click", function(){
		if(replyPopup_menus[index].style.display == "none"){
			replyPopup_menus[index].style.display = "flex";
		} else{
			replyPopup_menus[index].style.display = "none";
		}
		
	})
	
  });
}









