<!DOCTYPE html>
<html lang="en">

<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
          <center><img src="img/MpGov.png" class="img-responsive"  width="60px">
          <h3 style="color: #14B5EF">Jal Nigam Bhopal</h3></center>
        </div>
        <div class="modal-body" style="padding: 40px; margin-bottom: 50px">
          <form method="post">
        
              <h4 class="margin-bottom-1x">Login By ID</h4>
              <div class="form-group input-group">
                <input class="form-control" type="email" placeholder="Email" required=""><span class="input-group-addon "><i class="fa fa-envelope "></i></span>
              </div>
              <div class="form-group input-group">
                <input class="form-control" type="password" placeholder="Password" required=""><span class="input-group-addon "><i class="fa fa-eye-slash"></i></span>
              </div>
              <div style="padding-bottom: 50px">
                <div class="custom-control custom-checkbox">
                  <input class="custom-control-input" type="checkbox" id="remember_me" checked="">
                  <label class="custom-control-label" for="remember_me">Remember me</label>
                </div><a class="navi-link" href="account-password-recovery.html">Forgot password?</a>
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
          <li>You are here: </li>
          <li><a href="index.html">Home</a> </li>
          <li>Pages </li>
          <li class="active">About Us</li>
        </ol>
      </div>
    </div>
  </div>
</section>
<!-- End of Breadcrumps -->

<section class="section_sapce section_primary cover-image" style="background: url(img/bg2.png)center center;">
  <div class="section-title ">
    <h2 style="color: #fff !important"><span></span>About Us</h2>
  </div>
</section>

<section class="section_sapce">

<div class="container">
	<div class="row">
	<div class="col-sm-4">
		<img src="img/bg3.jpg" class="img-responsive"></div>
		<div class="col-sm-8">
		<h2>मुख्य उदेद्श्य</h2>
		<p>1. राज्य के ग्रामीण परिवारों को सुरक्षित पेयजल पर्याप्त मात्रा में सुविधाजनक स्थान पर परिवार स्तर पर नल कनेक्शन द्वारा उचित वितरण व्यवस्था के साथ वर्ष भर उपलब्धता सुनिश्चित करना।</p>
		<p>2. शहरी/नगरीय/ग्रामों की नलजल योजनाओं की परिकल्पना, रूपांकन, प्राक्कलन, निविदा प्रपत्र निर्माण, निविदाएं आमंत्रण, कार्यादेश, क्रियान्वयन, पर्यवेक्षण तथा अनुश्रवण।</p>
		<p>3. भू-गर्भीय तथा तथा सतही जल संसाधनों का संयुक्त उपयोग सुनिश्चित् करना।</p>
		<p>4. राज्य की ग्रामीण नलजल योजनाओं का संचालन एवं संधारण सुनिश्चित करने हेतु ग्राम पेयजल समितियों के गठन उनमें जल के प्रति सामाजिक तथा पर्यावरणीय चेतना विकसित करने में सहयोग प्रदाय करना।</p>
		<p>5. नगरीय क्षेत्रों एवं ग्रामीण क्षेत्रों में उत्सर्जित होने वाले जल मल के निकास एवं उपचार की योजनाओं का आकल्पन एवं क्रियान्यवन करना।</p>
		<p>6. पेयजल प्रदाय योजनाओं एवं जल मल निकास योजनाओं के क्रियान्वयन से संबधित नीतिगत निर्णय हेतु राज्य स्तर पर शीर्ष संस्था के रूप में कार्य करना।</p>

		</div>
	</div>
</div>
</section>



<%@include file="footer.jsp"%>
</body>
</html>