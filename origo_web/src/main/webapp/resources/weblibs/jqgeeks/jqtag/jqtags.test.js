utils.define('jqtags.test').extend('jqtag').as(function(test,_test_, _attr_){
	
	test.register({
	    tagName: "jq-test",
	    events: {
	        "click":"toggleValue"
	    },
	    accessors: {
	        name: {
	            type: "string"
	        }
	    },
	    attachedCallback: function () {
	        this.$.innerHTML = (!this.active ? "Hi" : "Bye") + " " + this.$.name;
	    },
	    toggleValue : function(){
	    	this.active = !this.active;
	    	this.attachedCallback();
	    }
	});
	
});