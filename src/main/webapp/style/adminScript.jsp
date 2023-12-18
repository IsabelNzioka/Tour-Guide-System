<script>
$(document).ready(function(){
  $("#searchForm").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $(".TourList tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

function deleteEntity(tourId, deleteUrl) {
    var url = 'http://localhost:8080/Tours-system/api/v1/tours/tour/' + tourId;

    var confirmation = confirm('Are you sure you want to delete this record?');

    if (confirmation) {
      fetch(url, {
          method: 'DELETE',
          headers: {
              'Content-Type': 'application/json',
          },
      })
      .then(response => {
          console.log('Response:', response);
          if (response.status === 204) {
              window.location.reload();
          }
          return response.json();
      })
      .then(data => {
          console.log('Tour deleted successfully:', data);
      })
      .catch(error => {
          console.error('Error deleting tour:', error);
      });
    }
}


     function editUrl(id, url) {
        const fullUrl = './' + url + '&id=' + id;
         console.log("Hello editing" + fullUrl);
         window.location.href = fullUrl;
     }



</script>