$(document).ready(function(){
    $(".rank_category_date").text(weekDay);
})
// 전체, 뮤지션, 퍼포먼스 색깔 바꾸는 js
$(".rank_genre a").on('click', function (e) {
    $(".rank_genre a").removeClass('on'); // 기존 a태그에 있던 on 클래스를 지우고
    $(this).addClass('on'); // 클릭 이벤트가 실행된 a태그에 클래스 on을 넣어주자
})

$(".rank_category_tiny a").on('click', function (e) {
    e.preventDefault();
    $(".rank_category_tiny a").removeClass('on');
    $(this).addClass('on');
    $(".rank_category_")
})

// $(".rank_category_date").on('click', function () {
//     if ($(".rank_category_calendar").is(".on")) {
//         $(this).removeClass("on");
//         $(".rank_category_calendar").css("display", "none");
//         $(".rank_category_calendar").removeClass("on");
//     } else {
//         $(this).addClass("on");
//         $(".rank_category_calendar").css("display", "block");
//         $(".rank_category_calendar").addClass("on");
//     }
// })



// $("#week_rank").click(function(){
//     e.preventDefault();
//     divCurrent = '#rank_calendar_ver1';

// })

// $("#month_rank").click(function(){
//     e.preventDefault();
//     divCurrent = '#rank_calendar_ver2';
// })

// $("#year-rank").click(function(){
//     e.preventDefault();
//     divCurrent = '#rank_calendar_ver3';
// })
let divCurrent = '#rank_calendar_ver1';

function divChange(e) {
    $(divCurrent).hide();
    divCurrent= e;
    $(divCurrent).show();
}


$(".rank_category_date").click(function (e) {
    if ($(".rank_category_calendar").css('display') == 'none') {
        $(".rank_category_calendar").show();
        divChange('#rank_calendar_ver1');
    } else if ($(".rank_category_calendar").css('display') == 'block') {
        $(".rank_category_calendar").hide();
    }
})


$("#week-rank").click(function (e) {
    e.preventDefault();
    divChange('#rank_calendar_ver1');
    console.log(weekDay);
    $(".rank_category_date").text(weekDay);
})

$("#month-rank").click(function (e) {
    e.preventDefault();
    divChange('#rank_calendar_ver2');
    $(".rank_category_date").text(monthDay);

})

$("#year-rank").click(function (e) {
    e.preventDefault();
    divChange('#rank_calendar_ver3');
    $(".rank_category_date").text(year);
})




$("#rank_calendar_ver1").datepicker({
    dateFormate: 'yy-dd-mm',
    prevText: '이전 달',
    nextText: '다음 달',
    showOtherMonths: true,
    monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
    monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNmaesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '.',
    maxDate: 0

})


$("#rank_calendar_ver2").datepicker({ 
    dateFormate: 'yy-mm',
    showOtherMonths: true,
    changeMonth: true,
    changeYear: true,
    monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
    monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNmaesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '.',
    closeText: "선택"
    })

// });

$("#rank_calendar_ver3").datepicker({
    dateFormate: 'yyyy',
    changeYear: true
})

    const week=['일','월','화','수','목','금','토'];
    let today = new Date();
    let year=today.getFullYear();
    let month=today.getMonth() + 1;
    let monthDay=year + "/" + month;
    let day=week[today.getDay()];
    let date=today.getDate();
    let hours = today.getHours();
    let minutes = today.getMinutes();
    let firstWeek = year + "." + month + '월 ' + date + '일 ' +  "(" + day +  ")";
    let lastWeek = year + "." + month + '월 ' + (date + 7) + '일 ' +  "(" + day +  ")";
    let weekDay= firstWeek + " ~ " + lastWeek;

$(function () {
    $('#rank_calendar_ver1').datepicker();
    let curDate = '';
    $('#rank_calendar_ver1').change(function () {
        $(".rank_category_date").text("");
        $(".rank_category_date").text($('#rank_calendar_ver1').val());
    })

    $('#rank_calendar_ver2').change(function(){
        $(".rank_category_date").text("");
        $(".rank_category_date").text($('#rank_calendar_ver2').val());
    })

    $('#rank_calendar_ver3').change(function(){
        $(".rank_category_date").text("");
        $(".rank_category_date").text($('#rank_calendar_ver3').val());
    })
})

$(function () {
    $('#rank_calendar_ver2').monthpicker();
})

$(function () {
    $('#rank_calendar_ver3').datepicker();
})