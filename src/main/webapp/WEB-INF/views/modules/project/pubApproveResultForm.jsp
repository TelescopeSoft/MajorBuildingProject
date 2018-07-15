<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>批准结果管理</title>
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
		<li><a href="${ctx}/project/pubApproveResult/">批准结果列表</a></li>
		<li class="active"><a href="${ctx}/project/pubApproveResult/form?id=${pubApproveResult.id}">批准结果<shiro:hasPermission name="project:pubApproveResult:edit">${not empty pubApproveResult.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:pubApproveResult:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="pubApproveResult" action="${ctx}/project/pubApproveResult/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">项目代码：</label>
			<div class="controls">
				<form:input path="prjCode" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目名称：</label>
			<div class="controls">
				<form:input path="prjName" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工程项目编号：</label>
			<div class="controls">
				<form:input path="prjNum" htmlEscape="false" maxlength="64" class="input-xlarge "/>
				&nbsp;&nbsp;(江苏省住建厅统一工程项目编号，住建局一号通系统)
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批事项：</label>
			<div class="controls">
				<form:input path="approveItemLabel" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批部门：</label>
			<div class="controls">
				<form:input path="approveDept" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<!-- 
		<div class="control-group">
			<label class="control-label">approve_item_code：</label>
			<div class="controls">
				<form:input path="approveItemCode" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">approve_subitem_label：</label>
			<div class="controls">
				<form:input path="approveSubitemLabel" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">approve_subitem_code：</label>
			<div class="controls">
				<form:input path="approveSubitemCode" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div> -->
		<div class="control-group">
			<label class="control-label">审批结果：</label>
			<div class="controls">
				<form:input path="approveResult" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批复文号：</label>
			<div class="controls">
				<form:input path="approveNum" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批日期：</label>
			<div class="controls">
				<input name="approveDate" type="text" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${pubApproveResult.approveDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">记录显示状态:</label>
			<div class="controls">
				<form:select path="displayFlag" class="input-xlarge">
					<form:option value="" label="请选择"/>
					<form:options items="${fns:getDictList('display_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="project:pubApproveResult:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>