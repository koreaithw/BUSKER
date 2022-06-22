// ajax 생성
let showService = (function () {
    function goConcertPlan(type, page, callback, error) {
        console.log("getList")
        let pageNum = page || 1;
        $.ajax({
            url: "/concert/concertPlanList/" + type + "/" + pageNum,
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
let showDiv = $(".show-wrap");


// div 변하는 function 선언
function concertPlanList(type, page){
    console.log("새로고침 됐슈")
    showService.goConcertPlan(type, page, function (total, list) {
        let str = "";
        console.log("concertPlanList 안까지 들어왔슈  ", type, "  변수는 ", page)

        if(list == null || list.length == 0){
            showDiv.html("");
            return;
        }

        $.each(list, function(i, show){
            let infoNumber = Number(show.showNumber);
            str += "<a class='goRead' href='/concert/concertPlanInfo?pageNum=" + page + "&amount=15&type&keyword&showNumber=" + infoNumber +"' target='_self'>"
            str += "<div class='list-bigger-wrap'>"
            str += "<img class='lazyload' src='http://tkfile.yes24.com/upload2/perfblog/202205/20220516/20220516-42246.jpg/dims/quality/70/' alt='/show_view'/>"
            str += "<div class='list-bigger-txt'>"
            str += "<p class='list-b-tit1'>" + show.showName + "</p>"
            str += "<p class='list-b-tit2'>" + show.showLocation + "</p>"
            str += "<p class='list-b-circle'>" + "D-" + show.dday + "</p>"
            str += "</div>"
            str += "</div>"
            str += "</a>"
        });

        showDiv.html(str);
    }, function (a, b, c) {
        console.log(a, b, c)
    });
}

$(document).ready(function () {
    // 새로고침 첫 실행 (type : A, pageNum : 1 (기본값))
    concertPlanList(type, pageNum);
})

let currentCategory = ".all";
function categoryChange(e) {
    $(currentCategory).attr("id", "non-current");
    currentCategory = e;
    $(currentCategory).attr("id", "current");
}

$(".all").click(function (e) {
    categoryChange(".all");
    e.preventDefault();
    console.log("all 됐슈")
    pageNum = 1;
    concertPlanList("A", pageNum);
})

$(".musician").click(function (e) {
    categoryChange(".musician");
    e.preventDefault();
    console.log("musician 됐슈")
    pageNum = 1;
    concertPlanList("M", pageNum);
})

$(".performance").click(function (e) {
    categoryChange(".performance");
    e.preventDefault();
    console.log("performance 됐슈")
    pageNum = 1;
    concertPlanList("P", pageNum);
})

$("a.goRead").click(function (e) {
    e.preventDefault();
    location.href = "/concert/concertPlanInfo" + paging + "&showNumber=" + $(this).attr('href');
});


