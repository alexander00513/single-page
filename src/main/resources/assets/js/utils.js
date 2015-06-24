function activateMenu(elementId) {
    $('ul li.active').removeClass('active');
    $('#' + elementId).addClass('active');
}