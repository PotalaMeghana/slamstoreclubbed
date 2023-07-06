
   $(document).on('click', '#update-button', function(event) {
    event.preventDefault();
 	console.log("updating profile");
    
    var id = document.getElementById("adminId").value;
   
    
    var name = document.getElementById("adminName").value;
    var email = document.getElementById("adminEmail").value;
    var role = document.getElementById("adminRole").value;
    var password = document.getElementById("adminPassword").value;
    console.log("updating profile",id);
    updateProfile(id,name,email,role,password);
});


function updateProfile(id,name,email,role,password){
console.log("in viewing  shipped Orders");
 $.ajax({
      url: "updateAdminDetails",
      method: 'GET',
      data:{id:id,
    	  title:name,
    	  email:email,
    	  designation:role,
    	  password:password},
      success: function(response) {
        $('#content').html(response); // Set the response HTML as the inner HTML of the select element
      },
      error: function(xhr, status, error) {
        console.log('AJAX Error: ' + error);
      }
    });
}

  
