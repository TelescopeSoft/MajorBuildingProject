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


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->


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
						<li><a href="${ctx}/publicity/project"><i
								class="fa fa-dashboard"></i>首页</a></li>
						<li >征地信息</li>
						<li class="active">征地信息详情</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-info">
                    	<!-- /.box-header -->
                    	<div class="box-header">
                    	    <div class="approvetitle">征地信息</div>
                    	</div>
                    	<div class="box-body">
                    		<table class="table table-bordered">
                    			<tr>
                    				<td class="bg-info" width="30%">项目名称</td>
                    				<td>${detail.prjName}</td>
                    			</tr>
                    			<tr>
                    			    <td class="bg-info" width="30%">批准日期</td>
                    			    <td><fmt:formatDate value="${detail.approveDate}" pattern="yyyy-MM-dd"/></td>
                    			 </tr>
                    			 <tr>
                    			    <td class="bg-info" width="30%">批准文号</td>
                    			    <td>${detail.approveNum}</td>
                    			 </tr>
                    			 <tr>
                    			    <td class="bg-info" width="30%">征地位置	</td>
                    			    <td>${detail.address}</td>
                    			 </tr>
                    		</table>

                    	</div>

                    	<div class="box-header">
                        		<div class="approvetitle">批前</div>
                        </div>
                        <div class="box-body">
                        <table class="table">
                            <tr class="bg-info">
                                    <td width="5%">序号</td>
                                    <td width="15%">信息内容</td>
                                    <td width="40%">标题</td>
                                    <td width="5%">操作</td>
                                    <td width="25%">发布单位</td>
                                    <td width="10%">发布日期</td>
                                </tr>
                                <c:forEach items="${detail.beforeApproveList}" var="item" varStatus="status">
                                    <tr>
                                        <td>${item.sort}</td>
                                        <td>${item.content}</td>
                                        <td>${item.title}</td>
                                        <td><a href="#" onclick="${item.fileUrl}">查看</a></td>
                                        <td>${item.publicUnit}</td>
                                        <td><fmt:formatDate value="${item.publicDate}"
                                                pattern="yyyy-MM-dd" /></td>
                                    </tr>
                                </c:forEach>
                        		</table>
                        	</div>
                        <div class="box-header">
                        		<div class="approvetitle">批中</div>
                        </div>
                        <div class="box-body">
                            <table class="table">
                            <tr class="bg-info">
                                    <td width="5%">序号</td>
                                    <td width="15%">信息内容</td>
                                    <td width="40%">标题</td>
                                    <td width="5%">操作</td>
                                    <td width="25%">发布单位</td>
                                    <td width="10%">发布日期</td>
                             </tr>
                                <c:forEach items="${detail.inApproveList}" var="item" varStatus="status">
                                    <tr>
                                        <td>${item.sort}</td>
                                        <td>${item.content}</td>
                                        <td>${item.title}</td>
                                         <td><a d="myReplyFile" href="#" onclick="${item.fileUrl}">查看</a></td>
                                        <td>${item.publicUnit}</td>
                                        <td><fmt:formatDate value="${item.publicDate}"
                                                pattern="yyyy-MM-dd" /></td>
                                    </tr>
                                </c:forEach>
                        	</table>
                        </div>
                        <div class="box-header">
                        		<div class="approvetitle">批后</div>
                        </div>
                        <div class="box-body">
                            <table class="table">
                            <tr class="bg-info">
                                    <td width="5%">序号</td>
                                    <td width="15%">信息内容</td>
                                    <td width="40%">标题</td>
                                    <td width="5%">操作</td>
                                    <td width="25%">发布单位</td>
                                    <td width="10%">发布日期</td>
                             </tr>
                                <c:forEach items="${detail.afterApproveList}" var="item" varStatus="status">
                                    <tr>
                                        <td>${item.sort}</td>
                                        <td>${item.content}</td>
                                        <td>${item.title}</td>
                                         <td><a href="#" onclick="${item.fileUrl}">查看</a></td>
                                        <td>${item.publicUnit}</td>
                                        <td><fmt:formatDate value="${item.publicDate}"
                                                pattern="yyyy-MM-dd" /></td>
                                    </tr>
                                </c:forEach>
                        	</table>
                        </div>

                        <div class="text-center">
                        <button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
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

	<!-- jQuery 3 -->
	<!--<script src="${ctxStatic}/bower_components/jquery/dist/jquery.min.js"></script>-->
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${ctxStatic}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- SlimScroll -->
	<script
		src="${ctxStatic}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="${ctxStatic}/bower_components/fastclick/lib/fastclick.js"></script>
	<script src="${ctxStatic}/dist/js/expropriationDetailInfo.js"></script>

	<script>
    </script>
</body>
</html>
