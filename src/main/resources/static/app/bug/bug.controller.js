angular.module('issueTracker').controller('BugController', BugController);

function BugController($scope, Bug) 
{
	$scope.bugList = [];
	$scope.showNewBugPanel = true;
	$scope.bug = {};
	
	$scope.togglePanel = function() {
		if($scope.showNewBugPanel) {
			$scope.showNewBugPanel = false;
			$scope.bug = {};
		} else {
			$scope.showNewBugPanel = true;
		}
	};
	
	$scope.createOrEdit = function() {
		if($scope.bug.id != null) {
			angular.forEach($scope.bugList, function(value, key) {
				if(value.id == $scope.bug.id) {
					value.title = $scope.bug.title;
					$scope.edit($scope.bug);
					$scope.resetForm();
				}
			});
		} else {
			$scope.create({id: null, name: $scope.argBug.title});
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
	
	$scope.showEditPanel = function(argItem) {
		$scope.showNewBugPanel = true;
		$scope.bug = {
				id: argItem.id, 
				title: argItem.title,
				description: argItem.description,
				status : {
					id : argItem.status.id,
					description : argItem.status.description
				},
				priority : {
					id : argItem.status.id,
					description : argItem.status.description
				}
		};
	};
	
	$scope.edit = function(argBug) {
		Bug.update({ id: argBug.id }, argBug);
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
	
	$scope.listAll(); // initialize list on load
}
