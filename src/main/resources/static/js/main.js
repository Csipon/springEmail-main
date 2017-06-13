$(document).ready(function () {

    // checkNewMessage();

    $(".button-collapse").sideNav({
        menuWidth: 220,
        edge: 'left',
        draggable: false
    });

    $('.dropdown-button').dropdown({
        belowOrigin: true,
        alignment: 'left'
    });

    $(".burger").on('click', function () {
        $("#slide-out").toggleClass("mini-nav");
        $(".menu-block").toggleClass("hide-menu-block");
        $(".content").toggleClass("full-content");
    });

    $(document).on('click', "a.a-dummy", function (e) {
        e.preventDefault();
    });

    $(document).on("click", "a.a-logout", function (e) {
        $(this).find("form").submit();
    });

    $(".menu-element").on("click", function (e) {
        if ($(document).width() < 992) {
            $('.button-collapse').sideNav('hide');
        }
    });

    $('.button-collapse').sideNav('hide');
    downloadContent();
    $(window).on('hashchange', function () {
        downloadContent();
    });
});

function downloadContent() {
    var $contentBody = $(".content-body-wrapper");
    $contentBody.removeClass("content-body-visible");
    $(".progress").addClass("progress-active");
    $.get({
        url: "/" + $(".menu-item-user").data("user-role") + "/" + location.hash.substr(1),
        dataType: "html"
    }).success(function (data) {
        changeContent(data)
    }).error(function (e) {
        changeContent(e.responseText)
    });
}

function changeContent(content) {
    var $contentBody = $(".content-body-wrapper");
    window.setTimeout(function () {
        $contentBody.html(content);
        $(".progress").removeClass("progress-active");
        $contentBody.addClass("content-body-visible");
        var pageName = $contentBody.find(".content-body").data("page-name");
        $("#current-page").text(pageName);
        document.title = pageName;
    }, 500);
}

function send(form, url, type) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(".progress").addClass("progress-active");
    var xhr = $.ajax({
        url: url,
        type: type,
        data: $(form).serialize(),
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        statusCode: {
            200: function (data) {
                Materialize.toast(xhr.getResponseHeader("successMessage"), 10000);
            },
            201: function (data) {
                Materialize.toast(xhr.getResponseHeader("successMessage"), 10000);
            },
            417: function (data) {
                Materialize.toast(xhr.getResponseHeader("validationMessage"), 10000);
            },
            500: function (data) {
                Materialize.toast(xhr.getResponseHeader("errorMessage"), 10000, 'red');
            }
        }
    }).complete(function () {
        $(".progress").removeClass("progress-active");
    });
    return xhr;
}