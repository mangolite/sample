utils.define("ox.signup").extend('spamjs.module').as(function(signup,_instance_) {
	
	var HEADER = utils.module("ox.header");
	var FOOTER = utils.module("ox.footer");
	var ROUTER = utils.module("jqrouter");
	
	_instance_._init_ = function(){
		// Set View
		var self = this;
		this.router = ROUTER.instance();
		
		this.view('ox.signup.html').done(function(){
			self.add("header",HEADER.instance({
				id : "header"
			}));
			self.add("footer",FOOTER.instance({
				id : "footer"
			}));
			self.add_routing();
		});
	};
	
	_instance_.add_routing = function(){
		var self = this;
		this.router.on("/ox/register/*",function(x){
			var REGISTER = utils.module("ox.register");
			self.add("singup_body",REGISTER.instance({
				id : "singup_body"
			}));
		}).on("/ox/login",function(){
			var LOGIN = utils.module("ox.login");
			self.add("singup_body",LOGIN.instance({
				id : "singup_body"
			}));
		}).otherwise("ox/login");
	};
	
	_instance_._remove_ = function(){
		this.router.off();
	};
	
});