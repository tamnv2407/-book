'use strict';

angular.module('bookApp').factory('BookService', BookService);

BookService.$inject = [ '$http', '$q' ];

function BookService($http, $q) {

	var REST_SERVICE_URI = 'books';

	var factory = {
		fetchAllBooks : fetchAllBooks,
		create : create,
		getBook : getBook,
		update : update,
		deleteBook : deleteBook
	};

	return factory;

	function fetchAllBooks() {
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}

	function create(book) {
		var deferred = $q.defer();
		$http.put('books', book).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}

	function getBook(id) {
		var deferred = $q.defer();
		$http.get('books/' + id).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			deferred.reject(errResponse);
		});

		return deferred.promise;
	}

	function update(book) {
		var deferred = $q.defer();
		$http.post('books' , book).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}

	 function deleteBook(id) {
	 var deferred = $q.defer();
	 $http.delete('books/'+id)
	 .then(
	 function (response) {
	 deferred.resolve(response.data);
	 },
	 function(errResponse){
	 deferred.reject(errResponse);
	 }
	 );
	 return deferred.promise;
	 }

}
