'use strict';

function save(){

   alert("Guardando informacion");
}

function compReserva()
{
   let bandera = document.getElementById('id_bandera_reserva').value;

    if(bandera === 'false'){
        alert('No se puede reservar en la fecha seleccionada');
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

     
