"use strict";
let n = 92;
let contador = 0;
let digitos = n;
console.log("entre " + n);
while (digitos != 0) {
    digitos = (n / 10);
    digitos = (digitos | 0);
    console.log(digitos);
    contador = contador + 1;
    console.log(contador);
}
console.log("el  numero " + n + " tiene " + digitos + " digitos");
