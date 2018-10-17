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
				<td>${pubApproveResult.deptName}</td>
				<td>${pubApproveResult.itemName}</td>
				<td>${pubApproveResult.currentStateLabel}
				<!--<c:choose>
				    <c:when test="${ pubApproveResult.currentState eq 'A0501'}">通过</c:when>
				    <c:when test="${ pubApproveResult.currentState eq 'A0502'}">不通过</c:when>
                    <c:otherwise>其他</c:otherwise>
                    </c:choose>-->
                </td>
				<td><fmt:formatDate value="${pubApproveResult.dealTime}"
						pattern="yyyy-MM-dd" /></td>
				<td>${pubApproveResult.approvalNum}</td>
			</tr>
		</c:forEach>

	</table>
</div>