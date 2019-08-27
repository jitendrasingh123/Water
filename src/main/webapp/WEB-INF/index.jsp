
<!DOCTYPE html>
<html lang="en">

<head>

	<%@include file="head.jsp"%>
	
	

<script type="text/javascript">
window.onload = function() {
	
//pie chart----------------------------------------------------	
	var dps1 = [[]];
	var chart1 = new CanvasJS.Chart("pieChartContainer", {
		animationEnabled: true,
		exportEnabled: true,	
		title:{
			text: ""
		},
		data: [{
			type: "pie",    
		    yValueFormatString: "#,###\"%\"",
		    showInLegend: true,
		    indexLabel: "{y}", 
		    indexLabelPlacement: "inside",
			dataPoints: dps1[0]
		}]
	});
	 
	var yValue1;
	var name1;
	 
	<c:forEach items="${dataPointsListPie}" var="dataPoints" varStatus="loop">
		<c:forEach items="${dataPoints}" var="dataPoint">
			yValue1 = parseFloat("${dataPoint.y}");
			name1 = "${dataPoint.name}";
			dps1[parseInt("${loop.index}")].push({
				name : name1,
				y : yValue1
			});
		</c:forEach>
	</c:forEach>
	 
	chart1.render();
	 
	
	
	
	//bar chart----------------------------------------------------	
 
var dps2 = [[]];
var chart2 = new CanvasJS.Chart("barChartContainer", {
	theme: "light2", //"light1", "dark1", "dark2"
	animationEnabled: true,
	title: {
		text: ""
	},
	axisX: {
		title: "Days of the week",
		valueFormatString: "YYYY"
	},
	axisY: {
		title: "Number of cases",
		includeZero: false,
		maximum: 250
	},
	data: [{
		type: "column",
		xValueType: "dateTime",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0mn tonnes",
		dataPoints: dps2[0]
	}]
});
 
var xValue2;
var yValue2;
 
<c:forEach items="${dataPointsListBar}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		xValue2 = parseInt("${dataPoint.x}");
		yValue2 = parseFloat("${dataPoint.y}");
		label = "${dataPoint.label}";
		indexLabel = "${dataPoint.indexLabel}";
		dps2[parseInt("${loop.index}")].push({
			x : xValue2,
			y : yValue2
		});		
	</c:forEach>	
</c:forEach> 
 
chart2.render();
 

//line chart---------------------------------------------------------------------------------
var dps3 = [[]];
var chart3 = new CanvasJS.Chart("lineChartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	animationEnabled: true,
	title: {
		text: ""
	},
	axisX: {
		title: "Days of the week",
		valueFormatString: "MMM"
	},
	axisY: {
		title: "Number of cases",
		suffix: " °C"
	},
	data: [{
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 °C",
		dataPoints: dps3[0]
	}]
});
 
var xValue3;
var yValue3;
 
<c:forEach items="${dataPointsListLine}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		xValue3 = parseInt("${dataPoint.x}");
		yValue3 = parseFloat("${dataPoint.y}");
		dps3[parseInt("${loop.index}")].push({
			x : xValue3,
			y : yValue3
		});		
	</c:forEach>	
</c:forEach> 
 
chart3.render();
 
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
					<h1>Home</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb">
						<li>You are here:</li>
						<li><a href="index.html">Home</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- End of Breadcrumps -->


	<!-- Slider -->
	<div class="slidercontainer bg_primary" style="padding-top: 20px">
	<!--	<div class="row">
			<div class="container">
				<div class="section-title  margin-b50">
					<h2>Case Datails</h2>
                </div>
			</div>
		</div>-->
		<div class="container">
			<div class="row ">
			
			<div class="col-sm-6 col-md-6 margin-top-30">
                	<div class="panel panel-info" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
                   	<div class="panel-heading">
                   	<div><span><img class="img-circle" src="${loginUser.path }" style="float: left" width="70px"></span><span><h3 class="text-center" style="color:#121111">Mr. <%= loginUser.getUserName() %></h3></span> </div>
							
                        </div>
                    
                        <div class="panel-body" style="margin-top: 20px">
                        	<ul class="nav nav-stacked">
                                <li><a href="next7dayshearing">Hearing in next 7 days <span class="pull-right badge bg-red">${next7dayscount}</span></a></li>
                                <li><a href="last7dayshearing">Hearing in last 7 days <span class="pull-right badge bg-aqua">${last7dayscount }</span></a></li>
                                <li><a href="last30dayshearing">Hearing in last 30 days<span class="pull-right badge bg-green">${last30dayscount }</span></a></li>
                               <!--  <li><a href="#">Total Update Cases<span class="pull-right badge  bg-blue  ">150</span></a></li> -->
                               <!--  <li><a href="#">Zone Cases<span class="pull-right badge bg-green">30</span></a></li>
                               <li><a href="#">Circle Cases<span class="pull-right badge bg-aqua">25</span></a></li> -->
                               <li><a href="totalcasespending">Total pending cases - till date<span class="pull-right badge  bg-red  ">${totalcasespendingcount}</span></a></li>
                                <li>&nbsp;</li>
                          	</ul>
                        </div>
                  	</div>
                </div>
                
                
                <div class="col-sm-6 col-md-6 margin-top-30">
					<div class="panel panel-info" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
					<div class="panel-heading">
							<h3 class="text-center" style="color:#121111">7 day hearing (Next & Previous)</h3>
                        </div>
                        <div class="panel-body">
					<div id="lineChartContainer" style="height: 370px; width: 100%;"></div>
                	</div>
						<!-- <div class="panel-footer"><a href="#" class="btn btn-primary"> Detail</a></div> -->
					</div>
				</div>
				
				
				
		
				<div class="col-sm-6 col-md-6 margin-top-30">
					<div class="panel panel-info" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
					<div class="panel-heading">
							<h3 class="text-center" style="color:#121111">Pending Cases</h3>
                        </div>
                        <div class="panel-body">
							<div id="pieChartContainer" style="height: 370px; width: 100%;"></div></div>
						<!-- <div class="panel-footer"><a href="#" class="btn btn-primary"> Detail</a></div> -->
					</div>
				</div>
				
					
			<div class="col-sm-6 col-md-6 margin-top-30">
					<div class="panel panel-info" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
					<div class="panel-heading">
							<h3 class="text-center" style="color:#121111">Updated Cases</h3>
                        </div>
                        <div class="panel-body">
						<div id="barChartContainer" style="height: 370px; width: 100%;"></div></div>
						<!-- <div class="panel-footer"><a href="#" class="btn btn-primary"> Detail</a></div> -->
					</div>
				</div>
				
				
               
                
				
			</div>
		</div>
	</div>
	

	<!-- End of Slider -->
	
  
  <%@include file="footer.jsp"%>
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