/**
 * 
 */
'use strict';

angular.module('bookApp').controller('LoginController', LoginController);

LoginController.$inject = [ '$scope', '$state', 'LoginService', 'blockUI' ];

function LoginController($scope, $state, LoginService, blockUI, $sessionStorage) {
	// If user is logged in, redirect to books list
    if(sessionStorage.user != undefined){

		$state.transitionTo('books', {
		    location: true,
		    inherit: true,
		    relative: $state.$current,
		    notify: false
		})
    }

	$scope.user = {
		email : '',
		password : ''
	};
	$scope.errorMessage = '';

	$scope.signin = signin;

	function signin() {
		blockUI.start();
		LoginService.signin($scope.user).then(function(data) {
			if(data != null && data.id != undefined){
				blockUI.stop();
				sessionStorage.user = data;

				$state.transitionTo('books', {
				    location: true,
				    inherit: true,
				    relative: $state.$current,
				    notify: false
				})
			} else {
				blockUI.stop();
				$scope.errorMessage = 'Invalid email or password';
			}
		}, function(error) {
			blockUI.stop();
		})
	}
}
