'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:TeacherIndexCtrl
 * @description
 * # TeacherIndexCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('TeacherIndexCtrl', function($scope, teacher) {
        // 教师列表
        $scope.teachers = [];
        $scope.name = '';
        $scope.page = 1;
        $scope.pageSize = 2;

        /**
         * 查询
         * @return   {array}                 当前教师
         * @author 梦云智 http://www.mengyunzhi.com
         * @DateTime 2017-01-21T20:02:09+0800
         */
        var query = function() {
            // 取教师列表
            teacher.paginate($scope.name, $scope.page, $scope.pageSize, function(teachers) {
                $scope.teachers = teachers;
            });
        };

        // 系统初始化
        var init = function() {
            query();
        };

        // 换页
        var changePage = function(page) {
            $scope.page = page;
            query();
        };

        // 是否给当前页添加active样式
        var activeClass = function(page) {
            if (page === $scope.page) {
                return 'active';
            } else {
                return '';
            }
        };

        $scope.query = query;
        $scope.changePage = changePage;
        $scope.activeClass = activeClass;
        init();
    });
