var Widgets = {
  jQuery : $,

  settings : {
	columns : '.column',
	widgetSelector: '.widget',
	handleSelector: '.widget-head',
	contentSelector: '.widget-content',
	widgetDefault : {
	  movable: true,
	  removable: true,
	  collapsible: true,
	  colorClasses : ['color-yellow', 'color-red', 'color-blue', 'color-white', 'color-orange', 'color-green', 'color-gray']
	},

	widgetIndividual : {}
  },

  attachStylesheet : function (href) {
	var $ = this.jQuery;
	return $('<link href="' + href + '" rel="stylesheet" type="text/css" />').appendTo('head');
  },

  getWidgetSettings : function (id) {
	var $ = this.jQuery,
	settings = this.settings;
	return (id && settings.widgetIndividual[id]) ? $.extend({},settings.widgetDefault,settings.widgetIndividual[id]) : settings.widgetDefault;
  },

  addWidgetControls : function () {
	var Widgets = this,
	$ = this.jQuery,
	settings = this.settings;

	$(settings.widgetSelector, $(settings.columns)).each(function () {
	  var thisWidgetSettings = Widgets.getWidgetSettings(this.id);
	  if (thisWidgetSettings.removable) {
		$('<a href="#" class="remove" title="刪除">CLOSE</a>').mousedown(function (e) {
		  e.stopPropagation();
		}).click(function () {
		  if(confirm('你要刪除這個widget嗎 ?')) {
			$(this).parents(settings.widgetSelector).animate({
			  opacity: 0
			},function () {
			  $(this).wrap('<div/>').parent().slideUp(function () {
				$(this).remove();
			  });
			});
		  }
		  return false;
		}).appendTo($(settings.handleSelector, this));
	  }

	  if (thisWidgetSettings.collapsible) {
		$('<a href="#" class="collapse" title="閉合">COLLAPSE</a>').mousedown(function (e) {
		  e.stopPropagation();
		}).toggle(function () {
		  $(this).removeClass('collapse').addClass('uncollapse')
		  .parents(settings.widgetSelector)
		  .find(settings.contentSelector).hide();
		  return false;
		},function () {
		  $(this).removeClass('uncollapse').addClass('collapse')
		  .parents(settings.widgetSelector)
		  .find(settings.contentSelector).show();
		  return false;
		}).prependTo($(settings.handleSelector,this));
	  }
	});

  },

  makeSortable : function () {
	var Widgets = this ;
	var $ = this.jQuery ;
	var settings = this.settings ;
	
	var $sortableItems = (function () {
	  var notSortable = '#none';
	  $(settings.widgetSelector,$(settings.columns)).each(function (i) {
		if (! Widgets.getWidgetSettings(this.id).movable) {
		  if(!this.id) {
			this.id = 'widget-no-id-' + i;
		  }
		  notSortable += '#' + this.id + ',';
		}
	  });
	  return $('> li:not(' + notSortable + ')', settings.columns);
	})();

	$sortableItems.find(settings.handleSelector).css({
	  cursor: 'move'
	}).mousedown(function (e) {
	  $sortableItems.css({
		width:''
	  });
	  $(this).parent().css({
		width: $(this).parent().width() + 'px'
	  });
	}).mouseup(function () {
	  if(!$(this).parent().hasClass('dragging')) {
		$(this).parent().css({
		  width:''
		});
	  } else {
		$(settings.columns).sortable('disable');
	  }
	});

	$(settings.columns).sortable({
	  items: $sortableItems,
	  connectWith: $(settings.columns),
	  handle: settings.handleSelector,
	  placeholder: 'widget-placeholder',
	  forcePlaceholderSize: false,
	  revert: 300,
	  delay: 100,
	  opacity: 0.8,
	  containment: 'document',
	  start: function (e,ui) {
		$(ui.helper).addClass('dragging');
		$(ui.placeholder).height($(ui.item).height());
	  },
	  stop: function (e,ui) {
		$(ui.item).css({
		  width:''
		}).removeClass('dragging');
		$(settings.columns).sortable('enable');
	  }
	});
  },

  init : function (extendcss) {
	this.attachStylesheet(extendcss);
	this.addWidgetControls();
	this.makeSortable();
  }

};
