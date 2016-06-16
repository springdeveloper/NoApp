'use strict';
App.factory('LeadService', ['$http', '$q','API_URL', function($http, $q,API_URL){
    return {
    	
            fetchAllLead: function() {
                    return $http.get(API_URL + "lead/lead_list/json")
                            .then(
                                    function(response){
                                        return response.data;
                                         
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching Lead');
                                        return $q.reject(errResponse);
                                    }
                            );
                    
            },

        
    };
}]);