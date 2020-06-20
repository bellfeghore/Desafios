
function revision(){
    var r = 0;
    var rut = document.getElementById("rut").value;
    var nombres = document.getElementById("nombres").value;
    var apellidos = document.getElementById("apellidos").value;
    var edad = document.getElementById("edad").value;
    var correo = document.getElementById("correo").value; 
    var especialidad = document.getElementById("especialidad").options[document.getElementById("especialidad").selectedIndex].text;
    var fecha = document.getElementById("fecha").value;
    var hora = document.getElementById("hora").options[document.getElementById("hora").selectedIndex].text;
    var cRut = /^[0-9|-|kK]*[0-9]{8}[-]{1}[0-9kK]{1}$/;
    var cCorreo = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var cEdad = /[0-9]/gim;
    var cLetras= /^[ñA-Za-z _]*[ñA-Za-z][ñA-Za-z _]*$/;
    if(rut===""||nombres===""||apellidos===""||edad===""||correo===""||fecha===""){
        alert("Por favor rellene todos los campos")
    }else{
        if(cRut.test(rut)){
            r++;
        }else{
            alert("Rut invalido")
        }
        if(cLetras.test(nombres)){
            r++;
        }else{
            alert ("Por favor ingrese solo letras")
        }
        if(cLetras.test(apellidos)){
            r++;
        }else{
            alert ("Por favor ingrese solo letras")
        }
        if(edad.length<3){
            if(cEdad.test(edad)){
            r++;
            }else{
                alert("Ingrese solo numeros")
            }
        }else{
            alert("Ha ingresado demasiado valores")
        }
        if(cCorreo.test(correo)){
            r++;
        }else{
            alert("Direccion de correo electronico invalida")
        }
    }
    if(r==5){
        exito(nombres,apellidos,edad,rut,correo,hora,fecha,especialidad,);
    }
}

function exito(nombres,apellidos,edad,rut,correo,hora,fecha,especialidad){
    document.getElementById("reservaExitosa").style.display = "block";
    document.getElementById("reservaExitosa").innerHTML=(`Estimado(a) ${nombres} ${apellidos}, su hora para ${especialidad} ha sido reservada para el
    día ${fecha} a las ${hora}. Además, se le envió un mensaje a su correo ${correo} con el detalle de su cita.
    Gracias por preferirnos.
    `);
}