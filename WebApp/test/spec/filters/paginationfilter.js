'use strict';

describe('Filter: paginationFilter', function() {

    // load the filter's module
    beforeEach(module('webAppApp'));

    // initialize a new instance of the filter before each test
    var paginationFilter;
    beforeEach(inject(function($filter) {
        paginationFilter = $filter('paginationFilter');
    }));

    it('每页2条，共10条，共5页', function() {
        var items = [];
        expect(paginationFilter(items, 2, 10).length).toBe(5);
    });

    it('每页1条，共10条，共10页', function() {
        var items = [];
        expect(paginationFilter(items, 1, 10).length).toBe(10);
    });

    it('每页2条，共11条，共6页', function() {
        var items = [];
        expect(paginationFilter(items, 2, 13).length).toBe(7);
    });


});
