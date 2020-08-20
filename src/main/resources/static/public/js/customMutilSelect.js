let txt, content, list, quantity, result, arrPayload;

txt = document.getElementById("droptxt");
content = document.getElementById("contentx");
list = document.querySelectorAll('.contentx input[type="checkbox"]');
quantity = document.querySelectorAll('.quantity');
result = document.getElementById("result");
txt.addEventListener('click', function () {
    console.log(content)
    content.classList.toggle('showx')
})

// Close the dropdown if the user clicks outside of it
window.onclick = function (e) {
    if (!e.target.matches('.list')) {
        if (content.classList.contains('showx')) content.classList.remove('showx')
    }
}

list.forEach(function (item, index) {
    item.addEventListener('click', function () {
        quantity[index].type = (item.checked) ? 'number' : 'hidden';
        calc()
    })
})

quantity.forEach(function (item) {
    item.addEventListener('input', calc)
})

function calc() {
    for (var i = 0, arr = [], arrResult = []; i < list.length; i++) {
        if (list[i].checked) {
            arr.push(quantity[i].value + ' x ' + list[i].dataset.value)
            arrResult.push({
                itemId: list[i].value,
                qty: quantity[i].value,
            });
        }
    }
    arrPayload = arrResult;
    result.value = JSON.stringify(arrResult);
    //console.log(result);
    txt.value = arr.join(', ')
}


