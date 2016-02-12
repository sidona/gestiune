/**
 * Created by sdonose on 2/11/2016.
 */


angular.module('myApp')
    .controller('addProductCtrl', function ($scope, addProduct, $state) {
        $scope.newProduct = new addProduct();

        $scope.addProduct = function () {
            $scope.newProduct.$save(function () {
                $state.go('/')
            })
        }
    });