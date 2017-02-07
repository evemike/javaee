'use strict';

/**
 * @ngdoc service
 * @name webAppApp.user
 * @description
 * # user
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('user', function(server) {
        /**
         * 用户登陆
         * @param    {string}                 username 用户名
         * @param    {string}                 password 密码
         * @param    {Function}               callback 回调函数
         * @return   {}                          
         * @author 梦云智 http://www.mengyunzhi.com
         * @DateTime 2017-02-07T18:34:55+0800
         */
        var login = function(username, password, callback) {
            server.http({
                method: 'POST',
                url: '/User_login',
                data: {
                    username: username,
                    password: password
                }
            }, function(response) {
                // 将是否通过验证传给V层
                callback(response.isPassed);
            });
        };

        return {
            login: login
        };
    });
