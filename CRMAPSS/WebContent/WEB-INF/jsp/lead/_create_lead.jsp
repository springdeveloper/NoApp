
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:url var="addAction" value="/lead/_createLead" />
<div class="clearfix"></div>
<div class="clearfix"></div>

<c:url var="findCountryURL" value="/common/api/getCountry" />
<c:url var="findStatesURL" value="/common/api/getState" />
<c:url var="findCityURL" value="/common/api/getCity" />

<form:form name="myForm" action="${addAction}" method="POST"
	commandName="lead" class="form-horizontal form-label-left">
						<form:hidden path="id" class="form-control" />
	
	<div class="row">
		<br />
		<div class="col-md-6 col-sm-12 col-xs-12 form-group">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.leadOwner" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="leadOwner" class="form-control" />
					<div class="alert-danger fade in">
						<span class="sr-only">Error:</span>
						<form:errors class="success" path='leadOwner' />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.firstName" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="firstName" class="form-control" />
					<div class="alert-danger fade in">
						<span class="sr-only">Error:</span>
						<form:errors class="success" path='firstName' />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.mobile" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="mobile" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.otherMobile" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="otherMobile" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.phone" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="phone" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.website" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="website" class="form-control" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.industry" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">

					<form:select path="industry" 	class="select2_single form-control">
					<form:options items="${Industrylist}" itemValue="id" itemLabel="description"></form:options>
					</form:select>
					
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.rating" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="rating" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.annualRevenue" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="annualRevenue" class="form-control" />
				</div>
			</div>

			<p>Adress</p>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.country" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:select path="countryName" id="country"
						class="select2_single form-control" tabindex="-1">
						<form:option value="0">Select Country</form:option>>
				
					
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.city" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:select path="cityName" id="city"
						class="select2_single form-control" tabindex="-1">
						<form:option value="0">Select City</form:option>>
					</form:select>
				</div>
			</div>

		</div>
		<!-- First Dive End -->
		<div class="col-md-6 col-sm-12 col-xs-12 form-group">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.lastName" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="lastName" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.company" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="company" class="form-control" />
				</div>
			</div>
         	<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.emails" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="emails" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.otherEmail" /> </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="otherEmail" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.skypeId" /> </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="skypeId" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.leadSource" /> </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:select path="leadSource" class="select2_single form-control"
						tabindex="-1">
						<form:options items="${source_list}" itemValue="id" itemLabel="sourceName"/>
					</form:select>

				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.leadStatus" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
				
					<form:select path="LeadStatus" class="select2_single form-control">
					<form:options items="${leadStatus}" itemValue="id" itemLabel="fullName" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.noOfEmployee" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="noOfEmployee" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.twiterId" /> </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="twiterId" class="form-control" />
				</div>
			</div>
			<p>Details</p>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.state" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">

					<form:select path="stateName" id="state"
						class="select2_single form-control" tabindex="-1">
							<form:option value="0">Select State</form:option>>
					</form:select>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.postalCode" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="postalCode" class="form-control" />
				</div>
			</div>

		</div>
		<!-- Second Div End -->
	</div>
	<div class="row">
		<div class="col-md-6 col-sm-12 col-xs-12 form-group">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.leadDescription" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:textarea path="leadDescription"
						class="resizable_textarea form-control"
						style="width: 200%; overflow: hidden; word-wrap: break-word; resize: horizontal; height: 70px;" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-12">
					<button type="submit" class="btn btn-primary">
						<spring:message code="button.cancel" />
					</button>
					<form:button class="btn btn-success">
						<spring:message code="button.submit" />
					</form:button>
				</div>
			</div>


		</div>

	</div>

</form:form>
<script type="text/javascript">
$(document).ready(function() {
$.getJSON('${findCountryURL}', {
ajax : 'true'
}, function(data) {
var html 
var ids=${lead.countryName}-1
if(ids=="-1"){
 html = '<option value="">Country</option>';
 
}else{
var cids=${lead.countryName}
getSateDropDownByCountryId(cids);	
var ids=${lead.countryName}-1
html =  '<option value="' + data[ids].id + '">'
+ data[ids].countryName + '</option>';
}
var len = data.length;
for (var i = 0; i < len; i++) {
html += '<option value="' + data[i].id + '">'
+ data[i].countryName + '</option>';
							}
html += '</option>';
$('#country').html(html);});
function getObjects(obj, key, val) {
    var objects = [];
    for (var i in obj) {
        if (!obj.hasOwnProperty(i)) continue;
        if (typeof obj[i] == 'object') {
            objects = objects.concat(getObjects(obj[i], key, val));
        } else if (i == key && obj[key] == val) {
            objects.push(obj);
        }
    }
    return objects;
}
function getKeyAndKeyValue(obj, key, val) 
{
    var newObj = false; 
    $.each(obj, function()
    {
        var testObject = this; 
        $.each(testObject, function(k,v)
        {
            //alert(k);
            if(val == v && k == key)
            {
                newObj = testObject;
            }
        });
    });
    return newObj;
}
function getSateDropDownByCountryId(countryId){

$.getJSON('${findStatesURL}', {
    id : countryId
}, function(data) {
	var html 
	var ids=${lead.stateId}	
	if(ids=="-1"){
	 html = '<option value="">State</option>';
	 
	}else{
		var sid=${lead.stateId}
		getCityDropDownByStateId(sid);
	html =  '<option value="' +getKeyAndKeyValue(data,'id',ids).id + '">'
	+ getKeyAndKeyValue(data,'id',ids).stateName + '</option>';
	}
var len = data.length;
for (var i = 0; i < len; i++) {
html += '<option value="' + data[i].id + '">'
 + data[i].stateName + '</option>';
} html += '</option>';
 $('#state').html(html);
});
}
function getCityDropDownByStateId(stateId){

$.getJSON('${findCityURL}', {
    id :stateId
}, function(data) {

	var html 
	var idss=${lead.cityId}
	if(idss=="-1"){
	 html = '<option value="">City</option>'; 
	}else{
	var ids=${lead.cityId}
	html =  '<option value="' +getKeyAndKeyValue(data,'id',ids).id+ '">'
	+getKeyAndKeyValue(data,'id',ids).cityName + '</option>';
	}
var len = data.length;
for (var i = 0; i < len; i++) {
html += '<option value="' + data[i].id + '">'
 + data[i].cityName + '</option>';
} html += '</option>';
 $('#city').html(html);
});
}



						$('#country')
								.change(
										function() {
											$
													.getJSON(
															'${findStatesURL}',
															{
																id : $(this)
																		.val()
															},
															function(data) {
																var html = '<option value="">State Name</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].id + '">'
																			+ data[i].stateName
																			+ '</option>';
																}
																html += '</option>';

																$('#state')
																		.html(
																				html);
															});
										});

						$('#state')
								.change(
										function() {
											$
													.getJSON(
															'${findCityURL}',
															{
																id : $(this)
																		.val()
															},
															function(data) {
																var html = '<option value="">City Name</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].id + '">'
																			+ data[i].cityName
																			+ '</option>';
																}
																html += '</option>';

																$('#city')
																		.html(
																				html);
															});
										});
					});
</script>