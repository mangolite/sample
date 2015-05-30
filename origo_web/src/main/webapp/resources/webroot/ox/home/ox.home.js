utils.define("ox.home").extend('spamjs.module').as(function(home,_instance_) {
	
	var STOMP = utils.module('tunnel.stomp');
	var TOPBAR = utils.module('ox.topbar');
	
	//module Initializer
	_instance_._init_ = function(){
		//Set View
		var self = this;
		this.view('ox.home.html').done(function(){
			console.info("ox.home.html is loaded and set to view")
		}).done(function(){
			self.add("#inner_topbar",TOPBAR.instance({
				id : "topbar" 
			}));	
		})
	};
	
});