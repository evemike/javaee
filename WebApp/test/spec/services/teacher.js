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
    }));


    it('应该取出来所有的教师数据', function() {
        teacher.paginate('zhangsan', 1, 2, function(teachers) {
            console.log('返回教师信息如下：');
            console.log(teachers);
            expect(teachers.length).toBe(2);
        });
        // 模拟数据请求
        $httpBackend.flush();
        
    });
});
