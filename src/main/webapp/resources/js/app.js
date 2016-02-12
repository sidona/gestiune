/**
 * Created by sdonose on 2/11/2016.
 */

"use strict";

angular.module('myApp', [ 'ngResource','ui.router']);

angular.module('myApp').config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state('addProduct',{
            url:"/addProduct",
            templateUrl:"resources/js/views/addProduct.jsp"
        })
})
