'use strict';

describe('Service: teacher', function() {

    // load the service's module
    beforeEach(module('webAppApp'));

    // instantiate service
    var teacher;
    beforeEach(inject(function(_teacher_) {
        teacher = _teacher_;
    }));

    it('should do something', function() {
        expect(!!teacher).toBe(true);
    });

    it('应该取出来所有的教师数据', function() {
        var teachers = teacher.all();
        // 检测tachers的长度，如果为2，正确，则不报错。
        expect(teachers.length).toBe(2);
    });

});
