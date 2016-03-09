angular.module('issueTracker').factory('BugStatus', BugStatusFactory);

function BugStatusFactory($resource) {
	return $resource('/bug/status/list', null, {
		list : {
			method : 'GET',
			isArray:true
		}
	});
}
