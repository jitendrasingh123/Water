<!-- Main Menu -->
<%@ page import="com.cinfy.water.model.User"%>
<%
	User loginUserMainMenu = (User) request.getSession().getAttribute("loginUser");
	//request.setAttribute ("loginUser", loginUser);
	//if (loginUser == null) {
%>
	<div class="main_menu">
  <div class="row">
     <div class="col-sm-12">
       <div  class=" pull-right">
        <nav id="desktop-menu">
          <div id='cssmenu'>
          <ul class="sf-menu" id="navigation">
								<li class="current"><a href="index">Home</a></li>
								<li class="current"><a href="about">About us</a></li>
								<li class="current"><a href="case_registration">Case	Registration</a></li>
								<li class="current"><a href="case_search">Case Search</a></li>
								<% if(loginUserMainMenu.getRole().getId()==1){%>
								<li class="current"><a href="user_list">User List</a></li>
								<%} %>


							</ul>
          
          </div>
        </nav>
      </div>
      </div>
    </div>
 
</div>
	<!-- End of Main Menu -->
	
	
	