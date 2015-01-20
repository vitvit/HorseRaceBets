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
			<c:out value="${user.username}" />
		</h1>
		<br /> <br />
		<script type="text/javascript">
			$(document).ready(
					function() {
						$('.nav-tabs a:first').tab('show');
						$(".triggerRemove").click(
								function(e) {
									e.preventDefault();
									$("#modalRemove .removeBtn").attr("href",
											$(this).attr("href"));
									$("#modalRemove").modal();
								});
					});
		</script>
		<!-- Nav tabs -->
		<c:if test="${!empty bets}">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="label.horse" /></th>
						<th><spring:message code="label.betvalue" /></th>
						<th><spring:message code="label.date" /></th>
						<th><spring:message code="label.remove" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${user.bets}" var="bet">
						<tr>
							<td><c:out value="${bet.horse.horseName}" /></td>
							<td><c:out value="${bet.betValue}" /></td>
							<td><c:out value="${bet.date}" /></td>
							<td><a
								href="<spring:url value="/bet/delete/${bet.id}.html" />"
								class="btn btn-danger triggerRemove"> <spring:message
										code="label.remove" />
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<!-- Modal -->
		<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">
							<spring:message code="label.remove" />
						</h4>
					</div>
					<div class="modal-body">
						<spring:message code="label.reallyremove" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<spring:message code="label.cancel" />
						</button>
						<a href="" class="btn btn-danger removeBtn"><spring:message
								code="label.remove" /></a>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="layout/footer.jsp"%>
	</div>
</body>
</html>