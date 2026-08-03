"use strict";
let minumero = -543;
if (minumero >= 0) {
    let decena = Math.trunc(minumero / 10) % 10;
    let unidad = Math.abs(minumero % 10);
    let centena = Math.trunc(minumero / 100) % 10;
    console.log(unidad);
    console.log(decena);
    console.log(centena);
    console.log("el numero invertido es: " + unidad + decena + centena);
}
else
    console.log("numero negativo");
