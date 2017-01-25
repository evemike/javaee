'use strict';

describe('Controller: TeacherIndexCtrl', function() {

    // load the controller's module
    beforeEach(module('webAppApp'));

    var TeacherIndexCtrl,
        scope, $httpBackend;

    // Initialize the controller and a mock scope
    beforeEach(inject(function($controller, $rootScope, _$httpBackend_) {
        scope = $rootScope.$new();
        $httpBackend = _$httpBackend_;
        // 定义请求 URL
        var url = 'resource/teacher/all.json';
        // 定义返回数据。注意此处的json数据的写法与xxx.json文件中的json数据的写的法的异同。
        var data = {
            teachers: [
                { username: 'zhangsan', name: '张三', sex: 0, email: 'zhangsan@yunzhiclub.com' },
                { username: 'lisi', name: '李四', sex: 1, email: 'lisi@yunzhiclub.com' },
                { username: 'wangwu', name: '王五', sex: 0, email: 'wangwu@yunzhiclub.com' }
            ]
        };

        // 进行模似数据请求配置.当请求方法为GET，资源名为resource/teacher/index/all.json, 返回data数据.
        $httpBackend.when('GET', url).respond(data);

        TeacherIndexCtrl = $controller('TeacherIndexCtrl', {
            $scope: scope
                // place here mocked dependencies
        });
    }));

    it('测试M层的静态数据', function() {
        // 模拟数据请求
        // $httpBackend.flush();
        // expect(scope.teachers.length).toBe(3);
    });
});
