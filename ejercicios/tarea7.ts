let inicio:number=1;
let factoriza:number = 1;
let fin: number = 3;

for (let i:number = 1; i <= fin; i++) {
    factoriza = i * factoriza;
};
console.log ("el factorial de " + fin + " es " + factoriza);