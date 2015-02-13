<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>

</head>
<body>

	<div class="container">
		<%@ include file="layout/main.jsp"%>

		<form:form method="post" commandName="racing">

			<label for="name" class="col-sm-2 control-label"><spring:message
					code="label.date" /></label>
			<div class="col-sm-2">

				<form:input type="date" path="date" cssClass="form-control"
					name="date" />
				<form:errors path="date" />
			</div>

			<br />
			<br />

			<label for="hippoodrome" class="col-sm-2 control-label"><spring:message
					code="label.hippodrome" /></label>
			<div class="col-sm-2">

				<form:input name="birthDate" path="hippodrome"
					cssClass="form-control" />
				<form:errors path="hippodrome" />
			</div>

			<br />
			<br />

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"><spring:message
						code="label.horses" /></label> <br />

				<div class="col-sm-2">
					<c:forEach items="${racing.horses}" var="horse" varStatus="status">
						<form:select path="horses[${status.index }].id"
							cssClass="form-control">
							<form:option value="0" cssClass="form-control">
								<spring:message code="label.horses" />
							</form:option>
							<form:options items="${horseList}" itemValue="id"
								itemLabel="horseName" />
						</form:select>
						<br/>
					</c:forEach>
				</div>
			</div>



			<div class="col-sm-10">
				<input type="submit"
					value="<spring:message code="label.addracing" />"
					class="btn btn-custom" />
					
			</div>
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

		<c:if test="${!empty listRacing}">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="label.date" /></th>
						<th><spring:message code="label.hippodrome" /></th>
						<th><spring:message code="label.operation" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listRacing}" var="racing">
						<tr>
							<td><c:out value="${racing.date}" /></td>
							<td><c:out value="${racing.hippodrome}" /></td>
							<td><a
								href="<spring:url value="/racing/delete/${racing.id}.html" />"
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
