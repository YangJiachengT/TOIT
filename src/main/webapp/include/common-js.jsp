<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/assets/vendor/babel-external-helpers/babel-external-helpers.js"></script>
<script src="/assets/vendor/jquery/jquery.min.js?v=3.3.1"></script>
<script src="/assets/vendor/popper-js/umd/popper.min.js"></script>
<script src="/assets/vendor/bootstrap/bootstrap.min.js?v=4.0.0"></script>
<!-- 带动画的页面过度jQuery插件  -->
<script src="/assets/vendor/animsition/animsition.js"></script>
<!--  鼠标滚轮插件 是一个用于添加跨浏览器的鼠标滚轮支持的 jQuery 插件。 -->
<!-- <script src="/assets/vendor/mousewheel/jquery.mousewheel.js"></script> -->
<script src="/assets/vendor/asscrollbar/jquery-asScrollbar.js"></script>
<!-- 块级元素滚动 -->
<script src="/assets/vendor/asscrollable/jquery-asScrollable.js"></script>
<!-- 鼠标移入容器元素时滚动 ,用于菜单显示-->
<script src="/assets/vendor/ashoverscroll/jquery-asHoverScroll.js"></script>
<!-- Plugins --> 
<!-- 滑动按钮插件 -->
<!-- <script src="/assets/vendor/switchery/switchery.js"></script> -->
<!-- jquery引导插件 -->
<!-- <script src="/assets/vendor/intro-js/intro.js"></script> -->
<!-- 用于跨浏览器使用javascript的简单包装器全屏API这使得您可以将页面或任何元素都输入到全屏中。避免浏览器实现差异,全屏使用 -->
<script src="/assets/vendor/screenfull/screenfull.js"></script>
<!-- 侧面板滑块插件 -->
<script src="/assets/vendor/slidepanel/jquery-slidePanel.js"></script>
<!-- <script src="/assets/vendor/skycons/skycons.js"></script> -->
<!-- <script src="/assets/vendor/chartist-plugin-tooltip/chartist-plugin-tooltip.js"></script> -->
<!-- 圆形进度动画插件 -->
<!-- <script src="/assets/vendor/aspieprogress/jquery-asPieProgress.min.js"></script> -->
<!-- jquery地图插件 -->
<!-- <script src="/assets/vendor/jvectormap/jquery-jvectormap.min.js"></script> -->
<!-- <script src="/assets/vendor/jvectormap/maps/jquery-jvectormap-au-mill-en.js"></script> -->
<!-- jquery 等高排列插件 -->
<script src="/assets/vendor/matchheight/jquery.matchHeight-min.js"></script>
<!-- Scripts -->
<script src="/assets/js/Component.js?v=4.0.1"></script> 
<script src="/assets/js/Plugin.js?v=4.0.1"></script> 
<script src="/assets/js/Base.js?v=4.0.1"></script> 
<script src="/assets/js/Config.js?v=4.0.1"></script> 
<script src="/assets/js/Section/Menubar.js?v=4.0.1"></script> 
<script src="/assets/js/Section/Sidebar.js?v=4.0.1"></script> 
<script src="/assets/js/Section/PageAside.js?v=4.0.1"></script> 

<script src="/assets/js/Plugin/menu.js?v=4.0.1"></script>
<!-- Config -->
<script src="/assets/js/config/colors.js?v=4.0.1"></script>
<script>Config.set('assets', '/assets');</script>

<script src="/assets/js/Site.js"></script> 

<script src="/assets/js/Plugin/asscrollable.js?v=4.0.1"></script>
<script src="/assets/js/Plugin/slidepanel.js?v=4.0.1"></script>
<script src="/assets/js/Plugin/switchery.js?v=4.0.1"></script>
<script src="/assets/js/Plugin/matchheight.js?v=4.0.1"></script>
<script src="/assets/js/Plugin/action-btn.js"></script>

<!-- <script src="/assets/vendor/jquery-ui/jquery-ui.min.js"></script> -->
<!-- alertify -->
<script src="/assets/vendor/alertify/alertify.js?v=1.0.0"></script>
<!-- toastr -->
<script src="/assets/vendor/toastr/toastr.js?v=2.1.4"></script>
<!-- 图片插件 -->
<script src="/assets/plugin/imageviewer/imageviewer.min.js?v=1.0"></script>
<!-- 通用方法 -->
<script src="/assets/js/util.js?v=1.0.5"></script>

<script src="/assets/js/Plugin/asrange.js"></script>
<script src="/assets/js/Plugin/ionrangeslider.js"></script>
<script src="/assets/plugin/bootstrap-table/bootstrap-table.js"></script>

<script src="/js/bootstrapvalidator/bootstrapValidator.min.js"></script>
<script src="/js/axios/axios.js"></script>
<script
	src="/assets/plugin/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script>
 (function(document, window, $){
   'use strict';
   var Site = window.Site;
   $(document).ready(function(){
   	Site.run();
   });
 })(document, window, jQuery);
</script>
<!-- Remark end -->
<script>
	function serialNumGen(value, row, index) {
		return index + 1;
	}
</script>

<script>
	function form2Json(id) {

		var arr = $(id).serializeArray()
		var jsonStr = "";

		jsonStr += '{';
		for (var i = 0; i < arr.length; i++) {
			jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
		}
		jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
		jsonStr += '}'

		var json = JSON.parse(jsonStr)
		return json
	}
</script>

<script>
	function formReset(id) {
		$(':input', id).not(':button, :submit, :reset, :hidden,:radio') // 去除不需要重置的input类型
		.val('').removeAttr('checked').removeAttr('selected');
	}
</script>