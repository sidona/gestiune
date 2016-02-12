<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/main.css">

    <script src="<c:url value="/resources/lib/jquery-1.12.0.min.js"/>"></script>
    <script src="<c:url value="/resources/lib/jspdf.min.js"/>"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>


    <script type="text/javascript" src="<c:url value="/resources/lib/angular.js"/>"></script>
    <script src="<c:url value="/resources/lib/angular-resource.js"/>"></script>
    <script src="<c:url value="/resources/lib/angular-ui-router.min.js"/>"></script>
    <script src="<c:url value="resources/js/app.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/productCtrl.js"/>"></script>
    <script src="<c:url value="/resources/js/service/product.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/addProductCtrl.js"/>"></script>
    <script src="<c:url value="/resources/js/controller/productDetailCtrl.js"/>"></script>





</head>
<body ng-app="myApp">
<h2>Hello World!</h2>

<div class="container" ng-cloak>
    <div ng-include="'resources/js/views/header.jsp'"></div>

    <div class="row">
        <div class="ui-view-container">
            <div ui-view></div>
        </div>
    </div>
</div>


</body>

</html>
