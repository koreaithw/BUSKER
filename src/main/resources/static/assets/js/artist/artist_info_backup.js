let userNumber = document.getElementById('user_number').value
let likecount = document.getElementById('like_count').value
let likeval = document.getElementById('like_check').value

let query = window.location.search;
let param = new URLSearchParams(query);
let artistNumber = param.get('artistNumber');
let artistnumber = param.get('artistNumber');

let sessionUserCheck = false;

if(!(userNumber == null)) {
    sessionUserCheck = true;
}
// console.log(likeval)
// if (userNumber) {
//     if (likeval > 0) {
//         $(".img1").css('display', 'none');
//         $(".img2").css('display', 'inline-block');
//     }
// }
let replyUserNumber = 0;

console.log(userNumber)

//후원버튼 클릭시 모달창 열기
$("#btn-modal").click(function () {
    if (!userNumber) {
        alert("로그인후 이용해주세요");
    } else {
        console.log("fdd")
        $(".modal").fadeIn();
    }
});

//닫기 누를시 모달창 닫기
$(".modal-close-btn").click(function () {
    $(".modal").fadeOut();
});


function modalout() {
    $(".modal").fadeOut();
}

function donateapi() {
    // getter

    var IMP = window.IMP;
    IMP.init('imp17202305');
    // var usernumber = userNumber;

    var money = $('input[name="donation-money"]').val();
    var message = $('input[name="donation-message"]').val();
    console.log(artistnumber);
    console.log(money);
    console.log(message);
    console.log(query);

    IMP.request_pay({
        pg: 'kakao',
        merchant_uid: 'merchant_' + new Date().getTime(),

        name: '주문명 : 주문명 설정',
        amount: money,
        buyer_email: 'iamport@siot.do',
        buyer_name: '구매자이름',
        buyer_tel: '010-1234-5678',
        buyer_addr: '인천광역시 부평구',
        buyer_postcode: '123-456'
    }, function (rsp) {
        console.log(rsp);
        if (rsp.success) {
            var msg = '후원해주셔서 감사합니다.';
            // msg += '고유ID : ' + rsp.imp_uid;
            // msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            // msg += '카드 승인번호 : ' + rsp.apply_num;

            let donationObj = {
                "userNumber": userNumber,
                "artistNumber": artistnumber,
                "donationMoney": money,
                "donationMessage": message,
                "query": query
            };

            $.ajax({

                url: "/donation/donationRegister", //충전 금액값을 보낼 url 설정
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(donationObj),
                success: function (data) {
                },
            });
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
        modalout();
    });

};


$(document).ready(function () {
    let likecount = document.getElementById('like_count').value
    let likeval = document.getElementById('like_check').value
    console.log(likeval);
    if (userNumber) {
        if (likeval > 0) {
            $(".img1").css('display', 'none');
            $(".img2").css('display', 'inline-block');
        }
    }

    $.getJSON("/file/artist/find", {artistNumber:artistnumber}, function (file) {
        let src = "/file/artist/display?fileName=" + file.uploadPath + "/" + file.uuid + "_" + file.fileName;
        console.log(src)
        $("img.artist-image").attr("src", src);
    })


})




$("#btn-like").click(function () {



    if (!userNumber) {
        alert("로그인 후 이용해주세요")
    } else {

        if (likeval > 0) {
            $(".img1").css('display', 'inline-block');
            $(".img2").css('display', 'none');


            console.log(userNumber);
            console.log(artistnumber);

            let likeObj = {
                "userNumber": userNumber,
                "artistNumber": artistnumber
            };

            $.ajax({

                url: "/like/artist/likeDelete",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(likeObj),
                success: function (data) {
                },
            });

            likecount -= 1;
            likeval -= 1;

            setTimeout(function () {
                // Location.reload(true)
                location.replace(location.href);
            }, 50);

        } else {

            $(".img1").css('display', 'none');
            $(".img2").css('display', 'inline-block');



            console.log(userNumber);
            console.log(artistnumber);

            let likeObj = {
                "userNumber": userNumber,
                "artistNumber": artistnumber
            };

            $.ajax({
                // beforeSend: function (xhr) {
                //     xhr.setRequestHeader("Content-type","application/json");
                // },
                url: "/like/artist/likeNew",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(likeObj),
                success: function (data) {
                },
            });
            likecount += 1;
            likeval += 1;


            setTimeout(function () {
                // Location.reload(true)
                location.replace(location.href);
            }, 50);
        }
    }
})














