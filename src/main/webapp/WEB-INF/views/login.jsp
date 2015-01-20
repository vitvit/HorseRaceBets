<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%@ include file="layout/main.jsp"%>

		<form class="form-signin" role="form"
			action="<spring:url value="/j_spring_security_check" />"
			method="POST">
			<h2 class="form-signin-heading">
				<spring:message code="label.pleasesignin" />
			</h2>
			<input type="text" name="j_username" class="form-control"
				placeholder="Name" required autofocus> <input
				type="password" name="j_password" class="form-control"
				placeholder="Password" required>
			<button class="btn btn-lg btn-custom btn-block" type="submit">
				<spring:message code="label.signin" />
			</button>
		</form>
		<%@ include file="layout/footer.jsp"%>
	</div>
</body>
</html>