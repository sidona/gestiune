/**
 * Created by sdonose on 2/11/2016.
 */

"use strict";

angular.module('myApp', ['ui.router', 'ngResource']);

angular.module('myApp').config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state('product', {
            url: '/product',
            templateUrl: "resources/js/views/product.jsp"
        });
    $stateProvider
        .state('addProduct', {
            url: '/product/addProduct',
            templateUrl: "resources/js/views/addProduct.jsp"
        });
    $stateProvider
        .state('productDetail', {
            url: '/product/:productId',
            templateUrl: "resources/js/views/productDetail.jsp",
            controller: 'productDetailCtrl'
        })
});
