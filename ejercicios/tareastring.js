"use strict";
//
//
//
let i;
let galeria = "abrelata";
const vocales = "aeiouAEIOU";
let conta = 0;
function buscavocales(galeria) {
    for (i = 0; i < galeria.length; i++) {
        if (vocales.includes(galeria[i])) {
            conta++;
        }
    }
    return conta;
}
console.log(galeria);
console.log(buscavocales(galeria));
