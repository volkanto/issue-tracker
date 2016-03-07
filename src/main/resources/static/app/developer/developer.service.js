angular.module('issueTracker').factory('Developer', DeveloperFactory);

function DeveloperFactory($resource) {
	return $resource('/developer/:id', {
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
			url : '/developer/list',
			isArray:true
		},
		create: {
			method: 'POST',
			url	: '/developer/create'
		}
	});
}
