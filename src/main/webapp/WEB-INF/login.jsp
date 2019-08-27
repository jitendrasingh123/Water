<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.Console"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html >

<head>
	
	
	<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MP PHE Department</title>
	<link rel="shortcut icon" href="images/icons/favicon.png" />

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,400,500" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,700,800" rel="stylesheet">

	<!-- Bootstrap & Styles -->
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap-theme.css" rel="stylesheet">
	<link href="css/block_grid_bootstrap.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/owl.carousel.css" rel="stylesheet">
	<link href="css/owl.theme.css" rel="stylesheet">
	<link href="css/animate.min.css" rel="stylesheet" />
	<link href="css/jquery.circliful.css" rel="stylesheet" />
	<link href="css/slicknav.css" rel="stylesheet" />
	<link href="css/video-popup.css" rel="stylesheet" />
	<link href="css/responsive.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet">
	
	
</head>

<body>

   <!--  Loading
    <div class="loading animated-middle">
        <div class="loader">Loading...</div>
    </div>-->
    

    <!-- Top MiniBar-->
    <section class="topminibar" >
     <div class="row">
     	<div class="container">
            <div class="col-sm-12 col-md-6 col-xs-12">
               <ul class="list-inline">
                  <li><a href="#"><i class="fa fa-commenting"></i><span> Contact Us</span></a></li>
                  <li><a href="contact.html"><i class="fa fa-envelope"></i><span> www.jalnigam.com</span></a></li>
               </ul>
            </div>
            <div class="col-sm-12 col-md-6 col-xs-12">
               <div class="text-right loginbuttons">
                  <a href="cart.html hidden-md-down" class="btn btn-sm btn-default"><i class="fa fa-download"></i> &nbsp; Get mobile app </a>
               
               </div>
            </div>
         </div>
     </div>
    </section>
    <!-- End of Top MiniBar-->
   <!-- Top Bar-->
	<div class="top">
		<div class="row">
			<div class="container">
				<div class="col-sm-3">
					<div class="logo" style="float: left">
						<a href="index.html"><img alt="" src="img/MpGov.png"></a>
					</div><div style=" font-size: 21px; color: #1CABF0; padding-top: 20px;">&nbsp;&nbsp;MP PHE Department</div>
				</div>
				<div class="col-sm-9">
					<ul class="nav nav-pills pull-right">
						
						<li> <a href="#" class="btn btn-sm btn-new" style="color: #fff;" data-toggle="modal" data-target="#myModal"><i class="fa fa-user"></i> Account Login</a> </li>
							<!-- <li> <a href="signup" class="btn btn-sm btn-new" style="color: #fff;"><i class="fa fa-user"></i>Register</a> </li> -->
						
						
					
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End of Top Bar-->
	
   
   <!--loginmodal-->
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
         <form:form method="post" action="loginProcess" modelAttribute="login">
        
              <h4 class="margin-bottom-1x">Login By ID</h4>
              <div class="form-group input-group">
                <form:input class="form-control" type="email" placeholder="Email" path="userId" required="true"/><span class="input-group-addon "><i class="fa fa-envelope "></i></span>
              </div>
              <div class="form-group input-group">
                <form:password class="form-control" placeholder="Password" path="password" required="true"/><span class="input-group-addon "><i class="fa fa-eye-slash"></i></span>
              </div>
              <div style="padding-bottom: 50px">
                <div class="custom-control custom-checkbox">
                  <input class="custom-control-input" type="checkbox" id="remember_me" checked>
                  <label class="custom-control-label" for="remember_me">Remember me</label>
                </div><a class="navi-link" href="account-password-recovery.html">Forgot password?</a>
              </div>
              <div class="text-center text-sm-right" style="margin-bottom: 20px">
               <button class="btn btn-primary btn-sm" type="submit">Login</button>
              </div>
            </form:form>
        </div>
       
      </div>
      
    </div>
  </div>



	<!-- Slider -->
	<div class="slidercontainer bg_primary" style="margin-top: 10px; padding: 20px;">
	<!--	<div class="row">
			<div class="container">
				<div class="section-title  margin-b50">
					<h2>Case Datails</h2>
                </div>
			</div>
		</div>-->
		
	</div>
	
	<div class="container" style="margin-top: 50px">
	<div class="row">
		<div class="col-sm-6">
			<img src="img/swarn_jayanti.jpg">
		</div>
		
				<div class="col-sm-6">
		<h2>मुख्य उदेद्श्य</h2>
		<p>1. राज्य के ग्रामीण परिवारों को सुरक्षित पेयजल पर्याप्त मात्रा में सुविधाजनक स्थान पर परिवार स्तर पर नल कनेक्शन द्वारा उचित वितरण व्यवस्था के साथ वर्ष भर उपलब्धता सुनिश्चित करना।</p>
		<p>2. शहरी/नगरीय/ग्रामों की नलजल योजनाओं की परिकल्पना, रूपांकन, प्राक्कलन, निविदा प्रपत्र निर्माण, निविदाएं आमंत्रण, कार्यादेश, क्रियान्वयन, पर्यवेक्षण तथा अनुश्रवण।</p>
		<p>3. भू-गर्भीय तथा तथा सतही जल संसाधनों का संयुक्त उपयोग सुनिश्चित् करना।</p>
		<p>4. राज्य की ग्रामीण नलजल योजनाओं का संचालन एवं संधारण सुनिश्चित करने हेतु ग्राम पेयजल समितियों के गठन उनमें जल के प्रति सामाजिक तथा पर्यावरणीय चेतना विकसित करने में सहयोग प्रदाय करना।</p>
		<p>5. नगरीय क्षेत्रों एवं ग्रामीण क्षेत्रों में उत्सर्जित होने वाले जल मल के निकास एवं उपचार की योजनाओं का आकल्पन एवं क्रियान्यवन करना।</p>
		<p>6. पेयजल प्रदाय योजनाओं एवं जल मल निकास योजनाओं के क्रियान्वयन से संबधित नीतिगत निर्णय हेतु राज्य स्तर पर शीर्ष संस्था के रूप में कार्य करना।</p>





	
		</div>
		
	</div></div>
	<!-- End of Slider -->
	
	
	<!--<div class="slidercontainer">
		<div id="mainslider" class="owl-carousel owl-theme" style="opacity: 1; display: block;">

            <div class="owl-wrapper-outer"><div class="owl-wrapper" style="width: 15224px; left: 0px; display: block; transition: all 1000ms ease 0s; transform: translate3d(0px, 0px, 0px);"><div class="owl-item" style="width: 1903px;"><div class="item">
				<div class="row full-width no-gutter section_sapce bg_primary cover-image2" data-image-src="images/slider/7.jpg" style="background: url(&quot;images/slider/7.jpg&quot;) center center;">
                    <div class="container">
                        <div class="col-sm-12 col-md-6 custom-info4-column radius">
                            <div class="thequote">
                                <h5 class="text_dark">Cheap Web Hosting with Superior Speed</h5>
                                <p class="text_dark">Our web hosting services will rock your world. All servers are SSD-powered.</p>
                                <a href="#" class="btn btn-lg btn-new">Buy Now</a>
                            </div>
                        </div>
                    </div>
				</div>
            </div></div><div class="owl-item" style="width: 1903px;"><div class="item">
				<div class="row full-width no-gutter section_sapce bg_primary cover-image2" data-image-src="images/slider/4.jpg" style="background: url(&quot;images/slider/4.jpg&quot;) center center;">
                    <div class="container">
                        <div class="col-sm-12 col-md-8 center-block custom-info-column outer-glow">
                            <div class="thequote">
                                <h5>TheOptimal is an ICANN accredited leading provider</h5>
                                <p>We are is an ICANN accredited leading provider of web-presence solutions to small-businesses</p>
                                <a href="#" class="btn btn-lg btn-new">Buy Now</a>
                            </div>
                        </div>
                    </div>
				</div>
            </div></div><div class="owl-item" style="width: 1903px;"><div class="item">
				<div class="row full-width no-gutter section_sapce bg_primary cover-image2" data-image-src="images/slider/6.jpg" style="background: url(&quot;images/slider/6.jpg&quot;) center center;">
                    <div class="container">
                        <div class="col-sm-12 col-md-6 pull-right custom-info3-column radius">
                            <div class="thequote">
                                <h5>Buy Shared Hosting Services</h5>
                                <p>Our website hosting plans come with free of cost. Website domain &amp; website design</p>
                                <a href="#" class="btn btn-lg btn-new">Buy Now</a>
                            </div>
                        </div>
                    </div>
				</div>
            </div></div><div class="owl-item" style="width: 1903px;"><div class="item">
				<div class="row full-width no-gutter section_sapce bg_primary cover-image2" data-image-src="images/slider/8.jpg" style="background: url(&quot;images/slider/8.jpg&quot;) center center;">
                    <div class="container">
                        <div class="col-sm-12 col-md-6 custom-info-column outer-glow">
                            <div class="thequote">
                                <h5>TheOptimal Affiliate Program</h5>
                                <p>It's easy, and quick FREE! Get a unique tracking code for your websites that accounts for every visitor you refer.</p>
                                <a href="#" class="btn btn-lg btn-new">Register Now</a>
                            </div>
                        </div>
                    </div>
				</div>
            </div></div></div></div>

			

			

			

		</div>
	</div>-->

	<!--  Features -->
	<!--<section  class="section_sapce">
	
		<div class="row">
			<div class="container">
				<div class="section-title margin-b30">
					<h2><span>Welcome to TheHosting</span> Why Choose TheHosting ?</h2>
                </div>
			</div>
		</div>
		<div class="row">
			<div class="container">
            	<div class="col-lg-4 margin-t30">
                    <div class="text-center">
                        <i class="fa fa-percent fa-3x text_primary square-border-icon"></i>
                        <h3>Discount Guarantee!</h3>
                         <p>Vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti.</p>
                    </div>
                </div>
				<div class="col-lg-4 margin-t30">
                    <div class="text-center">
                        <i class="fa fa-phone fa-3x text_primary square-border-icon"></i>
                        <h3>24/7 Technical Support</h3>
                         <p>Vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti.</p>
                    </div>
                </div>
				<div class="col-lg-4 margin-t30">
                    <div class="text-center">
                        <i class="fa fa-check fa-3x text_primary square-border-icon"></i>
                        <h3>Best Pricing</h3>
                         <p>Vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti.</p>
                    </div>
                </div>
			</div>
		</div>
	</section>-->
	
	
	<!-- End of Features -->
       
       
  
        
  <!--  Footer -->
<footer class="footer">
  
  <div class="row bg_white copyright">
  <hr>
    <p class="copyright text-center">Copyright Â© 2018 - 2019 <a href="https://www.cinfysystems.com/">Cinfy Systems.</a> All Rights Reserved</p>
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
	<script src="js/video-popup.js"></script>
	<script src="js/jquery.circliful.min.js"></script>
	<script src="js/waypoints.min.js"></script>
    <script src="js/jquery.responsiveTabs.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/retina.min.js"></script>
	<script src="js/jquery.parallax-1.1.3.js"></script>
    <script src="js/jquery.countdown.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/Chart.bundle.js"></script>
	
	
	
	<!--chart-->
	<script>
  var ctx = document.getElementById("myChart").getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ["Jan", "Feb", "Mar", "Apl", "May", "June"],
      datasets: [{
        label: '# of Cases',
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderColor: [
          'rgba(255,99,132,1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: true
          }
        }]
      }
    }
  });

</script>

<!--piechart-->
	<script>
  //pie
  var ctxP = document.getElementById("pieChart").getContext('2d');
  var myPieChart = new Chart(ctxP, {
    type: 'pie',
    data: {
      labels: ["Pending", "Last 7 day", "Update", "Next 7 day", "My case"],
      datasets: [{
        data: [300, 50, 100, 40, 120],
        backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
        hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
      }]
    },
    options: {
      responsive: true
    }
  });

</script>
	
	<!--line chart-->
	<script>
  //line
  var ctxL = document.getElementById("lineChart").getContext('2d');
  var myLineChart = new Chart(ctxL, {
    type: 'line',
    data: {
      labels: ["Monday", "Tuesday", "wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
      datasets: [{
          label: "Next 7 Day Hearing",
          data: [65, 59, 80, 81, 56, 55, 40],
          backgroundColor: [
            'rgba(105, 0, 132, .2)',
          ],
          borderColor: [
            'rgba(200, 99, 132, 1)',
          ],
          borderWidth: 2
        },
        {
          label: "Previous 7 Day Hearing",
          data: [28, 48, 40, 19, 86, 27, 90],
          backgroundColor: [
            'rgba(0, 137, 132, .2)',
          ],
          borderColor: [
            'rgba(0, 10, 130, 1)',
          ],
          borderWidth: 2
        }
      ]
    },
    options: {
      responsive: true
    }
  });

</script>

	
	

</body>

</html>