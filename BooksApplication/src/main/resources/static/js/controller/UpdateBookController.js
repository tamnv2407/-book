'use strict';

angular.module('bookApp')
.controller('UpdateBookController', UpdateBookController);

function UpdateBookController($scope, $uibModalInstance, BookService, bookId){
	$scope.close = close;
	$scope.cancel = cancel;
	$scope.saveBook = saveBook;
	$scope.book = {};
	$scope.getBookDetail = getBookDetail;
	$scope.getBookDetail(bookId);

	function close(){
		$uibModalInstance.close();
	}
	
	function cancel(){
		$uibModalInstance.dismiss('cancel');
	}
	
	function getBookDetail(bookId){
		BookService.getBook(bookId).then(
				function (data){
					$scope.book = data;
				}		,
				function (error){
					console.log(error);
				});
	}

	function saveBook(){
		BookService.update($scope.book).then(
		function (data){
			$uibModalInstance.close(data);
		}		,
		function (error){
			console.log(error);
		}
		);
	}
}