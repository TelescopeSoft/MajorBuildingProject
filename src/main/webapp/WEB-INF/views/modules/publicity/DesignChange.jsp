<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>滨湖区重大建设项目信息公开平台</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${ctxStatic}/bower_components/bootstrap/dist/css/bootstrap.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${ctxStatic}/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${ctxStatic}/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${ctxStatic}/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${ctxStatic}/dist/css/AdminLTE.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${ctxStatic}/dist/css/skins/_all-skins.min.css">

  <link rel="stylesheet" href="${ctxStatic}/dist/css/mbp.css">
    
  <!-- Select2 -->
  <link rel="stylesheet" href="${ctxStatic}/bower_components/select2/dist/css/select2.min.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="${ctxStatic}/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

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

  <header class=" topbox">
      <div class="toptitile">滨湖区重大建设项目信息公开平台</div>
  </header>
	<%@ include file="/WEB-INF/views/modules/publicity/menu.jsp"%>
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <ol class="breadcrumb">
          <li><a href="${ctx}/publicity/project"><i class="fa fa-dashboard"></i>首页</a></li>
          <li class="active">重大设计变更</li>
        </ol>
      </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <div class="approvetitle">重大设计变更公示</div>
                        </div>
 
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="designChangeTable" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>项目代码</th>
                                        <th>项目名称</th>
                                        <th>审批事项</th>
                                        <th>审批部门</th>
                                        <th>审批结果</th>
										<th>批复文号</th>
                                        <th>审批时间</th>
                                    </tr>
                                    </thead>
                                </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
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
        <footer class="main-footer">
            <%@ include file="/WEB-INF/views/modules/publicity/foot.jsp"%>
			<!-- /.container -->
		</footer>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="${ctxStatic}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${ctxStatic}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="${ctxStatic}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${ctxStatic}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${ctxStatic}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${ctxStatic}/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${ctxStatic}/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${ctxStatic}/dist/js/demo.js"></script>
<!-- moment js -->
<script src="${ctxStatic}/bower_components/moment/moment.min.js"></script>
<script>
    $(function () {
        $('#designChangeTable').DataTable({
            'paging'      : true,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'autoWidth'   : true,
            "ajax": '${ctx}/publicity/designchange/list',
	        "columns": [
	            { "data": "prjCode" },
	            { "data": "prjName" },
	            { "data": "approveItemLabel" },
	            { "data": "approveDept" },
	            { "data": "approveResult" },
	            { "data": "approveNum" },
	            { "data": function(obj){ var day = moment(obj.approveDate);return day.format("YYYY-MM-DD")} }
	        ],
            'language': {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });

    })
</script>
</body>
</html>
