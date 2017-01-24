
angular.module('mainApp')
  .controller('bookResortConfirm', ['$scope','$http','$location','$rootScope',function ($scope,$http,$location,$rootScope)  {
	  
	 
	  
	  $scope.cancelResort=function(){
	   
		 var guest=$rootScope.guestId;
		 var reserve=$scope.reservation;
		 
		 var req={
			  method:'POST',
			  url:'http://10.74.100.243:9081/resort-reservation/resort/cancel-reservation',
			  headers:{
				 'Accept': 'application/json',
				'Content-Type': 'application/json'
    },
	data:{guest_ID:guest,reservation_Id:reserve}
	}
	
	$http(req).then(function(response){
		$location.path('/viewItineary');
		console.log(JSON.stringify(response));
		
		
	},function(response){
		alert('service not provided');
	});
		  
  };
}]);
   
  
