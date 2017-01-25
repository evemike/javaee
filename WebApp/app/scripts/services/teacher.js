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

            // 进行http POST请求, 即便存在paginate.json文件，在进行请求时，也会报404错误。
            $http({
                method: 'POST',
                url: 'http://127.0.0.1:8080/javaee/teacher/',
                data: {
                    name: name,
                    page: page,
                    pageSize: pageSize
                },
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