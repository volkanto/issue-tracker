angular.module('issueTracker').controller('BugController', BugController);

function BugController($scope, Bug, BugPriority, BugStatus, Developer) 
{
	$scope.bugList = [];
	$scope.bugUnassignedList = [];
	$scope.bug = {};
	$scope.bugPriorityList = [];
	$scope.developerList = [];
	$scope.bugStatusList = [];
	$scope.assign = {};
	
	$scope.assign = function() {
		Bug.assign({ bugId: $scope.assign.bug.id, developerId: $scope.assign.bug.developer.id }, function(response) {
			$scope.listAll();
			$scope.listUnassignedBugs();
		});
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
				issueId: argItem.issueId, 
				title: argItem.title,
				description: argItem.description,
				status : {
					id : argItem.status.id
				},
				priority : {
					id : argItem.priority.id
				},
				developer : {
					id : argItem.developer != null ? argItem.developer.id : null
				}
		};
	};
	
	$scope.edit = function(argBug) {
		Bug.update({ id: argBug.issueId }, argBug, function(item) {
			$scope.listAll();
		});
	};
	
	$scope.create = function(argBug) {
		Bug.create(argBug, function(item) {
			$scope.listAll();
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
	
	$scope.listUnassignedBugs = function() {
		Bug.listUnassigned(function(response) {
			$scope.bugUnassignedList = response ? response : [];
		});
	};
	
	$scope.init = function() {
		$scope.listAll();	
		$scope.listDeveloper();
		$scope.listBugPriority()
		$scope.listBugStatus();
		$scope.listUnassignedBugs();
	};
	
	$scope.init();
}
