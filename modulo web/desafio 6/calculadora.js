function agregarValor(x){
document.getElementById('resultado').value += x;
  if (document.getElementById('resultado').value.substr(-2)=="++"||document.getElementById('resultado').value.substr(-2)=="--"||document.getElementById('resultado').value.substr(-2)=="**"||document.getElementById('resultado').value.substr(-1)=="//"||document.getElementById('resultado').value.substr(-1)=="==") {
    alert(`no puede ingresar ${x} dos veces seguidas `)
    return document.getElementById('resultado').value = "";
  }
  else {
  }
}
function limpiarPantalla(){
  document.getElementById('resultado').value = "";
}
function calcular(){
  var result = eval(document.getElementById('resultado').value);
  document.getElementById('resultado').value = result;
}
