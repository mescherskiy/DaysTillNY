$(document).ready(function(){
    assignButton();
});

function assignButton() {
    $("#submit").click(function () {
        if ($("#date").val() == "")
            $("#text").text("Выберите дату!");
        else
            $("#text").text("");

        if ($("#date").val() != "") {
            const obj = {
                date: $("#date").val()
            };

            $.ajax({
                type: "POST",
                url: "count",
                contentType: "application/json",
                data: JSON.stringify(obj),
                dataType: "json",
                success: (function (response) {
                    $('#days').text(response)
                })
            });
        }
    });
}
