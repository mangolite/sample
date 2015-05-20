utils.define('jqtags.tab').extend('jqtag').as(function(test){
	
	var $ = jQuery;
	var $tabHeaders,$tabBodies,$selectedHeader,$selectedBody;
	
	test.register({
	    tagName: "jq-tab",
	    events: {
	        "click jq-tab-head":"selectTab"
	    },
	    accessors: {
	        value: {
	            type: "string",
	            default : "",
	            onChange : "setValue"
	        }
	    },	
	    attachedCallback: function () {
	    	var self = this;
	    	self.setValue();
	    },
	    setValue : function(){
	    	var $this = $(this.$);
	    	var activeClass = $this.attr("active-class");
	    	
	    	$tabHeaders = $this.find("jq-tab-head");
	    	$tabBodies = $this.find("jq-tab-pane");
	    	$tabBodies.attr("hidden",true);
	    	$tabHeaders.removeAttr("active").removeClass(activeClass);
	    	
	    	$selectedHeader = $tabHeaders.filter("[value='"+this.$.value+"']");
	    	$selectedHeader.attr("active", true).addClass(activeClass);
	    	
	    	$selectedBody= $tabBodies.filter("[value='"+this.$.value+"']");
	    	$selectedBody.removeAttr("hidden");
	    	
	    },
	    selectTab : function(e,target){
	    	this.$.value = target.getAttribute("value");
	    	this.setValue();
	    	this.trigger("change")
	    }
	});
	
});