"use strict";
let n = 5;
let conta = 0;
let sumapar = 0;
if (n > 0) {
    for (let i = 1; conta < n; i++) {
        let resto = i % 2;
        if (resto == 0) {
            sumapar = sumapar + i;
            conta = conta + 1;
        }
    }
    console.log("los primeros " + n + " suman " + sumapar);
}
else {
    console.log("numero negativo");
}
