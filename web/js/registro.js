
var error = document.getElementById("error");

function validarSexo() {
    var sexo = document.getElementById("sexo");
    if (sexo.value.toLowerCase() === "femenino" || sexo.value.toLowerCase() === "masculino"  || sexo.value === "") {
        error.innerHTML = "";
    } else {
        error.innerHTML = "El sexo debe ser Femenino o Masculino";
    }
}