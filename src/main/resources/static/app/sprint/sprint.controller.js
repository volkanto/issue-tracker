angular.module('issueTracker').controller('SprintController', SprintController);

function SprintController($scope, Sprint) {
	$scope.sprint = {};
	$scope.searchSprint = {};
	$scope.sprintList = [];
	$scope.sprintStoryList = [];
	
	$scope.createOrEdit = function() {
		if($scope.sprint.id != null) {
			angular.forEach($scope.sprintList, function(value, key) {
				if(value.id == $scope.sprint.id) {
					$scope.edit($scope.sprint);
					$scope.resetForm();
				}
			});
		} else {
			$scope.create($scope.sprint);
		}
	};
	
	$scope.edit = function(argSprint) {
		Sprint.update({ id: argSprint.id }, argSprint, function(item) {
			$scope.listAll();
		});
	};
	
	$scope.create = function(argSprint) {
		$scope.sprint.startDate = $scope.sprint.startDate.getTime();
		$scope.sprint.endDate = $scope.sprint.endDate.getTime();
		Sprint.create(argSprint, function(item) {
			$scope.listAll();
		}, function(error) {
			alert(error.data.message);
		});
		$scope.resetForm();
	};
	
	$scope.resetForm = function() {
		$scope.sprint = {};
		$scope.today();
	};
	
	$scope.showEditPanel = function(argItem) {
		$scope.sprint = {
				id: argItem.id, 
				title : argItem.title,
				description: argItem.description,
				startDate : argItem.startDate,
				endDate : argItem.endDate
		};
	};
	
	$scope.listAll = function() {
		Sprint.list(function(response) {
			$scope.sprintList = response ? response : [];
		});
	};
	
	$scope.listSprintStories = function() {
		if($scope.searchSprint.id !== undefined) {
			Sprint.get({id: $scope.searchSprint.id }, function(response) {
				$scope.sprintStoryList = response ? response.stories : [];
			}, function(error) {
				alert(error.message);
			});	
		} else {
			alert("Choose correct sprint!");
		}
		
	};
	
	$scope.init = function() {
		$scope.listAll();	
	};
	
	$scope.init();
	
	$scope.today = function() {
		$scope.sprint.startDate = new Date();
		$scope.sprint.endDate = new Date($scope.sprint.startDate.getFullYear(), $scope.sprint.startDate.getMonth(), $scope.sprint.startDate.getDate() + 5);
	};
	$scope.today();

	$scope.clear = function() {
		$scope.dt = null;
	};

	$scope.inlineOptions = {
		customClass : getDayClass,
		minDate : new Date(),
		showWeeks : true
	};

	$scope.dateOptions = {
		dateDisabled : disabled,
		formatYear : 'yy',
		maxDate : new Date(2020, 5, 22),
		minDate : new Date(),
		startingDay : 1
	};

	// Disable weekend selection
	function disabled(data) {
		var date = data.date, mode = data.mode;
		return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	}

	$scope.toggleMin = function() {
		$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null
				: new Date();
		$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	};

	$scope.toggleMin();

	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};

	$scope.open2 = function() {
		$scope.popup2.opened = true;
	};

	$scope.setDate = function(year, month, day) {
		$scope.dt = new Date(year, month, day);
	};

	$scope.formats = [ 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate' ];
	$scope.format = $scope.formats[0];
	$scope.altInputFormats = [ 'M!/d!/yyyy' ];

	$scope.popup1 = {
		opened : false
	};

	$scope.popup2 = {
		opened : false
	};

	function getDayClass(data) {
		var date = data.date, mode = data.mode;
		if (mode === 'day') {
			var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

			for (var i = 0; i < $scope.events.length; i++) {
				var currentDay = new Date($scope.events[i].date).setHours(0, 0,
						0, 0);

				if (dayToCheck === currentDay) {
					return $scope.events[i].status;
				}
			}
		}

		return '';
	}
}
