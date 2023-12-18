<script>
function viewMore( tourId, url) {
    const fullUrl = './' + url + '?id=' + tourId;
    window.location.href = fullUrl;
}


      $(document).ready(function () {
          var priceSlider = $("#priceRange");

          // Initialize ion.rangeSlider
          priceSlider.ionRangeSlider({
              type: "double",
              grid: true,
              min: 0,
              max: 100,
              from: 0,
              to: 100,
              step: 1,
              onFinish: function (data) {
                  updatePriceRangeValue(data.from, data.to);
                  updateUrlParams(data.from, data.to);
                  reloadPage();
              }
          });

          // Initial setup
          updatePriceRangeValue(0, 100);

          // Check for initial filter values in the URL
          var urlParams = new URLSearchParams(window.location.search);
          var minPrice = urlParams.get('minPrice');
          var maxPrice = urlParams.get('maxPrice');

          if (minPrice !== null && maxPrice !== null) {
              // Set initial values from URL
              var minValue = calculateSliderValue(minPrice);
              var maxValue = calculateSliderValue(maxPrice);
              priceSlider.data("ionRangeSlider").update({
                  from: minValue,
                  to: maxValue
              });
              updatePriceRangeValue(minValue, maxValue);
          }
      });

      function updatePriceRangeValue(minValue, maxValue) {
          var minPrice = calculateMinPrice(minValue);
          var maxPrice = calculateMaxPrice(maxValue);

          // Round min and max prices to the nearest whole number
          minPrice = Math.round(minPrice);
          maxPrice = Math.round(maxPrice);

          // Display the selected price range
          $('#selectedPrices').text('Selected Price Range: $' + minPrice + ' - $' + maxPrice);
      }

      function calculateMinPrice(value) {
          // Implement your logic to map the range value to the minimum price
          // For example, you can use a linear mapping or any other algorithm based on your requirements.
          return value * 60; // Assuming the maximum slider value is 100
      }

      function calculateMaxPrice(value) {
          // Set the upper limit to $6000
          var upperLimit = 6000;

          // Implement your logic to map the range value to the maximum price
          // Ensure that the scaling is correct based on the slider's maximum value
          return (value / 100) * upperLimit;
      }

      function calculateSliderValue(price) {
          // Implement your logic to map the price to the slider value
          // For example, you can use a linear mapping or any other algorithm based on your requirements.
          return price / 60; // Assuming the maximum slider value is 100
      }

      function updateUrlParams(minValue, maxValue) {
          // Update the URL with the new filter values
          var newUrl = 'http://localhost:8080/Tours-system/tours?filter=price';

          newUrl += '&minPrice=' + encodeURIComponent(calculateMinPrice(minValue));
          newUrl += '&maxPrice=' + encodeURIComponent(calculateMaxPrice(maxValue));

          // Replace the current URL without reloading the page
          window.history.replaceState({}, document.title, newUrl);
      }

      function reloadPage() {
          location.reload();
      }



  </script>






