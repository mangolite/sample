_define_("ox.user",function(user,_user_){
	
	var SERVER = _module_('tunnel.server');
	var PIPE = _module_('tunnel.pipe');
	
	
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