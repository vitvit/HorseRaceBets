<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>



</head>
<body>

	<div class="container">
		<%@ include file="layout/main.jsp"%>

		<form:form commandName="user"
			cssClass="form-horizontal registrationForm">

			<c:if test="${param.success eq true}">
				<div class="alert alert-success">
					<spring:message code="label.registrationsuccsessful" />
				</div>
			</c:if>

			<div class="form-group">
				<label for="username" class="col-sm-2 control-label"><spring:message
						code="label.name" /></label>
				<div class="col-sm-4">
					<form:input path="username" cssClass="form-control" />
					<form:errors path="username" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label"><spring:message
						code="label.email" /></label>
				<div class="col-sm-4">
					<form:input path="email" cssClass="form-control" />
					<form:errors path="email" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label"><spring:message
						code="label.password" /></label>
				<div class="col-sm-4">
					<form:password path="password" cssClass="form-control" />
					<form:errors path="password" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label"><spring:message
						code="label.passwordagain" /></label>
				<div class="col-sm-4">
					<input type="password" name="password_again" id="password_again"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-2">
					<input type="submit" value="Registrate!"
						class="btn btn-lg btn-custom" />
				</div>
			</div>
		</form:form>

		<%@ include file="layout/footer.jsp"%>
	</div>
	<script>
	$(document)
		.ready(
				function() {

					$(".registrationForm")
							.validate(
									{
										rules : {
											username : {
												required : true,
												minlength : 4,
												remote : {
													url : "<spring:url value='/registration/checkusername.html' />",
													type : "get",
													data : {
														username : function() {
															return $(
																	"#username")
																	.val();
														}
													}
												}
											},
											email : {
												required : true,
												email : true
											},
											password : {
												required : true,
												minlength : 5
											},
											password_again : {
												required : true,
												minlength : 5,
												equalTo : "#password"
											}
										},
										highlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-success')
													.addClass('has-error');
										},
										unhighlight : function(element) {
											$(element).closest('.form-group')
													.removeClass('has-error')
													.addClass('has-success');
										},
										messages : {
											username : {
												remote : "Such username already exists!"
											}
										}
									});
				});
	</script>
</body>
</html>