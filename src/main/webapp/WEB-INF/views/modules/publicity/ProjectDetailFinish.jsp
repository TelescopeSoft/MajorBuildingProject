<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="box box-info">
	<c:forEach items="${list}" var="item" varStatus="status">
		<div class="box-header">
			<div class="approvetitle">
				${ status.index + 1}、备案项目：<span>${item.prjfinishname}</span>
			</div>
		</div>
		<div class="box-body">
			<table class="table table-bordered">
				<tr>
					<td class="bg-info" width="15%">竣工备案编号</td>
					<td width="35%">${item.prjfinishnum}</td>
					<td class="bg-info" width="15%">竣工备案内部编号</td>
					<td width="35%">${item.prjfinishinnernum}</td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">施工许可证编号</td>
					<td width="35%">${item.builderlicencenum}</td>
					<td class="bg-info" width="15%">质量检测机构名称</td>
					<td width="35%">${item.qccorpname}</td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">实际造价（万元）</td>
					<td width="35%">${item.factcost}</td>
					<td class="bg-info" width="15%">实际面积（平方米）</td>
					<td width="35%">${item.factarea}</td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">实际开工日期</td>
					<td width="35%"><fmt:formatDate value="${item.bdate}"
							pattern="yyyy-MM-dd" /></td>
					<td class="bg-info" width="15%">实际竣工验收日期</td>
					<td width="35%"><fmt:formatDate value="${item.edate}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">结构体系</td>
					<td width="35%">${item.prjstructuretypenumLabel}</td>
					<td class="bg-info" width="15%">实际建设规模</td>
					<td width="35%">${item.factsize}</td>

				</tr>
				<tr>
					<td class="bg-info" width="15%">竣工决算审计单位</td>
					<td width="35%"></td>
					<td class="bg-info" width="15%">财务决算金额</td>
					<td width="35%"></td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">审计结论</td>
					<td width="35%" colspan="3"></td>
				</tr>
			</table>
		</div>
	</c:forEach>
</div>