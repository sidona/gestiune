<%--
  Created by IntelliJ IDEA.
  User: sdonose
  Date: 2/12/2016
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div ng-controller="productCtrl">

    <div>
        <div>
            <button class="btn btn-default" style="margin-bottom: 20px"><a ui-sref="addProduct">Add product</a></button>
        </div>
        <div id="editor"></div>
        <button class="btn btn-primary" ng-click="exportPdf()" id="cmd">ia</button>
    </div>

    <div id="pdf">
        <table class="table table-bordered" id="tableProduct">
            <tr style="text-align: center">
                <td>Id</td>
                <td>Product</td>
                <td>Price</td>

            </tr>
            <tr ng-repeat="product in products">
                <td ng-repeat="prod in products.0">{{prod}}</td>
                <td><a ui-sref="productDetail({productId:product.productId})"> {{product.name}}</a></td>
                <td>{{product.price}}</td>

            </tr>
{{products}}
            {{prod}}
<div ng-repeat="p in products"> p==={{p[0]}}
    <div ng-repeat="produ in p[1]"> snajsns {{produ}} </div>
</div>

        </table>
    </div>

</div>