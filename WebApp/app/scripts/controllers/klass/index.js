'use strict';

/**
 * @ngdoc function
 * @name webAppApp.controller:KlassIndexCtrl
 * @description
 * # KlassIndexCtrl
 * Controller of the webAppApp
 */
angular.module('webAppApp')
    .controller('KlassIndexCtrl', function($scope, config, klass, $timeout) {
        // 初始化
        var klasses = [];
        $scope.page = 1; // 第几页
        $scope.pageSize = 3; // 每页大小
        $scope.totalCount = 10; // 总条数
        $scope.name = ''; // 查询条件
        $scope.isDebug = config.isDebug; // 开发模式
        $scope.message = '';                // 消息
        $scope.error = '';                  // 错误消息

        console.log(klass);
        // 设置提示消息
        var setMessage = function (message) {
            $scope.message = message;
            $scope.error = '';
            $timeout(function() {
                $scope.message = '';
            }, 1500);
        };

        // 设置错误提示消息
        var setError = function (error) {
            $scope.error = error;
            $scope.message = '';
            $timeout(function() {
                $scope.error = '';
            }, 1500);
        };

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

        // 删除, 注意这里的参数，不能使用klass, 原因是：....
        var del = function (index, klassEntity) {
            klass.del(klassEntity.id, function(response) {
                // 发生错误
                if (!angular.equals({}, response.errors)) {
                    setError('系统发生错误');
                    console.log(response.errors);
                // 删除成功
                } else if(response.errorMessages.length === 0) {
                    setMessage('删除成功');
                    console.log(index);
                    $scope.klasses.splice(index, 1);

                // 发生警告
                } else {
                    setMessage('系统失败:' + response.errorMessages.toString());
                }
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
        $scope.del = del;
    });
