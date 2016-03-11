angular.module('issueTracker').controller('StoryController', StoryController);

function StoryController($scope, Story, StoryPoint, StoryStatus, Developer) 
{
	$scope.storyList = [];
	$scope.showNewStoryPanel = true;
	$scope.story = {};
	$scope.storyStatusList = [];
	$scope.storyPointList = [];
	$scope.developerList = [];
	
	$scope.togglePanel = function() {
		if($scope.showNewStoryPanel) {
			$scope.showNewStoryPanel = false;
			$scope.story = {};
		} else {
			$scope.showNewStoryPanel = true;
		}
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
		Story.update({ id: argStory.issueId }, argStory);
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
	
	$scope.init = function() {
		$scope.listAll();	
		$scope.listDeveloper();
		$scope.listStoryPoint()
		$scope.listStoryStatus();
	};
	
	$scope.init();
}
