let lado1: number = 3;
let lado2: number = 5;
let lado3: number = 1;

// Evaluación triangular:
if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2) {
    
    // identificación de triangulos:
    if (lado1 === lado2 && lado2 === lado3) {
        console.log("Equilátero");
    } else if (lado1 === lado2 || lado2 === lado3 || lado1 === lado3) {
        console.log("Isósceles");
    } else {
        console.log("Escaleno");
    }
} else {
    console.log("No forman un triángulo");
}