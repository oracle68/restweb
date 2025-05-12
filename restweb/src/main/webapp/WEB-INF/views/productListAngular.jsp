<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>    <title>AngularJS User List</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js"></script-->
 </head>
<body ng-app ng-controller="MyFilter">
 Lista Products AngularJS
<table>
<tr>
  <td>id</td>
  <td>name</td>
  <td>description</td>
  <td>price</td>

</tr>  
<tr ng-repeat="elemento in lista track by $index">
  ID <td>{{elemento.id}}</td>
  Nombre<td>{{elemento.name}}</td> 
  Desc   <td>{{elemento.description}}</td>
  Price <td>{{elemento.price}}</td>
</tr>

</table>



 <script> 
       function MyFilter($scope,$document)
  {           
     
    	   $scope.lista = ${lista};
    	   console.log($scope.lista); 
    
	}
  
</script>
</body>
</html>