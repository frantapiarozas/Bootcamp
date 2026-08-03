"use strict";
let L = [5, 8, 4, 3, 6, 9];
for (let i in L) {
    console.log("elemento en indice " + i + " es " + L[i]);
}
function suma(L) {
    let sumar = 0;
    for (let i in L) {
        sumar += L[i];
    }
    return sumar;
}
console.log(suma(L));
