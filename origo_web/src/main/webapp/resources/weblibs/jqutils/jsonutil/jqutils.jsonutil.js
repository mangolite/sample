utils.proxy('jqutils.jsonutil').intercept('utils.json').as(function(JsonUtil){
	
	utils.require(":webmodules/dummy-json");
	var dummyJson = utils.module('dummyJson');
	var parse = JsonUtil.parse;
	
	JsonUtil.parse = function(_json_string_){
		if(typeof _json_string_ === 'string'){
			return parse(dummyJson.parse(_json_string_))
		} else {
			return _json_string_;
		}
	};
	
});
