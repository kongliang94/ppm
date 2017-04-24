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
     	<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1"> 用户名 :</label>
							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="logonname"
									class="col-xs-4 col-sm-6" name="logonname" />&nbsp;(用户名必须唯一)
							</div>

						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-input-readonly"> 密码 :</label>

							<div class="col-sm-9">
								<input readonly="1" type="text" class="col-xs-4 col-sm-6"
									id="form-input-readonly" value="123456" name="logonpwd" />

							</div>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1"> 真实姓名 :</label>

							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="Username"
									class="col-xs-4 col-sm-6" name="username" />
							</div>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-2"> 邮箱:</label>

							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="Email"
									class="col-xs-4 col-sm-6" name="email" />
							</div>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1"> 电话:</label>

							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="Phone"
									class="col-xs-4 col-sm-6" name="phone" />
							</div>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1"> 责任ID:</label>

							<div class="col-sm-9">
								<input type="text" id="form-field-1" placeholder="dutyID"
									class="col-xs-4 col-sm-6" name="dutyId" />
							</div>
						</div>
					</div>
	<div class="modal-body">
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right"
				for="form-field-1"> 审批人标识:</label>

				<div class="col-sm-9">
					<div class="radio">
						<label> <input class="ace" name="approvemark"
							type="radio" value="1"> <span class="lbl">是</span> </label>
					
						<label> <input class="ace" name="approvemark"
							type="radio" value="0"> <span class="lbl">否</span> </label>
					</div>
				</div>
				</div>
			</div>
		
		<div class="modal-body">
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right"
					for="form-field-1"> 部门:</label>

				<div class="col-sm-9">

					<s:select list="#departments" listKey="did" listValue="name"
						headerKey="0" headerValue="==请选择==" name="did"></s:select>

				</div>
			</div>
		</div>


		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal" onclick="checks()">关闭
			</button>
			<input type="submit" class="btn btn-primary" value="提交" />
		</div>
		<script type="text/javascript">
			function checks()
    {
        var radios=document.getElementsByName("approvemark");
        for(var i=0;i<radios.length;i++)
        {
            if(radios[i].checked==true)
            {
                alert("你最喜欢的语言是："+radios[i].value);
            }
        }
    }
		</script>
</body>
</html>
