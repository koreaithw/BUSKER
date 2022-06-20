console.log("myPage Module....");

let myPageService = (function(){

    // 유저 정보 수정
    function modify(userNumber, callback){
        $.ajax({
            url: "/myPage" + userNumber,
            type: "patch",
            data: JSON.stringify(userNumber),
            contentType: "application/json; charset=utf-8",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    // 회원 탈퇴
    function remove(userNumber, callback){
        $.ajax({
            url: "/myPage/" + userNumber,
            type: "delete",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    function modifyPw(userNumber, password, callback){
        $.ajax({
        url: "/myPage/" + userNumber,
            type: "post",
            contentType: "text/plain",
            success: function(result){
            if(callback){
                callback(result);
            }
            }
        });
    }

    return {modify:modify, modifyPw:modifyPw, remove:remove}
    })();