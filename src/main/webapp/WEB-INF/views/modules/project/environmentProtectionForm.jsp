<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>施工期环境保护措施管理</title>
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
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/project/environmentProtection/">施工期环境保护措施列表</a></li>
		<li class="active"><a href="${ctx}/project/environmentProtection/form?id=${environmentProtection.id}">施工期环境保护措施<shiro:hasPermission name="project:environmentProtection:edit">${not empty environmentProtection.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:environmentProtection:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="environmentProtection" action="${ctx}/project/environmentProtection/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">发改项目代码：</label>
			<div class="controls">
			    <form:select path="prjCode" class="input-xxlarge">
                <form:options items="${projectList}" itemLabel="projectName" itemValue="projectCode" htmlEscape="false"/>
                </form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设置施工现场封闭围挡：</label>
			<div class="controls">
				<form:radiobuttons path="closeFlag" items="${fns:getDictList('environment_close')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设置冲洗设施、道路硬化等扬尘措施：</label>
			<div class="controls">
				<form:radiobuttons path="washFlag" items="${fns:getDictList('environment_close')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">施工期环境保护措施整改情况：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>整改情况</th>
								<th>整改通知</th>
								<shiro:hasPermission name="project:environmentProtection:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="environmentProtectionRectifyList">
						</tbody>
						<shiro:hasPermission name="project:environmentProtection:edit"><tfoot>
							<tr><td colspan="5"><a href="javascript:" onclick="addRow('#environmentProtectionRectifyList', environmentProtectionRectifyRowIdx, environmentProtectionRectifyTpl);environmentProtectionRectifyRowIdx = environmentProtectionRectifyRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="environmentProtectionRectifyTpl">//<!--
						<tr id="environmentProtectionRectifyList{{idx}}">
							<td class="hide">
								<input id="environmentProtectionRectifyList{{idx}}_id" name="environmentProtectionRectifyList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="environmentProtectionRectifyList{{idx}}_delFlag" name="environmentProtectionRectifyList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<textarea id="environmentProtectionRectifyList{{idx}}_rectify" name="environmentProtectionRectifyList[{{idx}}].rectify" rows="4" maxlength="255" class="input-xxlarge ">{{row.rectify}}</textarea>
							</td>
							<td>
								<textarea id="environmentProtectionRectifyList{{idx}}_rectifyNotice" name="environmentProtectionRectifyList[{{idx}}].rectifyNotice" rows="4" maxlength="255" class="input-xxlarge  ">{{row.rectifyNotice}}</textarea>
							</td>
							<shiro:hasPermission name="project:environmentProtection:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#environmentProtectionRectifyList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var environmentProtectionRectifyRowIdx = 0, environmentProtectionRectifyTpl = $("#environmentProtectionRectifyTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(environmentProtection.environmentProtectionRectifyList)};
							for (var i=0; i<data.length; i++){
								addRow('#environmentProtectionRectifyList', environmentProtectionRectifyRowIdx, environmentProtectionRectifyTpl, data[i]);
								environmentProtectionRectifyRowIdx = environmentProtectionRectifyRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="project:environmentProtection:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>