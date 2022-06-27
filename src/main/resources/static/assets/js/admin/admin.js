// Admin Module

console.log("Admin Module....");

let adminService = (function () {

    function getWorkApplyList(page, callback, error) {
        $.ajax({
            url: "/admin/workApplyList/" + page,
            type: "get",
            dataType: "json",
            contentType: "application/json",
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
        })
    }

    function getRecruitmentList(page, callback, error) {
        $.ajax({
            url: "/recruit/recruitmentList/" + page,
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
                if(callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        })
    }

    function approve(wno, callback, error) {
        console.log("approve work..");
        $.ajax({
            url: "/admin/workApprove/" + wno,
            type: "get",
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
            type: "get",
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

    function removeRecruitment(rno, callback, error) {
        $.ajax({
            url: "/recruit/recruitmentDelete/" + rno,
            type: "get",
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

    function getUserList(param, callback, error) {
        $.ajax({
            url: "/admin/userList/" + param.page + "/" + param.isArtist,
            type: "post",
            dataType: "json",
            contentType: "application/json",
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
        })
    }

    function getUserSearchResult(param, callback, error) {
        $.ajax({
            url: "/admin/userList/" + param.page + "/" + param.isArtist + "/" + param.keyword,
            type: "post",
            dataType: "json",
            contentType: "application/json",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        })
    }

    function deleteUser(uno, callback, error) {
        $.ajax({
            url: "/myPage/" + uno,
            type: "delete",
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
        })
    }

    function getArtistApplyList(param, callback, error) {
        $.ajax({
            url: "/admin/artistApplyList/" + param.page + "/" + param.isUpdate,
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        })
    }

    function getArtistList(page, callback, error) {
        $.ajax({
            url: "/admin/artistList/" + page,
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if(error){
                    error(xhr, status, er);
                }
            }
        })
    }

    function approveArtist(ano, callback, error) {
        $.ajax({
            url: "/admin/approveArtist/" + ano,
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

    function rejectArtist(ano, callback, error) {
        $.ajax({
            url: "/admin/rejectArtist/" + ano,
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

    function removeArtist(ano, callback, error) {
        $.ajax({
            url: "/admin/removeArtist/" + ano,
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
        getWorkApplyList: getWorkApplyList,
        approve: approve,
        reject: reject,
        getRecruitmentList: getRecruitmentList,
        removeRecruitment: removeRecruitment,
        getUserList: getUserList,
        deleteUser: deleteUser,
        getUserSearchResult: getUserSearchResult,
        getArtistApplyList: getArtistApplyList,
        approveArtist: approveArtist,
        rejectArtist: rejectArtist,
        getArtistList: getArtistList,
        removeArtist: removeArtist,
    }
})();

