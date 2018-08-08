<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发改审批事项办理详细信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/project/approvalProcess/">发改审批事项办理详细信息列表</a></li>
		<shiro:hasPermission name="project:approvalProcess:edit"><li><a href="${ctx}/project/approvalProcess/form">发改审批事项办理详细信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="approvalProcess" action="${ctx}/project/approvalProcess/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目代码：</label>
				<form:input path="projectCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目代码</th>
				<th>办理处（科）室</th>
				<th>办理状态</th>
				<th>办理意见</th>
				<th>办理时间</th>
				<shiro:hasPermission name="project:approvalProcess:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="approvalProcess">
			<tr>
				<td><a href="${ctx}/project/approvalProcess/form?id=${approvalProcess.id}">
					${approvalProcess.projectCode}
				</a></td>
				<td>
					${approvalProcess.handleDeptName}
				</td>
				<td>
					${approvalProcess.handleState}
				</td>
				<td>
					${approvalProcess.handleOpinion}
				</td>
				<td>
					<fmt:formatDate value="${approvalProcess.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="project:approvalProcess:edit"><td>
    				<a href="${ctx}/project/approvalProcess/form?id=${approvalProcess.id}">修改</a>
					<a href="${ctx}/project/approvalProcess/delete?id=${approvalProcess.id}" onclick="return confirmx('确认要删除该发改审批事项办理详细信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>