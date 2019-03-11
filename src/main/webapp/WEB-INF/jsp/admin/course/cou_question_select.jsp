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
								role="tab" aria-selected="true">选择题批量导入</a></li>
							<li class="nav-item" role="presentation"><a class="nav-link"
								data-toggle="tab" href="#exampleTabsLineTwo"
								aria-controls="exampleTabsLineTwo" role="tab"
								aria-selected="false">判断题批量导入</a></li>
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
//操作
function actionFormatter(value, row, index) {
	var _delete = "";
	var _edit = "";
	_delete = '<a class="btn btn-xs text-danger" href="javascript:void(0);" onclick="couMultiQuestionDelete('
			+ row.id + ')">删除 </a>';
	_edit = '<a class="btn btn-xs text-primary" href="javascript:void(0);" onclick="('
		+ row.id + ')">编辑未做 </a>';

	return _edit + _delete;
}
function actionFormatterJudge(value, row, index){
	var _delete = "";
	_delete = '<a class="btn btn-xs text-danger" href="javascript:void(0);" onclick="couJudgeQuestionDelete('
			+ row.id + ')">删除 </a>';
	_edit = '<a class="btn btn-xs text-primary" href="javascript:void(0);" onclick="('
		+ row.id + ')">编辑未做 </a>';
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
</script>
</html>