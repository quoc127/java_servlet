<%@include file="/common/taglib.jsp"%>
<%@ page isELIgnored="false"%>
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
		<form action="<c:url value="admin-new"/>" id="formSubmit" method="get">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li><i class="ace-icon fa fa-home home-icon"></i> <a
								href="#">Trang chủ</a></li>
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
											<ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page" /> <input
												type="hidden" value="" id="maxPageItem" name="maxPageItem" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script type="text/javascript">
	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	var limit = 2;
	$(function () {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: totalPages,
			visiblePages: 10,
			startPage: currentPage,
			onClick: function (event, page) {
				if (currentPage != page) {
					$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
			}
		});
	});
	</script>
</body>
</html>