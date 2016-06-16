var App = angular.module('CRMAPP', ['ui.bootstrap'])
        .constant('API_URL', 'http://localhost:9191/CRMAPPS/');


App.controller('LeadCtrl', function ($scope, $http,$filter) {
    $scope.lead = [];
    $scope.predicate = 'id';  
    $scope.reverse = true;  
    $scope.currentPage = 1;  
    $scope.order = function (predicate) {  
    $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;  
    $scope.predicate = predicate;  
    };  
   // $scope.lead = [];

	  $http.get("http://localhost:8080/CRMAPPS/lead/lead_list/json")
      .success(function (response) {
          $scope.leads = response.list;
         
       //console.log("----------"+JSON.stringify($scope.leads))
    
    
   // $scope.test=  $scope.db();
    //console.log("----------"+JSON.stringify($scope.db()))
   //    $scope.leads=$scope.test.list;  
          console.log($scope.leads.length)
          
          
      $scope.totalItems = $scope.leads.length;  
      $scope.numPerPage = 5;  
      $scope.paginate = function (value) {  
        var begin, end, index;  
        begin = ($scope.currentPage - 1) * $scope.numPerPage;  
        end = begin + $scope.numPerPage;  
        index = $scope.leads.indexOf(value);  
        return (begin <= index && index < end);  
      };  
      });
});