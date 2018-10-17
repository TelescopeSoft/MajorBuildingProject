<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>批准结果管理</title>
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
		<li class="active"><a href="${ctx}/project/pubApproveResult/">批准结果列表</a></li>
		<shiro:hasPermission name="project:pubApproveResult:edit"><li><a href="${ctx}/project/pubApproveResult/form">批准结果添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pubApproveResult" action="${ctx}/project/pubApproveResult/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目代码：</label><form:input path="prjCode" /></li>
			<li><label>项目名称：</label><form:input path="prjName" /></li>
			<li><label>审批事项：</label><form:input path="approveItemLabel" /></li>
			<li class="clearfix"></li>
			<li><label>审批部门：</label><form:input path="approveDept" /></li>
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
				<th>工程项目编号</th>
				<th>审批事项</th>
				<th>审批部门</th>
				<th>审批结果</th>
				<th>批复文号</th>
				<th>审批日期</th>
				<th>记录显示状态</th>
				<shiro:hasPermission name="project:pubApproveResult:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pubApproveResult">
			<tr>
				<td>${pubApproveResult.prjCode}</td>
				<td>${pubApproveResult.prjName}</td>
				<td>${pubApproveResult.prjNum}</td>
				<td>${pubApproveResult.approveItemLabel}</td>
				<td>${pubApproveResult.approveDept}</td>
				<td>${pubApproveResult.approveResult}</td>
				<td>${pubApproveResult.approveNum}</td>
				<td><fmt:formatDate value="${pubApproveResult.approveDate}" pattern="yyyy-MM-dd"/></td>
				<td><c:choose>
							<c:when test="${pubApproveResult.displayFlag eq '0'}">
						显示</c:when>
							<c:otherwise>
						不显示
						</c:otherwise>
						</c:choose></td>
				<shiro:hasPermission name="project:pubApproveResult:edit"><td>
    				<a href="${ctx}/project/pubApproveResult/form?id=${pubApproveResult.id}">修改</a>
					<a href="${ctx}/project/pubApproveResult/delete?id=${pubApproveResult.id}" onclick="return confirmx('确认要删除该批准结果吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>