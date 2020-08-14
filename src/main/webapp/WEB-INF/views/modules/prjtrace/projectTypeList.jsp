<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目类型管理</title>
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
		<li class="active"><a href="${ctx}/prjtrace/projectType/">项目类型列表</a></li>
		<shiro:hasPermission name="prjtrace:projectType:edit"><li><a href="${ctx}/prjtrace/projectType/form">项目类型添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="projectType" action="${ctx}/prjtrace/projectType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>ID</th>
				<th>名称</th>
				<th>更新时间</th>
				<shiro:hasPermission name="prjtrace:projectType:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="projectType" varStatus="status">
			<tr>
				<td>
					${status.index + 1}
				</td>
				<td>
					<a href="${ctx}/prjtrace/projectType/form?id=${projectType.id}">${projectType.name}</a>
				</td>
				<td>
					<fmt:formatDate value="${projectType.gmtModified}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="prjtrace:projectType:edit"><td>
    				<a href="${ctx}/prjtrace/projectType/form?id=${projectType.id}">修改</a>
					<a href="${ctx}/prjtrace/projectType/delete?id=${projectType.id}" onclick="return confirmx('确认要删除该项目类型吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>