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
    return $resource('http://localhost:8080/product/:id',{id:'productId'},
        {
            post:{method:'POST'}
        })
});