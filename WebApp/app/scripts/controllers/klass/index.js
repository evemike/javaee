'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassIndexCtrl
 * @description
 * # KlassIndexCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('KlassIndexCtrl', function($scope, config) {
        // 初始化
        var klasses = [];
        $scope.page = 1; // 第几页
        $scope.pageSize = 2; // 每页大小
        $scope.totalCount = 10; // 总条数
        $scope.name = ''; // 查询条件
        $scope.isDebug = config.isDebug; // 开发模式

        klasses.push({ id: 1, name: '一年级一班', teacher: { name: '王五' } });
        klasses.push({ id: 2, name: '一年级二班', teacher: { name: '赵六' } });
        klasses.push({ id: 3, name: '二年级一班', teacher: { name: '孙七' } });

        // 为当前页增加active样式
        var activeClass = function(index) {
            if ($scope.page === index) {
                return 'active';
            } else {
                return '';
            }
        };

        // 用户点击分页触发
        var changePage = function (index) {
            $scope.page = index;
        };

        $scope.klasses = klasses;
        $scope.activeClass = activeClass;
        $scope.changePage = changePage;
    });
