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

$(function(){
    $('#week-rank').click(function(){
        $(".rank_calendar_ver1").css('display', 'block');
        $(".rank_calendar_ver2").css('display', 'none');
        $(".rank_calendar_ver3").css('display', 'none');
    })

    $('#month-rank').click(function(){
        $(".rank_calendar_ver3").css('display', 'none');
        $(".rank_calendar_ver2").css('display', 'block');
        $(".rank_calendar_ver1").css('display', 'none');
    })

    $('#year-rank').click(function(){
        $(".rank_calendar_ver1").css('display', 'none');
        $(".rank_calendar_ver2").css('display', 'none');
        $(".rank_calendar_ver3").css('display', 'block');
    })
})





// console.log("Ranking Module......");
// let Rankingservise = (function(){
//     function add(rankingService, callback, error){
//         console.log("add reply..........");
//         $.ajax({
//             url: "/ranking",
//             type: "get",
//             data: JSON.stringify(rankingService),
//             contentType: "application/json",
//             success: function(result){
//                 if(callback){
//                     callback(result);
//                 }
//             },
//             error: function(xhr, status, er){
//                 if(error){
//                     error(xhr, status, er);
//                 }
//             }
//         });
//     }
//
// })();

let rankingService = (function(){
function year(year, callback, error) {
    console.log("6/27 ..........");
    $.ajax({
        url: "ranking/rankingAll",
        type: 'get',
        data: JSON.stringify({year}),
        contentType: "application/json",
        success: function (result) {
            if (callback) {
                callback(result);
            }
        },
        error: function (xhr, status, er) {
            if (error) {
                error(er);
            }
        }
    });
}

return {add: add};
})();





