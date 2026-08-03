//arreglo de numeros

let L:number [] = [5, 8, 4, 3, 6, 9]
//se muestran indices y sus valores
for(let i in L) {
    console.log ("elemento en indice " + i + " es " + L[i]);
}
//funcion suma que recibe arreglo L
function suma(L:number[]):number {
    let sumar:number = 0;

    for (let i in L) {
        sumar += L[i];
    }
    return sumar; 
}
//funcion promedio
function promedio(sumar:number):number {
    let prom:number = 0;
    prom = suma(L)/L.length
}
console.log(suma(L));