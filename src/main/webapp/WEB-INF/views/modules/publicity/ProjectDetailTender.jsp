<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/pubtaglib.jsp"%>
<div class="box box-info">
	<!-- /.box-header -->
<c:if test="${pkid ne '2018-320211-70-02-303414'}">

	<div class="box-header">
		<div class="approvetitle">资格预审公告</div>
	</div>
	<div class="box-body">
		<table class="table table-bordered">
		    <c:forEach items="${zigeyushen}" var="item" varStatus="status">
			<tr>
				<td class="bg-info" width="10%">公告名称</td>
				<td width="70%"><a
					href="${ctx}/publicity/tenderdetail?indexId=${item.indexid}"
					target="_blank">
						${item.title}</a></td>
				<td class="bg-info" width="10%">时间</td>
				<td width="10%"><fmt:formatDate value="${item.opentime}" pattern="yyyy-MM-dd"/></td>
			</tr>
			</c:forEach>
            <c:if test="${empty zigeyushen}">
            <tr>
                <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
            </tr>
            </c:if>

		</table>
	</div>


	<div class="box-header">
		<div class="approvetitle">招标公告</div>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
	        <c:forEach items="${zhaobiaogonggao}" var="item" varStatus="status">
    			<tr>
    				<td class="bg-info" width="10%">公告名称</td>
    				<td width="70%"><a
    					href="${ctx}/publicity/tenderdetail?indexId=${item.indexid}"
    					target="_blank">
    						${item.title}</a></td>
    				<td class="bg-info" width="10%">时间</td>
    				<td width="10%"><fmt:formatDate value="${item.opentime}" pattern="yyyy-MM-dd"/></td>
    			</tr>
    			</c:forEach>
            <c:if test="${empty zhaobiaogonggao}">
            <tr>
                <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
            </tr>
            </c:if>
		</table>
	</div>


	<div class="box-header">
		<div class="approvetitle">中标候选人公示</div>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
    <c:forEach items="${zhongbiaohouxuanren}" var="item" varStatus="status">
    			<tr>
    				<td class="bg-info" width="10%">公告名称</td>
    				<td width="70%"><a
    					href="${ctx}/publicity/tenderdetail?indexId=${item.indexid}"
    					target="_blank">
    						${item.title}</a></td>
    				<td class="bg-info" width="10%">时间</td>
    				<td width="10%"><fmt:formatDate value="${item.opentime}" pattern="yyyy-MM-dd"/></td>
    			</tr>
    			</c:forEach>
            <c:if test="${empty zhongbiaohouxuanren}">
            <tr>
                <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
            </tr>
            </c:if>
		</table>
	</div>

	<div class="box-header">
		<div class="approvetitle">中标结果</div>
	</div>
	 <c:if test="${empty tenderList}">
	 <div class="box-body">
	    <table class="table table-bordered">
                <tr>
                    <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
                </tr>
        </table>
                </div>
                </c:if>
	<c:forEach items="${tenderList}" var="item" varStatus="status">
		<div class="box-body">
			<div>${ status.index + 1}、标段名称 : ${item.tendername}</div>
			<table class="table table-bordered">
				<tr>
					<td class="bg-info">中标通知书编号</td>
					<td>${item.tendernum}</td>
					<td class="bg-info">中标通知书内部编号</td>
					<td>${item.tenderinnernum}</td>
				</tr>
				<tr>
					<td class="bg-info">招标类型</td>
					<td>${item.tenderclassnumlabel}</td>
					<td class="bg-info">招标方式</td>
					<td>${item.tendertypenumlabel}</td>
				</tr>
				<tr>
					<td class="bg-info">中标日期</td>
					<td><fmt:formatDate value="${item.tenderresultdate}"
							pattern="yyyy-MM-dd" /></td>
					<td class="bg-info">中标金额</td>
					<td>${item.tendermoney}</td>
				</tr>
				<tr>
					<td class="bg-info">建设规模</td>
					<td>${item.prjsize}</td>
					<td class="bg-info">面积（平方米）</td>
					<td>${item.area}</td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">招标代理单位名称</td>
					<td width="35%">${item.agencycorpname}</td>
					<td class="bg-info" width="15%">招标代理单位组织机构代码 （社会信用代码）</td>
					<td width="35%">${item.agencycorpcode}</td>
				</tr>
				<tr>
					<td class="bg-info">中标单位名称</td>
					<td>${item.tendercorpname}</td>
					<td class="bg-info">中标单位组织机构代码 （社会信用代码）</td>
					<td>${item.tendercorpcode}</td>
				</tr>
				<tr>
					<td class="bg-info">项目经理/总监理工程师姓名</td>
					<td>${item.constructorname}</td>
					<td class="bg-info">项目经理/总监理工程师电话</td>
					<td>${item.constructorphone}</td>
				</tr>
			</table>
		</div>
	</c:forEach>

</c:if>

<c:if test="${pkid eq '2018-320211-70-02-303414'}">
    <c:if test="${not empty zigeyushen}">
	<div class="box-header">
		<div class="approvetitle">资格预审公告</div>
	</div>
	<div class="box-body">
		<table class="table table-bordered">
		    <c:forEach items="${zigeyushen}" var="item" varStatus="status">
			<tr>
				<td class="bg-info" width="10%">公告名称</td>
				<td width="70%"><a
					href="${ctx}/publicity/tenderdetail?indexId=${item.indexid}"
					target="_blank">
						${item.title}</a></td>
				<td class="bg-info" width="10%">时间</td>
				<td width="10%"><fmt:formatDate value="${item.opentime}" pattern="yyyy-MM-dd"/></td>
			</tr>
			</c:forEach>
            <c:if test="${empty zigeyushen}">
            <tr>
                <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
            </tr>
            </c:if>

		</table>
	</div>
	 </c:if>

<c:if test="${not empty zhaobiaogonggao}">
	<div class="box-header">
		<div class="approvetitle">招标公告</div>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
	        <c:forEach items="${zhaobiaogonggao}" var="item" varStatus="status">
    			<tr>
    				<td class="bg-info" width="10%">公告名称</td>
    				<td width="70%"><a
    					href="${ctx}/publicity/tenderdetail?indexId=${item.indexid}"
    					target="_blank">
    						${item.title}</a></td>
    				<td class="bg-info" width="10%">时间</td>
    				<td width="10%"><fmt:formatDate value="${item.opentime}" pattern="yyyy-MM-dd"/></td>
    			</tr>
    			</c:forEach>
            <c:if test="${empty zhaobiaogonggao}">
            <tr>
                <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
            </tr>
            </c:if>
		</table>
	</div>
	</c:if>

<c:if test="${not empty zhongbiaohouxuanren}">
	<div class="box-header">
		<div class="approvetitle">中标候选人公示</div>
	</div>


	<div class="box-body">
		<table class="table table-bordered">
    <c:forEach items="${zhongbiaohouxuanren}" var="item" varStatus="status">
    			<tr>
    				<td class="bg-info" width="10%">公告名称</td>
    				<td width="70%"><a
    					href="${ctx}/publicity/tenderdetail?indexId=${item.indexid}"
    					target="_blank">
    						${item.title}</a></td>
    				<td class="bg-info" width="10%">时间</td>
    				<td width="10%"><fmt:formatDate value="${item.opentime}" pattern="yyyy-MM-dd"/></td>
    			</tr>
    			</c:forEach>
            <c:if test="${empty zhongbiaohouxuanren}">
            <tr>
                <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
            </tr>
            </c:if>
		</table>
	</div>
	</c:if>

	 <c:if test="${empty tenderList}">
	 <div class="box-header">
     		<div class="approvetitle">中标结果</div>
     	</div>
     <div class="box-body">
     			<table class="table table-bordered">
                <tr>
    				<td class="bg-info" width="10%">公告名称</td>
    				<td width="70%"><a
    					href="http://xzfw.wuxi.gov.cn/doc/2018/04/20/1808839.shtml"
    					target="_blank">[WXBH201804002-W01]XDG-2017-17号地块建设项目XDG-2017-17号地块（一期）施工工程</a></td>
    				<td class="bg-info" width="10%">时间</td>
    				<td width="10%">2018-04-20</td>
    			</tr>
                <tr>
        				<td class="bg-info" width="10%">公告名称</td>
        				<td width="70%"><a
        					href="http://xzfw.wuxi.gov.cn/doc/2018/04/20/1808840.shtml"
        					target="_blank">[WXBH201804002-W02]XDG-2017-17号地块建设项目XDG-2017-17号地块（一期）监理工程</a></td>
        				<td class="bg-info" width="10%">时间</td>
        				<td width="10%">2018-04-20</td>
        			</tr>
     			</div>
	 </c:if>
    <c:if test="${not empty tenderList}">
	<div class="box-header">
		<div class="approvetitle">中标结果</div>
	</div>
	 <c:if test="${empty tenderList}">
	 <div class="box-body">
	    <table class="table table-bordered">
                <tr>
                    <td>可点击&nbsp;&nbsp;<a href="http://xzfw.wuxi.gov.cn/ztzl/wxsggzyjyzx/index.shtml" target="_blank">无锡市公共资源交易中心</a>&nbsp;&nbsp;查询</td>
                </tr>
        </table>
                </div>
                </c:if>
	<c:forEach items="${tenderList}" var="item" varStatus="status">
		<div class="box-body">
			<div>${ status.index + 1}、标段名称 : ${item.tendername}</div>
			<table class="table table-bordered">
				<tr>
					<td class="bg-info">中标通知书编号</td>
					<td>${item.tendernum}</td>
					<td class="bg-info">中标通知书内部编号</td>
					<td>${item.tenderinnernum}</td>
				</tr>
				<tr>
					<td class="bg-info">招标类型</td>
					<td>${item.tenderclassnumlabel}</td>
					<td class="bg-info">招标方式</td>
					<td>${item.tendertypenumlabel}</td>
				</tr>
				<tr>
					<td class="bg-info">中标日期</td>
					<td><fmt:formatDate value="${item.tenderresultdate}"
							pattern="yyyy-MM-dd" /></td>
					<td class="bg-info">中标金额</td>
					<td>${item.tendermoney}</td>
				</tr>
				<tr>
					<td class="bg-info">建设规模</td>
					<td>${item.prjsize}</td>
					<td class="bg-info">面积（平方米）</td>
					<td>${item.area}</td>
				</tr>
				<tr>
					<td class="bg-info" width="15%">招标代理单位名称</td>
					<td width="35%">${item.agencycorpname}</td>
					<td class="bg-info" width="15%">招标代理单位组织机构代码 （社会信用代码）</td>
					<td width="35%">${item.agencycorpcode}</td>
				</tr>
				<tr>
					<td class="bg-info">中标单位名称</td>
					<td>${item.tendercorpname}</td>
					<td class="bg-info">中标单位组织机构代码 （社会信用代码）</td>
					<td>${item.tendercorpcode}</td>
				</tr>
				<tr>
					<td class="bg-info">项目经理/总监理工程师姓名</td>
					<td>${item.constructorname}</td>
					<td class="bg-info">项目经理/总监理工程师电话</td>
					<td>${item.constructorphone}</td>
				</tr>
			</table>
		</div>
	</c:forEach>
</c:if>
</c:if>


</div>


