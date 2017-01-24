angular.module('mainApp')

  .controller('bookResort', ['$scope','$http','$location','$rootScope', function ($scope,$http,$location, $rootScope)  {

                  $rootScope.bgimg = "Images/bedroom.jpeg";

  $scope.today = function() {

    $scope.dt = new Date();

                $scope.dt1 = new Date();

  };

  $scope.today();

  $scope.clear = function() {

    $scope.dt = null;

                $scope.dt1 = null;

  };

 

  $scope.inlineOptions = {

    customClass: getDayClass,

    minDate: new Date(),

    showWeeks: true

  };

  

  

  $scope.dateOptions = {

    dateDisabled: disabled,

    formatYear: 'yy',

    maxDate: new Date(2020, 5, 22),

    minDate: new Date(),

    startingDay: 1

  };

 

 

  function disabled(data) {

    var date = new Date(),

      mode = data.mode;

    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);

  }


/*$(function () {

             var date = new Date();
             var currentMonth = date.getMonth();
             var currentDate = date.getDate();
             var currentYear = date.getFullYear();

            if("dt").length > 0){
                $("dt").datepicker({
                 maxDate: new Date(currentYear, currentMonth, currentDate)
             });
            }
})
  */
  
 /* $(function () {

                 $('#datetimepicker').datetimepicker({  minDate:new Date()});
           });*/

  $scope.toggleMin = function() {

    $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();

    $scope.dateOptions.minDate = $scope.inlineOptions.minDate;

  };

 

  $scope.toggleMin();

 

  $scope.open1 = function() {

    $scope.popup1.opened = true;

                };

 

  $scope.open2 = function() {

    $scope.popup2.opened = true;

                };

 

  $scope.setDate = function(year, month, day) {

    $scope.dt = new Date(year, month, day);

  };

 

  $scope.formats = ['yyyy-MM-dd', 'dd.MM.yyyy', 'shortDate'];

  $scope.format = $scope.formats[0];

  $scope.altInputFormats = ['M!/d!/yyyy'];

 

  $scope.popup1 = {

    opened: false

  };

 

  $scope.popup2 = {

    opened: false

  };

  

 

  

 $scope.dayDiff =function(){

                  d1=$scope.dt;

                  d2= $scope.dt1; 

 

                  $scope.numberOfNights = Math.floor((Date.UTC(d2.getFullYear(), d2.getMonth(), d2.getDate()) - Date.UTC(d1.getFullYear(), d1.getMonth(), d1.getDate()) ) /(1000 * 60 * 60 * 24));

  }

  

  var tomorrow = new Date();

  tomorrow.setDate(tomorrow.getDate() + 1);

  var afterTomorrow = new Date();

  afterTomorrow.setDate(tomorrow.getDate() + 1);

  $scope.events = [

    {

      date: tomorrow,

      status: 'full'

    },

    {

      date: afterTomorrow,

      status: 'partially'

    }

  ];

  

 

 

  function getDayClass(data) {

    var date = data.date,

      mode = data.mode;

    if (mode === 'day') {

      var dayToCheck = new Date(date).setHours(0,0,0,0);

 

      for (var i = 0; i < $scope.events.length; i++) {

        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

 

        if (dayToCheck === currentDay) {

          return $scope.events[i].status;

        }

      }

    }

 

    return '';

  }

                

                $scope.bookreset=function(){

                                

                                $scope.room_type='Standard';

                                $scope.dt=new Date();

                                $scope.dt1=new Date();

                                $scope.numberOfNights='0';

                                $scope.numberOfGuests='1';

                                

                };

  

  $scope.bookresort=function(){

                  

                                 

                   

                                  var guest=$rootScope.guestId;

                                  

                                  var rmtype=$scope.room_type;

                                  var checkin=$scope.dt;

                                  var checkout=$scope.dt1;

                                  var noofnights=$scope.numberOfNights;

                                  var noofguests=$scope.numberOfGuests;

                                  

                                  var req={

                                                  method:'POST',

                                                  url:'http://10.74.100.243:9081/resort-reservation/resort/book-reservation',

                                                  headers:{

                                                                'Accept': 'application/json',

                                                                'Content-Type': 'application/json'

    },

                data:{guest_ID:guest,resort_type:rmtype,checkIn_date:checkin,checkout_date:checkout,no_of_nights:noofnights,no_of_guests:noofguests}

                }

                

                $http(req).then(function(response){

                                

                                var d = response.data.data.checkIn_date;

                                dt = d.split('T')[0];

                                

                                var d1 = response.data.data.checkout_date;

                                dt1 = d1.split('T')[0];

                                

                                $location.path('/bookResortConfirm');

                                

                                $rootScope.resort_type = response.data.data.resort_type;

                                $rootScope.checkIn_date = dt;

                                $rootScope.checkout_date = dt1;

                                $rootScope.no_of_nights= response.data.data.no_of_nights;

                                $rootScope.no_of_guests= response.data.data.no_of_guests;

                                $rootScope.reservation= response.data.data.reservation_Id;

                                $rootScope.status= response.data.data.status;

                                

                                console.log(JSON.stringify(response));

                                

                },function(response){

                                

            alert(response.statusMsg);

        

                                });

 

                }

                                  

  

                                  }]);