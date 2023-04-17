var scoreLights = document.querySelectorAll(".scoreLight");

scoreLights.forEach(function(scoreLight) {
  var reviewScore = parseInt(scoreLight.nextElementSibling.
  querySelector("#userScore").textContent);

	if (reviewScore >= 4.0){
	    scoreLight.style.backgroundColor = "springgreen";
	} else if (reviewScore >= 3.0 && reviewScore < 4.0) {
	    scoreLight.style.backgroundColor = "yellow";
	} else if ( reviewScore >= 2.0 && reviewScore < 3.0 ) {
	    scoreLight.style.backgroundColor = "white";
	} else if (reviewScore < 2.0) {
	    scoreLight.style.backgroundColor = "red";
	}
});

const rDate = document.getElementById("date");
const reviewDate = new date(rDate);