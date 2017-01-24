
angular.module('mainApp')
  .controller('bookDiningConfirm', ['$rootScope', '$scope', '$http', '$location', function ($rootScope,$scope,$http, $location)  { 
  $scope.cancel = function() {
var guest =$rootScope.guestId;	
var resv =$rootScope.reservationId;

		var req = {
    method: 'POST',
    url: 'http://10.74.100.243:9081/dining-reservation/dining/cancel_reservation',
    headers: {
		'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    
	data: {
guest_ID : guest,
reservation_ID:resv,
}
}

$http(req).then(function (response) {
 $location.path('/viewItineary');
	 console.log(JSON.stringify(response));
}, function (response) {
	alert("Guest Dining is not cancelled.");
   
});
};
     }]);

  
