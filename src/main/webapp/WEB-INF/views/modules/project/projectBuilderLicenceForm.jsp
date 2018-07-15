<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>施工许可信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/project/projectBuilderLicence/">施工许可信息列表</a></li>
		<li class="active"><a href="${ctx}/project/projectBuilderLicence/form?id=${projectBuilderLicence.id}">施工许可信息<shiro:hasPermission name="project:projectBuilderLicence:edit">${not empty projectBuilderLicence.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:projectBuilderLicence:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="projectBuilderLicence" action="${ctx}/project/projectBuilderLicence/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">pkid：</label>
			<div class="controls">
				<form:input path="pkid" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工许可项目名称：</label>
			<div class="controls">
				<form:input path="builderlicencename" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工许可证编号：</label>
			<div class="controls">
				<form:input path="builderlicencenum" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工许可证内部编号：</label>
			<div class="controls">
				<form:input path="builderlicenceinnernum" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同备案编码：</label>
			<div class="controls">
				<form:input path="recordinnernum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目编号：</label>
			<div class="controls">
				<form:input path="prjnum" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设用地规划许可证编号：</label>
			<div class="controls">
				<form:input path="buldplannum" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设工程规划许可证编号：</label>
			<div class="controls">
				<form:input path="projectplannum" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工图审查合格书编号：</label>
			<div class="controls">
				<form:input path="censornum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同金额(万元)：</label>
			<div class="controls">
				<form:input path="contractmoney" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">面积（平方米）：</label>
			<div class="controls">
				<form:input path="area" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设规模：</label>
			<div class="controls">
				<form:input path="prjsize" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发证日期：</label>
			<div class="controls">
				<input name="issuecertdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${projectBuilderLicence.issuecertdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">勘察单位名称：</label>
			<div class="controls">
				<form:input path="econcorpname" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">勘察单位组织机构代码（社会信用代码：</label>
			<div class="controls">
				<form:input path="econcorpcode" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设计单位名称：</label>
			<div class="controls">
				<form:input path="designcorpname" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设计单位组织机构代码（社会信用代码）：</label>
			<div class="controls">
				<form:input path="designcorpcode" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工单位名称：</label>
			<div class="controls">
				<form:input path="conscorpname" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工单位组织机构代码（社会信用代码：</label>
			<div class="controls">
				<form:input path="conscorpcode" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">施工单位安全生产许可证编号：</label>
			<div class="controls">
				<form:input path="safetycerid" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">监理单位名称：</label>
			<div class="controls">
				<form:input path="supercorpname" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">监理单位组织机构代码（社会信用代码）：</label>
			<div class="controls">
				<form:input path="supercorpcode" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目经理姓名：</label>
			<div class="controls">
				<form:input path="constructorname" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目经理证件类型：</label>
			<div class="controls">
				<form:input path="cidcardtypenum" htmlEscape="false" maxlength="1" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目经理证件号码：</label>
			<div class="controls">
				<form:input path="constructoridcard" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目经理电话号码：</label>
			<div class="controls">
				<form:input path="constructorphone" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总监理工程师姓名：</label>
			<div class="controls">
				<form:input path="supervisionname" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总监理工程师证件类型：</label>
			<div class="controls">
				<form:input path="sidcardtypenum" htmlEscape="false" maxlength="1" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总监理工程师证件号码：</label>
			<div class="controls">
				<form:input path="supervisionidcard" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总监理工程师电话：</label>
			<div class="controls">
				<form:input path="supervisionphone" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">记录登记时间：</label>
			<div class="controls">
				<input name="createdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${projectBuilderLicence.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据更新标识：</label>
			<div class="controls">
				<form:input path="updateflag" htmlEscape="false" maxlength="1" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上报地区编码：</label>
			<div class="controls">
				<form:input path="sbdqbm" htmlEscape="false" maxlength="6" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">datastate：</label>
			<div class="controls">
				<form:input path="datastate" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">cjrqsj：</label>
			<div class="controls">
				<input name="cjrqsj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${projectBuilderLicence.cjrqsj}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xgrqsj：</label>
			<div class="controls">
				<input name="xgrqsj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${projectBuilderLicence.xgrqsj}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">scrqsj：</label>
			<div class="controls">
				<input name="scrqsj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${projectBuilderLicence.scrqsj}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">returnresult：</label>
			<div class="controls">
				<form:input path="returnresult" htmlEscape="false" maxlength="-1" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">updateuser：</label>
			<div class="controls">
				<form:input path="updateuser" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xzsp_sgxk：</label>
			<div class="controls">
				<form:input path="xzspSgxk" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="project:projectBuilderLicence:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>