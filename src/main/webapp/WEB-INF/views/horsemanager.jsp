<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="layout/main.jsp"%>

		<form:form method="post" commandName="horse">
			<div class="form-group">

				<form:label path="horseName" class="col-sm-2 control-label">
					<spring:message code="label.horsename" />
				</form:label>
				<div class="col-sm-10">
					<form:input path="horseName" cssClass="form-control" />
					<form:errors path="horseName" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="koeficient" class="col-sm-2 control-label">
					<spring:message code="label.koeficient" />
				</form:label>
				<div class="col-sm-10">
					<form:input path="koeficient" cssClass="form-control" />
					<form:errors path="koeficient" />
				</div>
			</div>


			<input type="submit" value="<spring:message code="label.addhorse" />"
				class="btn btn-custom" />


		</form:form>

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

		<c:if test="${!empty horseList}">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="label.horse" /></th>
						<th><spring:message code="label.operation" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${horseList}" var="horse">
						<tr>
							<td><c:out value="${horse.horseName}" /></td>
							<td><a
								href="<spring:url value="/horsemanager/${horse.id}.html" />"
								class="btn btn-info triggerInfo"> <spring:message
										code="label.horseinfo" /></a> <a
								href="<spring:url value="/horsemanager/delete/${horse.id}.html" />"
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

		<div class="modal fade" id="modalInfo" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">
							<spring:message code="label.horseinfo" />
						</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label"><spring:message
									code="label.horse" /></label>
							<div class="col-sm-10">
								<c:out value="${horse.horseName}" />
							</div>
						</div>
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
