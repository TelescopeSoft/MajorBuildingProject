<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>征地信息管理</title>
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
		<li class="active"><a href="${ctx}/project/expropriation/">征地信息列表</a></li>
		<shiro:hasPermission name="project:expropriation:edit"><li><a href="${ctx}/project/expropriation/form">征地信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="expropriation" action="${ctx}/project/expropriation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目名称：</label>
				<form:input path="prjName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>所属镇：</label>
				<form:input path="town" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>所属村：</label>
				<form:input path="village" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>批复文号：</label>
				<form:input path="approveNum" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>项目名称</th>
				<th>项目位置</th>
				<th>所属镇</th>
				<th>所属村</th>
				<th>批复文号</th>
				<th>批准日期</th>
				<th>update_date</th>
				<shiro:hasPermission name="project:expropriation:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="expropriation">
			<tr>
				<td><a href="${ctx}/project/expropriation/form?id=${expropriation.id}">
					${expropriation.prjName}
				</a></td>
				<td>
					${expropriation.address}
				</td>
				<td>
					${expropriation.town}
				</td>
				<td>
					${expropriation.village}
				</td>
				<td>
					${expropriation.approveNum}
				</td>
				<td>
					<fmt:formatDate value="${expropriation.approveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${expropriation.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="project:expropriation:edit"><td>
    				<a href="${ctx}/project/expropriation/form?id=${expropriation.id}">修改</a>
					<a href="${ctx}/project/expropriation/delete?id=${expropriation.id}" onclick="return confirmx('确认要删除该征地信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>