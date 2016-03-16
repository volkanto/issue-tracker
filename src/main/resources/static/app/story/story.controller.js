angular.module('issueTracker').controller('StoryController', StoryController);

function StoryController($scope, Story, StoryPoint, StoryStatus, Developer, Sprint) 
{
	$scope.storyList = [];
	$scope.storyUnassignedList = [];
	$scope.story = {};
	$scope.storyStatusList = [];
	$scope.storyPointList = [];
	$scope.developerList = [];
	$scope.sprintList = [];
	$scope.assign = {};
	$scope.assignToSprint = {};
	$scope.unassignedSprintStoryList = [];
	
	$scope.listSprint = function() {
		Sprint.list(function(response) {
			$scope.sprintList = response ? response : [];
		});
	};
	
	$scope.listUnassignedStoryList = function() {
		Sprint.listUnassignedStoryList(function(response) {
			$scope.unassignedSprintStoryList = response ? response : [];
		});
	};
	
	$scope.assign = function() {
		Story.assign({ storyId: $scope.assign.story.id, developerId: $scope.assign.story.developer.id }, function(response) {
			$scope.listAll();
			$scope.listUnassignedStories();
		});
	};
	
	$scope.assignToSprint = function() {
		Sprint.assign({ sprintId: $scope.assignToSprint.sprintId, storyId: $scope.assignToSprint.storyId }, function(response) {
			Sprint.list();
			$scope.listUnassignedSprintStories();
		});
	};
	
	$scope.createOrEdit = function() {
		if($scope.story.issueId != null) {
			angular.forEach($scope.storyList, function(value, key) {
				if(value.issueId == $scope.story.issueId) {
					$scope.edit($scope.story);
					$scope.resetForm();
				}
			});
		} else {
			$scope.create($scope.story);
		}
	};
	
	$scope.refresh = function() {
		$scope.listAll();
	};
	
	$scope.listAll = function() {
		Story.list(function(response) {
			$scope.storyList = response ? response : [];
		});
	};
	
	$scope.isInSelectedPoint = function(argId) {
		return $scope.story.point != null && argId == $scope.story.point.id;
	};
	
	$scope.isInSelectedStatus = function(argId) {
		return $scope.story.status != null && argId == $scope.story.status.id;
	};
	
	$scope.isInSelectedDeveloper = function(argId) {
		return $scope.story.developer != null && argId == $scope.story.developer.id;
	}
	
	$scope.showEditPanel = function(argItem) {
		$scope.showNewStoryPanel = true;
		$scope.story = {
				issueId: argItem.issueId, 
				title: argItem.title,
				description: argItem.description,
				status : {
					id : argItem.status.id
				},
				point : {
					id : argItem.point != null ? argItem.point.id : null
				},
				developer : {
					id : argItem.developer != null ? argItem.developer.id : null
				}
		};
	};
	
	$scope.edit = function(argStory) {
		Story.update({ id: argStory.issueId }, argStory, function(item) {
			$scope.listAll();
		});
	};
	
	$scope.create = function(argStory) {
		Story.create(argStory, function(item) {
			$scope.listAll();
		}, function(error) {
			alert(error.data.message);
		});
		$scope.resetForm();
	};
	
	$scope.resetForm = function() {
		$scope.story = {};
	};
	
	$scope.listStoryPoint = function() {
		StoryPoint.list(function(response) {
			$scope.storyPointList = response ? response : [];
		});
	};
	
	$scope.listStoryStatus = function() {
		StoryStatus.list(function(response) {
			$scope.storyStatusList = response ? response : [];
		});
	};
	
	$scope.listDeveloper = function() {
		Developer.list(function(response) {
			$scope.developerList = response ? response : [];
		});
	};
	
	$scope.listUnassignedStories = function() {
		Story.listUnassigned(function(response) {
			$scope.storyUnassignedList = response ? response : [];
		});
	};
	
	$scope.init = function() {
		$scope.listAll();	
		$scope.listDeveloper();
		$scope.listStoryPoint()
		$scope.listStoryStatus();
		$scope.listUnassignedStories();
		$scope.listSprint();
		$scope.listUnassignedStoryList();
	};
		
	$scope.init();
}
