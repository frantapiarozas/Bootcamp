"use strict";
// diamesaño :: numero formato DDMMAAAA -> aaaammdd
// numero en formato DDMMAAAA devuelto en formato inverso 
// ejemplo: diamesaño (12052015) devuelve 20150512
let dma = 12052015;
let dma1 = 15102002;
console.log(dma + " y " + dma1);
function diamesaño(dma) {
    let amd = dma.toString();
    let añomesdia = amd[4] + amd[5] + amd[6] + amd[7] + amd[2] + amd[3] + amd[0] + amd[1];
    return añomesdia;
}
console.log(diamesaño(dma));
let fecha1 = +(diamesaño(dma));
console.log(diamesaño(dma1));
let fecha2 = +(diamesaño(dma1));
if (fecha1 > fecha2) {
    console.log(dma + " es mayor que " + dma1);
}
else {
    console.log(dma + " es menor que " + dma1);
}
