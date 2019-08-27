
<!DOCTYPE html>
<html lang="en">

<head>
	<%@include file="head.jsp"%>
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

	/* function getSubDivisionList(divisionId) {
		

		$.ajax({
			type : "POST",
			url : "get_subdivision_list",
			data : {
				"divisionId" : divisionId
			}

		}).done(
				function(subDivisionList) {

					//document.getElementById("officeId").disabled = false;
					var opt = '';
					opt += '<option value="">Select Sub Division</option>';
					for (i in subDivisionList) {

						opt += '<option value="'+subDivisionList[i].id+'">'
								+ subDivisionList[i].nameEnglish + '</option>';
					}
					$('#subDivisionId').html(opt);

				});

	} */
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
        <h1>Case Search</h1>
      </div>
      <div class="col-sm-6">
        <ol class="breadcrumb">
          <li>You are here: </li>
          <li><a href="index.html">Home</a> </li>
          <li>Pages </li>
          <li class="active">Case Search</li>
        </ol>
      </div>
    </div>
  </div>
</section>
<!-- End of Breadcrumps -->

<!-- <section class="section_sapce section_primary cover-image" style="background: url(img/bg2.png)center center;">
  <div class="section-title ">
    <h2 style="color: #fff !important">Search your Case</h2>
  </div>
</section> -->




<div class="container">
                               
	<div class="row">
		<div class="col-sm-12">
		<form action="case_search_filter" method="post">
		                          <c:if test="${not empty success}">
										<div class="alert alert-success">
											<a href="#" class="close" data-dismiss="alert">&times;</a><strong>
											${success}</strong>
										</div>
									</c:if>
									  <c:if test="${not empty error}">
										<div class="alert alert-danger">
											<a href="#" class="close" data-dismiss="alert">&times;</a><strong>
											${error}</strong>
										</div>
									</c:if>
		                        
		<div class="panel with-nav-tabs panel-primary" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
                   	<div class="panel-heading">
                   	<div><h3 class="text-center" style="color:#fff">Case Search</h3></div></div>
                    
                        <div class="panel-body table-responsive" style="margin-top: 20px">
                        
                        <table class="table table-bordered" style="margin-top: 5px">
                <thead>
                  <tr >
                    <th>Zone</th>
                    <th>Circle</th>
                    <th>Devision</th>
                  </tr>
                </thead>
                <tbody class="table01">
                  <tr >
                    <td>
                    <c:if test="${zoneFlag eq false}">
                    <span>${zone.nameEnglish}</span>
                    <input type="hidden" name="zoneId" value="${zone.id}">
                    </c:if>
                     <c:if test="${zoneFlag eq true}">
                    <select class="form-control" name="zoneId"
												 onchange="getCircleList(this.value);">
												<option value="">Select</option>
												<c:forEach items="${zoneList}" var="zl">
													<option value="${zl.id}">${zl.nameEnglish}</option>
												</c:forEach>
											</select>
											</c:if>
											</td>
                    <td>
                     <c:if test="${circleFlag eq false}">
                     <span>${circle.nameEnglish}</span>
                      <input type="hidden" name="circleId" value="${circle.id}">
                     </c:if>
                        <c:if test="${circleFlag eq true}">
                     <select class="form-control" name="circleId"
												id="circleId" 
												onchange="getDivisionList(this.value);">
													<option value="">Select</option>
											 <c:forEach items="${circleList}" var="cl">
													<option value="${cl.id}">${cl.nameEnglish}</option>
												</c:forEach> 
											</select>
											</c:if>
											</td>
                       
                        <td>
                          <c:if test="${divisionFlag eq false}">
                         <span>${division.nameEnglish}</span>
                          <input type="hidden" name="divisionId" value="${division.id}">
                          </c:if>
                           <c:if test="${divisionFlag eq true}">
                          <select class="form-control" name="divisionId"
												id="divisionId"
												>
												<option value="">Select</option>
											 	<c:forEach items="${divisionList}" var="dl">
													<option value="${dl.id}">${dl.nameEnglish}</option>
												</c:forEach>
											</select>
											</c:if>
											</td>
                  </tr>
                   <thead>
                  <tr >
                    <th>Hearing From</th>
                    <th>Hearing To</th>
                    <th></th>
                  </tr>
                    </thead>
                  <tr >
                    <td><input type="date" name="fromDateHearing" class="form-control"/></td>
                    <td><input type="date" name="toDateHearing" class="form-control"/></td>                       
                        <td></td>
                  </tr>
                   <thead>
                  <tr >
                  
                    <th colspan="3" style="text-align:center;">OR</th>
                   
                  </tr>
                    </thead>
              
                  <thead>
                    <tr >
                    <th>Type</th>
                    <th>Number</th>
                    <th>Year</th>
                  </tr>
                   </thead>
                   <tr >
                    <td><select class="form-control" name="caseTypeId" id="caseTypeId" >
                       <option value="">Select Case Type</option>
											 	<c:forEach items="${caseTypeList}" var="dl">
													<option value="${dl.id}">${dl.caseType}</option>
												</c:forEach>
                      
                      </select></td>
                    <td><input type="text" class="form-control" name="caseNo" id="caseNo" value=""></td>
                    <td><select class="form-control" name="caseYear" id="caseYear" >
                        <option value="">Select Year</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                        <option value="2015">2015</option>
                        <option value="2014">2014</option>
                        <option value="2013">2013</option>
                        <option value="2012">2012</option>
                        <option value="2011">2011</option>
                        <option value="2010">2010</option>
                        <option value="2009">2009</option>
                        <option value="2008">2008</option>
                        <option value="2007">2007</option>
                        <option value="2006">2006</option>
                        <option value="2005">2005</option>
                        <option value="2004">2004</option>
                        <option value="2003">2003</option>
                        <option value="2002">2002</option>
                        <option value="2001">2001</option>
                        <option value="2000">2000</option>
                        <option value="1999">1999</option>
                        <option value="1998">1998</option>
                        <option value="1997">1997</option>
                        <option value="1996">1996</option>
                        <option value="1995">1995</option>
                        <option value="1994">1994</option>
                        <option value="1993">1993</option>
                        <option value="1992">1992</option>
                        <option value="1991">1991</option>
                        <option value="1990">1990</option>
                        <option value="1989">1989</option>
                        <option value="1988">1988</option>
                        <option value="1987">1987</option>
                        <option value="1986">1986</option>
                        <option value="1985">1985</option>
                        <option value="1984">1984</option>
                        <option value="1983">1983</option>
                        <option value="1982">1982</option>
                        <option value="1981">1981</option>
                        <option value="1980">1980</option>
                        <option value="1979">1979</option>
                        <option value="1978">1978</option>
                        <option value="1977">1977</option>
                        <option value="1976">1976</option>
                        <option value="1975">1975</option>
                        <option value="1974">1974</option>
                        <option value="1973">1973</option>
                        <option value="1972">1972</option>
                        <option value="1971">1971</option>
                      </select></td>
                  </tr>
                  
                  
                 
                </tbody>
              </table>
                        
                        	<table class="table table-bordered" style="margin-top: 5px">
                <thead>
                
                </thead>
                <tbody class="table01">
                 
                  
                </tbody>
              </table>
              <div class="row" >
              <div class="col-md-6 mrg-20" style="margin-top: 10px" align="right">
								<div class="effect-1">
									<input type="submit" class="btn btn-light btn-primary"
										name="Submit" />
								</div>
							</div>
							  <div class="col-md-6 mrg-20"  align="left"
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
		
		<div class="panel panel-info" style="box-shadow: 2px 4px 29px -4px rgba(0,0,0,0.35) !important;">
                   	<div class="panel-heading">
                   	<div><h3 class="text-center" style="color:#121111">Case Details</h3></div>
							
                        </div>
                    
                        <div class="panel-body  table-responsive" style="margin-top: 20px">
                               <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                                            <th>Sr.No.</th>
										    <th>Case No.</th>
										    <th>Petitioner Name</th>
											<th>Respondent Name</th>
											<th>Zone</th>									
											<th>Division</th>	
											<th>Name Of Court</th>	
											<th>Petition Date</th> 									
																			
											<th>Action</th> 
            </tr>
        </thead>
      <tbody>
										
											<c:set var="count" value="0" scope="page" />
												
											<c:forEach items="${list}" var="fl">
												<c:set var="countlog1" value="0" scope="page" />
												<c:set var="countlog2" value="0" scope="page" />
												<tr class="odd gradeX">
													<td>
													<input type="hidden" name="ids" value="${fl.id}">
													<c:set var="count" value="${count + 1}"	scope="page" /> <c:out value="${count}" /> </td>
													<td style="word-break:break-all;">${fl.caseTypeId.caseType}/ ${fl.caseNo}/ ${fl.caseYear}</td>													
													<%-- <td style="word-break:break-all;">${fl.petitioner}</td>
													<td style="word-break:break-all;">${fl.respondent}</td> --%>
													
													<td style="word-break:break-all;">
												  <c:forEach items="${fl.petitionerNames}" var="pt">
												  
												    <c:set var="countlog1" value="${countlog1 + 1}"	scope="page" /> <c:out value="${countlog1}" />) ${pt.petitionerName}
												   </br>
												    </c:forEach>
												   </td>
													<td style="word-break:break-all;">
														
													  <c:forEach items="${fl.defendantNames}" var="dt">
												    <c:set var="countlog2" value="${countlog2 + 1}"	scope="page" /> <c:out value="${countlog2}" />) ${dt.defendantId.userName}(${dt.defendantId.designationId.name})
												</br>
												  </c:forEach>
												  </td>
													<td >${fl.zoneId.nameEnglish}</td>
													<td >${fl.divisionId.nameEnglish}</td>											
													<td ><c:out value="${fl.courtNameId.courtName}" /></td>
													<td><fmt:formatDate type = "date" value = "${fl.petitionDate}" /></td>
																							
												 <td>
												 <a	href="<c:url value="/case_registration?id=${fl.id}"/>"><img src="img/pencil_edit.png" width="20px" class="img-responsive center-block"></a>
												
												</td>  
												 
												</tr>
											</c:forEach>
										
									</tbody>
        <tfoot>
            <tr>
                   <th>Sr.No.</th>
										    <th>Case No.</th>
										    <th>Petitioner Name</th>
											<th>Respondent Name</th>
											<th>Zone</th>									
											<th>Division</th>	
											<th>Name Of Court</th>	
											<th>Petition Date</th> 									
																			
											<th>Action</th> 
            </tr>
        </tfoot>
    </table>               
                        	
                        </div>
                        
                  	</div>
		
			
			
		</div>
	</div>
	
</div>








<%@include file="footer.jsp"%>






</body>
</html>