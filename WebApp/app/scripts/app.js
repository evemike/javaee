'use strict';

/**
 * @ngdoc overview
 * @name webAppApp
 * @description
 * # webAppApp
 *
 * Main module of the application.
 */
angular
    .module('webAppApp', [
        'ngAnimate',
        'ngAria',
        'ngCookies',
        'ngMessages',
        'ngResource',
        'ngRoute',
        'ngSanitize'
    ])
    .config(function($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl',
                controllerAs: 'main'
            })
            .when('/about', {
                templateUrl: 'views/about.html',
                controller: 'AboutCtrl',
                controllerAs: 'about'
            })
            .when('/teacher/', {
                templateUrl: 'views/teacher/index.html',
                controller: 'TeacherIndexCtrl',
                controllerAs: 'teacher/Index'
            })
            .otherwise({
                redirectTo: '/'
            });
        // 进行跨域请求时，发送cookie
        $httpProvider.defaults.withCredentials = true;
    });
