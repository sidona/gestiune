/**
 * Created by sdonose on 2/11/2016.
 */
"use strict";


angular.module('myApp').service('product',function($resource){
    return $resource('http://localhost:8080/getAllProduct')

});
angular.module('myApp').service('addProduct',function($resource){
    return $resource('http://localhost:8080/newProduct',
    {
       post:{method:'POST'}
    })
});

angular.module('myApp').service('detailProduct',function($resource){
    return $resource('http://localhost:8080/productList/:productId',{productId:'productId'},
        {
            post:{method:'POST'}
        })
});



angular.module('myApp').service('deleteProduct',function($resource){
    return $resource('http://localhost:8080/deleteProduct/:name',{name:'name'},
        {
            post:{method:'POST'},
            remove:{method:'DELETE'}
        })
});