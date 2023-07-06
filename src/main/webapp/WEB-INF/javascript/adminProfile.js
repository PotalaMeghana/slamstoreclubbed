
    $(document).ready(function() {
        $(document).on('click', '#edit-profile', function(event) {
            event.preventDefault();
            console.log("entered admin profile");
            editProfile();
        });
    });
    
    function editProfile(){
        $.ajax({
            url: "editAdminProfile",
            method: 'GET',
            success: function(response) {
                $('#tableData').html(response); // Set the response HTML as the inner HTML of the select element
            },
            error: function(xhr, status, error) {
                console.log('AJAX Error: ' + error);
            }
        });
    }

