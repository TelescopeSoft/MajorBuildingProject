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
                    <li class="active"><a href="Index.html">您正在访问：首页 &gt;&gt;重大项目 &gt;&gt;${projectinfo.prjname} </a></li>
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
                                <li><a href="#complete" data-toggle="tab">竣工</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="basic">
                                    <div class="box box-info">
                                        <!-- /.box-header -->
                                        <div class="box-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td  class="bg-info">项目代码</td>
                                                    <td>2017-320211-79-01-503424</td>
                                                    <td class="bg-info">项目名称</td>
                                                    <td >方泉苑六期一批安置房</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">行政审批编号</td>
                                                    <td>20170763</td>
                                                    <td class="bg-info">立项文号</td>
                                                    <td >锡滨发改许[2017]9号</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">住建项目编号</td>
                                                    <td>3202111706060101</td>
                                                    <td class="bg-info">项目分类</td>
                                                    <td >房屋建筑工程</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">项目（法人）单位</td>
                                                    <td>无锡山水慧谷城镇建设发展有限公司</td>
                                                    <td class="bg-info">项目（法人）单位组织机构代码</td>
                                                    <td >91320211679801268Q</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">立项级别</td>
                                                    <td>地级市</td>
                                                    <td class="bg-info">项目地址</td>
                                                    <td >滨湖区缘溪道与兴隆路交叉口西北侧</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">经度</td>
                                                    <td>120.26906</td>
                                                    <td class="bg-info">纬度</td>
                                                    <td >31.43400</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">建设用地规划许可证编号</td>
                                                    <td></td>
                                                    <td class="bg-info">建设工程规划许可证编号</td>
                                                    <td ></td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">拟开工时间（年）</td>
                                                    <td></td>
                                                    <td class="bg-info">拟建成时间（年）</td>
                                                    <td ></td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">建设规模及内容</td>
                                                    <td></td>
                                                    <td class="bg-info">总投资（万元）</td>
                                                    <td ></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>

                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="approve">
                                    
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tender">
                                    <div class="box box-info">
                                        <!-- /.box-header -->
                                        <div class="box-header">
                                            <div class="approvetitle">资格预审公告</div>
                                        </div>
                                        <div class="box-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td  class="bg-info" width="10%">公告名称</td>
                                                    <td width="70%"><a href="http://xzfw.wuxi.gov.cn/doc/2018/03/19/1770459.shtml" target="_blank">
                                                        [WXBH201802001-W02]方泉苑六期一批安置房项目方泉苑六期一批安置房（A地块）项目监理
                                                    </a></td>
                                                    <td class="bg-info" width="10%">时间</td>
                                                    <td width="10%">2018-03-19</td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="box-header">
                                            <div class="approvetitle">招标公告</div>
                                        </div>

                                        <div class="box-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td  class="bg-info" width="10%">公告名称</td>
                                                    <td width="70%"><a href="http://xzfw.wuxi.gov.cn/doc/2018/03/09/1761653.shtml" target="_blank">
                                                        [WXBH201802001-W02]方泉苑六期一批安置房项目方泉苑六期一批安置房（A地块）项目监理
                                                    </a></td>
                                                    <td class="bg-info" width="10%">时间</td>
                                                    <td width="10%">2018-03-09</td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="box-header">
                                            <div class="approvetitle">中标候选人公示</div>
                                        </div>

                                        <div class="box-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td  class="bg-info" width="10%">公告名称</td>
                                                    <td width="70%"><a href="http://xzfw.wuxi.gov.cn/doc/2018/04/15/1808826.shtml" target="_blank">
                                                        [WXBH201802001-W02]方泉苑六期一批安置房项目方泉苑六期一批安置房（A地块）项目监理
                                                    </a></td>
                                                    <td class="bg-info" width="10%">时间</td>
                                                    <td width="10%">2018-04-15 </td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="box-header">
                                            <div class="approvetitle">中标结果</div>
                                        </div>
                                        <div class="box-body">
                                            <table class="table table-bordered">
                                                <tr>
                                                    <td  class="bg-info">项目编号</td>
                                                    <td>3202111706060101</td>
                                                    <td class="bg-info">标段名称</td>
                                                    <td  >方泉苑六期一批安置房（A地块）项目施工</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">中标通知书编号</td>
                                                    <td>3202111706060101-BD-001</td>
                                                    <td class="bg-info">中标通知书内部编号</td>
                                                    <td >WXBH201802001-W01</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">招标类型</td>
                                                    <td>施工</td>
                                                    <td class="bg-info">招标方式</td>
                                                    <td >公开招标</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">中标日期</td>
                                                    <td>2018-04-09</td>
                                                    <td class="bg-info">中标金额</td>
                                                    <td >19879.3070</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info" width="15%">招标代理单位名称</td>
                                                    <td width="35%">江苏省建友工程项目管理咨询有限公司</td>
                                                    <td class="bg-info" width="15%">招标代理单位组织机构代码
                                                        （社会信用代码）</td>
                                                    <td width="35%">75050049-3</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">中标单位名称</td>
                                                    <td>无锡市亨利富建设发展有限公司</td>
                                                    <td class="bg-info">中标单位组织机构代码
                                                        （社会信用代码）</td>
                                                    <td >73956029-2</td>
                                                </tr>
                                                <tr>
                                                    <td  class="bg-info">项目经理/总监理工程师姓名</td>
                                                    <td>冯铭伟</td>
                                                    <td class="bg-info">项目经理/总监理工程师电话</td>
                                                    <td >13861779988</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="contract">
                                    <div class="box-header">
                                        <div class="approvetitle">合同列表</div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered ">
                                            <tr class="bg-info">
                                                <td>合同备案编号</td>
                                                <td>合同项目名称</td>
                                                <td>合同类别</td>
                                                <td>发包单位名称</td>
                                                <td>承包单位名称</td>
                                                <td>合同金额（万元）</td>
                                                <td>合同签订日期</td>
                                            </tr>

                                            <tr>
                                                <td>3202111706060101-HZ-001</td>
                                                <td>方泉苑六期一批安置房（A地块）项目施工</td>
                                                <td>施工总承包</td>
                                                <td>无锡山水慧谷城镇建设发展有限公司</td>
                                                <td>展有限公司	无锡市亨利富建设发展有限公司</td>
                                                <td>19879.3070</td>
                                                <td>2018-04-13</td>
                                            </tr>
                                            <tr>
                                                <td>3202111706060101-HE-001</td>
                                                <td>方泉苑六期一批安置房（A地块）项目监理</td>
                                                <td>监理</td>
                                                <td>无锡山水慧谷城镇建设发展有限公司</td>
                                                <td>无锡太湖明珠建设咨询有限公司</td>
                                                <td>180.0000</td>
                                                <td>2018-04-27</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="tab-pane" id="safty">
                                    <div class="box-header">
                                        <div class="approvetitle">安全监督</div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered ">
                                            <tr class="bg-info">
                                                <th>项目名称</th>
                                                <th>项目编号</th>
                                                <th>立项批准文号</th>
                                                <th>报监工程名称</th>
                                                <th>安全监督机构名称</th>
                                                <th>建设单位名称</th>
                                                <th>报监日期</th>
                                                <th>申办人</th>
                                                <th>投资类型</th>
                                                <th>建设性质</th>
                                            </tr>
                                            <tr>
                                                <td>方泉苑六期一批安置房</td>
                                                <td>3202111706060101</td>
                                                <td>锡滨发改许[2017]9号</td>
                                                <td>方泉苑六期一批安置房(A地块）项目施工	</td>
                                                <td>无锡市滨湖区建筑工程安全监督站</td>
                                                <td>无锡山水慧谷城镇建设发展有限公司</td>
                                                <td>2018-06-29</td>
                                                <td>陆伟峰</td>
                                                <td>政府投资</td>
                                                <td>新建</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="tab-pane" id="quality">
                                    <div class="box-header">
                                        <div class="approvetitle">质量监督</div>
                                    </div>

                                    <div class="box-body">
                                        <table class="table table-bordered ">
                                            <tr class="bg-info">
                                                <th>项目名称</th>
                                                <th>项目编号</th>
                                                <th>立项批准文号</th>
                                                <th>报监工程名称</th>
                                                <th>质量监督机构名称</th>
                                                <th>建设单位名称</th>
                                                <th>报监日期</th>
                                                <th>申办人</th>
                                                <th>投资类型</th>
                                                <th>建设性质</th>
                                            </tr>
                                            <tr>
                                                <td>方泉苑六期一批安置房</td>
                                                <td>3202111706060101</td>
                                                <td>锡滨发改许[2017]9号</td>
                                                <td>方泉苑六期一批安置房(A地块）项目施工	</td>
                                                <td>无锡市滨湖区建设工程质量监督站</td>
                                                <td>无锡山水慧谷城镇建设发展有限公司</td>
                                                <td>2018-06-29</td>
                                                <td>陆伟峰</td>
                                                <td>政府投资</td>
                                                <td>新建</td>
                                            </tr>
                                        </table>
                                    </div>
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

                                <div class="tab-pane" id="complete">
                                    <div class="box-header">
                                        <div class="approvetitle">竣工备案信息</div>
                                    </div>
                                    <div class="box-body">
                                        <table class="table table-bordered">
                                            <tr>
                                                <td  class="bg-info" width="15%">竣工备案编号</td>
                                                <td width="35%">3202111706060101-JX-001</td>
                                                <td class="bg-info" width="15%">备案项目名称</td>
                                                <td width="35%" >	方泉苑五期棚户区改造（E块E1-E11号房及E块地下室）</td>
                                            </tr>
                                            <tr>
                                                <td  class="bg-info" width="15%">施工许可证编号</td>
                                                <td width="35%">320211020140026</td>
                                                <td class="bg-info" width="15%">质量检测机构名称</td>
                                                <td width="35%" >无锡市滨湖区建设工程安全监督站</td>
                                            </tr>
                                            <tr>
                                                <td  class="bg-info" width="15%">实际造价（万元）</td>
                                                <td width="35%">7094.0000</td>
                                                <td class="bg-info" width="15%">实际面积（平方米）</td>
                                                <td width="35%" >48532.00</td>
                                            </tr>
                                            <tr>
                                                <td  class="bg-info" width="15%">实际开工日期</td>
                                                <td width="35%">2011-01-01</td>
                                                <td class="bg-info" width="15%">实际竣工验收日期</td>
                                                <td width="35%" >2011-10-31</td>
                                            </tr>
                                            <tr>
                                                <td  class="bg-info" width="15%">结构体系</td>
                                                <td width="35%"  >框架结构</td>
                                                <td class="bg-info" width="15%">实际建设规模</td>
                                                <td width="35%" ></td>

                                            </tr>
                                            <tr>
                                                <td  class="bg-info" width="15%">竣工决算审计单位</td>
                                                <td width="35%" ></td>
                                                <td class="bg-info" width="15%">财务决算金额</td>
                                                <td width="35%" ></td>

                                            </tr>
                                            <tr>
                                                <td  class="bg-info" width="15%">审计结论</td>
                                                <td width="35%" colspan="3"></td>


                                            </tr>
                                            </table>
                                        </div>
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
	    "url" : "pages/test-paper.jsp"
	},{
	    "id" : "approve",
	    "url" : "${ctx}/publicity/projectdetailapprove"
	}];
	
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
    })
</script>
</body>
</html>
