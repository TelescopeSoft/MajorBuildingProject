<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="box box-info">
	<div class="box-header">
		<div class="approvetitle">安监申报列表</div>
	</div>

	<div class="box-body">
		<table class="table table-bordered ">
			<tr class="bg-info">
				<th>报监工程名称</th>
				<th>安全监督机构名称</th>
				<th>建设单位名称</th>
				<th>建设规模</th>
				<th>报监日期</th>
				<th>申办人</th>
				<!-- <th>申办人联系电话</th> -->
				<th>项目面积</th>
				<th>项目造价</th>
				<th>结构层次</th>
				<th>申报目标</th>
				<th>状态</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.xmmc}</td>
					<td>${item.ajjgmc}</td>
					<td>${item.econcorpname}</td>
					<td>${item.prjsize}</td>
					<td><fmt:formatDate value="${item.updateDate}"
                        							pattern="yyyy-MM-dd" /></td>
					<td>${item.sbr}</td>
					<!-- <td>${item.sbryddh}</td> -->
					<td>${fn:substring(item.mj, 0, fn:length(item.mj) - 2)}</td>
					<td>${fn:substring(item.zj, 0, fn:length(item.zj) - 2)}</td>
					<td>${item.jgcc}</td>
					<td>${item.sbmb}</td>
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
</div>