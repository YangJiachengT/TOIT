(function (global, factory) {
  if (typeof define === "function" && define.amd) {
    define('/tables/jsgrid', ['jquery', 'Site'], factory);
  } else if (typeof exports !== "undefined") {
    factory(require('jquery'), require('Site'));
  } else {
    var mod = {
      exports: {}
    };
    factory(global.jQuery, global.Site);
    global.tablesJsgrid = mod.exports;
  }
})(this, function (_jquery, _Site) {
  'use strict';

  var _jquery2 = babelHelpers.interopRequireDefault(_jquery);

  (0, _jquery2.default)(document).ready(function ($$$1) {
    (0, _Site.run)();
  });

  jsGrid.setDefaults({
    tableClass: "jsgrid-table table table-striped table-hover"
  });

  jsGrid.setDefaults("text", {
    _createTextBox: function _createTextBox() {
      return (0, _jquery2.default)("<input>").attr("type", "text").attr("class", "form-control input-sm");
    }
  });

  jsGrid.setDefaults("number", {
    _createTextBox: function _createTextBox() {
      return (0, _jquery2.default)("<input>").attr("type", "number").attr("class", "form-control input-sm");
    }
  });

  jsGrid.setDefaults("textarea", {
    _createTextBox: function _createTextBox() {
      return (0, _jquery2.default)("<input>").attr("type", "textarea").attr("class", "form-control");
    }
  });

  jsGrid.setDefaults("control", {
    _createGridButton: function _createGridButton(cls, tooltip, clickHandler) {
      var grid = this._grid;

      return (0, _jquery2.default)("<button>").addClass(this.buttonClass).addClass(cls).attr({
        type: "button",
        title: tooltip
      }).on("click", function (e) {
        clickHandler(grid, e);
      });
    }
  });

  jsGrid.setDefaults("select", {
    _createSelect: function _createSelect() {
      var $result = (0, _jquery2.default)("<select>").attr("class", "form-control input-sm"),
          valueField = this.valueField,
          textField = this.textField,
          selectedIndex = this.selectedIndex;

      _jquery2.default.each(this.items, function (index, item) {
        var value = valueField ? item[valueField] : index,
            text = textField ? item[textField] : item;

        var $option = (0, _jquery2.default)("<option>").attr("value", value).text(text).appendTo($result);

        $option.prop("selected", selectedIndex === index);
      });

      return $result;
    }
  });

});