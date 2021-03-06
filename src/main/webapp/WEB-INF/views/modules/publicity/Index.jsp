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
  <link rel="stylesheet" href="${ctxStatic}/dist/css/skins/_all-skins.css">

    <link rel="stylesheet" href="${ctxStatic}/dist/css/mbp.css">

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
  <!--
    <div class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a href="Index.html" class="navbar-brand"></a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                    <i class="fa fa-bars"></i>
                </button>
            </div>

            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${ctx}/publicity/project">重大项目</a></li>
                    <li><a href="${ctx}/publicity/approveguide">批准服务</a></li>
                    <li><a href="ApproveResult.html">批准结果</a></li>
                    <li><a href="Tender.html">招标投标</a></li>
                    <li><a href="LandExpropriation.html">土地征收</a></li>
                    <li><a href="#">重大设计变更</a></li>
                    <li><a href="Construction.html">施工信息</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">质量安全监督<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="QualitySupervisor.html">质量监督</a></li>
                            <li><a href="SaftySupervisor.html">安全监督</a></li>
                            <li><a href="AdminPenalty.html">行政处罚</a></li>
                        </ul>
                    </li>
                    <li><a href="Complete.html">竣工信息</a></li>
                </ul>
            </div>
        </div>
    </nav>
    </div> -->
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <ol class="breadcrumb">
          <li><a href="${ctx}/publicity/project"><i class="fa fa-dashboard"></i>首页</a></li>
          <li class="active">重大项目</li>
        </ol>
      </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <div class="approvetitle">项目列表</div>
                        </div>

                        <!-- form start -->
                        <form role="form" action="${pageContext.request.contextPath}/publicity/index" method="post">
                            <div class="box-body">
                                <div class="row form-group">
                                    <div class="col-xs-3">
                                        <input name="prjname" type="text" class="form-control" placeholder="项目名称">
                                    </div>
                                    <div class="col-xs-4">
                                        <input name="prjnum"  type="text" class="form-control" placeholder="项目编码">
                                    </div>
                                    <div class="col-xs-4">
                                        <input name="buildcorpname"  type="text" class="form-control" placeholder="建设单位">
                                    </div>
                                    <div class="col-xs-1">
                                        <button type="submit" class="btn btn-primary">查询</button>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->

                        </form>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="projectList" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>项目名称</th>
                                    <th>立项文号</th>
                                    <th>项目编码</th>
                                    <th>建设单位</th>
                                    <!--<th>施工图审查数</th>
                                    <th>招投标数</th>
                                    <th>合同备案数</th>
                                    <th>安全报监数</th>
                                    <th>质量报监数</th>
                                    <th>施工许可数</th>
                                    <th>竣工备案数</th>-->
                                    <!--<th>项目地址</th>-->
                                </tr>
                                </thead>
                                <!--
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td><a href="ProjectDetail.html">无锡信捷电气股份有限公司年产20万台运动型PLC、高端伺服驱动器建设项目</a> </td>
                                    <td>滨湖发改备[2018]27号</td>
                                    <td><a href="ProjectDetail.html">3202111806150102</a></td>
                                    <td>无锡信捷电气股份有限公司</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td><a href="ProjectDetail.html">方泉苑六期一批安置房</a> </td>
                                    <td> 锡滨发改许[2017]9号</td>
                                    <td><a href="ProjectDetail.html">3202111706060101</a></td>
                                    <td>无锡山水慧谷城镇建设发展有限公司</td>
                                </tr>
                                </tbody>-->

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
<script>
    $(function () {

        $('#projectList').DataTable({
            'paging'      : true,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'autoWidth'   : true,
            "ajax": "${pageContext.request.contextPath}/publicity/projects?prjname=${projectinfo.prjname}&prjnum=${projectinfo.prjnum}&buildcorpname=${projectinfo.buildcorpname}",
	        "columns": [
	            { "data": "prjname" },
	            { "data": "prjapprovalnum" },
	            { "data": "prjnum" },
	            { "data": "buildcorpname" }
	        ],
	        "columnDefs": [{
	            "render": function(data, type, row, meta ) {
	            	if(data != null){
	                    return '<a href="${ctx}/publicity/projectdetail?pkid='+row.pkid+'">' + data + '</a>';
	                 }else{
	                        return "";
	                 }
	            },
	            "targets": 0
	        }],
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
