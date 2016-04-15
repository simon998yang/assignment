<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<title>Edit</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="css/app.css">
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<form:form class="form-horizontal" role="form" method="post" action="editContact?contactId=${contact.id}"
			modelAttribute="contact">
			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName">First Name:</label>
				<div class="col-sm-4">
					<form:input type="text" class="form-control" id="firstName" path="firstName" maxlength="30" required="true" />
					<div class="has-error">
						<form:errors path="firstName" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName">Last Name:</label>
				<div class="col-sm-4">
					<form:input type="text" class="form-control" id="lastName" path="lastName" maxlength="30" required="true" />
					<div class="has-error">
						<form:errors path="lastName" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgId">Organisation Name:</label>
				<div class="col-sm-4">
					<form:select class="form-control" id="orgId" path="org.id" items="${orgMap}" />
					<div class="has-error">
						<form:errors path="org.id" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-1">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
				<div class="col-sm-1">
					<a href="viewContact?contactId=${contact.id}"><button type="button" class="btn btn-default">Cancel</button></a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>