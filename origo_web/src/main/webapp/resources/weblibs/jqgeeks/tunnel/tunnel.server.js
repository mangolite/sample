utils.define('tunnel.server').as(function(server,_server_) {

	server.getDataPath = function(api,OBJ){
		return utils.config.get().contextPath + "json" + '/'+ api;
	};
	var tunnel = utils.module('tunnel');
	var json = utils.module('utils.json');

	
	var funs = ['get','post'];
	funs.map(function(key){
		server[key] = 
			new Function('OBJ','{ OBJ.method="'+ key +'"; return this.send(OBJ); }');
	});
	
    server.send = function(OBJ){
    	var reqObj = new tunnel.Request(OBJ);
    	$.ajax({
            url : this.getDataPath(OBJ),
            type  : reqObj.method,
            dataType: "json",
            data: { 
            	data : json.stringify(OBJ.data),
            	api : OBJ.api
            }
         }).done(function(rep,_1,_2_3){
         	if(rep.success && reqObj._success_){
        		return (reqObj._success_ ? reqObj._success_(rep.data,rep,_1,_2_3) : null);
        	} else if(!rep.success && reqObj._error_){
        		return (reqObj._error_ ? reqObj._error_(rep.data,rep,_1,_2_3) : null);
        	} else if(reqObj._done_){
        		return (reqObj._done_ ? reqObj._done_(rep.data,rep,_1,_2_3) : null);
        	}
        });
        return reqObj;
    };
    
    server.sendNew = function(OBJ){
    	return tunnel.getRequestObject(OBJ,function(){
    		$.getJSON(server.getDataPath(OBJ.api,OBJ),function(resp){
    			
    		});
    	});
    };
    
    server.get = function(api, data){
    	return  $.get(server.getDataPath(api,data),{ data : data}).then(function(resp){
    		return json.parse(resp);
    	});
    };
    server.post = function(api, data){
    	return  $.post(server.getDataPath(api,data),{ data : json.stringify(data)});
    };
});