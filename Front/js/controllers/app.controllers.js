'use strict';

var app = angular.module("app");


app.controller("LoginCtrl", function LoginCtrl($scope, $location) {
    
    $scope.JoinGameButtonClicked = function JoinGameButtonClicked()
    {
        $location.path('/game').replace();
    }
    
});


app.controller("GameCtrl", function GameCtrl($scope, $location, gameService) {
    $scope.pieces = [{
        id : 1,
        shape : "ROUND",
        hole : true,
        height : "SMALL",
        color: "black"
    },{
        id : 2,
        shape : "SQUARE",
        hole : true,
        height : "BIG",
        color: "white"
    }];
});

app.controller("BoardTileCtrl", function BoardTileCtrl($scope, $location, gameService) {

});
