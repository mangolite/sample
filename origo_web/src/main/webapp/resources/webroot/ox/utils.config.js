utils.config.set({
	debug : true,
	contextPath : 'app',
	resourcePath : 'resources',
	dataPath : 'data',
	bundle_list : "/app/resources/resources.json?cb=utils.updateBundle&$=*&",
	moduleDir : {
		'test.*' : 'test/'
	},
	template : 'folader',
	combine : true,
	combineJS : true,
	//load_all_modules : true,
	moduleConfig : {
		'tunnel.server' : {
			url : 'app/sidebar.json'
		},
		'jqutils.cache.files' : {
			cache_script : false
		}
	}
	
});