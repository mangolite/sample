utils.proxy('jqutils.jsonutil').intercept('utils.json').as(function(JsonUtil){
	
	utils.require(":webmodules/dummy-json");
	var dummyJson = utils.module('dummyJson');
	var parse = JsonUtil.parse;
	
	JsonUtil.parse = function(_json_string_,compile){
		if(typeof _json_string_ === 'string'){
			var _json_string_2 = _json_string_;
			if(compile!==false){
				_json_string_2 = dummyJson.parse(_json_string_)
			}
			return parse(_json_string_2)
		} else {
			return _json_string_;
		}
	};
	
});
