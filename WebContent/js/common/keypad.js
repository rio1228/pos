/**
 *
 */
$(function(){//これがないとダメ
	$("#keypad").keypad({separator: '|', prompt: '',
		  layout: ['7|8|9|'+$.keypad.BACK,'4|5|6|'+$.keypad.CLEAR,'1|2|3|'+$.keypad.CLOSE,'0|00'],
		  keypadOnly: false
		});
});