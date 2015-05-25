utils.define("ox.app").extend("spamjs.module").as(function(app,_app_) {
	
	utils.module('bootstrap');
	var server = utils.module('tunnel.server');
	var pipe = utils.module('tunnel.pipe');
	var router = utils.module('jqrouter');
	//Load HTML tags
	utils.require('jqtags.test','jqtags.switch');
	
	var main_module = null;

	/**
	 *  ._init_ is instance level event-method pre-defined and directed by spamjs.module
	 * 
	 */
	_app_._init_ = function(){
		var self = this;
		self.pipe = pipe.instance();
		self.router = router.instance();
		/*
		 * We will check if user is logged in or not 
		 * 
		 */
		server.post("user/isValid").done(function(resp){
			if(resp.success === true){
					
				self.load_main_module();
				
			} else {
				/*
				 * User is not logged in, so lets ask him to enter his creds,
				 * 
				 */
				var SIGNUP = utils.module("ox.signup");

				self.add(SIGNUP.instance({
					id : "signup"
				}));

				/*
				 * spamjs comes with this method pipe, which is always recommned instead if using native pipe instance of tunnel.pipe, 
				 * as it also takes care of un-binding of pipe-events when module is unloaded, 
				 * otherwise developer has to manually call pipe.off method to unbind.
				 * 
				 * here we are listeing to pipe event so that when login is done we can start main module
				 * 
				 */
				self.pipe.on("ox.login.done", function(){
					self.remove("signup")
					self.load_main_module();
				});
			}
			
		});
		
	};
	
	_app_.load_main_module = function(){
		var self = this;
		self.add(utils.module("ox.navbar").instance());
		self.add(utils.module("ox.sidebar").instance());
		
		main_module = utils.module("ox.main").instance();
		self.add(main_module);
		
		/*
		 * here we are listening to pipe event so that when main methis is ready wehn can bind-routing events
		 * 
		 */
		self.pipe().on("ox.main.ready", function(){
			app.add_routing(main_app);
		});
		
		/* 
		 * Logout url Mapping
		 */
		router.on("/ox/logout",function(e){
			/*
			 * Tell server that user wants to logout
			 */
			server.post( "user/logout",{}).done(function(resp){
				/*
				 * Server has invalidated the session, now reload the application to main page
				 */
				router.reload("/ox");
			});
		});
		
	};
	
	_app_._remove_ = function(){
		this.pipe.off();
		this.router.off();
	};
	
	
	/**
	 *  A custom method to add url routing when user is logged in
	 * 
	 */
	app.add_routing = function(){
		
		/**
		 *  Custom method of app, to add module to main_module, it will unload the current app loaded
		 *  in main_module and add specified module
		 * 
		 */
		
		router.on("/ox/home",function(e){
			main_module.add(utils.module("ox.home").instance({
				id : "main_module"
			}));
		});
		
		router.on("/ox/mywall",function(e){
			main_module.add(utils.module("ox.mywall").instance({
				id : "main_module"
			}));
		});

	};
	

	/**
	 * _ready_ method is triggered when module is loaded and
	 * doc is ready to handler DOM operations
	 */
	app._ready_ = function(){
		app.instance().init();
	};
});