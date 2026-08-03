//cajero ::
//
//

let monto:number = 20000;
let retiro:number = 4;
let valor:number;

function cajero (monto:number, retiro:number):number {
    valor = monto % retiro;
    return (valor);
}
console.log (cajero (monto, valor));