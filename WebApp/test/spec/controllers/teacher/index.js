'use strict';

describe('Controller: TeacherIndexCtrl', function() {

    // load the controller's module
    beforeEach(module('webAppApp'));

    var TeacherIndexCtrl,
        scope;

    // Initialize the controller and a mock scope
    beforeEach(inject(function($controller, $rootScope) {
        scope = $rootScope.$new();
        TeacherIndexCtrl = $controller('TeacherIndexCtrl', {
            $scope: scope
                // place here mocked dependencies
        });
    }));

    it('测试M层的静态数据', function() {
        expect(scope.teachers.length).toBe(2);
        expect(scope.teachers[0].username).toBe('zhangsan');
    });
});
