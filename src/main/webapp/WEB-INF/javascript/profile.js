// Function to add a product to the cart
function addToCart(productId) {
  $.ajax({
    url: "addToCart",
    method: 'GET',
    data: { productId: productId },
    success: function(response) {
      if (response.success) {
        var bt = '<button class="removeFromCart" data-product-id="' + productId + '">Remove from Cart</button>';
        $(".addToCartButton").html(bt);
      }
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to add a product to the wishlist
function addToWishlist(productId) {
  $.ajax({
    url: "addToWishlist",
    method: 'GET',
    data: { productId: productId },
    success: function(response) {
      $('#display').html(response);
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to remove a product from the cart
function removeFromCart(productId) {
  console.log("Remove from cart called");
  $.ajax({
    url: "removeFromCart",
    method: 'GET',
    data: { productId: productId },
    success: function(response) {
      showCart();
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to remove a product from the wishlist
function removeFromWishlist(productId) {
  console.log("Remove from wishlist called");
  $.ajax({
    url: "removeFromWishlist",
    method: 'GET',
    data: { productId: productId },
    success: function(response) {
      showWishlist();
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to display the cart
function showCart() {
  console.log("Show cart called");
  $.ajax({
    url: "cartDisplay",
    method: 'GET',
    data: { userId: 1 },
    success: function(response) {
      $('#edit').html(response);
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

// Function to display the wishlist
function showWishlist() {
  $.ajax({
    url: "wishlistItems",
    method: 'GET',
    data: { userId: 1 },
    success: function(response) {
      console.log("Profile wishlist");
      $('#edit').html(response);
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}

$(document).ready(function() {
  // Event handler for the 'buyid' click event
  $(document).on('click', '.buyid', function(event) {
    event.preventDefault();
    buynow();
  });

  // Event handler for the 'addToCartButton' click event
  $(document).on('click', '.addToCartButton', function(event) {
    event.preventDefault();
    var productId = $(this).data('product-id');
    console.log(productId);
    addToCart(productId);
  });

  // Event handler for the 'removeFromCart' click event
  $(document).on('click', '.removeFromCart', function(event) {
    event.preventDefault();
    var productId = $(this).data('product-id');
    console.log(productId);
    removeFromCart(productId);
  });

  // Event handler for the 'addToWishlistButton' click event
  $(document).on('click', '.addToWishlistButton', function(event) {
    event.preventDefault();
    var productId = $(this).data('product-id');
    console.log(productId);
    addToWishlist(productId);
  });

  // Event handler for the 'removeFromWishlist' click event
  $(document).on('click', '.removeFromWishlist', function(event) {
    event.preventDefault();
    var productId = $(this).data('product-id');
    console.log(productId);
    removeFromWishlist(productId);
  });

  // Event handler for the 'cart-button' click event
  $('#cart-button').click(function() {
    showCart();
  });

  // Event handler for the 'Wishlist-button' click event
  $('#Wishlist-button').click(function() {
    showWishlist();
  });
});

// Event handler for the 'checkCustomerOrders' click event
$(document).on('click', '.checkCustomerOrders', function(event) {
  event.preventDefault();
  console.log("Entered customer orders profile");
  displayProfile();
});

// Function to display the customer orders
function displayProfile() {
  $.ajax({
    url: "CustomerOrdersProfile",
    method: 'GET',
    success: function(response) {
      $('#edit').html(response);
    },
    error: function(xhr, status, error) {
      console.log('AJAX Error: ' + error);
    }
  });
}
