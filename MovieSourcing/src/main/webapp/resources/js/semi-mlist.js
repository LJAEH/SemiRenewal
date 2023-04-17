console.log("js 들어옴")


const janr = document.querySelectorAll('.btn');

janr.forEach((btn)=>{
// 클릭시 버튼색상이 변하는 효과 주는것 css에 있는 효과를 불러오는것

	btn.addEventListener('click', (e)=>{
	
		if(btn.classList.contains('active')) {
			btn.classList.remove('active');
			window.location.reload();
		
		}else {
			for(let i=0; i<janr.length; i++) {
				janr[i].classList.remove('active');
			}
			e.target.classList.add('active');
			clickjanr();
			clickgrade();
			clicknation();
		}
	})
});


//홈 버튼 클릭시 홈 으로 화면 이동

const homebutton = document.getElementById("homebutton");


homebutton.addEventListener("click", function() {

window.open("semi-main.html", "_self");


});




//top 버튼 클릭시 위로 이동


$('.elw').click(function() {

window.scrollTo({top : 0, behavior: 'smooth'});

});



//search box 초기화

var searchtext = document.querySelector('.search-txt');


searchtext.addEventListener('blur', function() {


searchtext.value= "";

});



//검색필터 (진행중)






function clickjanr(input1) {

console.log(input1.value)

const current = document.getElementById('contents');

$.ajax({


url : "Searchjanr",

data : {"input1" : input1.value},

type : "GET",

datatype : "JSON",

success : function(mlist) {

let str = JSON.parse(mlist);

console.log(str);

let res = "";

for(let i=0; i<str.length; i++) {

res += "<div><a href='movieInfo' id='contents'><img src = '/MovieSourcing"+
str[i].moviePoster+"' width='130px'><br><h3>"+str[i].movieTitle+
"</h3></a><br><p>"+str[i].national+"/"+str[i].movieGrade+"</p></div>";

}

$('.mlist2').html(res);

},

error: function(request, status, error) {

console.log("ajax 에러발생");

console.log("상태코드 : " + request.status); // 404, 500

}


})

};


function clicknation(input2) {

console.log(input2.value);

$.ajax({


url : "Searchnation",

data : {"input2" : input2.value},

type : "GET",

datatype : "JSON",

success : function(mlist) {

let str = JSON.parse(mlist);

console.log(str);

let res = "";

for(let i=0; i<str.length; i++) {

res += "<div><a href='movieInfo' id='contents'><img src = '/MovieSourcing"+
str[i].moviePoster+"' width='130px'><br><h3>"+str[i].movieTitle+
"</h3></a><br><p>"+str[i].national+"/"+str[i].movieGrade+"</p></div>";

}

$('.mlist2').html(res);

},

error: function(request, status, error) {

console.log("ajax 에러발생");

console.log("상태코드 : " + request.status); // 404, 500

}


})


}


function clickgrade(input3) {

console.log(input3.value);

$.ajax({


url : "Searchgrade",

data : {"input3" : input3.value},

type : "GET",

datatype : "JSON",

success : function(mlist) {

let str = JSON.parse(mlist);

console.log(str);

let res = "";

for(let i=0; i<str.length; i++) {

res += "<div><a href='movieInfo' id='contents'><img src = '/MovieSourcing"+
str[i].moviePoster+"' width='130px'><br><h3>"+str[i].movieTitle+
"</h3></a><br><p>"+str[i].national+"/"+str[i].movieGrade+"</p></div>";

}

$('.mlist2').html(res);

},

error: function(request, status, error) {

console.log("ajax 에러발생");

console.log("상태코드 : " + request.status); // 404, 500

}


})

return false;

}


function searchData() {
	console.log($('.search-txt').val());
	
	$.ajax({
		
		url : "SearchData",
		data : {"input4" : $('.search-txt').val()},
		type : "GET",
		datatype: "JSON",
		
		success : function(mlist) {
			
			console.log(mlist);
			
		let str = JSON.parse(mlist);
		console.log(str);
		let res = "";
		for(let i=0; i<str.length; i++) {
			
			res += "<div><a href='movieInfo' id='contents'><img src = '/MovieSourcing"+str[i].moviePoster+"' width='130px'><br><h3>"+str[i].movieTitle+"</h3></a><br><p>"+str[i].national+"/"+str[i].movieGrade+"</p></div>";
		}
	
		$('.mlist2').html(res);
       
        },
        
         error: function(request, status, error) {
			console.log("ajax 에러발생");
			console.log("상태코드 : " + request.status); // 404, 500
        }		
	})
};



