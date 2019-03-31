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

		<title>数据后台管理 - 订单</title>
		<meta name="description" content="订单">
		<meta name="keywords" content="订单">

		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

		<!-- 引入css -->
		<jsp:include page="common/css.jsp"></jsp:include>
		<!-- 引入css /-->
	</head>

<body class="hold-transition skin-blue sidebar-mini" style="overflow:scroll;overflow-x:hidden">

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
				订单管理 <small>全部订单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/order/list">订单管理</a></li>
				<li class="active">订单编辑</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content"> <!--订单信息-->
			<form action="${pageContext.request.contextPath}/order/save" method="post">
				
				<div class="panel panel-default">
					<div class="panel-heading">订单信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">订单编号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder="订单编号" name="orderNum"/>
						</div>

						<div class="col-md-2 title">下单时间</div>
						<div class="col-md-4 data">
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									id="datepicker-a3" name="orderTime" />
							</div>
						</div>
						<div class="col-md-2 title">出行人数</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder="出行人数"
								 name="peopleCount"/>
						</div>

						<div class="col-md-2 title">支付方式</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
								name="payType">
								<option value="0" selected="selected">支付宝</option>
								<option value="1">微信</option>
								<option value="2">其他</option>
							</select>
						</div>
						
						<div class="col-md-2 title">订单状态</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
								name="orderStatus">
								<option value="0" selected="selected">未支付</option>
								<option value="1">已支付</option>
							</select>
						</div>
						
						<div class="col-md-2 title">选择产品</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
								name="product.id">
								
								<c:forEach items="${ plist }" var="p">
									<option value="${ p.id }" >${ p.productName }</option>
								</c:forEach>
								
							</select>
						</div>

						<div class="col-md-2 title">选择会员</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
									name="member.id">
								<option value="1" selected="selected">张三丰</option>
								<option value="2">杨过</option>
							</select>
						</div>
						<div class="col-md-2 data"></div>
						<div class="col-md-4 data"></div>

						<div class="col-md-2 title rowHeight2x">订单描述</div>
						<div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3" placeholder="订单描述" name="orderDesc">
						</textarea>
						</div>

					</div>
				</div>
				<!--订单信息/-->
				
				
				<!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
			</form>
			<!--工具栏/--> </section>
			<!-- 正文区域 /-->


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