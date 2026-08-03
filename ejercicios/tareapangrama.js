"use strict";
//
//indicar si el texto es o no un pangrama
//
let texto = "cada vez que trabajo, me paga un whisky";
function esPangrama(texto) {
    //  textoLimpio = textoLimpio.toLowerCase("NFD").replace(/[\u0300-\u036f]/g, "");
    //  const letrasValidas = textoLimpio.replace(/[^a-z]/g, "");
    const conjuntoLetras = new Set(texto.toLowerCase().replace(/[^a-z]/g, ""));
    return conjuntoLetras.size === 26;
}
console.log(esPangrama(texto));
