/**
 * 
 */
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("registrationForm").addEventListener("submit", function (event) {
        let isValid = true;

        // Full Name Validation
        const fullname = document.getElementById("fullname").value.trim();
        if (fullname === "" || fullname.length < 3) {
            alert("Full Name must be at least 3 characters long.");
            isValid = false;
        }

        // Roll Number Validation
        const rollno = document.getElementById("rollno").value.trim();
        if (!/^[0-9]{6,15}$/.test(rollno)) {
            alert("Roll Number must be a numeric value between 6-15 digits.");
            isValid = false;
        }

        // Email Validation
        const email = document.getElementById("email").value.trim();
        if (!/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email)) {
            alert("Please enter a valid email address.");
            isValid = false;
        }

        // Gender Validation
        const gender = document.getElementById("gender").value;
        if (gender === "") {
            alert("Please select a gender.");
            isValid = false;
        }

        // Branch Validation
        const branch = document.getElementById("branch").value;
        if (branch === "") {
            alert("Please select a branch.");
            isValid = false;
        }

        // Blood Group Validation
        const bloodgroup = document.getElementById("bloodgroup").value;
        if (bloodgroup === "") {
            alert("Please select a blood group.");
            isValid = false;
        }

        // Password Validation
        const password = document.getElementById("password").value;
        if (password.length < 6) {
            alert("Password must be at least 6 characters long.");
            isValid = false;
        }

        // Confirm Password Validation
        const confirmPassword = document.getElementById("confirm-password").value;
        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            isValid = false;
        }

        // Prevent form submission if validation fails
        if (!isValid) {
            event.preventDefault();
        }
    });
});
