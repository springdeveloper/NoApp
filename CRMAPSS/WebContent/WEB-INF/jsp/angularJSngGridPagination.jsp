<!DOCTYPE html>
<html data-ng-app="myApp">

<head lang="en">
<style type="text/css">
.gridModelStyle {
	border: 1px solid rgb(212,212,212);
	margin-left: 20px;
	width: 95%;
	height: 50%;
	background-color: rgba(225,225,220, 0.9);
	float: left;
	box-shadow: 5px 5px 5px #888888;
}

.chartBlock{
	margin-left: 20px;
    width: 95%; 
	height: 55%;
}

.chartStyle {
    border: 1px solid rgb(212,212,212);
    width: 78%; 
    height: 100%;
	background-color: rgba(225,225,220, 0.9);
	float: left;
	box-shadow: 5px 5px 5px #888888;
}



.activeTeamsDropdownStyle {
    border: 1px solid rgb(212,212,212);
	margin-left: 20px;
	margin-top: 20px;
	width: 95%;
#	padding:5px 5px 5px 5px;
	background-color: rgba(225,225,220, 0.9);
	float: left;
	box-shadow: 5px 5px 5px #888888;
#transform:rotate(-0.7deg);
#-webkit-transform:skewX(2deg);
}

.filler {
    width: 100%; 
    height: 10px;
	float: left;
}

.ricSelection {
    border: 1px solid rgb(212,212,212);
    width: 20%; 
    height: 100%;
	background-color: rgba(225,225,220, 0.9);
	float: right;
	box-shadow: 5px 5px 5px #888888;
	overflow: auto;	
	
}

.scrollit {
	overflow: scroll;
	height: 400px;
	margin-top: 2px;
	padding-right: 20px;
	padding-left: 2px;
}

.tab {
	background-color: none;
#	padding:5px 5px 5px 5px;
	width: 98%; 
    height: 600px;
	font-size:11px;
#transform:rotate(0.7deg);
#-ms-transform:rotate(0.7deg); /* IE 9 */
#-webkit-transform:rotate(0.7deg); /* Safari and Chrome */
}
</style>
  <meta charset="utf-8">
  <title>Active Basket</title>
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.debug.js"></script>
  <link rel="stylesheet" type="text/css" href="static/AngularJSService/css/style.css" />
  <script type="text/javascript">

	  var app = angular.module('myApp', ['ngGrid']);

	  app.controller('MyController', function($scope, $http) {
	      $scope.filterOptions = {
	          filterText: "",
	          useExternalFilter: true
	      };
	      $scope.totalServerItems = 0;
	      $scope.pagingOptions = {
	          pageSizes: [20, 50, 100],
	          pageSize: 20,
	          currentPage: 1
	      };  
	      $scope.setPagingData = function(data, page, pageSize){	
	          var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
	          $scope.myData = pagedData;
	          $scope.totalServerItems = data.length;
	          if (!$scope.$$phase) {
	              $scope.$apply();
	          }
	      };
	      $scope.getPagedDataAsync = function (pageSize, page, searchText) {
	          setTimeout(function () {
	              var data;
	              if (searchText) {
	                  var ft = searchText.toLowerCase();
	                  $http.get('getPaginationData/'+pageSize+"/"+page).success(function (largeLoad) {		
	                      data = largeLoad.filter(function(item) {
	                          return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
	                          console.log("111111111111111")
	                      });
	                  
	                      $scope.setPagingData(data,page,pageSize);
	                  });            
	              } else {
	                  $http.get('getPaginationData/'+pageSize+"/"+page).success(function (largeLoad) {
	                      $scope.setPagingData(largeLoad,page,pageSize);
	                      console.log("222222222222222"+JSON.stringify(pageSize+""+page))
	                  });
	              
	              }
	          }, 100);
	      };
	  	
	      $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
	  	
	      $scope.$watch('pagingOptions', function (newVal, oldVal) {
	          if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
	            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
	          }
	      }, true);
	      $scope.$watch('filterOptions', function (newVal, oldVal) {
	          if (newVal !== oldVal) {
	            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
	          }
	      }, true);
	  	
	      $scope.gridOptions = {
	    		  enableGridMenu: true,	  
	          data: 'myData',
	          enablePaging: true,
	          showFooter: true,
	          totalServerItems:'totalServerItems',
	          pagingOptions: $scope.pagingOptions,
	          filterOptions: $scope.filterOptions
	         
	      };
	  });
  	
  </script>
</head>

<body data-ng-controller="MyController" style="overflow: auto;">			
		
	<div class='tab'>
		<div class="activeTeamsDropdownStyle">
		    <b>Spring MVC Server Side Pagination ng-grid AngularJS</b>		    				
		</div>	

		<div class="filler"></div>	
		<div class="gridModelStyle" data-ng-grid="gridOptions"></div>
	</div>
	
</body>

</html>