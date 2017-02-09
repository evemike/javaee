'use strict';

describe('Service: teacher', function() {

    // load the service's module
    beforeEach(module('webAppApp'));

    // instantiate service
    var teacher, $httpBackend, config;
    // 引用$httpBackend
    beforeEach(inject(function(_teacher_, _$httpBackend_, _config_) {
        teacher = _teacher_;
        $httpBackend = _$httpBackend_;
        config = _config_;
        // 定义请求 URL
        var url = 'http://127.0.0.1:8080/javaee/teacher/';
        // 定义返回数据。
        var data = {
            teachers: [
                { username: 'zhangsan', name: '张三', sex: 0, email: 'zhangsan@yunzhiclub.com' },
                { username: 'lisi', name: '李四', sex: 1, email: 'lisi@yunzhiclub.com' }
            ]
        };

        // 进行模似数据请求配置.当请求方法为GET，资源名为resource/teacher/index/all.json, 返回data数据.
        $httpBackend.when('POST', url).respond(data);

        url = config.apiRootPath + '/Teacher_all.json';
        data = {code: 200, teachers: []};
        $httpBackend.when('GET', url).respond(data);
    }));


    it('应该取出来所有的教师数据', function() {
        teacher.all(function(teachers) {
            console.log(teachers);
        });
        // 模拟数据请求
        $httpBackend.flush();
        
    });
});
