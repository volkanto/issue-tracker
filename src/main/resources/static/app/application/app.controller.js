angular.module('issueTracker').controller('AppController', AppController);

function AppController($scope, Developer, Bug, Story, Sprint) {
    $scope.developers = 0;
    $scope.bugs = 0;
    $scope.stories = 0;
    $scope.sprints = 0;
    
    $scope.developerSize = function() {
    	Developer.list(function(response) {
    		$scope.developers = response ? response.length : 0;
		});
    };
    
    $scope.bugSize = function() {
    	Bug.list(function(response) {
			$scope.bugs = response ? response.length : 0;
		});
    };
    
    $scope.storySize = function() {
    	Story.list(function(response) {
    		$scope.stories = response ? response.length : 0;
		});
    };
    
    $scope.sprintSize = function() {
    	Sprint.list(function(response) {
    		$scope.sprints = response ? response.length : 0;
		});
    };
    
    $scope.init = function() {
    	$scope.developerSize();
    	$scope.bugSize();
    	$scope.storySize();
    	$scope.sprintSize();
    };
    
    $scope.init();
}
