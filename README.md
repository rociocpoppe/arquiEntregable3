Trabajo de Arquitecturas Web 
Entregable 5


Curls de testeo en Postman

---

curl --location --request POST 'https://arquientregable5.herokuapp.com/estudiantes/' \
--header 'Content-Type: application/json' \
--data-raw '  {
        "nroDni": 6,
        "nombre": "Matias",
        "apellido": "Perez",
        "ciudadResidencia": "rauch",
        "edad": 25,
        "genero": "m",
        "nroLibretaUniv": 425,
        "carreras":[]
  } '

---

curl --location --request POST 'https://arquientregable5.herokuapp.com/estudiantesCarreras/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "idCarrera":4,
    "idEstudiante":5
}'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantes/ordenadoPorNombre/nombre'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantes/ordenadoPorApellido/apellido'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantes/ordenadoPorEdad/edad'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantes/lu/333'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantes/genero/f'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/carreras/byInscriptos'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantes/ciudadCarrera/tudai/tandil'

---

curl --location --request GET 'https://arquientregable5.herokuapp.com/estudiantesCarreras/reporte'

---

Se adjuntan las capturas de los testeos en Postman en la carpeta de documentación. 