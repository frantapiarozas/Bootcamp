//
//promedios de cada estudiante
//
import { L } from "./promedio.js";
for (let i = 0; i < L.length; i++) {
    let prom = (L[i][1][0] + L[i][1][1] + L[i][1][2] + L[i][1][3]) / 4;
    console.log(L[i][0] + " : " + prom);
}
