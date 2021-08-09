'use strict';

function isEmptyCargaEmpleado(){

    const nombre_empleado = document.getElementById('nombre_empleado');
    const apellido_empleado = document.getElementById('apellido_empleado');
    const dni_empleado = document.getElementById('dni_empleado');
    const direccion_empleado = document.getElementById('direccion_empleado');
    const fecha_nacimientoEmpl = document.getElementById('fechaNac_empleado');
    const cargo_empleado = document.getElementById('cargo_empleado');
    const usuario_empleado = document.getElementById('usuario_empleado');
    const password_empleado = document.getElementById('pass1');

    if(nombre_empleado.value == ""){
        alert("Campo nombre empleado vacio");
        return;
    }else if(apellido_empleado.value == ""){
        alert("Campo apellido empleado vacio");
        return;
    }else if(dni_empleado.value == ""){
        alert("Campo dni empleado vacio");
        return;
    }else if(direccion_empleado.value == ""){
        alert("Campo direccion empleado vacio");
        return;
    }else if(fecha_nacimientoEmpl.value == ""){
        alert("Campo fecha nacimiento empleado vacio");
        return;
    }else if(cargo_empleado.value == ""){
        alert("Campo cargo empleado vacio");
        return;
    }else if(usuario_empleado.value == ""){
        alert("Campo usuario empleado vacio");
        return;
    }else if(password_empleado.value == ""){
        alert("Campo contrase\xF1a empleado vacio");
        return;
    }


    
}


function isEmptyCargaHuesped(){

    const nombre_huesped = document.getElementById('nombre_huesped');
    const apellido_huesped = document.getElementById('apellido_huesped');
    const dni_huesped = document.getElementById('dni_huesped');
    const direccion_huesped = document.getElementById('direccion_huesped');
    const fecha_nacimientoHues = document.getElementById('fechaNac_huesped');
    const profesion_huesped = document.getElementById('profesion_huesped');

     if(nombre_huesped.value == ""){
        alert("Campo nombre huesped vacio");
        return;
    }else if(apellido_huesped.value == ""){
        alert("Campo apellido huesped vacio");
        return;
    }else if(dni_huesped.value == ""){
        alert("Campo dni huesped vacio");
        return;
    }else if(direccion_huesped.value == ""){
        alert("Campo direccion huesped vacio");
        return;
    }else if(fecha_nacimientoHues.value == ""){
        alert("Campo fecha nacimiento huesped vacio");
        return;
    }else if(profesion_huesped.value == ""){
        alert("Campo prefesion huesped vacio");
        return;
    }

}

function isEmptyCargaHabitacion()
{

    const numeroHabitacion = document.getElementById('numero_habitacion');
    const numeroPiso = document.getElementById('numero_piso');
    const tipoTematica = document.getElementById('tipo_tematica');
    const precioNoche = document.getElementById('precio_noche');
    const tipoHabitacion = document.getElementById('tipo_habitacion');

    if(numeroHabitacion.value ==""){
        alert("Campo numero habitacion vacio");
        return;
    }else if(numeroPiso.value ==""){
        alert("Campo numero de piso vacio");
        return;
    }else if(tipoTematica.value == ""){
        alert("Campo tipo tematica vacio");
        return;
    }else if(precioNoche.value == ""){
        alert("Campo precio noche vacio");
        return;
    }



}

    function isEmptyCargaReserva(){

        const fechaIngreso = document.getElementById('fecha_ingreso');
        const fechaEgreso = document.getElementById('fecha_egreso');
        const cantidaPersonas = parseInt(document.getElementById('cantidad_personas'));        
        const observaciones = document.getElementById('observaciones_reserva');
        const tipoHabitacion = document.getElementById('tipo_habitacion');

       
         console.log("La cantidad de personas es: " + cantidaPersonas.value);
         console.log("La fecha de ingreso es: " + fechaIngreso.value);

        if(fechaIngreso.value ==""){
            alert("Completar campo check-in");
            return;
        }else if(fechaEgreso.value == ""){
            alert("Completar campo check-out")
            return;
        }else if(cantidaPersonas.value == ""){
            alert("Ingresar cantidad de personas");
            return;
        }else if(observaciones.value == ""){
            observaciones.value = "Sin observaciones";
            return;
        }if(cantidaPersonas > 1){
             alert("Error");
            return;
        }

        

 }


       


    function cantidad(obj){
        const tipoHabitacion = document.getElementById('tipo_habitacion');
       if(obj.value > 1 && tipoHabitacion.value == "single"){
        alert("La cantidad de personas supera la capacidad de la habitacion");
        obj.value = "";
        return;
       }else if(obj.value > 2 && tipoHabitacion.value == "doble" ){
        alert("La cantidad de personas supera la capacidad de la habitacion");
        obj.value ="";
        return;
       }else if(obj.value > 3 && tipoHabitacion.value == "triple" ){
        alert("La cantidad de personas supera la capacidad de la habitacion");
        obj.value ="";
        return;
       }

    }

     function ingresoEgreso(obj){
         const fecha_ingreso = document.getElementById('fecha_ingreso');
        

        var fechaIngreso = new Date(fecha_ingreso.value);
        var fechaEgreso = new Date(obj.value);

        if(fechaEgreso < fechaIngreso){
            alert("Fecha CheckOut no puede ser menor al CheckIn");
            obj.value ="";
            return;
        }

     }



function doSearch()

        {

            const tableReg = document.getElementById('datos');
            const searchText = document.getElementById('searchTerm').value.toLowerCase();
            let total = 0;

            

            for (let i = 1; i < tableReg.rows.length; i++) {

                if (tableReg.rows[i].classList.contains("noSearch")) {

                    continue;

                }

                let found = false;
                const cellsOfRow = tableReg.rows[i].getElementsByTagName('td');

             
                for (let j = 0; j < cellsOfRow.length && !found; j++) {

                    const compareWith = cellsOfRow[j].innerHTML.toLowerCase();                 

                    if (searchText.length == 0 || compareWith.indexOf(searchText) > -1) {

                        found = true;

                        total++;

                    }

                }

                if (found) {

                    tableReg.rows[i].style.display = '';

                } else {                    

                    tableReg.rows[i].style.display = 'none';

                }

            }

 
          
            const lastTR=tableReg.rows[tableReg.rows.length-1];

            const td=lastTR.querySelector("td");

            lastTR.classList.remove("hide", "red");

            if (searchText == "") {

                lastTR.classList.add("hide");

            } 

        }

     
