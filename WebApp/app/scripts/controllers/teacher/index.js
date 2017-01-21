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
        $scope.teachers = teacher.all();
  });
