// ajax 생성
let showService = (function () {
    function goConcertPlan(type, page, callback, error) {
        console.log("getList")
        let pageNum = page || 1;
        $.ajax({
            url: "/main/concertPlanList/" + type + "/" + pageNum,
            type: "get",
            // data: JSON.stringify(type),
            dataType: "json",
            contentType: "application/json",
            success: function (showPageDTO) {
                if(callback) {
                    callback(showPageDTO.total, showPageDTO.list);
                }
            },
            error: function (xhr, status, er) {
                if(error)   {
                    error(xhr, status, er);
                }
            }
        })
    }

    return {goConcertPlan:goConcertPlan}
})();

// 기본 전역변수
let pageNum = 1;
let type = "A"
let showDiv = $(".small-5-box");


// div 변하는 function 선언
function concertPlanList(type, page){
    console.log("새로고침 됐슈")
    showService.goConcertPlan(type, page, function (total, list) {
        let str = "";
        console.log("concertPlanList 안까지 들어왔슈  ", type, "  변수는 ", page)

        if(list == null || list.length == 0){
            str += '<section class="show-wrap showIng"><div class="non-show">등록된 공연이 없습니다.</div></section>'
            showDiv.html(str);
            return;
        }

        $.each(list, function(i, show){
            let infoNumber = Number(show.showNumber);

            $.getJSON("/file/concert/file", {showNumber: infoNumber}, function(file){
                let src = "/file/concert/display?fileName=" + file.uploadPath + "/" + file.uuid + "_"  + file.fileName;
                $("#img-" + infoNumber).attr("src", src);
            })

            str += "<div class='image-plus-box'>"
            str += "<a href='/concert/concertPlanInfo?pageNum=" + page + "&amount=15&type&keyword&showNumber=" + infoNumber +"' target='_self'>"
            str += "<div>"
            str += "<img id='img-" + infoNumber + "' class='lazyload' src='' alt='#'/>"
            str += "</div>"
            str += "<div class='small-5-box-textbox'>"
            str += "<p id='small-5-box-uptext'>" + show.showTime + "</p>"
            str += "<p id='small-5-box-downtext'>" + show.showLocation + "</p>"
            str +="</div>"
            str += "</a>"
            str +="</div>"




        });

        showDiv.html(str);
        concertPage(type, total);
    }, function (a, b, c) {
        console.log(a, b, c)
    });
}





$(document).ready(function () {
    // 새로고침 첫 실행 (type : A, pageNum : 1 (기본값))
    concertPlanList(type, pageNum);

})



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



// let showService = (function () {
//
//
//     $.each(list, function (i, show) {
//         let infoNumber = Number(show.showNumber);
//
//         $.getJSON("/file/concert/file", {showNumber: infoNumber}, function (file) {
//             let src = "/file/concert/display?fileName=" + file.uploadPath + "/" + file.uuid + "_" + file.fileName;
//             $("#img-" + infoNumber).attr("src", src);
//         })

        // function getImg(num, callback, error) {
        //     $.ajax({
        //         url: "/file/work/find/" + num,
        //         type: "get",
        //         dataType: "json",
        //         contentType: "application/json",
        //         success: function (file) {
        //             if (callback) {
        //                 callback(file);
        //             }
        //         },
        //         error: function (xhr, status, er) {
        //             if (error) {
        //                 error(xhr, status, er);
        //             }
        //         }
        //     });
        // }

})














