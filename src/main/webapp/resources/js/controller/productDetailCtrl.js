/**
 * Created by sdonose on 2/12/2016.
 */
"use strict";
angular.module('myApp')
    .controller('productDetailCtrl', function ($scope, $stateParams, detailProduct) {
        $scope.detailProduct = detailProduct.get({productId: $stateParams.productId})
    });