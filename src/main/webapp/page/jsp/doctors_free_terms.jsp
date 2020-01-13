<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/doctors_free_terms.css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
</head>
<body>
<c:set var="licznik" value="${recordStartCounter }"/>
<script type="text/javascript">
    window.onload=function(){

        $('.check input:checkbox').click(function() {
            $('.check input:checkbox').not(this).prop('checked', false);
        });

    }
</script>
<div align="center">
    <div style="margin-top:100px;" class="container">
        <form role="form">
        <div class="row">
            <div class="col-sm-12 col-sm-offset-1">

                <div class="panel panel-default panel-table">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col col-xs-12" style="margin-bottom:15px;">
                                <h3  style="text-align:center;" class="panel-title">Doctor's Free Terms</h3>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table style="vertical-align: middle; text-align: center;" class="table table-striped table-bordered table-list">
                            <thead>
                            <tr>
                               <th class="hidden-xs text-center">Date</th>
                                <th class="text-center">Hour</th>
                                <th class="text-center">Room</th>
                                <th class="text-center">Choose</th>
                                <th class="text-center">Pick term</th>
                            </tr>
                            </thead>
                            <tbody>
<%--                            <c:forEach var="u" items="${userList }">--%>
<%--                                <c:set var="licznik" value="${licznik+1}"/>--%>
                                <tr>
                                    <td style="vertical-align: middle; text-align: center;" class="hidden-xs"><%--<c:out value="${u.id }" />--%>10.01.2020</td>
                                    <td style="vertical-align: middle; text-align: center;" class="hidden-xs"><%--<c:out value="${u.id }" />--%>14:00</td>
                                    <td style="vertical-align: middle; text-align: center;"><%--<c:out value="${u.id }" />--%>203</td>
                                    <td style="vertical-align: middle; text-align: center;"><label class="checkbox-inline check"><input type="checkbox" name="choose" value="1"> Choose this term</label></td>
                                </tr>
                                <tr>
                                    <td style="vertical-align: middle; text-align: center;" class="hidden-xs"><%--<c:out value="${u.id }" />--%>11.01.2020</td>
                                    <td style="vertical-align: middle; text-align: center;" class="hidden-xs"><%--<c:out value="${u.id }" />--%>8:00</td>
                                    <td style="vertical-align: middle; text-align: center;"><%--<c:out value="${u.id }" />--%>410</td>
                                    <td style="vertical-align: middle; text-align: center;"><label class="checkbox-inline check"><input type="checkbox" name="choose" value="2"> Choose this term</label></td>
                                </tr>
<%--                            </c:forEach>--%>
                            </tbody>
                        </table>

                    </div>

                </div>
                <div class="row">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-primary btn-block" action="/visitdetails" >Save</button>
                    </div>
                    <div class="col-sm">
                        <button type="button" class="btn btn-primary btn-block"
                                onclick="window.location.href='${pageContext.request.contextPath}/form'">Reject</button>
                                onclick="window.location.href='${pageContext.request.contextPath}/visitdetails'">Reject</button>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>

</body>
</html>






