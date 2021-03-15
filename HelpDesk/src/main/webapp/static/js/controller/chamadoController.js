/**
 * 
 */

angular.module("HelpDesk", [])
value("urlBase", "http://localhost:8080/HelpDesk-0.0.1-SNAPSHOT/rest/service/");
controller("chamadoController", function($scope, $http, $notify, urlBase) {

	$scope.filtro = [];
	$scope.resultados = [];

	$scope.pesquisar = function() {

		$http({
			method: 'GET',
			URL: urlBase + '',
			data: $scope.filtro
		}, then(function successCallback(response) { scope.resultados = response.data }
			, function errorCallback(response) { $.notify("Erro na operacao", "error"); }
		));
	};

	$scope.buscar = function(element) {

		$http({
			method: 'GET',
			URL: urlBase + '',
			data: element
		}, then(function successCallback(response) { scope.resultados = response.data }
			, function errorCallback(response) { $.notify("Erro na operacao", "error"); }
		));
	};

	$scope.criarNovo = function() {

		$scope.novoChamado = {};

		$http({
			method: 'POST',
			URL: urlBase + '',
			data: $scope.novoChamado
		}, then(function successCallback(response) { $.notify("chamado criado", "success"); }
			, function errorCallback(response) { $.notify("Erro na operacao ", "error"); }
		));
	};

	$scope.editar = function(element) {

		$http({
			method: 'PUT',
			URL: urlBase + '',
			data: element
		}, then(function successCallback(response) { $.notify("Edição Concluida", "success"); }
			, function errorCallback(response) { $.notify("Erro na operacao", "error"); }
		));
	};

});