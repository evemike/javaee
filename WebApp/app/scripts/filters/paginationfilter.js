'use strict';

/**
 * @ngdoc filter
 * @name webAppApp.filter:paginationFilter
 * @function
 * @description
 * # paginationFilter
 * Filter in the webAppApp.
 */
angular.module('webAppApp')
    .filter('paginationFilter', function() {
        return function(items, pageSize, totalCount) {
            // 计算共多少页
            var page = Math.ceil(totalCount / pageSize);
            // 按页数大小push数组
            for (var i = 1; i <= page; i++) {
                items.push(i);
            }
            // 返回包含有分页的数组
            return items;
        };
    });
