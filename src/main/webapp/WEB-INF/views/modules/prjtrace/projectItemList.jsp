<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>跟踪项目管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
    		$(document).ready(function() {
    			var tpl = $("#treeTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
    			var data = ${fns:toJson(list)}, rootId = "0";
    			addRow("#treeTableList", tpl, data, rootId, true);
    			$("#treeTable").treeTable({expandLevel : 5});
    		});
    		function addRow(list, tpl, data, pid, root){
    			for (var i=0; i<data.length; i++){
    				var row = data[i];
    				if ((${fns:jsGetVal('row.parentId')}) == pid){
    					$(list).append(Mustache.render(tpl, {
    						pid: (root?0:pid), row: row
    					}));
    					addRow(list, tpl, data, row.id);
    				}
    			}
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
	<table id="treeTable" class="table table-striped table-bordered table-condensed">
    		<thead>
            			<tr>
            			    <th>名称</th>
            			    <th>年份</th>
            				<th>项目类型</th>
            				<th>项目状态</th>
            				<th>年度目标</th>
            				<shiro:hasPermission name="prjtrace:projectItem:edit"><th>操作</th></shiro:hasPermission>
            			</tr>
            		</thead>
            		<tbody id="treeTableList"></tbody>
    	</table>
	<script type="text/template" id="treeTableTpl">
    		<tr id="{{row.id}}" pId="{{pid}}">
    			<td><a href="${ctx}/prjtrace/projectItem/form?id={{row.id}}">{{row.name}}</a></td>
    			 <td>{{row.ofyear}}</td>
    			<td>{{row.prjType.name}}</td>
    			<td>{{row.prjStatus.name}}</td>
    			<td>{{row.goal}}</td>
    			<shiro:hasPermission name="prjtrace:projectItem:edit"><td>
    				<a href="${ctx}/prjtrace/projectItem/form?id={{row.id}}">修改</a>
    				<a href="${ctx}/prjtrace/projectItem/delete?id={{row.id}}" onclick="return confirmx('要删除该项目及所有子项目吗？', this.href)">删除</a>
    				<a href="${ctx}/prjtrace/projectItem/form?parent.id={{row.id}}">添加子项目</a>
    			</td></shiro:hasPermission>
    		</tr>
    	</script>
</body>
</html>