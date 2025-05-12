<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="expandCollapseApp">
<head>    
 <title>AngularJS Invoice List</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-animate.min.js"></script>
 </head>
<body  ng-controller="expandCollapseCtrl">
 Lista Invoice AngularJS

<table>
<tr>
  <td>id</td>
  <td>status</td>
  <td>date</td>
  <td>customer</td>
  <td>linesProduct</td>
  <td>linesPrice</td>
    <td>linesQty</td>
  <td>linesProduct1</td>
  <td>linesPrice1</td>
    <td>linesQty1</td>    
</tr>  
<tr ng-repeat="elemento in lista">
   <td>{{elemento.id}}</td>
  <td>{{elemento.status}}</td> 
     <td>{{elemento.registDate}}</td>
   <td>{{elemento.customer.firstname}}</td>
   <td>{{elemento.lines[0].product}}</td>
	<td>{{elemento.lines[0].price}}</td>
	<td>{{elemento.lines[0].quantity}}</td>
   <td>{{elemento.lines[1].product}}</td>
	<td>{{elemento.lines[1].price}}</td>
	<td>{{elemento.lines[1].quantity}}</td>

</tr>	
</table>

<table border="1">
<tr>
  <td>id</td>
  <td>status</td>
  <td>date</td>
  <td>customer</td>
  <td>linesProduct linesPrice linesQty</td>
</tr>  
<tr ng-repeat="elemento in lista">
   <td>{{elemento.id}}</td>
  <td>{{elemento.status}}</td> 
     <td>{{elemento.registDate}}</td>
   <td>{{elemento.customer.firstname}}</td>
   <td ng-repeat="e in elemento.lines">{{e.product}} - {{e.price}} - {{e.quantity}}</td>

</tr>	
</table>

<div class="expandcollapse-item">
 <div ng-click="active = !active" ng-class="{'expandcollapse-heading-collapsed': active, 'expandcollapse-heading-expanded': !active}">
	<button>+</button>
 </div>
</div>        

        <div class="slideDown" ng-hide="active">
          <div class="expand-collapse-content">
			   <ul>
			    <li  ng-repeat="parent in lista">{{parent.id}} FirstName:{{parent.customer.firstname}} LastName:{{parent.customer.lastname}}
			      <ul>
			        <li  ng-repeat="child in parent.lines">Product:{{child.product}} Price:{{child.price}} Qty:{{child.quantity}}</li>
			      </ul>
			    </li>
			  </ul>          
        </div>
      </div>

 <script> 
 
 var expandCollapseApp = angular.module('expandCollapseApp', ['ngAnimate']);

 expandCollapseApp.controller('expandCollapseCtrl', function ($http,$scope) {
         $scope.active = true;
         $scope.active1 = true;

         $http.get('invoiceListJson')
    	    .success(function (response){
    	        $scope.lista = response;
    	        console.log($scope.lista);
    	    })
    	    .error(function (response){
    	        	        console.log(response); 
    	  }); 
         
 });
  
</script>
</body>
</html>