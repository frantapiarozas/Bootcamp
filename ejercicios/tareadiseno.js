"use strict";
//1. Escriba una clase Persona con atributos para el nombre, la edad y el rut. Incluya un método que
//devuelva una presentación de la persona:
class Persona {
    //atributos
    nombre;
    edad;
    rut;
    constructor(nom, eda, ru) {
        this.nombre = nom;
        this.edad = eda;
        this.rut = ru;
    }
    toString() {
        return "Hola, mi nombre es " + this.nombre + ", tengo " + this.edad + " anos, y mi rut es " + this.rut;
    }
}
let fco = new Persona("Fco TAPIA", 23, "21145549-7");
//console.log("hola mi nombre es " + nombre + "" tengo " + edad + " años y mi rut es " + rut);
console.log(fco.toString());
