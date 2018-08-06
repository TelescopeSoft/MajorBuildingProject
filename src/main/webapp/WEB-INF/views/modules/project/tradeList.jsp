<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招标投标管理</title>
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
		<li class="active"><a href="${ctx}/project/trade/">招标投标列表</a></li>
		<shiro:hasPermission name="project:trade:edit"><li><a href="${ctx}/project/trade/form">招标投标添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="trade" action="${ctx}/project/trade/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		    <li><label>标题：</label>
            				<form:input path="title" htmlEscape="false" maxlength="200" class="input-medium"/>
            			</li>
			<li><label>内部标号：</label>
				<form:input path="tenderInnerNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>类型：</label>
				<form:input path="tenderType" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>生成日期：</label>
				<input name="writetime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${trade.writetime}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li><label>公开日期：</label>
				<input name="opentime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${trade.opentime}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			    <th>标题</th>
			    <th>项目代码</th>
				<th>项目名称</th>
				<th>索引号</th>
				<th>内部标号</th>
				<th>类型</th>
				<th>生成日期</th>
				<th>公开日期</th>

				<shiro:hasPermission name="project:trade:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="trade">
			<tr>
			    <td>
			        <a href="${ctx}/project/trade/form?id=${trade.id}">${trade.title}</a>
                </td>
                <td>${trade.prjCode} </td>
				<td>
					${trade.prjName}
				</td>
				<td> ${trade.indexid} </td>
				<td>
					${trade.tenderInnerNum}
				</td>
				<td>
					${trade.tenderType}
				</td>

				<td>
					<fmt:formatDate value="${trade.writetime}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${trade.opentime}" pattern="yyyy-MM-dd"/>
				</td>

				<shiro:hasPermission name="project:trade:edit"><td>
    				<a href="${ctx}/project/trade/form?id=${trade.id}">修改</a>
					<a href="${ctx}/project/trade/delete?id=${trade.id}" onclick="return confirmx('确认要删除该招标投标吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>