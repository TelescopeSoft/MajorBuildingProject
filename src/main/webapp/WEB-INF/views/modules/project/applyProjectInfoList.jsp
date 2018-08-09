<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发改申报项目基本信息管理</title>
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
		<li class="active"><a href="${ctx}/project/applyProjectInfo/">发改申报项目基本信息列表</a></li>
		<!--<shiro:hasPermission name="project:applyProjectInfo:edit"><li><a href="${ctx}/project/applyProjectInfo/form">发改申报项目基本信息添加</a></li></shiro:hasPermission>-->
	</ul>
	<form:form id="searchForm" modelAttribute="applyProjectInfo" action="${ctx}/project/applyProjectInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目代码：</label>
				<form:input path="projectCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>项目名称：</label>
				<form:input path="projectName" htmlEscape="false" maxlength="512" class="input-medium"/>
			</li>
			<li><label style="width:140px;">总投资额（万元）：</label>
            	<form:input path="totalMoney" htmlEscape="false" maxlength="512" class="input-medium"/>
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
				<th>项目名称</th>
				<th>拟开工时间</th>
				<th>拟建成时间</th>
				<th>总投资额（万元）</th>
				<th>地点</th>
				<th>申报时间</th>
				<shiro:hasPermission name="project:applyProjectInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="applyProjectInfo">
			<tr>
				<td><a href="${ctx}/project/applyProjectInfo/form?id=${applyProjectInfo.id}">
					${applyProjectInfo.projectCode}
				</a></td>
				<td>
					${applyProjectInfo.projectName}
				</td>
				<td>
					${applyProjectInfo.startYear}
				</td>
				<td>
					${applyProjectInfo.endYear}
				</td>
				<td>
					${applyProjectInfo.totalMoney}
				</td>
				<td>
					${applyProjectInfo.addressDetail}
				</td>
				<td>
					<fmt:formatDate value="${applyProjectInfo.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="project:applyProjectInfo:edit"><td>
    				<a href="${ctx}/project/applyProjectInfo/form?id=${applyProjectInfo.id}">详情</a>
					<!--<a href="${ctx}/project/applyProjectInfo/delete?id=${applyProjectInfo.id}" onclick="return confirmx('确认要删除该发改申报项目基本信息吗？', this.href)">删除</a>-->
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>