//
//funcion que calcule promedio de todos los numeros impares de un arreglo
//

let b:number [] = [1,2,3,4,5,6,7]
let suma:number=0;
let contar:number=0;
let resto:number=0;
let promedio:number=0;

function promedioImpares (b:number[]) :number {
    for (let i:number=0;i<7;i++) {
        resto=b[i] % 2;
        if (resto!=0) {
            contar++;
            suma=b[i] + suma;
        }
    }
    promedio=suma/contar;
    return (promedio);
};

console.log("el promedio de los impares " + b + " es : " + promedioImpares(b));