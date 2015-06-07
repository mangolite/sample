utils.define('jqtags.tab.demo').extend("spamjs.module").as(function(demo,_demo_){
	
	utils.require("jqtags.tab");
	
	_demo_._init_ = function(){
		this.style("../jqtags.tab.scss");
		this.load({
			src : "test.html"
		});
	};
	
});