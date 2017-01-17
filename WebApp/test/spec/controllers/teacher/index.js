'use strict';

describe('Controller: TeacherIndexCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var TeacherIndexCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TeacherIndexCtrl = $controller('TeacherIndexCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(TeacherIndexCtrl.awesomeThings.length).toBe(3);
  });
});
