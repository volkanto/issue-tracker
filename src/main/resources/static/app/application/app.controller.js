angular.module('issueTracker').controller('AppController', AppController);

function AppController($scope) {
    $scope.developers = 0;
    $scope.bugs = 0;
    $scope.stories = 0;
    $scope.sprints = 0;
}
