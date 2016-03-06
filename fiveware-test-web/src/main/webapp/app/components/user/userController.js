(function() {
	'use strict';

	angular.module('fiveware-test-app')
		   .controller('UserController', UserController);

	UserController.$inject = ['$state', 'UserService'];
	function UserController($state, UserService) {
		
		var vm = this;
		
		console.log(UserService.query());
		
	}
})();