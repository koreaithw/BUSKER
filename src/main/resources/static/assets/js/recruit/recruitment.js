let recruitmentService = (function () {
    function getRecruitList(type,page,amount, callback, error) {
        let pageNum = page || 1;
        let typeN = type || "A";
        let amountN = amount || 10;
        $.ajax({
            url:"/recruit/recruitmentList/"+typeN+"/"+pageNum+"/"+amountN,
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function (RecruitListPageDTO) {
                if(callback) {
                    callback(RecruitListPageDTO.total, RecruitListPageDTO.list);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        });
    };

    function getImg(num,callback, error) {
        $.ajax({
            url: "/file/recruitment/find/"+num,
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

    return {getRecruitList: getRecruitList, getImg:getImg};
})();