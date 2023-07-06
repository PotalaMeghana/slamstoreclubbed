

        function makeEditable(row) {
            var cells = row.getElementsByTagName('td');
            
            for (var i = 0; i < cells.length - 1; i++) {
                var cell = cells[i];
                var text = cell.innerText;
                
                cell.innerHTML = '<input type="text" value="' + text + '">';
            }
            
            var editButton = row.querySelector('.edit-button');
            editButton.innerText = 'Save';
            editButton.onclick = function() {
                saveChanges(row);
            };
        }
        
        function saveChanges(row) {
            var cells = row.getElementsByTagName('td');
            var values = [];
            
            for (var i = 0; i < cells.length - 1; i++) {
                var cell = cells[i];
                var input = cell.querySelector('input');
                var text = input.value;
                
                cell.innerHTML = text;
                values.push(text);
            }
            
            var editButton = row.querySelector('.edit-button');
            editButton.innerText = 'Edit';
            editButton.onclick = function() {
                makeEditable(row);
            };
            
            // Invoke your custom function with the values as parameters
            handleSave(values);
        }
        
        function handleSave(values) {
            // Replace this with your custom logic to handle the saved values
            console.log('Saved values:', values);
            $.ajax({
                url: "updateCharge",
                method: 'POST',
                data:{
                   id:values[0],
                    From:values[1],
                   To:values[2],
                 shippingAmount:values[3]
                },
                success: function(response) {
                    console.log(response);
                    // Set the response HTML as the inner HTML of the select element
                    // dis();
                },
                error: function(xhr, status, error) {
                    console.log('AJAX Error: ' + error);
                }
            });
        }
        
        function addEntryForm() {
            var addForm = document.getElementById('add-form');
            addForm.style.display = 'block';
        }
        
        function submitEntryForm() {
            var ordvlFromInput = document.getElementById('ordvlFrom');
            var ordvlToInput = document.getElementById('ordvlTo');
            var ordvlShippingAmountInput = document.getElementById('ordvlShippingAmount');
            
            var ordvlFromValue = ordvlFromInput.value;
            var ordvlToValue = ordvlToInput.value;
            var ordvlShippingAmountValue = ordvlShippingAmountInput.value;
            
            $.ajax({
                url: "addCharge",
                method: 'POST',
                data:{
                    From:ordvlFromValue,
                    To:ordvlToValue,
                    shippingAmount:ordvlShippingAmountValue
                },
                success: function(response) {
                    console.log(response);
                    // Set the response HTML as the inner HTML of the select element
                    // dis();
                },
                error: function(xhr, status, error) {
                    console.log('AJAX Error: ' + error);
                }
            });
            ordvlFromInput.value = '';
            ordvlToInput.value = '';
            ordvlShippingAmountInput.value = '';
            
            // Hide the form
            var addForm = document.getElementById('add-form');
            addForm.style.display = 'none';
        }
   