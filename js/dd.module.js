//var DropTarget= function () {
// 
//    return {
//        restrict: "A",
//        controller: "GameCtrl",
//        link: function (scope, element, attributes, ctlr) {
// 
//            element.bind("dragover", function(eventObject){
//                eventObject.preventDefault();
//            });
// 
//            element.bind("drop", function(eventObject) {
//                // invoke controller/scope move method
//                var tileId = eventObject.dataTransfer.getData("text");
//                var dropTargetAttributeValue = eventObject.target.getAttribute("dd-drop-target");
//                if(dropTargetAttributeValue) {
//                    debugger;
//                    eventObject.target.appendChild(document.getElementById(tileId));
//                }
//                
//                
//                // cancel actual UI element from dropping, since the angular will recreate a the UI element
//                eventObject.preventDefault();
//            });
//        }
//    };
//}
//
//var Draggable = function () {
// 
//    return {
//        restrict: "A",
//        controller: "GameCtrl",
//        link: function(scope, element, attributes, ctlr) {
//            element.attr("draggable", true);
//            element.bind("dragstart", function(eventObject) {
//                eventObject.dataTransfer.setData("text", element.attr('id'))
//            });
//        }
//    };
//}
//
////angular.module("dd", [])
////    .directive("ddDraggable", Draggable)
////    .directive("ddDropTarget", DropTarget);
