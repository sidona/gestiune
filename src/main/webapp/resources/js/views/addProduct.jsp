<%--
  Created by IntelliJ IDEA.
  User: sdonose
  Date: 2/11/2016
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div ng-controller="addProductCtrl" style="width: 600px">
    <form class="form-horizontal" ng-submit="addProduct()">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input type="text" ng-model="newProduct.name" class="form-control" id="name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">Price</label>

            <div class="col-sm-10">
                <input type="text" ng-model="newProduct.price" class="form-control" id="price"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-primary" value="Save"/>
            </div>
        </div>
    </form>
</div>