<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="box box-info">
<c:forEach items="${list}" var="item" varStatus="status">
	<div class="box-header">
		<div class="approvetitle">
			报监工程${ status.index + 1}：<span>${item.xmmc}</span>
		</div>
	</div>

	<div class="box-body">
		<div>项目法人单位： ${item.jsdwName}</div>
		<table class="table table-bordered">
			<tr class="bg-info">
				<td>岗位</td>
				<td>姓名</td>
				<td>身份证号码</td>
				<td>联系电话</td>
			</tr>
			<c:forEach items="${item.jsdwRyList}" var="subItem">
				<tr>
					<td>${subItem.gw}</td>
					<td>${subItem.xm}</td>
					<td>${subItem.idcard}</td>
					<td>${subItem.lxdh}</td>
				</tr>
			</c:forEach>
		</table>

		<c:forEach items="${item.dwList}" var="dwItem">
			<div>${dwItem.dwlx}：${dwItem.dwName}</div>
			<table class="table table-bordered">
				<tr class="bg-info">
					<td width="10%">岗位</td>
					<td width="10%">姓名</td>
					<td width="10%">身份证号码</td>
					<td width="10%">联系电话</td>
					<td width="10%">资质证书编号</td>
					<td width="10%">资质类型和等级</td>
					<td width="10%">资格类型及证号</td>
				</tr>
				<c:forEach items="${dwItem.dwRyList}" var="dwryItem">
				<tr>
					<td width="10%">${dwryItem.gw}</td>
					<td width="10%">${dwryItem.xm}</td>
					<td width="10%">${dwryItem.idcard}</td>
					<td width="10%">${dwryItem.lxdh}</td>
					<td width="10%">${dwryItem.zzzs}</td>
					<td width="10%">${dwryItem.zzlxdj}</td>
					<td width="10%">${dwryItem.zgzh}</td>
				</tr>
				</c:forEach>
			</table>

		</c:forEach>

		<div>施工期环境保护措施落实情况</div>

		<table class="table table-bordered ">
			<tr class="bg-info">
				<td width="30%">落实事项</td>
				<td width="70%">落实情况</td>
			</tr>
			<tr>
				<td>扬尘检查情况、整改情况</td>
				<td></td>
			</tr>
			<tr>
				<td>施工场地出入口车辆冲洗检查情况， 整改情况</td>
				<td></td>
			</tr>

		</table>
	</div>
</c:forEach>
</div>