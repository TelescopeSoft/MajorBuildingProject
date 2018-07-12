<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>办事指南管理</title>
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
		<li class="active"><a href="${ctx}/project/pubApproveGuide/">办事指南列表</a></li>
		<shiro:hasPermission name="project:pubApproveGuide:edit"><li><a href="${ctx}/project/pubApproveGuide/form">办事指南添加</a></li></shiro:hasPermission>
	</ul>
	<!-- <form:form id="searchForm" modelAttribute="pubApproveGuide" action="${ctx}/project/pubApproveGuide/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul> 
	</form:form>-->
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed" style="table-layout: fixed;">
		<thead>
			<tr>
				<th width="10%">所属部门</th>
				<th width="20%">批准事项</th>
				<th width="10%">批准事项代码</th>
				<th width="20%">办事指南链接</th>
				<th width="20%">办事应用链接</th>
				<shiro:hasPermission name="project:pubApproveGuide:edit"><th width="10%">操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pubApproveGuide">
			<tr>
				<td width="10%">${pubApproveGuide.office.name}</td>
				<td width="10%">${pubApproveGuide.approveItemLabel}</td>
				<td width="10%">${pubApproveGuide.approveItemCode}</td>
				<td width="20%" style="word-wrap: break-word;"><a href="${pubApproveGuide.approveGuideUrl}" target="_blank">${pubApproveGuide.approveGuideUrl}</a></td>
				<td width="20%" style="word-wrap: break-word;"><a href="${pubApproveGuide.approveAppUrl}" target="_blank">${pubApproveGuide.approveAppUrl}</a></td>
				<shiro:hasPermission name="project:pubApproveGuide:edit"><td>
    				<a href="${ctx}/project/pubApproveGuide/form?id=${pubApproveGuide.id}">修改</a>
					<a href="${ctx}/project/pubApproveGuide/delete?id=${pubApproveGuide.id}" onclick="return confirmx('确认要删除该办事指南吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>