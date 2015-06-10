utils.define('jqtags.switch.demo').extend("spamjs.module").as(function(demo,_demo_){
	
	utils.require("jqtags.switch");
	
	_demo_._init_ = function(){
		this.style("../jqtags.switch.css");
		this.load({
			src : "test.html"
		});
	};
	
});