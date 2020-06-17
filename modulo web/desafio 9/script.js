function opciones(){
  var indice = prompt("Por favor ingrese un valor entre 1 y 6",0);
  switch (indice) {
    case "1":
    document.getElementById("datos").innerHTML=
    document.write("<p>Ingrese un valor de entre 0 y 100 para imprimir todos los numeros desde 0 hasta el valor ingresado</p>");
      document.write('<p><input type="text" id="respuesta" value "0-100"</p>');
      document.write('<p><button type="button" id="button" onclick="primer()">respuesta</button></p>');
      break;
    case "2":
    document.getElementById("datos").innerHTML=
    document.write("<p>De que color es el caballo blanco de Napoleon?</p>");
      document.write('<p><input type="text" id="respuesta" value "0-100"</p>');
      document.write('<p><button type="button" id="button" onclick="segundo()">Comprobar</button></p>');
      break;
    case "3":
    document.getElementById("datos").innerHTML=
    document.write("<p>Ingrese su promedio de matematicas, ciencias y fisica</p>");
      document.write('<p><input type="text" id="respuesta1" value "promedio de matematicas"</p>');
      document.write('<p><input type="text" id="respuesta2" value "promedio de ciencias"</p>');
      document.write('<p><input type="text" id="respuesta3" value "promedio de fisica"</p>');
      document.write('<p><button type="button" id="button" onclick="tercero()">Sacar promedio</button></p>');
      break;
    case "4":
    var coma = ",";
    var frutas = "";
    var fruta = prompt("Ingrese la primera fruta");
    if (fruta!=="manzana") {
      frutas = fruta;
    }
    var fruta = prompt("Ingrese la segnda fruta");
    if (fruta!=="manzana") {
      if (frutas!==null) {
      frutas = frutas.concat(coma,fruta)
    }else {
      frutas = fruta;
    }
    }
    var fruta = prompt("Ingrese la tercera fruta");
    if (fruta!=="manzana") {
      frutas = frutas.concat(coma,fruta)
    }
    console.log(frutas)
      break;
    case "5":
    document.getElementById("datos").innerHTML=
    document.write("<p>Ingresa tu nombre</p>");
      document.write('<p><input type="text" id="respuesta" value "0-100"</p>');
      document.write('<p><button type="button" id="button" onclick="quinto()">Contar</button></p>')
      break;
    case "6":
      cierre();
      break;
  }
}

function cierre(){
  document.getElementById("datos").innerHTML =
  document.write("<h4>Adios</h4>");
  document.write('<p><img src="chao.gif" alt=""></p>');
  setRandomColor();
}


function primer(){
  var x = document.getElementById("respuesta").value;
  if (x<=100 && x>=0) {

    document.write(`<p> Los numeros desde 0 hasta ${x} son: </p>`);
    for (var i = 0; i <= x; i++) {
      document.write(`${i}  `);
    };
  }else {
    alert("ha ingresado un valor incorrecto, intente de nuevo");

  }
}

function segundo(){
  var x = document.getElementById("respuesta").value;
  if (x==="blanco") {
    document.write("<p> Respuesta Correcta</p>")
  }else {
    alert("ha ingresado una respuesta incorrecta, intente de nuevo");
  }
}

function tercero(){
  var p1 = document.getElementById("respuesta1").value;
  var p2 = document.getElementById("respuesta2").value;
  var p3 = document.getElementById("respuesta3").value;
  var p = (parseFloat(p1)+parseFloat(p2)+parseFloat(p3))/3;
  var r = Math.round(p);
  document.write(`<p>Tu promedio es ${r}.</p>`);
}

function quinto(){
  var x = document.getElementById("respuesta").value;
  var vocales = 0;
  var consonantes = 0;
  var espacios = 0;
  vocales = x.match(/[aeiou]/gi).length;
  for (var i = 0; i < x.length; i++) {
    if (x[i]===" ") {
      espacios = espacios+1;
    }
  }
  consonantes = x.length - vocales - espacios;
  alert(vocales + ", " + consonantes);
}






//sacado de San Google para hacer la gracia
function setRandomColor() {const setBg = () => {
  const randomColor = Math.floor(Math.random()*16777215).toString(16);
  document.body.style.backgroundColor = "#" + randomColor;
}
setBg();}
