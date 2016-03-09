angular.module('issueTracker').controller('BugController', BugController);

function BugController($scope, Bug, Developer, BugPriority, BugStatus) 
{
	$scope.bugList = [];
	$scope.showNewBugPanel = true;
	$scope.bug = {};
	$scope.bugPriorityList = [];
	$scope.developerList = [];
	$scope.bugStatusList = [];
	
	$scope.togglePanel = function() {
		if($scope.showNewBugPanel) {
			$scope.showNewBugPanel = false;
			$scope.bug = {};
		} else {
			$scope.showNewBugPanel = true;
		}
	};
	
	$scope.createOrEdit = function() {
		if($scope.bug.issueId != null) {
			angular.forEach($scope.bugList, function(value, key) {
				if(value.issueId == $scope.bug.issueId) {
					value.title = $scope.bug.title;
					$scope.edit($scope.bug);
					$scope.resetForm();
				}
			});
		} else {
			$scope.create($scope.bug);
		}
	};
	
	$scope.refresh = function() {
		$scope.listAll();
	};
	
	$scope.listAll = function() {
		Bug.list(function(response) {
			console.log(response);
			$scope.bugList = response ? response : [];
		});
	};
	
	$scope.isInSelectedPriority = function(argId) {
		return $scope.bug.priority != null && argId == $scope.bug.priority.id;
	};
	
	$scope.isInSelectedStatus = function(argId) {
		return $scope.bug.status != null && argId == $scope.bug.status.id;
	};
	
	$scope.isInSelectedDeveloper = function(argId) {
		return $scope.bug.developer != null && argId == $scope.bug.developer.id;
	}
	
	$scope.showEditPanel = function(argItem) {
		$scope.showNewBugPanel = true;
		$scope.bug = {
				id: argItem.id, 
				title: argItem.title,
				description: argItem.description,
				status : {
					id : argItem.status.id
				},
				priority : {
					id : argItem.priority.id
				},
				developer : {
					id : argItem.developer.id
				}
		};
	};
	
	$scope.edit = function(argBug) {
		Bug.update({ id: argBug.issueId }, argBug);
	};
	
	$scope.create = function(argBug) {
		Bug.create(argBug, function(item) {
			$scope.bugList.push(item);
		}, function(error) {
			alert(error.data.message);
		});
		$scope.resetForm();
	};
	
	$scope.resetForm = function() {
		$scope.bug = {};
	};
	
	$scope.listBugPriority = function() {
		BugPriority.list(function(response) {
			$scope.bugPriorityList = response ? response : [];
		});
	};
	
	$scope.listBugStatus = function() {
		BugStatus.list(function(response) {
			$scope.bugStatusList = response ? response : [];
		});
	};
	
	$scope.listDeveloper = function() {
		Developer.list(function(response) {
			$scope.developerList = response ? response : [];
		});
	};
	
	$scope.init = function() {
		$scope.listAll();	
		$scope.listDeveloper();
		$scope.listBugPriority()
		$scope.listBugStatus();
	};
	
	$scope.init();
	
}
