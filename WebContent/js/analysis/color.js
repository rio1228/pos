/**
 *
 */
$(function() {
	/**
	 * 背景をランダムで変更するメソッド
	 */
	function randomColor(node, colorBoolean) {
	    if (node[0]) {
	        if (!node[0].nodeName) return
	    } else {
	        if (!node.nodeName) return
	    }
	    if (node.style) {
	        var dom = [node];
	        length = 1;
	    } else {
	        if (!node[0].style) {
	            return
	        }
	        var dom = node;
	        length = node.length;
	    }
	    for (var i = 0; i < length; i++) {
	        var colorR = ~~(10 * Math.random());
	        var colorG = ~~(256 * Math.random());
	        var colorB = ~~(256 * Math.random());
	        dom[i].style.backgroundColor = "rgb(" + colorR + "," + colorG + "," + colorB + ")";
	        if (colorBoolean) {
	            if (colorR + colorG + colorB > 382.5) {
	                var fontColor = "#333";
	            } else {
	                var fontColor = "#fff";
	            }
	            dom[i].style.color = fontColor;
	        }
	    }
	}
	var array = ["yellow","fuchsia","aqua","lime","white","#ff00ff","red"];

	var l = array.length;
	var r = Math.floor(Math.random()*l);
	var imgcolor = array[r];
	$(".drawer-hamburger-icon").css({"background-color":imgcolor});
		//randomColor($(".drawer-hamburger-icon"), true);

});