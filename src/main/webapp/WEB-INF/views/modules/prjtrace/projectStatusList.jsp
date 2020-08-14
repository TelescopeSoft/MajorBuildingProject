<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目状态管理</title>
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
		<li class="active"><a href="${ctx}/prjtrace/projectStatus/">项目状态列表</a></li>
		<shiro:hasPermission name="prjtrace:projectStatus:edit"><li><a href="${ctx}/prjtrace/projectStatus/form">项目状态添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="projectStatus" action="${ctx}/prjtrace/projectStatus/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>年份：</label>
				<input name="year" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="${projectStatus.year}"
					onclick="WdatePicker({dateFmt:'yyyy',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			    <th>#</th>
				<th>名称</th>
				<th>值</th>
				<th>年份</th>
				<th>更新时间</th>
				<shiro:hasPermission name="prjtrace:projectStatus:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="projectStatus" varStatus="status">
			<tr>
			    <td>
			        ${status.index + 1}
			    </td>
				<td><a href="${ctx}/prjtrace/projectStatus/form?id=${projectStatus.id}">
					${projectStatus.name}
				</a></td>
				<td> ${projectStatus.code}</td>
				<td>
					${projectStatus.year}
				</td>
				<td>
					<fmt:formatDate value="${projectStatus.gmtModified}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="prjtrace:projectStatus:edit"><td>
    				<a href="${ctx}/prjtrace/projectStatus/form?id=${projectStatus.id}">修改</a>
					<a href="${ctx}/prjtrace/projectStatus/delete?id=${projectStatus.id}" onclick="return confirmx('确认要删除该项目状态吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>