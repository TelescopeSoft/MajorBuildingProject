<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="box-header">
	<div class="approvetitle">合同列表</div>
</div>

<div class="box box-info">
	<table class="table table-bordered ">
		<tr class="bg-info">
			<td>合同备案编号</td>
			<td>合同项目名称</td>
			<td>合同类别</td>
			<td>发包单位名称</td>
			<td>承包单位名称</td>
			<td>合同金额（万元）</td>
			<td>合同签订日期</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.recordnum}</td>
				<td>${item.recordname}</td>
				<td>${item.contracttypeLabel}</td>
				<td>${item.propietorcorpname}</td>
				<td>${item.contractorcorpname}</td>
				<td>${item.contractmoney}</td>
				<td><fmt:formatDate value="${item.contractdate}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>

	</table>
</div>