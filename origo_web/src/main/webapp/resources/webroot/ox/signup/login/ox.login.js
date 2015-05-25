utils.define("ox.login").extend('spamjs.module').as(function(login,_instance_) {
	
	var PIPE = utils.module('tunnel.pipe');
	var ROUTER = utils.module('jqrouter');
	//model Initializer
	_instance_._init_ = function(){
		//Set View
		var self = this;
		self.pipe = PIPE.instance();
		self.router = ROUTER.instance();
		
		this.view('ox.login.html').done(function(){
			self.model({
				username : "admin", 
				password : "",
				company : "",
				status : ""
			});			
		});
		
	};
	// DOM events
	_instance_.login_clicked = function(e){
		var self = this;
		USER.auth(self.model()).done(function(resp){
			self.model().status = resp.data.status;
		});
	};
	
	_instance_.register_clicked = function(e) {
		self.router.go("/ox/register");
	};
	
	_instance_._remove_ = function(){
		this.router.off();
		this.pipe.off();
	};
	
});