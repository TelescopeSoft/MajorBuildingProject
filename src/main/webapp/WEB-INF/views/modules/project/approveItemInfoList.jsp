<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发改批准结果信息管理</title>
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
		<li class="active"><a href="${ctx}/project/approveItemInfo/">发改批准结果信息列表</a></li>
		<shiro:hasPermission name="project:approveItemInfo:edit"><li><a href="${ctx}/project/approveItemInfo/form">发改批准结果信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="approveItemInfo" action="${ctx}/project/approveItemInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
			<li><label>项目代码：</label><form:input path="projectCode" /></li>
			<li><label>项目名称：</label><form:input path="projectName" /></li>
			<li><label>审批事项：</label><form:input path="itemName" /></li>
			<li class="clearfix"></li>
			<li><label>审批部门：</label><form:input path="deptName" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
                <th>项目代码</th>
				<th>项目名称</th>
				<th>审批事项</th>
				<th>审批部门</th>
				<th>审批结果</th>
				<th>批复文号</th>
				<th>审批日期</th>
				<shiro:hasPermission name="project:approveItemInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="approveItemInfo">
			<tr>
                <td>${approveItemInfo.projectCode}</td>
				<td>${approveItemInfo.projectName}</td>
				<td>${approveItemInfo.itemName}</td>
				<td>${approveItemInfo.deptName}</td>
				<td>${approveItemInfo.currentStateLabel}</td>
				<td>${approveItemInfo.approvalNum}</td>
				<td><fmt:formatDate value="${approveItemInfo.dealTime}" pattern="yyyy-MM-dd"/></td>
				<shiro:hasPermission name="project:approveItemInfo:edit"><td>
    				<a href="${ctx}/project/approveItemInfo/form?id=${approveItemInfo.id}">详情</a>
					<!--<a href="${ctx}/project/approveItemInfo/delete?id=${approveItemInfo.id}" onclick="return confirmx('确认要删除该发改批准结果信息吗？', this.href)">删除</a>-->
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>