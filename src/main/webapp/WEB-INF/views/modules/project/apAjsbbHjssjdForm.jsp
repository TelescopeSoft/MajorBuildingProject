<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>安监申报环境交底管理</title>
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
		<li><a href="${ctx}/project/apAjsbbHjssjd/">安监申报环境交底列表</a></li>
		<li class="active"><a href="${ctx}/project/apAjsbbHjssjd/form?id=${apAjsbbHjssjd.id}">安监申报环境交底<shiro:hasPermission name="project:apAjsbbHjssjd:edit">${not empty apAjsbbHjssjd.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:apAjsbbHjssjd:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="apAjsbbHjssjd" action="${ctx}/project/apAjsbbHjssjd/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">uuid：</label>
			<div class="controls">
				<form:input path="uuid" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xh：</label>
			<div class="controls">
				<form:input path="xh" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jdxm：</label>
			<div class="controls">
				<form:input path="jdxm" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jdqk：</label>
			<div class="controls">
				<form:input path="jdqk" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="project:apAjsbbHjssjd:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>