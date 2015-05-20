utils.define('jqtags.switch').extend('jqtag').as(function(test,_test_, _attr_){
	
	test.register({
	    tagName: "jq-switch",
	    events: {
	        "change .switch-input":"toggleValue"
	    },
	    accessors: {
	        value: {
	            type: "boolean"
	        }
	    },
	    attachedCallback: function () {
	        this.$.innerHTML = 
	        '<label class="switch"> \
	        	<input type="checkbox" class="switch-input" '+ (this.$.value? 'checked' : '') +'> \
	        	<span class="switch-label" data-on="On" data-off="Off"></span> \
	        	<span class="switch-handle"></span> \
	    	</label>';
	    },
	    toggleValue : function(){
	    	this.$.value = !this.$.value;
	    }
	});
	
});