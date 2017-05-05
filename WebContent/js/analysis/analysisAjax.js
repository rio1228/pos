/**
 *analysis
 */
$(function(){//これがないとダメ
	var url = null;

	$("#sex").on("click",function(){
		alert("あいう");
		$.ajax({
			type: "POST",
			url : "http://localhost:8080/PosSystem/SexAnalysis",
			dataType: 'jsonp',
			//timeout:10000,
			success : function(data) {
				ccchart.init('chart_pie', data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
			}
		});
	});

	$("#age").on("click",function(){

		$.ajax({
			type: "POST",
		    url:"http://localhost:8080/PosSystem/AgeAnalysis",
			dataType: 'jsonp',
			//timeout:10000,
			success : function(data) {
				ccchart.init('chart_pie', data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
			}
		});
	});

	$("#price").on("click",function(){

		$.ajax({
			type: "POST",
		    url:"http://localhost:8080/PosSystem/PriceAnalysis",
			dataType: 'jsonp',
			//timeout:10000,
			success : function(data) {
				ccchart.init('chart_pie', data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
			}
		});
	});

	$("#wine").on("click",function(){

		$.ajax({
			type: "POST",
		    url:"http://localhost:8080/PosSystem/WineAnalysis",
			dataType: 'jsonp',
			//timeout:10000,
			success : function(data) {
				ccchart.init('chart_pie', data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
			}
		});
	});
});