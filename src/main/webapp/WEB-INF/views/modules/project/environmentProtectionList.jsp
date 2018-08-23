<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>施工期环境保护措施管理</title>
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
		<li class="active"><a href="${ctx}/project/environmentProtection/">施工期环境保护措施列表</a></li>
		<!--<shiro:hasPermission name="project:environmentProtection:edit"><li><a href="${ctx}/project/environmentProtection/form">施工期环境保护措施添加</a></li></shiro:hasPermission>-->
	</ul>
	<form:form id="searchForm" modelAttribute="environmentProtection" action="${ctx}/project/environmentProtection/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label >项目代码：</label>
				<form:input path="projectCode" htmlEscape="false" maxlength="64" class="input-xlarge"/>
			</li>
            <li><label >项目名称：</label>
				<form:input path="projectName" htmlEscape="false" maxlength="64" class="input-xlarge"/>
			</li>
			<li class="clearfix"></li>
            <li><label style="width:150px;">总投资额（万元）：</label>
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
				<th>设置施工现场封闭围挡</th>
				<th>设置冲洗设施、道路硬化等扬尘措施</th>
				<!--<th>整改情况</th>-->
				<th>更新日期</th>
				<shiro:hasPermission name="project:environmentProtection:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="environmentProtection">
			<tr>
				<td><a href="${ctx}/project/environmentProtection/form?prjCode=${environmentProtection.projectCode}">
					${environmentProtection.projectCode}
				</a></td>
                <td><a href="${ctx}/project/environmentProtection/form?prjCode=${environmentProtection.projectCode}">
                    ${environmentProtection.projectName}
                    </a>
				</td>
				<td>
					${fns:getDictLabel(environmentProtection.closeFlag, 'environment_close', '无')}
				</td>
				<td>
					${fns:getDictLabel(environmentProtection.washFlag, 'environment_close', '无')}
				</td>
				<!--<td>
                	<c:forEach items="${environmentProtection.environmentProtectionRectifyList}" var="u">
                    ${u.rectify} <br>
                    ${u.rectifyNotice}
                    </c:forEach>
                </td>-->
				<td>
					<fmt:formatDate value="${environmentProtection.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="project:environmentProtection:edit"><td>
    				<a href="${ctx}/project/environmentProtection/form?prjCode=${environmentProtection.projectCode}">修改</a>
					<!--<a href="${ctx}/project/environmentProtection/delete?id=${environmentProtection.projectCode}" onclick="return confirmx('确认要删除该施工期环境保护措施吗？', this.href)">删除</a>-->
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>