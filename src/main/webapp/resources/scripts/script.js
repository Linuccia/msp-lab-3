function XYR(){
    x = $("input[name='form:slider_x_hidden']").val();
    y = $("input[name='form:y_in']").val();
    r = $("input[id='form:r_value']").val();
}

function checkY(x, y) {
    if (!y) {
        return exceptionY('<br>Вы не ввели Y</br>')
    } else if (isNaN(y)) {
        return exceptionY('<br>Y должен быть числом</br>')
    } else if (y < -3 || y > 3) {
        return exceptionY('<br>Y не принадлежит [-3:3]</br>')
    } else {
        $(".exceptionY").html('');
        return true
    }
}

function exceptionY(message) {
    $(".exceptionY").html(message);
    point(0,0, 1);
    return false
}

function change() {
    setTimeout(function(){
        XYR();
        if (checkY(x,y))
            point(x, y, r);
    }, 150);
    drawPoints();
}


function point(x, y, r) {
    $('#point').attr("cx", (x * 120 / r + 200))
        .attr("cy", (y * -120 / r + 200));
}

