utils.define("dff.init").as(function(init) {
	
	utils.require('utils.custom','utils.custom.tag');
	utils.require('dff.formattypes',':jqgeeks/jquery-ui',":jqgeeks/bootstrap");
	//Importing dependencies
	var SON_MODULE = utils.module('dff.son');
	var son_insatnce = SON_MODULE.instance();
	//Alt : var son_insatnce = utils.module('dff.son').instance();
	var stomp = utils.module('stompClient');
	var template = utils.module('utils.template');
	
	/**
	 * _ready_ method is triggered when module is loaded and
	 * doc is ready to handler DOM operations
	 */
	init._ready_ = function(){
		
		init.templ = utils.module('sampledata').instance({ 
			handler : 'sampledata',
			data : { 
				detail : { price : "0" , volume : 0 , rate :0}
			},
			$parent : $('#myform')
		});
		
		init.templ2 = template.load({ 
			handler : 'market_price',
			data : { 
				detail : { price : "0" , volume : 0 , rate :0}
			},
			$parent : $('#market_price')
		});
    	
		/*
		 * Subscribing to broadcast event
		 */
		stomp.event.on('market_price',function(a,b,c,d){
			//console.log('a',a,b,c)
    		init.templ2.update({detail :a })
    	});
		
	}
	
});