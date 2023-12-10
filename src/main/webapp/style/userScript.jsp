<script>
function viewMore( tourId, url) {
    const fullUrl = './' + url + '?id=' + tourId;
    window.location.href = fullUrl;
}
</script>

<%--
<script>
function viewMore(tourId) {
    console.log("TourID>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + tourId);
    const url = './tour-details?id=' + tourId;
    const url = './tour-booking?id=' + tourId;
    window.location.href = url;
}
</script>

--%>

