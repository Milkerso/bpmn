<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/personal_data_form.css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
</head>
<body>
<form id="PersonalDataForm" action="/visitdetails" method="POST">
<div class="container">
    <form role="form" style="background-color: black">
            <h2>Personal Data Form</h2>
        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label">First Name</label>
            <div class="col-sm-12">
                <input type="text" id="firstName" name="firstName" path="firstName" class="form-control" placeholder="First Name" required>
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="col-sm-3 control-label">Last Name</label>
            <div class="col-sm-12">
                <input type="text" id="lastName" name="lastName" path="lastName" class="form-control" placeholder="Last name" required>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-12">
                <input type="email" id="email" name="email" path="email" class="form-control" placeholder="Email" required>
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-3 control-label">Address</label>
            <div class="col-sm-12">
                <input type="text" id="address" name="address" path="address" class="form-control" placeholder="Address" required>
            </div>
        </div>
        <div class="form-group">
            <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
            <div class="col-sm-12">
                <input type="date" id="birthDate" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm">
            <label for="phoneNumber" class="col-sm-12 control-label">Phone number</label>
                    <div class="col-sm-12">
                <input type="phoneNumber" id="phoneNumber" name="phoneNumber" placeholder="000-000-000" pattern="[0-9]{3}-[0-9]{3}-[0-9]{3}" required>
                    </div>
            </div>
            <div class="col-sm">
                <label for="gender" class="col-sm-12 control-label">Pick gender</label>
                <div class="col-sm-12">
                <select name="gender" id="gender">
                    <option value="1">Male</option>
                    <option value="2">Female</option>
                </select>
                </div>
            </div>
        </div>
        </div><!-- /.form-group -->
        <button type="submit" class="btn btn-primary btn-block">Save</button>
        </form>
</div> <!-- ./container -->

</form> <!-- /form -->
</body>
</html>






