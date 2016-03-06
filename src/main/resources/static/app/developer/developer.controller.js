angular.module('issueTracker').controller('DeveloperController', DeveloperController);

function DeveloperController($scope) {
	$scope.developerList = [{id: 1, name: 'volkan1'}, {id: 2, name: 'volkan2'}, {id: 3, name: 'volkan3'}];

	$scope.addNew = function() {
		var newOne = {id: 4, name: 'volkan4'};
		$scope.developerList.push(newOne);
	};
	
	$scope.remove = function(argIndex) {
		console.log(argIndex);
		$scope.developerList.splice(argIndex, 1);
	};
}
