<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<title>Search</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="css/app.css">
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<form:form class="form-horizontal" role="form" method="post" action="searchContact" modelAttribute="contact">
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName">First Name:</label>
				<div class="col-sm-4">
					<form:input type="text" class="form-control" id="firstName" path="firstName" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Last Name:</label>
				<div class="col-sm-4">
					<form:input type="text" class="form-control" id="lastName" path="lastName" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgName">Organisation Name:</label>
				<div class="col-sm-4">
					<form:input type="text" class="form-control" id="orgName" path="org.name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Search</button>
				</div>
			</div>
		</form:form>
	</div>

	<div class="container">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Organisation</th>
					<th>Date Created</th>
					<th>View Contact</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.firstName} &nbsp; ${contact.lastName}</td>
						<td>${webUtil.formatNameWithABN(contact.org)} </td>
						<td>${webUtil.formatDate(contact.createdDate)}</td>
						<td><a href='viewContact?contactId=${contact.id}'>
								<button class="btn btn-default">View</button>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>