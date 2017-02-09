'use strict';

/**
 * @ngdoc service
 * @name webAppApp.config
 * @description
 * # config
 * Constant in the webAppApp.
 */
angular.module('webAppApp')
  .constant('config', {
    isDebug: true,     // 开发模式
    apiRootPath: 'http://127.0.0.1:8080/javaee'    // api请求的根路径
  });
