var app=angular.module("myBanqueApp",[]);
app.controller("myBanqueController", function($scope,$http) {
	$scope.compte={};
	$scope.codeCompte=null;
	$scope.chargerCompte=function(){
		
	/*	$.getJSON( "http://localhost:8080/comptes/CC74", function( data ){
			alert("here");
			console.log(data);
		});*/
		$http.get("http://localhost:8080/comptes/"+$scope.codeCompte)
			.success(function(data){
				alert("dalkdsldkjaskl");
				$scope.compte=data;
			
		});
		/*var Url="/comptes/"+$scope.codeCompte;
		alert(Url);
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/comptes/CC74'
			}).then(function successCallback(response) {
			    alert("yes");
			    console.log("yes");
			  }, function errorCallback(response) {
				  alert("no");
				  console.log("no");
			  });*/
		/* $http.get("http://localhost:8080/comptes/CC74")
		  .then(function(response) {
			  console.log(response);
		      alert("yes");
		  });*/
		
	}
	
})