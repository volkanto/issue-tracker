angular.module('issueTracker').controller('HeaderController', HeaderController);

function HeaderController($scope, $location) {
	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};
}
