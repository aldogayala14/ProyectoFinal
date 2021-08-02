'Use Strict'


function comprobarClave(){
const password = document.getElemenById("password_empleado");
const password2 = document.getElemenById("password2_empleado");

if(password != password2){
    alert("Las contraseñas no son iguales");
}

}
