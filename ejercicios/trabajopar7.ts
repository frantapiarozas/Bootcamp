import * as tiempo from "./tiempo.js";

const tiempo1: number = 1;
const tiempo2: number = 4.5;
const suma: number = tiempo1 + tiempo2;
const resta: number = Math.abs(tiempo1 - tiempo2);

console.log("Tiempo 1 es " + tiempo.aHHMM(tiempo1));
console.log("Tiempo 1 es " + tiempo.aHHMM(tiempo1));
console.log("Tiempo 2 es " + tiempo.aHHMM(tiempo2));
console.log("");
console.log("La suma es " + tiempo.aHHMM(suma));
console.log("La resta es " + tiempo.aHHMM(resta));

console.assert(tiempo.aHHMM(suma) === "05:30");
console.assert(tiempo.aHHMM(resta) === "03:30");
console.assert(tiempo.aMinutos(1) === 60);
console.assert(tiempo.aMinutos(4.5) === 270);
console.assert(tiempo.aHoras(60) === 1);
console.assert(tiempo.aHoras(270) === 4.5);
console.assert(tiempo.aHHMM(1) === "01:00");
console.assert(tiempo.aHHMM(4.5) === "04:30");
console.assert(tiempo.comparar(1, 4.5) === -1);
console.assert(tiempo.comparar(4.5, 4.5) === 0);
console.assert(tiempo.comparar(4.5, 1) === 1);