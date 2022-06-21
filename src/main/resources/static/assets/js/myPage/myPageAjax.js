console.log("myPage Module....");

let myPageService = (function(){

    // 유저 정보 조회
    function read(userNumber, callback){
        $.ajax({
            url: "/myPage" + userNumber,
            type: "get",
            dataType: "json",
            success: function(user){
                if(callback) {
                    callback(user);
                }
            }
        })
    }

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

    return {modify:modify, read:read, modifyPw:modifyPw, remove:remove}
    })();