console.log("movieInfo js 들어옴");

if(loginCheck == 1){
	console.log("로그인 됨");
	const memNo = document.getElementById("memNo");
	const movieNo = document.getElementById("movieNo");
} else{
	console.log("로그인 안됨");
}



const toggle1 = document.getElementById("toggle1")
const wannaheart = document.getElementById("wannaheart");
const lifeMovie = document.getElementById("lifeMovie");
const watchedText = document.getElementById("watchedText");
const reviewWrite = document.getElementById("reviewWrite");

const scorebar = document.getElementById("score");
const movieScore = document.getElementById("scoreComment");

(function() {
	if(loginCheck == 1){
		$.ajax({
			url : "movieInfoLoginCheck",
			data : {
				"memNo" : memNo.value,
				"movieNo" : movieNo.value
			},
			type : "GET",
			dataType : "JSON",
			success : function(movieInfoCheck){
				
				if(movieInfoCheck.watchedMovie == "true"){
					toggle1.checked = true;
					watchedText.innerText = "본 영화에요";
	        		watchedText.style.color = "springgreen";
				}
				
				if(movieInfoCheck.wannaMovie == "true"){
					wannaheart.style.color = "pink";
				}
				
				if(movieInfoCheck.lifeMovie == "true"){
					lifeMovie.style.backgroundColor = "red";
				}
				
			},
			error : function(){
				console.log("에러발생");	
			}
		})
	}

	let movieScoreNumber = Number(movieScore.innerText);

	
	if(movieScoreNumber <= 3){
		scorebar.style.backgroundColor = "#ff9090";
		if(movieScoreNumber < 2) scorebar.style.width = "10%";
		else if(movieScoreNumber < 3) scorebar.style.width = "20%";
		else scorebar.style.width = "30%";
		
	} else if(movieScoreNumber <= 6){
		scorebar.style.backgroundColor = "#ffff00";
		if(movieScoreNumber < 5) scorebar.style.width = "40%";
		else if(movieScoreNumber < 6) scorebar.style.width = "50%";
		else scorebar.style.width = "60%";
		
	} else{
		scorebar.style.backgroundColor = "#adff2f";
		if(movieScoreNumber < 8) scorebar.style.width = "70%";
		else if(movieScoreNumber < 9) scorebar.style.width = "80%";
		else if(movieScoreNumber < 10) scorebar.style.width = "90%";
		else scorebar.style.width = "100%";
	}

})();



document.getElementById("toggle1").addEventListener("click", function(){
        document.getElementById("submit1").click()
});

function submit_1(loginMemberNo, movieNo){
	
	if(!loginMemberNo){
		
		window.alert("로그인을 해주세요");
		toggle1.checked = false;
		location.href = "/MovieSourcing/member/login";
		
		return false;
	} else{
		
		if(toggle1.checked == true) {
	        watchedText.innerText = "본 영화에요";
	        watchedText.style.color = "springgreen";
	        
	        const mode = "insert";
	        
			$.ajax({
				 url : "watchedMovie",
				 data : {"memNo" : loginMemberNo,
				 		"movieNo" : movieNo,
				 		"mode" : mode
				 },
				 type : "GET",
				 dataType : "JSON"
			 });
			 
	         return false;
	    } else{
	        watchedText.innerText = "못 본 영화에요";
	        watchedText.style.color = "rgb(214, 211, 206)";
	        
	        const mode = "delete";
			$.ajax({
				 url : "watchedMovie",
				 data : {"memNo" : loginMemberNo,
				 		"movieNo" : movieNo,
				 		"mode" : mode
				 },
				 type : "GET",
				 dataType : "JSON"
			 });
			
			 return false;
		}
		
	}
	return false;
}


wannaheart.addEventListener("click", function(){
	document.getElementById("submit2").click()
})

function submit_2(loginMemberNo, movieNo){
	if(!loginMemberNo){
		window.alert("로그인을 해주세요");
		location.href = "/MovieSourcing/member/login";
		
		return false;
	} else{
		if(wannaheart.style.color == "white"){
			wannaheart.style.color = "pink";
			const mode = "insert";
			
			$.ajax({
				url : "wannaMovie",
				data : {"memNo" : loginMemberNo,
						"movieNo" : movieNo,
						"mode" : mode
				},
				type : "GET",
				dataType : "JSON"
			});
			
		} else{
			wannaheart.style.color = "white";
			
			const mode = "delete";
			
			$.ajax({
				url : "wannaMovie",
				data : {"memNo" : loginMemberNo,
						"movieNo" : movieNo,
						"mode" : mode
				},
				type : "GET",
				dataType : "JSON"
			});
			
			
			
		}
		return false;
	}
}


lifeMovie.addEventListener("click", function(){
	if(loginCheck != 1){	
		window.alert("로그인을 해주세요");
		location.href = "/MovieSourcing/member/login";
	} else{
		if(lifeMovie.style.backgroundColor == "rgb(41, 128, 185)"){
			lifeMovie.style.backgroundColor = "red";
			const mode = "insert";
			
			$.ajax({
				url : "lifeMovie",
				data : {"memNo" : memNo.value,
						"movieNo" : movieNo.value,
						"mode" : mode
				},
				type : "GET",
				dataType : "JSON"
			});
			
			
		} else {
			lifeMovie.style.backgroundColor = "rgb(41, 128, 185)";
			const mode ="delete";
				
			$.ajax({
				url : "lifeMovie",
				data : {"memNo" : memNo.value,
						"movieNo" : movieNo.value,
						"mode" : mode
				},
				type : "GET",
				dataType : "JSON"
			});
			
		}
 	}
})

// 모달창 변수 선언

const reviewOverlay = document.getElementById("reviewOverlay");
const reviewWriteBox = document.getElementById("reviewWriteBox");
const nav = document.getElementsByClassName("nav");

reviewWrite.addEventListener("click", function(){
	if(loginCheck != 1){
		window.alert("로그인을 해주세요");
		location.href = "/MovieSourcing/member/login";
	} else{
		reviewOverlay.style.display = "flex";
	    reviewOverlay.style.position = "fixed";
	}
})


if(!movieReview){
	console.log("비어있음")
} else{
	
	const userScore = document.getElementsByClassName("userScore");
	const scoreLight = document.getElementsByClassName("scoreLight");
	
	for(let i = 0; i < userScore.length; i++){

	var userScoreText = userScore[i].innerText;
	var scoreNumber = Number(userScoreText);
		
		if (scoreNumber >= 4.0){
		    scoreLight[i].style.backgroundColor = "springgreen";
		} else if (scoreNumber >= 3.0 && scoreNumber < 4.0) {
		    scoreLight[i].style.backgroundColor = "yellow";
		} else if ( scoreNumber >= 2.0 && scoreNumber < 3.0 ) {
		    scoreLight[i].style.backgroundColor = "white";
		} else if (scoreNumber < 2.0) {
		    scoreLight[i].style.backgroundColor = "red";
		}
	}
}

if(movieReview){
	
	const reviewDotImgWrapper = document.getElementsByClassName("reviewDotImgWrapper");
	const reviewDotImgs = document.querySelectorAll("#reviewDotImg");
	const popup_menus = document.querySelectorAll("#popup_menu");
	
	if(reviewDotImgWrapper.length == 1){
		reviewDotImgs[0].addEventListener("click", function(){
			
			if(popup_menus[0].style.display == "none"){
				popup_menus[0].style.display = "block";
			}else{
				popup_menus[0].style.display = "none";
			}
			
	})
		
		
		
	} else if(reviewDotImgWrapper.length == 2){
		reviewDotImgs[0].addEventListener("click", function(){
			
			if(popup_menus[0].style.display == "none"){
				if(popup_menus[1].style.display == "block"){
					popup_menus[1].style.display = "none";
				}
				popup_menus[0].style.display = "block";
			} else{
				popup_menus[0].style.display = "none";
			}
		})
		
		reviewDotImgs[1].addEventListener("click", function(){
			if(popup_menus[1].style.display == "none"){
				if(popup_menus[0].style.display == "block"){
					popup_menus[0].style.display = "none";
				}
				popup_menus[1].style.display = "block";
			} else{
				popup_menus[1].style.display = "none";
			}
		})
		
		
		
	} else{
		reviewDotImgs[0].addEventListener("click", function(){
			if(popup_menus[0].style.display == "none"){
				if(popup_menus[1].style.display == "block" || popup_menus[2].style.display == "block"){
					popup_menus[1].style.display = "none";
					popup_menus[2].style.display = "none";
				}
				popup_menus[0].style.display = "block";
				
			} else{
				popup_menus[0].style.display = "none";
			}
			
			
		})
		
		reviewDotImgs[1].addEventListener("click", function(){

			if(popup_menus[1].style.display == "none"){
				if(popup_menus[0].style.display == "block" || popup_menus[2].style.display == "block"){
					popup_menus[0].style.display = "none";
					popup_menus[2].style.display = "none";
				}
				popup_menus[1].style.display = "block";
			} else{
				popup_menus[1].style.display = "none";
			}
		})
		
		reviewDotImgs[2].addEventListener("click", function(){

			if(popup_menus[2].style.display == "none"){
				if(popup_menus[1].style.display == "block" || popup_menus[0].style.display == "block"){
					popup_menus[1].style.display = "none";
					popup_menus[0].style.display = "none";
				}
				popup_menus[2].style.display = "block";
			} else{
				popup_menus[2].style.display = "none";
			}
		})
		
	}
	
	
}



// 리뷰모달 작성글 숫자

$("#reviewArea").on("input",function(){
	
    
 	$("#reviewArea").on("input",function(){
		const cnt = $("#reviewArea").val().length;
		
		if(cnt >= 101){
			const str = $(this).val();

			$(this).val(str.substr(0, 100));
		}
		 
		$("#reviewCounter").text(cnt);

	 })
});

$("#reviewSubmit").on("click", function(){
	$.ajax({
		url : "movieReview",
		data :{
			"movieNo" : movieNo.value,
			"memNo" : memNo.value,
			"reviewContent" : $("#reviewArea").val(),
			"reviewScore" : $("#starScore").val(),
			"mode" : "insert"
		},
		type : "POST",
		dataType : "JSON",
		success : function(returnStr){
			
			if(returnStr){
				reviewOverlay.style.display = "none ";
				document.location.href = document.location.href;
			} else{
				alert("리뷰 작성 실패");
			}
			
		}, 
		error : function(){
			console.log("에이젝스 실패");
		}
	})
})




// 별점 모달
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
    console.log(target.value*0.5);
}


// 모달 오버레이 클릭시

reviewOverlay.addEventListener("click", e => {
    const evTarget = e.target;
        if(evTarget.classList.contains("reviewOverlay")){
            reviewOverlay.style.display = "none ";
        }

})

function reviewDelete(movieNo, reviewerMemNo){
	console.log("movieNo::::" + movieNo);
	console.log("reviewerMemNo:::" + reviewerMemNo);
	$.ajax({
		url:"movieReview" ,
		data:{
			"movieNo":movieNo,
			"reviewerMemNo":reviewerMemNo,
			"mode" : "delete"
		},
		type :"GET",
		dataType : "JSON"
	})
	
	 window.location.reload();
}


//---------------------------------------------------------------






























