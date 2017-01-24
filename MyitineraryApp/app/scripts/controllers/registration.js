angular.module("mainApp")
 .directive('pwCheck', [function () {
    return {
      require: 'ngModel',
      link: function (scope, elem, attrs, ctrl) {
        var firstPassword = '#' + attrs.pwCheck;
          elem.add(firstPassword).on('keyup', function () {
          scope.$apply(function () {
            var v = elem.val()===$(firstPassword).val();
            ctrl.$setValidity('pwmatch', v);
          });
        }); 
      }
    }
  }]);
  
  angular.module("mainApp")
 .controller('regCtrl', ['$rootScope', '$scope', '$http', '$location', function ($rootScope,$scope,$http, $location) {
	 $rootScope.bgimg = "Images/registeration.jpeg";
	$scope.defaultFormData = { email : '', firstname :'', lastname:'', address: '', phone:'', pw1:'', pw2:''}
   $scope.user=angular.copy($scope.defaultFormData);
//$scope.resetCopy = angular.copy($scope.defaultFormData);

$scope.resetForm =  function() {
   //$scope.defaultFormData = {};
//alert($scope.userForm.$valid);
    //$scope.defaultFormData = angular.copy($scope.resetCopy);
    $scope.userForm.$setPristine();
	//$scope.userForm.$setValidity();
    $scope.userForm.$setUntouched();
	$scope.user = angular.copy($scope.defaultFormData);
    
    
    //$scope.$apply();
} 
 
$scope.submit = function() {
var email =$scope .email;
var fname =$scope.firstname;
var lname =$scope.lastname;
var add =$scope .address;
var phone =$scope .phone;
var pw1 =$scope .pw1;
var pw2 = $scope.pw2;
  
  var req = {
    method: 'POST',
    url: 'http://10.74.100.243:9081/guest-profile/guest/createguest',
    headers: {
  'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    
 data: {
    guest_email: email ,
    guest_first_name: fname ,
    guest_last_name: lname ,
 guest_address: add,
    guest_phone_no: phone,
    guest_pwd: pw1,
 guest_pwd: pw2,
 }
}
$http(req).then(function (response) {
    $location.path("/homepage");
 $rootScope.guestId =response.data.data.guestId; 
  $rootScope.firstname =response.data.data. guest_first_name; 
   $rootScope.lastname = response.data.data.guest_last_name;
 console.log(JSON.stringify(response));
}, function (response) {
 alert("User is not valid, User already exists");
    
});
};
   
     }]);
 
