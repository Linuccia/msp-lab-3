let svg = document.getElementById('graph');

function clickGraph() {
    $('.graph').on('click', function click(event) {
        let r = $("input[id='form:r_value']").val();
        let position = getMousePosition(svg, event);
        let x = position.x;
        let y = position.y;
        let y_val = ((200 - y) * r / 120).toFixed(4);
        if (y_val > 3) y_val = 3;
        if (y_val < -3) y_val = -3;
        let x_val = (((x - 200) * r / 120)).toFixed();
        if (x_val >= 2) x_val = 2;
        if (x_val <= -2) x_val = -2;
        if (x_val === "-0") x_val = 0;
        point1(x_val, y_val, r);
        $("a[id='form:slider_x_handle']").attr("style", "left: "+(50 + x_val*25)+"%");
        $("input[id='form:slider_x_hidden']").attr("value",x_val);
        $("label[id='form:xValue']").text(x_val);
        $("input[name='form:y_in']").val(y_val);
    });
}

function point1(x, y, r) {
    $('#point').attr('cx', x*120/r + 200).attr('cy', 200 - y*120/r );
}

function getMousePosition(svg, event) {
    let rect = svg.getBoundingClientRect();
    return {
        x: event.clientX - rect.left,
        y: event.clientY - rect.top
    };
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
    if (x >= 0 && y >= 0 && y <= -x/2 + r/2){
        return true
    }
    if (x >= 0 && y <= 0 && x*x + y*y <= r*r/4){
        return true
    }
    return (x <= 0 && y >= 0 && x >= -r/2 && y <= r)
}

// function drawPoints() {
//     let rows = document.getElementById('table_data').childNodes;
//     rows.forEach(row => {
//         let a = row.childNodes;
//         let b = a[0].innerHTML;
//         let c = a[1].innerHTML;
//         let d = r;
//         let res;
//         if (a[3].innerHTML === "true") {
//             res = "yellow";
//         } else {
//             res = "red";
//         }
//         document.querySelector('.graph').innerHTML += '<circle r="3" cx="' + (b * 120 /d + 200) +
//             '" cy="' + (c * -120 / d + 200) + '" fill="' + res + " ></circle>"
//     })
// }