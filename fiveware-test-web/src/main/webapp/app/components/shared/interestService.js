(function() {
    'use strict';

    angular.module('fiveware-test-app')
    	   .factory('InterestService', InterestService);
    
    InterestService.$inject = ['$resource'];
    function InterestService($resource) {
    	return $resource('rest/interest/:interestId');
	}

})();