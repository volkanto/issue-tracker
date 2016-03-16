angular.module('issueTracker').controller('DeveloperController', DeveloperController);

function DeveloperController($scope, Developer) 
{
	$scope.developerList = [];
	$scope.developer = {};
	$scope.developerBugList = [];
	$scope.developerStoryList = [];
	$scope.searchDeveloperBug = {};
	$scope.searchDeveloperStory = {};
	
	$scope.togglePanel = function() {
		if($scope.showNewDeveloperPanel) {
			$scope.showNewDeveloperPanel = false;
			$scope.developer = {};
		} else {
			$scope.showNewDeveloperPanel = true;
		}
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
		}, function(error) {
			alert(error.data.message);
		});
		$scope.resetForm();
	};
	
	$scope.resetForm = function() {
		$scope.developer = {};
	};
	
	$scope.listDeveloperBugs = function() {
		if($scope.searchDeveloperBug.id !== undefined) {
			Developer.get({ id: $scope.searchDeveloperBug.id }, function(response) {
				$scope.developerBugList = response ? response.bugs : [];
			}, function(error) {
				alert(error.message);
			});
		} else {
			alert("Choose correct developer!")
		}
	};
	
	$scope.listDeveloperStories = function() {
		if($scope.searchDeveloperStory.id !== undefined) {
			Developer.get({ id: $scope.searchDeveloperStory.id }, function(response) {
				$scope.developerStoryList = response ? response.stories : [];
			}, function(error) {
				alert(error.message);
			});	
		} else {
			alert("Choose correct developer!")
		}
	};
	
	$scope.init = function() {
		$scope.listAll(); 	
	};
	
	$scope.init();
}
