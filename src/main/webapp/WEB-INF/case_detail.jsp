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
        <center>
          <img src="img/MpGov.png" class="img-responsive"  width="60px">
          <h3 style="color: #14B5EF">Jal Nigam Bhopal</h3>
        </center>
      </div>
      <div class="modal-body" style="padding: 40px; margin-bottom: 50px">
        <form method="post">
          <h4 class="margin-bottom-1x">Login By ID</h4>
          <div class="form-group input-group">
            <input class="form-control" type="email" placeholder="Email" required="">
            <span class="input-group-addon "><i class="fa fa-envelope "></i></span> </div>
          <div class="form-group input-group">
            <input class="form-control" type="password" placeholder="Password" required="">
            <span class="input-group-addon "><i class="fa fa-eye-slash"></i></span> </div>
          <div style="padding-bottom: 50px">
            <div class="custom-control custom-checkbox">
              <input class="custom-control-input" type="checkbox" id="remember_me" checked="">
              <label class="custom-control-label" for="remember_me">Remember me</label>
            </div>
            <a class="navi-link" href="account-password-recovery.html">Forgot password?</a> </div>
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
        <h1>Case Registration</h1>
      </div>
      <div class="col-sm-6">
        <ol class="breadcrumb">
          <li>You are here: </li>
          <li><a href="index.html">Home</a> </li>
          <li>Pages </li>
           <li class="active">Case Register</li>
        </ol>
      </div>
    </div>
  </div>
</section>
<!-- End of Breadcrumps -->



<style>
	
	
	
	.stepwizard-step p {
    margin-top: 10px;
}

.stepwizard-row {
    display: table-row;
}

.stepwizard {
    display: table;
    width: 100%;
    position: relative;
}

.stepwizard-step button[disabled] {
    opacity: 1 !important;
    filter: alpha(opacity=100) !important;
}

.stepwizard-row:before {
    top: 14px;
    bottom: 0;
    position: absolute;
    content: " ";
    width: 100%;
    height: 1px;
    background-color: #ccc;
    z-order: 0;

}

.stepwizard-step {
    display: table-cell;
    text-align: center;
    position: relative;
}
	
	.stepwizard-row {
    display: table-row;
}

.stepwizard {
    display: table;
    width: 100%;
    position: relative;
}

.stepwizard-step button[disabled] {
    opacity: 1 !important;
    filter: alpha(opacity=100) !important;
}

.stepwizard-row:before {
    top: 14px;
    bottom: 0;
    position: absolute;
    content: " ";
    width: 100%;
    height: 1px;
    background-color: #ccc;
    z-order: 0;

}

</style>



<div class="slidercontainer bg_primary" style="padding-top: 20px; ">
<div class="container" style="margin-top: 30px">
<div class="row" >
<div class="col-md-12">
  <div class="panel panel-default">
    <div class="panel-heading">
      <div class="stepwizard">
        <div class="stepwizard-row setup-panel">
          <div class="stepwizard-step"> <a href="#step-1" type="button" class="btn btn-green btn-circle">1</a>
            <p style="color: #000; font-weight: 400; font-size:22px;">Case Detail - 1</p>
          </div>
          <div class="stepwizard-step"> <a href="#step-2" type="button" class="btn btn-default btn-circle" >2</a>
            <p style="color: #000; font-weight: 400;font-size:22px;">Upcoming Hearing Date - 2</p>
          </div>
          <div class="stepwizard-step"> <a href="#step-3" type="button" class="btn btn-default btn-circle" >3</a>
            <p style="color: #000; font-weight: 400;font-size:22px;">Order Details - 3</p>
          </div>
            <div class="stepwizard-step"> <a href="#step-4" type="button" class="btn btn-default btn-circle" >4</a>
            <p style="color: #000; font-weight: 400;font-size:22px;">Attachments - 4</p>
          </div>
        </div>
      </div>
    </div>
    <form:form action="save_case_registration"	modelAttribute="caseRegistration" enctype="multipart/form-data">
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
    <c:set var="counter_petitioner" value="1" scope="page" />
     <c:set var="counter_defendant" value="1" scope="page" />
      <c:set var="counter_attachment" value="0" scope="page" />
  
    <script>
    var counter_petitioner = 0;
    var counter_defendant = 0;
    var counter_attachment=0;
    $(document).ready(function() {
    	
    //petitionerNames--------------------------------------------------------------------------------------	
	var max_fields      = 10;
	var wrapper         = $(".input_fields_wrap"); 
	var add_button      = $(".add_field_button");
	var remove_button   = $(".remove_field_button");

	$(add_button).click(function(e){
		
	    e.preventDefault();
	    var total_fields = wrapper[0].childNodes.length;
	    if(total_fields < max_fields){
	    	counter_petitioner++;
	    	alert(counter_petitioner);
	    	$(wrapper).append('<input type="hidden"  name="petitionerNames['+counter_petitioner+'].id" class="field-long " />'
	    			+'<input type="text" placeholder="Petitioner Name" name="petitionerNames['+counter_petitioner+'].petitionerName" class="field-long form-control" style="margin-top:5px;" />');
	    }
	   
	    
	});
	$(remove_button).click(function(e){
		counter_petitioner--;
	    e.preventDefault();
	    var total_fields = wrapper[0].childNodes.length;
	    if(total_fields>1){
	        wrapper[0].childNodes[total_fields-1].remove();
	    }
	});
	//defendantNames--------------------------------------------------------------------
	var max_fields1      = 10;
	var wrapper1         = $(".input_fields_wrap_defendantNames"); 
	var add_button1      = $(".add_field_button_defendantNames");
	var remove_button1  = $(".remove_field_button_defendantNames");

	$(add_button1).click(function(e){
		
	    e.preventDefault();
	    var total_fields1 = wrapper1[0].childNodes.length;
	  
	    if(total_fields1 < max_fields1){
	    	counter_defendant++;
	    	alert(counter_defendant);
	        $(wrapper1).append('<input type="hidden" name="defendantNames['+counter_defendant+'].id" class="field-long" />'
	        		+'<select  name="defendantNames['+counter_defendant+'].defendantId.id" class="form-control"	required="required" style="margin-top:10px">'
					+'<option value="">Select Defendant</option>'
					+'<c:forEach items="${oicList}" var="ol">'
					+'<option value="${ol.id}">${ol.userName}</option>'
					+'</c:forEach>'
				    +'</select>');
	    }
	});
	$(remove_button1).click(function(e){
		counter_defendant--;
	    e.preventDefault();
	    var total_fields1 = wrapper1[0].childNodes.length;
	    if(total_fields1>1){
	        wrapper1[0].childNodes[total_fields1-1].remove();
	    }
	});
	
	
	//attachment--------------------------------------------------------------------------------------	
	var max_fields_attachment      = 10;
	var wrapper_attachment         = $(".input_fields_wrap_attachment"); 
	var add_button_attachment      = $(".add_field_button_attachment");
	var remove_button_attachment   = $(".remove_field_button_attachment");

	$(add_button_attachment).click(function(e){
		
	    e.preventDefault();
	    var total_fields_attachment = wrapper_attachment[0].childNodes.length;
	    if(total_fields_attachment < max_fields_attachment){
	    	counter_attachment++;
	    	alert(counter_attachment);
	    	$(wrapper_attachment).append('<div class="row"><div class="col-sm-6"> <input type="hidden"  name="caseAttachments['+counter_attachment+'].id" class="field-long " />'
	    			+'<input type="text" placeholder="Attachment Title Name" name="caseAttachments['+counter_attachment+'].title" class="field-long form-control" style="margin-top:5px;" />'
	    			+'</div><div class="col-sm-6"> <input type="file" placeholder="Image" name="caseAttachments['+counter_attachment+'].fileAttachment" class="field-long form-control" /></div></div>');
	    }
	   
	    
	});
	$(remove_button_attachment).click(function(e){
		counter_attachment--;
	    e.preventDefault();
	    var total_fields_attachment = wrapper_attachment[0].childNodes.length;
	    if(total_fields_attachment>1){
	    	wrapper_attachment[0].childNodes[total_fields_attachment-1].remove();
	    }
	});
	
	
});
    </script>
    <div class="panel-body" >
                                       

                                       
     
      <div class="row setup-content" id="step-1">
        <div class="section-title margin-b50">
          <!-- <h2>Register</h2> -->
        </div>
        <div class="form">
						
						<form:hidden path="id" />
							
						
						
						
						
							<div class="row">

								<div class="col-sm-6">

									<div class="col-sm-4">
										<div class="form-group">
											<label for="">Type of Case <span class="red">*</span></label>
											<form:select class="form-control" path="caseTypeId.id"
												required="required">
												<form:option value="">Select</form:option>
												<c:forEach items="${caseTypeList}" var="ctl">
													<form:option value="${ctl.id}">${ctl.caseType}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label for="">Case Number <span class="red">*</span></label>
											<form:input type="text" class="form-control" path="caseNo" 
												placeholder="Enter Number" name="case_number"
												required="required" maxlength="4" />
										</div>
									</div>

									<div class="col-sm-4">
										<div class="form-group">
											<label for="">Year<span class="red">*</span></label>
											<form:select class="form-control" path="caseYear" 
												required="required">
												 <form:option value="">Select Year</form:option>
						                        <form:option value="2019">2019</form:option>
						                        <form:option value="2018">2018</form:option>
						                        <form:option value="2017">2017</form:option>
						                        <form:option value="2016">2016</form:option>
						                        <form:option value="2015">2015</form:option>
						                        <form:option value="2014">2014</form:option>
						                        <form:option value="2013">2013</form:option>
						                        <form:option value="2012">2012</form:option>
						                        <form:option value="2011">2011</form:option>
						                        <form:option value="2010">2010</form:option>
						                        <form:option value="2009">2009</form:option>
						                        <form:option value="2008">2008</form:option>
						                        <form:option value="2007">2007</form:option>
						                        <form:option value="2006">2006</form:option>
						                        <form:option value="2005">2005</form:option>
						                        <form:option value="2004">2004</form:option>
						                        <form:option value="2003">2003</form:option>
						                        <form:option value="2002">2002</form:option>
						                        <form:option value="2001">2001</form:option>
						                        <form:option value="2000">2000</form:option>
						                        <form:option value="1999">1999</form:option>
						                        <form:option value="1998">1998</form:option>
						                        <form:option value="1997">1997</form:option>
						                        <form:option value="1996">1996</form:option>
						                        <form:option value="1995">1995</form:option>
						                        <form:option value="1994">1994</form:option>
						                        <form:option value="1993">1993</form:option>
						                        <form:option value="1992">1992</form:option>
						                        <form:option value="1991">1991</form:option>
						                        <form:option value="1990">1990</form:option>
						                        <form:option value="1989">1989</form:option>
						                        <form:option value="1988">1988</form:option>
						                        <form:option value="1987">1987</form:option>
						                        <form:option value="1986">1986</form:option>
						                        <form:option value="1985">1985</form:option>
						                        <form:option value="1984">1984</form:option>
						                        <form:option value="1983">1983</form:option>
						                        <form:option value="1982">1982</form:option>
						                        <form:option value="1981">1981</form:option>
						                        <form:option value="1980">1980</form:option>
						                        <form:option value="1979">1979</form:option>
						                        <form:option value="1978">1978</form:option>
						                        <form:option value="1977">1977</form:option>
						                        <form:option value="1976">1976</form:option>
						                        <form:option value="1975">1975</form:option>
						                        <form:option value="1974">1974</form:option>
						                        <form:option value="1973">1973</form:option>
						                        <form:option value="1972">1972</form:option>
						                        <form:option value="1971">1971</form:option>
											</form:select>
										</div>
									</div>

                                    
										
										<!--  <div class="input_fields_wrap">
										    <button class="add_field_button">Add More Fields</button>
										    <div><input type="text" name="mytext[]"></div>
										</div> -->
										
									<%-- <div class="col-sm-12">
										<div class="form-group">
											<label for="">Petitioner Name <span class="red">*</span></label>
											<form:input type="text" class="form-control"
												path="petitioner" placeholder="Enter Name"
												name="Petitioner name" required="required"  />
										</div>
									</div> --%>

                           <div class="col-sm-12">
										<div class="form-group">
											 <c:if test="${caseRegistration.petitionerNames.size()!=0}">
									  <label for="">Name Of Petitioner <span class="red">*</span></label>
									  </c:if>
									<c:forEach items="${caseRegistration.petitionerNames}" var="pettitioner" varStatus="i" begin="0" >
									<c:set var="counter_petitioner" value="${caseRegistration.petitionerNames.size()}" scope="page" />
										     	<c:set var="count" value="${index0 = (i.index) }"	scope="page" />										     	
									<div class="input_fields_wrap" style="margin-top:10px;" >
									<form:input type="hidden" path="petitionerNames[${i.index}].id" class="field-long " />
									<form:input type="hidden" path="petitionerNames[${i.index}].caseId" class="field-long " />									
									<form:input type="text" placeholder="Petitioner Name" path="petitionerNames[${i.index}].petitionerName" class="field-long form-control" />
									</div>  									     	
									</c:forEach>	 
									
									<c:if test="${caseRegistration.petitionerNames.size()==0}">    	
									 <c:set var="counter_petitioner" value="1" scope="page" />		
									   <label for="">Name Of Petitioner <span class="red">*</span></label>								     			                                    
									 <span><button type="button" class="add_field_button">Add Field</button></span>
									<span><button type="button" class="remove_field_button btn-primary">Remove Field</button></span>
									<div class="input_fields_wrap" style="margin-top:10px;" >
									<form:input type="hidden" path="petitionerNames[0].id" class="field-long " />
									<form:input type="text" placeholder="Petitioner Name" path="petitionerNames[0].petitionerName" class="field-long form-control" />
									</div>
									</c:if>
											
										</div>
									</div>


									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Zone <span class="red">*</span></label>
											<form:select class="form-control" path="zoneId.id"
												required="required" onchange="getCircleList(this.value);">
												<form:option value="">Select</form:option>
												<c:forEach items="${zoneList}" var="zl">
													<form:option value="${zl.id}">${zl.nameEnglish}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									
									
									

									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Circle <span class="red">*</span></label>
											<form:select class="form-control" path="circleId.id"
												id="circleId" required="required"
												onchange="getDivisionList(this.value);">
												<form:option value="">Select</form:option>
												<c:forEach items="${circleList}" var="cl">
													<form:option value="${cl.id}">${cl.nameEnglish}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>

									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Division <span class="red">*</span></label>
											<form:select class="form-control" path="divisionId.id"
												id="divisionId" required="required"
											>
												<form:option value="">Select</form:option>
												<c:forEach items="${divisionList}" var="dl">
													<form:option value="${dl.id}">${dl.nameEnglish}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								
										<div class="col-sm-12">
											<div class="form-group">
												<label for="">OIC Name <span class="red">*</span></label>
												<form:select class="form-control" path="oic.id"
													required="required">
													<form:option value="">Select OIC</form:option>
													<c:forEach items="${oicList}" var="ol">
														<form:option value="${ol.id}">${ol.userName}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>

										
								</div>
								<div class="col-sm-6">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Name Of Court <span class="red">*</span></label>
											<form:select class="form-control" path="courtNameId.id"
												required="required">
												<form:option value="">Select</form:option>
												<c:forEach items="${courtList}" var="cl">
													<form:option value="${cl.id}">${cl.courtName}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									
										<div class="col-sm-12">
										<div class="form-group">
										 <c:if test="${caseRegistration.defendantNames.size()!=0}">
										 <label for="">Name Of Defendant <span class="red">*</span></label>
										 </c:if>
											 <c:forEach items="${caseRegistration.defendantNames}" var="pettitioner" varStatus="i" begin="0" >
									         <c:set var="counter_defendant" value="${caseRegistration.defendantNames.size()}" scope="page" />
										     	<c:set var="count" value="${index0 = (i.index) }"	scope="page" />	
										     	<span class="input_fields_wrap_defendantNames">
											<form:input type="hidden" path="defendantNames[${i.index}].id" class="field-long" />
											<form:input type="hidden" path="defendantNames[${i.index}].caseId" class="field-long" />
											<form:select  path="defendantNames[${i.index}].defendantId.id" class="form-control"	required="required" style="margin-top:10px">
													<form:option value="">Select Defendant</form:option>
													<c:forEach items="${oicList}" var="ol">
														<form:option value="${ol.id}">${ol.userName}</form:option>
													</c:forEach>
												</form:select>
                                            </span>
										
										  </c:forEach>
										  <c:if test="${caseRegistration.defendantNames.size()==0}">
										     <c:set var="counter_defendant" value="1" scope="page" />
										    <label for="">Name Of Defendant <span class="red">*</span></label>
											<span><button type="button" class="add_field_button_defendantNames">Add Field</button></span>
											<span><button type="button" class="remove_field_button_defendantNames btn-primary">Remove Field</button></span>
											<span class="input_fields_wrap_defendantNames">
											<form:input type="hidden" path="defendantNames[0].id" class="field-long" />
											<form:select  path="defendantNames[0].defendantId.id" class="form-control"	required="required" style="margin-top:10px">
													<form:option value="">Select Defendant</form:option>
													<c:forEach items="${oicList}" var="ol">
														<form:option value="${ol.id}">${ol.userName}</form:option>
													</c:forEach>
												</form:select>
                                            </span>
                                            </c:if>
									</div>
									</div>
									
							

									<%-- <div class="col-sm-12">
										<div class="form-group">
											<label for="">Respondent Name <span class="red">*</span></label>
											<form:input type="text" class="form-control"
												placeholder="Enter Respondent Name" path="respondent"
												required="true" maxlength="50" />
										</div>
									</div> --%>



									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Petition date <span class="red">*</span></label>
											<form:input type="date" class="form-control"
												path="petitionDate" 
												required="required" />
										</div>
									</div>


									<div class="col-sm-12">
										<div class="form-group">
											<label>Details of Petition<span class="red">*</span>
											</label>
											<form:textarea path="petitionDetails" class="form-control"
												rows="4" cols="" placeholder="Detail" required="true"
												maxlength="500"></form:textarea>
										</div>
									</div>
									
										<div class="col-sm-12">
											<div class="form-group">
												<label for="">Case Status <span class="red">*</span></label>
												<form:select class="form-control" path="caseStatus"
													required="required">
													<form:option value="">Select Status</form:option>
													
														<form:option value="Running">Running</form:option>
															<form:option value="Disposed">Disposed</form:option>
												
												</form:select>
											</div>
										</div>

									
								</div>


							</div>

							
						
					</div>
      </div>
      
      
      <div class="row setup-content" id="step-2">
        <div class="section-title margin-b50">
        <!--   <h2>Important Date</h2> -->
        </div>
        <div class="form">
               
                
              
				
                  <div class="row"> 
              
                    <div class="col-sm-6">
                     
                      
                    
                       <div class="col-sm-12">
                        <div class="form-group">
                          <label for="">Reply date <span class="red">*</span></label>
                          <form:input type="date" class="form-control"  path="responsHearingDateId.responsDate"  required="true"/>
                        </div>
                      </div>
                      
                      
                       
                      
                   
                    </div>
                    
                    
                    <div class="col-sm-6">
                      
                       <div class="col-sm-12">
                        <div class="form-group">
                          <label for="">Upcoming hearing date <span class="red">*</span></label>
                          <form:input type="date" class="form-control"  path="responsHearingDateId.hearingDate"  required="true"/>
                        </div>
                      </div>
                      
                 
                    </div>
                    
                    
                  </div>
                 
             
              </div>
      </div>
      
      
      <div class="row setup-content" id="step-3">
        <div class="section-title margin-b50">
         
        </div>
        <div class="form">

							<div class="row">

								<div class="col-sm-6">
									<div class="col-sm-12">
										<div class="form-group">
											<label for="">Court Order date <span class="red">*</span></label>
											<form:input type="date" class="form-control"
												path="orderDate" required="true" />
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

                                     <div class="col-sm-12">
										<div class="form-group">
											<label>Others<span class="red">*</span>
											</label>
											<form:textarea path="others" class="form-control"
												rows="4" cols="" placeholder="Others" required="true"
												maxlength="500"></form:textarea>
										</div>
									</div>

								</div>


							</div>
						
							
						
					</div>
      </div>
      
      <div class="row setup-content" id="step-4">
        <div class="section-title margin-b50">
        <!--   <h2>Important Date</h2> -->
        </div>
        <div class="form">
               
                
              
				
                  <div class="row"> 
                  
                 <div class="form-group">
											 <c:if test="${caseRegistration.caseAttachments.size()!=0}">
									  <label for="">Case Attachments<span class="red">*</span></label>
									  </c:if>
									<c:forEach items="${caseRegistration.caseAttachments}" var="att" varStatus="i" begin="0" >
									<c:set var="counter_attachment" value="${caseRegistration.caseAttachments.size()}" scope="page" />
										     	<c:set var="count" value="${index0 = (i.index) }"	scope="page" />										     	
									<div class="input_fields_wrap_attachment" style="margin-top:10px;" >
									 <div class="row"><div class="col-sm-6"> 
									
									<form:input type="hidden" path="caseAttachments[${i.index}].id" class="field-long " />
									<form:input type="hidden" path="caseAttachments[${i.index}].caseId" class="field-long " />									
									<form:input type="text" placeholder="Title" path="caseAttachments[${i.index}].title" class="field-long form-control" />
									</div><div class="col-sm-3"> 	
									<form:input type="file" placeholder="Image" path="caseAttachments[${i.index}].fileAttachment" class="field-long form-control" />
									<form:hidden  path="caseAttachments[${i.index}].path" class="field-long form-control" />
									</div>
									<div class="col-sm-3"> 	
									<a href="${caseRegistration.caseAttachments[i.index].path }" target="_blank">View Attachment</a>
									</div>
									
								
									
									</div>
								
									</div>							     	
									</c:forEach>	 
									
								   	
											
									   <label for="">Case Attachments<span class="red">*</span></label>								     			                                    
									 <span><button type="button" class="add_field_button_attachment">Add Field</button></span>
									<span><button type="button" class="remove_field_button_attachment btn-primary">Remove Field</button></span>
									<div class="input_fields_wrap_attachment" style="margin-top:10px;" >
									<div class="row"><div class="col-sm-6"> 
									<form:input type="hidden" path="caseAttachments[${counter_attachment }].id" class="field-long " />
									<form:input type="text" placeholder="Attachment Title Name" path="caseAttachments[${counter_attachment }].title" class="field-long form-control" />
									</div><div class="col-sm-6"> 
									<form:input type="file" placeholder="Image" path="caseAttachments[${counter_attachment}].fileAttachment" class="field-long form-control" />
									</div>
									 </div>
									</div>	
										
              
                  </div>
                 
                                <div class="col-md-12 mrg-20" align="center"
								style="margin-top: 50px">
								<div class="effect-1">
									<input type="submit" class="btn btn-light btn-primary"
										name="Submit" />
								</div>
							</div>
              </div>
      </div>
      
      
    </div>
    </form:form>
  </div>
</div>
</div>
</div>
</div>


<%@include file="footer.jsp"%>
<script>
		function printDiv(divName){
			$('#uploadsDocsRemove').hide();
			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;
			document.body.innerHTML = "<html><head><title></title></head><body>" +printContents+"</body></html>";
			window.print();
			document.body.innerHTML = originalContents;
			$('#uploadsDocsRemove').show();
		}
	</script> 
<script>
	$(document).ready(function () {

    var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
                $item = $(this);

        if (!$item.hasClass('disabled')) {
            navListItems.removeClass('btn-green').addClass('btn-default');
            $item.addClass('btn-green');
            allWells.hide();
            $target.show();
            $target.find('input:eq(0)').focus();
        }
    });

    allNextBtn.click(function(){
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"), 
            curInputs = curStep.find("input[type='radio'],input[type='text'],input[type='url']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for(var i=0; i<curInputs.length; i++){
            if (!curInputs[i].validity.valid){
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid)
            nextStepWizard.removeAttr('disabled').trigger('click');
    });

    $('div.setup-panel div a.btn-green').trigger('click');
});
</script> 
<script>
	$(document).ready(function() {
    $("#add_row").on("click", function() {
        // Dynamic Rows Code
        
        // Get max row id and set new id
        var newid = 0;
        $.each($("#tab_logic tr"), function() {
            if (parseInt($(this).data("id")) > newid) {
                newid = parseInt($(this).data("id"));
            }
        });
        newid++;
        
        var tr = $("<tr></tr>", {
            id: "addr"+newid,
            "data-id": newid
        });
        
        // loop through each td and create new elements with name of newid
        $.each($("#tab_logic tbody tr:nth(0) td"), function() {
            var cur_td = $(this);
            
            var children = cur_td.children();
            
            // add new td and element if it has a nane
            if ($(this).data("name") != undefined) {
                var td = $("<td></td>", {
                    "data-name": $(cur_td).data("name")
                });
                
                var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
                c.attr("name", $(cur_td).data("name") + newid);
                c.appendTo($(td));
                td.appendTo($(tr));
            } else {
                var td = $("<td></td>", {
                    'text': $('#tab_logic tr').length
                }).appendTo($(tr));
            }
        });
        
        // add delete button and td
        /*
        $("<td></td>").append(
            $("<button class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>")
                .click(function() {
                    $(this).closest("tr").remove();
                })
        ).appendTo($(tr));
        */
        
        // add the new row
        $(tr).appendTo($('#tab_logic'));
        
        $(tr).find("td button.row-remove").on("click", function() {
             $(this).closest("tr").remove();
        });
});




    // Sortable Code
    var fixHelperModified = function(e, tr) {
        var $originals = tr.children();
        var $helper = tr.clone();
    

        $helper.children().each(function(index) {
            $(this).width($originals.eq(index).width())
        });
        
        return $helper;
    };
  
    $(".table-sortable tbody").sortable({
        helper: fixHelperModified      
    }).disableSelection();

    $(".table-sortable thead").disableSelection();



    $("#add_row").trigger("click");
});
</script> 
<!-- code for is socity or trust --> 
<script>
$(document).ready(function(){
	
	  if($("#selectSchoolType").val()!=""){
		 
		 var item=$("#selectSchoolType").val();
		
		 if(item==1){
	    	 $("#td1").html("Play School"); 
	    	 $("#td2").html("4000 sq.ft."); 
	    	 $("#td3").html("2500 sq.ft."); 
	    	 
	    }else if(item==2){
	    	
	    	 $("#td1").html("Primary School"); 
	    	 $("#td2").html("14000 sq.ft."); 
	    	 $("#td3").html("10000 sq.ft."); 
	    }else if(item==3){
	    	 $("#td1").html("Senior Secondary School"); 
	    	 $("#td2").html("2 Acre"); 
	    	 $("#td3").html("30000 sq.ft."); 
	    }else if(item==4){
	    	
	    	 $("#td1").html("International School"); 
	    	 $("#td2").html("2 Acre"); 
	    	 $("#td3").html("40000 sq.ft."); 
	    }else if(item==5){
	    	
	    	 $("#td1").html("Girls School"); 
	    	 $("#td2").html("2 Acre"); 
	    	 $("#td3").html("30000 sq.ft."); 
	    }else{ 
	    	 $("#td1").html("Play School"); 
	    	 $("#td2").html("4000 sq.ft."); 
	    	 $("#td3").html("2500 sq.ft."); 
   	 }
	}  
	
	
 	$('#selectSchoolType').change(function() {   
	    var item=$(this);
	 
	    if(item.val()==1){
	    	 $("#td1").html("Play School"); 
	    	 $("#td2").html("4000 sq.ft."); 
	    	 $("#td3").html("2500 sq.ft."); 
	    	 
	    }else if(item.val()==2){
	    	 $("#td1").html("Primary School"); 
	    	 $("#td2").html("14000 sq.ft."); 
	    	 $("#td3").html("10000 sq.ft."); 
	    }else if(item.val()==3){
	    	 $("#td1").html("Senior Secondary School"); 
	    	 $("#td2").html("2 Acre"); 
	    	 $("#td3").html("30000 sq.ft."); 
	    }else if(item.val()==4){
	    	
	    	 $("#td1").html("International School"); 
	    	 $("#td2").html("2 Acre"); 
	    	 $("#td3").html("40000 sq.ft."); 
	    }else if(item.val()==5){
	    	
	    	 $("#td1").html("Girls School"); 
	    	 $("#td2").html("2 Acre"); 
	    	 $("#td3").html("30000 sq.ft."); 
	    }else{ 
	    	 $("#td1").html("Play School"); 
	    	 $("#td2").html("4000 sq.ft."); 
	    	 $("#td3").html("2500 sq.ft."); 
   	 }
	   
	});

   $("#checkSociety").click(function(){
	  
 if($(this).is(":checked")) {
	 $("#isSociety").show(); 
	  $("#nameOfOrganization").attr("required","true");
	  $("#societyPinCode").attr("required","true");
	  $("#societyPhoneNo").attr("required","true");
	  $("#societyEmail").attr("required","true");
	  $("#societyWebsite").attr("required","true");
	  $("#societyAuthorizedPerson").attr("required","true");
	  $("#societyEmail").attr("required","true");
	  $("#societyAuthorizedPersonMobile").attr("required","true");
	  $("#societyPostalAddress").attr("required","true");
   }else{
	   $("#isSociety").hide(); 
	   $("#nameOfOrganization").attr("required","false");
		  $("#societyPinCode").attr("required","false");
		  $("#societyPhoneNo").attr("required","false");
		  $("#societyEmail").attr("required","false");
		  $("#societyWebsite").attr("required","false");
		  $("#societyAuthorizedPerson").attr("required","false");
		  $("#societyEmail").attr("required","false");
		  $("#societyAuthorizedPersonMobile").attr("required","false");
		  $("#societyPostalAddress").attr("required","false");
   }
});
   
   $("#checkRegistration").click(function(){
	 
 if($(this).is(":checked")) {
	 $("#isRegistered").show(); 
	  $("#yearRegistrationTrustSociety").attr("required","true");
	  $("#registrationNoTrustSociety").attr("required","true");
	  $("#periodUptoTrustSocietyValid").attr("required","true");
	
   }else{
	   $("#isRegistered").hide(); 
	   $("#yearRegistrationTrustSociety").attr("required","false");
		  $("#registrationNoTrustSociety").attr("required","false");
		  $("#periodUptoTrustSocietyValid").attr("required","false");
   }
});
   
   $("#isRegistrationBasicApproved").click(function(){
		 
	   if($(this).is(":checked")) {
	  	 $("#registrationBasicApproved").show(); 
	  	  $("#ddCheckCopyMultipart").attr("required","true");
	  	  $("#siteVisitDate").attr("required","true");
	  	 
	  	
	     }else{
	  	   $("#registrationBasicApproved").hide(); 
	  	  $("#ddCheckCopyMultipart").attr("required","false");
	  	  $("#siteVisitDate").attr("required","false");
	     }
	  });
   
 
   
   

  
});


</script> 
<script src="js/editor.js"></script> 
<script>
	$(document).ready(function() {
		
		$("#txtEditor").Editor();
	});
</script>
</body>
</html>