/**
 * Created by wassim on 29/12/16.
 */
var agency = angular.module('myApp',['ngRoute']);

agency.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when("/home", {
            templateUrl : "views/home.html"
        })
        .when("/blog", {
        templateUrl : "views/blog.html"
    })
        .otherwise({
            redirectTo : "/home"
        });
}]);