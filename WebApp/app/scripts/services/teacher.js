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

        var teachers = [];
        // 获取所有教师
        var all = function(callback) {
            // $http.get().then(function1(){}, function2(){}); 链式调用 then()中接收两个参数，类型均为function
            $http.get('resource/teacher/index/all.json').then(function success(response) {
                // 数据成功返回
                console.log(response);
                teachers = response.data.teachers;
                callback(teachers);
            }, function error(response) {
                console.log('数据请求错误：');
                console.log(response);
            });
        };

        // Public API here
        return {
            // 获取考场编排信息
            all: function(callback) {
                all(callback);
            },
        };
    });