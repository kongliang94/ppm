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
						<legend style="color: cornflowerblue;">项目信息  <s:textfield cssClass="hidden" id="pid" name="pid"/> <s:textfield cssClass="hidden" id="flag" name="flag"></s:textfield></legend>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="ds_host">项目名称</label>
							<div class="col-sm-3">
								<s:textfield name="name" cssClass="form-control" readonly="true"></s:textfield>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">难易度</label>
							<div class="col-sm-3">
								<s:textfield name="nyd.description" cssClass="form-control" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目担当</label>
							<div class="col-sm-3">
								<s:textfield name="user.username" cssClass="form-control" readonly="true"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">项目阶段</label>
							<div class="col-sm-3">
							<s:textfield name="stage.stageId" cssClass="hidden" readonly="true" id="stageId"></s:textfield>
								<s:textfield name="stage.name" cssClass="form-control" readonly="true"></s:textfield>
							</div>
							<label class="col-sm-1 control-label">部门</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="department.name" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目唯一号</label>
							<div class="col-sm-3">
								<s:textfield id="onlynum" cssClass="form-control" name="onlynum" readonly="true"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label" for="ds_username">项目编号</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="number" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="sum" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="description" readonly="true"/>
							</div>
						</div>
						<div class="form-group" style="display: none;" id="stage2id">
							<label class="col-sm-1 control-label" for="ds_username">影响</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="round" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="sum" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="description" readonly="true"/>
							</div>
						</div>
						<div class="form-group" style="display: none;" id="stage3id">
							<label class="col-sm-1 control-label" for="ds_username">xxx</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="round" />
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="sum" />
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="description" />
							</div>
						</div>
					</fieldset>

				</div>
			</div>
			
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
												</button> </td>
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
					<h4>指定审批人</h4>
					<s:select list="#users"
                        		listKey="uid" 
                        		listValue="username" 
                        		name="uid"
                        		id="userId"></s:select>
					<button style="float: right;" class="btn btn-purple" onclick="addapprove()">添加</button>
				</div>
				 <div class="widget-body">
					<div class="widget-main">
						
						 	<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>审批人</th>
									<th>操作</th>	
								</tr>
							</thead>
							<c:forEach items="${approves}" var="approve">
							<tbody>								
									<tr>
										<td>
											${approve.user.username}									
										</td>
										<td><button class="btn btn-xs btn-danger" onclick="deleteapprove()">
												<i class="icon-trash bigger-120"></i>
											</button>
										</td>										
									</tr>
							</tbody>
							</c:forEach>
						</table>
						
    				<div class="center"><button class="btn btn-info" onclick="ok()">确定</button></div>
         	</div>	
			</div>
		
	</div>
	</div>
	<!-- /container -->

	<script src="${pageContext.request.contextPath}/js/project.js"></script>
	<script type="text/javascript">
		
		function addapprove(){
			
			var onlynum=$("#onlynum").val();
			var userId=$("#userId").val();
			var stageId=$("#stageId").val();
			alert(stageId);
			var pid=$("#pid").val();				
			$.post("${pageContext.request.contextPath}/projectAction_appointUser.action",
			{onlynum:onlynum,stageId:stageId,userId:userId,pid:pid},
			function(json){
				if (json.success) {
						location.reload();
					}else{
						alert(json.msg);
				}
			},'json');
		}
		function ok(){
			window.location.href="${pageContext.request.contextPath}/projectAction_showAppointUserPageResult.action";
		}
		
	</script>
</body>
</html>
