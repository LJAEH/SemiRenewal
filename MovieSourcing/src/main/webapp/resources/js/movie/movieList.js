const scoreCircle = document.getElementsByClassName("fa-solid fa-circle");
const movieScore = document.getElementsByClassName("movieScore");


(function(){
	for(let i = 0; i < movieScore.length; i++){
		
		console.log("test");
		
		let userScore = movieScore[i].innerText;
		var score = Number(userScore);
		
		if(score < 3.5){
			scoreCircle[i].style.color = "red";
		    movieScore[i].style.color = "red";	
		} else if(3.5 <= score && score < 5.5){
			scoreCircle[i].style.color = "white";
		    movieScore[i].style.color = "white";
		} else if(5.5 <= score && score < 7.5){
			scoreCircle[i].style.color = "yellow";
		    movieScore[i].style.color = "yellow";
		} else{
			scoreCircle[i].style.color = "springgreen";
		    movieScore[i].style.color = "springgreen";
		}
		
	}
})();
