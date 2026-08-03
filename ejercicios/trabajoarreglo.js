"use strict";
//enero:: num -> temperaturas de todos los dias
//mostrar la temperatura de todo los dias de enero
//enero [0] devuelve 1 de enero 23 grados
let enero = [23, 14, 20, 19, 22, 24, 25, 27, 19, 17, 21, 13, 16, 15, 20, 22, 26, 25, 27, 25, 27, 14, 27, 25, 27, 26, 16, 22, 18, 27, 14];
for (let i in enero) {
    console.log(Number(i) + 1 + " de enero " + enero[i] + " grados");
}
