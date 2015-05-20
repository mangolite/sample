utils.define('tunnel').as(function(tunnel,_tunnel_) {

	var Request = function Request(OBJ,DATA){
		this.data = OBJ.data;
		this._done_ = OBJ.done;
		this._success_ = OBJ.success;
		this._on_ = OBJ.on;
		this.method = OBJ.method || 'POST';
		this._id_ = tunnel.getUniqueId();
		this._created_ = (new Date()).getTime();
		this._url_ = OBJ.api;
	};
	var funs = ['done','on','success'];
	funs.map(function(key){
		Request.prototype[key] = new Function('fun','{ this._'+ key +'_=fun; return this; }');
	})
	tunnel.Request = Request;
    window.Request = Request;
    
    tunnel.getRequestObject = function(OBJ,fun){
    	var reqObj = $.Deferred(fun);
    	var promise = reqObj.promise();
    	promise.on = promise.progress;
    	return promise;
    };
    
	var uniqueId = [];
	tunnel.getUUID = function() {
      var d = new Date().getTime();
      var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random() * 16) % 16 | 0;
        d = Math.floor(d / 16);
        return (c == 'x' ? r : (r & 0x7 | 0x8)).toString(16);
      });
      return uuid;
    };
    tunnel.getUniqueId =  function() {
      var id = "id_" + this.getUUID();
      while (uniqueId.indexOf(id) !== -1) {
        id = "id_" + this.getUUID();
      }
      uniqueId.push(id);
      return id;
    };
});