<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发改申报项目基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
            $("#btnExport").click(function(){
                $("#searchForm").attr("action", "${ctx}/project/applyProjectInfo/export");
                $("#searchForm").submit();
            });
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
            <li class="clearfix"></li>

			<li>
			<label>项目类型</label>
                <form:select path="projectType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getCodeInfoList('project_type')}" itemLabel="name" itemValue="code" htmlEscape="false"/>
				</form:select>
			</li>
			<li>
			<label>建设性质</label>
                <form:select path="projectNature" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getCodeInfoList('project_nature')}" itemLabel="name" itemValue="code" htmlEscape="false"/>
				</form:select>
			</li>
            <li><span style="margin-left:22px;">未匹配项目：</span> <form:checkbox path="notMatchPrj" value="true"/>  </li>

			<li class="clearfix"></li>
            <li><label>申报起时间：</label>
				<form:input path="applyDateStart" htmlEscape="false" maxlength="32" class="input-medium" />
			</li>
            <li><label>申报止时间：</label>
				<form:input path="applyDateEnd" htmlEscape="false" maxlength="32" class="input-medium" />
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="btns"><input id="btnExport" class="btn btn-primary" type="button" value="导出"/></li>
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
				<th>住建项目编码</th>
				<th>是否公示</th>
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
					<a href="${ctx}/project/applyProjectInfo/form?id=${applyProjectInfo.id}">${applyProjectInfo.projectName}</a>
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
					<fmt:formatDate value="${applyProjectInfo.applyDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${applyProjectInfo.prjNum} </td>
                <td><c:choose>
						<c:when test="${not empty applyProjectInfo.majorFlag and applyProjectInfo.majorFlag eq 'Y'}">
						是 <br>
						<a href="${ctx}/project/applyProjectInfo/toggleMajor?projectCode=${applyProjectInfo.projectCode}&majorFlag=N" onclick="return confirmx('确认要取消${projectInfo.prjname} 重大建设项目吗？', this.href)">取消重大项目</a>
						</c:when>
						<c:otherwise>否<br>
						<a href="${ctx}/project/applyProjectInfo/toggleMajor?projectCode=${applyProjectInfo.projectCode}&majorFlag=Y" onclick="return confirmx('确认要设置 ${projectInfo.prjname} 为重大建设项目吗？', this.href)">设为重大项目</a>
						</c:otherwise>
						</c:choose>
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