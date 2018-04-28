$(document).ready(function() {
    /* Add Milestone validators */
    $("#create-milestone-form").on("submit", function(e) {
        // Validate each field in the form - min/max length, format (for dates), etc
        var title = $("#title");
        var description = $("#description");
        var intendedDueDate = $("#intended-date");
        var actualDueDate = $("#actual-date");

        /* Milestone title validation */
        if (title.val().length < 4 || title.val().length > 64) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            title.next().text("Title must be between 4 and 64 characters") // Add error msg to the <span> element under the form input
        }

        /* Milestone description validation */
        if (description.val().length < 6 || description.val().length > 500) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            description.next().text("Description must be between 6 and 500 characters") // Add error msg to the <span> element under the form input
        }

        /* Milestone intendedDueDate validation */
        // TODO: add intendedDueDate validation

        /* Milestone actualDueDate validation */
        // TODO: add actualDueDate validation

        // Clear the title error when user types
        title.on("keydown", function() {
            title.next().empty()
        })

    })

    /* Register form validators */
});