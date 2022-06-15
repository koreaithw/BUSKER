
            $(function(){ // 가운데 메뉴 마우스 오버하면 2뎁스 나타나게 + 헤더 커지게 하는 소스
			$(".pf-center h2").on('mouseenter',function(){
				$(".pf-center h2").find("a").removeClass("on");
				$(".pf-center h2").find("div").css("display","none");
				$(".pf-center h2").css("height","auto");
				$(this).find("a").addClass("on");
				$(this).find("div").css("display","block");
				$(this).css("height","60px");
				$(".perform-top").animate({
					height: "140px"
				 }, 300);
			});
			$(".perform-top").on('mouseleave',function(){
				$(".pf-center h2").find("a").removeClass("on");
				$(".pf-center h2").find("div").css("display","none");
				$(".pf-center h2").css("height","auto");
				$(".perform-top").animate({
					height: "100px"
				 }, 300);
			});
		});






        $(function(){
         if ($.cookie("EXanadu") != null || $.cookie("Benefit") == "2314") {
            $(".consice").hide();
            $(".perform-top").css("top", "0px");
            $("#pf-gnb-wrap").css("top", "0px");

            if(1 == 1){ //장르메인
                $(".cp-top-wrap").next().css("top", "100px");
                $("section").first().css("padding-top", "100px");
            }
            else if(1 == 2){ //상세,경량화상세
                $(".renew-wrap").css("top", "100px");
            }
            else if(1 == 3){ //장르리스트
                $(".list-sec").css("padding-top","100px");
            }
            else{ //그 외
                $(".content-min-wrap").css("padding-top", "100px");

                if(1 == 4){ //검색
                    $(".srch-scroll-slide").css("padding-top","100px");
                }
            }
        }
    });







    /*스크롤하면 600px쯤에서 헤더부분 다시 보이게*/
	$(window).on('scroll',function(){
		var sctop = $(this).scrollTop();
		var sPath = window.location.pathname;
		var sPage = sPath.substring(sPath.lastIndexOf('/') + 1);

		//console.log(sPage);
		if(sctop>=600){
			$("#perform-top").addClass("fixed");
			$("#pf-gnb-wrap").addClass("re-top");
			$("#pf-gnb-wrap").removeClass("sub-top");

			if($.cookie("EXanadu") != null || $.cookie("Benefit") == "2314"){
				$("#perform-top").css("top","0px");
				$("#pf-gnb-wrap").css("top","0px"); 
				$("#consice").hide();
			}
			else{
				$("#consice").addClass("on");
				$("#consice").css("position","fixed");
			}

			$("body").css("padding-top","134px");
		}else{
			$("#perform-top").removeClass("fixed");
			$("#pf-gnb-wrap").removeClass("re-top");
			$("#pf-gnb-wrap").addClass("sub-top");

			if($.cookie("EXanadu") != null || $.cookie("Benefit") == "2314"){
				$("#perform-top").css("top","0px");
				$("#pf-gnb-wrap").css("top","0px"); 
				$("#consice").hide();
			}
			else{
				$("#consice").removeClass("on");
				$("#consice").css("position","relative");
			}

			$("body").css("padding-top","0");
		}

		if(sctop<=34){
			$("#pf-gnb-wrap").removeClass("sub-top");
		}

		
		//위로 올라가는 버튼 나타나게
		// if(sctop>0){
		// 	$(".return-top").addClass("on");
		// }else{
		// 	$(".return-top").removeClass("on");
		// }
	});


    //반응형 부분
	$( window ).resize(function() {
		/*헤더*/
		var wwidth = $(window).width();
		if(wwidth<1780){
			var pfc = 1780-wwidth;
			var pfcwidth = 580-pfc;
			if(pfcwidth>=230){
				$(".pf-center").css({"left":pfcwidth+"px","transform":"none"});
			}else{
				$(".pf-center").css({"left":"230px","transform":"none"});
			}			
		}else{
			$(".pf-center").css({"left":"50%","transform":"translate(-50%,0)"});
		}
		/*wing-list*/		
		$(".wing-box").removeAttr("style");
		$(".wing-list a").removeAttr("style");
	});

	//햄버거메뉴 슬라이드 라이브러리 사용
	$(".pf-gnb-box").mCustomScrollbar({
	});	



        