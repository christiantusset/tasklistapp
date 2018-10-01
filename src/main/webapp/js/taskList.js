var taskApp = angular.module('tasks', []);

taskApp.controller('taskController', function($scope, $http) {
 
	var atualizar = function () {
        $http.get('/tarefas')
            .success(function(response) {
                $scope.tasks = response;
                $scope.taskForm = {};
                console.log("tasks: ", response);
            })
            .error(function(response) {
                console.log('Error: ' + response);
        });
    };

    atualizar();

    $scope.limparCriacao = function() {
        $scope.taskForm = {};
        $scope.loading = false;
    };

    var removerModal = function () {
        $('#modal-tarefa').modal({
            show : 'false'
        });

        location.reload();
    };

    $scope.salvar = function() {
        if ($scope.taskForm.id) {
            $scope.atualizar();
        } else {
            $scope.criar();
        }
    };

    $scope.criar = function() {
        $http.post('/salvar', $scope.taskForm)
            .success(function(response) {
                $scope.loading = false;
                atualizar();
                removerModal();
                console.log("Tarefa salva !");
            })
            .error(function(error){
                console.log(error);
                console.log("Erro ao salvar tarefa!");
        });
    };

    $scope.atualizar = function() {
        $http.put('/atualizar/' + $scope.taskForm.id, $scope.taskForm)
            .success(function(response) {
                atualizar();
                removerModal();
                console.log("Atualizado com sucesso! " + response);
            })
            .error(function(error) {
                console.log(error);
                console.log("Erro ao Atualizar tarefa!");
        });
    };

    $scope.editar = function(id) {
        $http.get('/tarefa/' + id)
            .success(function(response) {
                $scope.taskForm = response;
                console.log("Informações: " + response);
            })
            .error(function(error) {
                console.log(error);
                console.log("Erro ao obter informações!");
        });
    };
    
    $scope.remover = function(id) {
        $http.delete('/remover/' + id)
            .success(function(response) {
                atualizar();
                console.log("Removido com sucesso!");
            })
            .error(function(error) {
                console.log(error);
                console.log("Erro ao Remover tarefa!");
        });
    };

});
