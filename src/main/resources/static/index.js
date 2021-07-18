angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http({
            url: 'http://localhost:8189/shop/products',
            method: 'GET',
            params: {}
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data;
        });
    };

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: 'http://localhost:8189/shop/products_page',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data.content;
        });
    };

    $scope.showProductInfo = function (productIndex) {
        $http({
            url: 'http://localhost:8189/shop/products/' + productIndex,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    };

    $scope.deleteProduct = function (productIndex) {
        $http({
            url: 'http://localhost:8189/shop/products/' + productIndex,
            method: 'DELETE'
        }).then(function (response) {
            console.log(response);
        });
    };

    $scope.loadProducts();


});