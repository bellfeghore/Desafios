var comprobar = /^[A-Z]+$/i;
var arregloOscuro = [];
var datosPokemon;



arregloOscuro.push("#6D6D4E");  //0
arregloOscuro.push("#7D1F1A");  //1
arregloOscuro.push("#6D5E9C");  //2
arregloOscuro.push("#682A68");  //3
arregloOscuro.push("#927D44");  //4
arregloOscuro.push("#786824");  //5
arregloOscuro.push("#6D7815");  //6
arregloOscuro.push("#493963");  //7
arregloOscuro.push("#787887");  //8
arregloOscuro.push("#9C531F");  //9
arregloOscuro.push("#445E9C");  //10
arregloOscuro.push("#4E8234");  //11
arregloOscuro.push("#A1871F");  //12
arregloOscuro.push("#A13959");  //13
arregloOscuro.push("#638D8D");  //14
arregloOscuro.push("#4924A1");  //15
arregloOscuro.push("#49392F");  //16
arregloOscuro.push("#9B6470");  //17
var arregloClaro = [];
arregloClaro.push("#C6C6A7");  //0
arregloClaro.push("#D67873");  //1
arregloClaro.push("#C6B7F5");  //2
arregloClaro.push("#C183C1");  //3
arregloClaro.push("#EBD69D");  //4
arregloClaro.push("#D1C17D");  //5
arregloClaro.push("#C6D16E");  //6
arregloClaro.push("#A292BC");  //7
arregloClaro.push("#D1D1E0");  //8
arregloClaro.push("#F5AC78");  //9
arregloClaro.push("#9DB7F5");  //10
arregloClaro.push("#A7DB8D");  //11
arregloClaro.push("#FAE078");  //12
arregloClaro.push("#FA92B2");  //13
arregloClaro.push("#BCE6E6");  //14
arregloClaro.push("#A27DFA");  //15
arregloClaro.push("#A29288");  //16
arregloClaro.push("#F4BDC9");  //17






function busquedaTipo() {
    $("#pantalla2").html(`
    <table id="tablaTipos">
        <tr>
            <button class="tipo" id="0" onclick="busquedaPokemonTipo(1)" style="background-color: #6D6D4E; value='1'">NORMAL</button>
            <button class="tipo" id="1" onclick="busquedaPokemonTipo(2)" style="background-color: #7D1F1A; value='2'">LUCHA</button>
            <button class="tipo" id="2" onclick="busquedaPokemonTipo(3)" style="background-color: #6D5E9C; value='3'">VOLADOR</button>
        </tr>
        <tr>
            <button class="tipo" id="3" onclick="busquedaPokemonTipo(4)" style="background-color: #682A68; value='4'">VENENO</button>
            <button class="tipo" id="4" onclick="busquedaPokemonTipo(5)" style="background-color: #927D44; value='5'">TIERRA</button>
            <button class="tipo" id="5" onclick="busquedaPokemonTipo(6)" style="background-color: #786824; value='6'">ROCA</button>
        </tr>
        <tr>
            <button class="tipo" id="6" onclick="busquedaPokemonTipo(7)" style="background-color: #6D7815; value='7'">BICHO</button>
            <button class="tipo" id="7" onclick="busquedaPokemonTipo(8)" style="background-color: #493963; value='8'">FANTASMA</button>
            <button class="tipo" id="8" onclick="busquedaPokemonTipo(9)" style="background-color: #787887; value='9'">ACERO</button>
        </tr>
        <tr>
            <button class="tipo" id="9" onclick="busquedaPokemonTipo(10)" style="background-color: #9C531F; value='10'">FUEGO</button>
            <button class="tipo" id="10" onclick="busquedaPokemonTipo(11)" style="background-color: #445E9C; value='11'">AGUA</button>
            <button class="tipo" id="11" onclick="busquedaPokemonTipo(12)" style="background-color: #4E8234; value='12'">PLANTA</button>
        </tr>
        <tr>
            <button class="tipo" id="12" onclick="busquedaPokemonTipo(13)" style="background-color: #A1871F; value='13'">ELECTRICO</button>
            <button class="tipo" id="13" onclick="busquedaPokemonTipo(14)" style="background-color: #A13959; value='14'">PSIQUICO</button>
            <button class="tipo" id="14" onclick="busquedaPokemonTipo(15)" style="background-color: #638D8D; value='15'">HIELO</button>
        </tr>
        <tr>
            <button class="tipo" id="15" onclick="busquedaPokemonTipo(16)" style="background-color: #4924A1; value='16'">DRAGON</button>
            <button class="tipo" id="16" onclick="busquedaPokemonTipo(17)" style="background-color: #49392F; value='17'">SINIESTRO</button>
            <button class="tipo" id="17" onclick="busquedaPokemonTipo(18)" style="background-color: #9B6470; value='18'">HADA</button>
        </tr>
    </table>`)
}

document.getElementById("tipos").addEventListener("click", busquedaTipo);
document.getElementById("nombre").addEventListener("click", busquedaNombre);
document.getElementById("numero").addEventListener("click", busquedaNumero);
document.getElementById("tipos").addEventListener("click", visible);
document.getElementById("nombre").addEventListener("click", visible);
document.getElementById("numero").addEventListener("click", visible);

function visible(){
    $(".contenido").css("visibility","visible")
   
}

function busquedaNombre() {
    $("#pantalla2").html(`<p><input type="text" id="nme" name="nme" maxlength="10" size="10"></p>
        <p> <button id="buscarNom" >BUSCAR</button></p>`)
    document.querySelector('#buscarNom').addEventListener('click', busquedaPokemonNombre);
}
function busquedaPokemonNombre() {
    var valor = $("#nme").val();
    if (comprobar.test(valor) == true) {
        pokemonDatos(valor);
    } else {
        alert("el pokemon que busca no se encuentra")
    }
}
function busquedaNumero() {
    $("#pantalla2").html(`
        <p><input type="number" id="nro" name="nro" min="1" max="807" placeholder="0-807"></p>
        <p> <button id="buscarNum" >BUSCAR</button></p>`)
    document.querySelector('#buscarNum').addEventListener("click", busquedaPokemonID);
}
function busquedaPokemonID() {
    var valor = $("#nro").val();
    if (valor < 808 && valor > 0) {
        pokemonDatos(valor)
    } else {
        alert("Ingrese un numero valido")
    }
}
function pruebas(datos) {
    var nombre = datos.name;
    var id = datos.id;
    var valorStats = []
    for (let index = 0; index < 6; index++) {
        var a = datos.stats[index]

        valorStats.push(a.base_stat)
    }
    sprite(id, nombre);
    rellenarGrafico(nombre, valorStats);
}
function pokemonDatos(valor) {
    var link = 'https://pokeapi.co/api/v2/pokemon/' + valor + '/';
    let url = link
    fetch(url).then(response => response.json()).then(function (pokeData) {
        pruebas(pokeData)
    })

}
function sprite(sp, nombre) {
    let url = `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${sp}.png`;
    $("#datos").html(`<div id="datos">
                    <table id="listaTipos">
                    </table>
                    </div>`);
    $("#imagen").html(`<img class="pokemonInfo" src="${url}" alt="${sp}" width="140px" height="auto">#${sp} ${nombre}`);
    $("#imagenEntrada").css("display", "none")
}
function colorClaro(indice) {
    for (let i = 0; i < arregloOscuro.length; i++) {
        if (indice == i) {
            $("#" + indice).css("background-color", arregloClaro[indice]);
            var tipo
        } else {
            $("#" + i).css("background-color", arregloOscuro[i])
        }
    }
}
function busquedaPokemonTipo(tipo) {
    colorClaro(tipo - 1);
    var link = "https://pokeapi.co/api/v2/type/" + tipo + "/";
    let url = link;
    fetch(url).then(response => response.json()).then(function (datos) { listaTipos(datos) })
}

function listaTipos(datos) {
    var listaCompleta = [];
    var listaPM = [];
    var listaID = [];
    for (let i = 0; i < datos.pokemon.length; i++) {
        listaCompleta.push(datos.pokemon[i].pokemon);
    }
    for (let i = 0; i < listaCompleta.length; i++) {
        listaPM.push(listaCompleta[i].name)
        listaID.push(listaCompleta[i].url)
    }
    listaCompleta = [];
    for (let i = 0; i < listaID.length; i++) {
        var x = listaID[i];
        x = x.slice(34, x.length - 1)
        listaCompleta.push(x + "  " + listaPM[i])
    }
    var tabla;
    tabla = "`"
    for (let i = 0; i < listaCompleta.length; i++) {
        tabla = tabla + `<tr><td>${listaCompleta[i]}</td></tr>`;
    }
    tabla = tabla + "`";
    $("#imagen").html(``);
    $("#grafico").html(`<canvas id="graficoEstadisticas"></canvas>`);
    $("#listaTipos").html(tabla);
    $("#imagenEntrada").css("display", "none");
    $("#listaTipos").css({ "overflow-y": "scroll", "heigth": "340px", "width": "280px", "margin": "10px" })
}
function rellenarGrafico(nombre, valor) {

    var ctx = document.getElementById('graficoEstadisticas').getContext('2d');
    var nombrePokemon = "'" + nombre + "'"
    var chart = new Chart(ctx, {
        type: 'radar',
        data: {
            labels: ['hp', 'attack', 'defense', 'special-attack', 'special-defense', 'speed'],
            datasets: [{
                label: nombrePokemon,
                data: valor
            }]
        },
        options: {
            scale: {
                ticks: {
                    beginAtZero: true
                }
            }
        }
    });
}