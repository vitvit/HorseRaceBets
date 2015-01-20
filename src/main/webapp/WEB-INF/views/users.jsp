<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="layout/main.jsp"%>

		<script type="text/javascript">
			$(document).ready(
					function() {
						$(".triggerRemove").click(
								function(e) {
									e.preventDefault();
									$("#modalRemove .removeBtn").attr("href",
											$(this).attr("href"));
									$("#modalRemove").modal();
								});
					});
		</script>
		<c:if test="${!empty users}">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="label.username" /></th>
						<th><spring:message code="label.operation" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td><a href="<spring:url value="/users/${user.id}.html" />">
									<c:out value="${user.username}" />
							</a></td>
							<td><a
								href="<spring:url value="/users/remove/${user.id}.html" />"
								class="btn btn-danger triggerRemove"> <spring:message
										code="label.remove" /></a></td>
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