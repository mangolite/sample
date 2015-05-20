utils.define('spamjs.boot_navbar').extend('spamjs.module').as(function(navbar, _instance_){
	
	_instance_._init_ = function(){
		
		//Set View
		this.style('boot.navbar.css');
		
		var data = {};
		data.nav_pos_class = this.options.position || '';
		data.container_class = this.options.fluid ? 'container-fluid' : 'container';
		var content_html = this.options.view || this.getClass().getPath('boot.navbar-content.html');
		
		var self = this;
		self.view('boot.navbar-wrapper.html',data,false).done(function(){
			content_html.load().done(function(html){
				self.find('.nav-container').html(html);
			});
		});
		
	};
	
	_instance_._config_ = function(config){
		this.url = config.url;
	};
	_instance_._get_wrapper_ = function(spam_class){
		return $('<div class="'+spam_class+'" />');
	};
});
