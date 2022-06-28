let usernumber = document.getElementById('user_number').value

console.log(usernumber)

//후원버튼 클릭시 모달창 열기
$("#btn-modal").click(function () {
    console.log("fdd")
    $(".modal").fadeIn();
});


//닫기 누를시 모달창 닫기
$(".modal-close-btn").click(function () {
    $(".modal").fadeOut();
});


function modalout() {
    $(".modal").fadeOut();
}



// 좋아요 버튼 누르면 좋아요 표시 하기
// let check = false;
// let changeLike = function() {
//     console.log("들어옴");
//     if (check) {
//         alert("이미 좋아요를 눌렀습니다.");
//         return;
//     }
//
//     $(".img1").css('display', 'none');
//     $(".img2").css('display', 'inline-block');
//
//     var usernumber = 1; //임시 넘버
//
//     let param = new URLSearchParams(query);
//     let artistnumber = param.get('artistNumber');
//
//     console.log(usernumber);
//     console.log(artistnumber);
//
//     let likeObj = {
//         "userNumber": usernumber,
//         "artistNumber": artistnumber
//     };
//
//     $.ajax({
//         // beforeSend: function (xhr) {
//         //     xhr.setRequestHeader("Content-type","application/json");
//         // },
//         url: "/like/artist/likeNew",
//         type: "POST",
//         contentType: "application/json",
//         data: JSON.stringify(likeObj),
//         success: function (data) {
//         },
//     });
//
//     check = true;
//
//
// }
//
//     sendlike();
//
//     function sendlike() {
//
//
//         var usernumber = 1; //임시 넘버
//
//         let param = new URLSearchParams(query);
//         let artistnumber = param.get('artistNumber');
//
//         console.log(usernumber);
//         console.log(artistnumber);
//
//         let likeObj = {
//             "userNumber": usernumber,
//             "artistNumber": artistnumber
//         };
//
//         $.ajax({
//             // beforeSend: function (xhr) {
//             //     xhr.setRequestHeader("Content-type","application/json");
//             // },
//             url: "/like/artist/likeNew",
//             type: "POST",
//             contentType: "application/json",
//             data: JSON.stringify(likeObj),
//             success: function (data) {
//             },
//         });
//
// }

// $('.rn-bb03-2 godonate').click(function donateapi() {
//     // getter
//     var IMP = window.IMP;
//     IMP.init(imp17202305);
//     var money = $('input[name="donation-money"]:checked').val();
//     console.log(money);
//
//     IMP.request_pay({
//         pg: 'kakao',
//         merchant_uid: 'merchant_' + new Date().getTime(),
//
//         name: '주문명 : 주문명 설정',
//         amount: money,
//         buyer_email: 'iamport@siot.do',
//         buyer_name: '구매자이름',
//         buyer_tel: '010-1234-5678',
//         buyer_addr: '인천광역시 부평구',
//         buyer_postcode: '123-456'
//     }, function (rsp) {
//         console.log(rsp);
//         if (rsp.success) {
//             var msg = '결제가 완료되었습니다.';
//             msg += '고유ID : ' + rsp.imp_uid;
//             msg += '상점 거래ID : ' + rsp.merchant_uid;
//             msg += '결제 금액 : ' + rsp.paid_amount;
//             msg += '카드 승인번호 : ' + rsp.apply_num;
//             $.ajax({
//                 type: "GET",
//                 url: "/user/mypage/charge/point", //충전 금액값을 보낼 url 설정
//                 data: {
//                     "amount" : money
//                 },
//             });
//         } else {
//             var msg = '결제에 실패하였습니다.';
//             msg += '에러내용 : ' + rsp.error_msg;
//         }
//         alert(msg);
//         document.location.href="/user/mypage/home"; //alert창 확인 후 이동할 url 설정
//     });
// });


function donateapi() {
    // getter
    var IMP = window.IMP;
    IMP.init('imp17202305');
    var usernumber = 2;
    let query = window.location.search;
    let param = new URLSearchParams(query);
    let artistnumber = param.get('artistNumber');
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

            let donationObj={
                "userNumber" : usernumber,
                "artistNumber" : artistnumber,
                "donationMoney" : money,
                "donationMessage" : message,
                "query" : query
            };

            $.ajax({
                // beforeSend: function (xhr) {
                //     xhr.setRequestHeader("Content-type","application/json");
                // },
                url: "/donation/donationRegister", //충전 금액값을 보낼 url 설정
                type: "POST",
                contentType: "application/json",
                data : JSON.stringify(donationObj),
                success : function (data){
                },
            });
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
        modalout();
        // document.location.href="/user/mypage/home"; //alert창 확인 후 이동할 url 설정
    });
};

// function clickLike() {
//     // getter
//
//     var usernumber = 1; //임시 넘버
//
//     let param = new URLSearchParams(query);
//     let artistnumber = param.get('artistNumber');
//
//     console.log(usernumber);
//     console.log(artistnumber);
//
//     let likeObj={
//                 "userNumber" : usernumber,
//                 "artistNumber" : artistnumber
//             };
//
//             $.ajax({
//                 // beforeSend: function (xhr) {
//                 //     xhr.setRequestHeader("Content-type","application/json");
//                 // },
//                 url: "/like/artist/likeNew",
//                 type: "POST",
//                 contentType: "application/json",
//                 data : JSON.stringify(likeObj),
//                 success : function (data){
//                 },
//             });
//
//         // document.location.href="/user/mypage/home"; //alert창 확인 후 이동할 url 설정
//     };

// $(function() {
//     // 추천버튼 클릭시(추천 추가 또는 추천 제거)
//     $("#like").click(function () {
//         var usernumber = 1; //임시 넘버
//
//         let param = new URLSearchParams(query);
//         let artistnumber = param.get('artistNumber');
//
//         console.log(usernumber);
//         console.log(artistnumber);
//
//
//
//         let likeObj = {
//             "userNumber": usernumber,
//             "artistNumber": artistnumber
//         };
//
//         $.ajax({
//             // beforeSend: function (xhr) {
//             //     xhr.setRequestHeader("Content-type","application/json");
//             // },
//             url: "/like/artist/likeNew",
//             type: "POST",
//             contentType: "application/json",
//             data: JSON.stringify(likeObj),
//             success: function (data) {
//             },
//         });
//     })
// });



$(document).ready(function () {
    let likecount = document.getElementById('like_count').value
    let likeval = document.getElementById('like_check').value
    console.log(likeval);




    if (likeval > 0) {
        $(".img1").css('display', 'none');
        $(".img2").css('display', 'inline-block');
    }
    // else {
    //     likeimg.src = "/resources/img/좋아요전.png";
    // }

    $("#btn-like").click(function () {

        if (likeval > 0) {
            $(".img1").css('display', 'inline-block');
            $(".img2").css('display', 'none');
            var usernumber = 2; //임시 넘버

            let query = window.location.search;

            let param = new URLSearchParams(query);
            let artistnumber = param.get('artistNumber');

            console.log(usernumber);
            console.log(artistnumber);

            let likeObj = {
                "userNumber": usernumber,
                "artistNumber": artistnumber
            };

            $.ajax({
                // beforeSend: function (xhr) {
                //     xhr.setRequestHeader("Content-type","application/json");
                // },
                url: "/like/artist/likeDelete",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(likeObj),
                success: function (data) {
                },
            });

            // $.ajax({
            //     // beforeSend: function (xhr) {
            //     //     xhr.setRequestHeader("Content-type","application/json");
            //     // },
            //     url: "/like/artist/likeDelete",
            //     type: "POST",
            //     contentType: "application/json",
            //     data: JSON.stringify(likeObj),
            //     success: function (data) {
            //     },
            // });

            likecount -= 1;
            likeval -= 1;

            setTimeout(function() {
                // Location.reload(true)
                location.replace(location.href);
            }, 50);








        } else {

            $(".img1").css('display', 'none');
            $(".img2").css('display', 'inline-block');
            var usernumber = 2; //임시 넘버

            let query = window.location.search;

            let param = new URLSearchParams(query);
            let artistnumber = param.get('artistNumber');

            console.log(usernumber);
            console.log(artistnumber);

            let likeObj = {
                "userNumber": usernumber,
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


            setTimeout(function() {
                // Location.reload(true)
                location.replace(location.href);
            }, 50);


        }

    })

})








