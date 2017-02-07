'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('LoginCtrl', function($scope, user, $location) {
        $scope.username = '';       // 用户名
        $scope.password = '';       // 密码

        // 提交表单
        var submit = function () {
            user.login($scope.username, $scope.password, function(isPassed) {
                if (isPassed === true) {
                    console.log('登录成功');
                    // 跳转至首页
                    $location.path('/');
                } else {
                    console.log('登录失败');
                }
            });
        };

        $scope.submit = submit;
    });
