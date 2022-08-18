<%@include file="/common/taglib.jsp"%>
<%@ page isELIgnored="false" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">Mô tả ngắn</th>
												
											</tr>
										</thead>
										<tbody>
											<!-- <tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Mark1</td>
											</tr> -->
										<c:forEach var="item" items="${model.listResult}">
														<tr>
														
															<td>${item.title}</td>
															<td>${item.shortDescription}</td>
															
														</tr>
											</c:forEach>
										</tbody>
									</table>
									<!--  <ul class="pagination" id="pagination"></ul> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	<!-- <script type="text/javascript">
	 $(function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: 35,
	            visiblePages: 10,
	            onPageClick: function (event, page) {
	                console.info(page + ' (from options)');
	            }
	        }).on('page', function (event, page) {
	            console.info(page + ' (from event listening)');
	        });
	    });
	</script> -->
</body>
</html>