<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>重大建设项目基本信息管理</title>
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
		<li><a href="${ctx}/pub/pubFgwProjectInfo/">重大建设项目基本信息列表</a></li>
		<li class="active"><a href="${ctx}/pub/pubFgwProjectInfo/form?id=${pubFgwProjectInfo.id}">重大建设项目基本信息<shiro:hasPermission name="pub:pubFgwProjectInfo:edit">${not empty pubFgwProjectInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="pub:pubFgwProjectInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="pubFgwProjectInfo" action="${ctx}/pub/pubFgwProjectInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">project_code：</label>
			<div class="controls">
				<form:input path="projectCode" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">project_name：</label>
			<div class="controls">
				<form:input path="projectName" htmlEscape="false" maxlength="512" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">project_type：</label>
			<div class="controls">
				<form:input path="projectType" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">project_type_lable：</label>
			<div class="controls">
				<form:input path="projectTypeLable" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">catalog_name：</label>
			<div class="controls">
				<form:input path="catalogName" htmlEscape="false" maxlength="1024" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">enterprise_name：</label>
			<div class="controls">
				<form:input path="enterpriseName" htmlEscape="false" maxlength="256" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">lerep_certtype：</label>
			<div class="controls">
				<form:input path="lerepCerttype" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">lerep_certno：</label>
			<div class="controls">
				<form:input path="lerepCertno" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">project_nature：</label>
			<div class="controls">
				<form:input path="projectNature" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">project_nature_label：</label>
			<div class="controls">
				<form:input path="projectNatureLabel" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">total_money：</label>
			<div class="controls">
				<form:input path="totalMoney" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">ydmj：</label>
			<div class="controls">
				<form:input path="ydmj" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zjly：</label>
			<div class="controls">
				<form:input path="zjly" htmlEscape="false" maxlength="12" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">start_year：</label>
			<div class="controls">
				<form:input path="startYear" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">end_year：</label>
			<div class="controls">
				<form:input path="endYear" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">address_detail：</label>
			<div class="controls">
				<form:input path="addressDetail" htmlEscape="false" maxlength="2014" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">scale_content：</label>
			<div class="controls">
				<form:input path="scaleContent" htmlEscape="false" maxlength="4000" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="pub:pubFgwProjectInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>