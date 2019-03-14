<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>标题</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<base>
<%@ include file="/include/common-css.jsp"%>
</head>

<body class="animsition dashboard">
	<%@ include file="/include/page-nav.jsp"%>
	<!-- Page -->
	<div class="page">
		<div class="page-header">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="javascript:void(0)">一级</a></li>
				<li class="breadcrumb-item active">二级</li>
			</ol>
		</div>

		<div class="page-content">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title"></h3>
				</div>
				<div class="panel-body">
					<div class="nav-tabs-horizontal" data-plugin="tabs">
						<ul class="nav nav-tabs nav-tabs-line" role="tablist">
							<li class="nav-item" role="presentation"><a
								class="nav-link active" data-toggle="tab"
								href="#exampleTabsLineOne" aria-controls="exampleTabsLineOne"
								role="tab" aria-selected="true">选择题</a></li>
							<li class="nav-item" role="presentation"><a class="nav-link"
								data-toggle="tab" href="#exampleTabsLineTwo"
								aria-controls="exampleTabsLineTwo" role="tab"
								aria-selected="false">判断题</a></li>
						</ul>

						<div class="tab-content pt-20">
							<div class="tab-pane active" id="exampleTabsLineOne"
								role="tabpanel">
								<table id="dataTable" class="" data-toggle="table"
									data-pagination="true" data-url="/exam/couMultiQuestionList"
									data-content-type="application/x-www-form-urlencoded"
									data-method="get" data-show-columns="true"
									data-show-refresh="true" data-page-number="1"
									data-page-size="10" data-page-list="[10, 20, 50]"
									data-striped="true" data-search="true" data-toolbar="#toolbar">
									<thead>
										<tr>
											<th data-width="60px" data-formatter="serialNumGen"
												data-align="center">#</th>
											<th data-field="question" data-sortable="true">题目</th>
											<th data-field="option_a" data-sortable="true">选项A</th>
											<th data-field="option_b" data-sortable="true"
												data-align="center">选项B</th>
											<th data-field="option_c" data-sortable="true"
												data-align="center">选项C</th>
											<th data-field="option_d" data-sortable="true"
												data-align="center">选项D</th>
											<th data-field="option_e" data-sortable="true"
												data-align="center">选项E</th>
											<th data-field="option_f" data-sortable="true"
												data-align="center">选项F</th>
											<th data-field="answer" data-sortable="true">难度</th>
											<th data-field="level" data-sortable="true">难度</th>
											<th data-field="stage" data-sortable="true">阶段</th>
											<th data-width="200px" data-align="center"
												data-formatter="actionFormatter">操作</th>
										</tr>
									</thead>
								</table>
							</div>
							<div class="tab-pane" id="exampleTabsLineTwo" role="tabpanel">
								<table id="dataTableJudge" class="" data-toggle="table"
									data-pagination="true" data-url="/exam/couJudgeQuestionList"
									data-content-type="application/x-www-form-urlencoded"
									data-method="get" data-show-columns="true"
									data-show-refresh="true" data-page-number="1"
									data-page-size="10" data-page-list="[10, 20, 50]"
									data-striped="true" data-search="true" data-toolbar="#toolbar">
									<thead>
										<tr>
											<th data-width="60px" data-formatter="serialNumGen"
												data-align="center">#</th>
											<th data-field="question" data-sortable="true">题目</th>
											<th data-field="answer_str" data-sortable="true">答案</th>
											<th data-field="level" data-sortable="true">难度</th>
											<th data-field="stage" data-sortable="true">阶段</th>
											<th data-width="200px" data-align="center"
												data-formatter="actionFormatterJudge">操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- End Page -->
	<!-- Modal -->
	<div class="bootbox modal fade" id="myModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="bootbox-close-button close"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<div class="bootbox-body">
						<form class="form-horizontal" id="multiForm">
							<input id="multiId" value="" type="hidden" name="multiId">
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">题目：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="question" placeholder="请输入题目" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">选项A：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="option_a" placeholder="请输入选项" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">选项B：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="option_b" placeholder="请输入选项" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">选项C：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="option_c" placeholder="请输入选项" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">选项D：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="option_d" placeholder="请输入选项" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">选项E：
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="option_e" placeholder="请输入选项" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">选项F：
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="option_f" placeholder="请输入选项" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">答案：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="answer">
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">阶段：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="stage">
										<option value="1">1</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">难度：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="level">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button data-bb-handler="success" type="button"
						data-dismiss="modal" aria-hidden="true" class="btn btn-default">取消</button>
					<button data-bb-handler="success" type="button"
						class="btn btn-success" id="multiBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal判断题 -->
	<div class="bootbox modal fade" id="myModalJudge" tabindex="-1"
		role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="bootbox-close-button close"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<div class="bootbox-body">
						<form class="form-horizontal" id="judgeForm">
							<input id="judgeId" value="" type="hidden" name="judgeId">
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">题目：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="question" placeholder="请输入题目" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">答案：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="answer">
										<option value="T">正确</option>
										<option value="F">错误</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">阶段：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="stage">
										<option value="1">1</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">难度：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="level">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button data-bb-handler="success" type="button"
						data-dismiss="modal" aria-hidden="true" class="btn btn-default">取消</button>
					<button data-bb-handler="success" type="button"
						class="btn btn-success" id="judgeBtn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="site-footer">
	<div class="site-footer-legal">
		© 2019 <a href="#">学生素质测评系统TOIT</a>
	</div>
	<div class="site-footer-right">
		Crafted with by <a href="#">Liu</a>
	</div>
	</footer>
</body>
<%@ include file="/include/common-js.jsp"%>
<script>
$(document).ready(function() {
	/* -------------------------------------选择题表单验证------------------------------------- */
	var multiForm = $("#multiForm");
	function multiFormValidator(){
		//初始化input状态样式图标
		var icon = {};
		//初始化验证规则
		multiForm.bootstrapValidator({
			feedbackIcons : icon, //加载图标
			/* 生效规则
			 * enabled:字段值发生变化就触发验证
			 * disabled/submitted:点击提交时触发验证
			 */
			live: 'disabled',
			//表单域配置
			fields : {
				question : {//username为input标签name值
					validators : {
						notEmpty : {
							message : '请输入题目'
						}
					}
				},
				option_a : {
					validators : {
						notEmpty : {
							message : '请输入选项'
						}
					}
				},
				option_b : {
					validators : {
						notEmpty : {
							message : '请输入选项'
						}
					}
				},
				option_c : {
					validators : {
						notEmpty : {
							message : '请输入选项'
						}
					}
				},
				option_d : {
					validators : {
						notEmpty : {
							message : '请输入选项'
						}
					}
				},
				answer : {
					validators : {
						notEmpty : {
							message : '请输入答案'
						}
					}
				},
				stage : {
					validators : {
						notEmpty : {
							message : '请选择阶段'
						}
					}
				},
				level : {
					validators : {
						notEmpty : {
							message : '请选择难度'
						}
					}
				}
			//最后一个没有逗号
			}
		});
	}
	multiFormValidator();
	$("#multiBtn").click(function () {
		var formName = '#multiForm'
        //进行表单验证
        var bv = multiForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            console.log(form2Json(formName));
            //发送ajax请求
            axios.post('/exam/couMultiQuestionUpdate',JSON.stringify(form2Json(formName)))
              .then(function (response) {
            	  if(response.data.state == 'ok'){
	            	  $('#dataTable').bootstrapTable('refresh');
	            	  alertify.success("编辑成功");
            	  }else{
            		  var message = response.data.message;
            		  var str = "编辑失败 " + message;
            		  alertify.error(str);
            	  }
            	  $('#myModal').modal('hide');
            	  //清除隐藏元素表达内容的关键
            	  formReset(formName);
            	  multiForm.data('bootstrapValidator').resetForm();
            	  
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    });
	$('#myModal').on('hide.bs.modal', function (e) {
		var formName = '#multiForm';
		var form = $("#multiForm");
		//清除隐藏元素表达内容的关键
		formReset(formName);
		form.data('bootstrapValidator').resetForm();
	})
	/* -------------------------------------选择题表单验证------------------------------------- */
	
	/* -------------------------------------判断题表单验证------------------------------------- */
	var judgeForm = $("#judgeForm");
	function judgeFormValidator(){
		//初始化input状态样式图标
		var icon = {};
		//初始化验证规则
		judgeForm.bootstrapValidator({
			feedbackIcons : icon, //加载图标
			/* 生效规则
			 * enabled:字段值发生变化就触发验证
			 * disabled/submitted:点击提交时触发验证
			 */
			live: 'disabled',
			//表单域配置
			fields : {
				question : {//username为input标签name值
					validators : {
						notEmpty : {
							message : '请输入题目'
						}
					}
				},
				answer : {
					validators : {
						notEmpty : {
							message : '请输入答案'
						}
					}
				},
				stage : {
					validators : {
						notEmpty : {
							message : '请选择阶段'
						}
					}
				},
				level : {
					validators : {
						notEmpty : {
							message : '请选择难度'
						}
					}
				}
			//最后一个没有逗号
			}
		});
	}
	judgeFormValidator();
	$("#judgeBtn").click(function () {
		var formName = '#judgeForm'
        //进行表单验证
        var bv = judgeForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            console.log(form2Json(formName));
            //发送ajax请求
            axios.post('/exam/couJudgeQuestionUpdate',JSON.stringify(form2Json(formName)))
              .then(function (response) {
            	  if(response.data.state == 'ok'){
	            	  $('#dataTableJudge').bootstrapTable('refresh');
	            	  alertify.success("编辑成功");
            	  }else{
            		  var message = response.data.message;
            		  var str = "编辑失败 " + message;
            		  alertify.error(str);
            	  }
            	  $('#myModalJudge').modal('hide');
            	  //清除隐藏元素表达内容的关键
            	  formReset(formName);
            	  judgeForm.data('bootstrapValidator').resetForm();
            	  
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    });
	$('#myModalJudge').on('hide.bs.modal', function (e) {
		var formName = '#judgeForm';
		var form = $("#judgeForm");
		//清除隐藏元素表达内容的关键
		formReset(formName);
		form.data('bootstrapValidator').resetForm();
	})
	/* -------------------------------------判断题表单验证------------------------------------- */
});
</script>
<script>
//操作
function actionFormatter(value, row, index) {
	var _delete = "";
	var _edit = "";
	_delete = '<a class="btn btn-xs text-danger" href="javascript:void(0);" onclick="couMultiQuestionDelete('
			+ row.id + ')">删除 </a>';
	_edit = '<a data-toggle="modal" data-target="#myModal" class="btn btn-xs text-primary" href="javascript:void(0);" onclick="setId(\'#multiId\',\''+row.id+'\')">编辑 </a>';

	return _edit + _delete;
}
function actionFormatterJudge(value, row, index){
	var _delete = "";
	_delete = '<a class="btn btn-xs text-danger" href="javascript:void(0);" onclick="couJudgeQuestionDelete('
			+ row.id + ')">删除 </a>';
	_edit = '<a data-toggle="modal" data-target="#myModalJudge" class="btn btn-xs text-primary" href="javascript:void(0);" onclick="setId(\'#judgeId\',\''+row.id+'\')">编辑 </a>';
	return _edit + _delete;
}
function couJudgeQuestionDelete(id) {
	alertify.confirm("确定要删除该条记录吗？", function() {
		axios.post('/exam/couJudgeQuestionDelete',id)
        .then(function (response) {
      	  if(response.data.state == 'ok'){
            $('#dataTableJudge').bootstrapTable('refresh');
            alertify.success("删除成功");
      	  }else{
      		alertify.error("删除失败");
      	  }
      	$('#myModal').modal('hide');
      	//清除隐藏元素表达内容的关键
      	  formReset(formName);
  		  form.data('bootstrapValidator').resetForm();
      	  
        })
        .catch(function (error) {
          console.log(error);
        });
	}, function() {
		//alertify.error("取消");
	});
}
function couMultiQuestionDelete(id) {
	alertify.confirm("确定要删除该条记录吗？", function() {
		axios.post('/exam/couMultiQuestionDelete',id)
        .then(function (response) {
      	  if(response.data.state == 'ok'){
            $('#dataTable').bootstrapTable('refresh');
            alertify.success("删除成功");
      	  }else{
      		alertify.error("删除失败");
      	  }
      	$('#myModal').modal('hide');
      	//清除隐藏元素表达内容的关键
      	  formReset(formName);
  		  form.data('bootstrapValidator').resetForm();
      	  
        })
        .catch(function (error) {
          console.log(error);
        });
	}, function() {
		//alertify.error("取消");
	});
}
function setId(name,id){
	$(name).val(id);
	getInfo(name,id);
}
function getInfo(name,id){
	var url = '';
	if(name == '#multiId'){
		url = '/exam/findMultiById';
	}else if(name == '#judgeId'){
		url = '/exam/findJudgeById';
	}
	axios.post(url,id)
	.then(function (response) {
		if(name == '#multiId'){
			console.log(response.data)
			$("#multiForm [name='question']").val(response.data.question);
			$("#multiForm [name='option_a']").val(response.data.optionA);
			$("#multiForm [name='option_b']").val(response.data.optionB);
			$("#multiForm [name='option_c']").val(response.data.optionC);
			$("#multiForm [name='option_d']").val(response.data.optionD);
			$("#multiForm [name='option_e']").val(response.data.optionE);
			$("#multiForm [name='option_f']").val(response.data.optionF);
			var answer = $("#multiForm [name='answer'] option");
			for (var i = 0; i < answer.length; i++) {
				if($(answer[i]).val() == response.data.answer){
					$(answer[i]).prop('selected',true);
				}
			}
			var stage = $("#multiForm [name='stage'] option");
			for (var i = 0; i < stage.length; i++) {
				if($(stage[i]).val() == response.data.stage){
					$(stage[i]).prop('selected',true);
				}
			}
			var level = $("#multiForm [name='level'] option");
			for (var i = 0; i < level.length; i++) {
				if($(level[i]).val() == response.data.level){
					$(level[i]).prop('selected',true);
				}
			}
		}else if(name == '#judgeId'){
			$("#judgeForm [name='question']").val(response.data.question);
			
			var answer = $("#judgeForm [name='answer'] option");
			for (var i = 0; i < answer.length; i++) {
				if($(answer[i]).val() == response.data.answer){
					$(answer[i]).prop('selected',true);
				}
			}
			var stage = $("#judgeForm [name='stage'] option");
			for (var i = 0; i < stage.length; i++) {
				if($(stage[i]).val() == response.data.stage){
					$(stage[i]).prop('selected',true);
				}
			}
			var level = $("#judgeForm [name='level'] option");
			for (var i = 0; i < level.length; i++) {
				if($(level[i]).val() == response.data.level){
					$(level[i]).prop('selected',true);
				}
			}
		}
	})
}
</script>
</html>