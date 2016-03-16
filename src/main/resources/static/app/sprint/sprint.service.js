angular.module('issueTracker').factory('Sprint', SprintFactory);

function SprintFactory($resource) {
	return $resource('/sprint/:id', {
		id : '@id'
	}, {
		update : {
			method : "PUT"
		},
		list : {
			method : 'GET',
			url : '/sprint/list',
			isArray:true
		},
		listUnassignedStoryList : {
			method : 'GET',
			url : '/sprint/unassigned/story/list',
			isArray:true
		},
		create: {
			method: 'POST',
			url	: '/sprint/create'
		}, 
		assign : {
			method : 'POST',
			url : '/sprint/:sprintId/assign/story/:storyId',
			params: { sprintId : '@sprintId', storyId : '@storyId' }
		}
	});
}
