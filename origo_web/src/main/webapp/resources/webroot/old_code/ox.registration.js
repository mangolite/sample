utils.define("ox.registration").as(function(reg) {
	
	utils.require('utils.custom','utils.custom.tag',"utils.controller");
	utils.require('dff.formattypes',':jqgeeks/jquery-ui',":jqgeeks/bootstrap", ":jqservice/geoservice");
	utils.require(":jqgeeks/mvc",":origo/login",":spam/sidebar");
	var controller = utils.module("utils.controller");
	
	var loginMod = utils.module("ox.login");
	var server = utils.module('tunnel.server');
	var pipe = utils.module('tunnel.pipe');
	/**
	 * _ready_ method is triggered when module is loaded and
	 * doc is ready to handler DOM operations
	 */
	reg._ready_ = function(){
		var loginIns =  loginMod.instance();
		loginIns.init({
			id : "#login_container"
		});
		
		pipe.on('ox.login.successful',function(){
			init.launchApp();
		});
		
		controller.on("/app/{xx}/no/{yyy}/z",function(xx,yyy){
			console.warn(xx,yyy);
		});
		controller.on("#bing/{hashparam}/jk",function(hashparam){
			console.warn(hashparam);
		});
		app.launchApp();
	};
	
	reg.launchApp = function(){
		$('#login_container').addClass('hide');
		$('#main_container').removeClass('hide');
		var sidebar = utils.module('boot.sidebar');
		var sidebarIns =  sidebar.instance();
		sidebarIns.init({
			id : "#sidebar_container"
		});
	};
	
});