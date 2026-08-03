"use strict";
let mes = 2;
let anio = 2024;
let esBisiesto = anio % 4 === 0 && (anio % 100 !== 0 || anio % 400 === 0);
let diasDelMes;
if (mes === 1 || mes === 3 || mes === 5 || mes === 7 || mes === 8 || mes === 10 || mes === 12) {
    diasDelMes = 31;
}
else if (mes === 4 || mes === 6 || mes === 9 || mes === 11) {
    diasDelMes = 30;
}
else if (mes === 2) {
    diasDelMes = esBisiesto ? 29 : 28;
}
else {
    diasDelMes = 0;
}
if (diasDelMes === 0) {
    console.log("Mes inválido");
}
else {
    console.log(`El mes ${mes} del año ${anio} tiene ${diasDelMes} días`);
}
