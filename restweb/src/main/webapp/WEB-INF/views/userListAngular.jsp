<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>    <title>AngularJS User List</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js"></script>
 </head>
<body ng-app ng-controller="MyFilter">
 Lista Users AngularJS
<table>
<tr>
  <td>id</td>
  <td>Firstname</td>
  <td>LastName</td>
  <td>Gender</td>
  <td>Provincia</td>
  <td>City</td>
  <td>Adresa</td>

</tr>  
<tr ng-repeat="x in lista ">
  <td>{{x.userId}}</td>
  <td>{{x.firstName}}</td>
  <td>{{x.lastName}}</td>
  <td>{{x.gender}}</td>
  <td>{{x.provincia.nom}}</td>  
  <td>{{x.city.nom}}</td>
  <td>{{x.adresa.nom}}</td>
</tr>

</table>

 <script> 
       function MyFilter($scope)
  {           
     
    	   $scope.lista = ${lista};
    	   console.log($scope.lista); 
    
	}
  
</script>
</body>
</html>