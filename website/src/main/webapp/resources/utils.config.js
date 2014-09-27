utils.config.set({
	debug : true,
	contextPath : 'app',
	resourcePath : 'resources',
	moduleDir : {
		'dff.*' : 'dff/models/',
		'utils.*' : '../lib/jqgeeks/utils/'
	},
	template : 'folader',
	combine : true,
});