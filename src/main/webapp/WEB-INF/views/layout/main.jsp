
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Static navbar -->
<div class="navbar navbar-custom" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<spring:url value="/" />"> <img alt="Brand"
				src="<spring:url value="/resources/images/logo.png"/>">
			</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="${current == 'index' ? 'active' : ''}"><a
					href='<spring:url value="/" />'><spring:message
							code="label.main" /></a></li>
				<security:authorize access="hasRole('ADMIN')">
					<li class="${current == 'users' ? 'active' : ''}"><a
						href="<spring:url value="/users.html" />"><spring:message
								code="label.users" /></a></li>
				</security:authorize>
				<security:authorize access="hasRole('ADMIN')">
					<li class="${current == 'horsemanager' ? 'active' : ''}"><a
						href="<spring:url value="/horsemanager.html" />"><spring:message
								code="label.horses" /></a></li>

				</security:authorize>
				<security:authorize access="hasRole('ADMIN')">
					<li class="${current == 'horsemanager' ? 'active' : ''}"><a
						href="<spring:url value="/racing.html" />"><spring:message
								code="label.racing" /></a></li>

				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="${current == 'account' ? 'active' : ''}"><a
						href="<spring:url value="/account.html" />"><spring:message
								code="label.mybets" /></a></li>
				</security:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="! isAuthenticated()">
					<li class="${current == 'login' ? 'active' : ''}"><a
						href="<spring:url value="/login" />"><spring:message code="label.login" /><span
							class="glyphicon glyphicon-log-in"></span></a></li>
					<li class="${current == 'register' ? 'active' : ''}"><a
						href="<spring:url value="/registration.html" />">
						<spring:message code="label.registration" /><span
							class="glyphicon glyphicon-pencil"></span></a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href="<spring:url value="/logout" />"><span
							class="glyphicon glyphicon-off"></span>
						<spring:message code="label.logout" /></a></li>
				</security:authorize>

			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</div>




