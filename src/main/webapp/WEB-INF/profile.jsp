<!DOCTYPE html>
<html lang="en">

<head>

	<%@include file="head.jsp"%>
	
</head>

<body>

  	<%@include file="topminibar.jsp"%>
	<%@include file="topbar.jsp"%>
	<%@include file="mainmenu.jsp"%>

<!-- Breadcrumps -->
<section class="breadcrumbs">
  <div class="row">
    <div class="container">
      <div class="col-sm-6">
        <h1>User Profile</h1>
      </div>
      <div class="col-sm-6">
        <ol class="breadcrumb">
          <li>You are here: </li>
          <li><a href="index.html">Home</a> </li>
          <li>Pages </li>
          <li class="active">Profile</li>
        </ol>
      </div>
    </div>
  </div>
</section>
<!-- End of Breadcrumps -->

<div class="slidercontainer bg_primary" style="padding-top: 20px; ">
  <div class="container" style="margin-top: 30px">
    <div class="row" >
      <div class="col-sm-12 " style="panel-info box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important; padding-bottom: 20px;">
        <div class="panel panel-info" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
          <div class="panel-heading">
            <h2 class="text-center" style="color:#121111">Personal Details</h2>
          </div>
          <div class="panel-body">
            <div class="row">
            	 <div class="col-sm-3">
            	 	<div class="boxes-border-top boxes ">
            	 	
            	 	<div class="" style="padding: 15px;">
            	 		<img src="${LoginUser.path }" class="img-responsive center-block" width="200px">
            	 		
            	 		 <h2 style="color: #272626; padding-top: 15px; text-align: center">${LoginUser.userName }</h2>
            	 		 <h4 style="color: #494848;  text-align: center" >${LoginUser.designationId.name }</h4>
            	 		 <hr>
            	 		<!--  <p style="color: #494848;  text-align: center">Ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p> -->
            	 		 
            	 	</div>
					
           	 	</div>
            	  </div>
            	   <div class="col-sm-9">
            	   <div class=" boxes-border-top boxes ">
            	   <div class="row">
            	   <div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Name:</b></label>
              <div class="col-xs-8  controls">${LoginUser.userName }</div>
              <!-- col-sm-10 --> 
            </div>
          </div>
           	  
           	  <!--  <div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Last Name:</b></label>
              <div class="col-xs-8  controls">Sharma</div>
              col-sm-10 
            </div>
          </div> -->
           	   <div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>User Name:</b></label>
              <div class="col-xs-8  controls">${LoginUser.userId }</div>
              <!-- col-sm-10 --> 
            </div>
					   </div>
					   
           	   	 <div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Email ID:</b></label>
              <div class="col-xs-8  controls">${LoginUser.userId }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>
           	   
           	   	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Mobile No:</b></label>
              <div class="col-xs-8  controls">${LoginUser.mobile }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
          	   	
          	   	
           	   		<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Designation:</b></label>
              <div class="col-xs-8  controls">${LoginUser.designationId.name }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   	
           	   	
           	   	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Level:</b></label>
              <div class="col-xs-8  controls">${LoginUser.lavelId.userType }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   
           	    	
           	   	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Role:</b></label>
              <div class="col-xs-8  controls">${LoginUser.role.role }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   	
           	   		<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Zone:</b></label>
              <div class="col-xs-8  controls">${LoginUser.zoneId.nameEnglish }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   	
           	   	
           	   		<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Circle:</b></label>
              <div class="col-xs-8  controls">${LoginUser.circleId.nameEnglish }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   	
           	   	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Division:</b></label>
              <div class="col-xs-8  controls">${LoginUser.divisionId.nameEnglish }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   	
           	  <!--  	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Subdivision:</b></label>
              <div class="col-xs-8  controls">somthing</div>
              col-sm-10 
            </div>
		 </div>	 -->
           	   	
           	   	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Parent:</b></label>
              <div class="col-xs-8  controls">${LoginUser.parentId.userName }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>	
           	   	
           	   	<div class="col-sm-6">
            <div class="row mgbt-xs-0">
              <label class="col-xs-4 control-label"><b>Supervisor:</b></label>
              <div class="col-xs-8  controls">${LoginUser.supervisorId.userName }</div>
              <!-- col-sm-10 --> 
            </div>
		 </div>
           	   	
		 	 </div>		
		 </div>		
            	   	
            	   </div>
            	   
            	</div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>




<!--  Footer -->
<%@include file="footer.jsp"%>
 
</body>
</html>