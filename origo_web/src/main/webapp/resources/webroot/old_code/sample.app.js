utils.define("sample.init").as(function(init) {
	
	utils.require('utils.custom','utils.custom.tag');
	utils.require('sample.formattypes',':jqgeeks/jquery-ui',":jqgeeks/bootstrap");
	utils.require(":jqgeeks/mvc",":jqgeeks/tunnel",":sample/login",":sample/chat");
	
	var loginMod = utils.module("sample.login");
	var stomp = utils.module('tunnel.stomp');
	/**
	 * _ready_ method is triggered when module is loaded and
	 * doc is ready to handler DOM operations
	 */
	init._ready_ = function(){
		
		var loginIns =  loginMod.instance({ 
			def : { "username" : "admin", "password" : "", auto : true},
			onLogin : function(){
				console.log("yes logged in");
				var chatMod = utils.module("sample.chat");
				chatIns = chatMod.instance();
				$("#loginSection").hide();
				$("#chatSection").show();
				chatIns.init({
					id : '#chatSection'
				})
				stomp.connect();
			}
		});
		loginIns.init({
			id : "#loginContainer"
		});
		
		
	};
});