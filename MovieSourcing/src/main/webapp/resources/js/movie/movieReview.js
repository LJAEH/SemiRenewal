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