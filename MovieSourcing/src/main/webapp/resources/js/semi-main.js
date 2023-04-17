



const janrbutton = document.getElementById("janrbutton");

janrbutton.addEventListener("click", function() {
    window.open("semi-mlist.html", "_self");
});

$('#janrbutton').click(function() {
    window.open('semi-mlist.html','_self');
});



// 첫번째 영화추천 슬라이드
let slides = document.querySelector('.slides'),
    slide = document.querySelectorAll('.slides li'),
    currentIdx = 0,
    slideCount = slide.length,
    prevBtn = document.querySelector('.prev'),
    slideWidth = 200,
    slideMargin = 30,
    nextBtn = document.querySelector('.next');

    slides.style.width = (slideWidth + slideMargin)*slideCount - slideMargin + 'px';

makeClone1();

function moveSlide(num) {
    slides.style.left = -num * (slideWidth + slideMargin) + 'px';
    currentIdx = num;
    console.log(currentIdx, slideCount);
    if(currentIdx == slideCount || currentIdx == -slideCount) {
       
        setTimeout(function() {
           slides.classList.remove('animated');
           slides.style.left = '0px';
           currentIdx = 0;
        }, 500);
       
        setTimeout(function() {
       
          slides.classList.add('animated');
       
        }, 600);
        
    }
};
       
function makeClone1() {
    for(var i = 0; i<slideCount; i++) {
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.appendChild(cloneSlide);
    }
    for(var i =  slideCount -1; i>=0; i--){
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.prepend(cloneSlide);
     }
    updateWidth1();
    setInitialPos1();
    setTimeout(function() {
        slides.classList.add('animated');
        
    },100);
}
       
function updateWidth1() {
    var currentSlides = document.querySelectorAll('.slides li');
    var newSlideCount = currentSlides.length;
       
    var newWidth = (slideWidth + slideMargin) * newSlideCount - slideMargin + 'px';
    slides.style.width = newWidth;
       
}
       
function setInitialPos1() {
    var initialTranslateValue = -(slideWidth + slideMargin) * slideCount
       
    slides.style.transform = 'translateX(' + initialTranslateValue + 'px)';
       
}
nextBtn.addEventListener('click', function() {
    moveSlide(currentIdx + 1);
});
prevBtn.addEventListener('click', function() {
    moveSlide(currentIdx - 1);
});




// 둦번쨰 영화추천 슬라이드
let slides2 = document.querySelector('.slides2'),
    slide2 = document.querySelectorAll('.slides2 li'),
    currentIdx2 = 0,
    slideCount2 = slide2.length,
    prevBtn2 = document.querySelector('.prev2'),
    slideWidth2 = 200,
    slideMargin2 = 30,
    nextBtn2 = document.querySelector('.next2');

    slides2.style.width = (slideWidth2 + slideMargin2)*slideCount2 - slideMargin2 + 'px';

makeClone2();


function moveSlide2(num2) {
    slides2.style.left = -num2 * (slideWidth2 + slideMargin2) + 'px';
    currentIdx2 = num2;
    console.log(currentIdx2, slideCount2);
    if(currentIdx2 == slideCount2 || currentIdx2 == -slideCount2) {
           
        setTimeout(function() {
            slides2.classList.remove('animated');
            slides2.style.left = '0px';
            currentIdx2 = 0;
        }, 500);
           
        setTimeout(function() {
           
            slides2.classList.add('animated');
           
        }, 600);
            
    }
};
           
function makeClone2() {
    for(var i = 0; i<slideCount2; i++) {
        var cloneSlide = slide2[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides2.appendChild(cloneSlide);
    }
    for(var i =  slideCount2 -1; i>=0; i--){
        var cloneSlide = slide2[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides2.prepend(cloneSlide);
    }
    updateWidth2();
    setInitialPos2();
    setTimeout(function() {
        slides2.classList.add('animated');
           
    },100);
}
           
function updateWidth2() {
    var currentSlides2 = document.querySelectorAll('.slides2 li');
    var newSlideCount2 = currentSlides2.length;
           
    var newWidth = (slideWidth2 + slideMargin2) * newSlideCount2 - slideMargin2 + 'px';
    slides2.style.width = newWidth;
           
}
           
function setInitialPos2() {
    var initialTranslateValue = -(slideWidth2 + slideMargin2) * slideCount2
           
    slides2.style.transform = 'translateX(' + initialTranslateValue + 'px)';
           
}
nextBtn2.addEventListener('click', function() {
    moveSlide2(currentIdx2 + 1);
});
prevBtn2.addEventListener('click', function() {
    moveSlide2(currentIdx2 - 1);
});
    





//메인포스터 슬라이드

let mslides = document.querySelector('.main-slides'),
    mslide = document.querySelectorAll('.main-slides li'),
    mcurrentIdx = 0,
    mslideCount = mslide.length,
    mslideWidth = 1920,
    mslideMargin = 0;


    makeClone();




function mmoveSlide(mnum) {
 mslides.style.left = -mnum * (mslideWidth + mslideMargin) + 'px';
 mcurrentIdx = mnum;
 if(mcurrentIdx == mslideCount || mcurrentIdx == -mslideCount) {

    setTimeout(function() {
        mslides.classList.remove('animated');
        mslides.style.left = '0px';
        mcurrentIdx = 0;
    }, 500);

    setTimeout(function() {

        mslides.classList.add('animated');

    }, 700);
 
 }
};

function makeClone() {
    for(var i = 0; i<mslideCount; i++) {
        var cloneSlide = mslide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        mslides.appendChild(cloneSlide);
    }
    for(var i =  mslideCount -1; i>=0; i--){
        var cloneSlide = mslide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        mslides.prepend(cloneSlide);
    }
    updateWidth();
    setInitialPos();
    setTimeout(function() {
        mslides.classList.add('animated');

    },100);
}

function updateWidth() {
    var currentSlides = document.querySelectorAll('.main-slides li');
    var newSlideCount = currentSlides.length;

    var newWidth = (mslideWidth + mslideMargin) * newSlideCount - mslideMargin + 'px';
    mslides.style.width = newWidth;

}

function setInitialPos() {
    var initialTranslateValue = -(mslideWidth + mslideMargin) * mslideCount

    mslides.style.transform = 'translateX(' + initialTranslateValue + 'px)';

}

var timer = undefined;

function autoSlide() {
    if(timer == undefined) {
        timer = setInterval(function() {
            mmoveSlide(mcurrentIdx +1);
        }, 2000);
    }
}
autoSlide();
function stopSlide() {
    clearInterval(timer);

    timer = undefined;

}
mslides.addEventListener('mouseenter', function() {
    stopSlide();
});
mslides.addEventListener('mouseleave', function() {
    autoSlide();
});







// 인기순위 슬라이드 실험


/*function chart() {
    let chart = document.querySelectorAll(".charts");

    for(let i=0; i<chart.length; i++) {
        chart[i].toggleAttribute('active');
    }
    setTimeout()
}
*/


//top 버튼 클릭시 위로 이동
$(window).scroll(function() {
    if($(this).scrollTop() > 100) {
        $('.btn').addClass('on');
    }else {
        $('.btn').removeClass('on');
    }
});

$('.btn').click(function() {
    window.scrollTo({top : 0, behavior: 'smooth'});
});


//인기차트 변경

let showNum = 0;
let chart = document.querySelectorAll('.chart');
$('.rotate').click(function() {

    chart[showNum].classList.remove("active");
    
    showNum++;

    if(showNum == 3){
        showNum = 0;
    }

    chart[showNum].classList.add("active");
 
});