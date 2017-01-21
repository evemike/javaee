'use strict';

describe('Service: teacher', function() {

    // load the service's module
    beforeEach(module('webAppApp'));

    // instantiate service
    var teacher;
    beforeEach(inject(function(_teacher_) {
        teacher = _teacher_;
    }));


    it('应该取出来所有的教师数据', function() {

        // karma并不能如此处理回调函数。todo:
        teacher.all(function(teachers){
            console.log(teachers);
            expect(typeof(teachers)).toBe('array');
        });
    });

});
