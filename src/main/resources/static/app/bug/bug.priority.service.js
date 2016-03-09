angular.module('issueTracker').factory('BugPriority', BugPriorityFactory);

function BugPriorityFactory($resource) {
	return $resource('/bug/priority/list', null, {
		list : {
			method : 'GET',
			isArray:true
		}
	});
}
