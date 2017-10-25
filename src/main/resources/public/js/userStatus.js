/*var request = $.ajax({
    url: 'url',
    type: 'GET',
    data: { field1: "hello", field2 : "hello2"} ,
    contentType: 'application/json; charset=utf-8'
});

request.done(function(data) {
    // your success code here
});

request.fail(function(jqXHR, textStatus) {
    // your failure code here
});*/

$(document).ready(function() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8087/status",
        /*data:{
            //id: 1
            id: $(".user-status").attr("value")
        }*/
        data: {
            id:  $('.user-status').attr("id")
        }
    }).then(function(data) {
        $('.user-status').append(data.status);
    });
});

/*

$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8087/status?id=1",
    }).then(function(data) {
        $('.user-status').append(data.status);
    });

});*/
