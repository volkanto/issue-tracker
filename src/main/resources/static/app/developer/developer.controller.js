angular.module('issueTracker').controller('DeveloperController', DeveloperController);

function DeveloperController($scope) 
{
	$scope.developerList = [];
	$scope.showNewDeveloperPanel = false;
	$scope.developer = {};
	
	$scope.openNewPanel = function() {
		$scope.showNewDeveloperPanel = true;
	};
	
	$scope.closeNewPanel = function() {
		$scope.showNewDeveloperPanel = false;
	};
	
	$scope.createOrEdit = function() {
		if($scope.developer.id != null) {
			angular.forEach($scope.developerList, function(value, key) {
				if(value.id == $scope.developer.id) {
					value.name = $scope.developer.name;
					$scope.edit($scope.developer);
					$scope.resetForm();
				}
			});
			
		} else {
			var newOne = {id: $scope.id, name: $scope.developer.name};
			$scope.create(newOne);
			$scope.developerList.push(newOne);
			$scope.resetForm();
		}
	};
	
	$scope.remove = function(argIndex) {
		// TODO: remove service
		$scope.developerList.splice(argIndex, 1);
	};
	
	$scope.refresh = function() {
		// TODO: list all developer service
		$scope.listAll();
	};
	
	$scope.listAll = function() {
		// TODO: list all developer service
		$scope.developerList = [{id: 1, name: 'volkan1'}, {id: 2, name: 'volkan2'}, {id: 3, name: 'volkan3'}];
	};
	
	$scope.showEditPanel = function(argItem) {
		$scope.showNewDeveloperPanel = true;
		$scope.developer = {id: argItem.id, name: argItem.name};
	};
	
	$scope.edit = function(argDeveloper) {
		// TODO: update service
	};
	
	$scope.create = function(argDeveloper) {
		// TODO: create service
	};
	
	$scope.resetForm = function() {
		$scope.developer = {};
	};
}
