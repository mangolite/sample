utils.define("ox.login").extend('spamjs.module').as(function(login,_instance_) {
	
	var server = utils.module('tunnel.server');
	var pipe = utils.module('tunnel.pipe');
	var router = utils.module('jqrouter')
	//model Initializer
	_instance_._init_ = function(){
		//Set View
		var self = this;
		self.pipe = pipe.instance();
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
		server.post( "user/authByCompany",self.model()).done(function(resp){
			self.model().status = resp.data.status;
			console.log("self.model()",resp);
			self.pipe.publish("ox.login.done",self.model());
		});
	};
	
	_instance_.register_clicked = function(e) {
		router.go("/ox/register");
	}
	
});