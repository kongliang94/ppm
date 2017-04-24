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
					<form  id="editForm" action="projectAction_update.action" method="post" onsubmit="return sub()">
					<fieldset>
						<legend style="color: cornflowerblue;">项目信息  <s:textfield cssClass="hidden" id="pid" name="pid"/> <s:textfield cssClass="hidden" id="mark" name="mark"/> <input class="hidden" id="id" name="id"/> <s:textfield cssClass="hidden" id="flag" name="flag"></s:textfield></legend>
						<div class="form-group">
							<label class="col-sm-1 control-label">项目名称</label>
							<div class="col-sm-3">
								<s:textfield name="name" cssClass="form-control" id="name"></s:textfield>
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="sum" id="money"/>
							</div>
							<label class="col-sm-1 control-label">项目简述</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="description" id="xmms"/>
							</div>
						</div>
						<div class="form-group">
							
							<label class="col-sm-1 control-label">部门</label>
							<div class="col-sm-3">
								<s:select list="#departments" 
								listKey="did" 
                        		listValue="name"
                        		cssClass="form-control"  
                        		name="did"></s:select>
							</div>
							<label class="col-sm-1 control-label">难易度</label>
							<div class="col-sm-3">								
								<s:select list="#values" 
								listKey="vid" 
                        		listValue="description"
                        		cssClass="form-control" 
                        		name="vid"></s:select>	
							</div>
							<label class="col-sm-1 control-label">项目担当</label>
							<div class="col-sm-3">								
								<s:select list="#users" 
								listKey="uid" 
                        		listValue="username"
                        		cssClass="form-control" 
                        		name="uid"></s:select>								
							</div>
							
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label">项目阶段</label>
							<div class="col-sm-3">
								<s:textfield cssClass="hidden" name="stage.stageId" id="stageId" readonly="true"/>
								<s:textfield cssClass="form-control" name="stage.name" id="stage" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_username">项目编号</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="number" readonly="true"/>
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目唯一号</label>
							<div class="col-sm-3">
								<s:textfield id="onlynum" cssClass="form-control" name="onlynum" readonly="true"/>
							</div>
							
							
						</div>
						<div class="form-group" style="display: none;" id="stage2id">
							<label class="col-sm-1 control-label" for="ds_username">影响</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="round" />
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="" />
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="" />
							</div>
						</div>
						<div class="form-group" style="display: none;" id="stage3id">
							<label class="col-sm-1 control-label" for="ds_username">规</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="" />
							</div>
							<label class="col-sm-1 control-label" for="ds_password">规模</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="" />
							</div>
							<label class="col-sm-1 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-3">
								<s:textfield cssClass="form-control" name="" />
							</div>
						</div>
					</fieldset>
					<div id="btn" class="center" style="padding-top: 10px;">
					
						<label style="color:#f00">如未操作，勿保存</label>
						<button id="save" class="btn btn-info" type="submit">
							<i class="icon-ok bigger-110"></i> 保存
						</button>
						<button id="back" class="btn btn-default" type="button" onclick="backinfo()">
							<i class="icon-backward bigger-110"></i> 返回
						</button>
					
					
					</div>
			
					</form>
				</div>
			</div>
			<div></div>
			<div class="row" style="padding-top: 30px">
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
												</button>
												 <a href="${pageContext.request.contextPath }/xitong.jsp">删除</a></td>
											</tr>
										</tbody>
										</c:forEach>
							</table>
							<div class="center">
								<button id="yes" class="btn btn-info"  type="button" onclick="stagedata()">
									<i class="icon-ok bigger-110"></i> 之前阶段
								</button>
								<button id="yes" class="btn btn-message" type="submit" onclick="uploadfile()">
									<i class="icon-upload bigger-110"></i> 上传
								</button>
							</div>
						</div>
					</div>
				</div>
				</form>
				<div class="widget-box" style="width:70%; margin:0 auto;padding-top: 30px">
					<div class="widget-header">
						<h4>审批</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main">

							<table id="sample-table-1"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>用户名</th>

										<th>审批状态</th>

										<th>描述</th>
									</tr>
								</thead>
								<c:forEach items="${approves}" var="approve">
								<tbody>								
									<tr>
										<td>${approve.user.username}</td>
										<td><c:if test="${approve.status==false}">未审批</c:if>
											<c:if test="${approve.status==true}">同意</c:if></td>
										<td>${approve.remark}</td>
									</tr>									
								</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>

				
					<div class="center">
						<button id="submit" class="btn btn-success" type="button"
							onclick="submitinfo()" style="display:none">
							<i class="icon-cloud-upload bigger-110"></i> 提交
						</button>
					</div>
		
	</div>
	<!-- /container -->

	

	<div class="copyright">
		<jsp:include page="/WEB-INF/jsp/ppm/public/footer.jsp"></jsp:include>
	</div>
	<script src="${pageContext.request.contextPath}/static/js/layer/layer.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/project.js"></script>
	<script type="text/javascript"> 
		
		function uploadfile() {
			var onlynum = $("#onlynum").val();
			var stageId = $("#stageId").val();
			var pid = $("#pid").val();
			//var id = $("#id").val();
			//if()
			//var pid = parseInt($("#pid").val())+1;
			//alert(id);
			$
					.layer({
						type : 2,
						border : [ 0 ],
						title : "用户信息",
						closeBtn : [ 0, true ],
						iframe : {
							src : "${pageContext.request.contextPath}/fileAction_uploadUI.action?pid="
									+ pid
									+ "&filePath="
									+ onlynum
									+ "&stage="
									+ stageId

						},
						area : [ '510px', '450px' ]
					});

		
		}
		
		function downName(path,name) {
			window.location.href = "${pageContext.request.contextPath}/fileAction_download.action?dir="
					+ path + "&name=" + encodeURI(encodeURI(name))
		}
		function backinfo() {
			window.location.href = "${pageContext.request.contextPath}/projectAction_showPageResult.action";
		}

		function submitinfo() {
			var pid = $("#pid").val();
			if (confirm("提交后不能修改，是否提交")) {

				window.location.href = "${pageContext.request.contextPath}/projectAction_sumbitInfo.action?pid="
						+ pid;
			} else {
				window.location.reload();
			}

		}
	</script>
</body>
</html>
