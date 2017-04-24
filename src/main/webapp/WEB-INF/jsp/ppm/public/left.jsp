<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>top</title>

</head>

<body>
	<div class="sidebar" id="sidebar">
		<script type="text/javascript">
					
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-success">
					<i class="icon-signal"></i>
				</button>

				<button class="btn btn-info">
					<i class="icon-pencil"></i>
				</button>

				<button class="btn btn-warning">
					<i class="icon-group"></i>
				</button>

				<button class="btn btn-danger">
					<i class="icon-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span> <span class="btn btn-info"></span> <span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
			</div>
		</div>
		<!-- #sidebar-shortcuts -->

		<ul id="left_con" class="nav nav-list">
			<li><a href="#"> <i class="icon-dashboard"></i> <span class="menu-text"> 欢迎页面 </span>
			</a></li>

			<li><a href="${pageContext.request.contextPath}/userAction_showPageResult.action"> <i class="icon-text-width"></i> <span class="menu-text"> 用户管理 </span>
			</a></li>

			<li><a href="${pageContext.request.contextPath}/departmentAction_showPageResult.action"> <i class="icon-list-alt"></i> <span class="menu-text"> 部门管理 </span>
			</a></li>

			<li><a href="${pageContext.request.contextPath}/projectStageAction_showAllStage.action"> <i class="icon-calendar"></i> <span class="menu-text"> 项目阶段管理</span>
			</a></li>
			<li><a href=""> <i class="icon-calendar"></i> <span class="menu-text"> 角色管理</span>
			</a></li>
			<li><a href=""> <i class="icon-calendar"></i> <span class="menu-text"> 权限配置</span>
			</a></li>

		</ul>
		<!-- /.nav-list -->

		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
		</div>

<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>
	</div>
</body>
</html>
