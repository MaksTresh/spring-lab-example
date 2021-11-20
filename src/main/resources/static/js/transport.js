var app = angular.module('transports', []).config(function ($httpProvider) {
    csrftoken = $("meta[name='_csrf']").attr("content");
    csrfheader = $("meta[name='_csrf_header']").attr("content");
    $httpProvider.defaults.headers.common["X-CSRF-TOKEN"] = csrftoken;
});

app.controller("TransportsController", function ($scope, $http) {

    $scope.successGetTransportsCallback = function (response) {
        $scope.transportsList = response.data;
        console.log(response.data);
        $scope.errormessage = "";
    };

    $scope.errorGetTransportsCallback = function (error) {
        console.log(error);
        $scope.errormessage = "Unable to get list of transports";
    };

    $scope.getTransports = function () {
        $http.get('/transports').then($scope.successGetTransportsCallback, $scope.errorGetTransportsCallback);
    };

    $scope.successDeleteTransportCallback = function (response) {
        for (var i = 0; i < $scope.transportsList.length; i++) {
            var j = $scope.transportsList[i];
            if (j.id === $scope.deletedId) {
                $scope.transportsList.splice(i, 1);
                break;
            }
        }
        $scope.errormessage = "";
    };

    $scope.errorDeleteTransportCallback = function (error) {
        console.log(error);
        $scope.errormessage = "Unable to delete transport";
    };

    $scope.deleteTransport = function (id) {
        $scope.deletedId = id;
        $http.delete('transports/' + id).then($scope.successDeleteTransportCallback, $scope.errorDeleteTransportCallback);
    };


    $scope.successGetTransportCallback = function (response) {
        $scope.transportsList = response.data;
        $scope.errormessage = "";
    };

    $scope.errorGetTransportCallback = function (error) {
        console.log(error);
        $scope.errormessage = "Unable to get information on transport number " + $scope.inputnumber;
    };

    $scope.successAddTransportCallback = function (response) {
        $http.get('/transports').then($scope.successGetTransportCallback, $scope.errorGetTransportCallback);
        $scope.errormessage = "";
    };

    $scope.errorAddTransportCallback = function (error) {
        console.log(error);
        $scope.errormessage = "Impossible to add new transport";
    };

    $scope.addTransport = function () {
        const data = {
            "raceName": $scope.inputname,
            "date": $scope.inputdate + "T" + $scope.inputtime + ":00.000+00:00",
            "transportType": $scope.inputtype
        }
        $http.post('/transports/', JSON.stringify(data)).then($scope.successAddTransportCallback, $scope.errorAddTransportCallback);
    };

});
