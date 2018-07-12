<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>办事指南管理</title>
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
		<li><a href="${ctx}/project/pubApproveGuide/">办事指南列表</a></li>
		<li class="active"><a href="${ctx}/project/pubApproveGuide/form?id=${pubApproveGuide.id}">办事指南<shiro:hasPermission name="project:pubApproveGuide:edit">${not empty pubApproveGuide.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:pubApproveGuide:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="pubApproveGuide" action="${ctx}/project/pubApproveGuide/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">所属部门：</label>
			<div class="controls">
				<sys:treeselect id="office" name="office.id" value="${pubApproveGuide.office.id}" labelName="office.name" labelValue="${pubApproveGuide.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批准事项：</label>
			<div class="controls">
				<form:input path="approveItemLabel" htmlEscape="false" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批准事项代码：</label>
			<div class="controls">
				<form:input path="approveItemCode" htmlEscape="false" maxlength="20" class="input-medium "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办事指南链接：</label>
			<div class="controls">
				<form:input path="approveGuideUrl" htmlEscape="false" maxlength="200" class="span12"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办事应用链接：</label>
			<div class="controls">
				<form:input path="approveAppUrl" htmlEscape="false" maxlength="200" class="span12"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="project:pubApproveGuide:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>