utils.define("ox.header").extend('spamjs.module').as(function(header,_header_) {
	
	var USER = utils.module('ox.user');
	
	_header_._init_ = function(){
		//Set View
		var self = this;
		self.view('ox.header.html').done(function(){
			self.model({
				username : "admin", 
				password : "",
				company : "",
				status : ""
			});		
		});
	};
	
	_header_.login_clicked = function(){
		var self = this;
		USER.auth(self.model()).done(function(resp){
			self.model().status = resp.data.status;
		});
	};
	
});