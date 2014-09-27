utils.define('mytemplate').extend('utils.abstracts.template').as(function(mytemplate,_ins_){
	//***************Static Methods/Triggers***********************//
	/**
	 * _execute_ is triggered when module definition is done
	 */
	var stomp = utils.module('stompClient');
	var json = utils.module('utils.json');
	
	mytemplate._execute_ = function(a,b){
    	console.info('_execute_ : module mytemplate is ready');
    };
    
    
	/**
	 * _ready_ method is triggered when class is loaded and
	 * doc is ready to handler DOM operations
	 */
    mytemplate._ready_ = function(a,b){
		console.info('_ready_ : module mytemplate is ready to use DOM operations');
	};
    
    
    //***************Instance Methods/Triggers***********************//
	/**
	 * _instance_._onchange_ is triggered whenever data values changes in ViewModel 
	 */
	_ins_._onchange_ = function(a,b){
    	console.info('_onchange_ : data change occured');
    	var req = { name : {fname : "", lname : ""}, age : 100};json.set(req,a,b);
    	stomp.send("userdata/"+a,req);
    };
    
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
    	this.on('DataChange', 'name.fname',function(a,b,c,d){
    		console.info('name.fname',a,b,c,d)
    	});
    	
    	this.on('name.lname',function(a,b,c,d){
    		console.info('name.lname',a,b,c,d)
    	});
    	/*
    	 * Listening to dest event on server;
    	 */
    	stomp.on('details_updated',function(a,b,c,d){
    		console.info('details_updated',a,b,c,d);
    	});
    	stomp.on('event','all_updated',function(a,b,c,d){
    		THIS.update(a)
    		console.info('all_updated',a,b,c,d);
    	});
    };
});