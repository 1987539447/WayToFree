var list = document.querySelector('.output ul');
var totalBox = document.querySelector('.output p');
var total = 0;
list.innerHTML = '';
totalBox.textContent = '';
var proudcts = [
'Underpants:6.99',
'Socks:5.99',
'T-shirt:14.99',
'Trousers:31.99',
'Shoes:23.99'];

for (var i = 0; i < proudcts.length; i++) { // number 2
                               // number 3
    var product = products[i];
    var name = product.splice(0,product.indexOf(':'));
    var price = Number(product.splice(product.indexOf(':')+1));
    // number 4
    total += price;
    // number 5
    var itemText = name + '-$'+ price;

    var listItem = document.createElement('li');
    listItem.textContent = itemText;
    list.appendChild(listItem);
}

totalBox.textContent = 'Total: $' + total.toFixed(2);
