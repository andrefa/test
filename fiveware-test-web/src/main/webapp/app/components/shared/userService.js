(function() {
    'use strict';

    angular.module('fiveware-test-app')
    	   .factory('UserService', UserService);
    
    UserService.$inject = ['$resource'];
    function UserService($resource) {
    	return $resource('rest/user/:id');
	}

})();