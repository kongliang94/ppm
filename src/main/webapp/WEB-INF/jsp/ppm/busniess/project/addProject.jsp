<%@ page language="java" pageEncoding="UTF-8"%>
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
<jsp:include page="/WEB-INF/jsp/ppm/public/pub.jsp"></jsp:include>
</head>

<body>
	
	
	
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form class="form-horizontal" action="projectAction_add.action"
					method="post">
					<fieldset>
						<legend style="color: cornflowerblue;">项目信息</legend>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="ds_host">项目名称</label>
							<div class="col-sm-2">
								<input class="form-control" name="name" type="text"
									placeholder="项目名称" />
							</div>
							<label class="col-sm-2 control-label">难易度</label>
							<div class="col-sm-2">
								<s:select list="#values" 
								listKey="vid" 
                        		listValue="description"
                        		cssClass="form-control" 
                        		name="vid"></s:select>	
							</div>
							<label class="col-sm-2 control-label">项目担当</label>
							<div class="col-sm-2">
								<s:select list="#users" 
								listKey="uid" 
                        		listValue="username"
                        		cssClass="form-control" 
                        		name="uid"></s:select>	
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="ds_password">规模</label>
							<div class="col-sm-2">
								<input class="form-control" name="sum" type="text"
									placeholder="123456" />
							</div>
							<label class="col-sm-2 control-label" for="ds_name">项目简述</label>
							<div class="col-sm-2">
								<input class="form-control" name="description" type="text"
									placeholder="ms" />
							</div>
							
							<label class="col-sm-2 control-label" for="ds_password">部门</label>
							<div class="col-sm-2">
								<s:select list="#departments" 
								listKey="did" 
                        		listValue="name"
                        		cssClass="form-control"  
                        		name="did"></s:select>
							</div>
							
						</div>
						<div class="form-group">
						<label class="col-sm-2 control-label" for="ds_username">阶段</label>
							<div class="col-sm-2">
								<s:select list="#stages" 
								listKey="id" 
                        		listValue="name"
                        		cssClass="form-control"
                        		name="id"></s:select>			
							</div>
							<label class="col-sm-2 control-label" for="ds_username">项目编号</label>
							<div class="col-sm-2">
								<input class="form-control" disabled="disabled" type="text"
									placeholder="不可填写" />
							</div>
							<label class="col-sm-2 control-label" for="ds_password">项目唯一号</label>
							<div class="col-sm-2">
								<input id="demo" class="form-control" name="onlynum" readonly></input>
							</div>
							
						</div>
						<div class="form-group">

							
						</div>
					</fieldset>
		
						<div id="btn" style="padding-top: 10px;">

							

							<div class="center">
								<button id="yes" class="btn btn-info" type="submit" onclick="saveinfo()">
									<i class="icon-ok bigger-110"></i> 保存
								</button>
								<button id="back" class="btn btn-default" type="button"
									onclick="javascript:history.go(-1)">
									<i class="icon-backward bigger-110"></i> 返回
								</button>
							</div>							

						</div>
					
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" language="javascript">
		var date = new Date();
		var month = date.getMonth() + 1;
		var strDate = date.getDate();
		if (month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if (strDate >= 0 && strDate <= 9) {
			strDate = "0" + strDate;
		}
		var currentdate = date.getFullYear() + "" + month + "" + strDate + ""
				+ date.getHours() + "" + date.getMinutes() + ""
				+ date.getSeconds();
		$("#demo").val(currentdate);
		//$("#demo").attr("placeholder",currentdate);
		function saveinfo(){
			
		}
	</script>
</body>
</html>
