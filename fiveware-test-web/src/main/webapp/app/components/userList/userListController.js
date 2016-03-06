(function() {
	'use strict';

	angular.module('fiveware-test-app')
		   .controller('UserListController', UserListController);

	UserListController.$inject = ['$state', 'UserService'];
	function UserListController($state, UserService) {
		
		var vm = this;
		
		console.log(UserService.query());
		
	}
})();