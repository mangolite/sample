utils.define("ox.user").as(function(user,_user_){
	
	var SERVER = utils.module('tunnel.server');
	var PIPE = utils.module('tunnel.pipe');
	
	
	user.validate = function(){
		/*
		 * We will check if user is logged in or not 
		 * 
		 */
		return SERVER.post("user/isValid");
	};
	
	user.unauth = function(){
		/*
		 * Tell server that user wants to logout
		 */
		return SERVER.post( "user/logout",{});
	};
	
	user.auth = function(data){
		return SERVER.post( "user/authByCompany",data).done(function(resp){
			PIPE.publish("ox.user.login.done",data);
		});
	};
	
	
})