utils.define("dff.grandfather").as(function(grandfather) {
	var count = 0;grandfather
	var counter = 0;
	
	grandfather.SET_GRANDFATHER_COUN = function(cnt) {
		count = cnt;
	};
	grandfather.GET_GRANDFATHER_COUN = function(cnt) {
		return count;
	};
	grandfather.SET_GRANDFATHER_COUNTER = function(cnt) {
		counter = cnt;
	};
	grandfather.GET_GRANDFATHER_COUNTER = function(cnt) {
		return counter;
	};
	
	grandfather.GRANDPA_FUN = function() {
		return 'GRANDFATHER';
	};
	grandfather.ONLY_GRANDFATHER_FUN = function() {
		return 'GRANDFATHER';
	};
	grandfather._instance_ = function GrandPa($parent) {
		var me = "grandfather"
		this.grandfather_say = function() {
			return 'grandfather';
		}
		this.only_grandfather_say = function() {
			return me;
		}
		this.set_title = function(title){
			this.gname = title;
		}
		this.set_grandfather = function(){
			this.title = "alok naath hello";
		}
	}
});