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

    <div class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a href="${ctxStatic}/publicity/index" class="navbar-brand"></a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${ctx}/publicity/index">您正在访问：首页 &gt;&gt;重大项目 &gt;&gt;${projectinfo.prjname} </a></li>
                    </ul>
                </div>

                </div>
        </div>
    </nav>
    </div>
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container">
      <!-- Content Header (Page header) -->
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#basic" data-toggle="tab">基本信息</a></li>
                                <li><a href="#approve" data-toggle="tab">批准结果</a></li>
                                <li><a href="#tender" data-toggle="tab">招标投标</a></li>
                                <li><a href="#contract" data-toggle="tab">合同备案</a></li>
                                <li><a href="#safty" data-toggle="tab">安全监督</a></li>
                                <li><a href="#quality" data-toggle="tab">质量监督</a></li>
                                <li><a href="#construction" data-toggle="tab">施工信息</a></li>
                                <!--<li><a href="#safetysupervision" data-toggle="tab">质量安全监督</a></li>-->
                                <li><a href="#finish" data-toggle="tab">竣工信息</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="basic">
             
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="approve">
                                    
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tender">
                                    
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="contract">
                                   
                                </div>
                                <div class="tab-pane" id="safty">
                                </div>
                                <div class="tab-pane" id="quality">
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="construction">
                                    <div class="box-header">
                                        <div class="approvetitle">项目法人单位：<span >无锡山水慧谷城镇建设发展有限公司</span></div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered">
                                            <tr class="bg-info">
                                                <td >岗位</td>
                                                <td >姓名</td>
                                                <td >身份证号码</td>
                                                <td >联系电话</td>
                                            </tr>
                                            <tr>
                                                <td>主要负责人</td>
                                                <td>杜星</td>
                                                <td>3202221982******18</td>
                                                <td>13861837138</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="box-header">
                                        <div class="approvetitle">勘察单位：<span >无锡水文工程地质勘察院</span></div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered">
                                            <tr class="bg-info">
                                                <td >岗位</td>
                                                <td >姓名</td>
                                                <td >身份证号码</td>
                                                <td >联系电话</td>
                                                <td>资质证书编号</td>
                                                <td>资质类型和等级</td>
                                                <td>资格类型及证号</td>
                                            </tr>
                                            <tr>
                                                <td>项目负责人</td>
                                                <td>王小敏</td>
                                                <td>4329301981******11</td>
                                                <td>13771045130</td>
                                                <td>B132045050</td>
                                                <td>甲级</td>
                                                <td>AY093200689</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="box-header">
                                        <div class="approvetitle">设计单位：<span >江苏中设集团股份有限公司</span></div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered">
                                            <tr class="bg-info">
                                                <td >岗位</td>
                                                <td >姓名</td>
                                                <td >身份证号码</td>
                                                <td >联系电话</td>
                                                <td>资质证书编号</td>
                                                <td>资质类型和等级</td>
                                                <td>资格类型及证号</td>
                                            </tr>
                                            <tr>
                                                <td>项目负责人</td>
                                                <td>朱炯为</td>
                                                <td>3202221973******17</td>
                                                <td>033201047</td>
                                                <td>A132002170-6/6</td>
                                                <td>甲级</td>
                                                <td>033201047</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="box-header">
                                        <div class="approvetitle">施工单位：<span >无锡市亨利富建设发展有限公司	</span></div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered">
                                            <tr class="bg-info">
                                                <td >岗位</td>
                                                <td >姓名</td>
                                                <td >身份证号码</td>
                                                <td >联系电话</td>
                                                <td>资质证书编号</td>
                                                <td>资质类型和等级</td>
                                                <td>资格类型及证号</td>
                                            </tr>
                                            <tr>
                                                <td>项目经理	</td>
                                                <td>冯铭伟</td>
                                                <td>3202111984******18</td>
                                                <td>13861779988</td>
                                                <td>D132041132</td>
                                                <td>一级</td>
                                                <td>苏建安B(2011)0200719</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="box-header">
                                        <div class="approvetitle">监理单位：<span >无锡太湖明珠建设咨询有限公司		</span></div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered">
                                            <tr class="bg-info">
                                                <td >岗位</td>
                                                <td >姓名</td>
                                                <td >身份证号码</td>
                                                <td >联系电话</td>
                                                <td>资质证书编号</td>
                                                <td>资质类型和等级</td>
                                                <td>资格类型及证号</td>
                                            </tr>
                                            <tr>
                                                <td>项目总监</td>
                                                <td>朱建荣</td>
                                                <td>3202111963******13</td>
                                                <td>15190277511</td>
                                                <td>E132000394</td>
                                                <td>甲级</td>
                                                <td></td>
                                            </tr>
                                        </table>
                                    </div>

                                    <div class="box-header">
                                        <div class="approvetitle">施工期环境保护措施落实情况</div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered ">
                                            <tr class="bg-info">
                                                <td width="30%">落实事项</td>
                                                <td width="70%">落实情况</td>
                                            </tr>
                                            <tr>
                                                <td>扬尘检查情况、整改情况</td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td>施工场地出入口车辆冲洗检查情况， 整改情况</td>
                                                <td></td>
                                            </tr>

                                            </table>
                                        </div>
                                </div>
                                <!-- /.tab-pane -->

                                <div class="tab-pane" id="finish">
                                    
                                </div>
                                <!-- /.tab-pane -->
                            </div>
                            <!-- /.tab-content -->
                        </div>
                    </div>
                    <!-- /.box -->
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
  <footer class="main-footer">
    <div class="container">
      <div class="pull-right hidden-xs">
        <b>版本</b> 1.0.0
      </div>
        <div class="row">
            <div class="text-center"></div>
        </div>

    </div>
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
<script>
	//准备tabs数据
	var tabsData = [{
	    "id" : "basic",
	    "url" : "${ctx}/publicity/projectdetailbasic?pkid=${projectinfo.pkid}"
	},{
	    "id" : "approve",
	    "url" : "${ctx}/publicity/projectdetailapprove?pkid=${projectinfo.pkid}"
	},{
	    "id" : "tender",
	    "url" : "${ctx}/publicity/projectdetailtender?pkid=${projectinfo.pkid}"
	},{
	    "id" : "contract",
	    "url" : "${ctx}/publicity/projectdetailcontract?pkid=${projectinfo.pkid}"
	},{
	    "id" : "safty",
	    "url" : "${ctx}/publicity/projectdetailsafty?pkid=${projectinfo.pkid}"
	},{
	    "id" : "quality",
	    "url" : "${ctx}/publicity/projectdetailquality?pkid=${projectinfo.pkid}"
	},{
	    "id" : "construction",
	    "url" : "${ctx}/publicity/projectdetailconstruction?pkid=${projectinfo.pkid}"
	},{
	    "id" : "finish",
	    "url" : "${ctx}/publicity/projectdetailfinish?pkid=${projectinfo.pkid}"
	} ];
	
	function tabsHandler(event) {
	    var data = event.data;
	    showTabs(data.id,data.url);
	    return false; //阻止默认a标签响应
	}
	
	function showTabs(tabsId,url) {
	    $("a[href='#"+tabsId+"']").tab('show');
	    var $tabContent = $('#'+tabsId);
	    if($tabContent.length < 100) {
	        $tabContent.load(url);
	        //console.info(tabsId + ' load done!');
	    }
	}
	
    $(function () {
    	$(tabsData).each(function(){
    	    //console.info(this.id + "--->" + this.url);
    	    $("a[href='#"+this.id+"']").bind('click',{
    	        id : this.id,
    	        url : this.url
    	    },tabsHandler);
    	});
    	
    	showTabs(tabsData[0].id,tabsData[0].url);
    })
</script>
</body>
</html>
