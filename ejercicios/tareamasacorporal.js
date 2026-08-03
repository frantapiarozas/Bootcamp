"use strict";
let imc;
let nutricion;
function masaCorporal(peso, altura) {
    imc = (peso / altura ** 2);
    if (imc < 18.5)
        nutricion = "bajo peso";
    else if (imc > 18.6 && imc < 24.9) {
        nutricion = "peso normal";
    }
    else if (imc > 25 && imc < 29.9) {
        nutricion = "sobrepeso";
    }
    else if (imc > 30) {
        nutricion = "obesidad";
    }
    return nutricion;
}
console.log(masaCorporal(40, 1.50));
