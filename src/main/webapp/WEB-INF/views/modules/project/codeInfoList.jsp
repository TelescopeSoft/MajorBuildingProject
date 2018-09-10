<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目代码表管理</title>
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
		<li class="active"><a href="${ctx}/project/codeInfo/">项目代码表列表</a></li>
		<shiro:hasPermission name="project:codeInfo:edit"><li><a href="${ctx}/project/codeInfo/form">项目代码表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="codeInfo" action="${ctx}/project/codeInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>code_type：</label>
				<form:input path="codeType" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>code：</label>
				<form:input path="code" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>name：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>code_type</th>
				<th>code</th>
				<th>name</th>
				<shiro:hasPermission name="project:codeInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="codeInfo">
			<tr>
				<td><a href="${ctx}/project/codeInfo/form?id=${codeInfo.id}">
					${codeInfo.codeType}
				</a></td>
				<td>
					${codeInfo.code}
				</td>
				<td>
					${codeInfo.name}
				</td>
				<shiro:hasPermission name="project:codeInfo:edit"><td>
    				<a href="${ctx}/project/codeInfo/form?id=${codeInfo.id}">修改</a>
					<a href="${ctx}/project/codeInfo/delete?id=${codeInfo.id}" onclick="return confirmx('确认要删除该项目代码表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>