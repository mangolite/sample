_tag_('jqtags.tab',function(test){
	
	var $ = _module_("jQuery");
	var $tabHeaders,$tabBodies,$selectedHeader,$selectedBody;
	var $this, $jqTab;
	_require_("jq2much");
	
	return {
	    tagName: "jq-tab",
	    events: {
	        "click jq-tab-head":"selectTab",
	        "click jq-tab-next":"selectNextTab",
	        "click jq-tab-prev":"selectPrevTab",
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
	    findSafe : function(selector){
	    	return $this.findSafe(selector,"jq-tab");
	    },
	    setValue : function(){
	    	$this = $(this.$);
	    	var activeClass = $this.attr("active-class");
	    	
	    	$tabHeaders = this.findSafe("jq-tab-head");
	    	$tabBodies = this.findSafe("jq-tab-pane");
	    	
	    	$tabBodies.attr("hidden",true);
	    	$tabHeaders.removeAttr("active").removeClass(activeClass);
	    	
	    	$selectedHeader = $tabHeaders.filter("[value='"+this.$.value+"']");
	    	$selectedHeader.attr("active", true).addClass(activeClass);
	    	
	    	$selectedBody= $tabBodies.filter("[tab='"+this.$.value+"']");
	    	$selectedBody.removeAttr("hidden");
	    	
	    },
	    selectTab : function(e,target){
	    	$this = $(this.$);
	    	$jqTab = $(target).closest("jq-tab");
	    	if($jqTab[0]===this.$){
		    	this.$.value = target.getAttribute("value");
		    	this.setValue();
		    	this.trigger("change");
	    	}
	    },
	    selectNextTab : function(e,target){
	    	$this = $(this.$);
	    	$jqTab = $(target).closest("jq-tab");
	    	if($jqTab[0]===this.$){
	    		$tabHeaders = this.findSafe("jq-tab-head");
	    		var selectedHeader = $tabHeaders[$tabHeaders.index($tabHeaders.filter("[active]"))-0+1];
	    		if(selectedHeader!==undefined){
	    			return this.selectTab(e,selectedHeader);
	    		}
	    	}
	    },
	    selectPrevTab : function(e,target){
	    	$this = $(this.$);
	    	$jqTab = $(target).closest("jq-tab");
	    	if($jqTab[0]===this.$){
	    		$tabHeaders = this.findSafe("jq-tab-head");
	    		var selectedHeader = $tabHeaders[$tabHeaders.index($tabHeaders.filter("[active]"))-1];
	    		if(selectedHeader!==undefined){
	    			return this.selectTab(e,selectedHeader);
	    		}
	    	}
	    }
	};
	
});