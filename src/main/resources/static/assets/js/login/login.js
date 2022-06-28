let loginForm =  $("form[name='loginForm']");
$(document).ready(function () {
    $(".id-input").keyup(function () {
      $(".delete-id-div").show();
    });
  
    $(".id-input").change(function () {
      if (!$("input[name='userId']").val()) {
        $(".delete-id-div").hide();
      }
    });
  
    $(".pw-input").keyup(function () {
      $(".delete-pw-div").show();
    });
  
    $(".pw-input").change(function () {
      if (!$("input[name='userPw']").val()) {
        $(".delete-pw-div").hide();
      }
    });
  });

  $(".id-text-delete").click(function () {
    $("input[name='userId']").val("");
    $(".delete-id-div").hide();
    $(".id-input").focus();
  });
  
  $(".pw-text-delete").click(function () {
    $("input[name='userPw']").val("");
    $(".delete-pw-div").hide();
    $(".pw-input").focus();
  });

  $("div#pwImg").click(function () {
    const $input = $("input[name='userPw']");
    if ($input.attr("type") == "password") {
      $input.attr("type", "text");
      $(this).css("background-image", "url('/images/login/eye_visible.png')");
    } else {
      $input.attr("type", "password");
      $(this).css("background-image", "url('/images/login/eye_hide.png')");
    }
  });
  
  //  유효성 검사
  function send() {
    $("#checkId").text("");
    $(".id-flex").css("border-bottom", "1px solid #ebebeb");
    $("#checkPw").text("");
    $(".pw-flex").css("border-bottom", "1px solid #ebebeb");
  
    if (!($(".id-input").val()) && !($(".pw-input").val())) {
      $("#checkId").text("아이디를 입력해주세요.");
      $(".id-flex").css("border-bottom", "1px solid #ff4d78");
      $("#checkPw").text("비밀번호를 입력해주세요.");
      $(".pw-flex").css("border-bottom", "1px solid #ff4d78");
      $(".id-input").focus();
      return;
    }
    if (!($(".id-input").val())) {
      $("#checkId").text("아이디를 입력해주세요.");
      $(".id-flex").css("border-bottom", "1px solid #ff4d78");
      $(".id-input").focus();
      return;
    }
    if (!($(".pw-input").val())) {
      $("#checkPw").text("비밀번호를 입력해주세요.");
      $(".pw-flex").css("border-bottom", "1px solid #ff4d78");
      $(".pw-input").focus();
      return;
    }
    loginForm.submit();
  }


/*
$('#login-button').click(function() {

  var userId = $('#login-input id-input').val();
  var userPw = $('#login-input pw-input').val();

  $.ajax({
    type : "POST",
    url : "/user/login",
    data : "userId=" + userId + "userPw" + userPw,
    dataType : "text",
    success : function(data) {
      if (data == 'loginFail') {
        alert('로그인에 실패하였습니다.')
      } else {
        window.location.href = 'main.html';
      }
    },
    error : function(request, status, error) {
      // alert("code:" + request.status + "\n" + "error:" + error);
    }
  })
});
*/
