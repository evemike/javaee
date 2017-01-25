'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:TeacherIndexCtrl
 * @description
 * # TeacherIndexCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
  .controller('TeacherIndexCtrl', function ($scope, teacher) {
        $scope.teachers = [];   // 教师列表
        $scope.name = '';       // 查询姓名
        $scope.page = 1;        // 第几页
        $scope.pageSize = 2;    // 每页显示几条数据

        // 获取教师分页列表
        teacher.paginate($scope.name, $scope.page, $scope.pageSize, function(teachers) {
            $scope.teachers = teachers;
        });
  });