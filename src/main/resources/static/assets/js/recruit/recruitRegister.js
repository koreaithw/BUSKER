// 아티스트 계정 등록
$("#recru-image").click(function () {
    let artistFileInput = document.getElementById("recru-file-input");
    artistFileInput.click();
  });


$("#recru-form-submit").on("click", function(e) {
  if(!$("#recru-title").val()) {
    $(".detail-title p").show();
    return false;
  }else {
    $(".detail-title p").hide();
  }
  if(!$("#recru-location").val()) {
    $("p.recru-location").show();
    return false;
  }else {
    $(".recru-location").hide();
  }
  if(!$("#recru-day").val()) {
    $("p.recru-day").show();
    return false;
  }else {
    $(".recru-day").hide();
  }
  if(!$("#recru-time").val()) {
    $("p.recru-time").show();
    return false;
  }else {
    $(".recru-time").hide();
  }
  if(!$("#recru-notice").val()) {
    $("p.recru-notice").show();
    return false;
  }else {
    $(".recru-notice").hide();
  }
  if(!$("#recru-summary").val()) {
    $("p.recru-summary").show();
    return false;
  }else {
    $(".recru-summary").hide();
  }
  if(!$("#recru-introduce").val()) {
    $("p.recru-introduce").show();
    return false;
  }else {
    $(".recru-introduce").hide();
  }
  if(!$("#recru-requirement").val()) {
    $("p.recru-requirement").show();
    return false;
  }else {
    $(".recru-requirement").hide();
  }
  if(!$("#recru-information").val()) {
    $("p.recru-information").show();
    return false;
  }else {
    $(".recru-information").hide();
  }

  alert("등록이 완료되었습니다.");
  $("Form#registerForm").submit();
  return true;
});