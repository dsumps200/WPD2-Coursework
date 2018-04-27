/* This file contains any AJAX requests made by the application */

$(document).ready(function() {

    /* Deletes the milestone, and redirects */
    $("#confirm-delete").on("click", function(e) {
        e.preventDefault();
        var id = $("#milestone-id").val();

        $.ajax({
            url: '/milestones/' + id + '/delete',
            type: 'DELETE',
            dataType: 'json',
            success: function(result) {
                if (result.success) {
                    window.location.href = "/milestones"
                }
            }
        })
    })
})