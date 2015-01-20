<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="layout/main.jsp"%>
		<h1>
			<c:out value="${horse.horseName}" />
		</h1>
		<br /> <br />

		<!-- Nav tabs -->
		<c:if test="${!empty bets}">
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th><spring:message code="label.horse" /></th>
					<th><spring:message code="label.betvalue" /></th>
					<th><spring:message code="label.date" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${horse.bets}" var="bet">
					<tr>
						<td><c:out value="${bet.user.username}" /></td>
						<td><c:out value="${bet.betValue}" /></td>
						<td><c:out value="${bet.date}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>

	
		<%@ include file="layout/footer.jsp"%>
	</div>
</body>
</html>