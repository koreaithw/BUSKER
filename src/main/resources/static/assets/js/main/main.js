var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
    setTimeout(showSlides, 5000)
}; // Change image every 5 seconds


let divCurrentName = ".flexing-all";

function formReset() {
    $("#ranking-musician")[0].reset();
    $("#myInfoForm")[0].reset();
    $("#newPwForm")[0].reset();

}


// 페이지 첫 설정
$(document).ready(function () {
    console.log("q21")
    divCurrentName = ".flexing-all";
    $(divCurrentName).show();
});

// 랭킹 헤더 변경시 본문 div
function tabChange(e) {
    $(divCurrentName).hide();
    divCurrentName = e;
    $(divCurrentName).show();
}

// 전체 헤더 클릭
// 전체 관리 탭
$(".all").click(function (e) {
    e.preventDefault();
    tabChange(".flexing-all")
});

// 뮤지션 헤더 클릭
// 뮤지션 관리 탭
$(".musician").click(function (e) {
    e.preventDefault();
    tabChange(".flexing-musician")
});

// 퍼포먼스 헤더 클릭
// 퍼포먼스 관리 탭
$(".performance").click(function (e) {
    e.preventDefault();
    tabChange(".flexing-performance")
});


$(document).ready(function () {
    $(window).scroll(function () {
        if ($(this).scrollTop() > 200) {
            $('.jcm-top').fadeIn();
        } else {
            $('.jcm-top').fadeOut();
        }
    });
    $('.jcm-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 400);
        return false;
    });

})










