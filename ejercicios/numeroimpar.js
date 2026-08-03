"use strict";
//
//funcion que calcule promedio de todos los numeros impares de un arreglo
//
let b = [1, 2, 3, 4, 5, 6, 7];
let suma = 0;
let contar = 0;
let resto = 0;
let promedio = 0;
function promedioImpares(b) {
    for (let i = 0; i < 7; i++) {
        resto = b[i] % 2;
        if (resto != 0) {
            contar++;
            suma = b[i] + suma;
        }
    }
    promedio = suma / contar;
    return (promedio);
}
;
console.log("el promedio de los impares " + b + " es : " + promedioImpares(b));
