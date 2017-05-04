'use strict';

angular.module('bookApp')
.controller('AddBookController', AddBookController);

function AddBookController($scope, $uibModalInstance, BookService){
	$scope.close = close;
	$scope.cancel = cancel;
	$scope.addBook = addBook;
	$scope.book = {};

	function close(){
		$uibModalInstance.close();
	}
	
	function cancel(){
		$uibModalInstance.dismiss('cancel');
	}
	
	function addBook(){
		BookService.create($scope.book).then(
		function (data){
			$uibModalInstance.close(data);
		}		,
		function (error){
			console.log(error);
		}
		);
	}
}