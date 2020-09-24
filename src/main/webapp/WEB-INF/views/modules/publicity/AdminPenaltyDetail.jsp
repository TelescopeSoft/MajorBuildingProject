<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>滨湖区重大建设项目信息公开平台</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${ctxStatic}/bower_components/bootstrap/dist/css/bootstrap.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${ctxStatic}/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${ctxStatic}/bower_components/Ionicons/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${ctxStatic}/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${ctxStatic}/dist/css/AdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${ctxStatic}/dist/css/skins/_all-skins.css">

<link rel="stylesheet" href="${ctxStatic}/dist/css/mbp.css">

<!-- Select2 -->
<link rel="stylesheet"
	href="${ctxStatic}/bower_components/select2/dist/css/select2.min.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet"
	href="${ctxStatic}/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  -->

</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
	<div class="wrapper">

		<%@ include file="/WEB-INF/views/modules/publicity/header.jsp"%>
		<%@ include file="/WEB-INF/views/modules/publicity/menu.jsp"%>
		<!-- Full Width Column -->
		<div class="content-wrapper">
			<div class="container">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<ol class="breadcrumb">
						<li><a href="${ctx}/publicity/project"><i
								class="fa fa-dashboard"></i>首页</a></li>
						<li class="active">行政处罚</li>
					</ol>
				</section>

				<!-- Main content -->
                        <section class="content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="box box-info">
                                    	<!-- /.box-header -->
                                    	<div class="box-body">
                                    		<table class="table table-bordered">
                                    			<tr>
                                    				<td class="bg-info" width="30%">行政处罚决定书文号</td>
                                    				<td width="70%">${bean.letterOfDecision}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">处罚名称	</td>
                                    				<td width="70%">${bean.name}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">处罚类别1</td>
                                    				<td width="70%">${bean.punishCategory}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">处罚事由</td>
                                    				<td width="70%">${bean.punishReason}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">处罚依据</td>
                                    				<td width="70%">${bean.punishBasis}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">行政相对人名称</td>
                                    				<td width="70%">${bean.adminRelativePerson}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">行政相对人代码_1 (统一社会信用代码)	</td>
                                    				<td width="70%">${bean.adminRelativePersonCode}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">法定代表人姓名</td>
                                    				<td width="70%">${bean.legalRepresentative}</td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">处罚结果</td>
                                    				<td width="70%">${bean.punishResult}</td>
                                    			</tr>
                                                <tr>
                                     				<td class="bg-info" width="30%">处罚决定日期</td>
                                     				<td width="70%"><fmt:formatDate value="${bean.punishmentDecisionDate}" pattern="yyyy-MM-dd"/></td>
                                     			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">处罚机关</td>
                                    				<td width="70%">${bean.punishDeptLabel}</td>
                                    			</tr>
                                                <!--<tr>
                                    				<td class="bg-info" width="30%">地方编码</td>
                                    				<td width="70%"></td>
                                    			</tr>
                                                <tr>
                                    				<td class="bg-info" width="30%">数据更新时间戳</td>
                                    				<td width="70%"></td>
                                    			</tr>-->
                                                <tr>
                                    				<td class="bg-info" width="30%">公示日期</td>
                                    				<td width="70%"><fmt:formatDate value="${bean.publicDeadline}" pattern="yyyy-MM-dd"/></td>
                                    			</tr>
                                    		</table>
                                    	</div>
                                    </div>
                                    <div class="text-center">
                                        <button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
                                    </div>
                                </div>
                                <!-- /.col -->


                            </div>
                            <!-- /.row -->

                        </section>
                        <!-- /.content -->

			</div>
			<!-- /.container -->
		</div>
		<!-- /.content-wrapper -->
		<footer>
			<%@ include file="/WEB-INF/views/modules/publicity/footer.jsp"%>
			<!-- /.container -->
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script src="${ctxStatic}/bower_components/jquery/dist/jquery.min.js"></script>
	<!--[if IE 8]>
    <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.9.1.js"></script>
    <![endif]-->
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${ctxStatic}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<script
		src="${ctxStatic}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="${ctxStatic}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="${ctxStatic}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="${ctxStatic}/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="${ctxStatic}/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${ctxStatic}/dist/js/demo.js"></script>

	<!-- moment js -->
	<script src="${ctxStatic}/bower_components/moment/moment.min.js"></script>


</script>
</body>
</html>
