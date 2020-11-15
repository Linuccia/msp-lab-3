    x = $('input[name=x]:checked').val();
    y = $('.y_in').val();
    r = $('.r_in').val();

    let svg = document.querySelector("svg");

$(function () {
    $('.graph').on('click', function (event) {
        if (checkR(x, y, r)) {
            let position = getMousePosition(svg, event);
            x = position.x;
            y = position.y;
            let x_val = (((x - 200) * r / 120) / 0.5).toFixed() * 0.5;
            point1(x_val, y, r);
            $('input[name=x][value=\"' + x_val + '\"]').prop('checked', true);
            $('.y_in').val(((200 - y) * r / 120).toFixed(2));
            $('.exceptionY').html('');
            return true
        }else alert("Введите корректный R, а то низзя");
    });
});

function point1(x, y, r) {
    $('#point').attr("cx", x*120/r + 200)
        .attr("cy", y);
}

function getMousePosition(svg, event) {
    let rect = svg.getBoundingClientRect();
    return {
        x: event.clientX - rect.left,
        y: event.clientY - rect.top
    };
}