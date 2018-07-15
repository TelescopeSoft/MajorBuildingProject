<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/project/projectInfo/">项目表列表</a></li>
		<li class="active"><a href="${ctx}/project/projectInfo/form?id=${projectInfo.pkid}">项目表<shiro:hasPermission name="project:projectInfo:edit">${not empty projectInfo.pkid?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:projectInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="projectInfo" action="${ctx}/project/projectInfo/save" method="post" class="form-horizontal">
		<form:hidden path="pkid"/>
		<form:hidden path="updateflag"/>
		<form:hidden path="sbdqbm"/>
		<form:hidden path="datastate"/>
		<form:hidden path="issgbz"/>
		<form:hidden path="prjapprovallevelnum"/>
		
		<sys:message content="${message}"/>		
		 
		<div class="control-group">
			<label class="control-label">项目编码：</label>
			<div class="controls">
				<form:input path="prjnum" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">内部编号：</label>
			<div class="controls">
				<form:input path="prjinnernum" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目名字：</label>
			<div class="controls">
				<form:input path="prjname" htmlEscape="false" maxlength="300" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目分类：</label>
			<div class="controls">
				<form:input path="prjtypenum" htmlEscape="false" maxlength="2" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设单位：</label>
			<div class="controls">
				<form:input path="buildcorpname" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设单位组织机构代码：</label>
			<div class="controls">
				<form:input path="buildcorpcode" htmlEscape="false" maxlength="18" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">省：</label>
			<div class="controls">
				<form:input path="provincenum" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">市：</label>
			<div class="controls">
				<form:input path="citynum" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区：</label>
			<div class="controls">
				<form:input path="countynum" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">立项文号：</label>
			<div class="controls">
				<form:input path="prjapprovalnum" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		 
		<div class="control-group">
			<label class="control-label">建设用地规划许可证编号：</label>
			<div class="controls">
				<form:input path="buldplannum" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设工程规划许可证编号：</label>
			<div class="controls">
				<form:input path="projectplannum" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总投资（万元）：</label>
			<div class="controls">
				<form:input path="allinvest" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总面积（平方米）：</label>
			<div class="controls">
				<form:input path="allarea" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设规模：</label>
			<div class="controls">
				<form:input path="prjsize" htmlEscape="false" maxlength="500" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建设性质：</label>
			<div class="controls">
				<form:input path="prjpropertynum" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工程用途：</label>
			<div class="controls">
				<form:input path="prjfunctionnum" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">实际开工日期：</label>
			<div class="controls">
				<input name="bdate" type="text" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${projectInfo.bdate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">实际竣工日期：</label>
			<div class="controls">
				<input name="edate" type="text" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${projectInfo.edate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">记录登记时间：</label>
			<div class="controls">
				<input name="createDate" type="text" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${projectInfo.createDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		 
		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<form:input path="jd" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<form:input path="wd" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="project:projectInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>