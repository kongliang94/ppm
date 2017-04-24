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

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">			
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>
					
					&nbsp;&nbsp;&nbsp;&nbsp;用户名：&nbsp;&nbsp;<input
						placeholder="Type something…" type="text">
					<ul class="breadcrumb">
						
						<input type="button" class="button purple" value="查询"
							onclick="upload()" sytle="padding-bottom: 0px;padding-top:3px" />
						<input type="button" class="button purple" value="添加"
							data-toggle="modal" data-target="#myModal"
							sytle="padding-bottom: 0px;padding-top:3px" />
					</ul>
					<!-- .breadcrumb -->

				</div>

				<div class="page-content">
					<script type="text/javascript">
						function update(updateid){
							var did=updateid;
		
							window.location.href="${pageContext.request.contextPath}/departmentAction_updateUI.action?did="+did;
						}
						function view(updateid){
						var did=updateid;
			//alert(uid);
						$.layer({
								    type: 2,
								    border: [0],
								    title: "用户信息",
								    closeBtn: [0, true],
								    iframe: {src : '${pageContext.request.contextPath}/departmentAction_view.action?did='+did},
								    area: ['510px', '450px']
								});
		//window.location.href="${pageContext.request.contextPath}/userAction_view.action?uid="+uid;
		
	}
					</script>
					<!-- /.page-header -->

					<div class="col-xs-12">

						<div id="dialog-confirm" class="hide">
							<p class="bigger-110 bolder center grey">
								<i class="icon-hand-right blue bigger-120"></i> 你确定要删除么？
							</p>
						</div>
						<!-- PAGE CONTENT BEGINS -->

						<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center"><label> <input type="checkbox"
											class="ace" /> <span class="lbl"></span> </label></th>
						
									<th>阶段ID</th>
									<th>阶段名</th>
									<th>描述</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${stages}" var="stage">
									<tr>
										<td class="center"><label> <input type="checkbox"
												class="ace" /> <span class="lbl"></span> </label></td>

										<td>${stage.stageId }</td>
										<td>${stage.name }</td>
										<td>${stage.description }</td>
										<td>
											<div
												class="visible-md visible-lg hidden-sm hidden-xs btn-group">
												<button class="btn btn-xs btn-success"
													onclick="view(${stage.id})">
													<i class="icon-eye-open bigger-120"></i>
												</button>

												<button class="btn btn-xs btn-info" onclick="update(${stage.id})">
													<i class="icon-edit bigger-120"></i>
												</button>

												<button class="btn btn-xs btn-danger">
													<i class="icon-trash bigger-120"></i>
												</button>


											</div>

											<div class="visible-xs visible-sm hidden-md hidden-lg">
												<div class="inline position-relative">
													<button class="btn btn-minier btn-primary dropdown-toggle"
														data-toggle="dropdown">
														<i class="icon-cog icon-only bigger-110"></i>
													</button>

													<ul
														class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
														<li><a href="#" class="tooltip-info"
															data-rel="tooltip" title="View"> <span class="blue">
																	<i class="icon-zoom-in bigger-120"></i> </span> </a></li>

														<li><a href="#" class="tooltip-success"
															data-rel="tooltip" title="Edit"> <span class="green">
																	<i class="icon-edit bigger-120"></i> </span> </a></li>

														<li><a href="#" class="tooltip-error"
															data-rel="tooltip" title="Delete"> <span class="red">
																	<i class="icon-trash bigger-120"></i> </span> </a></li>
													</ul>
												</div>
											</div>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						
						<!-- PAGE CONTENT ENDS -->
					</div>

					<!-- /.col -->

					<!-- /.row -->

				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<jsp:include page="/WEB-INF/jsp/ppm/public/container.jsp"></jsp:include>
		</div>

		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i> </a>
	</div>
	<!-- /.main-container -->





	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

</body>
</html>
