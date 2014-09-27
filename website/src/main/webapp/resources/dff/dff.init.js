//utils.require('dff.son');
//utils.require('dff.father','dff.son','dff.grandfather');
utils.define("dff.init").as(function(init) {
	//var g = dff.grandfather.instance();
	//var f = dff.father.instance();
	//var S = utils.module('dff.son');
	//var s = utils.module('dff.son').instance("Ram");
	//var s2 = dff.son.instance("Ramesh");
	//console.log(s2.title);
	
/*	
	utils.require('utils.custom.tag');
	
	init.templ =  utils.require('dff.mytemp').instance(
			{"content":"original","topic":null,"message":{"name":null},"tags":[{"id":"0","name":"A"},{"id":"2","name":"B"}]}
			,$('#myform'));
	
	init.templ.data.sub('a.b',function(a,b,c,d){
		console.log('a.b',a,b,c,d)
	});
	
	init.templ.data.sub('a.*',function(a,b,c,d){
		console.log('a.*',a,b,c,d)
	});
	
	init._ready_ = function(){
		dff.init.templ.data.patch({"~message":[{"name":"not hello"}],"~tags":[{"+2":{"id":"3","name":"C"}},{"+3":{"id":"4","name":"E"}}],"tags":{"~0":[{"id":"5"},{"name":"F"}],"~1":[{"name":"D"}]},"~":[{"topic":"newTopic"}]})
		df
		f.init.templ.data.patch({"~tags":[{"-3":0}]})
		console.log("len==",init.templ.data.data.tags.length);
	};*/
	
	//utils.loadPackage("jqgeeks/utils_widget","jqgeeks/utils_main");
	utils.module('mytemplate').instance({ 
		data : { 
			name : {fname : "Lalit"}
		},
		$parent : $('#myform')
	});
	
});