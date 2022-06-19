// Admin Module

console.log("Admin Module....");

let adminService = (function () {

    function approve(wno, callback, error) {
        console.log("approve work..");
        $.ajax({
            url: "/admin/workApprove/" + wno,
            type: "post",
            success: function (result) {
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        });
    }

    function reject(wno, callback, error) {
        console.log("reject work....");
        $.ajax({
            url: "/admin/workReject/" + wno,
            type: "post",
            success: function (result) {
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        });
    }

    return {
        approve: approve,
        reject: reject,
    }
})