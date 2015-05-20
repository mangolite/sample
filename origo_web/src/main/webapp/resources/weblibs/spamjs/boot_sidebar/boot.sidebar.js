utils.define('boot.sidebar').extend('utils.viewmodel').as(function(sidebar, _instance_){
	
	
	_instance_._init_ = function(){
		
		//Set View
		this.style('boot.sidebar.css');
		
		var self = this;
		this.getClass().getPath("sidebar.json").load().done(function(resp){
			var data = utils.json.parse(resp);
			console.debug("resp",data)
			self.view('boot.sidebar.html',data,false);
		});

		var self = this;
		self.htmlbodyHeightUpdate();
		$( window ).resize(function() {
			self.htmlbodyHeightUpdate()
		});
		$( window ).scroll(function() {
			self.height2 = $('.main').height()
			self.htmlbodyHeightUpdate()
		});
		this.$$.on('click','a',function(e){
			console.log(e);
			//return utils.preventPropagation(e);
		});
		
	};
	
	_instance_._config_ = function(config){
		this.url = config.url;
	};
	
	_instance_.htmlbodyHeightUpdate = function(){
		var self = this;
		self.height3 = $( window ).height()
		self.height1 = $('.nav').height()+50
		self.height2 = $('.main').height()
		if(self.height2 > self.height3){
			$('html').height(Math.max(self.height1,self.height3,self.height2)+10);
			$('body').height(Math.max(self.height1,self.height3,self.height2)+10);
		}
		else
		{
			$('html').height(Math.max(self.height1,self.height3,self.height2));
			$('body').height(Math.max(self.height1,self.height3,self.height2));
		}
		
	}
});
