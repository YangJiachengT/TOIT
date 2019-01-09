var winWidth = 0;
var winHeight = 0;
//函数：获取尺寸   
function findDimensions() {
	//获取窗口宽度   
	if (window.innerWidth)   
		  winWidth = window.innerWidth;
	else if ((document.body) && (document.body.clientWidth))   
		  winWidth = document.body.clientWidth;
	//获取窗口高度   
	if (window.innerHeight)   
		  winHeight = window.innerHeight;
	else if ((document.body) && (document.body.clientHeight))   
		  winHeight = document.body.clientHeight;
	 
	//通过深入Document内部对body进行检测，获取窗口大小   
	if (document.documentElement  && document.documentElement.clientHeight &&   
										 document.documentElement.clientWidth) {
		winHeight = document.documentElement.clientHeight;
		winWidth = document.documentElement.clientWidth;
	}
}

//客户选择器
function cmpPicker(){
	modalHref(ctx+'/cmp/picker','ajaxModal');
}
/**
 * 是否为空或空字符串或者未定义
 */
function isNullOrUndefined(obj) {
	if(obj==null || obj == "" || obj==undefined) {
		return true;
	} else {
		return false;
	}
}

/**
 * 打开模态框
 * @param e  事件
 * @param obj  this  
 */
function modal(e,obj){
	e.preventDefault();
	$remote = obj.remote ||obj.href, 
	$modal = $('<div class="modal" id="ajaxModal"><div class="modal-body"></div></div>');
	$('body').append($modal);
	$modal.modal({
		backdrop : 'static',
		keyboard : false
	});
	$modal.load($remote);
//	$("#ajaxModal").draggable();//为模态对话框添加拖拽
//	$("#ajaxModal").css("overflow", "hidden");//禁止模态对话框的半透明背景滚动

}

/**
 * 打开模态框
 * @param href  路径
 */
function modalHref(href,divId){
	$modal = $('<div class="modal" id="'+divId+'"><div class="modal-body"></div></div>');
	$('body').append($modal);
	$modal.modal({
		backdrop : 'static',
		keyboard : false
	});
	if (href == undefined) {
		href = "";	
	}
	if (href.indexOf("?") > -1) {
		href += "&" + (new Date()).valueOf()
	} else {
		href += "?" + (new Date()).valueOf()
	}
	$modal.load(href);
//	$("#"+divId).draggable();//为模态对话框添加拖拽
//	$("#"+divId).css("overflow", "hidden");//禁止模态对话框的半透明背景滚动
}

/**
 * 关闭模态框
 * @param e  事件
 * @param obj  this  
 */
function closeModal(divId){
	$("#"+divId).modal('hide');  //手动关闭
	$("#"+divId).remove();//清除页面
}

//客户选择器
function cmpSelect(){
	modalHref(ctx+'/company/cmpSelector','ajaxModal');
}

//客服专员选择器  //type 1:返回方法  accountCallBack()  2:accountCallBack2()
function accountPicker(type){
	if(isNullOrUndefined(type)){
		type==1;
	}
	modalHref(ctx+'/system/account/accountPicker?type='+type,'ajaxModal');
}

/**
 * 多附件上传
 * @param attachIds
 * @param attachDivId
 */
function uploadWords(e,attachIds,attachDivId) {
	e.preventDefault();
	$remote = ctx+"/attach/upload/words?attachField="+attachIds+"&attachDivId="+attachDivId,
	$modal = $('<div class="modal" id="filesModal"><div class="modal-body"></div></div>');
	$('body').append($modal);
	$modal.modal({
		backdrop : 'static',
		keyboard : false
	});
	$modal.load($remote);
}

/**
 * 单文件上传操作
 * @param attachFieldId
 * @param attachDivId
 * @param attachFileId(file_id)
 * @param attachFileName(file_name)
 * @param attachFileSuffix(doc/x)
 * @returns
 */
function uploadOneFileComplete(attachFieldId,attachDivId,attachFileId,attachFileName,attachFileSuffix) {	
	$("#contractAttach").val(attachFileId);
	$("#contractAttach").trigger('input:changed',attachFileId);
	
	var downloadUrl = ctx +"/attach/download?attachId=" + attachFieldId;
	var dispFilename = attachFileName;
	if(typeof(readonly) == "undefined"){
		readonly =false;
	}
	var disphtml = ''
		+'  <div style="padding:15px;float:left;">'
			+'	<div>';
	if(!isImageType(attachFileSuffix)){
		disphtml+=''
			+'	<img src='+ctx+'"/assets/images/upload.png"  style="height:150px;" />';
	}else{
		disphtml+=''
			+'	<img src="'+downloadUrl+'" data-high-res-src="'+downloadUrl+'" class="gallery-items"  style="height:150px"  />';
	}
		disphtml+=''
			+'	</div>'
			+'	<div style="margin-top:5px;">'+dispFilename+'</div>'
			+'	<div class="text-left" style="height:25px">'
			+'	  <a class="btn btn-white btn-bitbucket btn-xs" href="'+downloadUrl+'" target="_blank">'
			+'		<i class="fa fa-download"></i> 下载'
			+'	  </a>';
		if(!readonly){
		disphtml+=''
			+'	  <a class="btn btn-white btn-bitbucket btn-xs" onclick="_removeAttach(\''+attachFileId+'\',\''+dispFilename+'\',\''+attachFieldId+'\')">'
			+'		<i class="fa fa-trash"></i> 删除'
			+'	  </a>';
		}
		disphtml+=''
			+'	</div>'
			+'  </div>';
	$("#" + attachDivId).html('<div class="file-box" name="'+attachFieldId+'" id="attachDiv_'+attachFileId+'">' + disphtml + "</div>");
	//模板文件错误文件信息删除
	if($("#attachError")){
		$("#attachError").remove();
		//将保存按钮设置为可填
		if($("#btnSubmit")){
			$("#attachError").removeAttr("disabled");
		}
	}
}

/**
 * 单图片上传
 * @param e  事件
 * @param attchId  
 * @param attchDispId
 */
function uploadImage(e,attachField,attachImage){
	e.preventDefault();
	$remote = ctx+"/attach/upload/image?attachField="+attachField+"&attachImage="+attachImage,
	$modal = $('<div class="modal" id="filesModal"><div class="modal-body"></div></div>');
	$('body').append($modal);
	$modal.modal({
		backdrop : 'static',
		keyboard : false
	});
	$modal.load($remote);
}

/**
 * 图片、附件上传完成操作
 * @param attchId
 * @param attchDispId
 */
function uploadSingleComplete(attachField,attachImage,attachId,url,attachFileSuffix,fileName) {
	$("#"+attachField).val(attachId);
	var downloadUrl= ctx+url;
	var disphtml = ''
		+'  <div style="padding:0 0 0 1.0715rem;width:150px;height:150px;" >'
		+'	<figure class="overlay overlay-hover" style="height:135px;width:135px;">';
	//console.log(attachFileSuffix);
	if(!isImageType(attachFileSuffix)){
		disphtml+=''
			 +' <div class="img_wd">'+fileName+'</div>';
	}else{
		disphtml+=' <img class="overlay-figure gallery-items" src="'+downloadUrl+'"data-high-res-src="'+downloadUrl+'" alt="'+fileName+'" width="100%" height="100%">' 
	}
	disphtml+=''
		+'	<figcaption class="overlay-panel overlay-background overlay-fade overlay-icon">'
		+'		<a class="icon wb-search" style="margin:0 5px;font-size:1.286rem;width:1.286rem"  href="javascript:void(0)" onclick="clickImg(event,this)"></a>'
		+'		<a class="icon wb-download" style="margin:0 5px;font-size:1.286rem;width:1.286rem" href="'+downloadUrl+'" target="_self" ></a>'
		+'		<a class="icon wb-close" style="margin:0 5px;font-size:1.286rem;width:1.286rem"  onclick="_removeSingleAttach(\''+attachId+'\',\''+attachImage+'\',\''+attachField+'\')"></a>'
		+'		<h5 class="animation-slide-bottom" style="margin:0">'+fileName+'</h5>'
		+'	</figcaption>'
		+'  </figure>'
		+'</div>';
	$("#"+attachImage).html(disphtml);
	
	if (typeof uploadSuccess === "function") { // 是函数 其中 FunName 为函数名称
		uploadSuccess(attachId,attachImage);
	} else{// 不是函数
		//console.log("不存在该函数");
	}
}

//删除单个附件操作
function _removeSingleAttach(attachId,attachImage,attachFieldId){
	alertify.confirm("确认删除该附件吗？", function () {
		$.ajax({
			type: "post",
			url: ctx+"/attach/maintain/remove",
			data: {"attachId":attachId},
			dataType: "json",
			success: function(result){
				if(result.state=="ok"){
					$("#"+attachFieldId).val("");
					var disphtml = ''
						+'  <div style="padding:0 0 0 1.0715rem;width:150px;height:150px;" >'
						+'	<figure class="overlay" style="height:135px;width:135px;">'
						+'	<img src='+ctx+'"/assets/images/upload.png"  class="overlay-figure" />'
						+'	<figcaption class="overlay-panel overlay-background overlay-fade overlay-icon">'
						+'		<a class="icon wb-upload" style="margin:0 5px;font-size:1.286rem;width:1.286rem" onclick="uploadImage(event,\''+attachFieldId+'\',\''+attachImage+'\')"></a> '
						+'	</figcaption>'
						+'  </figure>'
						+'</div>';
					$("#"+attachImage).html(disphtml);
					
					if (typeof removeSingleSuccess === "function") { // 是函数 其中 FunName 为函数名称
						removeSingleSuccess(attachId,attachImage);
					}else{// 不是函数
						console.log("不存在该函数");
					}
				}else{
					console.log(result);
				}
			}
		});
	}, function () {
//			alertify.error("取消");
	});
	
}

/**
 * 多附件上传
 * @param attachIds
 * @param attachDivId
 */
function uploadFiles(e,attachIds,attachDivId) {
	e.preventDefault();
	$remote = ctx+"/attach/upload/files?attachField="+attachIds+"&attachDivId="+attachDivId,
	$modal = $('<div class="modal" id="filesModal"><div class="modal-body"></div></div>');
	$('body').append($modal);
	$modal.modal({
		backdrop : 'static',
		keyboard : false
	});
	$modal.load($remote);
}

//判断是否为图片文件
function isImageType(fileType) {
	if(isNullOrUndefined(fileType)) { return false; }
	var lowerType = fileType.toLowerCase();
	//jgp、jpeg、tiff、raw、bmp、gif、png
	if("jpg"==lowerType || "jpeg"==lowerType || "tiff" == lowerType 
			|| "raw" == lowerType || "bmp" == lowerType 
			|| "gif" == lowerType || "png" == lowerType) {
		return true;
	}
	return false;
}

/**
 * 文件上传完成后返回url和filename
 * attachFileId 文件Id
 * attchFileName 文件名
 * attchFileSuffix 文件后缀名
 * @param url
 */
function uploadFileComplete(attachFieldId,attachDivId,attachFileId,attachFileName,attachFileSuffix,readonly) {
	var _attachFieldVal = $("#"+attachFieldId).val();
	if(_attachFieldVal) {
		_attachFieldVal += "," + attachFileId;
	} else {
		_attachFieldVal = attachFileId;
	}
	$("#"+attachFieldId).val(_attachFieldVal);
	$("#"+attachField).trigger('input:changed',_attachFieldVal);
	dispAnAttachsFile(attachFieldId,attachDivId,attachFileId,attachFileName,attachFileSuffix,readonly);
}

//附件上传结束
function dispAnAttachsFile(attachFieldId,attachDivId,attachFileId, attachFileName,attchFileSuffix, readonly) {
	var downloadUrl = ctx+"/attach/download?attachId=" + attachFileId;
	var downloadThumbUrl = ctx+"/attach/download/thumb?attachId=" + attachFileId;
	
	var psnlAttachFlg = (typeof uploadPsnlAttachSuccess === "function");
	var dispFilename = attachFileName;
	var imgDivheight="150px"
	if(psnlAttachFlg){
		imgDivheight="190px";
	}
		
	if(typeof(readonly) == "undefined"){
		readonly =false;
	}
	var disphtml = '  <div style="padding:0 0 0.9rem 1.0715rem;width:150px;height:'+imgDivheight+';" id="attachDiv_'+attachFileId+'">'
				+'	<figure class="overlay overlay-hover" style="height:135px;width:135px;">';
	if(!isImageType(attchFileSuffix)){
		disphtml+='<div class="img_wd">'+attachFileName+'</div>';
	}else{
		disphtml+=' <img class="overlay-figure gallery-items" src="'+downloadThumbUrl+'"data-high-res-src="'+downloadUrl+'" alt="'+attachFileName+'" >' ;
	}
	disphtml+=''
		+'	<figcaption class="overlay-panel overlay-background overlay-fade overlay-icon">'
		+'		<a class="icon wb-search" style="margin:0 5px;font-size:1.286rem;width:1.286rem"  href="javascript:void(0)" onclick="clickImg(event,this)"></a>'
		+'		<a class="icon wb-download" style="margin:0 5px;font-size:1.286rem;width:1.286rem" href="'+downloadUrl+'" target="_self" ></a>'
		+'		<a class="icon wb-close" style="margin:0 5px;font-size:1.286rem;width:1.286rem"  onclick="_removeAttach(\''+attachFileId+'\',\''+dispFilename+'\',\''+attachFieldId+'\')"></a>';
		if(!psnlAttachFlg){
			disphtml+='		<h5 class="animation-slide-bottom" style="margin:0">'+attachFileName+'</h5>';
		}
		disphtml+='	</figcaption>'
		+'  </figure>';
		if(psnlAttachFlg){
			disphtml+='		<h5 class="animation-slide-bottom" style="margin:10px;text-align:center;word-wrap:break-word;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp:2;overflow: hidden;">'+attachFileName+'</h5>';
		}
		disphtml+='</div>';
	$("#" + attachDivId).prepend(disphtml);
	if(typeof uploadPsnlAttachSuccess === "function"){
		//此方法只用于人员附件//工伤详情页面附件
		uploadPsnlAttachSuccess(attachFileId);
	}else if (typeof uploadSuccess === "function") { // 是函数 其中 FunName 为函数名称
		uploadSuccess(attachFileId);
	}else{// 不是函数
		console.log("不存在该函数");
	}
}


//删除附件操作
function _removeAttach(attachId,attachFileName,attachFieldId){
	alertify.confirm("确认删除该附件吗？", function () {
			$.ajax({
				type: "post",
				url: ctx+"/attach/maintain/remove",
				data: {"attachId":attachId},
				dataType: "json",
				success: function(result){
					if(result.state=="ok"){
						$("#attachDiv_" + attachId).remove();
						var attachs = $("#"+attachFieldId).val();
						attachs = attachs.replace(attachId,"");
						//处理附件逗号问题
						var newattaches ="";
						var attach = attachs.split(",");
						for (var i = 0; i<attach.length;i++) {
							if(!isNullOrUndefined(attach[i])){
								if(!isNullOrUndefined(newattaches)){
									newattaches += ",";
								}
								newattaches += attach[i];
							}
						}
						$("#"+attachFieldId).val(newattaches);
						if (typeof removePsnlAttachSuccess === "function") { // 是函数 其中 FunName 为函数名称
							//该方法只用于人员附件//工伤详情页面附件
							removePsnlAttachSuccess(attachId);
						} 
					}else{
						console.log(result);
					}
				}
			});
		}, function () {
	//		alertify.error("取消");
	});
}

//图片查看
function clickImg(e,obj){
	imgShow();
	$(obj).parent().siblings().click();
}

//Alertify 文案本地化
function registerAlertify4Local(){
	alertify.okBtn("确定").cancelBtn("取消").theme("bootstrap").logPosition("top right").delay(2500);
}

function str2Date(str) {
	if(isNullOrUndefined(str) || str.length < 8) {
		return null;
	}
	var year = str.substring(0,4);
	var month = str.substring(4,6);
	var day = str.substring(6,8);
	var HH = 0, mm = 0;
	if(str.length > 8) {
		HH = str.substring(9,11);
		mm = str.substring(12,14);
	}
	var d = new Date();
	d.setFullYear(year,month-1,day);
	d.setHours(HH);
	d.setMinutes(mm);
	d.setSeconds(0);
	return d;
}
function month2Str(date) {
	 if(isNullOrUndefined(date)){
	   	 return "";
	 }
	 var y = date.getFullYear();
	 var m = date.getMonth() + 1;  
	 if(m<10) m = "0" + m;
	 var redate = y +""+m; 
	 return redate;
}
//月份相加： yyyy-MM + n
function plusMonth(yearMonth,n) {
	var t= str2Date(yearMonth+"01");
	t.setMonth(t.getMonth() + n);
	return month2Str(t);
}

//图片显示器初始化
function imgShow(){
	var viewer = ImageViewer();
 	$('.gallery-items').click(function () {
		var imgSrc =$(this).attr("src"),
	 	highResolutionImage = $(this).attr("data-high-res-src");
	 	viewer.show(imgSrc, highResolutionImage);
	 });
}

/**
 * 错误处理
 */
function resultErr(result) {
	if (result.result == 1) {// 未登录
		toastr.error("用户未登录或超时，请重新登录！","用户未登录或超时",{positionClass: "toast-top-center"});
		if (window != top){
			top.location.href = ctx+"/login";
		}else{
			location.href = "/";
		}
	} else {// 提示错误
		toastr.error(result.msg,"",{positionClass: "toast-top-center"});
//		alertify.alert(result.msg);
	}
}

//左侧列表滚动条设置高度
function leftHeight(time){
	setTimeout(function(){
		var panelBodyHeight=$(".panel-body").outerHeight(true);
		//console.log(winHeight);
		//console.log(panelBodyHeight);
		if(winHeight>panelBodyHeight){
			$(".scrollable-container").css({"height":(winHeight-150)+"px"});
		}else{
			$(".scrollable-container").css({"height":(panelBodyHeight)+"px"});
		}
	},time);
}

function isNumber( s ){
	if(s==null || s=="")
		return true;

	s = s + "";
	
	if(s.charAt(0) == '.') return false;

	var regu = "^[0-9.]+$";
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
	   return true;
	} else {
	   return false;
	}
	return true;
}

function checkNumber(obj) {
	if(obj != null && !isNumber(obj.value)) {
		obj.value = "0";
	}
}

function downloadQcloudFile(id){
	self.location=ctx+"/attach/download/downloadQcloudFile?id="+id;
}
