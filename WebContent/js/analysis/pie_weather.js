/**
 *
 */
$(function() {
	$.ajaxSetup({scriptCharset:'utf-8'});
	/**
	 * 円グラフを作るためのajax
	 */
	$.ajax({
		type: "POST",
		url : "http://localhost:8080/PosSystem/SaleAnalysisWeatherServlet",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		timeout:10000,
	}).done(function(data){
			var graphPie = JSON.parse(data);
			ccchart.init('chart_pie', graphPie);
	}).fail(function(XMLHttpRequest, textStatus, errorThrown){
		alert("ログインしてください");
	});

	/**
	 * 似た属性の商品を出すためのajax
	 */
	$.ajax({
		type: "POST",
		url : "http://localhost:8080/PosSystem/AllSuggestServlet",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "jsonp",//追加
		timeout:10000,
	}).done(function(data){
		var suggestTable = data.suggestTable
		var suggestForModal = data.suggestForModal;
		for (var i = 0; i < suggestTable.length-1; i++) {
			var name = suggestTable[i][4]
			var price = suggestTable[i][9]
			var productcode =  suggestTable[i][3]
			var pic = suggestTable[i][10]
			$("#popularTable").append($("<tr></tr>")
			                  .append($('<td><img src="'+pic+'" alt="画像を表示できません" width="60px" height="50px"></td>'))
			                  .append($('<td></td>').text(name))
			                  .append($('<td><BUTTON>詳細</BUTTON></td>'))
		    );
			$('td').eq(0).addClass('pic');
			$('td').eq(1).addClass('productname');
			$('#popularTable BUTTON').addClass('detail');
			var j = 0;
			while (j != -1) {
				var productcode2 = suggestForModal[j][2]
				if(productcode == productcode2){
					var campanyname = suggestForModal[j][1]
					var price = suggestForModal[j][4]
					price = price.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
					$("#modalDiv").append($('<div></div>')
								  .append($('<BUTTON></BUTTON>'))
								  .append($('<h1>詳細</h1>'))
								  .append($('<img src="'+pic+'" alt="画像を表示できません" width="260px" height="250px"></td>'))
								  .append($('<h2></h2>').text(name))
								  .append($('<table></table>')
								  .append($('<tr></tr>')
										  .append($('<th></th>').text("企業名"))
										  .append($('<th></th>').text("価格"))
										  .append($('<th></th>').text("数量"))
										  .append($('<th></th>').text("納品日"))
										  .append($('<th></th>').text("発注"))
								  )
								  .append($('<tr></tr>')
										  .append($('<td></td>').text(campanyname))
							              .append($('<td></td>').text('\\'+price))
							              .append($('<td></td>').text("1ケース(6本)"))
							              .append($('<td></td>').text('3日'))
							              .append($('<td><BUTTON>発注する</BUTTON></td>'))
								  ))
								  .append($('<BUTTON>すべてキャンセルする</BUTTON>'))
								  .append($('<BUTTON>確定する</BUTTON>'))
					);
					$("#modalDiv div").eq(i).addClass('remodal');//一つ目にしかかからない理由は一つ目のテーブルにしかクラスdata属性をつけてないから
					$("#modalDiv div").eq(i).attr({'data-remodal-id': 'modal'+i,'data-remodal-options': 'hashTracking:false'});
					$("#modalDiv BUTTON").eq(0).addClass('remodal-close');
					$("#modalDiv BUTTON").eq(0).attr({'data-remodal-action': 'close',});
					$("#modalDiv BUTTON").eq(1).addClass('dicision');
					$("#modalDiv BUTTON").eq(2).addClass('remodal-cancel');
					$("#modalDiv BUTTON").eq(2).attr({'data-remodal-action': 'cancel',});
					$("#modalDiv BUTTON").eq(3).addClass('remodal-confirm');
					$("#modalDiv BUTTON").eq(3).attr({'data-remodal-action': 'confirm',});
					$("#modalDiv BUTTON").eq(4).addClass('remodal-close');
					$("#modalDiv BUTTON").eq(4).attr({'data-remodal-action': 'close',});
					$("#modalDiv BUTTON").eq(5).addClass('dicision');
					$("#modalDiv BUTTON").eq(6).addClass('remodal-cancel');
					$("#modalDiv BUTTON").eq(6).attr({'data-remodal-action': 'cancel',});
					$("#modalDiv BUTTON").eq(7).addClass('remodal-confirm');
					$("#modalDiv BUTTON").eq(7).attr({'data-remodal-action': 'confirm',});
					$("#modalDiv BUTTON").eq(8).addClass('remodal-close');
					$("#modalDiv BUTTON").eq(8).attr({'data-remodal-action': 'close',});
					$("#modalDiv BUTTON").eq(9).addClass('dicision');
					$("#modalDiv BUTTON").eq(10).addClass('remodal-cancel');
					$("#modalDiv BUTTON").eq(10).attr({'data-remodal-action': 'cancel',});
					$("#modalDiv BUTTON").eq(11).addClass('remodal-confirm');
					$("#modalDiv BUTTON").eq(11).attr({'data-remodal-action': 'confirm',});
					$("#modalDiv table").addClass('toriatukai');
					j = -1;
				}else {
					j++;
				}
			}
		}
	}).fail(function(data){
		alert("ログインしてください")
	});

	$(document).on("click", ".detail", (function(){
	 var index = $('.detail').index(this);
	$('[data-remodal-id=modal'+index+']').remodal().open();
	}));

	$(document).on("click", ".dicision", (function(){
		$(".dicision").text("発注予定")
		$("#orderTable").append(
		            $("<tr></tr>")
		            	.addClass("order")
		                .append($('<td></td>').text("楽園ワインパック1800ml"))
		                .append($('<td></td>').text("株式会社マルチ"))
		                .append($('<td></td>').text("\\1,000"))
		                .append($('<td></td>').text("2ケース"))
		                .append($('<td></td>').text("\\12,000"))
		                .append($('<td><BUTTON>削除</BUTTON></td>'))
		);
		$("#orderTable BUTTON").addClass('delete');
		$(".dicision").removeClass("dicision").addClass("dicided");
		}));
	$(document).on("click", ".dicided", (function(){
		$(".dicided").text("発注する")
		$("#orderTable .order").remove();
		$(".dicided").removeClass("dicided").addClass("dicision");
		}));
	$(document).on("click", ".delete", (function(){
		$(".dicided").text("発注する")
		$("#orderTable .order").remove();
		$(".dicided").removeClass("dicided").addClass("dicision");
		}));

});