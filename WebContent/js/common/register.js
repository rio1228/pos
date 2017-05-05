/**
 *
 */
$(function(){//これがないとダメ

	 retailProductTable = null;
	 sum = null;
	 summary = null;
	 zip = null;
	 wheather = null;
	 temp = null;

	var priceArray = [];
	var productCodeArray =[];
	var quantitiyArray =[];

	var totalPrice = 0;
	var base_url="http://api.openweathermap.org/data/2.5/weather";

	$("#keypad").val("");
	$("input[name='sex']:checked").val("1");
	$("#age_select").val("0");

	$.ajax({
		type: "POST",
		url : "http://localhost:8080/PosSystem/RetailProductServlet",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "jsonp",//追加
		timeout:10000,
	}).done(function(data){
		retailProductTable = data.retailProductTable;
		zip = data.zip;
		console.log(zip);

		$.ajax({
			url: base_url+"?zip="+zip+",jp&units=metric&appid=9d9720b59f64a70a70ec591c66245050",
			}).done(function(weatherdata){
			wheather = weatherdata.weather[0].description;
			temp = weatherdata.main.temp;
			if(wheather =="clear sky" || wheather =="few clouds"){
				wheather = 1;
				$("main").css("background-color","red");
			}else if(wheather =="scattered clouds" || wheather =="broken clouds"){
				wheather = 2;
				$("main").css("background-color","grey");
			}else if(wheather =="snow"){
				wheather = 4;
				$("main").css("background-color","sky blue");
			}else{
				wheather = 3;
				$("main").css("background-color","blue");
			}
			if(temp > 30){
				temp = 1;

			}else if(temp > 15 && temp < 29.9){
				temp = 2;

			}else if(temp > 5 && temp < 15){
				temp = 3;
			}else if(temp < 5){
				temp = 4;
			}
			console.log(wheather);
			console.log(temp);
			// img insert
			/*var img = document.createElement('img');
			img.src = "http://openweathermap.org/img/w/"+weatherdata.weather[0].icon+".png";
			img.alt = weatherdata.weather[0].main;
			document.getElementById('icon').appendChild(img);

			// 位置
			document.getElementById('here').innerHTML = weatherdata.name;*/
		}).fail(function(error){
			$.ajax({
				url: base_url+"?zip="+zip+",jp&units=metric&appid=9d9720b59f64a70a70ec591c66245050",
				}).done(function(weatherdata){
				wheather = weatherdata.weather[0].description;
				temp = weatherdata.main.temp;
				if(wheather =="clear sky" || wheather =="few clouds"){
					wheather = 1;
					$("main").css("background-color","red");
				}else if(wheather =="scattered clouds" || wheather =="broken clouds"){
					wheather = 2;
					$("main").css("background-color","grey");
				}else if(wheather =="snow"){
					wheather = 4;
					$("main").css("background-color","sky blue");
				}else{
					wheather = 3;
					$("main").css("background-color","blue");
				}
				if(temp > 30){
					temp = 1;

				}else if(temp > 15 && temp < 29.9){
					temp = 2;

				}else if(temp > 5 && temp < 15){
					temp = 3;
				}else if(temp < 5){
					temp = 4;
				}
				console.log(wheather);
				console.log(temp);
				// img insert
				/*var img = document.createElement('img');
				img.src = "http://openweathermap.org/img/w/"+weatherdata.weather[0].icon+".png";
				img.alt = weatherdata.weather[0].main;
				document.getElementById('icon').appendChild(img);

				// 位置
				document.getElementById('here').innerHTML = weatherdata.name;*/
			}).fail(function(error){
				$.ajax({
					url: base_url+"?zip="+zip+",jp&units=metric&appid=9d9720b59f64a70a70ec591c66245050",
					}).done(function(weatherdata){
					wheather = weatherdata.weather[0].description;
					temp = weatherdata.main.temp;
					if(wheather =="clear sky" || wheather =="few clouds"){
						wheather = 1;
						$("main").css("background-color","red");
					}else if(wheather =="scattered clouds" || wheather =="broken clouds"){
						wheather = 2;
						$("main").css("background-color","grey");
					}else if(wheather =="snow"){
						wheather = 4;
						$("main").css("background-color","sky blue");
					}else{
						wheather = 3;
						$("main").css("background-color","blue");
					}
					if(temp > 30){
						temp = 1;

					}else if(temp > 15 && temp < 29.9){
						temp = 2;

					}else if(temp > 5 && temp < 15){
						temp = 3;
					}else if(temp < 5){
						temp = 4;
					}
					console.log(wheather);
					console.log(temp);
					// img insert
					/*var img = document.createElement('img');
					img.src = "http://openweathermap.org/img/w/"+weatherdata.weather[0].icon+".png";
					img.alt = weatherdata.weather[0].main;
					document.getElementById('icon').appendChild(img);

					// 位置
					document.getElementById('here').innerHTML = weatherdata.name;*/
				}).fail(function(error){
					$.ajax({
						url: base_url+"?zip="+zip+",jp&units=metric&appid=9d9720b59f64a70a70ec591c66245050",
						}).done(function(weatherdata){
						wheather = weatherdata.weather[0].description;
						temp = weatherdata.main.temp;
						if(wheather =="clear sky" || wheather =="few clouds"){
							wheather = 1;
							$("main").css("background-color","red");
						}else if(wheather =="scattered clouds" || wheather =="broken clouds"){
							wheather = 2;
							$("main").css("background-color","grey");
						}else if(wheather =="snow"){
							wheather = 4;
							$("main").css("background-color","sky blue");
						}else{
							wheather = 3;
							$("main").css("background-color","blue");
						}
						if(temp > 30){
							temp = 1;

						}else if(temp > 15 && temp < 29.9){
							temp = 2;

						}else if(temp > 5 && temp < 15){
							temp = 3;
						}else if(temp < 5){
							temp = 4;
						}
						console.log(wheather);
						console.log(temp);
						// img insert
						/*var img = document.createElement('img');
						img.src = "http://openweathermap.org/img/w/"+weatherdata.weather[0].icon+".png";
						img.alt = weatherdata.weather[0].main;
						document.getElementById('icon').appendChild(img);

						// 位置
						document.getElementById('here').innerHTML = weatherdata.name;*/
					}).fail(function(error){
						alert("天気情報取得失敗")
					});
				});
			});
		});
	}).fail(function(data){
		alert("登録されている商品が存在しないかエラーが起きています")
	});

	$("#insert").on("click",function(){//商品名を入力したときに呼び出されるメソッド
		//リクエスト用のオブジェクトに値を詰め込む
		var totalPrice = 0;
		var productCode = $("#reader").val();
		var i = 0;
		while(i!=-1 || i<retailProductTable.length){
			var productCheckCode = retailProductTable[i][1]
			if(productCode == productCheckCode){
				productCodeArray.push(productCode);
				quantitiyArray.push("1");
				console.log(productCodeArray);
				var name = retailProductTable[i][2];
				var price = retailProductTable[i][3];
				priceArray.push(price);//まず0番目にデータが入ってる
				console.log(priceArray);
				price = price.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
				$("#register_body").append($("<tr></tr>")
						 .append($('<td></td>').text(name).addClass('productName'))
		                 .append($('<td></td>').text(1+"本").addClass('num'))
		                 .append($('<td></td>').text("\\"+price).addClass('subPrice'))
				);
				i = -1;
				 $("#reader").val("");
				 for(var j = 0;j<priceArray.length;j++){
					 var plusPrice = priceArray[j];
					 plusPrice = Number(plusPrice);
					 totalPrice = totalPrice+plusPrice;
				 }
				 console.log(totalPrice)
				 var tax = totalPrice*0.08;
				 tax = Math.floor(tax);
				 var sum = totalPrice + tax;
				 totalPrice = String(totalPrice);
				 tax = String(tax);
				 sum = String(sum);
				 totalPrice = totalPrice.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
				 tax = tax.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
				 sum = sum.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
				 $("#totalprice").html($('<P>\\'+totalPrice+'</P>'));
				 $("#tax").html($('<P>\\'+tax+'</P>'));
				 $("#summary").html($('<P>\\'+sum+'</P>'));
				 var product_num = $("#register_body tr").length
				 $("#product_quantity").html($('<P>数量：'+product_num+'点</P>'));
			}else{
				i++;
			}
		}

	});
	$(".button").on("click",function(){//あらかじめ設定している商品ボタンが押された時の処理
		var totalPrice = 0;
		var index = $('.button').index(this);
		var productCodeButton = $(".button").eq(index).val();
		var i = 0;
		try {
			while(i!=-1 || i<retailProductTable.length){
				var productCheckCode = retailProductTable[i][1];
				if(productCodeButton == productCheckCode){
					productCodeArray.push(productCodeButton);
					quantitiyArray.push("1");
					console.log(productCodeArray);
					console.log(quantitiyArray);
					var name = retailProductTable[i][2];
					var price = retailProductTable[i][3];
					priceArray.push(price);//まず0番目にデータが入ってる
					console.log(priceArray);
					price = price.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
					$("#register_body").append($("<tr></tr>")
				                  .append($('<td></td>').text(name).addClass('productName'))
				                  .append($('<td></td>').text(1+"本").addClass('num'))
				                  .append($('<td></td>').text("\\"+price).addClass('subPrice'))
					);
					var i = -1;
					 $("#reader").val("");
					 for(var j = 0;j<priceArray.length;j++){
						 var plusPrice = priceArray[j];
						 plusPrice = Number(plusPrice);
						 totalPrice = totalPrice+plusPrice;
					 }
					 console.log(totalPrice)
					 var tax = totalPrice*0.08;
					 tax = Math.floor(tax);
					 sum = totalPrice + tax;
					 totalPrice = String(totalPrice);
					 summary = sum;
					 tax = String(tax);
					 summary = String(summary);
					 totalPrice = totalPrice.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
					 tax = tax.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
					 summary = summary.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
					 $("#totalprice").html($('<P>\\'+totalPrice+'</P>'));
					 $("#tax").html($('<P>\\'+tax+'</P>'));
					 $("#summary").html($('<P>\\'+summary+'</P>'));
					 var product_num = $("#register_body tr").length
					 $("#product_quantity").html($('<P>数量：'+product_num+'点</P>'));
					}else{
						i++;
					}
			}
		} catch(e) {
			console.log(e);
		}
	});
	$(".num td").on("dblclick",function(){
		//alert("seikou ")
	});
	$("#keypad").on("change",function(){
		var deposit =$("#keypad").val();//預り金の値を取得
		var oturi = deposit-sum;//預り金と総合計を計算
		oturi = String(oturi);
		oturi = oturi.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );
		$("#change").html($('<P>\\'+oturi+'</P>'));
	});
	/*
	$(".productcode9").on("change",function(){//商品名を変更したときに呼び出されるメソッド
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj9.message = $(".productcode9").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson9 = $.toJSON(requestObj9);
		$.ajax({
			type: "POST",
			url : "http://localhost:8080/PosSystem/RegisterArray",
			data: {requestJs9 : requestJson9},
			dataType: 'jsonp',
			timeout:10000,
			success : function(data9) {
				getVal9 = (data9);//商品名の単価を取得
				$(".number9").spinner( "value", 1 );
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
			}
		});
	});


	$(".number0").spinner({//こっからスピナー
	    max: 100,//最大値
	    min: 1,//最小値
	    step: 1,//ステップ数
	    icons: {
	    	down: "ui-icon-arrow-1-s",
	    	up: "ui-icon-arrow-1-n"
	    },

	    spin: function( event, ui ) {//上下ボタンで値を変更したとき
	    	var count =  ui.value;
            subTotal0 = Math.floor((count * getVal0)*1.08);
    		$(".subprice0").text("\\"+subTotal0);
    		totalPrice = (subTotal0 + subTotal1 + subTotal2 + subTotal3 + subTotal4 + subTotal5 + subTotal6 + subTotal7 + subTotal8 + subTotal9);
    		$("#totalprice").text("\\"+totalPrice);

        },

        change: function(event, ui) {//テキストエリアで値を直接変更したとき
        	var count = $( ".number0" ).val();
            console.log(count);
            subTotal0 = Math.floor((count * getVal0)*1.08);
            $(".subprice0").text("\\"+subTotal0);
    		totalPrice = (subTotal0 + subTotal1 + subTotal2 + subTotal3 + subTotal4 + subTotal5 + subTotal6 + subTotal7 + subTotal8 + subTotal9);
    		$("#totalprice").text("\\"+totalPrice);
        }
    });

	*/

	$("#deposit").on("click",function(){//預り金を入力したときに呼び出されるメソッド

		sexObj =  $('input[name="sex"]:checked').val();
		ageObj = $("#age_select").val();

		$.ajax({
			type: "POST",
			url : "http://localhost:8080/PosSystem/RegisterInsert",
			data: { productCodeJson : productCodeArray,//productcode配列
				     countJs : quantitiyArray,/*次はここ数量*/
				        sexJs : sexObj,//性別
				        ageJs : ageObj,
				        tempJs: temp,
				        wheatherJs: wheather},//年齢層

			dataType:"json",
		    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			timeout:10000,
	    }).done(function(){
	    	$("#keypad").val("");
	    	$('input[name="sex"]:checked').val("1");
	    	$("#age_select").val("0");
	    }).fail(function(XMLHttpRequest, textStatus, errorThrown){
	    	alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
		});
	});
});