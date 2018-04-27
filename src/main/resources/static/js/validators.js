$(document).ready(function() {
    /* Add Milestone validators */
    $("#create-milestone-form").on("submit", function(e) {
        // Validate each field in the form - min/max length, format (for dates), etc
        var title = $("#title");
        var description = $("#description");
        var intendedDueDate = $("#intended-date");

        /* Milestone title validation */
        if (title.val().length < 4 || title.val().length > 64) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            title.next().text("Title must be between 4 and 64 characters") // Add error msg to the <span> element under the form input
        }

        // Clear the title error when user types
        title.on("keydown", function() {
            title.next().empty()
        })

    })

    /* Register form validators */
});