'use strict';

/**
 * @ngdoc service
 * @name webAppApp.klass
 * @description
 * # klass
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('klass', function(server) {
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
            // 进行http POST请求.
            // 由于是post请求方式，所以即便是我们在项目中存在paginate.json文件
            // 但如果我们查看控制台，仍然会发现有错误产生，同时，没有正确的接收到数据
            server.http({
                method: 'POST',
                url: '/Klass.json',
                data: {
                    name: name,
                    page: page,
                    pageSize: pageSize
                }
            }, function(response) {
                callback(response);
            });
        };

        // 新增数据
        var save = function(teacher, callback) {
            server.http({
                method: 'POST',
                url: '/klass.Save.json',
                data : teacher
            }, function(response) {
                callback(response);
            });
        };
        
        // Public API here
        return {
            // 获取全部教师信息
            paginate: function(name, page, pageSize, callback) {
                return paginate(name, page, pageSize, callback);
            },
            save: save
        };
    });
