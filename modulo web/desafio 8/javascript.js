
var traumatologia = [];
var radiologia = [];
var dental = [];
var primero,ultimo;
function registro(hora,especialista,paciente,rut,prevision){
  this.hora=hora;
  this.especialista=especialista;
  this.paciente=paciente;
  this.rut=rut;
  this.prevision=prevision;
}
//RADIOLOGIA
var miregistro = new registro("11:00","Ignacio Schulz","Francis Rojas","9878782-1","Fonasa");
radiologia.push(miregistro);
var miregistro = new registro("11:30","Federico Subercaseaux","Pamela Estrada","15345241-3","Isapre");
radiologia.push(miregistro);
var miregistro = new registro("15:00","Fernando Wurthz","Armando Luna","16445345-9","Isapre");
radiologia.push(miregistro);
var miregistro = new registro("15:30","Ana Maria Godoy","Manuel Godoy","17666419-0","Fonasa");
radiologia.push(miregistro);
var miregistro = new registro("16:00","Patricia Suazo","Ramon Ulloa","14989389-K","Fonasa");
radiologia.push(miregistro);

radiologia.splice(0,1);
var i = radiologia.length - 1;
radiologia.splice(i,1);

var radCount = radiologia.length;
document.getElementById("rad").innerHTML = "Total de consultas: " + radCount;
primero = radiologia[0].paciente + " - " + radiologia[0].prevision;
ultimo = radiologia[radiologia.length-1].paciente + " - " + radiologia[radiologia.length-1].prevision;
var radAtc = "Primer consulta: " + primero + " | ultima consulta: " + ultimo;
document.getElementById("rad2").innerHTML = radAtc;
//TRAUMATOLOGIA
var miregistro = new registro("08:00","Maria Paz Ultarra","Paula Sanchez","15554774-5","Fonasa");
traumatologia.push(miregistro);
var miregistro = new registro("10:00","Raul Araya","Angélica Navas","15444147-9","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("10:30","Maria Arriagada","Ana Klapp","17879423-9","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("11:00","Alejandro Badilla","Felipe Mardones","1547423-6","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("11:30","Cecilia Budnik","Diego Marre","16554741-K","Fonasa");
traumatologia.push(miregistro);
var miregistro = new registro("12:00","Arturo Cavagnaro","Cecilia Mendez","9747535-8","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("12:30","Andres Kanacri","Marcial Suazo","11254785-5","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("09:00","Rene Poblete","Ana Gellona","13123329-7","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("09:30","Maria Solar","Ramiro Andrade","11254785-5","Fonasa");
traumatologia.push(miregistro);
var miregistro = new registro("10:00","Raul Loyola","Carmen Isla","10112348-3","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("10:30","Andres Kanacri","Antonio Larenas","13453234-1","Isapre");
traumatologia.push(miregistro);
var miregistro = new registro("12:30","Matias Aravena","Susana Poblete","14345656-6","Fonasa");
traumatologia.push(miregistro);
var traCount = traumatologia.length;
document.getElementById("tra").innerHTML = "Total de consultas: " + traCount;
primero = traumatologia[0].paciente + " - " + traumatologia[0].prevision;
ultimo = traumatologia[traumatologia.length-1].paciente + " - " + traumatologia[traumatologia.length-1].prevision;
var traAtc = "Primer consulta: " + primero + " | ultima consulta: " + ultimo;
document.getElementById("tra2").innerHTML = traAtc;
//DENTAL
var miregistro = new registro("08:30","Andrea Zuñiga","Marcela Retamal","11123425-6","Isapre");
dental.push(miregistro);
var miregistro = new registro("11:00","Maria Pia Zañartu","Angel muñoz","9878789-2","Isapre");
dental.push(miregistro);
var miregistro = new registro("11:30","Scarlett Witting","Mario Kast","7998789-5","Fonasa");
dental.push(miregistro);
var miregistro = new registro("13:00","Francisco Von Teuber","Karin Fernandez","18887662-K","Fonasa");
dental.push(miregistro);
var miregistro = new registro("13:3s0","Eduardo Viñuela","Hugo Sanchez","17665461-4","Fonasa");
dental.push(miregistro);
var miregistro = new registro("14:00","Raquel Villaseca","Ana Sepulveda","14441281-0","Isapre");
dental.push(miregistro);
var denCount = dental.length;
document.getElementById("den").innerHTML = "Total de consultas: " + denCount;
primero = dental[0].paciente + " - " + dental[0].prevision;
ultimo = dental[dental.length-1].paciente + " - " + dental[dental.length-1].prevision;
var denAtc = "Primer consulta: " + primero + " | ultima consulta: " + ultimo;
document.getElementById("den2").innerHTML = denAtc;

document.write(`<h4> la lista de consultas médicas de Dental</h4>`)
for (var i = 0; i < dental.length; i++) {
  document.write(`<p>${dental[i].hora} - ${dental[i].especialista} - ${dental[i].paciente} - ${dental[i].rut} - ${dental[i].prevision}</p>`);
}

var totalPacientes = radiologia.concat(dental,traumatologia);
document.write(`<h4>Lista de pacientes</h4>`)
for (var i = 0; i < totalPacientes.length; i++) {
  var p = totalPacientes[i]
  document.write(`<p>${totalPacientes[i].paciente}</p>`)
}

document.write(`<h4>FONASA cambiarlas por ISAPRE y viceversa</h4>`)
dental.map(dental=>{
  if (dental.prevision==="Fonasa") {
    dental.prevision="Isapre"
  }else {
    dental.prevision="Fonasa"
  }return dental;
});

for (var i = 0; i < dental.length; i++) {
  document.write(`<p>${dental[i].prevision};${dental[i].rut};${dental[i].paciente}</p>`);
}
