
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="head.jsp"%>
<script type="text/javascript">
	function getCircleList(zoneId) {		
		$.ajax({
			type : "POST",
			url : "get_circle_list",
			data : {
				"zoneId" : zoneId
			}

		}).done(
				function(circleList) {					
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
					var opt = '';
					opt += '<option value="">Select Division</option>';
					for (i in divisionList) {

						opt += '<option value="'+divisionList[i].id+'">'
								+ divisionList[i].nameEnglish + '</option>';
					}
					$('#divisionId').html(opt);
				});
	}
</script>

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
					<h1>User Search</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb">
						<li>You are here:</li>
						<li><a href="index.html">Home</a></li>
						<li>Pages</li>
						<li class="active">User Search</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<form action="user_search_filter" method="post">
					<div class="panel with-nav-tabs panel-primary"
						style="box-shadow: 2px 4px 29px -4px rgba(0, 0, 0, 0.35) !important;">
						<div class="panel-heading">
							<div>
								<h3 class="text-center" style="color: #fff">User Search</h3>
							</div>
						</div>

						<div class="panel-body table-responsive" style="margin-top: 20px">

							<table class="table table-bordered" style="margin-top: 5px">
								<thead>
									<tr>
										<th>Zone</th>
										<th>Circle</th>
										<th>Devision</th>
									</tr>
								</thead>
								<tbody class="table01">
									<tr>
										<td>
										 <select class="form-control" name="zoneId"
											onchange="getCircleList(this.value);">
												<option value="">Select</option>
												<c:forEach items="${zoneList}" var="zl">
													<option value="${zl.id}">${zl.nameEnglish}</option>
												</c:forEach>
										 </select>
										</td>
										<td>
										 <select class="form-control" name="circleId"
											id="circleId" onchange="getDivisionList(this.value);">												
										 </select>
										</td>
										<td>
										  <select class="form-control" name="divisionId"
											id="divisionId">												
										  </select>
										</td>
									</tr>
								
								</tbody>
							</table>

							<table class="table table-bordered" style="margin-top: 5px">
								<thead>

								</thead>
								<tbody class="table01">


								</tbody>
							</table>
							<div class="row">
								<div class="col-md-6 mrg-20" style="margin-top: 10px"
									align="right">
									<div class="effect-1">
										<input type="submit" class="btn btn-light btn-primary"
											name="Submit" />
									</div>
								</div>
								<div class="col-md-6 mrg-20" align="left"
									style="margin-top: 10px;">
									<div class="effect-1">
										<input type="reset" class="btn btn-light btn-primary"
											name="Reset" />
									</div>
								</div>
							</div>
						</div>

					</div>
				</form>


			</div>
		</div>

	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">

				<div class="panel panel-info"
					style="box-shadow: 2px 4px 29px -4px rgba(0, 0, 0, 0.35) !important;">
					<div class="panel-heading">
						<div>
							<h3 class="text-center" style="color: #121111">User Details</h3>
						</div>

					</div>

					<div class="panel-body  table-responsive" style="margin-top: 20px">
						<table id="example" class="display" style="width: 100%">
							<thead>
								<tr>
									<th>Sr/no</th>
				                    <th>Name</th>
				                    <th>Designation </th>
				                    <th>Email ID</th>
				                    <th>Mobile No</th>
				                    <th>Zone</th>
				                    <th>Circle</th>
				                    <th>Division</th>
				                    <th>Action</th>
								</tr>
							</thead>
							<tbody>
				                 <c:set var="count" value="0" scope="page" />
								 <c:forEach items="${userList}" var="ul">
				                  <tr >
				                     <td><c:set var="count" value="${count + 1}" scope="page" /> <c:out value="${count}" /></td>
				                     <td>${ul.userName}</td>
				                     <th>${ul.designationId.name}</th>
				                     <td>${ul.userId}</td>
				                     <td>${ul.mobile}</td>
				                     <td>${ul.zoneId.nameEnglish}</td>
				                     <th>${ul.circleId.nameEnglish}</th>
				                     <td>${ul.divisionId.nameEnglish}</td>
				                     <td><a	href="<c:url value="/signup?id=${ul.id}"/>"><img src="img/pencil_edit.png" width="20px" class="img-responsive center-block"></a></td>
				                  </tr>
				                 </c:forEach>
							</tbody>							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="footer.jsp"%>
</body>
</html>