<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>行政处罚管理</title>
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
		<li class="active"><a href="${ctx}/project/pubAdminPenalty/">行政处罚列表</a></li>
		<shiro:hasPermission name="project:pubAdminPenalty:edit"><li><a href="${ctx}/project/pubAdminPenalty/form">行政处罚添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pubAdminPenalty" action="${ctx}/project/pubAdminPenalty/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>处罚名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>行政相对人名称</th>
				<th>决定书文号</th>
				<th>处罚名称</th>
				<th>处罚决定日期</th>
				<th>处罚机关</th>
				<th>记录显示状态</th>
				<shiro:hasPermission name="project:pubAdminPenalty:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pubAdminPenalty">
			<tr>
				<td>${pubAdminPenalty.adminRelativePerson} </td>
				<td>${pubAdminPenalty.letterOfDecision} </td>
				<td><a href="${ctx}/project/pubAdminPenalty/form?id=${pubAdminPenalty.id}">
					${pubAdminPenalty.name}
				</a></td>
				<td>
					<fmt:formatDate value="${pubAdminPenalty.punishmentDecisionDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${pubAdminPenalty.punishDeptLabel} </td>
				<td><c:choose>
							<c:when test="${pubAdminPenalty.displayFlag eq '0'}">
						显示</c:when>
							<c:otherwise>
						不显示
						</c:otherwise>
						</c:choose></td>
				<shiro:hasPermission name="project:pubAdminPenalty:edit"><td>
    				<a href="${ctx}/project/pubAdminPenalty/form?id=${pubAdminPenalty.id}">修改</a>
					<a href="${ctx}/project/pubAdminPenalty/delete?id=${pubAdminPenalty.id}" onclick="return confirmx('确认要删除该行政处罚吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>