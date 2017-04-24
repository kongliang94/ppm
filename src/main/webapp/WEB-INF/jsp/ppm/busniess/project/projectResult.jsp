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
				
				
</body>
</html>
