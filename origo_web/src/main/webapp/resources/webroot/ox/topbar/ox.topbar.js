utils.define("ox.topbar").extend('spamjs.module').as(function(topbar,_instance_) {
	
	var STOMP = utils.module('tunnel.stomp');
	
	//module Initializer
	_instance_._init_ = function(){
		//Set View
		this.load({
			src : "ox.topbar.html",
			data : {}
		}).done(function(){
			console.info("ox.home.html is loaded and set to view")
		})
		
		this.model({
			age : 45
		})
		this.data({
			name : "Neeraj"
		});
		
		this.$$.trigger("asas")
		
		
	};
	
});