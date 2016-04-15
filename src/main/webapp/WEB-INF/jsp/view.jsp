<!DOCTYPE html>
<html lang="en">
<title>View</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="css/app.css">
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName">First Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="firstName" value="${contact.firstName}" disabled />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Last Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="lastName" value="${contact.lastName}" disabled />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgName">Organisation Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="orgName" value="${contact.org.name}" disabled />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="abn">Organisation ABN:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="abn" value="${webUtil.formatABN(contact.org.abn)}" disabled />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="createdDate">Created:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="createdDate" value="${webUtil.formatDateTime(contact.createdDate)}"
						disabled />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="editContact?contactId=${contact.id}"><button type="button" class="btn btn-default">Edit</button></a>
				</div>
			</div>
		</form>

	</div>
</body>
</html>