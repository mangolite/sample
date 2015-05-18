utils.define("ox.home").extend('spamjs.module').as(function(home,_instance_) {
	
	var STOMP = utils.module('tunnel.stomp');
	var NAVBAR = utils.module('ox.navbar');
	
	//module Initializer
	_instance_._init_ = function(){
		//Set View
		this.view('ox.home.html').done(function(){
			console.info("ox.home.html is loaded and set to view")
		}).done(function(){
//			NAVBAR.instacne({
//				//id : 
//			})
		})
		this.$$.on("jqrouter.key.x", function(e,data){
			console.warn("eeee",e,data)
		});
		
		
	};
	
});