/**
 * Created by sdonose on 2/11/2016.
 */
"use strict";
angular.module('myApp').controller('productCtrl', function ($scope, product) {
        product.query(function (data) {
            $scope.products = data;
        })
    })