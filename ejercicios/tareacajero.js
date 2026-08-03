"use strict";
//cajero ::
//
//
let monto = 20000;
let retiro = 4;
let valor;
function cajero(monto, retiro) {
    valor = monto % retiro;
    return (valor);
}
console.log(cajero(monto, valor));
