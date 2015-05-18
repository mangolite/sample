utils.define("ox.signup").extend('spamjs.module').as(function(signup,_instance_) {
	
	var HEADER = utils.module("ox.header");
	var FOOTER = utils.module("ox.footer");
	
	_instance_._init_ = function(){
		// Set View
		var self = this;
		this.router = utils.module("jqrouter");
		
		this.view('ox.signup.html').done(function(){
			self.add("header",HEADER.instance({
				id : "header"
			}));
			self.add("footer",FOOTER.instance({
				id : "footer"
			}));
			self.add_routung();
		});
	};
	
	_instance_.add_routung = function(){
		var self = this;
		this.router.on("/ox/register/*",function(x){
			var REGISTER = utils.module("ox.register");
			self.remove("login");
			self.add("singup_body",REGISTER.instance({
				id : "register"
			}));
		}).on("/ox/login",function(){
			var LOGIN = utils.module("ox.login");
			self.remove("register");
			self.add("singup_body",LOGIN.instance({
				id : "login"
			}));
		}).otherwise("ox/login");
	};
	
	_instance_._remove_ = function(){
		this.router.off();
	};
	
});