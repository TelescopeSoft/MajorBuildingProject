<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>跟踪项目管理</title>
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
		<li class="active"><a href="${ctx}/prjtrace/projectItem/">跟踪项目列表</a></li>
		<shiro:hasPermission name="prjtrace:projectItem:edit"><li><a href="${ctx}/prjtrace/projectItem/form">跟踪项目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="projectItem" action="${ctx}/prjtrace/projectItem/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>年份：</label>
                <input name="ofyear" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="${projectItem.ofyear}"
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
			    <th>年份</th>
				<th>名称</th>
				<th>项目类型</th>
				<th>项目状态</th>
				<th>年度目标</th>
				<shiro:hasPermission name="prjtrace:projectItem:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="projectItem">
			<tr>
                <td>${projectItem.ofyear} </td>
				<td><a href="${ctx}/prjtrace/projectItem/form?id=${projectItem.id}">
					${projectItem.name}
				</a></td>
			    <td>${projectItem.prjType.name} </td>
			    <td>${projectItem.prjStatus.name} </td>
			    <td>${projectItem.goal} </td>
				<shiro:hasPermission name="prjtrace:projectItem:edit"><td>
    				<a href="${ctx}/prjtrace/projectItem/form?id=${projectItem.id}">修改</a>
					<a href="${ctx}/prjtrace/projectItem/delete?id=${projectItem.id}" onclick="return confirmx('确认要删除该跟踪项目吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>