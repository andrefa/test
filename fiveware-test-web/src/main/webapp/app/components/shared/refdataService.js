(function() {
    'use strict';

    angular.module('fiveware-test-app')
    	   .factory('RefdataService', RefdataService);
    
    RefdataService.$inject = ['$resource'];
    function RefdataService($resource) {
    	return $resource('rest/refdata/', {}, {
    		'listGenders': {
    			method	: 'GET',
    			url		: 'rest/refdata/listGenders',
    			isArray : true
    		}
    	});
	}

})();