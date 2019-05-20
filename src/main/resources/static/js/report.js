$(document).ready(function(){
    $('#entryselect').on('change', function(){
        var entry = $(this).val();
        if(!entry)return;

        $.ajax({
            type : "GET",
            url : "/admin/report/entry/"+entry,
            contentType: "application/json",
            dataType : "json",
            success : function(data){
                var table = $.makeTable(data);
                $('.results').html('');
                $(table).appendTo(".results");
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                console.log(XMLHttpRequest.responseJSON);
            }
        });
    })
})