//num * num% + num -> precio durante 10 años
//el precio de productos aumenta 10% cada año
//ejemplo:2189 * 10% + 2189 = 2407

let precio:number = 1990;
let anhos:number = 10;
let L:number[] = [];

function proyeccionPrecios(precio:number, anhos:number): number[] {
    for (let i:number = 0; i < 10; i++) {
       L[i] = Math.trunc (precio * 0.1 + precio);
       precio = L[i];
    }
    return L
}

console.log (proyeccionPrecios(precio,anhos));