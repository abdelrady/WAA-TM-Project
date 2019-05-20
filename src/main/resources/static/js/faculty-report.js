
$(document).ready(function(){
    $('#blocks-select').on('change', function(){
        var courseBlockId = $(this).val();
        if(!courseBlockId){
            $('.results').html('');
            return;
        }

        $.ajax({
            type : "GET",
            url : "/faculty/reports/mvc/courseBlock/"+courseBlockId+"/stats/",
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