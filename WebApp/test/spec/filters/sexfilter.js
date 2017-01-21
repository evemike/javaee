'use strict';

describe('Filter: sexFilter', function() {

    // load the filter's module
    beforeEach(module('webAppApp'));

    // initialize a new instance of the filter before each test
    var sexFilter;
    beforeEach(inject(function($filter) {
        sexFilter = $filter('sexFilter');
    }));

    it('输入0，返回男；输入1，返回女', function() {
        expect(sexFilter(0)).toBe('男');
        expect(sexFilter(1)).toBe('女');
    });

});
