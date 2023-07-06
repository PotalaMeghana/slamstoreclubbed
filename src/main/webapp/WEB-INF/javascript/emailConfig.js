
    function getemail() {
        var email = document.getElementById("email").value;
        var pwd = document.getElementById("pwd").value;
        console.log("hello");
        $.ajax({
            url: "EmailConfiguration",
            method: 'POST',
            data: {
                email: email,
                pwd: pwd
            },
            success: function(response) {
                $('#p').html("done");
                console.log('In the updation of master entry function');
            },
            error: function(xhr, status, error) {
                console.log('AJAX Error: ' + error);
            }
        });
    }
