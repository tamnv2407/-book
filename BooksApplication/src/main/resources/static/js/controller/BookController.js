'use strict';

angular.module('bookApp')
.controller('BookController', BookController);

BookController.$inject = ['$scope', '$uibModal' ,'BookService', 'blockUI'];

function BookController($scope, $uibModal, BookService, blockUI) {

    $scope.showAddBookForm = showAddBookForm;
    $scope.fetchAllBooks = fetchAllBooks;
    $scope.showEditBookForm = showEditBookForm;
    $scope.showDeleteConfirm = showDeleteConfirm;

    $scope.fetchAllBooks();

    function fetchAllBooks(){
    	blockUI.start();
        BookService.fetchAllBooks()
            .then(
            function(books) {
                $scope.books = books;
                blockUI.stop();
            },
            function(errResponse){
                console.error('Error while fetching Users');
                blockUI.stop();
            }
        );
    }
    
    function showAddBookForm(){
    	 $uibModal.open({
    	      animation: true,
    	      ariaLabelledBy: 'modal-title',
    	      ariaDescribedBy: 'modal-body',
    	      templateUrl: 'views/add-book.html',
    	      controller: 'AddBookController'
    	    }).result.then(function (result) {
    	       if(result == true){
    	    	    $scope.fetchAllBooks();
    	       }
    	    }, function () {
    	      $log.info('Modal dismissed at: ' + new Date());
    	    });;
    }
    
    function showEditBookForm(bookId){
    	$uibModal.open({
  	      animation: true,
  	      ariaLabelledBy: 'modal-title',
  	      ariaDescribedBy: 'modal-body',
  	      templateUrl: 'views/edit-book.html',
  	      controller: 'UpdateBookController',
  	      resolve: {
  	        bookId: function () {
  	          return bookId;
  	        }
  	      }
  	    }).result.then(function (result) {
  	       if(result == true){
  	    	    $scope.fetchAllBooks();
  	       }
  	    }, function () {
  	      
  	    });
    }
    
    function showDeleteConfirm(book){
    	$uibModal.open({
    	      animation: true,
    	      ariaLabelledBy: 'modal-title',
    	      ariaDescribedBy: 'modal-body',
    	      templateUrl: 'views/delete-book.html',
    	      controller: 'DeleteBookController',
    	      resolve: {
    	        book: function () {
    	          return book;
    	        }
    	      }
    	    }).result.then(function(result) {
    	       if(result == true){
    	    	    $scope.fetchAllBooks();
    	       }
    	    }, function () {
    	      
    	    });
    }

}
