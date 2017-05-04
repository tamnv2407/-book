'use strict';

angular.module('bookApp')
.controller('DeleteBookController', DeleteBookController);

function DeleteBookController($scope, $uibModalInstance, BookService, book){
	$scope.close = close;
	$scope.cancel = cancel;
	$scope.deleteBook = deleteBook;
	$scope.book = book;

	function close(){
		$uibModalInstance.close();
	}
	
	function cancel(){
		$uibModalInstance.dismiss('cancel');
	}
	
	function deleteBook(bookId){
		BookService.deleteBook(bookId).then(
				function (data){
					$uibModalInstance.close(data);
				}		,
				function (error){
					console.log(error);
				});
	}
}