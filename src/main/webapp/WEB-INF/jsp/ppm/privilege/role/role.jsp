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

<title>部门管理</title>
<jsp:include page="/WEB-INF/jsp/ppm/public/pub.jsp"></jsp:include>

</head>

<body>
	<jsp:include page="/WEB-INF/jsp/ppm/public/top.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span> </a>
			<jsp:include page="/WEB-INF/jsp/ppm/public/left.jsp"></jsp:include>

			
				
			
			<div class="page-content">
				<div class="content_wrap">
					<div class="zTreeDemoBackground left">
						<ul id="tree" class="ztree" style="-moz-user-select: none;"></ul>
					</div>

					<div class="addnodes" id="rMenu"
						style="position:absolute;display:none;overflow:hidden">
						<ul>
							<li id="addRole"
								style="background: url(${pageContext.request.contextPath}/style/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">增加角色</li>
							<li id="deleteRole"
								style="background: url(${pageContext.request.contextPath}/style/images/jian.jpg) 10px 9px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">删除角色</li>
							<li id="updateRole"
								style="background: url(${pageContext.request.contextPath}/style/images/jian.jpg) 10px 9px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">修改角色</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		</div>
		</body>
</html>
