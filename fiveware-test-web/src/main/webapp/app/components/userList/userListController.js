(function() {
	'use strict';

	angular.module('fiveware-test-app')
		   .controller('UserListController', UserListController);

	UserListController.$inject = ['$state', 'UserService'];
	function UserListController($state, UserService) {
		
		var vm = this;
		vm.userList = UserService.query();
		vm.deleteUser = deleteUser;
		vm.getGenderName = getGenderName;

		function getGenderName(genderId) {
			if (genderId == 1) {
				return "Masculino";
			}
			return "Feminino";
		}
		
		function deleteUser(user) {
			if(confirm("Confirma a exclusao do usuario '" + user.fullName + "'?")) {
				user.$delete({id : user.id}).then(function() {
					vm.userList = UserService.query();
				});
			}
		}

	}
})();