angular.module('mainApp')
   .controller('bookDining',['$rootScope', '$scope', '$http', '$location', function ($rootScope,$scope,$http, $location) { 
   $rootScope.bgimg = "Images/newdine.jpg";
   
  $scope.today = function() {
    $scope.dt = new Date();
  };
  $scope.today();
  $scope.clear = function() {
    $scope.dt = null;
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
  // Disable weekend selection
  function disabled(data) {
    var date = data.date,
                      mode = data.mode;
    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
  }
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
  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
  $scope.format = $scope.formats[0];
  $scope.altInputFormats = ['M!/d!/yyyy'];
  $scope.popup1 = {
    opened: false
  };
  $scope.popup2 = {
    opened: false
  };
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
   function addMinutes(time/*"hh:mm"*/, minsToAdd/*"N"*/) 
{
        function z(n)
        {
           return (n<10? '0':'') + n;
        }
        var bits = time.split(':');
        var mins = bits[0]*60 + (+bits[1]) + (+minsToAdd);
        return z(mins%(24*60)/60 | 0) + ':' + z(mins%60); 
 }  

 
$scope.book = function() {
var guest =$rootScope.guestId; 
var dtype =$scope.diningType;
var date =$scope.dt;
var noOfGuests =$scope.noOfGuests;
var dtime = $scope.dtime;
 var d = new Date($scope.dtime);
      var hours=d.getHours();
      var minutes=Math.round(d.getMinutes());
    
      var Time=hours+':'+minutes;
     
      $scope.displayTime=Time;
 var matime=$scope.displayTime;
       
  
  var req = {
    method: 'POST',
    url: 'http://10.74.100.243:9081/dining-reservation/dining/book_reservation',
    headers: {
  'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    
 data: {
guest_ID : guest,
dining_type : dtype,
dineIn_date : date,
no_Of_Guests : noOfGuests,
dineIn_time : matime,
 }
}
$http(req).then(function (response) {
 
 
 var dt = response.data.data.dineIn_date;
 dt = dt.split('T')[0];
 
    $location.path("/bookDiningConfirm");
 $rootScope.dining_type = response.data.data.dining_type;
 $rootScope.dineIn_date = dt;
 $rootScope.no_Of_Guests = response.data.data.no_Of_Guests;
 $rootScope.dineIn_time  = response.data.data.dineIn_time ;
 $rootScope.reservationId =response.data.data.reservation_ID; 
 $rootScope.status =response.data.data.status; 
  console.log(JSON.stringify(response));
 
}, function (response) {
 alert(response.statusMsg);
});
};
   
     }]);
 
