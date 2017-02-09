'use strict';

/**
 * @ngdoc service
 * @name webAppApp.server
 * @description
 * # server
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('server', function($http, config) {
        var http = function(param, callback) {
            var data = {};
            // 设置请求的header
            param.header = {
                contentType: 'application/json',
            };
            // 统一处理URL
            param.url = config.apiRootPath + param.url;

            $http(param).then(function successCallback(response) {
                    // 开发者模式下，打印资源请求结果
                    if (config.isDebug === true) {
                        console.log(response);
                    }
                    
                    data = response.data;

                    // 网络发生错误 
                }, function errorCallback(response) {
                    console.log('网络请求发生错误:');
                    console.log(response);
                }).
                // 发生异常
            catch(function(e) {
                console.log('$http发生异常: ', e);
                throw e;
            }).finally(function() {
                // todo:进行错误码的判断，如果提示用户未登陆，则跳转至登陆页面
                if (typeof(data.code) === 'undefined') {
                    console.log('未获取到code值');
                } else if (data.code !== 200) {
                    // 返回的状态码不是200，则说明发生了错误
                    console.log('返回的状态码为' + data.code);
                    checkCode(data.code);
                } else {

                    // 调用回调函数, 返回数据
                    callback(data);
                }
            });
        };

        // 核验错误码
        var checkCode = function(code) {
            if (code === 401) {
                console.log('用户尚未登陆，或停留的时间过长');
                // 跳转至用户登陆界面
                

            } else if (code === 403) {
                console.log('用户无此操作权限');
                // 提示用户无此权限

            } else {
                console.log('接收到了未定义的错误码');
            }
        };

        // Public API here
        return {
            http: http
        };
    });
