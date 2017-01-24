'use strict';

describe('Controller: regCtrl', function () {

  // load the controller's module
  beforeEach(module('mainApp'));

  var regCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    regCtrl = $controller('regCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(regCtrl.awesomeThings.length).toBe(3);
  });
});
