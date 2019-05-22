function convertTableToCSV(table) {
    var result, ctr, columnDelimiter, lineDelimiter, data;

    data = $(table).find("tr") || null;
    if (data == null || !data.length) {
        return null;
    }

    columnDelimiter = ',';
    lineDelimiter = '\n';


    result = '';


    data.each(function() {
        ctr = 0;
        var cols = $(this).find("td");
        if (ctr == 0 && cols.length == 0){
            cols = $(this).find("th");
        }
        else{
            cols = $(this).find("td");
        }
        cols.each(function() {
            if (ctr > 0) result += columnDelimiter;

            result += $(this).html();
            ctr++;
        });
        result += lineDelimiter;
    });

    return result;
}

function downloadCSV(table) {
    var data, filename, link;
    var csv = convertTableToCSV(table);
    if (csv == null) return;

    filename = 'export.csv';

    if (!csv.match(/^data:text\/csv/i)) {
        csv = 'data:text/csv;charset=utf-8,' + csv;
    }
    data = encodeURI(csv);

    link = document.createElement('a');
    link.setAttribute('href', data);
    link.setAttribute('download', filename);
    link.click();
}