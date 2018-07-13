<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>

<div class="box box-info">
	<!-- /.box-header -->
	<div class="box-body">
		<table class="table table-bordered">
			<tr>
				<td class="bg-info">项目代码</td>
				<td>${projectinfo.prjCode}</td>
				<td class="bg-info">项目名称</td>
				<td>${projectinfo.prjname}</td>
			</tr>
			<tr>
				<td class="bg-info">行政审批编号</td>
				<td>${projectinfo.prjinnernum}</td>
				<td class="bg-info">立项文号</td>
				<td>${projectinfo.prjapprovalnum}</td>
			</tr>
			<tr>
				<td class="bg-info">住建项目编号</td>
				<td>${projectinfo.prjapprovalnum}</td>
				<td class="bg-info">项目分类</td>
				<td><c:choose>
						<c:when test="${projectinfo.prjtypenum == '01'}">房屋建筑工程 </c:when>
						<c:when test="${projectinfo.prjtypenum == '02'}">市政工程</c:when>
						<c:otherwise>其他 </c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="bg-info">项目（法人）单位</td>
				<td>${projectinfo.buildcorpname}</td>
				<td class="bg-info">项目（法人）单位组织机构代码</td>
				<td>${projectinfo.buildcorpcode}</td>
			</tr>
			<tr>
				<td class="bg-info">立项级别</td>
				<td><c:choose>
						<c:when test="${projectinfo.prjapprovallevelnum == '001'}">部级 </c:when>
						<c:when test="${projectinfo.prjapprovallevelnum == '002'}">省级</c:when>
						<c:when test="${projectinfo.prjapprovallevelnum == '003'}">地市级</c:when>
						<c:when test="${projectinfo.prjapprovallevelnum == '004'}">区县级</c:when>
						<c:otherwise>其他 </c:otherwise>
					</c:choose></td>
				<td class="bg-info">项目地址</td>
				<td>${projectinfo.address}</td>
			</tr>
			<tr>
				<td class="bg-info">经度</td>
				<td>${projectinfo.jd}</td>
				<td class="bg-info">纬度</td>
				<td>${projectinfo.wd}</td>
			</tr>
			<tr>
				<td class="bg-info">建设用地规划许可证编号</td>
				<td>${projectinfo.buldplannum}</td>
				<td class="bg-info">建设工程规划许可证编号</td>
				<td>${projectinfo.projectplannum}</td>
			</tr>
			<tr>
				<td class="bg-info">拟开工时间（年）</td>
				<td><fmt:formatDate value="${projectinfo.bdate}" pattern="yyyy-MM-dd"/></td>
				<td class="bg-info">拟建成时间（年）</td>
				<td><fmt:formatDate value="${projectinfo.edate}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td class="bg-info">建设规模及内容</td>
				<td>${projectinfo.prjsize}</td>
				<td class="bg-info">总投资（万元）</td>
				<td>${projectinfo.allinvest}</td>
			</tr>
		</table>
	</div>
</div>