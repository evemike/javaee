'use strict';

/**
 * @ngdoc service
 * @name webAppApp.teacher
 * @description
 * # teacher
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('teacher', function($http) {
        /**
         * 获取当前页的教师
         * @param    {string}                 name     查询教师的名字
         * @param    {int}                 page     第几页
         * @param    {int}                 pageSize 每页多少条
         * @param    {Function}               callback 回调函数
         * @return   {[type]}                          
         * @author 梦云智 http://www.mengyunzhi.com
         * @DateTime 2017-01-21T19:05:55+0800
         */
        var paginate = function(name, page, pageSize, callback) {
            var teachers = [];

            // 进行http POST请求.
            // 由于是post请求方式，所以即便是我们在项目中存在paginate.json文件
            // 但如果我们查看控制台，仍然会发现有错误产生，同时，没有正确的接收到数据
            $http({
                method: 'POST',
                url: 'http://127.0.0.1:8080/javaee/teacher/',
                data: {
                    name: name,
                    page: page,
                    pageSize: pageSize
                },
                header: {
                    contentType: 'application/json',
                }
            }).then(function successCallback(response) {
                console.log(response);
                teachers = response.data.teachers;

                // 网络发生错误 
            }, function errorCallback(response) {
                console.log('error callback');
                console.log(response);
            }).
            // 发生异常
            catch(function(e) {
                console.log('Error: ', e);
                throw e;
            }).finally(function() {
                // 调用回调函数, 返回教师数组
                callback(teachers);
            });
        };


        // Public API here
        return {
            // 获取全部教师信息
            paginate: function(name, page, pageSize, callback) {
                return paginate(name, page, pageSize, callback);
            },
        };
    });