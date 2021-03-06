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
<form id="PersonalDataForm" action="/medicalsummary" method="POST">
    <div class="container">
        <form role="form">
            <h2>Medical Summary</h2>
            <div class="form-group" style="margin-top:15px;">
                <div class="row">
                <label class="col-sm-8 control-label">Doctor</label>
                <label class="col-sm-4">Jakiś lekarz</label>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                <label class="col-sm-8 control-label">Picked specialization</label>
                <label class="col-sm-4">Jakaś specjalizacja</label>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                <label class="col-sm-8 control-label">Picked term</label>
                <label class="col-sm-4">Jakiś termin</label>
                </div>
            </div>
            <div class="form-group" style="margin-top:15px;">
                <div class="row">
                <label for="urgent" class="col-sm-8 control-label">Urgent Examination</label>
                <label class="col-sm-4"><input type="checkbox" id="urgent" name="urgent"> Check</label>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                <label for="NFZ" class="col-sm-8 control-label">NFZ</label>
                <label class="col-sm-4"><input type="checkbox" id="NFZ" name="NFZ"> Check</label>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <button type="submit" class="btn btn-primary btn-block" action="/medicalsummary" >Save</button>

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






