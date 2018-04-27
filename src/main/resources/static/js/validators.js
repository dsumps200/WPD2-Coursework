$(document).ready(function() {
    /* Add Milestone validators */
    $("#create-milestone-form").on("submit", function(e) {
        // Validate each field in the form - min/max length, format (for dates), etc
        var title = $("#title");
        var description = $("#description");
        var intendedDueDate = $("#intended-date");

        /* Milestone title */
        if (title.val().length < 4 || title.val().length > 64) {
            e.preventDefault();
            title.next().text("Title must be between 4 and 64 characters")
        }

        // Clear the title error when user types
        title.on("keydown", function() {
            title.next().empty()
        })

    })

    /* Register form validators */
});