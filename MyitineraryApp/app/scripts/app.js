
angular.module('mainApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
	'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when("/", {
        templateUrl: 'views/mainPage.html',
        controller: 'mainCtrl',
        
      })
	  .when("/login", {
        templateUrl: 'views/login.html',
        controller: 'loginCtrl',
        
      })
	  .when("/registration", {
            templateUrl: "views/registration.html",
                    controller: "regCtrl"
            })
       .when("/bookResort", {
            templateUrl: "views/bookResort.html",
                    controller: "bookResort"
            })            
			.when("/bookResortConfirm", {
            templateUrl: "views/bookResortConfirm.html",
                    controller: "bookResortConfirm"
            })
            .when("/bookDining", {
            templateUrl: "views/bookDining.html",
                    controller: "bookDining"
            })
            .when("/viewItineary", {
            templateUrl: "views/itinerary.html",
                    controller: "itinerary"
            })
            .when("/bookDiningConfirm", {
            templateUrl: "views/bookDiningConfirm.html",
                    controller: "bookDiningConfirm"
                })
                .when("/homepage", {
            templateUrl: "views/homePage.html",
                    controller: "homePage"
					
                })
                    .otherwise({
                    redirectTo: 'views/main.html'
                    });
  });