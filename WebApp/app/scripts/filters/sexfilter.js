'use strict';

/**
 * @ngdoc filter
 * @name webAppApp.filter:sexFilter
 * @function
 * @description
 * # sexFilter
 * Filter in the webAppApp.
 */
angular.module('webAppApp')
    .filter('sexFilter', function() {
        var getSexByInt = function(sex) {
            if (sex) {
                return '女';
            } else {
                return '男';
            }
        };
        
        return function(input) {
            return getSexByInt(input);
        };
    });
