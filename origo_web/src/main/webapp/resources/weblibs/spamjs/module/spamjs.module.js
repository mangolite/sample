utils.define('spamjs.module').as(function(viewmodel,_instance_){

	utils.require(":webmodules/rivets");
	
	var TEMPLATES = {};
	var PENDINGS = {};
	var _id_ = 0;
	
	window.__undescore_template_resolver_ = function(file_name,data){
		if(TEMPLATES[file_name]){
			return TEMPLATES[file_name](data);
		} else if(file_name){
			return "NO TEMPLATE FOUND:"+file_name ;
		} else return "";
	};
	
	viewmodel._instance_ = function(_options_){
		var _options_ = _options_ || {};
		this.id = _options_.id || (++_id_);
		this.uuid = window.getUUID();
		this._child_ = {};
		this.options = _options_;
		this._data_ = {};
		this._model_ = {};
	};
	
	_instance_.apply = function(){
		if(this.$$ && this._model_ && this.$$.html().trim()!==""){
			if(this.$$view) this.$$view.unbind();
			var self = this;
			this.$$view = rivets.bind(this.$$[0], { model : this._model_ }, {
				handler: function(target, event, binding) {
					if(binding.keypath && self[binding.keypath]){
						self[binding.keypath](event, target,binding);
					}
					//this.call(target, event, binding)
				}
			});
		}
	};
	_instance_.model = function(model){
		if(model!==undefined){
			this._model_ = model;
			this.apply();
		}
		return this._model_;
	};
	_instance_.html = function(raw_html){
		this.$$.html(raw_html);
		this.apply();
	};
	_instance_.render = function(data){
		this._data_ = data || this._data_;
		return this.html(TEMPLATES[this.tempPath](this._data_));
	};
	
	var view = function(self, html_path,data, _templateSettings_){
		self._data_ = data || self._data_ ;
		self._templateSettings_ = $.extend(self._templateSettings_,_templateSettings_);
		self.tempPath = html_path._type_ === 'ClassPath' ? html_path : self.getClass().getPath(html_path);
		
		if(TEMPLATES[self.tempPath]) {
			console.debug(""+self.tempPath,"FOUND");
			return $.when(self.render(self._data_));
		} else {
			return viewmodel.prepare_template(self.tempPath,self._templateSettings_).then(function(){
				return self.render();
			});
		}
	};
	
	_instance_.view = function(html_path,data){
		var self = this;
		return view(this,html_path,data).done(function(resp){
			(typeof self._view_ === 'function' ) && self._view_(resp);
		});
	};
	
	viewmodel.prepare_template = function(html_path,q){
		if(TEMPLATES[html_path]){
			return TEMPLATES[html_path];
		} else if(PENDINGS[html_path]){
			return PENDINGS[html_path];
		} else {
			PENDINGS[html_path] = html_path.load().then(function(raw_html){
				var P = [];
				var mathces = raw_html.match(/<include\s*(.*?)\s*data=(.*?)\/>/g);
				if(mathces!==null){
					var newDir = html_path.resetPath()._resolved_path_;
					var paths = mathces.map(function(x){
						/*
						 * To allow all the combinations for attribute assignments
						 */ 
						  return ((/src="?([^"\s]+)"?\s*/).exec(x)[1]).replace(/(^\')|(\'$)/g, "") ;
					});
					console.info("paths",paths)

					for(var i in paths){
						var newClassPath = utils.getClassPath(newDir,paths[i]);
						raw_html = raw_html.replace(
						        /<include\s*(.*?)\s*data=(.*?)\s*\/>/,
						        paths[i] ? '<!-- print(window.__undescore_template_resolver_("'+newClassPath.toString()+'",$2)); -->'
						        		: ""
						);
						if(paths[i]){
							P.push(viewmodel.prepare_template(newClassPath,q));
						}
					}
				}
				delete PENDINGS[html_path];
				TEMPLATES[html_path] = viewmodel._.template(raw_html,undefined,q);
				return $.when.apply($,P)
			});
			return PENDINGS[html_path];
		}
	};
	
	_instance_.load = function(obj){
		var self = this;
		var dff = [];
		 
		if(typeof obj.src === 'string'){
			obj.tempPath = self.getClass().getPath(obj.src)
			dff.push(viewmodel.prepare_template(obj.tempPath));
		}
		if(typeof obj.data === 'string'){
			dff.push($.getJSON(self.getClass().getPath(obj.data)).done(function(resp){
				obj.data = resp;
			}));
		} else if(typeof obj.data === 'object' && typeof obj.data.done == "function"){
			dff.push(obj.data.done(function(resp){
				obj.data = resp;
			}));
		}
		return $.when.apply($,dff).done(function(){
			if(obj.tempPath){
				obj.html = TEMPLATES[obj.tempPath](obj.data);
			}
			if(typeof obj.selector === "string"){
				self.$$.find(obj.selector)[obj.method || "html"](obj.html);
			} else {
				self.tempPath = obj.tempPath;
				if(typeof self.src === 'string'){
					self.render(obj.data)
				} else {
					self.html(obj.html);
				}
			}
		});
	};
	
	_instance_.style = function(css_path){
		var myCSS = [];
		for(var i in arguments){
			myCSS.push(utils.url.resolve(arguments[i],this.getClass()._dir_))
		}
		utils.files.loadCss(myCSS);
	};
	_instance_.$ = _instance_.find= function(selector){
		return this.$$.find(selector);
	};
	
	_instance_._get_wrapper_ = function(uuid,spam_class){
		return $('<div id='+uuid+' class="'+spam_class+'" />');
	};
	
	_instance_.init = function(options){
		var spam_class = this.getClass().module.replace('\.',"-","g");
		this.$$ = this._get_wrapper_(this.uuid,spam_class);
		if(options === undefined){
			$('body').append(this.$$);
		} else if(options.length===undefined){
			$(options.selector).first().append(this.$$);
		} else if(options.parent && options.parent.append){
			options.parent.append(this.$$);
		} else if(options && options.append){
			//console.warn(options.html(), options.append, this.$$)
			options.append(this.$$);
		}
		//console.warn("thisss",this)
		this.$$.addClass(spam_class);
		this._init_();
		return this;
	};
	
	_instance_._add_ = function($container,vm){
		if(this._child_[vm.id]){
			this.remove(vm.id);
		}
		this._child_[vm.id] = vm;
		$container = ($container.length>0) ? $container : this.$$; 
		vm.init($container);
	};
	
	_instance_.add = function(){
		var start = 0, count = arguments.length, selector;
		if(typeof arguments[0] === "string"){
			start = 1;
			selector = arguments[0];
		} 
		for(var i=start; i<count; i++){
			var vm = arguments[i];
			var parent = this.$( selector).first();
			this._add_(parent,vm);
		}
		return arguments[start];
	};
	
	_instance_.remove = function(id){
		if(id!==undefined){
			var cvm = this._child_[id];
			if(cvm && cvm.remove) cvm.remove();
		} else {
			if(this._remove_) {
				this._remove_();
			}
			if(this.$$view) {
				this.$$view.unbind();
			}
			for(var i in this._child_){
				this._child_[i].remove();
				delete this._child_[i];
			};
			if(this.$$){
				this.$$.remove();
			}
		}
	};
	
	viewmodel._config_ = function(thisConfig,all){
		if(this.module === "spamjs.module"){
			var _rivetConfig = $.extend({
				  // Attribute prefix in templates
				  prefix: 'rx',
				  // Preload templates with initial data on bind
				  preloadData: true,
				  // Toot sightglas interface for keypaths
				  rootInterface: '.',
				  // Template delimiters for text bindings
				  templateDelimiters: ['{', '}'],
				  // Augment the event handler of the on-* binder
				  handler: function(target, event, binding) {
				    this.call(target, event, binding.view.models)
				  }
				},thisConfig.rivetConfig
			);
			rivets.configure(_rivetConfig);
		}
	};
	
});
utils.proxy('spam').intercept('spamjs.module');
utils.proxy('utils.viewmodel').intercept('spamjs.module');
utils.define('spamjs.module._').as(function(_,_instance_){

	  
	  // By default, Underscore uses ERB-style template delimiters, change the
	  // following template settings to use alternative delimiters.
//	    evaluate    : /<%([\s\S]+?)%>/g,
//	    interpolate : /<%=([\s\S]+?)%>/g,
//	    escape      : /<%-([\s\S]+?)%>/g
	  _.templateSettings = {
	    evaluate    : /<!--\ ([\s\S]+?)\ -->/g,
	    interpolate : /{{([\s\S]+?)}}/g,
	    escape      : /<!--\\([\s\S]+?)-->/g,
	    variable : 'data'
	  };

	  // When customizing `templateSettings`, if you don't want to define an
	  // interpolation, evaluation or escaping regex, we need one that is
	  // guaranteed not to match.
	  var noMatch = /(.)^/;

	  // Certain characters need to be escaped so that they can be put into a
	  // string literal.
	  var escapes = {
	    "'":      "'",
	    '\\':     '\\',
	    '\r':     'r',
	    '\n':     'n',
	    '\t':     't',
	    '\u2028': 'u2028',
	    '\u2029': 'u2029'
	  };

	  var escaper = /\\|'|\r|\n|\t|\u2028|\u2029/g;

	  // JavaScript micro-templating, similar to John Resig's implementation.
	  // Underscore templating handles arbitrary delimiters, preserves whitespace,
	  // and correctly escapes quotes within interpolated code.
	  
_.template = function(text, data, settings) {
	var render;
	settings = $.extend({}, _.templateSettings,
			(settings == false ? utils.config.templateSettings : settings));

	// Combine delimiters into one regular expression via alternation.
	var matcher = new RegExp([ (settings.escape || noMatch).source,
			(settings.interpolate || noMatch).source,
			(settings.evaluate || noMatch).source ].join('|')
			+ '|$', 'g');

	// Compile the template source, escaping string literals appropriately.
	var index = 0;
	var source = "__p+='";
	text.replace(matcher, function(match, escape, interpolate, evaluate, offset) {
		source += text.slice(index, offset).replace(escaper,function(match) {
			return '\\' + escapes[match];
		});

		if (escape) {
			source += "'+\n((__t=(" + escape + "))==null?'':_.escape(__t))+\n'";
		}
		if (interpolate) {
			source += "'+\n((__t=(" + interpolate + "))==null?'':__t)+\n'";
		}
		if (evaluate) {
			source += "';\n" + evaluate + "\n__p+='";
		}
		index = offset + match.length;
		return match;
	});
	source += "';\n";

	// If a variable is not specified, place data values in local scope.
	if (!settings.variable)
		source = 'with(obj||{}){\n' + source + '}\n';

	source = "var __t,__p='',__j=Array.prototype.join,"
			+ "print=function(){__p+=__j.call(arguments,'');};\n"
			+ source + "return __p;\n";

	try {
		render = new Function(settings.variable || 'obj', '_',
				source);
	} catch (e) {
		e.source = source;
		throw e;
	}

	if (data)
		return render(data, _);
	var template = function(data) {
		return render.call(this, data, _);
	};

	// Provide the compiled function source as a convenience for precompilation.
	template.source = 'function(' + (settings.variable || 'obj')
			+ '){\n' + source + '}';

	return template;
};

});