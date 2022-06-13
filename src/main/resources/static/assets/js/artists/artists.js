
var genreListType = "1";
var genreSort = 0;
var prevGenreSort;
var genreArea = '';
var genreListTotalCnt = 0;
var artistType = 0;
var genreType = 1;
var BEFORESEND_HTML = '<div class=\'list-more\'><span class=\'lm1\'></span><span class=\'lm2\'></span><span class=\'lm3\'></span><span class=\'lm4\'></span></div>';

// Genrelist
function jsf_genre_GetGenreList(genre, genretype, sort) {

    prevGenreSort = genreSort;
    genreSort = sort;
    //genreArea = $('#SelectProvince option:selected').val();
    curPage = $.trim($("#pCurPage").val());
    pageSize = $.trim($("#pPageSize").val());
    genreType = genretype;
    idGenre = genre;

    n_click_logging($.ajax({
        async: true,
        type: "GET",
        url: "/New/Genre/Ajax/GenreList_Data.aspx",
        data: { genre: idGenre, sort: genreSort, area: genreArea, genretype: genreType, pCurPage: curPage, pPageSize: pageSize },
        dataType: "html",
        success: function (data, textStatus) {
            if (curPage == 1) {
                $(".ms-list-imgs").remove();
                $("#ListTotalCnt").remove();
            } else {
                $("#ListTotalCnt").remove();
            }
            $(".list-sec").append(data)
            $("#ListCntText").text($("#ListTotalCnt").val() + "개");

            jsf_genre_SetSortOrderClass();
            //jsf_genre_SetListType();

            //jsf_com_ShowPager("div.paging", "#ListTotalCnt", "#pCurPage", "#pPageSize", jsf_genre_GetGenreList_Callback, { showcount: true, showendpoint: false });
            asyncType = false;
        },
        error: function (xhr, textStatus, errorThrown) {
            $(document).find('body').html(xhr.responseText);
            asyncType = false;
            //$("#dialogAlert").jAlert({ "msg": "현재 예매가능한 공연이 존재하지 않습니다." });
        },
        beforeSend: function (xhr, settings) {
            //jsf_com_AjaxLoader(jcAJAX_BEFORESEND, 0, 0, "", "#ListCntText");
            $(".list-sec").append(BEFORESEND_HTML)
            asyncType = false;

        },
        complete: function (xhr, textStatus) {
            //jsf_com_AjaxLoader(jcAJAX_COMPLETE, 0, 0, "", "#ListCntText");
            $(".list-more").remove();
            asyncType = false;
        }
    }));
}

function jsf_genre_GetGenreList_Callback() {
    jsf_genre_GetGenreList(idGenre, genreType, genreSort);
}

function jsf_genre_SetSortOrderClass() {

    $('.li-sec-tag a').removeClass("on");
    $('.li-sec-tag').find("a[token='" + (genreSort) + "']").addClass("on")
}

//function jsf_genre_SetListType() {
//    if (genreListType == 2) {
//        $("#genreList").find("div.ilist").css("display", "none");
//        $("#genreList").find("div.iimg").css("display", "block");
//    } else {
//        $("#genreList").find("div.iimg").css("display", "none");
//        $("#genreList").find("div.ilist").css("display", "block");
//    }

//}

//function jsf_PopChk1(val) {
//    if (val == 1) {
//        $("#divpop1").css("display", "none");
//        //위치값 계산해서 넣어야 함-롤오버
//        $("#divpop1").css("display", "Block");
//    }
//    else {
//        $("#divpop1").css("display", "none");
//    }
//}