/**
 * Created by wassim on 29/12/16.
 */
var agency = angular.module('myApp',['ngRoute']);

agency.controller('FlightsController',['$scope','$http',function ($scope,$http) {
    $http.get('http://192.168.1.100:8080/RestOffreVol/webresources/flights').success(function (data) {
        $scope.flights=data;


    });
}]);

agency.controller('HomeController',['$scope',function ($scope) {
    
}]);
agency.controller('CarsController',['$scope','$http',function ($scope,$http) {
    $http.get("http://localhost:8081/cars").success(function (data) {
        $scope.cars=JSON.parse(data);
        console.log(data);
    }).error(function (error) {
        $scope.cars=error;
    });


}]);

agency.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when("/home", {
            templateUrl : "views/home.html",
            controller: 'HomeController'
        })
        .when("/flights", {
        templateUrl : "views/flights.html",
            controller: 'FlightsController'
    })
        .when("/cars", {
            templateUrl : "views/cars.html",
            controller: 'CarsController'
        })
        .otherwise({
            redirectTo : "/home"
        });
}]);
