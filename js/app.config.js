'use strict';
var app = angular.
  module('app',["ngRoute"]).
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
          templateUrl: 'partials/login.html',
          controller: 'LoginCtrl'
        }).
        when('/game',{
            templateUrl: 'partials/game.html',
            controller: 'GameCtrl'
        }).
        otherwise('/');
    }
  ]);
