<!DOCTYPE html>

<%@ include file="layout/taglib.jsp"%>

<html lang="en">
<head>
<%@ include file="layout/head.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="layout/main.jsp"%>
		
		<c:if test="${!empty listRacing}">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="label.date" /></th>
						<th><spring:message code="label.hippodrome" /></th>
						<th><spring:message code="label.bet" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listRacing}" var="racing">
						<tr>
							<td><c:out value="${racing.date}" /></td>
							<td><c:out value="${racing.hippodrome}" /></td>
							<td><a
								href="<spring:url value="/account/bet.html" />"
								class="btn btn-danger triggerRemove"> <spring:message
										code="label.remove" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<!-- Button trigger modal -->
		<button class="btn btn-custom btn-lg" data-toggle="modal"
			data-target="#myModal">
			<spring:message code="label.newbet" />
		</button>


		<form:form commandName="bet" cssClass="form-horizontal blogForm">
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">
								<spring:message code="label.newbet" />
							</h4>
						</div>
						<div class="modal-body">

							<div class="form-group">
								<label for="name" class="col-sm-2 control-label"><spring:message
										code="label.horse" /></label>
								<div class="col-sm-10">
									<form:select path="horse.id">
										<form:option value="0" class="form-control">
											<spring:message code="label.horses" />
										</form:option>
										<form:options items="${horseList}" itemValue="id"
											itemLabel="horseName" />
									</form:select>
									<form:errors path="horse" />
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label"><spring:message
										code="label.betvalue" /></label>
								<div class="col-sm-10">

									<form:input path="betValue" />
									<form:errors path="betValue" />
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<spring:message code="label.close" />
							</button>
							<input type="submit" class="btn btn-primary" value="Bet!" />
						</div>
					</div>
				</div>
			</div>
		</form:form>

		<br /> <br />
		<script type="text/javascript">
			$(document).ready(
					function() {
						$('.nav-tabs a:first').tab('show'); // Select first tab
						$(".triggerRemove").click(
								function(e) {
									e.preventDefault();
									$("#modalRemove .removeBtn").attr("href",
											$(this).attr("href"));
									$("#modalRemove").modal();
								});
						$(".blogForm").validate(
								{
									rules : {
										name : {
											required : true,
											minlength : 1
										},
										url : {
											required : true,
											url : true
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
									}
								});
					});
		</script>



		<!-- Tab panes -->
		<div class="tab-content">
		<c:if test="${!empty betList}">
			<h3>
				<spring:message code="label.mybets" />
			</h3>
	
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th><spring:message code="label.name" /></th>
						<th><spring:message code="label.betvalue" /></th>
						<th><spring:message code="label.date" /></th>
						<th><spring:message code="label.remove" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${betList}" var="bet">
						<tr>
							<td><c:out value="${bet.horse.horseName}" /></td>
							<td><c:out value="${bet.betValue}" /></td>
							<td><c:out value="${bet.date}" /></td>
							<td><a href="bet/delete/${bet.id}"
								class="btn btn-danger triggerRemove"><spring:message
										code="label.remove" /> </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>

		<%@ include file="layout/footer.jsp"%>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<spring:message code="label.removebet" />
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

</body>
</html>





