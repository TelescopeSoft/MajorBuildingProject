<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>配置表管理</title>
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
		<li class="active"><a href="${ctx}/project/pubConfig/">配置表列表</a></li>
		<shiro:hasPermission name="project:pubConfig:edit"><li><a href="${ctx}/project/pubConfig/form">配置表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pubConfig" action="${ctx}/project/pubConfig/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<!--<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>-->
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>键</th>
				<th>值</th>
				<shiro:hasPermission name="project:pubConfig:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pubConfig">
			<tr>
				<td><a href="${ctx}/project/pubConfig/form?id=${pubConfig.id}">
					${pubConfig.ckey}
				</a></td>
				<td>
					${pubConfig.cvalue}
				</td>
				<shiro:hasPermission name="project:pubConfig:edit"><td>
    				<a href="${ctx}/project/pubConfig/form?id=${pubConfig.id}">修改</a>
					<a href="${ctx}/project/pubConfig/delete?id=${pubConfig.id}" onclick="return confirmx('确认要删除该配置表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>