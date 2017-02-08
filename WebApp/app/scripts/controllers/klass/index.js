'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassIndexCtrl
 * @description
 * # KlassIndexCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('KlassIndexCtrl', function($scope, config, klass) {
        // 初始化
        var klasses = [];
        $scope.page = 1; // 第几页
        $scope.pageSize = 3; // 每页大小
        $scope.totalCount = 10; // 总条数
        $scope.name = ''; // 查询条件
        $scope.isDebug = config.isDebug; // 开发模式

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
            paginate();
        };

        // 分页查询
        var paginate = function() {
            klass.paginate($scope.name, $scope.page, $scope.pageSize, function(response) {
                $scope.page = response.page;
                $scope.klasses = response.klasses;
                $scope.totalcount = response.totalCount;
            });
        };

        // 初始化
        var int = function() {
            paginate();
        };

        int();
        $scope.query = paginate;
        $scope.klasses = klasses;
        $scope.activeClass = activeClass;
        $scope.changePage = changePage;
    });
