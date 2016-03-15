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
		create: {
			method: 'POST',
			url	: '/sprint/create'
		}
	});
}
