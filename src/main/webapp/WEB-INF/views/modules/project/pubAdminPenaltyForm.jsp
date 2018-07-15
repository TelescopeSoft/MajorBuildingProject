<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>行政处罚管理</title>
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
		<li><a href="${ctx}/project/pubAdminPenalty/">行政处罚列表</a></li>
		<li class="active"><a href="${ctx}/project/pubAdminPenalty/form?id=${pubAdminPenalty.id}">行政处罚<shiro:hasPermission name="project:pubAdminPenalty:edit">${not empty pubAdminPenalty.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:pubAdminPenalty:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="pubAdminPenalty" action="${ctx}/project/pubAdminPenalty/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">行政相对人名称：</label>
			<div class="controls">
				<form:input path="adminRelativePerson" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">行政处罚决定书文号：</label>
			<div class="controls">
				<form:input path="letterOfDecision" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="span12"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚决定日期：</label>
			<div class="controls">
				<input name="punishmentDecisionDate" type="text" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${pubAdminPenalty.punishmentDecisionDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚机关：</label>
			<div class="controls">
				<form:input path="punishDeptLabel" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚类别：</label>
			<div class="controls">
				<form:input path="punishCategory" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚事由：</label>
			<div class="controls">
				<form:input path="punishReason" htmlEscape="false" maxlength="255" class="span12"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚依据：</label>
			<div class="controls">
				<form:input path="punishBasis" htmlEscape="false" maxlength="255" class="span12"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">行政相对人代码 (统一社会信用代码)：</label>
			<div class="controls">
				<form:input path="adminRelativePersonCode" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">法定代表人姓名：</label>
			<div class="controls">
				<form:input path="legalRepresentative" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处罚结果：</label>
			<div class="controls">
				<form:input path="punishResult" htmlEscape="false" maxlength="255" class="span12"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地方编码：</label>
			<div class="controls">
				<form:input path="county" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公示截止期：</label>
			<div class="controls">
				<input name="publicDeadline" type="text"  maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${pubAdminPenalty.publicDeadline}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">记录显示标识:</label>
			<div class="controls">
				<form:select path="displayFlag" class="input-xlarge">
					<form:option value="" label="请选择"/>
					<form:options items="${fns:getDictList('display_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">关联项目编码：</label>
			<div class="controls">
				<form:input path="prjNum" htmlEscape="false" maxlength="20" class="input-xlarge"/> 
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="project:pubAdminPenalty:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>