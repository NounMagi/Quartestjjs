'use strict';

var app = angular.module("app");

var dropLinkFunction = function (attributeName, funcDrop) {
    var linkFunction = function (scope, element, attributes, ctlr) {
        element.bind("dragover", function(eventObject){
                eventObject.preventDefault();
            });
        element.bind("drop", function(eventObject) {
                // invoke controller/scope move method
                var tileId = eventObject.dataTransfer.getData("text");
                var dropTargetAttributeValue = eventObject.target.getAttribute(attributeName);
                var elementType = element;
                var tileElement = document.getElementById(tileId);
                if(dropTargetAttributeValue) {
                    eventObject.target.appendChild(document.getElementById(tileId));
                }else{
                    var pool = document.getElementById("piecespool");
                    pool.appendChild(tileElement);
                }
                
                
                // cancel actual UI element from dropping, since the angular will recreate a the UI element
                eventObject.preventDefault();
            });
    }
    return linkFunction;
}

app.directive("dropBoardTile",["gameService", function (gameService){
    return {
        restrict: "A",
        link: dropLinkFunction("drop-board-tile", function(){})
    };
}]);

app.directive("dropPiecePool",["gameService", function (gameService){
    return {
        restrict: "A",
        link: dropLinkFunction("drop-piece-pool", function(){})
    };
}]);


app.directive("draggablePiece",["gameService", function (gameService){
    return {
        restrict: "A",
        link: function(scope, element, attributes, ctlr) {
            element.attr("draggable", true);
            element.bind("dragstart", function(eventObject) {
                eventObject.dataTransfer.setData("text", element.attr('id'))
            });
        }
    };
}]);


app.directive("pieceDirective", function () {
   var directive = {
       templateUrl : "directives/piecetemplate.html",
       scope : {
           shape: '@shape',
           color: '@color',
           height: '@height',
           hole: '@hole',
           id: '@id'
       },
       link : function ($scope, el, attrs, ctrl)
       {
           var canvas = el[0].firstElementChild
           var drawCtx = canvas.getContext("2d")
           var mult = 1.0
           var canvasWidth = canvas.width
           var canvasHeight = canvas.height
           var radius = 30
           var squareSide = 50
           
           
           if($scope.height === 'BIG')
           {
               mult = 1.5
           }
           
           switch($scope.shape) {
               case 'SQUARE':
                   drawCtx.beginPath()
                   drawCtx.fillStyle = $scope.color
                   var centerWidth = canvasWidth*0.5 - (squareSide * mult * 0.5)
                   var centerHeight = canvasHeight*0.5 - (squareSide * mult * 0.5)
                   drawCtx.rect(centerWidth, centerHeight, squareSide * mult, squareSide * mult)
                   drawCtx.fill()
                   drawCtx.stroke()
                   
                   break;
               case 'ROUND':
                   drawCtx.beginPath()
                   drawCtx.fillStyle = $scope.color
                   drawCtx.arc(canvasWidth*0.5,canvasHeight*0.5, radius * mult,0, 2*Math.PI)
                   drawCtx.fill()
                   drawCtx.stroke()
                   break;
           }
           
           if($scope.hole === 'true')
           {
               drawCtx.beginPath();
               drawCtx.fillStyle = 'white'
               drawCtx.arc(canvasWidth*0.5,canvasHeight*0.5, 10,0, 2*Math.PI)
               drawCtx.fill()
               drawCtx.stroke()
           }
           
       }
   }
   return directive;
});

app.directive("boardtileDirective", function() {
    var directive = {
        templateUrl : "directives/boardtiletemplate.html",
        scope : {
            ncol: '@ncol',
            nrow: '@nrow'
        },
        controller : "BoardTileCtrl",
        link : function ($scope, el, attrs, ctrl) {
            console.log("Linked")
        }
    }
    
    return directive;
});