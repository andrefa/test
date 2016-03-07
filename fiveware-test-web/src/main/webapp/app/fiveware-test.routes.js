(function() {
    'use strict';

    angular.module('fiveware-test-app')
           .config(UiRouterConfig);
		
	UiRouterConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
	function UiRouterConfig($stateProvider, $urlRouterProvider) {
	
		$urlRouterProvider.otherwise('/');
		
		$stateProvider
            .state('/',{
                url : '/',
                templateUrl: 'app/components/userList/userList.html',
                controller: 'UserListController',
                controllerAs: 'userListCtrl'
            }).state('addUser',{
                url : '/user',
                templateUrl: 'app/components/user/user.html',
                controller: 'UserController',
                controllerAs: 'userCtrl'
            }).state('editUser',{
                url : '/user/{userId:int}',
                templateUrl: 'app/components/user/user.html',
                controller: 'UserController',
                controllerAs: 'userCtrl'
            });

	}
})();