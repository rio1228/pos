/**
 *
 */
$(function(){//これがないとダメ
	var url = null;
	var Pjax = require('pjax-api').Pjax;
	$("#home_pie").on("click",function(){

		new Pjax({
			  areas: [
			    // try to use the first query.
			    '#analysis',
			    // fallback.
			    'body'
			  ],load : { script: true } //遷移先のインラインスクリプトを読み込む
		});
	});

	$("#sex_pie").on("click",function(){

		new Pjax({
			  areas: [
			    // try to use the first query.
			    '#analysis',
			    // fallback.
			    'body'
			  ],load : { script: true } //遷移先のインラインスクリプトを読み込む
		});
	});

	$("#weather_pie").on("click",function(){
		new Pjax({
			  areas: [
			    // try to use the first query.
			    '#analysis',
			    // fallback.
			    'body'
			  ],load : { script: true } //遷移先のインラインスクリプトを読み込む
		});
	});

	$("#temp_pie").on("click",function(){
		new Pjax({
			  areas: [
			    // try to use the first query.
			    '#analysis',
			    // fallback.
			    'body'
			  ],load : { script: true } //遷移先のインラインスクリプトを読み込む
		});
	});
	$("#human_pie").on("click",function(){
		new Pjax({
			  areas: [
			    // try to use the first query.
			    '#analysis',
			    // fallback.
			    'body'
			  ],load : { script: true } //遷移先のインラインスクリプトを読み込む
		});
	});
});