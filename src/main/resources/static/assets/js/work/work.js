console.log("Work Module...");

let workService = (function(){
   function getWorkKeywordList(tag,page,callback, error) {
       let pageN = page || 1;
       let tagN = tag || null;
       console.log("in module..."+tag);
       $.ajax({
           url:"/work/workList/"+tagN+"/"+pageN,
           type:"get",
           dataType: "json",
           contentType: "application/json",
           success: function (workApplyPageDTO) {
               if (callback) {
                   callback(workApplyPageDTO.total, workApplyPageDTO.list);
               }
           },error: function (xhr, status, er) {
               if(error){
                   error(xhr, status, er);
               }
           }
       });
   };

    function getImg(num,callback, error) {
        $.ajax({
            url: "/file/work/find/"+num,
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function (file) {
                if(callback){
                    callback(file);
                }
            },
            error: function (xhr, status, er) {
                if(error)   {
                    error(xhr, status, er);
                }
            }
        });
    }
   return { getWorkKeywordList: getWorkKeywordList, getImg:getImg};
})();

let $workList = $("ul.works");
console.log($workList);
//
// function tagList(tag, page) {
//     workService.getWorkKeywordList(tag, page, function (total, list) {
//         console.log("in module..."+tag);
//         $workList.empty();
//         let str = "";
//         if(list == null || list.length == 0) {
//             $workList.html("");
//             return;
//         }
//
//         $.each(list, function (i, work) {
//             let infoNumber = Number(work.workNumber);
//
//
//             str += `<li>`;
//             str += `<p class='works_tit'>`+work.workName+`</p>`;
//             str += `<p class='worker'>`+work.artistName+`</p>`;
//             str += `<a href='`+work.workNumber+`' class='works_img'>`;
//             str += `<img src='' id='#img-`+infoNumber+`' alt=''></a>`;
//             str += `<p class='tags'>`+work.workTag+`</p>`;
//             str += `</li>`;
//
//             $.getJSON("/file/work/file", {workNumber: infoNumber}, function(file){
//                 let src = "/file/work/display?fileName=" + file.uploadPath + "/" + file.uuid + "_"  + file.fileName;
//                 $("#img-" + infoNumber).attr("src", src);
//             });
//             console.log("list in~~~~");
//         });
//         $workList.html(str);
//         console.log(str);
//         pageNum = page;
//     }, function (a,b,c){
//         console.log(a,b,c);
//     });
// }

