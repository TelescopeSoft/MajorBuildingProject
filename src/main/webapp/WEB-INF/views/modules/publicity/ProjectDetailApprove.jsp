<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>

<div class="box box-info">
	<table class="table table-bordered ">
		<tr class="bg-info">
			<td>审批部门</td>
			<td>审批事项</td>
			<td>审批结果</td>
			<td>审批时间</td>
			<td>批复文号</td>
		</tr>
		<c:forEach items="${list}" var="pubApproveResult">
			<tr>
				<td>${pubApproveResult.approveItemLabel}</td>
				<td>${pubApproveResult.approveDept}</td>
				<td>${pubApproveResult.approveResult}</td>
				<td><fmt:formatDate value="${pubApproveResult.updateDate}"
						pattern="yyyy-MM-dd" /></td>
				<td>${pubApproveResult.approveNum}</td>
			</tr>
		</c:forEach>

	</table>
</div>