utils.define('sampledata').extend('utils.abstracts.template').as(function(sampledata,_ins_){
	//***************Static Methods/Triggers***********************//
	/**
	 * _execute_ is triggered when module definition is done
	 */
	var stomp = utils.module('stompClient');
	var json = utils.module('utils.json');
	
	sampledata._execute_ = function(a,b){
    	console.info('_execute_ : module mytemplate is ready');
    };
    
	/**
	 * _ready_ method is triggered when class is loaded and
	 * doc is ready to handler DOM operations
	 */
    sampledata._ready_ = function(a,b){
		console.info('_ready_ : module mytemplate is ready to use DOM operations');
	};
    
    //***************Instance Methods/Triggers***********************//
	/**
	 * _instance_._onchange_ is triggered whenever data values changes in ViewModel 
	 */
	_ins_._onchange_ = function(a,b){
		console.log('----',a,b)
		var det = this.get('detail')
    	stomp.send("sampledata/price_updated",det);
    };
    
    sampledata.send = function(){
    	var a = "name.fname", b = "NONANME";
    	var req = { name : {fname : "", lname : ""}, age : 100};json.set(req,a,b);
    	stomp.send("userdata/"+name,req);
    }
    
    /**
     * _instance_._create_ - is triggered for each instance after it is initialized,
     * 
     */
    _ins_._create_ = function(){
    	console.info('_create_ : instance is created');
    };
    
    /**
     *  _instance_._ready_ -  is available for templates only and is triggered 
     *  after DOM is rendered 
     * 
     */
    _ins_._ready_ = function(){
    	console.info('_ready_ : instance is ready');
    	var THIS = this;
    	this.on('DataChange', 'details.price',function(a,b,c,d){
    		console.info('DataChange :',a,b,c,d)
    	});
    	this.on('detail.price',function(a,b,c,d){
    		console.info('detail.price',a,b,c,d)
    	});
    	this.on('detail.volume',function(a,b,c,d){
    		console.info('detail.volume',a,b,c,d)
    	});
    	this.compute('detail.rate',function(){
    		console.log(this.get('detail.price'),this.get('detail.volume'))
    		return this.get('detail.price')/this.get('detail.volume');
    	});
    	/*
    	 * Listening to dest event on server;
    	 */
    	stomp.on('market_price',function(a,b,c,d){
    		console.info('market_price',a,b,c,d);
    	});
    };
});