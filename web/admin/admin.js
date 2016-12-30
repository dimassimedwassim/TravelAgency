/**
 * Created by wassim on 30/12/16.
 */
var admin = angular.module('adminApp',['ngRoute']);
admin.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when("/dashboard", {
            templateUrl : "views/dashboard.html"
        })
        .when("/flights", {
            templateUrl : "views/flights.html"
        })
        .when("/reservations", {
            templateUrl : "views/reservations.html"
        })
        .otherwise({
            redirectTo : "/dashboard"
        });
}]);