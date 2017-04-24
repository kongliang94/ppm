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
					<li class="active"><a href="${pageContext.request.contextPath}/projectAction_showAppointUserPageResult.action">指定审批人</a></li>
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
	<div class="main-container" id="main-container">

		<div class="container">
			<form class="form-search">
				<div class="row">
					<div class="col-sm-3">
						<div class="input-group">
							<input class="form-control search-query"
								placeholder="Type your query" type="text"> <span
								class="input-group-btn">
								<button class="btn btn-purple btn-sm" type="button">
									Search <i class="icon-search icon-on-right bigger-110"></i>
								</button> </span>
						</div>
					</div>
					
				</div>
			</form>

			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<table id="sample-table-1"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"></th>									
										<th>项目名称</th>
										<th>担当名称</th>
										<th class="hidden-480">阶段</th>
										<th>规模</th>

										<th><i class="icon-time bigger-110 hidden-480"></i> 更新日期
										</th>
										<th class="hidden-480">审批状态</th>


									</tr>
								</thead>
								<s:iterator value="#projects" var="p">
									<tbody>
										<tr>
											<td class="center"><a href="projectAction_appointUserUI.action?pid=${pid}">指定</a></td>
											<td><s:property value="name" />
											</td>
											<td><s:property value="user.username" />
											</td>
											<td><s:property value="stage.name" />
											</td>
											<td><s:property value="sum" />
											</td>
											<td><s:property value="freshDate" />
											</td>
											<td><s:if test="#p.status==0">推进中..</s:if>
											<s:if test="#p.status==1">审批中..</s:if>
											<s:if test="#p.status==2">已完成</s:if>
											</td>
										</tr>


									</tbody>
								</s:iterator>
							</table>
							
						</div>
						<!-- /.table-responsive -->
					</div>
					<!-- /span -->
				</div>
				<!-- /row -->

			</div>
			<!-- /container -->

		</div>

	</div>
	<jsp:include page="/WEB-INF/jsp/ppm/public/footer.jsp"></jsp:include>
	<script type="text/javascript">
		
									
	</script>
</body>
</html>
