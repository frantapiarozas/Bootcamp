//
//escribir un conjunto con funciones
//L = [1,2,2,1] -> C = [1,2]

let l = [3,5,6,5,7,1,3];
let m = [1,4,5];

function aConjunto(arr: number[]): number[] {
    const conjunto: number[] = [];
    for (const elemento of arr) {
        if (conjunto.indexOf(elemento) === -1) {
            conjunto.push(elemento);
        }
    }
    return conjunto
}

function union(l:number[], m:number[]): number[] {
    const combinado = l.concat(m);
    return aConjunto(combinado);
}

function interseccion(l:number[], m:number[]): number[] {
    const conjunto1 = aConjunto(l);
    const resultado:number[] = [];

    for (const elemento of conjunto1) {
        if (m.includes(elemento)) {
            resultado.push(elemento);
        }
    }
    return resultado
}

function esSubconjunto(l: number[], m: number[]): boolean {
    for (const elemento of l) {
        if (m.indexOf(elemento) === -1) {
            return false
        }
    }
    return true
}

console.log (aConjunto([3,5,6,5,7,1,3]));
console.log (union([3,5,6,5,7,1,3], [1,4,5]));
console.log (interseccion([3,5,6,5,7,1,3], [1,4,5]));
console.log (esSubconjunto([3,5,6,5,7,1,3], [1,4,5]));