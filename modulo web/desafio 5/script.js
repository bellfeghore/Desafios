function validar(){
  var nombre = document.getElementById("nombre").value;
  var apellidos = document.getElementById("apellidos").value;
  var correo = document.getElementById("correo").value;
  var usuario = document.getElementById("usuario").value;
  var contraseña = document.getElementById("contraseña").value;
  var telefono = document.getElementById("telefono").value;
  var comprobarCorreo = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  var comprobarTelefono = /^([0-9])*$/;
if (nombre===""||apellidos===""||correo===""||usuario===""||contraseña===""||telefono==="") {
  alert("Todos los campos son obligatorios");
  return false;
}
else if (nombre.length>30) {
  alert("El nombre es demasiado largo");
  return false;
}
else if (apellidos.length>80) {
  alert("El apellido es demasiado largo");
  return false;
}
else if (correo.length>100){
  alert("El correo es demasiado largo");
  return false;
}
else if (!comprobarCorreo.test(correo)){
  alert("Correo invalido");
  return false;
}
else if (usuario.length>20) {
  alert("El usuario es demasiado largo");
  return false;
}
else if (contraseña.length>20) {
  alert("La contraseña es demasiado largo");
  return false;
}
else if (telefono.length>15) {
  alert("El telefono es demasiado largo");
  return false;
}
else if (!comprobarTelefono.test(telefono)) {
  alert("El telefono solo puede contener numeros");
  return false;
}
else {
    alert(`bienvenido ${nombre} ${apellidos}!. Gracias por registrarte. Tu nombre de usuario es : ${usuario} y tu contraseña es ${contraseña}.`);
}
}
