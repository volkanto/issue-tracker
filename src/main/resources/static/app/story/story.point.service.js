angular.module('issueTracker').factory('StoryPoint', StoryPointFactory);

function StoryPointFactory($resource) {
	return $resource('/story/point/list', null, {
		list : {
			method : 'GET',
			isArray:true
		}
	});
}
