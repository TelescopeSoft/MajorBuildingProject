<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目表管理</title>
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
		<li class="active"><a href="${ctx}/project/projectInfo/">项目表列表</a></li>
		<shiro:hasPermission name="project:projectInfo:edit"><li><a href="${ctx}/project/projectInfo/form">项目表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="projectInfo" action="${ctx}/project/projectInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>项目名称：</label><form:input path="prjname" /></li>
			<li><label>项目编码：</label><form:input path="prjnum" /></li>
			<li><label>建设单位：</label><form:input path="buildcorpname" /></li>
			<li class="clearfix"></li>
			<li><label>建设单位：</label><form:input path="prjapprovalnum" /></li>
			<!--<li><label style="width:100px;">发改项目代码：</label><form:input path="prjCode" /></li>-->
			<li><span style="margin-left:22px;">未匹配项目：</span> <form:checkbox path="matchPrj" value="true"/>  </li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr>
		    <th>发改项目代码</th>
			<th>项目编码</th>
			<th>项目名称</th>
			<th>建设单位</th>
			<th>建设单位组织机构代码</th>
			<th>发改立项文号</th>
			<th>项目金额/总投资（万元）</th>
			<th>总面积（平方米）</th>
			<th>建设规模</th>
			<!--<th>是否重大项目</th>-->
			<th>
				<shiro:hasPermission name="project:projectInfo:edit">操作</shiro:hasPermission>
			</th>
		</tr>
		<tbody>
		<c:forEach items="${page.list}" var="projectInfo">
			<tr>
			    <td>${projectInfo.prjCode}</td>
				<td>${projectInfo.prjnum}</td>
				<td>${projectInfo.prjname}</td>
				<td>${projectInfo.buildcorpname}</td>
				<td>${projectInfo.buildcorpcode}</td>
				<td>${projectInfo.prjapprovalnum}</td>
				<td>${projectInfo.allinvest}</td>
				<td>${projectInfo.allarea}</td>
				<td>${projectInfo.prjsize}</td>
				<!--<td><c:choose>
						<c:when test="${not empty projectInfo.majorFlag and projectInfo.majorFlag eq 'Y'}">
						是 <br> 
						<a href="${ctx}/project/projectInfo/toggleMajor?pkid=${projectInfo.pkid}&majorFlag=N" onclick="return confirmx('确认要取消${projectInfo.prjname} 重大建设项目吗？', this.href)">取消重大项目</a>
						</c:when>
						<c:otherwise>否<br>
						<a href="${ctx}/project/projectInfo/toggleMajor?pkid=${projectInfo.pkid}&majorFlag=Y" onclick="return confirmx('确认要设置 ${projectInfo.prjname} 为重大建设项目吗？', this.href)">设为重大项目</a>
						</c:otherwise>
						</c:choose> 
				</td>-->
				<shiro:hasPermission name="project:projectInfo:edit"><td>
    				<a href="${ctx}/project/projectInfo/form?pkid=${projectInfo.pkid}">修改</a>
					<a href="${ctx}/project/projectInfo/delete?pkid=${projectInfo.pkid}" onclick="return confirmx('确认要删除该项目表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>