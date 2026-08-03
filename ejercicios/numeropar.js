"use strict";
//function listapares (n):num -> pares
//funcion que retorne un arreglo con los n primeros numeros pares
//[2,4,6,8,10,12]
let n = 6;
let pares = new Array(n);
function listaPares(n) {
    for (let i = 0; i < n; i++) {
        pares[i] = 2 * (i + 1);
    }
    return pares;
}
console.log(listaPares(n));
