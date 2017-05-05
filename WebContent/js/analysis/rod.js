/**
 *
 */
$(function() {
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		type: "POST",
		url : "http://localhost:8080/PosSystem/SaleAnalysisRod",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		timeout:10000,
		success : function(data) {
			var graphRod = JSON.parse(data);
			ccchart.init('chart_rod',graphRod);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
		}
	});
});
