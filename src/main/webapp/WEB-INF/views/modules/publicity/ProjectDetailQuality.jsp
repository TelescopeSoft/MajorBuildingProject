<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="box-header">
	<div class="approvetitle">质监申报列表</div>
</div>

<div class="box box-info">
	<table class="table table-bordered ">
		<tr class="bg-info">
			<th>报监工程名称</th>
			<th>质量监督机构名称</th>
			<th>建设单位名称</th>
			<th>建设规模</th>
			<th>工程地址</th>
			<th>报监日期</th>
			<th>申办人</th>
			<!-- <th>申办人联系电话</th> -->
			<th>建设性质</th>
			<th>投资类型</th>
			<th>审批状态</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.xmmc}</td>
				<td>${item.zjjgmc}</td>
				<td>${item.econcorpname}</td>
				<td>${item.prjsize}</td>
				<td>${item.gcdz}</td>
				<td><fmt:formatDate value="${item.updatedate}"
						pattern="yyyy-MM-dd" /></td>
				<td>${item.sbr}</td>
				<td>${item.jsxzLabel}</td>
				<td>${item.tzlx}</td>
				<td><c:choose>
						<c:when test="${item.status == '0'}">未受理</c:when>
						<c:when test="${item.status == '1'}">已退回</c:when>
						<c:when test="${item.status == '2'}">办理中</c:when>
						<c:when test="${item.status == '3'}">已办结</c:when>
						<c:otherwise>其他 </c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>

	</table>
</div>