<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>

<div class="box box-info">
	<!-- /.box-header -->
	<div class="box-body">
		<table class="table table-bordered">
			<tr>
				<td class="bg-info" width="15%">项目代码</td>
				<td width="35%">${projectinfo.projectCode}</td>
				<td class="bg-info" width="15%">项目名称</td>
				<td width="35%">${projectinfo.projectName}</td>
			</tr>
			<tr>
				<td class="bg-info">项目类型</td>
				<td>${projectinfo.projectTypeLabel}</td>
				<td class="bg-info">核准目录分类</td>
				<td>${projectinfo.catalogName}</td>
			</tr>
			<tr>
				<td class="bg-info">项目（法人）单位</td>
				<td>${projectinfo.enterpriseName}</td>
				<td class="bg-info">项目（法人）证照号码</td>
				<td>${projectinfo.lerepCertNo}</td>
			</tr>
			<tr>
				<td class="bg-info">建设性质</td>
				<td>${projectinfo.projectNatureLabel}</td>
				<td class="bg-info">总投资（万元）</td>
				<td>${projectinfo.totalMoney}</td>
			</tr>
			<tr>
				<td class="bg-info">用地面积（公顷）</td>
				<td>${projectinfo.ydmj}</td>
				<td class="bg-info">资金来源</td>
                <td>${projectinfo.zjly}</td>
			</tr>
			<tr>
				<td class="bg-info">拟开工时间（年）</td>
				<td>${projectinfo.startYear}</td>
				<td class="bg-info">拟建成时间（年）</td>
				<td>${projectinfo.endYear}</td>
			</tr>
			<tr>
				<td class="bg-info">项目详细地址</td>
				<td colspan="3">${projectinfo.addressDetail}</td>
			</tr>
            <tr>
				<td class="bg-info">建设规模及内容</td>
				<td colspan="3">
				<c:if test="${empty projectinfo.scaleContentPub }" >
				    ${projectinfo.scaleContent}
				</c:if>
				<c:if test="${not empty projectinfo.scaleContentPub }" >
                	 ${projectinfo.scaleContentPub}
                </c:if>
				</td>
			</tr>
		</table>
	</div>
</div>