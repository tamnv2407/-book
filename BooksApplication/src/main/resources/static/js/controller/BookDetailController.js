'use strict';

angular.module('bookApp')
.controller('BookDetailController', BookDetailController);

function BookDetailController($scope, BookService, $stateParams, blockUI){

	$scope.book = {};
	$scope.getBookDetail = getBookDetail;
	var bookId = $stateParams.bookId;
	$scope.getBookDetail(bookId);
	
	function getBookDetail(bookId){
		blockUI.start();
		BookService.getBook(bookId).then(
				function (data){
					$scope.book = data;
					blockUI.stop();
				}		,
				function (error){
					blockUI.stop();
					console.log(error);
				});
	}
}