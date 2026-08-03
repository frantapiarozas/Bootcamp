//
//devolver la cantidad de vocales de una palabra
//

let i:number;
let galeria:string="abrelata";
const vocales:string = "aeiouAEIOU";
let conta:number = 0;

function buscavocales (galeria:string): number {
    for (i = 0; i < galeria.length;i++) {
        if (vocales.includes(galeria[i])) {
        conta++}
    }
   return conta
}
console.log(galeria);
console.log(buscavocales(galeria));