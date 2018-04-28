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

        // Clear the description error when user types
        description.on("keydown", function() {
            description.next().empty()
        })

        // Clear the description error when user types
        // TODO: clear intendedDueDate error on selection

        // Clear the description error when user types
        // TODO: clear intendedDueDate error on selection

    })

    /* Register form validators */
    $("#register-form").on("submit", function(e) {
        // Validate each field in the form - min/max length, matching passwords, password combination, available username, etc
        var firstname = $("#firstname");
        var surname = $("#surname");
        var username = $("#username");
        var password = $("#password");
        var password_confirm = $("#password_confirm");

        /* Register firstname validation */
        if (firstname.val().length < 1 || firstname.val().length > 35) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            firstname.next().text("First name must be between 1 and 35 characters") // Add error msg to the <span> element under the form input
        }

        /* Register surname validation */
        if (surname.val().length < 1 || surname.val().length > 35) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            surname.next().text("Surname must be between 1 and 35 characters") // Add error msg to the <span> element under the form input
        }

        /* Register username validation */
        if (username.val().length < 6 || username.val().length > 35) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            username.next().text("Username must be between 6 and 35 characters") // Add error msg to the <span> element under the form input
        }

        /* Register password validation */
        if (password.val().length < 8) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            password.next().text("Password must be 8 or more characters") // Add error msg to the <span> element under the form input
        }

        /* Register password_confirm validation */
        if (password_confirm.val() !== password.val()) {
            e.preventDefault(); // prevent form submission if this 'if' condition is true
            password_confirm.next().text("Passwords do not match") // Add error msg to the <span> element under the form input
        }

        // TODO: add validation to ensure first & last name contain only text
        // TODO: add validation to ensure username contains only text, numbers, underscore?
        // TODO: add validation to ensure password contains at least 1 uppercase, 1 lowercase, 1 number

        // Clear the firstname error when user types
        firstname.on("keydown", function() {
            firstname.next().empty()
        })

        // Clear the surname error when user types
        surname.on("keydown", function() {
            surname.next().empty()
        })

        // Clear the username error when user types
        username.on("keydown", function() {
            username.next().empty()
        })

        // Clear the password error when user types
        password.on("keydown", function() {
            password.next().empty()
        })

        // Clear the password_confirm error when user types
        password_confirm.on("keydown", function() {
            password_confirm.next().empty()
        })
        password.on("keydown", function() {
            password_confirm.next().empty()
        })
    })
});