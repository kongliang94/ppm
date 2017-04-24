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
<script type="text/javascript">
	
	$().ready(function() {
		//设置分页要跳转到的url
		$("body").data("url", "projectAction_showOwnProject.action");
		//声明分页的事件	
		GylUtils.basedata.initEvent();
		
	});
</script>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/ppm/public/nav.jsp"></jsp:include>
	<div class="main-container" id="main-container">

		<div class="container">
	<div class="page-content">
						<div class="page-header">
							<h1>
								欢迎进入项目管理后台系统
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->


                                	 欢迎使用项目管理后台系统 
								<div class="hr hr32 hr-dotted"></div>


								<div class="hr hr32 hr-dotted"></div>


								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					</div>
					</div>
</body>
</html>
