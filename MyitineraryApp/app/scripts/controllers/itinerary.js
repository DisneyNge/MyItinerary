angular.module('mainApp')

    .service('myService', function($http, $rootScope) {

        var chk = $rootScope.guestId;



        this.getData = function(book) {

            $http({




                method: 'GET',

                url: 'http://10.74.100.243:9081/guest-itinerary/guest/itinerary/' + chk,

            }).success(function(data) {

                book(data);



            }).error(function() {

                alert("error");

            });

        }

    });




angular.module('mainApp')

    .controller('itinerary', ['$scope', '$http', '$location', '$rootScope', 'myService', '$route', function($scope, $http, $location, $rootScope, myService, $route) {

        myService.getData(function(response) {

            $rootScope.bgimg = "Images/iti.png";




            $scope.data = response;

            var s = JSON.parse(response.data.resortList);

            console.log('s: ' + JSON.stringify(s));

            $scope.resortList = s.data;



            $scope.data = response;

            var dine = JSON.parse(response.data.diningList);

            console.log('dine: ' + JSON.stringify(dine));

            $scope.diningList = dine.data;



        });




        $scope.cancel = function(res) {
            console.log('---------------------'+res);



            var guest = $rootScope.guestId;

            var reserve = res;



            var req = {

                method: 'POST',

                url: 'http://10.74.100.243:9081/resort-reservation/resort/cancel-reservation',

                headers: {

                    'Accept': 'application/json',

                    'Content-Type': 'application/json'

                },

                data: {
                    guest_ID: guest,
                    reservation_Id: reserve
                }

            }



            $http(req).then(function(response) {

                //$location.path('/viewItineary');

                console.log(JSON.stringify(response));

                $route.reload();

               



            }, function(response) {

                alert('service not provided');

            });



        };



        $scope.dineCancel = function(din) {
 console.log('---------------------'+din);


            var guest = $rootScope.guestId;

            var dine = din;



            var req = {

                method: 'POST',

                url: 'http://10.74.100.243:9081/dining-reservation/dining/cancel_reservation',

                headers: {

                    'Accept': 'application/json',

                    'Content-Type': 'application/json'

                },

                data: {
                    guest_ID: guest,
                    reservation_ID: dine
                }

            }



            $http(req).then(function(response) {

                //$location.path('/viewItineary');

                console.log(JSON.stringify(response));
				$route.reload();



            }, function(response) {

                alert('service not provided');

            });



        };




    }]);