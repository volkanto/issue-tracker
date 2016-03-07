angular.module('issueTracker').controller('DeveloperController', DeveloperController);

function DeveloperController($scope, Developer) 
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
			$scope.create({id: null, name: $scope.developer.name});
		}
	};
	
	$scope.remove = function(argDeveloper) {
		Developer.remove({ id: argDeveloper.id }, function(response) {
			angular.forEach($scope.developerList, function(value, key){
				if(value.id == argDeveloper.id) {
					$scope.developerList.splice(key, 1);					
				}
			});
		});
	};
	
	$scope.refresh = function() {
		$scope.listAll();
	};
	
	$scope.listAll = function() {
		Developer.list(function(response) {
			$scope.developerList = response ? response : [];
		});
	};
	
	$scope.showEditPanel = function(argItem) {
		$scope.showNewDeveloperPanel = true;
		$scope.developer = {id: argItem.id, name: argItem.name};
	};
	
	$scope.edit = function(argDeveloper) {
		Developer.update({ id:argDeveloper.id }, argDeveloper);
	};
	
	$scope.create = function(argDeveloper) {
		Developer.create(argDeveloper, function(item) {
			$scope.developerList.push(item);
		});
		$scope.resetForm();
	};
	
	$scope.resetForm = function() {
		$scope.developer = {};
	};
	
	$scope.listAll(); // initialize list on load
}
