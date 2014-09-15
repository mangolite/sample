utils.define("dff.father").extend("dff.grandfather").as(function(parent,_instance_) {
	var count = 0;
	parent.GRANDFATHER_FUN = function() {
		return 'FATHER';
	};
	parent.FATHER_FUN = function() {
		return 'FATHER';
	};
	parent.ONLY_FATHER_FUN = function() {
		return 'FATHER';
	};
	parent._instance_ = function Father($parent) {
		this.fname = "Father:father";
		this.grandfather_say =  function(){
			return "father";
		}
		this.father_say = function() {
			return 'father';
		}
		this.only_father_say = function() {
			return 'father';
		}
		this.get_fname = function(){
			return this.title;
		}
		this.set_title = function(title){
			this.fname = title;
		}
	}
});