angular.module('issueTracker', ['ngRoute', 'ui.bootstrap', 'ngResource'])
		.config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when("/bug", {
				templateUrl : "app/bug/bug.list.html",
				controller : "BugController"
			}).when("/story", {
				templateUrl : "app/story/story.list.html",
				controller : "StoryController"
			}).when("/sprint", {
				templateUrl : "app/sprint/sprint.list.html",
				controller : "SprintController"
			}).when("/developer", {
				templateUrl : "app/developer/developer.list.html",
				controller : "DeveloperController"
			}).when("/developer/:id", {
				templateUrl : "/app/developer/developer.list.html",
				controller : "DeveloperController"
			}).when("/dev/bug", {
				templateUrl : "/app/developer/bug/developer.bug.html",
				controller : "DeveloperBugController"
			}).when("/dev/story", {
				templateUrl : "/app/developer/story/developer.story.html",
				controller : "DeveloperStoryController"
			}).when("/home", {
				templateUrl : "/app/application/home.html",
				controller : "AppController"
			})
			.otherwise({
				redirectTo : '/home'
			});
		} ]);
