'use strict';

describe('Service: httpServer', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var httpServer;
  beforeEach(inject(function (_httpServer_) {
    httpServer = _httpServer_;
  }));

  it('should do something', function () {
    expect(!!httpServer).toBe(true);
  });

});
