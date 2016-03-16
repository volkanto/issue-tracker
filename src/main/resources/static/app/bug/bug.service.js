angular.module('issueTracker').factory('Bug', BugFactory);

function BugFactory($resource) {
	return $resource('/bug/:id', {
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
			url : '/bug/list',
			isArray:true
		},
		listUnassigned : {
			method : 'GET',
			url : '/bug/unassigned/list',
			isArray : true
		},
		create: {
			method: 'POST',
			url	: '/bug/create'
		},
		assign : {
			method : 'POST',
			url : '/bug/assign/:bugId/developer/:developerId',
			params: { bugId : '@bugId', developerId : '@developerId' }
		}
	});
}
