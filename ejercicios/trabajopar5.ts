//invertir :: num -> num
//dado un numero de dos digitos, lo devuelve al reves
//ejemplo: invertir(81) devuelve 18
function invertir(numero: number): number {
 let unidades: number = numero % 10;
 //let division: number = numero / 10;
 //let decenas: number = division - (unidades / 10);
 let decenas: number = (numero - unidades) / 10;
 return unidades * 10 + decenas;
}
//Tests
console.assert(invertir(81) == 18);
console.assert(invertir(20) == 2);