<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/ppm/public/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加部门</h4>
				</div>
				<s:form action="departmentAction_add.action">


					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1"> 部门名称:</label>
							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="depname"
									class="col-xs-4 col-sm-6" name="name" />
							</div>

						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1"> 部门描述:</label>
							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="description"
									class="col-xs-4 col-sm-6" name="description" />
							</div>

						</div>
					</div>
					
					

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<input type="submit" class="btn btn-primary" value="提交" />
					</div>
				</s:form>
			</div>
  </body>
</html>
