'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassAddCtrl
 * @description
 * # KlassAddCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('KlassAddCtrl', function($scope, config, teacher, klass) {
        $scope.klass = {name:'', teacherId:0};       // 教师
        // 教师列表
        $scope.teachers = [];
        $scope.isDebug = config.isDebug;
        $scope.isError = false; // 是否发生错误
        $scope.errors = {};     // 错误信息
        $scope.message = '';    // 提示信息

        // 数据提交
        var submit = function() {
            klass.save($scope.klass, function(response){
                if (!angular.equals({}, response.errors)) {
                    // 发生错误
                    $scope.errors = response.errors;
                    $scope.isError = true;              // 发生错误
                    $scope.message = '';                // 清空消息
                    
                } else {
                    // 添加成功
                    $scope.message = '添加成功';
                    $scope.isError = false;
                }
            });
        };

        // 获取教师列表
        var getTeachers = function() {
            teacher.all(function(response){
                $scope.teachers = response;             // 获取到的所有教师
                $scope.klass.teacherId = $scope.teachers[0].id;    // 初始化选中的教师
            });
        };

        // 初始化
        var int = function () {
            getTeachers();
        };

        int();
        $scope.submit = submit;
        this.scope = $scope;

    });
