angular.module('issueTracker').factory('StoryStatus', StoryStatusFactory);

function StoryStatusFactory($resource) {
	return $resource('/story/status/list', null, {
		list : {
			method : 'GET',
			isArray:true
		}
	});
}
