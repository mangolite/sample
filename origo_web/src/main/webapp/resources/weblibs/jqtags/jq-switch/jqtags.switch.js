_tag_('jqtags.switch',function(test,_test_, _attr_){
	
	return {
	    tagName: "jq-switch",
	    events: {
	        "change .switch-input":"toggleValue"
	    },
	    accessors: {
	        value: {
	            type: "boolean"
	        },
	        on: {
	            type: "string",
	            default : "On"
	        },
	        off: {
	            type: "string",
	        	default : "Off"
	        },
	        label: {
	            type: "string",
	        	default : ""
	        }
	    },
	    attachedCallback: function () {
	        this.$.innerHTML = 
	        '<label><span>'+this.$.label+'</span>' + 
	        '<label class="switch"> \
	        	<input type="checkbox" class="switch-input" '+ (this.$.value? 'checked' : '') +'> \
	        	<span class="switch-label" data-on="'+this.$.on+'" data-off="'+this.$.off+'"></span> \
	        	<span class="switch-handle"></span> \
	    	</label></label>';
	    },
	    toggleValue : function(){
	    	this.$.value = !this.$.value;
	    }
	};
	
});