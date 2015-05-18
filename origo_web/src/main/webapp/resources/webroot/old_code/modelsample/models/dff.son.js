utils.define("dff.son").extend('dff.father').as(function(son,_instance_) {
	/*
	 * Module level variables, private
	 */
	var COUNT = 0;
	
	/*
	 * Module level variables, public, accessible globally 'dff.son.GLOBAL_PROPERTIES'
	 */
	son.GLOBAL_PROPERTIES = "OK";
		
	/*
	 * Module level methods accessible globally 'dff.son.GRANDFATHER_FUN'
	 */
	son.GRANDFATHER_FUN =  function(){
		return "son";
	};
	son.FATHER_FUN = function() {
		return "son";
	};
	son.SON_FUN =  function(){
		return "son";
	};

	/*
	 * constructor of module can be initiated using 'dff.son.instance("ABC")'; 
	 */
	son._instance_ = function Son(name) {
		console.info('son ini...');
		//instance level properties
		this.title = name;
		//Only if you want to have private properties
		var privateProp;
		var privateFun = function(){
			console.info('private fun executed')
		};
		
		/*	Instance level methods, not recommended, use 
		 * 	only if you want to have private properties/methods, accessible by these methods
		 */
		this.getPname = function(){
			return privateProp;
		};
		this.setPname = function(pname){
			privateProp = pname;
			privateFun();
		}
	};
	
	/*
	 * Default values per instance, can be overridden, 
	 * but if deleted, it falls-back to default value
	 */
	_instance_.fname = "FNAME";
	
	/*
	 * Instance level methods 
	 */
	_instance_.setFname = function(name){
		this.fname = name;
	};
	
	_instance_.getFname = function(){
		return this.fname;
	};
	_instance_.grandfather_say =  function(){
		return "son";
	};
	_instance_.father_say = function() {
		return "son";
	};
	_instance_.son_say =  function(){
		return "son";
	};
	_instance_.set_father = function(name){
		return this.parent('set_title')(name);
	};

	/*
	 * This method is triggered for each instance when created 
	 */
	_instance_._create_ =  function(){
		console.info('You created an instance and it is ready');
	};
	
});