<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>征地信息管理</title>
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
		<li><a href="${ctx}/project/expropriationDetail/">征地信息列表</a></li>
		<li class="active"><a href="${ctx}/project/expropriationDetail/form?id=${expropriationDetail.id}">征地信息<shiro:hasPermission name="project:expropriationDetail:edit">${not empty expropriationDetail.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="project:expropriationDetail:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="expropriationDetail" action="${ctx}/project/expropriationDetail/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">项目代码：</label>
			<div class="controls">
				<form:input path="prjCode" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目名称：</label>
			<div class="controls">
				<form:input path="prjName" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批准文号：</label>
			<div class="controls">
				<form:input path="approveNum" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批准日期：</label>
			<div class="controls">
				<input name="approveDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${expropriationDetail.approveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">征地位置：</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区划编码：</label>
			<div class="controls">
				<form:input path="countyNum" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">lcid：</label>
			<div class="controls">
				<form:input path="lcid" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">display_flag：</label>
			<div class="controls">
				<form:input path="displayFlag" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">征地信息内容：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>信息类型</th>
								<th>信息内容</th>
								<th>标题</th>
								<th>发布单位</th>
								<th>发布日期</th>
								<th>file_name</th>
								<th>file_preffix</th>
								<th>file_url</th>
								<th>file_path</th>
								<th>display_flag</th>
								<shiro:hasPermission name="project:expropriationDetail:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="expropriationDetailInfoList">
						</tbody>
						<shiro:hasPermission name="project:expropriationDetail:edit"><tfoot>
							<tr><td colspan="12"><a href="javascript:" onclick="addRow('#expropriationDetailInfoList', expropriationDetailInfoRowIdx, expropriationDetailInfoTpl);expropriationDetailInfoRowIdx = expropriationDetailInfoRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="expropriationDetailInfoTpl">//<!--
						<tr id="expropriationDetailInfoList{{idx}}">
							<td class="hide">
								<input id="expropriationDetailInfoList{{idx}}_id" name="expropriationDetailInfoList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="expropriationDetailInfoList{{idx}}_delFlag" name="expropriationDetailInfoList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_infoType" name="expropriationDetailInfoList[{{idx}}].infoType" type="text" value="{{row.infoType}}" maxlength="20" class="input-small "/>
							</td>
							<td>
								<textarea id="expropriationDetailInfoList{{idx}}_content" name="expropriationDetailInfoList[{{idx}}].content" rows="4" maxlength="100" class="input-small ">{{row.content}}</textarea>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_title" name="expropriationDetailInfoList[{{idx}}].title" type="text" value="{{row.title}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_publicUnit" name="expropriationDetailInfoList[{{idx}}].publicUnit" type="text" value="{{row.publicUnit}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_publicDate" name="expropriationDetailInfoList[{{idx}}].publicDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
									value="{{row.publicDate}}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_fileName" name="expropriationDetailInfoList[{{idx}}].fileName" type="text" value="{{row.fileName}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_filePreffix" name="expropriationDetailInfoList[{{idx}}].filePreffix" type="text" value="{{row.filePreffix}}" maxlength="100" class="input-small "/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_fileUrl" name="expropriationDetailInfoList[{{idx}}].fileUrl" type="text" value="{{row.fileUrl}}" maxlength="255" class="input-small "/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_filePath" name="expropriationDetailInfoList[{{idx}}].filePath" type="text" value="{{row.filePath}}" maxlength="255" class="input-small "/>
							</td>
							<td>
								<input id="expropriationDetailInfoList{{idx}}_displayFlag" name="expropriationDetailInfoList[{{idx}}].displayFlag" type="text" value="{{row.displayFlag}}" maxlength="1" class="input-small "/>
							</td>
							<shiro:hasPermission name="project:expropriationDetail:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#expropriationDetailInfoList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var expropriationDetailInfoRowIdx = 0, expropriationDetailInfoTpl = $("#expropriationDetailInfoTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(expropriationDetail.expropriationDetailInfoList)};
							for (var i=0; i<data.length; i++){
								addRow('#expropriationDetailInfoList', expropriationDetailInfoRowIdx, expropriationDetailInfoTpl, data[i]);
								expropriationDetailInfoRowIdx = expropriationDetailInfoRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="project:expropriationDetail:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>