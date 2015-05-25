utils.define("ox.main").extend('spamjs.module').as(function(main,_main_) {
	
	//module Initializer
	_main_._init_ = function(){
		var self = this;
		self.router = utils.module("jqrouter").instance();
		self.add_routing();
	};
	
	main._ready_ =  function(){
		
	};
	
	
	/**
	 *  A custom method to add url routing when user is logged in
	 * 
	 */
	_main_.add_routing = function(){
		var self = this;
		/**
		 *  Custom method of app, to add module to main_module, it will unload the current app loaded
		 *  in main_module and add specified module
		 * 
		 */
		self.router.on("/ox/home",function(e){
			self.add(utils.module("ox.home").instance({
				id : "main_module"
			}));
		}).on("/ox/mywall",function(e){
			self.add(utils.module("ox.mywall").instance({
				id : "main_module"
			}));
		}).otherwise("/ox/home");
	};
	
	_main_._remove_ = function(){
		//this.pipe.off();
		this.router.off();
	};
});