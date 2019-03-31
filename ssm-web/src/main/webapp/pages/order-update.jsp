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
				<form action="${pageContext.request.contextPath}/order/update"
					method="post">
					<input type="hidden" name="id" value="${orders.id }"/>
					<input type="hidden" name="product.id" value="${orders.product.id}"/>
					<div class="panel panel-default">
						<div class="panel-heading">订单信息</div>
						<div class="row data-type">

							<div class="col-md-2 title">订单编号</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" placeholder="订单编号"
									value="${orders.orderNum }" name="orderNum" readonly="readonly"/>
							</div>

							<div class="col-md-2 title">下单时间</div>
							<div class="col-md-4 data">
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right"
										id="datepicker-a3" name="orderTime"
										   value='<fmt:formatDate value="${orders.orderTime}"
															pattern="yyyy-MM-dd HH:mm:ss" />' readonly="readonly"/>
								</div>
							</div>

                            <div class="col-md-2 title">出行人数</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" placeholder="出行人数"
                                       value="${orders.peopleCount}" name="peopleCount"/>
                            </div>

                            <div class="col-md-2 title">支付方式</div>
                            <div class="col-md-4 data">
                                <select class="form-control select2" style="width: 100%"
                                        name="payType">
                                    <option value="0" <c:if test="${ orders.payType == 0 }">selected='selected'</c:if>>
                                        支付宝
                                    </option>
                                    <option value="1" <c:if test="${ orders.payType == 1 }">selected='selected'</c:if>>
                                        微信
                                    </option>
                                    <option value="2" <c:if test="${ orders.payType == 2 }">selected='selected'</c:if>>
                                        其他
                                    </option>
                                </select>
                            </div>

                            <div class="col-md-2 title">订单状态</div>
                            <div class="col-md-4 data">
                                <select class="form-control select2" style="width: 100%"
                                        name="orderStatus">
                                    <option value="0" <c:if test="${ orders.orderStatus == 0 }">selected='selected'</c:if>>
                                        未支付
                                    </option>
                                    <option value="1" <c:if test="${ orders.orderStatus == 1 }">selected='selected'</c:if>>
                                        已支付
                                    </option>
                                </select>
                            </div>

							<div class="col-md-2 title">商品名称</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" placeholder="商品名称"
									value="${orders.product.productName }" name="product.productName" readonly="readonly"/>
							</div>

							<div class="col-md-2 title">出发城市</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" placeholder="出发城市"
									value="${orders.product.cityName }" name="product.cityName" readonly="readonly"/>
							</div>

							<div class="col-md-2 title">出发时间</div>
							<div class="col-md-4 data">
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right"
										id="datepicker-a6"
										   value='<fmt:formatDate value="${orders.product.departureTime}"
															pattern="yyyy-MM-dd HH:mm:ss" />'
										   name="product.departureTime" readonly="readonly"/>
								</div>
							</div>

                            <div class="col-md-2 title">会员名称</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" placeholder="会员名称"
                                       value="${orders.member.memberName }" name="member.memberName" readonly="readonly"/>
                            </div>

                            <div class="col-md-2 title">会员联系电话</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" placeholder="会员联系电话"
                                       value="${orders.member.phoneNum }" name="member.phoneNum" readonly="readonly"/>
                            </div>

							<div class="col-md-2 title rowHeight2x">其他信息</div>
							<div class="col-md-10 data rowHeight2x">
								<textarea class="form-control" rows="3" placeholder="其他信息" name="orderDesc">${orders.orderDesc }
								</textarea>
							</div>

						</div>
					</div>
					<!--订单信息/-->
					<!--工具栏-->
					<div class="box-tools text-center">
						<button type="submit" class="btn bg-maroon">修改</button>
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