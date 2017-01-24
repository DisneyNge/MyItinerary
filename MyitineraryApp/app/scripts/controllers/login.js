
angular.module('mainApp')
  .controller('loginCtrl', ['$scope', '$http', '$location','$rootScope', function ($scope,$http,$location,$rootScope) {
$rootScope.bgimg = "Images/colourfull.jpeg";
$scope.login = function() {
	
var email =$scope.email;
var pwd = $scope.password;

	 
var req = {
    method: 'POST',
    url: 'http://10.74.100.243:9081/guest-profile/guest/validateguest',
    headers: {
		'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    data: { guest_email: email, guest_pwd: pwd }
}

$http(req).then(function (response) {
   $location.path('/homepage');
   $rootScope.guestId = response.data.data.guestID;
   $rootScope.firstname = response.data.data.guest_first_name;
    $rootScope.lastname = response.data.data.guest_last_name;
  console.log(JSON.stringify(response));
    
}, function (response) {
    alert("User Invalid");
});
};
}]);

