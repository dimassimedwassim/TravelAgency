/**
 * Created by wassim on 30/12/16.
 */
var admin = angular.module('adminApp',['ngRoute']);
admin.controller('FlightsController',['$scope','$http',function ($scope,$http) {
    $http.get('http://192.168.1.100:8080/RestOffreVol/webresources/flights').success(function (data) {
        $scope.flights=data;


    });
    
}]);

admin.controller('UsersController',['$scope','$http',function ($scope,$http) {
    // $http.get('').success(function (data) {
    //     $scope.users=data;
    //
    //
    // });
    $scope.users="users";
}]);


admin.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when("/flights", {
            templateUrl : "views/flights.html",
            controller:'FlightsController'
        })
        .when("/addFlight", {
            templateUrl : "views/addFlight.html"
        })
        .when("/users", {
            templateUrl : "views/users.html",
            controller:'UsersController'
        })
        .when("/addUser", {
            templateUrl : "views/userAdd.html"
        })
        .when("/reservations", {
            templateUrl : "views/reservations.html"
        })
        .otherwise({
            redirectTo : "/flights"
        });
}]);