'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassEditCtrl
 * @description
 * # KlassEditCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('KlassEditCtrl', function($scope, config, teacher,  $routeParams, klass) {
        $scope.klass = {};
        // 教师列表
        $scope.teachers = [];
        // 选中的教师
        
        $scope.isDebug = config.isDebug;
        $scope.isError = false; // 是否发生错误
        $scope.errors = {};     // 错误信息
        $scope.message = '';    // 提示信息
        $scope.klass = {};      // 班级信息
        $scope.klass.id = $routeParams.id;     // 班级关键字

        // 数据提交
        var submit = function() {
            klass.update($scope.klass, function(response){
                if (!angular.equals({}, response.errors)) {
                    // 发生错误
                    $scope.errors = response.errors;
                    $scope.isError = true;              // 发生错误
                    $scope.message = '';                // 清空消息
                    
                } else {
                    // 添加成功
                    $scope.message = '更新成功';
                    $scope.isError = false;
                }
            });
        };

        // 获取当前班级信息
        var getKlass = function() {
            klass.get($scope.klass.id, function(response) {
                $scope.klass = response.klass;
            });
        };

        // 获取教师列表
        var getTeachers = function() {
            teacher.all(function(response) {
                $scope.teachers = response; // 获取到的所有教师
                $scope.teacher = $scope.teachers[0].id; // 初始化选中的教师
            });
        };

        // 初始化
        var int = function() {
            getTeachers();
            getKlass();
        };

        int();
        $scope.submit = submit;

    });
