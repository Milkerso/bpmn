<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/complete_visit_details.css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
</head>
<body>
<form id="PersonalDataForm" action="/visit" method="POST">
    <div class="container">
        <form role="form">
            <h2>Complete Visit Details</h2>
            <div class="form-group" style="margin-top:15px;">
                <label for="urgent" class="col-sm-5 control-label">Urgent Examination</label>
                <label><input type="checkbox" id="urgent" name="urgent"> Check</label>
            </div>
            <div class="form-group">
                <label for="specialization" class="col-sm-12 control-label">Pick specialization</label>
                <div class="col-sm-12">
                    <select name="specialization" id="specialization">
                        <option value="1">Dentist</option>
                        <option value="2">Surgeon</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="doctor" class="col-sm-3 control-label">Pick doctor</label>
                <div class="col-sm-12">
                    <select class="full-width" name="doctor" id="doctor">
                        <option value="1">Dr Pepper</option>
                        <option value="2">Dr Oetker</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="NFZ" class="col-sm-5 control-label">NFZ</label>
                <label><input type="checkbox" id="NFZ" name="NFZ"> Check</label>
            </div>
                <div class="row">
                    <div class="col-sm">
                    <button type="submit" class="btn btn-primary btn-block" action="/visitdetails" >Save</button>
                    </div>
                    <div class="col-sm">
                        <button type="button" class="btn btn-primary btn-block"
                                onclick="window.location.href='${pageContext.request.contextPath}/form'">Reject</button>
                    </div>
                </div>
        </form>
    </div> <!-- ./container -->

</form> <!-- /form -->
</body>
</html>






