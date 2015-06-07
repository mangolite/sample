utils.define("ox.register").extend('spamjs.module').as(function(registration,_instance_) {
	
	_instance_._init_ = function(){
		this.router = utils.module("jqrouter").instance();
		//Set View
		var self = this;
		console.log("init register module")
		this.view('ox.register.html').done(function(){
			$('.navbar-search').hide();
		});
		
	};
	
	_instance_._view_ = function(){
		var self = this;
		this.router.on("#/tab/{tab}", function(tab){
			console.log("/tab/{tab}",tab)
			self.$$.find(".reg_tabs").val(tab)
		}).otherwise("#/tab/general");
	};
	
	_instance_._remove_ = function(){
		this.router.off();
	};
	
});