<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>시술 목록</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/resources/assets/css/bootstrap.min.css' />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/resources/themes/dashboard.css' />" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<c:url value='/resources/assets/js/ie8-responsive-file-warning.js'/> "></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        <!--
        function fnWrite() {
            window.location.href = "<c:url value='/hairProcedure/${customerId}/write' />";
        }
        //-->
    </script>

</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">시술 목록</h1>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>시술명</th>
                        <th>시술일</th>
                        <th>노트</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="hairProcedure" items="${hairProcedureList}" varStatus="loop">
                        <tr>
                            <td><a href="<c:url value="/hairProcedure/${hairProcedure.customerId}/${hairProcedure.hairProcedureId}" />">${hairProcedure.hairProcedureName}</a></td>
                            <td>${hairProcedure.hairProcedureDate}</td>
                            <td>${hairProcedure.note}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="span9 text-right">
                <button class="btn" onclick="window.location.herf=fnWrite();">새글</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
