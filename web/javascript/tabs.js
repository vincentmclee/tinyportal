(function($) {
  $.fn.tabs = function() {
	var _handler = function() {
	  var container = this;
	  $('div.tabs li a', container).each(function(){
		var isActiveTab = $(this).parent().hasClass('active');
		if (isActiveTab ) {
		  $(this).click(function(){
			return false;
		  }) ;
		}
	  })
	};
	return this.each(_handler);
  };
})(jQuery);
