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
    if (!$("input[name='userPhoneNumber']").val()) {
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
  $("input[name='userPhoneNumber']").val("");
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

  if (!loginForm.userId.value && !loginForm.userPhoneNumber.value) {
    $("#checkId").text("이메일을 입력해주세요.");
    $(".id-flex").css("border-bottom", "1px solid #ff4d78");
    $("#checkPw").text("비밀번호를 입력해주세요.");
    $(".pw-flex").css("border-bottom", "1px solid #ff4d78");
    $(".id-input").focus();
    return;
  }
  if (!loginForm.userId.value) {
    $("#checkId").text("이메일을 입력해주세요.");
    $(".id-flex").css("border-bottom", "1px solid #ff4d78");
    $(".id-input").focus();
    return;
  }
  if (!$("#userPhoneNumber")) {
    $("#checkPw").text("휴대폰 번호를 입력해주세요.");
    $(".pw-flex").css("border-bottom", "1px solid #ff4d78");
    $(".pw-input").focus();
    return;
  }
  // loginForm.submit();
}

//  유효성 검사
function send() {
  $("#checkId").text("");
  $(".id-flex").css("border-bottom", "1px solid #ebebeb");
  $("#checkPw").text("");
  $(".pw-flex").css("border-bottom", "1px solid #ebebeb");
  $("#checkSMSNumber").text("");
  $(".checkNumber-flex").css("border-bottom", "1px solid #ebebeb");

  if (!($("#userPhoneNumber").val()) && !($("#checkNumber").val())) {
    $("#checkId").text("아이디를 입력해주세요.");
    $(".id-flex").css("border-bottom", "1px solid #ff4d78");
    $("#checkPw").text("휴대폰 번호를 입력해주세요.");
    $(".pw-flex").css("border-bottom", "1px solid #ff4d78");
    $("#checkSMSNumber").text("인증번호를 입력해주세요.");
    $(".checkNumber-flex").css("border-bottom", "1px solid #ff4d78");
    $(".id-input").focus();
    return;
  }

  if (!($("#userPhoneNumber").val())) {
    $("#checkPw").text("휴대폰 번호를 입력해주세요.");
    $(".pw-flex").css("border-bottom", "1px solid #ff4d78");
    $(".pw-input").focus();
    return;
  }
  if (!($("#checkNumber").val())) {
    $("#checkSMSNumber").text("인증번호를 입력해주세요.");
    $(".checkNumber-flex").css("border-bottom", "1px solid #ff4d78");
    $(".id-input").focus();
    return;
  }
  loginForm.submit();
}

function next() {
  $("#idFind").submit();
}

//이메일 입력방식 선택
$("#selectEmail").change(function () {
  $("#selectEmail option:selected").each(function () {
    if ($(this).val() == "1") {
      //직접입력일 경우
      $("#userEmailDomain").val(""); //값 초기화
      $("#userEmailDomain").attr("disabled", false); //활성화
    } else {
      //직접입력이 아닐경우
      $("#userEmailDomain").val($(this).text()); //선택값 입력
      $("#userEmailDomain").attr("disabled", true); //비활성화
    }
  });
});
