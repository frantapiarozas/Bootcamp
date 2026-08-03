"use strict";
//evaluacion:num [num] -> num
//las notas menores 5 se les suma 0.5
//ejemplo: [2.4,1.5,6.1] = [2.9,2.0,6.1]
let notas = [4.5, 5.3, 3.2, 6.3];
let notaok = [];
function evaluacion(notas) {
    for (let i = 0; i < notas.length; i++) {
        if (notas[i] < 5.0) {
            notaok.push(notas[i] + 0.5);
        }
        else {
            notaok.push(notas[i]);
        }
    }
    return (notaok);
}
console.log(evaluacion(notas));
let sumnota = 0;
let sumnotaok = 0;
for (let i = 0; i < notas.length; i++) {
    sumnota = notas[i] + sumnota;
    sumnotaok = notaok[i] + sumnotaok;
    console.log(notas[i] + " -> " + notaok[i]);
}
console.log("promedio original: " + Number(sumnota / notas.length).toFixed(1));
console.log("promedio modificado: " + Number(sumnotaok / notaok.length).toFixed(1));
