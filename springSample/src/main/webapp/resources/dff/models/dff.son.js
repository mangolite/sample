utils.define("dff.son").extend('dff.father').as(function(son,_instance_) {
	
	var count = 0;
	this.GRANDFATHER_FUN =  function(){
		return "son";
	}
	this.FATHER_FUN = function() {
		return "son";
	}
	this.SON_FUN =  function(){
		return "son";
	}
	son._instance_ = function Son(name) {
		console.log('son ini...')
		this.title = name;
		this.fname = "FNAME";
		this.grandfather_say =  function(){
			return "son";
		}
		this.father_say = function() {
			return "son";
		}
		this.son_say =  function(){
			return "son";
		}
		this.set_father = function(name){
			return this.parent('set_title')(name);
		}
		this.who_is_sabka_father = function(name){
			return this.parent().get_fname.call(this,name);
		}
	};
});