'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassAddCtrl
 * @description
 * # KlassAddCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('KlassAddCtrl', function($scope, config, teacher) {
        $scope.name = '';       // 名称
        // 教师列表
        $scope.teachers = [];
        // 选中的教师
        $scope.teacher = 0;
        $scope.isDebug = config.isDebug;
        var submit = function() {
            console.log('submit');
        };

        // 获取教师列表
        var getTeachers = function() {
            teacher.all(function(response){
                $scope.teachers = response;             // 获取到的所有教师
                $scope.teacher = $scope.teachers[0].id; // 初始化选中的教师
            });
        };

        // 初始化
        var int = function () {
            getTeachers();
        };

        int();
        $scope.submit = submit;

    });
