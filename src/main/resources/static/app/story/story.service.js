angular.module('issueTracker').factory('Story', StoryFactory);

function StoryFactory($resource) {
	return $resource('/story/:id', {
		id : '@id'
	}, {
		update : {
			method : "PUT"
		},
		remove : {
			method : "DELETE"
		},
		list : {
			method : 'GET',
			url : '/story/list',
			isArray:true
		},
		listUnassigned : {
			method : 'GET',
			url : '/story/unassigned/list',
			isArray : true
		},
		create: {
			method: 'POST',
			url	: '/story/create'
		},
		assign : {
			method : 'POST',
			url : '/story/assign/:storyId/developer/:developerId',
			params: { storyId : '@storyId', developerId : '@developerId' }
		}
	});
}
