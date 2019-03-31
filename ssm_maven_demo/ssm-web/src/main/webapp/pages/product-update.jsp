<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- 页面meta -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>数据后台管理 - 产品</title>
		<meta name="description" content="产品">
		<meta name="keywords" content="产品">

		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

		<!-- 引入css -->
		<jsp:include page="common/css.jsp"></jsp:include>
		<!-- 引入css /-->
	</head>

<body class="hold-transition skin-purple sidebar-mini" style="overflow:scroll;overflow-x:hidden">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="common/header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="common/aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				产品管理 <small>产品表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/product/list">产品管理</a></li>
				<li class="active">产品修改</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form action="${pageContext.request.contextPath}/product/update"
				method="post">
				<input type="hidden" name="id" value="${product.id}">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">产品信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">产品编号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="productNum"
								placeholder="产品编号" value="${product.productNum}"
								readonly="readonly"/>
						</div>
						<div class="col-md-2 title">产品名称</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="productName"
								placeholder="产品名称" value="${product.productName}"/>
						</div>
						<div class="col-md-2 title">出发时间</div>
						<div class="col-md-4 data">
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									id="datepicker-a3" name="departureTime"
									value='<fmt:formatDate value="${product.departureTime}"
																	pattern="yyyy-MM-dd HH:mm:ss" />'/>
							</div>
						</div>


						<div class="col-md-2 title">出发城市</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="cityName"
								placeholder="出发城市" value="${product.cityName}"/>
						</div>

						<div class="col-md-2 title">产品价格</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder="产品价格"
								name="productPrice" value="${product.productPrice}"/>
						</div>

						<div class="col-md-2 title">产品状态</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
								name="productStatus">

								<option value="0"
										<c:if test="${ product.productStatus == 0 }">selected='selected'</c:if>>
									关闭
								</option>
								<option value="1"
										<c:if test="${ product.productStatus == 1 }">selected='selected'</c:if>>
									开启
								</option>
							</select>
						</div>

						<div class="col-md-2 title rowHeight2x">其他信息</div>
						<div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3" placeholder="其他信息"
								name="productDesc">${product.productDesc}</textarea>
						</div>

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">修改</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<jsp:include page="common/footer.jsp"></jsp:include>
		<!-- 底部导航 /-->

	</div>
</body>
	<!-- 引入js -->
	<jsp:include page="common/js.jsp"></jsp:include>
	<!-- 引入js /-->
</html>