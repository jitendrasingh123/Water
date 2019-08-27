<%@ page import="com.cinfy.water.model.User"%>
<%
	User loginUser = (User) request.getSession().getAttribute("loginUser");
	//request.setAttribute ("loginUser", loginUser);
	//if (loginUser == null) {
%>
<!-- Top Bar-->
	<div class="top">
		<div class="row">
			
				<div class="col-sm-4">
					<div class="logo" style="float: left">
						<a href="#"><img alt="" src="img/MpGov.png"></a>
					</div>
					<div style="font-size: 21px; color: #1CABF0; padding-top: 20px;">&nbsp;&nbsp;MP
						PHE Department</div>
				</div>
				<div class="col-sm-8 pull-right">
					<ul class="nav nav-pills">

                     <li style="padding-top: 3px;">
							<div class="btn-group country_select">
							<ul class="dropdown-menu">

									<li><div style="padding: 10px">
											<img src="<%=loginUser.getPath()%>" width="50px"
												class="img-circle" alt="Daniel Adams"> <span><%=loginUser.getUserName()%></span>
										</div></li>
									<li><a href="profile">View Profile</a></li>
									<li><a href="case_search">Update case</a></li>
									<li class="sub-menu-separator"></li>
									<li><a href="logout"> <i class="icon-unlock"></i>Logout
									</a></li>
								</ul>
							
							
								<button aria-expanded="false" aria-haspopup="true"
									class="btn btn-link dropdown-toggle" data-toggle="dropdown"
									type="button"><%=loginUser.getUserName()%>
									<b class="caret"></b>
								</button>
								
							</div>
						</li>
						
						<!-- <li> <a href="#" class="btn btn-sm btn-new" style="color: #fff;" data-toggle="modal" data-target="#myModal"><i class="fa fa-user"></i> Account Login</a> </li> -->
						<% if(loginUser.getRole().getId()==1){%>
						<li><a href="signup" class="btn btn-sm btn-new"
							style="color: #fff;"><i class="fa fa-user"></i>Register</a></li>
                       <%} %>
						
					</ul>
				</div>
			
		</div>
	</div>
	<!-- End of Top Bar-->