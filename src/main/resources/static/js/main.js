$(document).ready(function() {
    /* Initiate the datepicker */
    var datePickerConfig = {
        dateFormat: "yy-mm-dd"
    };
   $("#intended-date").datepicker(datePickerConfig);
   $("#actual-date").datepicker(datePickerConfig);

   /* Sets defaults on the edit Milestone modal */
   $("#edit-milestone-modal").on("show.bs.modal", function(e) {
       $("#title").val($("#title").data("title"))
       $("#description").val($("#description").data("description"))
       $("#intended-date").val($("#intended-date").data("intended"))

       if ($("#actual-date").attr("data-actual")) {
            $("#actual-date").val($("#actual-date").data("actual"))
       }
   })

    $(".alert").delay(3000).fadeOut();
});