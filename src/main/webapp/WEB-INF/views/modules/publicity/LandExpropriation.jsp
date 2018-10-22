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
<!-- Theme style -->
<link rel="stylesheet" href="${ctxStatic}/dist/css/AdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${ctxStatic}/dist/css/skins/_all-skins.css">

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

		<header class="topbox">
			<div class="toptitile">滨湖区重大建设项目信息公开平台</div>
		</header>
		<%@ include file="/WEB-INF/views/modules/publicity/menu.jsp"%>
		
		<!-- Full Width Column -->
		<div class="content-wrapper">
			<div class="container">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<ol class="breadcrumb">
						<li><a href="${ctxStatic}/publicity/project"><i class="fa fa-dashboard"></i>首页</a></li>
						<li class="active">土地征收</li>
					</ol>
				</section>

				<!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">征地告知书</h3>
                            <div class="box-tools pull-right">
                                <a href="#">更多&gt;&gt;</a>
                            </div>
                        </div>

                        <div class="box-body">
                            <table class="table table-bordered">
                                <tr>
                                    <td width="80%"><a href="http://z.jsmlr.gov.cn/jstdgk/xxgkController/turnToMyDetail.do?ggid=59e996651df949549bdda9fb95f89804&unitCode=320211&flag=1" target="_blank">THXC2017-地块7立信大道与震泽路东北侧地块告知</a></td>
                                    <td width="20%">2018-04-10</td>
                                </tr>
                            </table>
                        </div>
                    </div>

                </div>

                <div class="col-md-6">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">征收土地公告</h3>
                            <div class="box-tools pull-right">
                                <a href="#">更多&gt;&gt;</a>
                            </div>
                        </div>

                        <div class="box-body">
                            <table class="table table-bordered">
                                <tr>
                                    <td width="80%"><a href="http://xzfw.wuxi.gov.cn/doc/2018/03/19/1770459.shtml" target="_blank">BHXL2017-地块20土地征收方案</a></td>
                                    <td width="20%">2017-12-22</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">安置补偿方案公告</h3>
                            <div class="box-tools pull-right">
                                <a href="#">更多&gt;&gt;</a>
                            </div>
                        </div>

                        <div class="box-body">
                            <table class="table table-bordered">
                                <tr>
                                    <td width="80%"><a href="http://z.jsmlr.gov.cn/jstdgk/xxgkController/turnToMoreDetail.do?lcid=ce98f6fe28d44eb2818f506cf23588b0&unitCode=320211&flag=4" target="_blank">BHXL2017-地块15补偿安置方案</a></td>
                                    <td width="20%">2017-12-13</td>
                                </tr>
                            </table>
                        </div>
                    </div>

                </div>

                <div class="col-md-6">

                </div>
            </div>
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
	 
</body>
</html>
