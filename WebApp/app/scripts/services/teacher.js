'use strict';

/**
 * @ngdoc service
 * @name webAppApp.teacher
 * @description
 * # teacher
 * Service in the webAppApp.
 */
angular.module('webAppApp')
    .service('teacher', function() {
        var teachers = [
            { name: '张三', username: 'zhangsan', sex: 0, email: 'zhangsan@yunzhiclub.com' },
            { name: '李四', username: 'lisi', sex: 1, email: 'lisi@yunzhiclub.com' }
        ];
        // Public API here
        return {
            // 获取考场编排信息
            all: function() {
                return teachers;
            },
        };
    });
