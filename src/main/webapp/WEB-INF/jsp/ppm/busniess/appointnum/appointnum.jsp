<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/ppm/public/taglib.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>项目信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
<jsp:include page="/WEB-INF/jsp/ppm/public/pub.jsp"></jsp:include>
</head>

<body>


	<div class="page-content">		
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->

					<fieldset>
						<legend style="color: cornflowerblue;">项目信息 <s:textfield cssClass="hidden" id="pid" name="pid"/>  <s:textfield cssClass="hidden" id="flag" name="flag"></s:textfield></legend>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="ds_host">项目名称</label>
							<div class="col-sm-3">
								<s:textfield name="name" readonly="true"></s:textfield>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">难易度</label>
							<div class="col-sm-3">
								<s:textfield name="nyd.description" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目担当</label>
							<div class="col-sm-3.5">
								<s:textfield name="user.username" readonly="true"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">项目阶段</label>
							<div class="col-sm-3">
								<s:textfield id="stage" class="form-control" name="stage.name" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label">部门</label>
							<div class="col-sm-3">
								<s:textfield class="form-control" name="department.name" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目唯一号</label>
							<div class="col-sm-3.5">
								<s:textfield id="onlynum" class="form-control" name="onlynum" readonly="true"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="ds_username">项目编号</label>
							<div class="col-sm-3">
								<s:textfield class="form-control" name="number" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield class="form-control" name="sum" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-3">
								<s:textfield class="form-control" name="description" readonly="true"/>
							</div>
						</div>

					</fieldset>

				</div>
			</div>
			<div class="row">
				<div class="widget-box" style="width:70%; margin:0 auto;">
					<div class="widget-header">
						<h4>成果物</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main">

							<table id="sample-table-1"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>

										<th>文件名</th>
										<th>上传日期</th>
										<th>操作</th>
									</tr>
								</thead>
								<c:forEach items="${results}" var="file">
										<tbody>
											<tr>
												<td class="hidden">${file.id}</td>
												<td>${file.fileName}</td>
												<td>${file.uploadDate}</td>

												<td><button class="btn btn-xs btn-info" onclick="downName('${file.filePath}','${file.fileName}')" title="下载">
													<i class="icon-cloud-download bigger-120"></i>
												</button></td>
											</tr>
										</tbody>
										</c:forEach>
							</table>
							<div class="center">
								<button id="yes" class="btn btn-info"  type="button" onclick="stagedata()">
									<i class="icon-ok bigger-110"></i> 之前阶段
								</button>
								
							</div>
						</div>
					</div>
				</div>

				<div class="widget-box" style="width:70%; margin:0 auto;">
				<div class="widget-header">
					<h4>指定唯一编号</h4>		
				</div>
				<div class="widget-body">
					<div class="widget-main">
						
						<label class="col-sm-2 control-label" for="ds_name">请输入唯一编号:</label>		
                             <input id="addnumber" name="number" type="text" autofocus required/>
                             &nbsp;
                            <button type="submit" onclick="submitnum()" class="button">提交</button>
							<button type="yes" onclick="ok()" class="button">确定</button>
        			</div>
        		</div>
         	</div>

				
			</div>
		
	</div>
	<!-- /container -->

	
	<jsp:include page="/WEB-INF/jsp/ppm/public/footer.jsp"></jsp:include>
	<script type="text/javascript">
	
		function stagedata(){
			//var pid=$("#pid").val();
			//alert(pid);
			var stage=$("#stage").val();
			if(stage=="企划"){
				alert("这是第一阶段");
			}
		}
		

		function submitnum() {
		var pid=$("#pid").val();
		var addnumber=$("#addnumber").val().trim();
			//alert(pid);
		if(addnumber==null||addnumber==""){
			alert("该字段不能为空！");
		}else{
			if (confirm("提交后不能修改，是否提交")) {
				//window.location.href="${pageContext.request.contextPath}/projectAction_appointnum.action?pid="+pid+"&number="+addnumber;
					$.post("${pageContext.request.contextPath}/projectAction_appointnum.action",
			{number:addnumber,pid:pid},
			function(json){
				if (json.success) {
						location.reload();
					}else{
						alert(json.msg);
				}
			},'json');
								
				} 
				else{
					location.reload();
				}
		}
		}
		function ok(){
			window.location.href="${pageContext.request.contextPath}/projectAction_showAppointNumPageResult.action";
		}
	</script>
</body>
</html>
