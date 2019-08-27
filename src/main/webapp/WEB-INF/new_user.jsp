
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="head.jsp"%>
</head>

<script type="text/javascript">
	function getCircleList(zoneId) {
		//alert("zone id--"+zoneId);
		/* $('#circleId').find('option').remove().end().append(
				'<option value="0">Select Office</option>').val(''); */
		//('#circleId').append('<option value="foo">Select</option>');
		$.ajax({
			type : "POST",
			url : "get_circle_list",
			data : {
				"zoneId" : zoneId
			}

		}).done(
				function(circleList) {
					//document.getElementById("officeId").disabled = false;
					var opt = '';
					opt += '<option value="">Select Circle</option>';
					for (i in circleList) {
						opt += '<option value="'+circleList[i].id+'">'
								+ circleList[i].nameEnglish + '</option>';
					}
					$('#circleId').html(opt);

				});

	}

	function getDivisionList(circleId) {
	

		$.ajax({
			type : "POST",
			url : "get_division_list",
			data : {
				"circleId" : circleId
			}

		}).done(
				function(divisionList) {

					//document.getElementById("officeId").disabled = false;
					var opt = '';
					opt += '<option value="">Select Division</option>';
					for (i in divisionList) {

						opt += '<option value="'+divisionList[i].id+'">'
								+ divisionList[i].nameEnglish + '</option>';
					}
					$('#divisionId').html(opt);

				});

	}
	
	function checkEmailExist(val) {
		//alert('sdsds='+val);

		$.ajax({		
			url : 'existEmail?userId=' + val,

			success : function(response) {
				
				if (response == true) {
					document.getElementById("isEmailExist").style.color = "#ff0000";
					$("#isEmailExist").text("Email Already Exist !");

				} else {
					$("#isEmailExist").text("");
				}
			}
		});
	};

	function checkContactExist(val) {
		
		$.ajax({		
			url : 'existContact?mobileNo=' + val,

			success : function(response) {
				
				if (response == true) {
					document.getElementById("isContactExist").style.color = "#ff0000";
					$("#isContactExist").text("Contact Already Exist !");

				} else {
					$("#isContactExist").text("");
				}
			}
		});
	};

</script>

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
								required=""> <span class="input-group-addon "><i
								class="fa fa-envelope "></i></span>
						</div>
						<div class="form-group input-group">
							<input class="form-control" type="password"
								placeholder="Password" required=""> <span
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
					<h1>User Register</h1>
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
				<div class="col-sm-12 "
					style="panel-info box-shadow: 2px 4px 29px -4px rgba(0, 0, 0, 0.35) !important; padding-bottom: 20px;">
					<div class="panel panel-info"
						style="box-shadow: 2px 4px 29px -4px rgba(0, 0, 0, 0.35) !important;">
						<div class="panel-heading">
							<h2 class="text-center" style="color: #121111">New User
								Registration</h2>
						</div>
						<div class="panel-body">
							<div class="form">
								<form:form action="save_registration"
									modelAttribute="userRegistration" enctype="multipart/form-data">
									<form:hidden path="id"/>
									<c:if test="${not empty message}">
										<div class="alert alert-success">
											<a href="#" class="close" data-dismiss="alert">&times;</a><strong>
											${message}</strong>
										</div>
									</c:if>
									<div class="row">
										<div class="col-sm-6">
											<div class="col-sm-12">
												<div class="form-group">
													<label for="">User Name <span class="red">*</span></label>
													<form:input type="text" class="form-control"
														path="userName" placeholder="Enter user name"
														name="user_name" required="required" />
												</div>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Password <span class="red">*</span></label>
													<form:input type="text" class="form-control"
														path="password" placeholder="Enter Password"
														name="password" required="required" />
												</div>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Role <span class="red">*</span></label>
													<form:select class="form-control" path="role.id"
														required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${roleList}" var="rl">
															<form:option value="${rl.id}">${rl.role}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Circle </label>
													<form:select class="form-control" path="circleId.id"
														id="circleId" 
														onchange="getDivisionList(this.value);">
														<form:option value="">Select</form:option>
														<c:forEach items="${circleList}" var="cl" >
															 <form:option value="${cl.id}">${cl.nameEnglish}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>

											<%-- <div class="col-sm-12">
												<div class="form-group">
													<label for="">Subdivision <span class="red">*</span></label>
													<form:select class="form-control" path="subDivisionId"
														id="subDivisionId" required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${subDivisionList}" var="sdl" >
								 <form:option value="${sdl.id}">${sdl.nameEnglish}</form:option>
							</c:forEach>
													</form:select>
												</div>
											</div> --%>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Parent <span class="red">*</span></label>
													<form:select class="form-control" path="parentId.id"
														required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${parentList}" var="pl">
															<form:option value="${pl.id}">${pl.userName}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Designation <span class="red">*</span></label>
													<form:select class="form-control" path="designationId.id"
														required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${designationList}" var="dl">
															<form:option value="${dl.id}">${dl.name}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>
											<div class="col-sm-12">
												<div class="form-group">
													<label for="">System Admin <span class="red">*</span></label>
													<form:select class="form-control" path="systemsAdminTypeId.id"
														required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${sysAdminTypeList}" var="satl">
															<form:option value="${satl.id}">${satl.type}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>

											<!-- <div class="col-sm-12">
                      <div class="form-group">
                        <label for="">Updated Date<span class="red">*</span></label>
                        <input type="date" class="form-control"  placeholder="Enter mobile number" name="updated_date"  required="required" />
                      </div>
                    </div>
         
                   <div class="col-sm-12">
                      <div class="form-group">
                        <label for="">Updated By<span class="red">*</span></label>
                        <input type="text" class="form-control"  placeholder="Enter mobile number" name="updated_by"  required="required" />
                      </div>
                   </div> -->

										</div>
										<div class="col-sm-6">
											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Email ID <span class="red">*</span></label>
													<form:input type="text" class="form-control" path="userId"
														placeholder="Enter email address" name="emailid"
														required="required" onblur="checkEmailExist(this.value)"/>
												</div>
												<span id="errorEmail" style="color: #ff0000; font-size: 12px; "></span>
                            					<span id="isEmailExist"></span>
											</div>


											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Level <span class="red">*</span></label>
													<form:select class="form-control" path="lavelId.id"
														required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${levelList}" var="ll">
															<form:option value="${ll.id}">${ll.userType}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Zone </label>
													<form:select class="form-control" path="zoneId.id"
														 onchange="getCircleList(this.value);">
														<form:option value="">Select</form:option>
														<c:forEach items="${zoneList}" var="zl">
															<form:option value="${zl.id}">${zl.nameEnglish}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Division </label>
													<form:select class="form-control" path="divisionId.id"
														id="divisionId" >
														<form:option value="">Select</form:option>
														<c:forEach items="${divisionList}" var="dl" >
															 <form:option value="${dl.id}">${dl.nameEnglish}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>
											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Mobile Number <span class="red">*</span></label>
													<form:input type="text" class="form-control" path="mobile"
														placeholder="Enter mobile number" name="mobile"
														required="required" maxlength="10" onblur="checkContactExist(this.value)"/>
												</div>
												<span id="errorContact" style="color: #ff0000; font-size: 12px; "></span>
                            					<span id="isContactExist"></span>
											</div>

											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Supervisor <span class="red">*</span></label>
													<form:select class="form-control" path="supervisorId.id"
														required="required">
														<form:option value="">Select</form:option>
														<c:forEach items="${parentList}" var="sl">
															<form:option value="${sl.id}">${sl.userName}</form:option>
														</c:forEach>
													</form:select>
												</div>
											</div>
											
											<div class="col-sm-12">
												<div class="form-group">
													<label for="">Profile Image <span class="red">*</span></label>
													 <form:hidden class="form-control"   path="path"  />
													 <form:input type="file" class="form-control"   path="fileAttachment" />
												</div>
											</div>

											<!-- <div class="col-sm-12">
                      <div class="form-group">
                        <label for="">Create Date<span class="red">*</span></label>
                        <input type="date" class="form-control"  placeholder="Enter mobile number" name="created_date"  required="true" />
                      </div>
                    </div>
                    
                    <div class="col-sm-12">
                      <div class="form-group">
                        <label for="">Created By<span class="red">*</span></label>
                        <input type="text" class="form-control"  placeholder="Enter mobile number" name="created_by"  required="true"/>
                      </div>
                    </div> -->

											

										</div>
									</div>
									<!-- <div class="row">
                	 <div class="col-sm-12">
                    <input type="checkbox" name="is_true" value="true" />
                    &nbsp; I hereby certify that the above given information is true and accurate<span class="red">*</span></div>
                	
                </div> -->
									<div class="panel-footer text-center">
										<input type="submit" class="btn btn-light btn-primary"
											name="Submit" />
									</div>
								</form:form>
							</div>
						</div>
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
				Copyright © 2018 - 2019 <a href="https://www.cinfysystems.com/">Cinfy
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