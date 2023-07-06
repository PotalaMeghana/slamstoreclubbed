
        $(document).ready(function() {
            $("#filterForm").submit(function(event) {
                event.preventDefault(); // Prevent form submission

                var startDate = $("#startDate").val();
                var endDate = $("#endDate").val();
                console.log(startDate + "startdate");
                console.log("end  " + endDate);

                var url = "getBetweenDatesPayments"; // Replace with your actual controller URL

                $.ajax({
                    url: url,
                    method: "GET",
                    data: {
                        startDate: startDate,
                        endDate: endDate
                    },
                    success: function(response) {
                        $("#paymentcontent").html(response); // Replace the table body with the filtered payments
                    },
                    error: function(xhr, status, error) {
                        console.log("AJAX error:", error);
                    }
                });
            });
        });

        function filterPayments() {
            var filter = document.getElementById("filterSelect").value;
            $.ajax({
                type: "POST",
                url: "filterPayments",
                data: { priceRange: filter },
                success: function(response) {
                    $('#paymentcontent').html(response);
                },
                error: function() {
                    alert("Error occurred while filtering product details.");
                }
            });
        }
 
 