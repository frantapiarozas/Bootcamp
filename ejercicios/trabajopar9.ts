//detectar los espacios en un string y reemplazarlos por un "_"
//aSnake

let i:number;
let palabraModificada: string;

function aSnake (palabra:string):string {

let listamayuscula:string[]=palabra.match(/A-Z/)

    for (i = 0; i < palabra.length; i++) {
        if (palabra.charAt(i) == "") {
            palabraModificada = palabra.replace("","_");
            break; 
        }

        else if(&& i>0) {

                break;
            }

}
return listaMayuscula;
//palabra[i].match(/A-Z/)
// const resultado = texto.match(/[A-Z]/);
}
console.log(aSnake("Juan Perez"));