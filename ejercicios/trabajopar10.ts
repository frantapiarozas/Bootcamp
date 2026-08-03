//1. Escriba una clase Persona con atributos para el nombre, la edad y el rut. Incluya un método que
//devuelva una presentación de la persona:
class Persona {
    nombre: string;
    edad: number;
    rut: string;
    constructor(nombre: string, edad: number, rut: string){
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
    }
    toString(): string {
        return "Hola, mi nombre es " +
            this.nombre + ", tengo " + this.edad +
            " años y mi rut es " + this.rut; 
    }
}
let juanito: Persona = new Persona("Juan Pérez", 35, "12.345.678-9");
//console.log(juanito.toString());



//2 - Escriba la clase Circulo con un atributo para el radio y métodos para calcular el área y el perímetro.
//Recuerde que las fórmulas para calcularlos son:
// area = pi * r**2
// perimetro = 2 * pi * r
class Circulo {
    radio: number;
    constructor(radio: number) {
        this.radio = radio;
    }
    area(): number {
        return Math.PI * this.radio**2;
    }
    perimetro(): number {
        return 2 * Math.PI * this.radio;
    }
}
let circulo: Circulo = new Circulo(10);
//console.log("Area: " + circulo.area() + ", Perimetro: " + circulo.perimetro());

//3 Escriba la clase CuentaBancaria con atributos para el saldo y métodos para depositar y retirar dinero
//Considere, además, que la cuenta tiene un tope de $15.000.000, y que luego de esa cantidad ya no se
//puede depositar dinero.
//Pista: Tenga en cuenta casos bordes como, por ejemplo, retirar más dinero del disponible.
class CuentaBancaria {
    saldo: number;
    constructor(saldo: number) {
        this.saldo = saldo;
    }
    getSaldo(): number {
        return this.saldo;
    }
    depositar(monto: number): boolean{
        if(monto <= 0){
            return false;
        }
        let total: number = this.saldo + monto;
        if(total > 15000000){
            return false;
        
        } else {
            this.saldo = total;
            return true;
        }
    }
    retirar(monto: number): boolean {
        if(monto > this.saldo){
            return false;
        }
        if(monto <= 0){
            return false;
        
        } else {
            this.saldo -= monto;
            return true;
        }
    }
}
let cuenta: CuentaBancaria = new CuentaBancaria(1000000);
console.assert(cuenta.depositar(15000000) == false);
console.assert(cuenta.depositar(14000000) == true);
console.assert(cuenta.depositar(0) == false);
console.log(cuenta.getSaldo()); // 15.000.000
console.assert(cuenta.retirar(16000000) == false);
console.assert(cuenta.retirar(0) == false);
console.assert(cuenta.retirar(6000000) == true);
console.log(cuenta.getSaldo());

//4
/*
El tiempo normalmente es representado por el formato HH:MM, que significa Horas y Minutos.
Sin embargo, manejar dicho formato no es directo, por lo que usaremos sus conocimientos de
clases para facilitarlo.
a. Escriba la clase Tiempo , suponiendo que un instante es representado con horas y minutos.
b. Escriba el método enMinutos(t1) que retorne un entero representando la cantidad de minutos.
Por ejemplo, el tiempo 14:05 retorna 845 , es decir, 14*60 + 5.
c. Adapte la clase Tiempo para poder imprimir un objeto en el formato "8:30" .
d. Adapte la clase Tiempo para que permita sumar instantes de tiempo: T1.suma(T2).
e. Adapte la clase Tiempo para que permita restar instantes de tiempo: T1.resta(T2).
*/ 
class Tiempo {
    hora: number;
    minutos: number;
    constructor(hora: number, minutos: number) {
        this.hora = hora;
        this.minutos = minutos;
    }
    getHora(): number {
        return this.hora;
    }
    getMinutos(): number {
        return this.minutos;
    }

    static enMinutos(tiempo: Tiempo): number {
        return tiempo.getHora() * 60 + tiempo.getMinutos();
    }
}
let tiempo: Tiempo = new Tiempo(1405);
Tiempo.enMinutos();