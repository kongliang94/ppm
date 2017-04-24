<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>nav</title>
	<jsp:include page="/WEB-INF/jsp/ppm/public/pub.jsp"></jsp:include>
  </head>
  
  <body>
  	<div class="container">
		<div class="nav navbar-pink" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <i class="icon-leaf"></i>
					Panasonic </a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div id="navbar" class="navbar-header pull-right">


				<ul id="myTab"
					class="nav nav-pills padding-12 tab-color-white background-white">
					<li class=""><a href="${pageContext.request.contextPath}/projectAction_showOwnProject.action">项目信息</a>
					</li>
					<li class=""><a href="${pageContext.request.contextPath}/projectAction_showAppointUserPageResult.action">指定审批人</a></li>
					<li class=""><a href="${pageContext.request.contextPath}/projectAction_showAppointNumPageResult.action">指定项目编号</a></li>
					<li class=""><a href="${pageContext.request.contextPath}/projectAction_showApproveProjectList.action">审批</a>
					</li>

					<li><a href="#">数据下载</a>
					</li>
					<li class="disabled"><a data-toggle="tab" href="##">Responsive</a>
					</li>
				</ul>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	$().ready(function() {
	 	$("li").each(function(index){
	 	
  			$(this).click(function(){ 
  				$("li").removeClass("active");
  				$("li").eq(index).addClass("active");

  			});
  			
  		});
 	});
 </script>
</body>
 </html>
