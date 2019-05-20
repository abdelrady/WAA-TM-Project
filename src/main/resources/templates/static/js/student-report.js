
$(document).ready(function(){
    $('#blocks-select').on('change', function(){
        var blockId = $(this).val();
        var studentId = $('.student-id').val();
        if(!blockId || !studentId)return;
        var totalSessions = $(this).find(':selected').data('sessions');
        $('.block-sessions').text(totalSessions);

        $.ajax({
            type : "GET",
            url : "/students/reports/rest/block/"+blockId+"/student/"+studentId,
            //data : ,
            contentType: "application/json",
            dataType : "json",
            success : function(data){
                var table = $.makeTable(data);
                $('.results').html('');
                $(table).appendTo(".results");
                $('.present-days').text(data.length);
                var percentage = data.length * 100 / totalSessions;
                $('.block-percentage').text(percentage.toFixed(2));
                var extraCredits = 0;
                if(percentage >= 90)
                    extraCredits = 1.5;
                else if(percentage >= 80)
                    extraCredits = 1;
                else if(percentage >= 70)
                    extraCredits = 0.5;
                $('.extra-credits').text(extraCredits);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                console.log(XMLHttpRequest.responseJSON);

            }
        });
    })
})