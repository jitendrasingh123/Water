<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.cinfy.water.model.User"%>
<!DOCTYPE html>
<html lang="en">

<head>

<%@include file="head.jsp"%>


</head>

<body>


	<%@include file="topminibar.jsp"%>
	<%@include file="topbar.jsp"%>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<center>
						<img src="img/MpGov.png" class="img-responsive" width="60px">
						<h3 style="color: #14B5EF">Jal Nigam Bhopal</h3>
					</center>
				</div>
				<div class="modal-body" style="padding: 40px; margin-bottom: 50px">
					<form method="post">

						<h4 class="margin-bottom-1x">Login By ID</h4>
						<div class="form-group input-group">
							<input class="form-control" type="email" placeholder="Email"
								required=""><span class="input-group-addon "><i
								class="fa fa-envelope "></i></span>
						</div>
						<div class="form-group input-group">
							<input class="form-control" type="password"
								placeholder="Password" required=""><span
								class="input-group-addon "><i class="fa fa-eye-slash"></i></span>
						</div>
						<div style="padding-bottom: 50px">
							<div class="custom-control custom-checkbox">
								<input class="custom-control-input" type="checkbox"
									id="remember_me" checked=""> <label
									class="custom-control-label" for="remember_me">Remember
									me</label>
							</div>
							<a class="navi-link" href="account-password-recovery.html">Forgot
								password?</a>
						</div>
						<div class="text-center text-sm-right" style="margin-bottom: 20px">
							<button class="btn btn-primary btn-sm" type="submit">Login</button>
						</div>
					</form>
				</div>

			</div>

		</div>
	</div>


	<%@include file="mainmenu.jsp"%>


	<!-- Breadcrumps -->
	<section class="breadcrumbs">
		<div class="row">
			<div class="container">
				<div class="col-sm-6">
					<h1>Register</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb">
						<li>You are here:</li>
						<li><a href="index.html">Home</a></li>
						<li>Pages</li>
						<li class="active">Register</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- End of Breadcrumps -->



	<!-- Register -->

	<div class="slidercontainer bg_primary" style="padding-top: 20px;">
		<div class="container" style="margin-top: 30px">
			<div class="row">
				<div class="col-sm-12 panel panel-info"
					style="panel-info box-shadow: 2px 4px 29px -4px rgba(0, 0, 0, 0.35) !important; padding-bottom: 20px;">

					<div class="checkout-steps">

						<a href="case_update" class="active"><span class="angle"></span><span
							class="step-indicator"><img src="img/ic.png">3. Case
								Update</a> <a href="case_date"><span class="angle"></span>2.
							Upcoming Hearing Date</a> <a href="case_registration"><span
							class="angle"></span>1. Case Details</a>

					</div>

					<div class="section-title margin-b50">
						<h2>Update Case Details</h2>
					</div>


					<div class="form">
						<form:form action="save_case_registration"
							modelAttribute="caseRegistration">

							<form:hidden path="id" />
							<form:hidden path="responsHearingDateId.id" />

							<div class="row">

								<div class="col-sm-6">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Court Order date <span class="red">*</span></label>
											<form:input type="date" class="form-control"
												path="orderDate " required="true" />
										</div>
									</div>

									<div class="col-sm-12">
										<div class="form-group">
											<label>Order Details<span class="red">*</span>
											</label>
											<form:textarea path="orderDetails" class="form-control"
												rows="4" cols="" placeholder="Order Details" required="true"
												maxlength="500"></form:textarea>
										</div>
									</div>

									<div class="col-sm-12">
										<div class="form-group">
											<label>Conclusion Review of Govt. Advocate<span
												class="red">*</span>
											</label>
											<form:textarea path="advocateOpinion" class="form-control"
												rows="4" cols="" placeholder="Detail" required="true"
												maxlength="500"></form:textarea>
										</div>
									</div>

								</div>


								<div class="col-sm-6">



									<div class="col-sm-12">
										<div class="form-group">
											<label>Action by Department<span class="red">*</span>
											</label>
											<form:textarea path="actionTaken" class="form-control"
												rows="4" cols="" placeholder="Detail" required="true"
												maxlength="500"></form:textarea>
										</div>
									</div>


									<!--  <div class="col-sm-12">
                        <div class="form-group">
                          <label for="">Date of Entry <span class="red">*</span></label>
                          <input type="date" class="form-control"  path="court_order_date "  required="true"/>
                        </div>
                      </div> -->

								</div>


							</div>
							<!--   <div class="col-sm-12">
                    <input type="checkbox" name="is_true" value="true" />
                    &nbsp; I hereby certify that the above given information is true and accurate<span class="red">*</span></div> -->
							<div class="col-md-12 mrg-20" align="center"
								style="margin-top: 50px">
								<div class="effect-1">
									<input type="submit" class="btn btn-light btn-primary"
										name="Submit" />
								</div>
							</div>
						</form:form>
					</div>




				</div>


			</div>



		</div>
	</div>
	<!-- End of Register -->

	<!--  Footer -->
	<footer class="footer">

		<div class="row bg_white copyright">
			<hr>
			<p class="copyright text-center">
				Copyright Â© 2018 - 2019 <a href="https://www.cinfysystems.com/">Cinfy
					Systems.</a> All Rights Reserved
			</p>
		</div>
	</footer>
	<!--  End of Footer -->




	<!--  Back to Top -->
	<a href="#top" id="back-to-top"><i class="fa fa-angle-up"></i></a>

	<!--  Scripts -->
	<script src="js/jquery.min.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.min.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/jquery.circliful.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/retina.min.js"></script>
	<script src="js/jquery.parallax-1.1.3.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/fontawesome.min.js"></script>

</body>
</html>