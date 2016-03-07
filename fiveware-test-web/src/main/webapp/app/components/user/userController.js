(function() {
	'use strict';

	angular.module('fiveware-test-app')
		   .controller('UserController', UserController);

	UserController.$inject = ['$state', '$stateParams', 'UserService', 'InterestService', 'RefdataService'];
	function UserController($state, $stateParams, UserService, InterestService, RefdataService) {
		
		var vm = this;
		vm.user = new UserService();
		vm.saveUser = saveUser;
		vm.interestList = InterestService.query();
		vm.genderList = RefdataService.listGenders();
		
		init();

		function init() {
			var userId = $stateParams.userId;
			if(userId) {
				vm.user = UserService.get({id : userId});
			}
		}
		
		function saveUser() {
			vm.user.$save().then(function(){
				alert("Sucesso!");
				$state.go('/');
			});
		}
		
	}
})();