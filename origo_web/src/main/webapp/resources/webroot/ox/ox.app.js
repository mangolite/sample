utils.define("ox.app").extend("spamjs.module").as(function(app,_app_) {
	
	utils.module('bootstrap');
	var PIPE = utils.module('tunnel.pipe');
	var ROUTER = utils.module('jqrouter');
	var USER = utils.module('ox.user');
	//Load HTML tags
	utils.require('jqtags.test','jqtags.switch');
	
	/**
	 *  ._init_ is instance level event-method pre-defined and directed by spamjs.module
	 * 
	 */
	_app_._init_ = function(){
		var self = this;
		self.pipe = PIPE.instance();
		self.router = ROUTER.instance();
		
		/*
		 * We will check if user is logged in or not 
		 * 
		 */
		USER.validate().done(function(resp){
			var MAIN_MODULE = utils.module("ox.main");
			if(resp.success === true){
					
				self.add(MAIN_MODULE.instance({
					id : "super_module"
				}));
				
			} else {
				/*
				 * User is not logged in, so lets ask him to enter his creds,
				 * 
				 */
				var SIGNUP = utils.module("ox.signup");

				self.add(SIGNUP.instance({
					id : "super_module"
				}));

				/*
				 * spamjs comes with this method pipe, which is always recommned instead if using native pipe instance of tunnel.pipe, 
				 * as it also takes care of un-binding of pipe-events when module is unloaded, 
				 * otherwise developer has to manually call pipe.off method to unbind.
				 * 
				 * here we are listeing to pipe event so that when login is done we can start main module
				 * 
				 */
				self.pipe.on("ox.user.login.done", function(){
					self.add(MAIN_MODULE.instance({
						id : "super_module"
					}));
				});
			}
			
		});	
		
		/* 
		 * Logout url Mapping
		 */
		self.router.on("/ox/logout",function(e){
			/*
			 * Tell server that user wants to logout
			 */
			USER.unauth().done(function(resp){
				/*
				 * Server has invalidated the session, now reload the application to main page
				 */
				self.router.reload("/ox");
			});
		});
		
	};
	
	_app_._remove_ = function(){
		this.pipe.off();
		this.router.off();
	};
	
	
	/**
	 * _ready_ method is triggered when module is loaded and
	 * doc is ready to handler DOM operations
	 */
	app._ready_ = function(){
		app.instance().init();
	};
});