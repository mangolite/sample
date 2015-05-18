utils.define("ox.cmpny_info").extend('spamjs.module').as(function(login,_instance_) {
	
	var server = utils.module('tunnel.server');
	var pipe = utils.module('tunnel.pipe');
	//model Initializer
	_instance_._init_ = function(){
		console.warn("---",this.getClass().getPath());
		this.style(
				"../origo/styles/bootstrap.css",
				"../origo/styles/bootstrap-responsive.css",
				"../origo/styles/font-awesome.css",
				"../origo/styles/origeoextreme.css",
				"../origo/styles/sample.css",
			    "../origo/styles/crop/main.css",
	    		"../origo/styles/crop/croppic.css"		
		);
		//Set View
		this.view('cmpny_info.html',{
			text : "This is global text",
			body : { text : "THis is body Section"},
			footer : { text : "THis is footer Section"}
		});
		//Bind Model (2Way binding)
//		this.model({
//			username : "", 
//			password : "",
//			company : "",
//			status : ""
//		});
	};
	// DOM events
	_instance_.login_clicked = function(e){
		var self = this;
		server.post({
			api : "user/authByCompany",
			data : self.model()
		}).done(function(data,resp){
			self.model().status = data.status;
			pipe.send("ox.login.successful",self.model());
		});
	};
	
});