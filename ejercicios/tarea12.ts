//import L from ./promedio.js
//promedios de cada estudiante
//gabriela:57.5


import {L} from "./promedio.js";

for (let i:number = 0; i < L.length; i++) {
    let prom:number = (L[i][1][0]+L[i][1][1]+L[i][1][2]+L[i][1][3])/4;
    console.log(L[i][0] + " : " + prom);
}