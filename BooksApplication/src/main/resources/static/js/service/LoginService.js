'use strict';

angular.module('bookApp')
.factory('LoginService', LoginService);

LoginService.$inject = ['$http', '$q'];

function LoginService($http, $q){

    var SIGNIN_REST_SERVICE_URI = 'signin';

    var factory = {
        signin: signin,
        users : users
     //   createUser: createUser,
    //    updateUser:updateUser,
    //    deleteUser:deleteUser
    };

    return factory;

    function signin(user) {
        var deferred = $q.defer();
        $http.post(SIGNIN_REST_SERVICE_URI, user)
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
    
    function users() {
        var deferred = $q.defer();
        $http.get("users")
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
