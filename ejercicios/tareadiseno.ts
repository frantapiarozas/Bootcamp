//1. Escriba una clase Persona con atributos para el nombre, la edad y el rut. Incluya un método que
//devuelva una presentación de la persona:

class Persona{
    //atributos
    nombre: string;
    edad: number;
    rut: string;

    constructor (nom: string, eda: number, ru: string) {
        this.nombre = nom;
        this.edad = eda;
        this.rut = ru; 
    }
    toString() : string {
    return "Hola, mi nombre es " + this.nombre + ", tengo " + this.edad + " anos, y mi rut es " + this.rut;
    }
    
}
let fco: Persona = new Persona("Fco TAPIA", 23 , "21145549-7");

console.log(fco.toString());
