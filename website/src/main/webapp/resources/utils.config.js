utils.config.set({
	debug : true,
	contextPath : 'app',
	resourcePath : 'resources',
	bundle_list : "/app/resources/resources.json?cb=utils.updateBundle&$=*&",
	moduleDir : {
		'dff.*' : 'dff/models/',
		'test.*' : 'test/',
		'utils.*' : '../libs/jqgeeks/utils/'
	},
	template : 'folader',
	combine : true,
	TAG_ATTR : {
		DATA_PATH : 'rx-path',
		DATA_ONCHANGE : 'rx-onchange',
		DATA_ONCLICK : 'rx-click',
		DATA_FORMAT : 'data-format'
	}
});