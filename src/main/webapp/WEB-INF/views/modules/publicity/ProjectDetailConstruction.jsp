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
		<table class="table table-bordered">
			<tr>
				<td class="bg-info" width="20%">项目法人单位：</td>
				<td width="30%" > ${item.jsdwName}</td> 
				<td class="bg-info" width="20%">${item.jsdwRyList.get(0).gw}：</td>
				<td width="30%" > ${item.jsdwRyList.get(0).xm}</td> 
			</tr>
		</table>
		<!-- <table class="table table-bordered">
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
		</table>  -->
		<c:forEach items="${item.dwList}" var="dwItem">
			<div>${dwItem.dwlx}：${dwItem.dwName}</div>
			<table class="table table-bordered">
				<tr class="bg-info">
					<td width="10%">岗位</td>
					<td width="10%">姓名</td>
					<!-- <td width="10%">身份证号码</td>
					<td width="10%">联系电话</td> -->
					<td width="10%">资质证书编号</td>
					<td width="10%">资质类型和等级</td>
					<td width="10%">资格类型及证号</td>
				</tr>
				<c:forEach items="${dwItem.dwRyList}" var="dwryItem">
				<tr>
					<td width="10%">${dwryItem.gw}</td>
					<td width="10%">${dwryItem.xm}</td>
					<!-- <td width="10%">${dwryItem.idcard}</td>
					<td width="10%">${dwryItem.lxdh}</td> -->
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
			<c:forEach items="${item.hjList}" var="hjItem">
			<tr>
				<td>${hjItem.jdxm}</td>
				<td>${hjItem.jdqk}</td>
			</tr>
			</c:forEach>


		</table>
	</div>
</c:forEach>

<div class="box-header">
		<div class="approvetitle">
			施工期环境保护措施
		</div>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tr>
				<td class="bg-info" width="20%">设置施工现场封闭围挡：</td>
                <c:choose>
			        <c:when test="${not empty envProtect.closeFlag and envProtect.closeFlag==1}">
			        <td width="30%" style="background-color:#ffeb3b"> ${fns:getDictLabel(envProtect.closeFlag, 'environment_close', '已设置')}</td>
			        </c:when>
			    	<c:otherwise>
			    	<td width="30%" > ${fns:getDictLabel(envProtect.closeFlag, 'environment_close', '已设置')}</td>
			    	</c:otherwise>
			    </c:choose>
                <td class="bg-info" width="20%">设置冲洗设施、道路硬化等扬尘措施：</td>
                <c:choose>
			        <c:when test="${not empty envProtect.washFlag  and envProtect.washFlag==1}">
                    <td width="30%" style="background-color:#ffeb3b"> ${fns:getDictLabel(envProtect.washFlag, 'environment_close', '已设置')}</td>
			        </c:when>
			    	<c:otherwise>
			    	<td width="30%" > ${fns:getDictLabel(envProtect.washFlag, 'environment_close', '已设置')}</td>
			    	</c:otherwise>
			    </c:choose>

			</tr>

			<c:if test="${empty envProtect.environmentProtectionRectifyList}">
            <tr>
				<td class="bg-info" width="25%">整改措施：</td>
				<td width="25%" >无</td>
				<td class="bg-info" width="25%">检查整改情况 ：</td>
				<td width="25%" >无</td>
			</tr>
			</c:if>
			<c:forEach items="${envProtect.environmentProtectionRectifyList}" var="u" varStatus="status">
            <tr>
				<td class="bg-info" width="25%">整改措施 ${status.index+1}：</td>
				<td width="25%" > <c:out value="${u.rectify}" escapeXml="false"/></td>
				<td class="bg-info" width="25%">检查整改情况 ${status.index+1}：</td>
				<td width="25%" > <c:out value="${u.rectifyNotice}" escapeXml="false"/></td>
			</tr>
            </c:forEach>
		</table>
	</div>
</div>
</div>