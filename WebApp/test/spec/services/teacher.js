'use strict';

describe('Service: teacher', function() {

    // load the service's module
    beforeEach(module('webAppApp'));

    // instantiate service
    var teacher, $httpBackend;
    // 引用$httpBackend
    beforeEach(inject(function(_teacher_, _$httpBackend_) {
        teacher = _teacher_;
        $httpBackend = _$httpBackend_;

        // 定义请求 URL
        var url = 'resource/teacher/index/all.json';
        // 定义返回数据。注意此处的json数据的写法与xxx.json文件中的json数据的写的法的异同。
        var data = {
            teachers: [
                { username: 'zhangsan', name: '张三', sex: 0, email: 'zhangsan@yunzhiclub.com' },
                { username: 'lisi', name: '李四', sex: 1, email: 'lisi@yunzhiclub.com' }
            ]
        };

        // 进行模似数据请求配置.当请求方法为GET，资源名为resource/teacher/index/all.json, 返回data数据.
        $httpBackend.when('GET', url).respond(data);
    }));

    it('should do something', function() {
        expect(!!teacher).toBe(true);
    });

    it('应该取出来所有的教师数据', function() {
        teacher.all(function(teachers){
            expect(teachers.length).toBe(2);
        });

        // 模拟数据请求
        $httpBackend.flush();
    });
});
