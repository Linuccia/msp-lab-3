function XYR(){
    x = $('#slider_x').val();
    y = $('#y_in').val();
    r = $('#r_in').val();
}

function checkY(x, y, r) {
    if (!y) {
        return exceptionY('<br>Вы не ввели Y')
    } else if (isNaN(y)) {
        return exceptionY('<br>Y должен быть числом')
    } else if (y < -3 || y > 3) {
        return exceptionY('<br>Y не принадлежит [-3:3]')
    } else {
        $('.exceptionY').html('');
        return true
    }
}

function exceptionY(message) {
    $('.exceptionY').html(message);
    point(0,0, 2);
    return false
}

$(function () {
// $('#send').on('click', function (event) {
// XYR();
// if(checkY(x, y, r)) {
// $.get(
// "/CheckArea",
// {x: x, y: y, r: r}
// )
// // drawPoints(x, y, r)
// } else {
// event.preventDefault()
// }
// });
    $('.sliderX').on('input', function (){
        XYR();
        if (checkY(x,y,r))
            point(x, y, r);
    });
    $('.y_in').on('input', function (){
        XYR();
        if (checkY(x,y,r))
            point(x, y, r);
    });
    $('.r_in').on('input', function (){
        XYR();
        if (checkY(x,y,r))
            point(x, y, r);
    })

});

function point(x, y, r) {
    $('#point').attr("cx", (x * 120 / r + 200))
        .attr("cy", (y * -120 / r + 200));
}

function drawPoints(x, y, r) {
    if (getHit(x, y, r) === true) {
        document.querySelector('.graph').innerHTML += '<circle r="3" cx="' + (x * 120 / r + 200) +
            '" cy="' + (y * -120 / r + 200) + '" fill="yellow" ></circle>'
    } else {
        document.querySelector('.graph').innerHTML += '<circle r="3" cx="' + (x * 120 / r + 200) +
            '" cy="' + (y * -120 / r + 200) + '" fill="red" ></circle>'
    }
}

function getHit(x, y, r) {
    if (x >= 0 && y >= 0 && x <= 2*y + r){
        return true
    }
    if (x <= 0 && y <= 0 && x*x + y*y <= r*r/4){
        return true
    }
    return (x <= 0 && y >= 0 && x <= -r/2 && y <= r)
}
