var App = angular.module('HelpDesk', ["ngRoute"]);
App.value('urlBase', 'http://localhost:8080/HelpDesk-0.0.1-SNAPSHOT/rest/service')
App.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl: 'static/view/home.html',
			controller: 'chamadoController'
		})
		.when('/chamados/edit/:id', {
			templateUrl: 'static/view/edit.html',
			controller: 'editarController'
		})
		.when('/chamados/novo', {
			templateUrl: 'static/view/adicionar.html',
			controller: 'novoController'
		});

	//$routeProvider.otherWise({ redirectTo: '/index' });

});

App.controller('chamadoController', function($scope, $http, $window, $location, $routeParams, $route, urlBase) {


	//var urlBase = 'http://localhost:8080/HelpDesk-0.0.1-SNAPSHOT/rest/service';
	var hoje = new Date();
	$scope.filtro = {};
	$scope.filtro.idChamado = null;
	$scope.filtro.dataInicio = null;
	$scope.filtro.dataFim = null;
	$scope.filtro.status = null;
	$scope.resultados = [];

	$scope.pesquisar = function() {

		var response;
		var err;
		var param = montarParamsFiltro();

		var req = {
			method: 'GET',
			url: urlBase + '/listar' + param,
			headers: {
				'Content-Type': 'application/json'
			},
			//data: $scope.filtro

		};

		$http(req).then(function(response) {
			$scope.resultados = response.data;
		}, function(err) {
			alert(err.data.mensagem);
		});

	};

	var montarParamsFiltro = function() {
		var param = '?';
		if ($scope.filtro.idChamado !== null && $scope.filtro.idChamado !== undefined) {
			param = param + 'idChamado=' + $scope.filtro.idChamado;
		}
		if ($scope.filtro.status !== null && $scope.filtro.status !== undefined) {
			param = param + '&status=' + $scope.filtro.status.value;
		}
		if ($scope.filtro.dataInicio !== null && $scope.filtro.dataInicio !== undefined) {
			var dataInicio = $scope.filtro.dataInicio.getFullYear() + '-' + addZero($scope.filtro.dataInicio.getMonth() + 1) + '-' + addZero($scope.filtro.dataInicio.getDate());
			param = param + '&dtInicio=' + dataInicio;
		}
		if ($scope.filtro.dataFim !== null && $scope.filtro.dataFim !== undefined) {
			var dataFim = $scope.filtro.dataFim.getFullYear() + '-' + addZero($scope.filtro.dataFim.getMonth() + 1) + '-' + addZero($scope.filtro.dataFim.getDate());
			param = param + '&dtFim=' + dataFim;
		}
		return param;

	}
	function addZero(numero) {
		if (numero <= 9)
			return "0" + numero;
		else
			return numero;
	}


	$scope.novoChamado = function() {
		$location.path('/chamados/novo');
	};

	$scope.editar = function(id) {
		$location.path('/chamados/edit/' + id);
	};

}

)
App.controller('editarController', function($scope, $http, $window, $location, $routeParams, $route, urlBase) {
	$scope.id = $routeParams.id;
	console.log('recebendo id: ' + $scope.id);
	console.log('request API: ' + urlBase + '/buscar/' + $scope.id);

	$scope.chamado = {};
	$scope.comentario = {};

	$scope.comentario.idChamado = $scope.id;
	$scope.comentario.descricao = "";

	$scope.buscar = function() {
		var response;
		var err;
		var req = {
			method: 'GET',
			url: urlBase + '/buscar/' + $scope.id,
			headers: {
				'Content-Type': 'application/json'
			}
			//data: $scope.filtro
		};
		$http(req).then(function(response) {
			$scope.chamado = response.data;
		}, function(err) {
			alert(err.data.mensagem);
		});
	};

	$scope.atualizar = function() {
		var response;
		var err;

		var req = {
			method: 'PUT',
			url: urlBase + '/atualizar/',
			headers: {
				'Content-Type': 'application/json'
			},
			data: $scope.chamado
		};
		$http(req).then(function(response) {
			alert(response.data.mensagem);
			$location.path('/chamados/edit/' + $scope.chamado.id);
		}, function(err) {
			alert(err.data.mensagem);
		});
	};

	$scope.cancelar = function() {
		$location.path('/');
	};

	$scope.addComentario = function() {
		var response;
		var err;

		var req = {
			method: 'POST',
			url: urlBase + '/incluir/comentario',
			headers: {
				'Content-Type': 'application/json'
			},
			data: $scope.comentario

		};
		$http(req).then(function(response) {
			$('#modalComenatrio').modal('hide');
			$scope.comentario.descricao = ""
			alert(response.data.mensagem);
		}, function(err) {
			alert(err.data.mensagem);
		});
	};

	$scope.buscar();

})

App.controller('novoController', function($scope, $http, $window, $location, $routeParams, $route, urlBase) {
	$scope.chamado = {};
	$scope.chamado.titulo = "";
	$scope.chamado.descricao = "";
	$scope.chamado.status = "";

	$scope.addChamado = function() {
		var response;
		var err;

		var req = {
			method: 'POST',
			url: urlBase + '/incluir',
			headers: {
				'Content-Type': 'application/json'
			},
			data: $scope.chamado

		};
		$http(req).then(function(response) {
			$scope.chamado.titulo = "";
			$scope.chamado.descricao = "";
			$scope.chamado.status = "";
			alert(response.data.mensagem);
		}, function(err) {
			alert(err.data.mensagem);
		});
	};

	$scope.cancelar = function() {
		$location.path('/');
	};

});