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
						<legend style="color: cornflowerblue;">项目信息  <s:textfield cssClass="hidden" id="pid" name="pid"/> 
						<s:textfield cssClass="hidden" id="flag" name="flag"></s:textfield>
						<input class="hidden" id="userid">${sessionScope.user.uid}</input></legend>
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
							  <s:textfield id="stageId" cssClass="hidden" name="stage.stageId" readonly="true"/>
								<s:textfield id="stage" cssClass="form-control" name="stage.name" readonly="true"/>
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
					<h4>审批</h4>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form class="form-inline"  id="approve-form">
						 	<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>用户名 </th>
									<th>审批状态</th>					
									<th>描述</th>
								</tr>
							</thead>
							
							<tbody>	
							<c:forEach items="${approves}" var="approve">						
									<tr id="content">
										<td id="userid">${approve.user.username}
										</td>
										<td id="status"><c:if test="${approve.status==false}">未审批</c:if>
											<c:if test="${approve.status==true}">同意</c:if>
										</td>
										
										<td>
										${approve.remark}
										</td>
									</tr>	
									</c:forEach>
							</tbody>
							
						</table>
						<div>
							<label>备注</label>
			
							<textarea class="form-control" id="text">
							</textarea>
							  <span></span>
						</div>
    					<div class="center">
    					<button id="yees" class="button btn-info" type="button" onclick="approveProject()">
							<i class="icon-ok bigger-110"></i>
							同意
						</button>
						<button id="no" class="button" type="button">
							<i class="icon-undo bigger-110"></i>
							不同意
						</button>
						<button id="back" class="button purple" type="button" onclick="javascript:history.go(-1)"> 
							<i class="icon-backward bigger-110"></i>
							返回
     					</button>
    					</div>
						</form>
        			</div>
        		</div>
         </div>

				
			</div>
		
	</div>
	<!-- /container -->
	<div class="footer">
		<jsp:include page="/WEB-INF/jsp/ppm/public/footer.jsp"></jsp:include>
	</div>
	<script src="${pageContext.request.contextPath}/js/project.js"></script>
	<script type="text/javascript">
	
		
		function approveProject(){
			var aid=${sessionScope.user.uid};
			var pid=$("#pid").val();
			var onlynum=$("#onlynum").val();
			window.location.href="${pageContext.request.contextPath}/projectAction_approve.action?aid="+aid+"&pid="+pid+"&onlynum="+onlynum;
			
			
		}
		$().ready(function(){
			var aid=${sessionScope.user.uid};
			var pid=$("#pid").val();
			var onlynum=$("#onlynum").val();
			
			var stageId=$("#stageId").val();
			
	
	$("button#no").unbind("click");
	$("button#no").bind("click",function(){
			var remark=$("textarea#text").val();
			//alert(remark);
            if ($("textarea#text").val().trim()==null||$("textarea#text").val().trim()=="") {
             	alert("请输入驳回原因");                	
            }else{
            	$.post(
            		"${pageContext.request.contextPath}/projectAction_disapprove.action",
            		{pid:pid,uid:aid,stageId:stageId,onlynum:onlynum,remark:remark},
            		function(json){
            			//alert(json.success);
            			if(json.success){
            				window.location.href="${pageContext.request.contextPath}/projectAction_showApproveProjectList.action";
            			}
            			else{
            				alert(json.msg);
            				window.location.reload();
            			}
            		},'json');
            }                    
	});
});
		
	</script>
</body>
</html>
