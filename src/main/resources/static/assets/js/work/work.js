console.log("Work Module...");

let workService = (function(){
   function getWorkKeywordList(tag,page,callback, error) {
       let pageN = page || 1;
       console.log("in module..."+tag);
       $.ajax({
           url:"/work/workList/"+tag+"/"+pageN,
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
       // $.getJSON("/work/workList/"+tag, function (workApplyPageDTO) {
       //     if(callback) {
       //         callback(workApplyPageDTO.total, workApplyPageDTO.list);
       //     }
       // }).fail(function (xhr, status, er){
       //     if(error) {
       //         error(er);
       //     }
       // });
   };

    function getImg(num,callback, error) {
        $.ajax({
            url: "/file/work/find",
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

   return { getWorkKeywordList: getWorkKeywordList};
})();

let $workList = $(".works");

function tagList(tag, page) {
    $workList.remove();
    workService.getWorkKeywordList(tag, page, function (total, list) {
        console.log("in module..."+tag);
        $workList.html("");
        let str = "";
        if(list == null || list.length == 0) {
            $workList.html("");
            return;
        }

        $.each(list, function (i, work) {
            let infoNumber = Number(work.workNumber);

            $.getJSON("/file/work/file", {workNumber: infoNumber}, function(file){
                let src = "/file/work/display?fileName=" + file.uploadPath + "/" + file.uuid + "_"  + file.fileName;
                $("#img-" + infoNumber).attr("src", src);
            })

            str += "<li>";
            str += "<p className='works_tit'>"+work.workName+"</p>";
            str += "<p className='worker'>"+work.artistName+"</p>";
            str += "<a href='"+work.workNumber+"' className='works_img'>";
            if(work.file != null) {
                str += "<img src='' id='#img-"+infoNumber+"' alt=''></a>";
            }else{
                str += "<img src='/images/work/20473078.jpg' alt=''></a>";
            }
            str += "<p className='tags'>"+work.workTag+"</p>";
            str += "</li>";
        });
        $workList.append(str);
        pageNum = page;
    }, function (a,b,c){
        console.log(a,b,c);
    });
}

