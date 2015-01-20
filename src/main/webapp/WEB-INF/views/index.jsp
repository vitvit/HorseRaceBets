<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="layout/main.jsp"%>
		<div class="content">
			<h1>
				<spring:message code="label.title" />
			</h1>
			<spring:message code="label.indexcontent" />
	
			<div class="img">
				<img src="<spring:url value="/resources/images/horse.jpg"/>" />
			</div>
		</div>
		<%@ include file="layout/footer.jsp"%>
	</div>
</body>
</html>