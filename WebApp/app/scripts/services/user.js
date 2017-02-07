'use strict';

/**
 * @ngdoc service
 * @name webAppApp.user
 * @description
 * # user
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('user', function($http) {
        var login = function(username, password, callback) {
            var data = {};
            $http({
                    method: 'POST',
                    url: 'http://127.0.0.1:8080/javaee/User_login',
                    data: {
                        username: username,
                        password: password
                    },
                    header: {
                        contentType: 'application/json',
                    }
                }).then(function successCallback(response) {
                    console.log(response);
                    data = response.data;

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
                callback(data.isPassed);
            });
        };

        return {
            login: login
        };
    });
