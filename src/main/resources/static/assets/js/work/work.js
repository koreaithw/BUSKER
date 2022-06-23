// console.log("Work Module...");
//
// function workService = (function(){
//    function getWorkKeywordList(tag,callback, error) {
//        $.getJSON("/work/workList/"+tag, function (workApplyPageDTO) {
//            if(callback) {
//                callback(workApplyPageDTO.total, workApplyPageDTO.list);
//            }
//        }).fail(function (xhr, status, er){
//            if(error) {
//                error(er);
//            }
//        });
//    }
//
//    return { getWorkKeywordList: getWorkKeywordList};
// });