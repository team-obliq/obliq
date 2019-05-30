$(function () {
    $("a.nav-link[href='" + window.location.pathname + "']").addClass('font-weight-bold')
})

$(function () {
    $('[data-toggle="popover"]').popover()
})