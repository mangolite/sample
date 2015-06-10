utils.define('jqtag').as(function(jqtag,_instance_){
	
	utils.require(":pitana/pitana.js")
	
	jqtag._extend_ = function(tag,_tag_){
		tag._jqTagConfig_ = {};
		tag._jqTagConfig_ = tag._definition_(tag,tag._jqTagConfig_) || tag._jqTagConfig_;
	};

	jqtag.register = function(config){
		this._jqTagConfig_ = config || {};
	};
	
	jqtag._extended_ = function(tag,_tag_){
		var parentConfig = tag.parent()._jqTagConfig_ || {};
		tag._jqTagConfig_ = $.extend(true,parentConfig,tag._jqTagConfig_);
		if(tag._jqTagConfig_.tagName === undefined){
			tag._jqTagConfig_.tagName = tag.module.replace(/jqtags\./,"jq-").replace(/\./g,"-");
		}	
		pitana.register(tag._jqTagConfig_)
	};
});

(function(foo) {
	
	foo._tag_ = function(tagName,definition){
		return utils.define(tagName).extend('jqtag').as(definition);
	};
	
})(this);