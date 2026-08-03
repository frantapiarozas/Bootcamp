"use strict";
//num * num% + num -> precio durante 10 años
//el precio de productos aumenta 10% cada año
//ejemplo:240 * 10% + 240 = 
let precio = 1990;
let anhos = 10;
let L = [];
function proyeccionPrecios(precio, anhos) {
    for (let i = 0; i < 10; i++) {
        L[i] = Math.trunc(precio * 0.1 + precio);
        precio = L[i];
    }
    return L;
}
console.log(proyeccionPrecios(precio, anhos));
