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
        // 使用回调函数来获取数据
        teacher.all(function(teachers) {
            $scope.teachers = teachers;
        });
  });