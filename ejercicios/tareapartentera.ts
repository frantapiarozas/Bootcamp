// parteentera:: num num -> numero sin decimales
// calcula division de dos numeros enteros y devuelve cuociente sin decimales
// parteentera (11,3) devuelve 3

let divid = 11;
let divis = 3;
let cuoc:number = 0;

function parteEntera (divid:number, divis:number) : number  {
    cuoc = divid / divis;
    cuoc = Math.trunc (cuoc);
    return (cuoc)
}
console.log (parteEntera (divid,divis));
console.log (divid + " / " + divis + " igual " + cuoc);