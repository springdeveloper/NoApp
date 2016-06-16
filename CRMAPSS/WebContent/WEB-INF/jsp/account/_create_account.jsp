<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:url var="addAction" value="/acc/_create_account" />
<div class="clearfix"></div>
<div class="clearfix"></div>

<c:url var="findCountryURL" value="/common/api/getCountry" />
<c:url var="findStatesURL" value="/common/api/getState" />
<c:url var="findCityURL" value="/common/api/getCity" />

<form:form name="myForm" action="${addAction}" method="POST"
	commandName="account" class="form-horizontal form-label-left">
						<form:hidden path="id" class="form-control" />
	
	<div class="row">
		<br />
		<div class="col-md-6 col-sm-12 col-xs-12 form-group">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.accountName" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:input path="accountName" class="form-control" />
					<div class="alert-danger fade in">
						<span class="sr-only">Error:</span>
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

		
			<p>Adress</p>

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
       </div></div>
	<div class="row">
		<div class="col-md-6 col-sm-12 col-xs-12 form-group">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"><spring:message
						code="label.leadDescription" /></label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<form:textarea path="annualRevenue"
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