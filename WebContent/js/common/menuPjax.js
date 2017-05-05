/**
 *
 */
$(function(){//これがないとダメ
	var Pjax = require('pjax-api').Pjax;
	var url = null;
	$("#marketing-analisis").on("click",function(){//これに全部合わせていく

		new Pjax({
			  areas: [
			    // try to use the first query.
			    '#contents',
			    // fallback.
			    'body'
			  ],load : { script: true } //遷移先のインラインスクリプトを読み込む
		});
	});

	$("#marketing-analisis-product").on("click",function(){

		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/marketing_analysis_product.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: "#contents",
		    fragment:  "#contents"
		  });
	});

	$("#sales-analisis").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/sales_analysis.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: "#contents",
		    fragment:  '#contents'
		  });
	});

	$("#ordering-management").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});
	$("#inventory-management").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#daily-report-management").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/daily_report.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#sales-management").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/sales_manager.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#goods-register").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/product_register.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#goods-update").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/product_update.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#sales-register").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/retails/",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#user_info").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/common/update.jsp",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});

	$("#others").on("click",function(){
		$.pjax({
		    url:"http://localhost:8080/PosSystem/common/",
		    load : { script: true }, //遷移先のインラインスクリプトを読み込む
		    container: '#contents',
		    fragment:  '#contents'
		  });
	});
});