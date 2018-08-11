<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发改申报项目基本信息管理</title>
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
		<li><a href="${ctx}/project/applyProjectInfo/">发改申报项目基本信息列表</a></li>
		<li class="active"><a href="${ctx}/project/applyProjectInfo/form?id=${applyProjectInfo.id}">发改申报项目基本信息<shiro:hasPermission name="project:applyProjectInfo:edit">${not empty applyProjectInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:applyProjectInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="applyProjectInfo" action="${ctx}/project/applyProjectInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>

		<div class="control-group">
			<label class="control-label">项目代码：</label>
			<div class="controls">
				<form:input path="projectCode" htmlEscape="false" maxlength="32" class="input-xlarge"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目名称：</label>
			<div class="controls">
				<form:input path="projectName" htmlEscape="false" maxlength="512" class="input-xxlarge"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">住建项目编码：</label>
			<div class="controls">
				<form:input path="prjNum" htmlEscape="false" maxlength="32" class="input-xlarge"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">项目类型：</label>
			<div class="controls">
				<form:input path="projectType" htmlEscape="false" maxlength="6" class="input-xlarge"/>
				<span class="help-inline"><font color="red">*</font> ${applyProjectInfo.projectTypeLabel}</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设性质：</label>
			<div class="controls">
				<form:input path="projectNature" htmlEscape="false" maxlength="2" class="input-xlarge"/>
				<span class="help-inline"><font color="red">*</font> ${applyProjectInfo.projectNatureLabel}</span>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">核准目录分类：</label>
			<div class="controls">
				<form:input path="catalogName" htmlEscape="false" class="input-xlarge"/>
			</div>
		</div>
		<div class="control-group">
        	<label class="control-label">项目（法人）单位：</label>
        	    <div class="controls">
        		    <form:input path="enterpriseName" htmlEscape="false" class="input-xlarge"/>
        		</div>
        </div>
        <div class="control-group">
          	<label class="control-label">项目法人证照类型：</label>
          	    <div class="controls">
          		    <form:input path="lerepCertType" htmlEscape="false"  class="input-xlarge"/>
          		</div>
          </div>
        <div class="control-group">
             	<label class="control-label">项目法人证照号码：</label>
             	    <div class="controls">
             		    <form:input path="lerepCertNo" htmlEscape="false" class="input-xlarge"/>
             		</div>
             </div>
		<div class="control-group">
			<label class="control-label">拟开工时间：</label>
			<div class="controls">
				<form:input path="startYear" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拟建成时间：</label>
			<div class="controls">
				<form:input path="endYear" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总投资额（万元）：</label>
			<div class="controls">
				<form:input path="totalMoney" htmlEscape="false" maxlength="16" class="input-xlarge"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设地点：</label>
			<div class="controls">
				<form:input path="placeCode" htmlEscape="false" maxlength="16" class="input-xlarge"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目详细地址：</label>
			<div class="controls">
				<form:input path="addressDetail" htmlEscape="false" maxlength="1024" class="input-xlarge"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">国标行业：</label>
			<div class="controls">
				<form:input path="industry" htmlEscape="false" maxlength="6" class="input-xlarge "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设规模及内容：</label>
			<div class="controls">
				<form:textarea  path="scaleContent" htmlEscape="false" maxlength="4000" class="input-xxlarge" rows="5" cols="80" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">申报时间：</label>
			<div class="controls">
				<input name="applyDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${applyProjectInfo.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用地面积（公顷）：</label>
			<div class="controls">
				<form:input path="ydmj" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">新增用地面积（公顷）：</label>
			<div class="controls">
				<form:input path="xzydmj" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">农用地面积（公顷）：</label>
			<div class="controls">
				<form:input path="nydmj" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
        <div class="control-group">
			<label class="control-label">项目资本金（万元）：</label>
			<div class="controls">
				<form:input path="xmzbj" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
       <div class="control-group">
			<label class="control-label">资金来源：</label>
			<div class="controls">
				<form:input path="zjly" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
       <div class="control-group">
			<label class="control-label">财政资金来源：</label>
			<div class="controls">
				<form:input path="czzjly" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="project:applyProjectInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>